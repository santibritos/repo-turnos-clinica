<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css" />

<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
</head>
<body>
<%@include file="clienteSideBar.jsp"%>
<div class="main-content">
	<h1 class="contenedor"> Workplace</h1>
	
	<div class="columnas-workplace">
		<div class="contenedor cards uno">
			
			<c:forEach items="${listaTurnos}" var="turno">
				<div class="card fondoCard colorAzul">
					<div class="card-content uno infoTurno">
						<label>${turno.hora}</label><br>
						<label>${turno.paciente.nombre} ${turno.paciente.apellido}</label>
					</div>
					<a type="text" class="btn btnAzul btnCard dos" name="txtId" href="cargarTurnoActual.html?id=${turno.id}">Cargar</a>
				</div>
				
			</c:forEach>
			
		</div>
		
		
		<div class="contenedor">
		
		
		
		<div>
		<c:if test="${turnoActual != null}">
		<form action="guardarObservacion.html" method="get">
			<table class="tabla">
				<thead>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Dni</th>
				</thead>
				<tbody>
					<tr>
						<td>${turnoActual.paciente.nombre}</td>
						<td>${turnoActual.paciente.apellido}</td>
						<td>${turnoActual.paciente.dni}</td>
					</tr>
				</tbody>
			</table>
			<div class="fondoAzul"><label class="contentLabel" for="taHistoria">Historia Clinica</label></div>
			<textarea id="taHistoria"></textarea><br>
			
				<div class="fondoAzul fondo100">
					<label class="contentLabel" for="taObservacion">Observacion</label>
				</div>
				<textarea id="taObservacion" name="taObservacion"></textarea><br><br>
					<div class="botonera">
					<input type="text" id="turnoActualId" name="turnoActualId"  value="${turnoActual.id}">
						<input type="submit" class="btn btnAzul bmediano" value="Guardar">
						<a href="cargarWorkplace.html" class="btn btnRojo bmediano">Cancelar</a>
					</div>				
			</form>
						
			</c:if>
			<c:if test="${mensajeExito == true}">
					Guardado Con exito.
			</c:if>
		</div>
		
		</div>




	</div>
</div>
</body>
</html>