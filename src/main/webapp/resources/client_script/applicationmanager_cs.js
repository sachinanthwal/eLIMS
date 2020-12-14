var cantrol = ['Active','Deactive'];
//var units = ['Unit 1','Unit 2','Unit 3','Unit 4','Unit 5'];
//var users = ['prem@gmail.com','awadhesh@gmail.com'];
//var myrecords = fnEventHandler("loadDraftBatchList", "Draft");

var myform = $('#frmApplicationList').html();
var config = {
    gdapplications: {
        name: 'gdapplications',
        url: 'getApplications',
        postData: {data: null},
        show: {
            toolbar: true,
            toolbarAdd: true,
            toolbarDelete: true,
            selectColumn: true,
        },
        columns: [
            {field: 'appid', caption: 'Application ID', size: 10, editable: {type: 'text'}},
            {field: 'caption', caption: 'Caption', size: 15, editable: {type: 'text'}},          
            {field: 'url', caption: 'URL', size: 20, editable: {type: 'text'}},
            {field: 'helpurl', caption: 'Help URL', size: 15, editable: {type: 'text'}},
            {field: 'imageurl', caption: 'Image URL', size: 10, editable: {type: 'text'}},          
            {field: 'app_parameter', caption: 'Application Parameter', size: 15, editable: {type: 'text'}},
            {field: 'app_group', caption: 'Application Group', size: 15, editable: {type: 'text'}}
            
        ],
        onAdd: function (event)
        {
            newapplication();
        },
        onChange: function (event)
        {
			var gridcol = w2ui['gdapplications'].columns[event.column];
			var fieldToUpdate = fnUpdateField(gridcol,event,'applications');
			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
        },
        onClick: function (event)
        {
          
            event.onComplete = function () {
                var grid = w2ui['gdapplications'];
                var sel = grid.getSelection();
                if (sel.length == 1)
                {
                    _appid = grid.get(sel[0])['appid'];
                    w2ui.gdapprole.postData['appid'] = _appid;
                    w2ui.gdapprole.load('getApplicationRoles');

                }
            };
        }
    },

    layout1: {
        name: 'layout1',
        panels: [
            {type: 'top', size: 320, resizable: true, title: "Application Manager"},
            {type: 'main', resizable: true},

        ]},
    layout2: {
        name: 'layout2',
        panels: [
            {type: 'left', size:530, resizable: true},
            {type: 'main', resizable: true},
          
        ]},

    gdapprole: {
        name: 'gdapprole',
        header: 'Settings',
        url: "getApplicationRoles",
        postData: {appid: "appmgr"},
        show: {
            toolbar: true,
            toolbarAdd: true,
            toolbarDelete: true,
            selectColumn: true
        },
        columns: [
            {field: 'roleid', caption: 'Role ID', size: 15, editable: {type: 'text'}},
            {field: 'al_create', caption: 'Create', size: 10, editable: {type: 'checkbox'}},
            {field: 'al_read', caption: 'Read', size: 10, editable: {type: 'checkbox'}},
            {field: 'al_update', caption: 'Update', size: 10, editable: {type: 'checkbox'}},
            {field: 'al_delete', caption: 'Delete', size: 10, editable: {type: 'checkbox'}},
            {field: 'al_print', caption: 'Print', size: 10, editable: {type: 'checkbox'}},

        ],
        
        onChange: function (event)
        {
			var gridcol = w2ui['gdapprole'].columns[event.column];
			var fieldToUpdate = fnUpdateField(gridcol,event,'application_roles');
			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
        },
        onAdd: function (event)
        {
            var gridA = w2ui.gdapplications;
            var recid = gridA.getSelection();
            var row = gridA.get(recid[0]);
            var data = row.appid;
            fnEventHandler('dummy', 'insertapprole', data, "applicationmanager_sc.php");
            w2ui['gdapprole'].reload();
        },
    
    },
    
};

$(function () 
{
    $('#main').w2layout(config.layout1);
    w2ui.layout1.content('top', $().w2grid(config.gdapplications));
    w2ui.layout1.content('main', $().w2layout(config.layout2));
    w2ui.layout2.content('left', $().w2grid(config.gdapprole));
}
);


function newapplication() {
    if (!w2ui.formfields) {
        $().w2form({
            name: 'formfields',
            fields: [
                {field: 'appid', type: 'text', required: true, html: {caption: 'Application Id'}},
                {field: 'caption', type: 'text', required: true, html: {caption: 'Application Name'}},
                {field: 'url', type: 'text', required: true, html: {caption: 'Application URL'}},
            ]
        });
    }
    $().w2popup('open', {
        title: 'Add Application',
        body: '<div id="form" style="width: 100%; height: 100%;"></div>',
        style: 'padding: 0px 0px 0px 0px',
        width: 350,
        height: 250,
        showMax: true,
        buttons: '<button class="w2ui-btn" onclick="saveApplication()">Save</button>' +
                '<button class="w2ui-btn" onclick="w2popup.close()">Cancel</button>',
        onOpen: function (event) {
            event.onComplete = function () {
                $('#w2ui-popup #form').w2render('formfields');
            }
        }
    });
}

function saveApplication()
{
    var vappid = $('#appid').val();
    var vcaption = $('#caption').val();
    var vurl = $('#url').val();
    var data = JSON.stringify({sappid: vappid, scaption: vcaption, surl: vurl});
    fnEventHandler('dummy', 'insertapplication', data, "applicationmanager_sc.php");
    w2ui['gdapplications'].reload();
    w2popup.close();
}



