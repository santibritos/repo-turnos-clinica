package frgp.utn.edu.ar.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.resources.Config;

public class Validador {

	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	 Turno t = (Turno)appContext.getBean("beanTurno");
	 TurnoNegocio neg = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
	 
	 Paciente p = (Paciente)appContext.getBean("beanPaciente");
	 PacienteNegocio pneg = (PacienteNegocio)appContext.getBean("beanPacienteNegocio");
	 
	 Medico m = (Medico)appContext.getBean("beanMedico");
    MedicoNegocio mneg = (MedicoNegocio)appContext.getBean("beanMedicoNegocio");
    
    Especialidad e = (Especialidad)appContext.getBean("beanEspecialidad");
    EspecialidadNegocio eneg = (EspecialidadNegocio)appContext.getBean("beanEspecialidadNegocio");
	
	public String validarDni(String dni)
	{
		 String regex = "[0-9]+";

 	    if (!dni.matches(regex)) {
 	        return "Dni no v·lido";
 	    }
 	    
 	    return pneg.Exist(dni) ? "existe" : "El paciente no existe en la base de datos";
	}
	public String validarDniNuevo(String dni)
		{
		 String regex = "[0-9]+";
 	        return dni.matches(regex) ? "valido": "Dni no v·lido";
 	    }
 	    
	/*
	 * (?:\+54\s?)? = Opcional: cÛdigo internacional argentino, con espacio opcional.

			(?:9\s?)? = Opcional: el 9 usado en celulares.
			
			(?:\d{2,4}) =  CÛdigo de ·rea: puede ser 11, 15, o cualquier otro de 2 a 4 dÌgitos.
			
			\s? = Espacio opcional.
			
			\d{3,4} = Primer bloque del n˙mero local.
			
			\s? = Espacio opcional.
			
			\d{4} = Segundo bloque final.
	 * */
	public String validarTelefono(String telefono)
	{
		String regex ="^(?:\\+54\\s?)?(?:9\\s?)?(?:\\d{2,4})\\s?\\d{3,4}\\s?\\d{4}$";
		
		return telefono.matches(regex) ? "valido" : "telefono no valido";
	}
	
	public String validarEmail(String email)
	{
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(regex) ? "valido" : "email no valido";
	}
	
	public String validarNombre(String nombre)
	{
		String regex = "^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—]{2,}$";
		return nombre.matches(regex) ? "valido" : "nombre no valido";
	}
	public String validarApellido(String apellido)
	{
		String regex = "^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—]{2,}$";
		return apellido.matches(regex) ? "valido" : "apellido no valido";
	}
	
	public String validarMedico(Integer legajo)
	{
		String regex = "^\\d{1,5}$";
		
		if(!legajo.toString().matches(regex))return "legajo no valido";
		
		return mneg.Exist(legajo) ? "valido" : "El medico no existe en la base de datos";
	}
	public String validarMedicoNuevo(Integer legajo)
	{
		String regex = "^\\d{1,5}$";
		
		return (!legajo.toString().matches(regex))? "legajo no valido" : "valido";
	}
	
	public List<String> validarPacienteNuevo(String dni, String nombre, String apellido, String telefono, String email)
	{
		List<String> lista = new ArrayList<String>();
		
		System.out.println(" < <<<<<<<<<<<<<<<< PRUEBA DE LA LISTA DE ALERTAS EN EL VALIDADOR ----------------");
		System.out.println(" < <<<<<<<<<<<<<<<< PRUEBA DE LA LISTA DE ALERTAS EN EL VALIDADOR ----------------");
		System.out.println(lista);
		
		String respuesta = this.validarDniNuevo(dni);
		if (respuesta!="valido") lista.add(respuesta);
		
		respuesta = this.validarNombre(nombre);
		if (respuesta!="valido") lista.add(respuesta);
		
		respuesta = this.validarApellido(apellido);
		if (respuesta!="valido") lista.add(respuesta);
		
		respuesta = this.validarTelefono(telefono);
		if (respuesta!="valido") lista.add(respuesta);
		
		respuesta = this.validarEmail(email);
		if (respuesta!="valido") lista.add(respuesta);
		
		
		return lista;
	}
}
