$(function() {
	$('#dgStatusList').w2grid({
		name : 'gvStatusType',
		url : 'server_script/projectmanager_sc.php',
		method : 'POST',
		postData : {
			reqtype : 'getStatusList',
			data : 'Draft'
		},
		columns : [ {
			field : 'lvalue',
			caption : 'Status Id',
			size : '40%'
		}, {
			field : 'ltext',
			caption : 'Status Name',
			size : '60%'
		} ],
		onClick : function(event) {
			var grid = this;
			event.onComplete = function() {
				var sel = grid.getSelection();
				var row = grid.get(sel[0]);
				var form = w2ui.frmProjectDetails;
				form.record['status'] = row.lvalue;
				form.refresh();
				w2popup.close();
			}
		}

	});
});


$(function() {
	var myform = $('#frmGeneralInfo').html();
	var frmImage = $('#frmImage').html();
	var config = {
			formx: {
			    name: 'formx',
			    style: 'border: 0px; background-color: transparent;',
			    formHTML: frmImage
			   }

			,
		layout1 : {
			name : 'layout1',
			padding : 4,
			panels : [ {
				type : 'top',
				resizable : false,
				size : 30,
				title : "USERS MANAGER"
			}, {
				type : 'left',
				size : '35%',
				resizable : true,
				minSize : 50
			}, {
				type : 'main',
				size : 800,
				minSize : 300
			} ]
		},
		layout2 : {
			name : 'layout2',
			panels : [ {
				type : 'top',
				size : 320,
				tabs : {
					active : 'tpGeneral',
					tabs : [ {
						id : 'tpGeneral',
						caption : 'General'
					}, {
						id : 'tpSecurity',
						caption : 'Security'
					}, {
						id : 'tpHistory',
						caption : 'History'
					}, ],
					onClick : function(event) {
						if (event.target == 'tpGeneral') {
							this.owner.content('top', w2ui.frmUserDetails);
						}
						if (event.target == 'tpSecurity') {
							this.owner.content('top', event.target);
						}
						if (event.target == 'tpHistory') {
							this.owner.content('top', event.target);
						}
					}
				}
			}, {
				type : 'main',
				size : 200,
				resizable : true
			}, ]
		},
		gduserlist : {
			name : 'gduserlist',
			url : 'getUsers',
			postData : {
				status : 'Draft'
			},
			show : {
				toolbar : true,
				toolbarInput : false,
				toolbarReload : false,
				toolbarColumns : false
			},
			toolbar : {
				items : [ 
				    {type : 'break'}, 
					{type : 'button',id : 'btnAdd',caption : 'Add',img : 'icon-plus-sign'}, 
					{type : 'button',id : 'btnSave',caption : 'Save',img : 'icon-save'} 
					],
				onClick : function(target, data) {
					if (target == 'btnAdd') {
						PromptAddUser();

					} else if (target == 'btnSave') {
						var form = w2ui.frmUserDetails;
						fnEventHandler('btnSaveForm', JSON.stringify({formdata: form.record}));
						w2ui['gduserlist'].reload();
					}
				}
			},
			columns : [ {
				field : 'username',
				caption : 'Login Id',
				size : '30%',
				sortable : true,
				searchable : true
			}, {
				field : 'fullname',
				caption : 'User Name',
				size : '70%',
				sortable : true,
				searchable : true
			}, ],
			onClick : function(event) {
				var grid = this;
				var form = w2ui.frmUserDetails;
				//console.log(event);
				event.onComplete = function() {
					var sel = grid.getSelection();
					// console.log(sel);
					if (sel.length == 1) {
						// form.recid = sel[0];
						_username = grid.get(sel[0])['username'];
						form.record = $.extend(true, {}, grid.get(sel[0]));
						form.refresh();
						// w2ui.gdAssignedSamples.postData['reqtype'] =
						// 'getAssignedSamples';
						// w2ui.gdAssignedSamples.postData['data'] =
						// $('#batchid').val();
						// w2ui['gdAssignedSamples'].load('server_script/projectmanager_sc.php');
					} else {
						form.clear();
					}
				}
			}
		},

		form : {
			name : 'frmUserDetails',
			formHTML : myform,
			fields : [ 
			          {name : 'status',type : 'list',options: {silent : true,items: ['Active','Hold','Retired','Draft']}}, 
			          {name : 'job_title',type : 'list',options:{items: ['Administrator','Analyst','Lab Manager']}}, 
			          {name : 'gender',type : 'list',required : true,options: { items: ['Male','Female'] }}, 
			          {name : 'dob',type : 'date',required : true,options: {format: 'dd-mm-yyyy'}}, 
			          {name : 'email',type : 'text',required : true}, 
			          {name : 'im',	type : 'text',required : true}, 
			          {name : 'address',type : 'text',required : true}
			         ],
			actions : {
				reset : function() {
					this.clear();
				},
				btnProjectType : function() {
					var vBatchType = $('#divProjectType').html();
					w2popup.open({
						title : 'List of available Project Types',
						body : vBatchType,
						buttons : 'buttons',
						showMax : true
					});
				},
				btnStatusId : function() {
					var vStatusList = $('#divStatusList').html();
					w2popup.open({
						title : 'List of Status(s)',
						body : vStatusList,
						buttons : 'buttons',
						showMax : true
					});
				},
			}
		}
	};

	$('#main').w2layout(config.layout1);
	w2ui.layout1.content('left', $().w2grid(config.gduserlist));
	w2ui.layout1.content('main', $().w2layout(config.layout2));
	w2ui.layout2.content('top', $().w2form(config.form));
	w2ui.layout2.content('main', $().w2form(config.formx));
	$().w2form(config.form);
	// $().w2grid(config.testgrid);

});

