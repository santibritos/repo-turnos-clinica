<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Turno</title>
</head>
<body>
		<%@ include file="adminSideBar.jsp" %>
	<div class="main-content">
		<h1 class="contenedor">Modificar Turno</h1>
		
		<div clasS="contenedor">
				<form action="modificarTurno2.html" method="post">
			
				<fieldset>
					<legend>Datos del Turno</legend>
					<br>
						<label>Id:</label>
						<input readonly type="text" name="txtId" class="txt" value="${turno.id}">
						<label>Medico:</label>
						<input readonly type="text" name="txtNombre" class="txt" value="${turno.medico.apellido}, ${turno.medico.nombre}">
						<label>Paciente:</label>
						<input readonly type="text" name="txtApellido" class="txt" value="${turno.paciente.apellido}, ${turno.paciente.nombre}">
						<label>Fecha:</label>
						<input id="datePaciente" type="date" name="txtFecha" class="txt" value="<fmt:formatDate value='${turno.fecha}' pattern='yyyy-MM-dd'/>">
						<label>Hora:</label>
						<input  type="time" name="txtHora" class="txt" value="${turno.hora}">
						<label>Estado:</label>
						<input readonly type="text" name="txtTelefono" class="txt" value="${turno.estado}">
				</fieldset>
					<div class="botonera">
					<br>
					<input class="btn btnAzul bmediano" type="submit" value="Agregar"><a href="turnos.html" class="btn btnRojo bmediano">Cancelar</a>
					</div>
				</form>
		</div>
	
	</div>
</body>
</html>