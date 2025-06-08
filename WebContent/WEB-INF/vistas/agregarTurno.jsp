<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Turno</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css" />

<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>

<style>
	
</style>

	<script type="text/javascript">

$(document).ready( function () {
    $('#tabla').DataTable();
} );

</script>
</head>
<body>
<%@include file="adminSideBar.jsp"%>

<div class="main-content">
	<h1 class="contenedor">Agregar Turno</h1>
	
<div class="poner-columnas"> 
	<div class="contenedor uno">
		<form action="altaTurno2.html" method="post">
	
		<fieldset>
			<legend>Datos del Turno</legend>
			<br>
				<label>Dni del Paciente:</label>
				<input required type="text" name="txtDni" class="txt" >
				<label>Legajo del Medico:</label>
				<input required readonly type="text" id="txtLegajo" name="txtLegajo" class="txt" >
				<label>Fecha del turno:</label>
				<input required id="datePaciente" type="date" name="txtFecha" class="txt" >
				<label>Hora del turno: </label>
				<input hidden type="time" name="txtHora" id="txtHora" class="txt" >
				<div id="div-horas" class="botonesHoras"> </div>
			<br>
			<div class="botonera">
			<br>
			<br>
			<input class="btn btnAzul bmediano" type="submit" value="Agregar"><a href="turnos.html" class="btn btnRojo bmediano">Cancelar</a>
			</div>
			</fieldset>
		</form>
			</div>
			<!-- guardo los datos de los horarios -->
			<c:forEach var="medico" items="${listaMedicos}">
				  <div class="horarios-medico" data-id="${medico.legajo}" style="display: none;">
				    <c:forEach var="horario" items="${medico.listaHorarios}">
				      <div 
				        class="horario" 
				        data-dia="${horario.dia.dia}" 
				        data-entrada="${fn:substring(horario.entrada, 0, 5)}" 
				        data-salida="${fn:substring(horario.salida, 0, 5)}">
				      </div>
				    </c:forEach>
				  </div>
			</c:forEach>
			
			<div class="contenedor dos">
					<fieldset >
							<legend>Buscar Medico</legend>
							<br>
								<select onchange="ajustarMedicos()" id="sEspecialidades" name="sEspecialidades">
									 <option value="">-- Todas las especialidades --</option>
									<c:forEach items="${especialidades}" var="especialidad">
										<option id="o${especialidad.id}" value="${especialidad.id}">${especialidad.nombre}</option>
									</c:forEach>
								</select>
							<br>
									<table id="tabla" class="display" style=" max-height: 700px;">
				   				 <thead>
				      					  <tr>
				          			<th>Legajo</th>
									<th>Nombre</th>
									<th>Apellido</th>
									<th style="width: 200px">Horarios</th>
									<th>Elegir</th>
				      					 </tr>
				   					 </thead>
				  						  <tbody id="tMedicos">
				  						  
				     							<c:forEach items="${listaMedicos}" var="medico">
				     								<c:if test="${medico.estado == true}">
				     						<tr data-especialidad="${medico.especialidad.id}">
				     								<td>${medico.legajo}</td>
							         			    <td>${medico.nombre}</td>
							          			  <td>${medico.apellido}</td>
							   
							     			       <td>
							   			         <c:forEach items="${medico.listaHorarios}" var="horario">
							      			     <c:if test="${horario.entrada != null}">
							   				      ${horario.dia}:<br>${horario.entrada}-${horario.salida}<br>
							       			     </c:if>
							          		  </c:forEach>
							       			     </td>
											   	<td>
					               				      <input class="btn btnAzul bchico" type=submit value="Elegir" onclick="elegir('${medico.legajo}')">
					                  		    </td>
				     						</tr>
				     								</c:if>
				     							</c:forEach>
				   						 </tbody>
									</table>
					</fieldset>
			</div>
	</div>
	
