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

<title><spring:message code="form063Report.title" /></title>
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
				<spring:message code="form063Report.title" />
			</h3>
		</div>



		<form action="form063" method="get">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label for="sel1"><spring:message code="yearSelect" /></label>

						<spring:bind path="command.year">
							<select class="form-control" id="sel1" size="5" multiple
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
		</form>



		<div class="width-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><spring:message code="table.patient.lastName" /></th>
						<th><spring:message code="table.patient.firstName" /></th>
						<th><spring:message code="table.patient.middleName" /></th>
						<th><spring:message code="table.patient.birthday" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${command.patientList }">
						<tr>
							<td>${row.lastName}</td>
							<td>${row.firstName}</td>
							<td>${row.middleName}</td>
							<td>${row.birthday}</td>
							<td><c:url var="repLink" value="form063">
									<c:param name="action" value="report" />
									<c:param name="ptid" value="${row.idPatient}" />
								</c:url> <a id="atb" href="${repLink}"> <spring:message
										code="link.report" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="submit" class="btn btn-info"
			value="<spring:message code="button.refresh" />" />
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