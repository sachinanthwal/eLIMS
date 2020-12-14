<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>EasyLIMS v1.0</title>
<meta name="description" content="Bootstrap Metro Dashboard - v1">
<meta name="author" content="Dennis Ji">

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" 	type="text/css">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" 	type="text/css">
<link href="<c:url value="/resources/css/style-responsive.css" />" rel="stylesheet" 	type="text/css">
<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
</head>

<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="left.jsp" />

	<div id="content" class="span10" style="padding: 5px">
		<iframe name="appContent" src="dashboard" width="100%" 	height="800px"></iframe>
	</div>

	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Save changes</a>
		</div>
	</div>

	<div class="clearfix"></div>

	
	<script src="<c:url value="/resources/js/jquery-migrate-1.0.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui-1.10.0.custom.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.ui.touch-punch.js" />"></script>
	<script src="<c:url value="/resources/js/modernizr.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.cookie.js" />"></script>
	<script src="<c:url value="/resources/js/fullcalendar.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
	<script src="<c:url value="/resources/js/excanvas.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.chosen.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.uniform.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.cleditor.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.noty.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.elfinder.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.iphone.toggle.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.uploadify-3.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.gritter.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.imagesloaded.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.masonry.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.knob.modified.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.sparkline.min.js" />"></script>
	<script src="<c:url value="/resources/js/counter.js" />"></script>
	<script src="<c:url value="/resources/js/retina.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>

</body>
</html>
