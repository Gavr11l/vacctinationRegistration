<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="assets/img/favicon.ico">



<title><spring:message code="mainform.title" /></title>

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
				<spring:message code="mainform.title" />
			</h3>
		</div>



		<div class="row marketing">
			<div class="col-lg-6">
				<h4>
					<a href="addvacdatalist"> <spring:message
							code="mainform.addVacctinationData" />
					</a>
				</h4>
				<p>
					<spring:message code="mainform.addVacctinationData.description" />
				</p>

				<h4>
					<a href="addvacresdatalist"> <spring:message
							code="mainform.addVacctinationResultData" />
					</a>
				</h4>
				<p>
					<spring:message
						code="mainform.addVacctinationResultData.description" />
				</p>

				<h4>
					<a href="addvacfdatalist"> <spring:message
							code="mainform.addVacctinationFaultData" />
					</a>
				</h4>
				<p>
					<spring:message
						code="mainform.addVacctinationFaultData.description" />
				</p>

				<h4>
					<a href="addvacrdatalist"> <spring:message
							code="mainform.addVacctinationRenouncementData" />
					</a>
				</h4>
				<p>
					<spring:message
						code="mainform.addVacctinationRenouncementData.description" />
				</p>

				<h4>
					<a href="addcpdata"> <spring:message
							code="mainform.addCalendarPlanData" />
					</a>
				</h4>
				<p>
					<spring:message code="mainform.addCalendarPlanData.description" />
				</p>

			</div>

			<div class="col-lg-6">

				<h4>
					<a href="vacrep"> <spring:message
							code="mainform.vacctinationReport" />
					</a>
				</h4>
				<p>
					<spring:message code="mainform.vacctinationReport.description" />
				</p>

				<h4>
					<a href="falrep"> <spring:message code="mainform.faultReport" />
					</a>
				</h4>
				<p>
					<spring:message code="mainform.faultReport.description" />
				</p>

				<h4>
					<a href="renrep"><spring:message
							code="mainform.renouncementReport" /></a>
				</h4>
				<p>
					<spring:message code="mainform.renouncementReport.description" />
				</p>

				<h4>
					<a href="form063"> <spring:message
							code="mainform.form063Report" /></a>
				</h4>
				<p>
					<spring:message code="mainform.form063Report.description" />
				</p>

			</div>
		</div>

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
	<script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