</div>	
	



	<script>
			
			function ajustarMedicos()
			{
				const especialidades = document.getElementById('sEspecialidades').value;
				const filas = document.querySelectorAll('#tMedicos tr');
				
				
				filas.forEach(fila =>{
					
					const idEspecialidadFila = fila.dataset.especialidad;
					const mostrar = (especialidades === "" || idEspecialidadFila === especialidades); // aca si se cumple una de las dos condiciones da true a mostrar, el false es implicito
					  fila.style.display = mostrar ? "" : "none"; //  condicion ? devuelve si verdadero : devuelve si falso;
				});
			}
			
			function elegir(legajo)
			{
				let txtLegajo = document.getElementById('txtLegajo');
				
				txtLegajo.value = legajo;		
				
			}
			
			function obtenerHorariosMedico(legajo) {
				  const contenedor = document.querySelector( ".horarios-medico[data-id='"+legajo+"']");
				 
				  const horarios = [];

				  if (contenedor) {
				    const bloques = contenedor.querySelectorAll('.horario');
				    bloques.forEach(bloque => {
				      horarios.push({
				        dia: bloque.dataset.dia,
				        entrada: bloque.dataset.entrada,
				        salida: bloque.dataset.salida
				      });
				    });
				  }
				  return horarios;
				}
			
			function borrarAnterior(){
				const anterior = document.getElementsByClassName('btnVerde');
				if(anterior.length > 0){
					anterior[0].classList.add('btnAzul');
					anterior[0].classList.remove('btnVerde');
				}
			}
			
			function seleccionarHora(valor)
			{
				borrarAnterior();
				const txt = document.getElementById('txtHora');
				const elegido = document.getElementById('btn'+valor);
				
				elegido.classList.remove("btnAzul");
				elegido.classList.add('btnVerde');
				
				txt.value = valor;
				
			}
			
			function crearBotones(entrada, salida)
			{
				const contenedor = document.getElementById('div-horas');
				
				contenedor.innerHTML = '';
				
				
				const inicio = new Date("2025-01-01T"+entrada+":00");
				const fin = new Date("2025-01-01T"+salida+":00");
				
				while(inicio < fin)
					{
						const hora = inicio.getHours().toString().padStart(2,"0");
						const minutos = inicio.getMinutes().toString().padStart(2,"0");
						const valor = hora+":"+minutos;
						
						const boton = document.createElement('button');
						
					
						boton.type = "button";
					    boton.textContent = valor;
					    boton.value = valor;
					   
					    	boton.onclick = () =>seleccionarHora(valor);
					    	 boton.classList.add('btn','btnAzul'); // Por si querés estilos

					    //boton.classList.add('btn','btnAzul'); // Por si querés estilos
					    boton.id = "btn"+valor;
					    contenedor.appendChild(boton);
					    inicio.setMinutes(inicio.getMinutes()+10);
					}
				
			}
			
			// para detectar el cambio de fecha y dar los horarios correctos
			const input = document.getElementById("datePaciente");

			input.addEventListener("change", () => {
				
			  const fechaStr = input.value;	
			  const fecha = new Date(fechaStr);

			  const dias = [ "lunes", "martes", "miercoles", "jueves", "viernes", "sábado","domingo"];
			  const nombreDia = dias[fecha.getDay()];
			  
			  // traigo el id del medico
			  const txtLegajo = document.getElementById('txtLegajo');
			  
				if (!txtLegajo.value) {
			        alert("Primero debe elegir un médico.");
			        return;
			    }

			  // los horarios del medico
			  const horarios = obtenerHorariosMedico(txtLegajo.value);
				

			  
			  horarios.forEach(horario =>{
				  console.log('HORARIO DIA:'+ horario.dia);
					if(horario.dia === nombreDia)
					{
						crearBotones(horario.entrada, horario.salida);
					}
			  });
			

			  
				fetch('verificarTurnosMedico.html?medicoId='+txtLegajo.value+'&fechaStr='+fechaStr)
				.then(response => response.text()) // Ojo: .text() porque devolvés un string
				  .then(data => {
				    console.log("Respuesta cruda:", data);
				    
				    // Si querés transformarlo a array:
				   const turnosOcupados = JSON.parse(data.replaceAll("'", '"')); // por si devuelve con comillas simples
				 	
				   	turnosOcupados.forEach(turno =>{
				   		
				 		let btn = document.getElementById('btn'+turno);
				 		btn.classList.remove('btnAzul');
				 		btn.classList.add('btnRojo');
				 		btn.disabled = true;
				   	});
				  })
				  .catch(error => console.error('Error:', error));
			
			});
			
	</script>

</body>
</html>