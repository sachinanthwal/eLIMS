<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy-LIMS</title>

<link href="<c:url value="/resources/css/w2ui-1.5.rc1.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" 	type="text/css">

<link href="<c:url value="/resources/codemirror/docs.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/codemirror/codemirror.css"/>" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/codemirror/codemirror.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/codemirror/sql.js"/>" type="text/javascript"></script>
<link href="<c:url value="/resources/codemirror/show-hint.css"/>" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/codemirror/show-hint.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/codemirror/sql-hint.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/codemirror/continuecomment.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/codemirror/matchbrackets.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/codemirror/comment.js"/>" type="text/javascript"></script>

</head>
<body>

	<div id="main" style="width: 100%; height: 600px;"></div>


	<div id="frmroleList" style="visibility: hidden;"></div>

	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script src="<c:url value="/resources/client_script/resultschema_cs.js" />"></script>

</body>
</html>