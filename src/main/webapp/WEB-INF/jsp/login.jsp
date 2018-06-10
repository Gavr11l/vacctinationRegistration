<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<title><spring:message code="loginf.loginTitle" /></title>

<!-- Bootstrap core CSS -->
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
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

		<spring:bind path="command.*">
			<c:if test="${fn:length(status.errorMessages) gt 0}">
				<div class="alert alert-danger">
					<c:forEach var="error" items="${status.errorMessages}">
						<strong>${error}</strong>
					</c:forEach>
				</div>
			</c:if>
		</spring:bind>


		<form action="login" method="post" class="form-signin">
			<h2 class="form-signin-heading">
				<spring:message code="loginf.please_sign_in" />
			</h2>

			<p>
				<spring:bind path="command.login">
					<label for="inputEmail" class="sr-only"><spring:message
							code="loginf.login" /></label>
					<input type="text" name="${status.expression}"
						value="${status.value}" id="inputEmail" class="form-control"
						placeholder="Login" required autofocus>
					<!-- <c:forEach var="error" items="${status.errorMessages}"> ${error} </c:forEach> -->
				</spring:bind>
			</p>

			<p>
				<spring:bind path="command.password">
					<label for="inputPassword" class="sr-only"><spring:message
							code="loginf.password" /></label>
					<input type="password" name="${status.expression}"
						value="${status.value}" id="inputPassword" class="form-control"
						placeholder="Password" required>
					<!-- <c:forEach var="error" items="${status.errorMessages}"> ${error}</c:forEach> -->
				</spring:bind>
			</p>

			<input type="hidden" name="action" value="login"> <input
				class="btn btn-lg btn-primary btn-block" type="submit"
				value="<spring:message code ="loginf.log_in"/> ">

		</form>
		<footer class="footer">
			<p>&copy; 2017 Gavr, Inc.</p>
		</footer>

	</div>
	<!-- /container -->
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
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