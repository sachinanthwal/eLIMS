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

	<div id="cusinfo" style="display: none">
		<div class="w2ui-page page-0">
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Company Id:</label>
				<div>
					<input name="compid" type="text" maxlength="100" style="width: 100px" readonly>
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Category:</label>
				<div>
					<input name="category" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Company Name:</label>
				<div>
					<input name="compname" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Address:</label>
				<div>
					<textarea name="address" rows="4" cols="50"> </textarea>
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>City:</label>
				<div>
					<input name="city" type="text" maxlength="100" style="width: 200px">
					<label>Pin:</label> <input name="postcode" type="text"
						maxlength="100" style="width: 75px">
				</div>

			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>State:</label>
				<div>
					<input name="state" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Phone:</label>
				<div>
					<input name="phone" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Mobile:</label>
				<div>
					<input name="mobile" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Fax No.:</label>
				<div>
					<input name="fax" type="text" maxlength="100" style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Email:</label>
				<div>
					<input name="email" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Contact Name:</label>
				<div>
					<input name="contactname" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-field w2ui-span8" style="clear: both">
				<label>Company Website</label>
				<div>
					<input name="website" type="text" maxlength="100"
						style="width: 300px">
				</div>
			</div>
			<div class="w2ui-buttons">
				<button class="w2ui-btn" name="save">Save</button>
			</div>
		</div>
	</div>
	
<form id="uploadfile" method="post" action="../uploadFiles" enctype="multipart/form-data">
  <input type="file" name="files" id="attFiles" accept="image/*" onchange="uploadDoc()" style="display:none" multiple>
</form>



	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script src="<c:url value="/resources/client_script/companies_cs.js" />"></script>

</body>
</html>