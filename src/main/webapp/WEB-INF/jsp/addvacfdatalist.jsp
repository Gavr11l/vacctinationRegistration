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

<title><spring:message code="addVacctinationFaultDataList.title" /></title>
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
				<spring:message code="addVacctinationFaultDataList.title" />
			</h3>
		</div>

		<form action="" method="get">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
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

				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
					<div class="radio-btn">
						<label><spring:message code="dateTypeChoice" /> <spring:bind
								path="command.dateType"></label>
						<p>
							<c:forEach var="dateType" items="${command.dateTypeCodes}">
								<c:set var="dataTypeCode" value="dataType.${dateType}" />
								<label class="radio my-radio-label"><input
									name="${status.expression}" type="radio"
									<c:if test="${dateType eq status.value}"> checked = "checked"</c:if>
									value="${dateType}"> <spring:message
										code="${dataTypeCode}" /> </input></label>
							</c:forEach>

							</spring:bind>
						</p>
					</div>
				</div>
			</div>


			<div class="width-table">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><spring:message code="table.patient.lastName" /></th>
							<th><spring:message code="table.patient.firstName" /></th>
							<th><spring:message code="table.patient.middleName" /></th>
							<th><spring:message code="table.patient.birthday" /></th>
							<th><spring:message
									code="table.vacctination.vacctinationType" /></th>
							<th><spring:message
									code="table.vacctination.vacctinationDate" /></th>
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
								<td><c:url var="addLink" value="addvacfdata">
										<c:param name="ptid" value="${row.patient.idPatient}" />
										<c:param name="vcid"
											value="${row.vacctination.idVacctination}" />
									</c:url> <a id="atb" href="${addLink}"> <spring:message
											code="link.addData" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<input type="submit" class="btn btn-info"
				value="<spring:message code="button.refresh" />" />
		</form>

		<footer class="footer">
			<p>&copy; 2017 Gavr, Inc.</p>
		</footer>

	</div>
	<!-- /container -->
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