function pSampleSelection() {
	w2popup
			.open({
				title : 'Sample Lists',
				body : '<div id="testselection" style="width: 100%; height: 200px;"></div>',
				buttons : '<button class="w2ui-btn" onclick="w2popup.close();">Close</button> '
						+ '<button class="w2ui-btn" onclick="sendSelectedSamples();">OK</button>',
				width : 500,
				height : 300,
				overflow : 'hidden',
				color : '#333',
				speed : '0.3',
				opacity : '0.8',
				modal : true,
				showClose : true,
				showMax : true,
				onOpen : function(event) {

				},
				onClose : function(event) {
					console.log('close');
				},
				onMax : function(event) {
					console.log('max');
				},
				onMin : function(event) {
					console.log('min');
				},
				onKeydown : function(event) {
					console.log('keydown');
				}
			});
	$('#testselection').w2render('gdSamplesList');
}

function sendSelectedSamples() {
	var data = JSON.stringify({
		batchid : $('#batchid').val(),
		recid : w2ui.gdSamplesList.getSelection()
	});
	fnEventHandler('AddSelectedSamples', data);
	w2popup.close();
	w2ui.gdAssignedSamples.postData['reqtype'] = 'getAssignedSamples';
	w2ui.gdAssignedSamples.postData['data'] = $('#batchid').val();
	w2ui['gdAssignedSamples'].load('server_script/projectmanager_sc.php');
}

$(function() {
	$().w2grid({
		name : 'gdSamplesList',
		url : 'server_script/projectmanager_sc.php',
		postData : {
			reqtype : 'getSampleslist',
			data : 'null'
		},
		method : 'POST',
		show : {
			toolbar : true,
			selectColumn : true
		},
		columns : [ {
			field : 'sampleid',
			caption : 'Sample Id',
			size : '25%'
		}, {
			field : 'matcode',
			caption : 'Material Code',
			size : '25%'
		}, {
			field : 'projectid',
			caption : 'Project Id',
			size : '25%'
		}, {
			field : 'compid',
			caption : 'Company Name',
			size : '25%'
		} ]

	});
});

$(function() {
	var fields = fnEventHandler('getAttributes', 'samplemanager');
	var fieldArray = [];
	for ( var i in fields) {

		var row = [];
		if (fields[i].type == 'list') {
			var data = fnEventHandler('getLookup', 'Sample Type');
			var items = [];
			for ( var key in data) {
				items.push(data[key].lvalue);
			}
			var options = {
				items : items
			};
			row = {
				name : fields[i].name,
				type : fields[i].type,
				required : fields[i].required == "1",
				options : options
			};
		} else {
			row = {
				name : fields[i].name,
				type : fields[i].type,
				required : fields[i].required == "1"
			};
		}

		if (fields[i].html.length > 0) {
			html = fields[i].html;
			html2 = JSON.parse(html);
			row['html'] = html2;
		}
		fieldArray.push(row);
	}

	$().w2form({
		name : 'frmAttributes',
		fields : fieldArray
	});
});

function PromptAddUser() {
	if (!w2ui.formfields) {
		$().w2form({
			name : 'formfields',
			url: "addnewuser",
			fields : [
			          {name : 'username',type : 'text',required : true,html : {caption : 'User Id'}}, 
			          {name : 'fullname',type : 'text',required : true,html : {caption : 'Full Name'}},
			          {name : 'dob',type : 'date',required : true,options: {format: 'dd-mm-yyyy'},html : {caption : 'Date of Birth'}},
			          {name : 'gender',type : 'list',required : true,options: {items:['Male','Female']},html : {caption : 'Gender'}},
			         ],
			         actions: {
			        	'Save': function () {
			        			this.save();
			        	 },
			             'Clear': function (event) {
			                this.clear();
			             }},
			             onSave: function(event) {
			                 alert(event.xhr.responseText);
			                 this.clear();
			                 w2popup.close();
			             	 w2ui['gduserlist'].reload();
			             }   	             
		});
	}
	$().w2popup('open',
					{
						title : 'Add User',
						body : '<div id="form" style="width: 100%; height: 100%;"></div>',
						style : 'padding: 0px 0px 0px 0px',
						width : 350,
						height : 250,
						showMax : false,
						onOpen : function(event) {
							event.onComplete = function() {
								$('#w2ui-popup #form').w2render('formfields');
							};
						}
					});
}

