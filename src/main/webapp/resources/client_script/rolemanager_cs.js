var tpfor = [ 'Active', 'Draft', 'Deactive' ];

$(function() {
	var config = {
		gdroles : {
			name : 'gdroles',
			url : "select",
			postData : {reqtype : 'gdroles',data : null},
			method : 'POST',
			show : {
					toolbar : true,
					selectColumn : true
			},
			toolbar : {
				items : [ 
				     {type : 'break'}, 
				     {type : 'button',id : 'btnAdd',caption : 'Add',img : 'icon-plus-sign'}, 
				     {type : 'button',id : 'btnDel',caption : 'Delete',img : 'icon-minus-sign'} 
				     ],
				onClick : function(target, data) {
					if (target == 'btnAdd') {
						fnEventHandler('insert', null);
						w2ui['gdroles'].reload();
						
					} else if (target == 'btnDel') {
								var grid = w2ui['gdroles'];
								var recid = grid.getSelection();
								fnEventHandler('delete', JSON.stringify({recid : recid}));
								w2ui['gdroles'].reload();
					}
				}
			},
			columns : [ 
			            {field : 'roleid',caption : 'Role Code',	size : 33,editable : {type : 'text'}}, 
			            {field : 'role',caption : 'Role Name',size : 33,editable : {type : 'text'}}, 
			            {field : 'is_active',caption : 'Role Status',size : 34,editable : {type : 'list',items : tpfor}} 
			          ],
			onChange : function(event) {
				var gridcol = w2ui['gdroles'].columns[event.column];
				var fieldToUpdate = fnUpdateField(gridcol,event,'roles');
				fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
			}

		},

		layout1 : {
			name : 'layout1',
			panels : [ {
				type : 'top',
				size : 320,
				resizable : true,
				title : "Role Manager"
			}, {
				type : 'main',
				size : 200,
				resizable : true
			}, ]
		},

	};

	$('#main').w2layout(config.layout1);
	w2ui.layout1.content('top', $().w2grid(config.gdroles));

});
