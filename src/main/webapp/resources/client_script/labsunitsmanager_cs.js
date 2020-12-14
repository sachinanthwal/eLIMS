var stat = [ 'Active', 'Deactive' ];
var units = [ 'Unit 1', 'Unit 2', 'Unit 3', 'Unit 4', 'Unit 5' ];
var users = [ 'prem@gmail.com', 'awadhesh@gmail.com' ];
var myform = $('#frmLabsList').html();

var config = {
	gdlabs : {
		name : 'gdlabs',
		url : "getLabs",
		postData : {
			status : ''
		},
		show : {
			toolbar : true,
			toolbarAdd : true,
			toolbarDelete : true,
			selectColumn : true
		},
		columns : [ {
			field : 'labid',
			caption : 'Lab Code',
			size : 20,
			editable : {
				type : 'text'
			}
		}, {
			field : 'labname',
			caption : 'Lab Name',
			size : 40,
			editable : {
				type : 'text'
			}
		}, {
			field : 'labnoprefix',
			caption : 'Lab Prefix',
			size : 40,
			editable : {
				type : 'text'
			}
		}, ],
		onAdd : function(event) {
			fnEventHandler('addLab', '');
			w2ui['gdlabs'].reload();
		},
		onChange : function(event) {
			var gridcol = w2ui['gdlabs'].columns[event.column];
			var fieldToUpdate = fnUpdateField(gridcol, event,'labs');
			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
		},
		onClick : function(event) {
			var grid = this;
			event.onComplete = function() {
				var sel = grid.getSelection();
				if (sel.length == 1) {
					_labid = grid.get(sel[0])['labid'];
					w2ui['gdunits'].postData['labid'] = _labid;
					w2ui.gdunits.load('getLabUnits');

				}
			}
		}
	},
	layout1 : {
		name : 'layout1',
		panels : [ {
			type : 'top',
			size : 320,
			resizable : true,
			title : "Lab/Unit Manager"
		}, {
			type : 'main',
			resizable : true
		}, ]
	},
	layout2 : {
		name : 'layout2',
		panels : [ {
			type : 'left',
			size : 530,
			resizable : true
		}, {
			type : 'main',
			resizable : true
		}, ]
	},
	gdunits : {
		name : 'gdunits',
		url : "getLabUnits",
		postData : {
			labid : 'LAB1'
		},
		show : {
			toolbar : true,
			toolbarAdd : true,
			selectColumn : true
		},
		columns : [ 
		            {field : 'unitcode',caption : 'Unit Code',size : 15}, 
		            {field : 'unitname',caption : 'Unit Name',size : 25}, 
		            {field : 'autoapproval',caption : 'Auto Approval',size : 15,editable: { type: 'checkbox', style: 'text-align: center' }  }
           
		],
		onAdd : function(event) {
			pLabUnit();
			w2ui['gdunits'].reload();
		},
		onClick : function(event) {
			var grid = this;
			event.onComplete = function() {
				var sel = grid.getSelection();
				if (sel.length == 1) {
					_labid = grid.get(sel[0])['labid'];
					_unitcode = grid.get(sel[0])['unitcode'];
					w2ui.gdUnitusers.postData['labid'] = _labid;
					w2ui.gdUnitusers.postData['unitcode'] = _unitcode;
					w2ui.gdUnitusers.load('getLabUnitUsers');
				}
			};
		},
		onChange : function(event) {
			var gridcol = w2ui['gdunits'].columns[event.column];
			var fieldToUpdate = fnUpdateField(gridcol, event,'labunits');
			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
		},
	},
	gdUnitusers : {
		name : 'gdUnitusers',
		url :  'getLabUnitUsers',
		postData : {
		labid : 'LAB1',
		unitcode : 'UNIT 1'
		},
		method : 'POST',
		show : {
			toolbar : true,
			toolbarAdd : true
		},
		columns : [ 
		            {field : 'labid',caption : 'Lab Id',size : 15}, 
		            {field : 'unitcode',caption : 'Unit Code',size : 15}, 
		            {field : 'username',caption : 'User Id',size : 35},
		            {field : 'fullname',caption : 'Full Name',size : 35}
		          ],
		onAdd : function(event) {
			pLabUnitUsers();
			w2ui['gdUnitusers'].reload();
		}
	}
};

$(function() {
	$('#main').w2layout(config.layout1);
	w2ui.layout1.content('top', $().w2grid(config.gdlabs));
	w2ui.layout1.content('main', $().w2layout(config.layout2));
	w2ui.layout2.content('left', $().w2grid(config.gdunits));
	w2ui.layout2.content('main', $().w2grid(config.gdUnitusers));
	// $().w2grid(config.gdUnitusers);
});


