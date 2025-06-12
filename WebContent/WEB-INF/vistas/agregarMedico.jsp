<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Medico</title>
</head>
<body>

<%@include file="adminSideBar.jsp"%>


<div class="main-content">
<h1 class="contenedor">Agregar Medico</h1>
<div class="contenedor">
	<form action="NuevoMedico.html" method="post">

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
			<input required type="text" name="txtNombre" class="txt">
			<label>Apellido</label>
			<input required type="text" name="txtApellido" class="txt">
			<label>Correo Electronico</label>
			<input required type="Email" name="txtEmail" class="txt">
			<label>telefono:</label>
			<input required type="text" name="txtTelefono" class="txt">
			<label>Direccion</label>
			<input required type="text" name="txtDireccion" class="txt">
			<label>Localidad:</label>
			<input required type="text" name="txtLocalidad" class="txt">
	</fieldset>
		<br>
		<fieldset>
			<legend>Datos Profesionales</legend>
			<br>
			<label>Legajo</label>
			<input required type="number" name="txtLegajo" class="txt">
			<label>Especialidad:</label>
			<select required name="txtEspecialidad">
				<c:forEach items="${especialidades}" var="especialidad" >
					<option value="${especialidad.id}">
						${especialidad.nombre}
					</option>
				</c:forEach>
			</select>		
		</fieldset>
		<br>
			<fieldset class="horario">
		<legend>Horario</legend>
			<div>
			<label class="label-horario" for="rbLunes">Lunes:</label>
			<input type="checkbox" id="cblunes" name="cblunes" onclick="habilitarCb('lunes')" value="lunes">
			<label class="label-horario" >Llegada: </label><input type="time" name="tLunes1" id="tlunes2"><label>Salida: </label><input type="time" name="tLunes2" id="tlunes1"><br>
			<label class="label-horario" for="cbMartes">Martes:</label>
			<input type="checkbox" id="cbmartes" name="cbmartes" onclick="habilitarCb('martes')" value="Martes">
			<label class="label-horario">Llegada: </label><input type="time"  name="tMartes1" id="tmartes1"><label>Salida: </label><input type="time" name="tMartes2" id="tmartes2"><br>
			<label class="label-horario" for="cbMiercoles">Miercles:</label>
			<input type="checkbox" id="cbmiercoles" name="cbmiercoles"  onclick="habilitarCb('miercoles')" value="Miercoles">
			<label class="label-horario">Llegada: </label><input type="time" name="tMiercoles2" id="tmiercoles1"><label>Salida:</label><input type="time" name="tMiercoles2" id="tmiercoles2"><br>
			<label class="label-horario" for="cbJueves">Jueves:</label>
			<input type="checkbox" id="cbjueves" name="cbjueves" onclick="habilitarCb('jueves')" value="Jueves">
			<label class="label-horario">Llegada: </label><input type="time" name="tJueves1" id="tjueves1"><label>Salida: </label><input type="time" name="tJueves2" id="tjueves2"><br>
			<label class="label-horario" for="cbViernes">Viernes:</label>
			<input type="checkbox" id="cbviernes" name="cbviernes" onclick="habilitarCb('viernes')" value="Viernes">
			<label class="label-horario">Llegada: </label><input type="time" id="tviernes1" name="tViernes2"><label>Salida: </label><input type="time" id="tviernes2" name="tViernes2"><br>
			</div>
		</fieldset>
		<br>
		<fieldset>
                <legend>Información de Cuenta</legend>
                <label for="username">Nombre de Usuario</label>
                <input required type="text" name="txtUsuario" required class="txt"/>

                <label for="password">Contraseña</label>
                <input required type="password" class="txt" name="txtPassword" required />
                <label for="password">Repetir Contraseña</label>
                <input required type="password" class="txt" name="txtPassword2" required />
            </fieldset>
            <br>
		<div class="botonera">
			<input type="submit" class="btn btnAzul bmediano" value="Agregar"><a href="Medicos.html" class="btnRojo btn bmediano">Cancelar</a>
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
// script para habilitar o desabilitar la seleccion de horas en base al valor de los checkbox
	function habilitarCb(dia)
	{
		const checkbox = document.getElementById('cb'+dia);
		const entrada = document.getElementById('t'+dia+'1');
		const salida = document.getElementById('t'+dia+'2');
		
		console.log(checkbox);
		console.log(entrada);
		console.log(salida);
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
		const dias = [];
		
		dias.push('lunes','martes','miercoles','jueves','viernes')
		
		dias.forEach(dia =>
		{
			const t1 = document.getElementById('t'+dia+'1');
			const t2 = document.getElementById('t'+dia+'2');
			
			t1.disabled = true;
			t2.disabled = true;
		});
	}

</script>
</body>
</html>