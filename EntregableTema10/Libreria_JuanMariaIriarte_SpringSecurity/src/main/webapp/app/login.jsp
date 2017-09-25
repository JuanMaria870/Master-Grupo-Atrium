<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/static/imagenes/libro.png" />

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/signin.css">

<title><spring:message code="libreria" /></title>


</head>

<body>

	<div class="container">

		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading"><spring:message
						code="init.sesion" /></h2>
			<label for="inputEmail" class="sr-only"><spring:message
						code="nombre" /></label> 
			<input	type="text" name="user" id="user" class="form-control" placeholder="<spring:message
						code="nombre" />"	required autofocus> 
			<label for="inputPassword"		class="sr-only"><spring:message
						code="password" /></label> 
			<input type="password" name="password"	id="password" class="form-control" placeholder="<spring:message
						code="password" />" required>
			
			<div class="checkbox">
				<label> <input type="checkbox" name="remember-me" value="<spring:message
						code="remember.me" />">
					<spring:message
						code="remember.me" />
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				<spring:message code="entrar" />
			</button>
		</form>
	</div>

</body>
</html>


<script>
	(function() {
		'use strict'

		if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
			var msViewportStyle = document.createElement('style')
			msViewportStyle.appendChild(document
					.createTextNode('@-ms-viewport{width:auto!important}'))
			document.head.appendChild(msViewportStyle)
		}

	}())
</script>