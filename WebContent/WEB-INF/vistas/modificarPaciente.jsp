<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Paciente</title>
</head>
<body>
	<%@ include file="adminSideBar.jsp" %>
	<div class="main-content">
		<h1 class="contenedor">Modificar Paciente</h1>
		
		<div class="contenedor">
			<form action="modificarPaciente2.html" method="post">
	
				<fieldset>
				<c:if test="${alertas!=null}">
					<div class="alerta" id="alerta">
						<c:forEach items="${alertas}" var="alerta">
						<label id="labelAlerta" class="uno">${alerta}</label>
						</c:forEach>
						<button type="button" onclick="cerrarAlerta()" class="btnAlerta">x</button>
					</div>
				</c:if>
					<legend>Datos Personales</legend>
					<br>
						<label>DNI</label>
						<input required type="text" name="txtDni" class="txt" value="${paciente.dni}">
						<label>Nombre</label>
						<input required type="text" name="txtNombre" class="txt" value="${paciente.nombre}">
						<label>Apellido</label>
						<input required type="text" name="txtApellido" class="txt" value="${paciente.apellido}">
						<label>Fecha de Nacimiento:</label>
						<input required id="datePaciente" type="date" name="txtNacimiento" class="txt" value="<fmt:formatDate value='${paciente.fecha_nacimiento}' pattern='yyyy-MM-dd'/>">
						<label>Correo Electronico</label>
						<input required type="Email" name="txtEmail" class="txt" value="${paciente.correo_electronico}">
						<label>telefono:</label>
						<input required type="text" name="txtTelefono" class="txt" value="${paciente.telefono}">
						<label>Direccion</label>
						<input required type="text" name="txtDireccion" class="txt" value="${paciente.direccion}">
						<label>Localidad:</label>
						<input required type="text" name="txtLocalidad" class="txt" value="${paciente.localidad}">
				</fieldset>
					<div class="botonera">
					<br>
					<input class="btn btnAzul bmediano" type="submit" value="Agregar"><a href="Pacientes.html" class="btn btnRojo bmediano">Cancelar</a>
					</div>
			</form>
		</div>
	
	</div>
	
<script>
	function cerrarAlerta()
	{
		const alerta = document.getElementById('alerta');
		alerta.style.display = 'none';
	}
	</script>	
</body>
</html>