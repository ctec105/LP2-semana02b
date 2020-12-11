<!-- IMPORTAR LA LIBRERIA -->
<%@ page import="java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Adjuntar estilos CSS -->
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
</head>
<body>
	<% 
		// Recuperamos los datos que llegan del request
		String vusuario = request.getParameter("usuario");
		String vnombre = (String) request.getAttribute("nombre");
		Date fecnac = (Date)request.getAttribute("fecnac");
	%>
	<table>
		<tr>
			<!--  CABECERA -->
			<td colspan="2" align="center">
				<jsp:include page="cabecera.jsp" />
			</td>
		</tr>
		<tr>
			<!-- MEN� -->
			<td><jsp:include page="menu.jsp" /></td>
			<!--  CUERPO -->
			<td>
				<table class="contorl">
					<tr>
						<td colspan="2">Bienvenido estimado usuario, sus datos son:</td>
					</tr>
					<tr>
						<td>Usuario:</td>
						<td><%= vusuario %></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><%= vnombre %></td>
					</tr>
					<tr>
						<td>Fecha de Nacimiento:</td>
						<td><%= fecnac %></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<!--  PIE DE P�GINA -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" /></td>
		</tr>
	</table>
</body>
</html>