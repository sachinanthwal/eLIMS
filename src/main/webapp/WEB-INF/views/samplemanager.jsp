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
<style>
#tabcarelabel {
	margin-left: 10px;
	border-collapse: collapse;
}

#tabcarelabel td {
	
}

#tabcarelabel td {
	width: 50px;
	text-align:center;
}
</style>
</head>
<body>
	<div id="main" style="width: 100%; height: 600px;"></div>
	<div id="divBatchList" style="visibility: hidden;">
		<div id="dgBatchList" style="width: 480px; height: 300px;"></div>
	</div>
	<div id="divProjectList" style="visibility: hidden;">
		<div id="dgProjectList" style="width: 480px; height: 300px;"></div>
	</div>
	<div id="divMaterialList" style="visibility: hidden;">
		<div id="dgMaterialList" style="width: 480px; height: 300px;"></div>
	</div>
	<div id="divCompanyList" style="visibility: hidden;">
		<div id="dgCompanyList" style="width: 480px; height: 300px;"></div>
	</div>
	<div id="carelabel" style="visibility: hidden;">
		<div
			style="background-image: url(../resources/images/care-labels.jpg); background-size: contain; background-repeat: no-repeat; width: 100%; height: 100%;">
			<table id="tabcarelabel">
				<tr>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
				</tr>
				<tr><td style="height:53px" ></td></tr>
				
				<tr>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="vehicle" value="Bike"></td>
					<td><input type="radio" name="bleach" value="Bike"></td>
					<td><input type="radio" name="bleach" value="Bike"></td>
					<td><input type="radio" name="bleach" value="Bike"></td>
					<td><input type="radio" name="bleach" value="Bike"></td>
				</tr>
			</table>
		</div>
	</div>


	<div id="frmSampleList" style="visibility: hidden;">
		<div class="w2ui-page page-0" style="width: 850px;">
			<div style="width: 380px; float: left; margin-right: 0px;">
				<div class="w2ui-group" style="height: 200px;">

					<div class="w2ui-field w2ui-span6">
						<label>Sample Id:</label>
						<div>
							<input id="sampleid" name="sampleid" type="text" maxlength="100"
								style="width: 190px" readonly>
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Material Code:</label>
						<div>
							<input name="matcode" type="text" maxlength="100"
								style="width: 190px" readonly />
							<button name="btnMatCodeClear" style="border-radius: 20px">x</button>
							<button name="btnMatCode"
								style="border-radius: 5px; height: 20px">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Batch Id:</label>
						<div>
							<input name="batchid" type="text" maxlength="100"
								style="width: 190px" readonly>
							<button name="btnBatchIdClear" style="border-radius: 20px;">x</button>
							<button name="btnBatchId"
								style="border-radius: 5px; height: 20px">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Project Id</label>
						<div>
							<input name="projectid" type="text" maxlength="100"
								style="width: 190px" readonly>
							<button name="btnProjectIdClear" style="border-radius: 20px">x</button>
							<button name="btnProjectId"
								style="border-radius: 5px; height: 20px">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Amount</label>
						<div>
							<input name="amount" type="text" maxlength="100" style="width: 190px" readonly>
						</div>
					</div>
				</div>
			</div>
			<div style="width: 380px; float: right; margin-left: 0px;">
				<div class="w2ui-group" style="height: 200px;">

					<div class="w2ui-field w2ui-span6">
						<label>Company Code:</label>
						<div>
							<input name="compid" type="text" maxlength="100"
								style="width: 190px" readonly />
							<button name="btnCompIdClear" style="border-radius: 20px">x</button>
							<button name="btnCompId" style="border-radius: 5px; height: 20px">...</button>
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Company Name:</label>
						<div>
							<input name="compname" type="text" maxlength="100"
								style="width: 200px" readonly />
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Address:</label>
						<div>
							<input name="address" type="text" maxlength="100"
								style="width: 200px" readonly />
						</div>
					</div>
					<div class="w2ui-field w2ui-span6">
						<label>Contact Person:</label>
						<div>
							<input name="contactname" type="text" maxlength="100"
								style="width: 200px" readonly />
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
		src="<c:url value="/resources/client_script/samplemanager_cs.js" />"></script>

</body>
</html>