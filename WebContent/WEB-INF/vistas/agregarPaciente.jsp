<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto Clinica</title>
</head>
<body>
<%@include file="adminSideBar.jsp"%>


<div class="main-content">
<h1 class="contenedor">Agregar Paciente</h1>
<div class="contenedor">
	<form action="altaPaciente2.html" method="post">

	<fieldset>
		<legend>Datos Personales</legend>
		<br>
				<label>DNI</label>
			<input type="text" name="txtDni" class="txt" >
			<label>Nombre</label>
			<input type="text" name="txtNombre" class="txt" >
			<label>Apellido</label>
			<input type="text" name="txtApellido" class="txt">
			<label>Fecha de Nacimiento:</label>
			<input id="datePaciente" type="date" name="txtNacimiento" class="txt" >
			<label>Correo Electronico</label>
			<input  type="Email" name="txtEmail" class="txt" >
			<label>telefono:</label>
			<input type="text" name="txtTelefono" class="txt" >
			<label>Direccion</label>
			<input type="text" name="txtDireccion" class="txt" >
			<label>Localidad:</label>
			<input type="text" name="txtLocalidad" class="txt" >
	</fieldset>
		<div class="botonera">
		<br>
		<input class ="btn btnAzul bmediano" type="submit" value="Agregar"><a href="Pacientes.html" class="btn btnRojo bmediano">Cancelar</a>
		</div>
	</form>
		</div>
	</div>
</body>
</html>