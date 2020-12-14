<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>Easy-LIMS</title>

<link href="<c:url value="/resources/css/w2ui-1.5.rc1.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" 	type="text/css">
</head>
<body>
<div class="container">
    <div class="login">
        <div style="text-align:center;margin-bottom: 24px;"><img width="200" src="resources/images/eLIMS.png"/></div>
        <h1>User Login</h1>
        <span style="color: orangered;"></span>
     <form id="form1" method="post">
		<div id="loginform" style="height: 300px; border: 0px">
			<div class="w2ui-page page-0">

			<div class="w2ui-field w2ui-span4" style="clear: both">
				<label>User Name:</label>
				<div>
					<input id = "username" name="username" type="text" maxlength="100" style="width: 120px !important;">
				</div>
			</div>

			<div class="w2ui-field w2ui-span4" style="clear: both">
				<label>Password:</label>
				<div>
					<input id= "password"  name="password" type="password" maxlength="100" style="width: 120px !important;">
				</div>
			</div>

			<div class="w2ui-field w2ui-span4" style="clear: both">
				<label>Site:</label>
				<div>
					<input name="site" type="text" maxlength="100" style="width: 120px !important;">
				</div>
			</div>

			<div class="w2ui-field w2ui-span4" style="clear: both">
				<label>User Role:</label>
				<div>
					<input name="userRole" type="text" maxlength="100" style="width: 120px !important;">
				</div>
			</div>

	<div class="w2ui-buttons">
		<button form="form1" value="Submit" type="button" name="submit">Login</button>
	</div>
	</div>
</div>
</form>


        <div style="text-align:center;margin-top: 12px;"><a style="color:#404040; margin-top: 12px;" href="register.php">Register new user</a></div>
        <div style="text-align:center;margin-top: 12px;"><a style="color:#404040;" href="#" onclick="forgotPassword()">Forgot your password?</a></div>
    </div>
</div>



	<div id="mkin" style="width: 100%; height: 600px;"></div>


	<div id="frmroleList" style="visibility: hidden;"></div>

	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script src="<c:url value="/resources/client_script/index_cs.js" />"></script>

</body>
</html>