function pLabUnit() {
	var gridA = w2ui.gdlabs;
	var sel = gridA.getSelection();
	var labid = gridA.get(sel[0])['labid'];

	$().w2grid({
		name : 'gdAvailableItem',
		url : 'getAvailableItem',
		postData: {labid: labid},
		method : 'POST',
		columns : [ {field : 'lvalue',caption : 'Available',size : '49%',sortable : true} ],
		onDblClick: function(event) {
			var grid = this;
			// need timer for nicer visual effect that record was selected
			setTimeout(function() {
				w2ui['gdSelectedItem'].add($.extend({}, grid.get(event.recid), {selected : false}));
				grid.selectNone();
				grid.remove(event.recid);
			}, 150);
		}
	});
	
	$().w2grid({
		name : 'gdSelectedItem',
		url : 'getSelectedItem',
		postData: {labid: labid},
		method : 'POST',
		columns : [ {field : 'lvalue',caption : 'Selected',	size : '49%',sortable : true} ],
		onDblClick: function(event) {
			var grid = this;
			// need timer for nicer visual effect that record was selected
			setTimeout(function() {
				w2ui['gdAvailableItem'].add($.extend({}, grid.get(event.recid), {selected : false}));
				grid.selectNone();
				grid.remove(event.recid);
			}, 150);
		}
	});
	
	w2popup
			.open({
				title : 'Lab Units',
				body  : '<div id="grid1" style="position: absolute; left: 0px; width: 49.9%; height: 200px;"></div><div id="grid2" style="position: absolute; right: 0px; width: 49.9%; height: 200px;"></div>',
				buttons : '<button class="w2ui-btn" onclick="w2popup.close();">Close</button> '
						+ '<button class="w2ui-btn" onclick="sendSelectedItems();">OK</button>',
				width : 500,
				height : 300,
				overflow : 'hidden',
				color : '#333',
				speed : '0.3',
				opacity : '0.8',
				modal : true,
				showClose : true,
			
				onClose : function (event) {
					w2ui["gdAvailableItem"].destroy();
					w2ui["gdSelectedItem"].destroy();
				 }   
			});
	
	$('#grid1').w2render('gdAvailableItem');
	$('#grid2').w2render('gdSelectedItem');
}

function sendSelectedItems() {
	var gridA = w2ui.gdlabs;
	var sel = gridA.getSelection();
	var labid = gridA.get(sel[0])['labid'];	
	var data = JSON.stringify({records : w2ui['gdSelectedItem'].records, labid : labid });
	fnEventHandler('editLabUnitList', data);
	w2ui["gdunits"].reload();
	w2popup.close();
}


function pLabUnitUsers() {
	var gridA = w2ui.gdunits;
	var sel = gridA.getSelection();
	var labid = gridA.get(sel[0])['labid'];
	var unitcode = gridA.get(sel[0])['unitcode'];
	
	$().w2grid({
		name : 'gdAvailableItem',
		url : 'getAvailableUsers',
		postData: {labid: labid, unitcode: unitcode},
		method : 'POST',
		columns : [ {field : 'username',caption : 'Available',size : '49%',sortable : true} ],
		onDblClick: function(event) {
			var grid = this;
			// need timer for nicer visual effect that record was selected
			setTimeout(function() {
				w2ui['gdSelectedItem'].add($.extend({}, grid.get(event.recid), {selected : false}));
				grid.selectNone();
				grid.remove(event.recid);
			}, 150);
		}
	});
	
	$().w2grid({
		name : 'gdSelectedItem',
		url : 'getSelectedUsers',
		postData: {labid: labid,unitcode: unitcode},
		method : 'POST',
		columns : [ {field : 'username',caption : 'Selected',	size : '49%',sortable : true} ],
		onDblClick: function(event) {
			var grid = this;
			// need timer for nicer visual effect that record was selected
			setTimeout(function() {
				w2ui['gdAvailableItem'].add($.extend({}, grid.get(event.recid), {selected : false}));
				grid.selectNone();
				grid.remove(event.recid);
			}, 150);
		}
	});
	
	w2popup
			.open({
				title : 'Lab Unit Users',
				body  : '<div id="grid1" style="position: absolute; left: 0px; width: 49.9%; height: 200px;"></div><div id="grid2" style="position: absolute; right: 0px; width: 49.9%; height: 200px;"></div>',
				buttons : '<button class="w2ui-btn" onclick="w2popup.close();">Close</button> '
						+ '<button class="w2ui-btn" onclick="sendSelectedUsers();">OK</button>',
				width : 500,
				height : 300,
				overflow : 'hidden',
				color : '#333',
				speed : '0.3',
				opacity : '0.8',
				modal : true,
				showClose : true,
			
				onClose : function (event) {
					w2ui["gdAvailableItem"].destroy();
					w2ui["gdSelectedItem"].destroy();
				 }   
			});
	
	$('#grid1').w2render('gdAvailableItem');
	$('#grid2').w2render('gdSelectedItem');
}

function sendSelectedUsers() {
	var gridA = w2ui.gdunits;
	var sel = gridA.getSelection();
	var labid = gridA.get(sel[0])['labid'];	
	var unitcode = gridA.get(sel[0])['unitcode'];	
	var data = JSON.stringify({records : w2ui['gdSelectedItem'].records, labid : labid, unitcode: unitcode });
	fnEventHandler('editLabUnitUserList', data);
	w2ui["gdUnitusers"].reload();
	w2popup.close();
}
