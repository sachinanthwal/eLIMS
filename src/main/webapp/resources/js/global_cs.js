//Call server and return type Json;
function fnEventHandler(url, postdata) {
	$.ajax({
		async : false,
		url : url,
		data : {
			request : postdata
		},
		success : function(data) {
			if (data.length > 0) {
				postdata = JSON.parse(data);
			}
		}
	});
	return postdata;
}

//Call server and return type String;
function fnCallServer_String(url, postdata) {
	$.ajax({
		async : false,
		url : url,
		data : {
			request : postdata
		},
		success : function(data) {
			if (data.length > 0) {
				postdata = data;
			}
		}
	});
	return postdata;
}

function fnUpdateField(gridcol, event, tablename) {

	var data = '';
	if (gridcol.editable.type == "list") {
		data = {
			recid : event.recid,
			field : gridcol.field + "='" + event.value_new.text + "'",
			tablename : tablename
		};
	} else if (gridcol.editable.type == "text") {
		data = {
			recid : event.recid,
			field : gridcol.field + "='" + event.value_new + "'",
			tablename : tablename
		};
	} else if (gridcol.editable.type == "checkbox") {
		var nvalue = 0;
		if (event.value_new == true) {
			nvalue = 1;
		}
		data = {
			recid : event.recid,
			field : gridcol.field + "=" + nvalue,
			tablename : tablename
		};
	} else {
		data = {
			recid : event.recid,
			field : gridcol.field + "=" + event.value_new,
			tablename : tablename
		};
	}
	return data;
}

function GenerateAttributeFields(attname) {
	var fields = fnEventHandler('../attributes/getAttributeFields', JSON
			.stringify({
				attname : attname
			}));
	var fieldArray = [];
	for ( var i in fields) {
		var row = [];
		if (fields[i].type == 'list') {
			var data = fnEventHandler('../lookups/getLookupValues', JSON
					.stringify({
						lname : 'Sample Type'
					}));
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
		} else if (fields[i].type == 'date') {
			row = {
				name : fields[i].name,
				type : fields[i].type,
				required : fields[i].required == "1",
				options : {
					format : 'dd-mm-yyyy'
				}
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
	return fieldArray;
};

function getFieldsToSave(f) {
	var fd = {};
	for (var i = 0; i < f.fields.length; i++) {
		var t = f.fields[i].type;
		var n = f.fields[i].name;
		var s = f.fields[i].options.hasOwnProperty('save');
		var v = f.record[n];
		// fields only which do not have option:{save: false}
		if (!s) {
			fd[n] = v;
			if (t == 'list') {
				fd[n] = v.id;
			}
			if (t == 'checkbox' && v == false) {
				fd[n] = "";
			}
		}
	}

	return fd;
}

function CalculationDialog(recid,tname) {
	var s =  "<button class='w2ui-btn' onclick=\"saveCalc("+ recid+ ",'"+tname+"')\">Save</button><button class='w2ui-btn' onclick='w2popup.close()'>Cancel</button>";
	w2popup.open({
				title : 'CALCULATION EDITOR',
				body : '<textarea id="comments"></textarea>',
				buttons : s
			});
	var mime = "text/x-mariadb";
	var cd = fnEventHandler('../generic/getCalcode', JSON.stringify({recid : recid,table: tname}));
	window.editor = CodeMirror.fromTextArea(
			document.getElementById("comments"), {
				mode : mime,
				indentWithTabs : true,
				smartIndent : true,
				lineNumbers : true,
				matchBrackets : true,
				autofocus : true,
				extraKeys : {
					"Ctrl-Space" : "autocomplete"
				},
			});
	editor.setValue(cd[0].calcode);

}
function saveCalc(recid,tname) {
	var calc = editor.getValue();
	fnEventHandler('../generic/setCalcode', JSON.stringify({calc : calc,recid : recid,table: tname}));
	w2popup.close();
}


function fnUploadFiles(frmParameters)
{
	var form = document.forms[0];
	var formData = new FormData(form);
	if(form[0].files.length==0)return;
	formData.append('param', frmParameters);

	jQuery.ajax({
		url: '../files/upload',
		data: formData,
		cache: false,
		contentType: false,
		processData: false,
		method: 'POST',
		type: 'POST', // For jQuery < 1.9
		success: function(data){
			//w2alert(data);
			//w2ui['gdDocuments'].reload();
		}
	});
}