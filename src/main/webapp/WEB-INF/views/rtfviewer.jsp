<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy-LIMS</title>

<link href="<c:url value="/resources/css/w2ui-1.5.rc1.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"	rel="stylesheet" type="text/css">

</head>
<body>

	<div id="main" style="width: 100%; height: 600px;">
		<div class="w2ui-page page-0">
			<div class="w2ui-field">
				<label>Text Area:</label>
				<div>
				
					<textarea id="rtf" style="width: 600px; resize: none" ></textarea>
		
				</div>
			</div>
		</div>
		    <div class="w2ui-buttons">
        <button class="w2ui-btn" name="reset">Reset</button>
        <button class="w2ui-btn" name="save">Save</button>
    </div>
	</div>

	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/rtf/tinymce.min.js" />"></script>
	<script src="<c:url value="/resources/rtf/jquery.tinymce.min.js" />"></script>

	<script>
		tinymce.init({
					selector : 'textarea',
					height : 400,
					theme : 'modern',
					browser_spellcheck : true,
					plugins : 'print preview fullpage paste save searchreplace autolink directionality code visualblocks visualchars fullscreen image link media template codesample table charmap hr pagebreak nonbreaking anchor toc insertdatetime advlist lists textcolor wordcount imagetools media  link contextmenu colorpicker textpattern help',
					toolbar1 : 'formatselect | bold italic strikethrough forecolor backcolor | link | alignleft aligncenter alignright alignjustify  | numlist bullist outdent indent  | removeformat',
					toolbar_items_size: 'small',
					image_advtab : true,
					templates : [ {
						title : 'Test template 1',
						content : 'Test 1'
					}, {
						title : 'Test template 2',
						content : 'Test 2'
					} ],
					content_css : [
							'//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
							'//www.tinymce.com/css/codepen.min.css' ]
				});
	</script>
	
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/client_script/rtfviewer_cs.js" />"></script>
	
</body>
</html>