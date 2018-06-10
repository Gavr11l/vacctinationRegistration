<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="assets/img/favicon.ico">

<title><spring:message code="addCalendarPlanData.title" /></title>
<!-- Bootstrap core CSS -->
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="assets/css/jumbotron-narrow.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="assets/js/ie-emulation-modes-warning.js"></script>

<script src="assets/js/script.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation"><a href="/app/mainform"><spring:message
								code="common.home" /></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><spring:message code="common.language" />
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="switchLanguage('ru');"><spring:message
										code="common.lru" /></a></li>
							<li><a href="#" onclick="switchLanguage('en');"><spring:message
										code="common.len" /></a></li>
							<li><a href="#" onclick="switchLanguage('ua');"><spring:message
										code="common.lua" /></a></li>
						</ul></li>
					<li role="presentation"><a href="/app/logout"><spring:message
								code="common.logout" /></a></li>
				</ul>
				<ul class="nav nav-pills pull-right">
					<li role="presentation">
						<p class="navbar-text">
							<spring:message code="common.medemployeeLabel" />
							: ${command.medEmployee.lastName}
							${command.medEmployee.firstName}
							${command.medEmployee.middleName}
						</p>
						<p class="navbar-text">
							<spring:message code="common.institution" />
							: ${command.institution.institutionName}
						</p>
					</li>
				</ul>
			</nav>
			<h3 class="text-muted">
				<spring:message code="addCalendarPlanData.title" />
			</h3>
		</div>



		<spring:bind path="command">
			<c:forEach var="error" items="${status.errorMessages}">
				<p>${error}</p>
			</c:forEach>
		</spring:bind>

		<div class="row">
			<form action="addcpdata" method="get">

				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-5">
					<div class="form-group">
						<label for="sel1"><spring:message
								code="vacctinationChoice" /></label>

						<spring:bind path="command.vacctinationIds">
							<select class="form-control" id="sel1" size="7" multiple
								name="${status.expression}">
								<c:forEach var="vac" items="${command.vacctinationList}">
									<option value="${vac.idVacctination}"
										<c:if test="${fn:contains( status.value, vac.idVacctination)}"> selected="selected"</c:if>>
										${vac.vacctinationType}</option>
								</c:forEach>
							</select>
						</spring:bind>
					</div>
				</div>

				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-5">
					<div class="form-group">
						<label for="sel1"><spring:message code="yearSelect" /></label>

						<spring:bind path="command.year">
							<select class="form-control" id="sel1" size="7" multiple
								name="${status.expression}">
								<c:forEach var="year" items="${command.yearList}">
									<option value="${year}"
										<c:if test="${status.value eq year}"> selected="selected"</c:if>>
										${year}</option>
								</c:forEach>
							</select>
						</spring:bind>

					</div>
				</div>

				<p>
					<br> <br> <br> <br> <input type="submit"
						class="btn btn-info"
						value="<spring:message code="button.refresh"/>" />
				</p>
		</div>

		</form>

		<p>
		<form id="frm2" action="addcpdata" method="post">

			<div class="row">
				<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
					<div class="form-group">
						<label for="sel1"><spring:message
								code="vacctinationChoice" /></label>
						<spring:bind path="command.vacctinationId">
							<select name="${status.expression}">
								<c:forEach var="vac" items="${command.vacctinationList2}">
									<option value="${vac.idVacctination}"
										<c:if test="${ status.value eq vac.idVacctination}"> selected="selected"</c:if>>
										${vac.vacctinationType}</option>
								</c:forEach>
							</select>
							<c:forEach var="error" items="${status.errorMessages}">
								<p>${error}</p>
							</c:forEach>
						</spring:bind>
					</div>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
					<div class="radio-btn">
						<label><spring:message code="patientChoice" /></label>
						<spring:bind path="command.patientId">
							<select name="${status.expression}">
								<c:forEach var="pat" items="${command.patientList}">
									<option value="${pat.idPatient}"
										<c:if test="${ status.value eq pat.idPatient}"> selected="selected"</c:if>>
										${pat.lastName} ${pat.firstName} ${pat.middleName}</option>
								</c:forEach>
							</select>
							<c:forEach var="error" items="${status.errorMessages}">
								<p>${error}</p>
							</c:forEach>
						</spring:bind>
					</div>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
					<div class="data-label">
						<label for="sel1"><spring:bind
								path="command.vacctinationDate"></label>
						<spring:message code="vacctinationDate" />
						<input type="text" name="${status.expression}"
							value="${status.value}">
						<c:forEach var="error" items="${status.errorMessages}">
							<p>${error}</p>
						</c:forEach>
						</spring:bind>
					</div>
				</div>



				<spring:bind path="command.vacctinationIds">
					<input type="hidden" name="${status.expression}"
						value="${status.value}">
				</spring:bind>
				<spring:bind path="command.year">
					<input type="hidden" name="${status.expression}"
						value="${status.value}">
				</spring:bind>
				<spring:bind path="command.pcpid">
					<input type="hidden" name="${status.expression}"
						value="${status.value}">
				</spring:bind>
				<br>
				<div class="col-xs-12 col-sm-1 col-md-1 col-lg-1">
					<input type="hidden" name="action" id="action">
					<c:choose>
						<c:when test="${command.editMode}">
							<input type="button" class="btn btn-primary"
								value="<spring:message code="button.edit" />"
								onclick="doSsubmit('edit')" />
						</c:when>
						<c:otherwise>
							<input type="button" class="btn btn-primary"
								value="<spring:message code="button.add" />"
								onclick="doSsubmit('add')" />
						</c:otherwise>
					</c:choose>
				</div>
		</form>
	</div>
	<script type="text/javascript">
		function doSsubmit(action) {
			document.getElementById("action").value = action;
			document.getElementById("frm2").submit();
		}
	</script>
	</p>

	<div class="width-table">
		<table class="table table-bordered table-condensed">
			<thead>
				<tr>
					<th><spring:message code="table.patient.lastName" /></th>
					<th><spring:message code="table.patient.firstName" /></th>
					<th><spring:message code="table.patient.middleName" /></th>
					<th><spring:message code="table.patient.birthday" /></th>
					<th><spring:message code="table.vacctination.vacctinationType" /></th>
					<th><spring:message code="table.vacctination.vacctinationDate" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${command.wrapperList }">
					<tr>
						<td>${row.patient.lastName}</td>
						<td>${row.patient.firstName}</td>
						<td>${row.patient.middleName}</td>
						<td>${row.patient.birthday}</td>
						<td>${row.vacctination.vacctinationType}</td>
						<td>${row.patientCalendarPlan.vacctinationDate}</td>
						<td><c:url var="ediLink" value="addcpdata">
								<c:param name="pcpid"
									value="${row.patientCalendarPlan.idPatientCalendarPlan}" />
							</c:url> <a id="atb" href="${ediLink}"> <spring:message
									code="link.editData" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<input type="submit" class="btn btn-info"
		value="<spring:message code="button.refresh" />" />

	</div>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>