<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Control de calificaciones alumnos</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Alumno</h3>
	
		<form:form action="saveAlumno" modelAttribute="alumno" method="POST"> <!-- Este va conectado al saveAlumno del controlador -->

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="apellido" /></td>
					</tr>

					<tr>
						<td><label>Grupo:</label></td>
						<td><form:input path="grupo" /></td>
					</tr>
					
					<tr>
						<td><label>Calificacion:</label></td>
						<td><form:input path="calificacion" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/alumno/list">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>










