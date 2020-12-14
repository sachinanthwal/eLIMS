var tpfor = ['Chemical', 'For Testing','Apparatus'];



$(function () {
    var myform = $('#frmMaterialList').html();
    var config = {
        gdmaterials: {
            name: 'gdmaterials',
            url: "getMaterialList",
            postData: {mattype: 'Tested Here'},
            show: {
                toolbar: true,
                toolbarAdd: true,
                toolbarDelete: true,
                selectColumn: true
            },
            columns: [
                {field: 'matcode', caption: 'Material Code', size: 33, editable: {type: 'text'}},
                {field: 'matname', caption: 'Material Name', size: 33, editable: {type: 'text'}},
                {field: 'mattype', caption: 'Material Type', size: 34, editable: {type: 'list', items: tpfor}},
                {field: 'attributename', caption: 'Attribute Name', size: 34, editable: {type: 'text'}}
            ],
            onAdd: function (event)
            {
                newmaterial();
            },
    		onChange : function(event) {
    			var gridcol = w2ui['gdmaterials'].columns[event.column];
    			var fieldToUpdate = fnUpdateField(gridcol,event,'materials');
    			fnEventHandler('../generic/saveGrid', JSON.stringify(fieldToUpdate));
    		}
        },

        layout1: {
            name: 'layout1',
            panels: [
                {type: 'top', size: 320, resizable: true, title: "Material Manager"},
                {type: 'main', size: 200, resizable: true},
            ]},
        
    }
    ;

    $('#main').w2layout(config.layout1);
    w2ui.layout1.content('top', $().w2grid(config.gdmaterials));
    //w2ui.layout1.content('main', $().w2grid(config.gdAssignedSamples));
}
);



function newmaterial() {
    if (!w2ui.formfields) {
        $().w2form({
            name: 'formfields',
            fields: [
                {field: 'matcode', type: 'text', required: true, html: {caption: 'Material Code'}},
                {field: 'matname', type: 'text', required: true, html: {caption: 'Material Name'}},
                {field: 'mattype', type: 'list', required: true,
                    options: {items: ['Chemical', 'For Testing','Apparatus']}, html: {caption: 'Material Type'}},
            ]
        });
    }
    $().w2popup('open', {
        title: 'Add Material',
        body: '<div id="form" style="width: 100%; height: 100%;"></div>',
        style: 'padding: 0px 0px 0px 0px',
        width: 350,
        height: 250,
        showMax: true,
        buttons: '<button class="w2ui-btn" onclick="FormSave()">Save</button>' +
                '<button class="w2ui-btn" onclick="w2popup.close()">Cancel</button>',
        onOpen: function (event) {
            event.onComplete = function () {
                $('#w2ui-popup #form').w2render('formfields');
            }
        }
    });
}

function FormSave()
{
    var vmatcode = $('#matcode').val();
    var vmatname = $('#matname').val();
    var vmattype = $('#mattype').w2field().get().id;
    var data = JSON.stringify({matcode: vmatcode, matname: vmatname, mattype: vmattype});
    fnEventHandler('AddMaterial',data);
    w2ui['gdmaterials'].reload();
    w2popup.close();
}

