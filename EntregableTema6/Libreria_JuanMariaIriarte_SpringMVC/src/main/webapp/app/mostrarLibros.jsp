<%@page import="com.grupoatrium.modelo.Libro"%>
<%@page import="java.util.List"%>
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
	<%
		List<Libro> lista = (List) request.getAttribute("lista");
	%>
	<div id="padre">
		<table class="table table-hover table-sm">
			<tr class="thead-default">
				<th><spring:message code="id" /></th>
				<th><spring:message code="titulo" /></th>
				<th><spring:message code="descripcion" /></th>
				<th><spring:message code="editorial" /></th>
				<th><spring:message code="precio" /></th>
				<th><spring:message code="comprar" /></th>
			</tr>
			<%
				for (Libro l : lista) {
			%>
			<tr>
				<td scope="row"><%=l.getId_libro()%></td>
				<td><%=l.getTitulo()%></td>
				<td><%=l.getDescripcion()%></td>
				<td><%=l.getEditorial().getNombre()%></td>
				<td><%=l.getPrecio()%> €</td>
				<td><a href="comprar?id=<%=l.getId_libro()%>"> <img
						src="${pageContext.request.contextPath}/static/imagenes/carrito.jpg"
						width="50" height="50">
				</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>