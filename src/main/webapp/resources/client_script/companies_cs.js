var eqlist = ['HPLC', 'ELISA', 'GCMS'];
var unitlist = ['Microbiology', 'Chemistry'];
var formhtml = $("#cusinfo").html();
var config = {
    layoutMain: {
        name: 'layoutMain',
        panels: [
            {type: 'top', size: 30, title: 'Company Manager'},
            {type: 'left', size: 600},
            {type: 'main', size: 400, resizable: true,
                tabs: {
                    active: 'tbCompanyDetails',
                    tabs: [
                        {id: 'tbCompanyDetails', caption: 'Customer Details'},
                        {id: 'tbContacts', caption: 'Contacts'},
                        {id: 'tbDocument', caption: 'Documents'}
                    ],
                    onClick: function (event) {
                        var grid = w2ui['gdCompanyList'];
                        var recid = grid.getSelection();
                        var compid = grid.get(recid[0])['compid'];
                        if (event.target == 'tbCompanyDetails') {
                            this.owner.content('main', w2ui['frmCompanyDetails']);
                        }
                        if (event.target == 'tbContacts') {
                            this.owner.content('main', w2ui['gdContacts']);
                            w2ui['gdContacts'].postData['compid'] = compid;
                        }
                        if (event.target == 'tbDocument') {
                            this.owner.content('main', w2ui['gdDocuments']);
                            w2ui['gdDocuments'].postData['compid'] = compid;
                        }
                    }}
            }]},
    frmCompanyDetails: {
        name: 'frmCompanyDetails',
        formHTML: formhtml,
        async: false,
        url: 'saveCompanyDetails',
        fields: [
            {field: 'compid', type: 'text'},
            {field: 'category', type: 'list', required: true, options: {items: ['Manufacturer', 'Supplier', 'Retailer']}},
            {field: 'compname', type: 'text', required: true},
            {field: 'address', type: 'textarea'},
            {field: 'city', type: 'text'},
            {field: 'postcode', type: 'text'},
            {field: 'state', type: 'text'},
            {field: 'phone', type: 'text'},
            {field: 'mobile', type: 'text'},
            {field: 'fax', type: 'text'},
            {field: 'contactname', type: 'text'},
            {field: 'email', type: 'text'},
            {field: 'website', type: 'text'}
        ],
        actions: {
            save: function (event) {
            	this.save();
            }
        },
        onSave: function(event){
            w2ui['gdCompanyList'].reload();
        }

    },
    gdDocuments: {
        name: 'gdDocuments',
        multiSelect: false,
        url: 'getCompanyDocuments',
        postData: {compid: -1},
        show: {
            toolbar: true,
            selectColumn:true
        },
        toolbar: {
            items: [
                {type: 'break'},
                {type: 'button', id: 'btnAdd', caption: 'Add', img: 'icon-plus-sign'},
                {type: 'button', id: 'btnDel', caption: 'Delete', img: 'icon-minus-sign'},
                {type: 'button', id: 'btnView', caption: 'View Document', img: 'icon-download-alt'}
            ],
            onClick: function (target, data) {
                if (target == 'btnAdd') {
                	$('#attFiles').click();
                }
                if (target == 'btnDel') {
                    var grid = w2ui['gdDocuments'];
                    var recid = grid.getSelection();
                    var url = grid.get(recid[0])['url'];                  
                   	fnEventHandler('../files/delete/'+url,JSON.stringify({recid: recid,}));
                   	w2ui['gdDocuments'].reload();
                }
                if (target == 'btnView') {
                    var grid = w2ui['gdDocuments'];
                    var recid = grid.getSelection();
                    var url = grid.get(recid[0])['url'];
                	location.href = '../files/download/'+url;
                 }
            }},
        columns: [
            {field: 'title', caption: 'Document Title',editable:{type:'text'}, size: '50%'},
            {field: 'filename', caption: 'File Name', size: '50%'},
        ],
		onChange : function(event) {
			var gridcol = w2ui['gdDocuments'].columns[event.column];
			var fieldToUpdate = fnUpdateField(gridcol,event,'company_documents');
			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
		}

    },
    gdCompanyList: {
        name: 'gdCompanyList',
        multiSelect: false,
        url: 'getCompanies',
        postData: {status: ''},
        show: {
            toolbar: true,
        },
        toolbar: {
            items: [
                {type: 'break'},
                {type: 'button', id: 'btnAdd', caption: 'Add', img: 'icon-plus-sign'},
                {type: 'button', id: 'btnDel', caption: 'Delete', img: 'icon-minus-sign'}
            ],
            onClick: function (target, data) {
                if (target == 'btnAdd') {
                    w2prompt({
                        label       : 'Company Id',
                        value       : '',
                        attrs       : 'style="width: 200px"',
                        title       : w2utils.lang('Add New Company'),
                        ok_text     : w2utils.lang('Ok'),
                        cancel_text : w2utils.lang('Cancel'),
                        width       : 400,
                        height      : 200
                    })
                    .ok(function (event) {
                    	  fnEventHandler('addNewCompany', JSON.stringify({compid: event}));
                    	  w2ui['gdCompanyList'].reload();
                    });                 
                }
                else if (target == 'btnDel') {
                    var grid = w2ui['gdCompanyList'];
                    var recid = grid.getSelection()[0];
                    fnEventHandler('../generic/deleteRow', JSON.stringify({recid: recid,tablename: 'companies'})); 
                    w2ui['gdCompanyList'].reload();
                }
                
            }},
        columns: [
            {field: 'compid', caption: 'Company Id', size: '20%'},
            {field: 'compname', caption: 'Company Name', size: '50%'},
            {field: 'category', caption: 'Category', size: '30%'}
        ],
        onClick: function (event) {
            event.onComplete = function () {
        		var grid = this;
				var form = w2ui.frmCompanyDetails;		
					var sel = grid.getSelection();	
					if (sel.length == 1) {	
						form.record = $.extend(true, {}, grid.get(sel[0]));
						form.refresh();
					} else {
						form.clear();
					}
            }
        }
    },
    gdContacts: {
        name: 'gdContacts',
        url: 'getCompanyContacts',
        postData: {compid: 'ABC'},
        show: {
            toolbarInput: false,
            toolbarSearch: false,
            toolbar: true,
        },
        toolbar: {
            items: [
                {type: 'button', id: 'btnAddContact', caption: 'Add', img: 'icon-plus-sign'},
                {type: 'button', id: 'btnDelContact', caption: 'Delete', img: 'icon-minus-sign'}
            ],
            onClick: function (target, data) {
                if (target == 'btnAddContact') {

                    var grid = w2ui['gdCompanyList'];
                    var recid = grid.getSelection();
                    var compid = grid.get(recid[0])['compid'];
                    fnEventHandler('addNewContact', JSON.stringify({compid: compid}));
                    w2ui['gdContacts'].postData['compid'] = compid;
                    w2ui['gdContacts'].reload();

                }
                else if (target == 'btnDelContact') {
                    var grid = w2ui['gdContacts'];
                    var recid = grid.getSelection()[0];
                    fnEventHandler('../generic/deleteRow', JSON.stringify({recid: recid,tablename: 'company_contacts'})); 
                    w2ui['gdContacts'].reload();
                }
            }
        },
        columns: [
            {field: 'name', caption: 'Name', size: 30, editable: {type: 'text'}},
            {field: 'email', caption: 'Email', size: 50, editable: {type: 'text'}},
            {field: 'position', caption: 'Position', size: 30, editable: {type: 'text'}},
            {field: 'notify', caption: 'Notify', size: 40, editable: {type: 'list', items: ['Report', 'Invoice']}}
        ],
        onChange: function (event) {
			var gridcol = w2ui['gdContacts'].columns[event.column];
			var fieldToUpdate = fnUpdateField(gridcol,event,'company_contacts');
			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
        }
    }
};

$(function () {
    $('#main').w2layout(config.layoutMain);
    $().w2grid(config.gdSampleList);
    $().w2grid(config.gdContacts);
    $().w2grid(config.gdDocuments);
    $().w2form(config.frmCompanyDetails);
    w2ui.layoutMain.content('left', $().w2grid(config.gdCompanyList));
    w2ui.layoutMain.content('main', w2ui['frmCompanyDetails']);
});

function uploadDoc(){
    var grid = w2ui['gdCompanyList'];
    var recid = grid.getSelection();
    var compid = grid.get(recid[0])['compid'];
    var frmParameters = JSON.stringify({doctype: 'companies',compid: compid });
    fnUploadFiles(frmParameters);
}


