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
	<div id="frmImage" style="display: none">
		<div class="w2ui-field w2ui-span4">
			<label>Profile Image</label>
			<div>
				<form method="post" action="../uploadFile?doctype=userprofile"
					enctype="multipart/form-data">
					<input type="file" name="uploadFile" accept="image/*" /> <br /> <br />
					<input type="submit" value="Upload" />
				</form>
			</div>
		</div>


		<img id="userprofileimg" src="<c:url value="../resources/upload/userprofile/male.jpg"/>" alt="Smiley face"
			height="100" width="100">
	</div>

	<div id="frmGeneralInfo" style="visibility: hidden;">
		<div class="w2ui-page page-0" style="width: 900px;">
			<div style="width: 350px; float: left; margin-right: 0px;">
				<div style="padding: 3px; font-weight: bold; color: #777;">General</div>
				<div class="w2ui-group" style="height: 235px;">
					<!--                        <div class="w2ui-field w2ui-span4">
                            <label>Rec Id:</label><div><input name="recid" type="text" maxlength="100" style="width: 100%"></div>
                        </div>-->
					<div class="w2ui-field w2ui-span4">
						<label>Status:</label>
						<div>
							<input name="status" type="text" maxlength="100"
								style="width: 200px">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Job Title:</label>
						<div>
							<input name="job_title" type="text" maxlength="100"
								style="width: 200px">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Gender:</label>
						<div>
							<input name="gender" type="text" maxlength="100"
								style="width: 200px">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Date of Birth:</label>
						<div>
							<input name="dob" type="text" maxlength="100"
								style="width: 200px">
						</div>
					</div>

				</div>
			</div>
			<div style="width: 350px; float: left; margin-left: 5px;">
				<div style="padding: 3px; font-weight: bold; color: #777;">Contact</div>
				<div class="w2ui-group" style="height: 235px;">
					<div class="w2ui-field w2ui-span4">
						<label>Email Id:</label>
						<div>
							<input name="email" type="text" maxlength="100"
								style="width: 90%">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>IM:</label>
						<div>
							<input name="im" type="text" maxlength="100" style="width: 90%">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4" style="clear: both">
						<label>Address:</label>
						<div>
							<textarea name="address" rows="4" style="width: 90%"></textarea>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>


	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script src="<c:url value="/resources/client_script/users_cs.js" />"></script>

</body>
</html>