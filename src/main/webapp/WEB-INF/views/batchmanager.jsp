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

            <div id="divBatchType" style="visibility: hidden;"><div id="dgBatchType" style="width: 480px;height: 300px;"></div></div>
             <div id="divProjectList" style="visibility: hidden;"><div id="dgProjectList" style="width: 480px;height: 300px;"></div></div>
             <div id="divCompanyList" style="visibility: hidden;"><div id="dgCompanyList" style="width: 480px;height: 300px;"></div></div>
             <div id="divMaterialList" style="visibility: hidden;"><div id="dgMaterialList" style="width: 480px;height: 300px;"></div></div>
             
	<div id="frmBatchList" style="visibility: hidden;">
		<div class="w2ui-page page-0" style="width: 900px;">
			<div style="width: 350px; float: left; margin-right: 0px;">
				<div style="padding: 3px; font-weight: bold; color: #777;">General</div>
				<div class="w2ui-group" style="height: 235px;">
					<!--                        <div class="w2ui-field w2ui-span4">
                            <label>Rec Id:</label><div><input name="recid" type="text" maxlength="100" style="width: 100%"></div>
                        </div>-->
					<div class="w2ui-field w2ui-span4">
						<label>Batch Id:</label>
						<div>
							<input name="batchid" type="text" maxlength="100"
								style="width: 100%" readonly>
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Batch Name:</label>
						<div>
							<input name="batchname" type="text" maxlength="100"
								style="width: 100%">
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Batch Type:</label>
						<div>
							<input name="batchtype" type="text" maxlength="100"
								style="width: 200px">
							<button name="btnBatchType" class="w2ui-btn-small">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Project:</label>
						<div>
							<input name="txproject" type="text" maxlength="100"
								style="width: 200px">
							<button name="btnProjectId" class="w2ui-btn-small">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Material:</label>
						<div>
							<input name="txmaterial" type="text" maxlength="100"
								style="width: 200px" />
							<button name="btnMatCode" class="w2ui-btn-small">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span4">
						<label>Expiry Date:</label>
						<div>
							<input name="expdate" type="eu-date" maxlength="100"
								style="width: 100%">
						</div>
					</div>


				</div>
			</div>
			<div style="width: 420px; float: right; margin-left: 0px;">
				<div style="padding: 3px; font-weight: bold; color: #777;">Address</div>
				<div class="w2ui-group" style="height: 235px;">
					<div class="w2ui-field w2ui-span6">
						<label>Customer Batch Id:</label>
						<div>
							<input name="custbatchid" type="text" maxlength="100"
								style="width: 235px" />
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Customer:</label>
						<div>
							<input name="txcustomer" type="text" maxlength="100"
								style="width: 200px" />
							<button name="btnCompId" class="w2ui-btn-small">...</button>
						</div>
					</div>
			<div class="w2ui-field w2ui-span6" style="clear: both">
						<label>Address:</label>
						<div>
							<textarea name="address" rows="4" style="width: 90%"></textarea>
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Customer Contact:</label>
						<div>
							<input name="custcont" type="text" maxlength="100"
								style="width: 235px" />
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Submitter:</label>
						<div>
							<input name="submitter" type="text" maxlength="100"
								style="width: 235px" />
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
		src="<c:url value="/resources/client_script/batchmanager_cs.js" />"></script>

</body>
</html>