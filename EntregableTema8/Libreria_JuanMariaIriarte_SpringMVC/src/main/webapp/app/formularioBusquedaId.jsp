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
		<sf:form action="buscarPorId" method="POST"
			modelAttribute="criteriaLibroBusquedaId">
			<div class="form-group">
				<sf:label path="id" class="form">
					<spring:message code="buscar_id" />
				</sf:label>
				<spring:message code="buscar_id" var="placeholder_id" />
				<sf:input path="id" class="form-control" placeholder='${placeholder_id}' onkeypress="return valida(event)" maxlength="6"/>
				<sf:errors path="id" class="error"/>
				<br>
			</div>


			<input type="submit" class="btn btn-primary"
				value='<spring:message code="boton_buscar" />' />

		</sf:form>
	</div>
</body>
</html>