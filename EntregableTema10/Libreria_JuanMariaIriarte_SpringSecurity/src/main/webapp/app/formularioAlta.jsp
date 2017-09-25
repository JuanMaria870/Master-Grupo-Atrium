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
		<sf:form action="alta" method="POST" modelAttribute="formLibro">
			<div class="form-group">
				<sf:label path="titulo" class="form">
					<spring:message code="alta_titulo" />
				</sf:label>
				<spring:message code="alta_titulo" var="placeholder_titulo" />
				<sf:input path="titulo" class="form-control" placeholder='${placeholder_titulo}'/>
				<sf:errors path="titulo" class="error"/>
				<br>
			</div>

			<div class="form-group">
				<sf:label path="descripcion" class="form">
					<spring:message code="alta_descripcion" />
				</sf:label>
				<spring:message code="alta_descripcion" var="placeholder_descripcion" />
				<sf:input path="descripcion" class="form-control" placeholder='${placeholder_descripcion}'/>
				<sf:errors path="descripcion" class="error"/>
				<br>
			</div>

			<div class="form-group">
				<sf:label path="editorial" class="form">
					<spring:message code="alta_editorial" />
				</sf:label>
				<spring:message code="alta_editorial" var="placeholder_editorial" />
				<sf:input path="editorial" class="form-control" placeholder='${placeholder_editorial}'/>
				<sf:errors path="editorial" class="error"/>
				<br>
			</div>

			<div class="form-group">
				<sf:label path="precio" class="form">
					<spring:message code="alta_precio" />
				</sf:label>
				<spring:message code="alta_precio" var="placeholder_precio" />
				<sf:input path="precio" class="form-control" placeholder='${placeholder_precio}' onkeypress="return validaNumeroYPunto(event)" maxlength="7"/>
				<sf:errors path="precio" class="error"/>
				<br>
			</div>

			<input type="submit" class="btn btn-primary"
				value='<spring:message code="boton_alta" />' />

		</sf:form>

	</div>
</body>
</html>