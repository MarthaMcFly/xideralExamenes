<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Control de calificaciones alumnos</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: "Add Customer" ESTE ES EL BOTON -->
			<input type="button" value="Agregar Alumno"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th> <!-- Se cambio First Name -->
					<th>Apellido</th> <!-- Se cambio Last Name -->
					<th>Grupo</th>
					<th>Calificacion</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempAlumno" items="${customers}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/alumno/showFormForUpdate">
						<c:param name="customerId" value="${tempAlumno.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/alumno/delete">
						<c:param name="customerId" value="${tempAlumno.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempAlumno.nombre} </td> <!-- Se cambio firstName -->
						<td> ${tempAlumno.apellido} </td> <!-- Se cambio lastName -->
						<td> ${tempAlumno.grupo} </td>
						<td> ${tempAlumno.calificacion} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Cambiar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estás seguro de que quieres eliminar al alumno?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









