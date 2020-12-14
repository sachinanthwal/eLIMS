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


	<div id="formhtml" style="visibility: hidden;">
		<div id="ScheduleForm" style="width: 750px;">
			<div class="w2ui-page page-0">
				<div class="w2ui-column-container" style="display: flex;">
					<div class="w2ui-column col-0"
						style="border: 1px solid lightgray; margin-right: 2px">
						<div class="w2ui-field">
							At <input name="atevery" type="radio" value="EveryHour" /><br>
							<label style="width: 90px;">Every</label>
							<div style="margin-left: 90px">
								<label><input name="everyhour" type="text" size="2" />Hour(s)</label>
							</div>
						</div>
					</div>
					<div class="w2ui-column col-1 "
						style="border: 1px solid lightgray; margin-left: 2px">
						<div class="w2ui-field ">
							At <input name="atevery" type="radio" value="TimeSet" /><br>
							<label>Fix Time 1</label>
							<div>
								<input name="fixtime1" type="text" size="5" />
							</div>
						</div>
						<div class="w2ui-field">
							<label>Fix Time 2</label>
							<div>
								<input name="fixtime2" type="text" size="5" />
							</div>
						</div>
						<div class="w2ui-field">
							<label>Fix Time 3</label>
							<div>
								<input name="fixtime3" type="text" size="5" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="w2ui-page page-1">
				<div class="w2ui-field">
					On <input name="atevery" type="radio" value="EveryDay" /><br>
					<label>Every:</label>
					<div>
						<input name="day" type="text" size="2" /> <label>day(s)</label>
					</div>
				</div>
			</div>
			<div class="w2ui-page page-2">
				<div class="w2ui-column-container" style="display: flex;">
					<div class="w2ui-column col-0">
						<div class="w2ui-field w2ui-span4">
							<label>Monday</label>
							<div>
								<input type="checkbox" name="monday" value="Mon">
							</div>
						</div>
						<div class="w2ui-field w2ui-span4">
							<label>Tuesday</label>
							<div>
								<input type="checkbox" name="tuesday" value="Tue">
							</div>
						</div>
						<div class="w2ui-field w2ui-span4">
							<label>Wednesday</label>
							<div>
								<input type="checkbox" name="wednesday" value="Tue">
							</div>
						</div>

						<div class="w2ui-field w2ui-span4">
							<label>Thursday</label>
							<div>
								<input type="checkbox" name="thursday" value="Tue">
							</div>
						</div>
					</div>

					<div class="w2ui-column col-1">
						<div class="w2ui-field w2ui-span4">
							<label>Friday</label>
							<div>
								<input type="checkbox" name="tuesday" value="Tue">
							</div>
						</div>
						<div class="w2ui-field w2ui-span4">
							<label>Saturday</label>
							<div>
								<input type="checkbox" name="wednesday" value="Tue">
							</div>
						</div>

						<div class="w2ui-field w2ui-span4">
							<label>Sunday</label>
							<div>
								<input type="checkbox" name="thursday" value="Tue">
							</div>
						</div>
					</div>
					<div class="w2ui-column col-2"
						style="border: 1px solid lightgray; margin-right: 2px">
						In <input name="atevery" type="radio" value="EveryWeek" /><br>
						<div class="w2ui-field">
							<label style="width: 70px">Every</label>
							<div style="margin-left: 70px">
								<input name="week" type="text" size="2" /> <label>Week(s)</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="w2ui-page page-3">

				<div class="w2ui-field">
					<label style="width: 40px"> 
						<input name="atevery" type="radio" value="EveryMonth" />
					</label>
					<div style="margin-left: 40px">
							<label>Every</label> 
							<input name="dayno" type="text" size="2"  placeholder="n,n,.."/> 
							<input name="MonthWeekdays" type="text" size="5" /> 
							<label>of every</label> 
							<input name="month" type="text" size="2" /> 
							<label>Month(s)</label>
					</div>
				</div>
			</div>
			<div class="w2ui-page page-4">
				<div class="w2ui-field">
					<label style="width: 30px">
						<input name="atevery" type="radio" value="EveryYear1" />
					</label>
					<div style="margin-left: 30px">
							<input name="ddmm" type="text" size="2" placeholder="dd-mm" /> 
							<label>every</label>
							<input name="year1" type="text" size="2" /> 
							<label>Year(s)</label>
					</div>
				</div>

				<div class="w2ui-field">
					<label style="width: 30px"> 
						<input name="atevery" type="radio" value="EveryYear2" />
					</label>
					<div style="margin-left: 30px">
						<input name="Yeardayno" type="text" size="5" /> 
						<input name="YearWeekdays" type="text" size="5" /> 
						<label> of </label>
						<input name="YearMonths" type="text" size="5" /> 
						<label>every</label> 
						<input name="year2" type="text" size="2" /> 
						<label>Years(s)</label>
					</div>
				</div>
			</div>
		</div>

		<div class="w2ui-buttons">
			<button class="w2ui-btn" name="save">Save</button>
		</div>
	</div>


	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/w2ui-1.5.rc1.js" />"></script>
	<script src="<c:url value="/resources/js/global_cs.js" />"></script>
	<script
		src="<c:url value="/resources/client_script/samplescheduler_cs.js" />"></script>
</body>
</html>