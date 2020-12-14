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

</head>
<body>

	<div id="main" style="width: 100%; height: 600px;"></div>

        <div id="cusinfo" style="display: none">
            <div class="w2ui-page page-0" >
                <h3>Company Info</h3><br>
                <input id="compname" name="compname" type="text"  style="width: 225px;" readonly>
                <br><br>
                <input name="address" type="text" maxlength="100" style="width: 225px" readonly><br>
                <br>
                <input name="city" type="text" maxlength="100" style="width: 150px" readonly>
            </div>
        </div>

	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script src="<c:url value="/resources/client_script/invoices_cs.js" />"></script>

</body>
</html>