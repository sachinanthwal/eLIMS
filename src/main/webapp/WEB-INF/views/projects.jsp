<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy-LIMS</title>

<link href="<c:url value="/resources/css/w2ui-1.5.rc1.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">

</head>
<body>

	<div id="main" style="width: 100%; height: 600px;"></div>

	<div id="frmProjectDetails" style="visibility: hidden;">
		<div class="w2ui-page page-0" style="width: 900px;">
			<div style="width: 400px; float: left; margin-right: 0px;">
				<div style="padding: 3px; font-weight: bold; color: #777;">General</div>
				<div class="w2ui-group" style="height: 235px;">
					<!--                        <div class="w2ui-field w2ui-span4">
                            <label>Rec Id:</label><div><input name="recid" type="text" maxlength="100" style="width: 100%"></div>
                        </div>-->
					<div class="w2ui-field w2ui-span4">
						<label>Project Id:</label>
						<div>
							<input name="projectid" type="text" maxlength="100" style="width: 100px" readonly>
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Project:</label>
						<div>
							<input name="projectname" type="text" maxlength="100"
								style="width: 100%">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Project Type:</label>
						<div>
							<input name="projecttype" type="text" maxlength="100"
								style="width: 200px">
							<button name="btnProjectType" class="w2ui-btn-small">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Status:</label>
						<div>
							<input name="status" type="text" maxlength="100" style="width: 100px" readonly>
			
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>


	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script
		src="<c:url value="/resources/client_script/projectmanager_cs.js" />"></script>

</body>
</html>