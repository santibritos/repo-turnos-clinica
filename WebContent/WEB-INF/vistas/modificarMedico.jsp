<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Medico</title>
<style>

</style>

</head>
<body>
<%@ include file="adminSideBar.jsp" %>
<div class="main-content">

	<h1 class="contenedor">Modificar Medico</h1>
	
	<div class="contenedor">
		<form action="modificarMedico2.html" method="post">

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
			<label>Nombre</label>
			<input required type="text" name="txtNombre" class="txt" value="${medico.nombre}">
			<label>Apellido</label>
			<input required type="text" name="txtApellido" class="txt" value="${medico.apellido}">
			<label>Correo Electronico</label>
			<input required type="Email" name="txtEmail" class="txt" value="${medico.correoElectronico}">
			<label>telefono:</label>
			<input required type="text" name="txtTelefono" class="txt" value="${medico.telefono}">
			<label>Direccion</label>
			<input required type="text" name="txtDireccion" class="txt" value="${medico.direccion}">
			<label>Localidad:</label>
			<input required type="text" name="txtLocalidad" class="txt" value="${medico.localidad}">
	</fieldset>
		<br>
		<fieldset>
			<legend>Datos Profesionales</legend>
			<br>
			<label>Legajo</label>
			<input required type="text" name="txtLegajo" class="txt" value="${medico.legajo}">
			<label>Especialidad:</label>
			<select required id="sEspecialidades" name="txtEspecialidad">
				<c:forEach items="${especialidades}" var="especialidad" >
					<option value="${especialidad.id}">
						${especialidad.nombre}
					</option>
				</c:forEach>
			</select>
		</fieldset>
		<br>
			<fieldset>
		<legend>Horario</legend>
			<div>
			<c:forEach items="${medico.listaHorarios}" var="horario">
				<label for="cb${horario.dia}">${horario.dia}:</label>
				<input <c:if test="${horario.entrada != null}">checked</c:if> onclick="habilitarCb('${horario.dia}')" type="checkbox" id="cb${horario.dia}" name="cb${horario.dia}"  value="'${horario.dia}'">
				<label>Llegada: </label><input type="time" name="t${horario.dia}1" id="t${horario.dia}1" value="${horario.entrada}">
				<label>Salida:</label><input type="time" name="t${horario.dia}2" id="t${horario.dia}2" value="${horario.salida}"><br>
			</c:forEach>
			</div>
		</fieldset>
		<br>
		<fieldset>
                <legend>Información de Cuenta</legend>
                <label for="username">Nombre de Usuario</label>
                <input required type="text" name="txtUsuario" required class="txt" value="${medico.usuario.usuario}"/>

                <label for="password">Contraseña</label>
                <input required type="password" class="txt" name="txtPassword" required value="${medico.usuario.password}"/>
                 <label for="password">Repetir Contraseña</label>
                <input required type="password" class="txt" name="txtPassword2" required value="${medico.usuario.password}" />
            </fieldset>
		<div class="botonera">
		<br>
		<input class="btn btnAzul bmediano" type="submit" value="Agregar"><a href="Medicos.html" class="btn btnRojo bmediano">Cancelar</a>
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
<script>
// carga la especialidad del medico a modificar en el select
let especialidades = document.getElementById("sEspecialidades");


for(let i=0; especialidades.length;i++)
  {
    console.log(especialidades[i]);
      if(especialidades[i].value == '<c:out value="${medico.especialidad.id}" />')
      {
        especialidades[i].defaultSelected = true;
      }
  }	
</script>
<script>
// script para habilitar o desabilitar la seleccion de horas en base al valor de los checkbox
	function habilitarCb(dia)
	{
		const checkbox = document.getElementById('cb'+dia);
		const entrada = document.getElementById('t'+dia+'1');
		const salida = document.getElementById('t'+dia+'2');
		
		 const estaMarcado = checkbox.checked;
		
		if (estaMarcado) {
	        // Si el checkbox está marcado, habilita los campos de hora
	        entrada.disabled = false;
	        salida.disabled = false;
	    } else {
	        // Si no está marcado, deshabilita los campos de hora
	        entrada.disabled = true;
	        salida.disabled = true;
	    }
		
	}
	
	window.onload = function ()
	{
		  <c:forEach var="horario" items="${medico.listaHorarios}">
		  habilitarCb('${horario.dia}');
      </c:forEach>
	}

</script>
</body>
</html>