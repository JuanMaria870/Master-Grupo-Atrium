<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="index.jsp" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="libreria" /></title>
</head>
<body>
	<div id="padre">
		<sf:form action="buscarPorTitulo" method="POST"
			modelAttribute="criteriaLibroBusquedaTitulo">
			<div class="form-group">

				<sf:label path="titulo" class="form">
					<spring:message code="buscar_titulo" />
				</sf:label>
				<spring:message code="buscar_titulo" var="buscar_titulo" />
				<sf:input path="titulo" class="form-control" placeholder='${buscar_titulo}' />
				<sf:errors path="titulo" class="error"/>
				<br>
			</div>

			<input type="submit" class="btn btn-primary" value='<spring:message code="boton_buscar" />' />

		</sf:form>
	</div>
</body>
</html>