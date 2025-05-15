package frgp.utn.edu.ar.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Horario;
import frgp.utn.edu.ar.entidades.HorarioDTO;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.MedicoDTO;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.resources.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TurnoController {
	
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	 Turno t = (Turno)appContext.getBean("beanTurno");
	 TurnoNegocio neg = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
	 
	 Paciente p = (Paciente)appContext.getBean("beanPaciente");
	 PacienteNegocio pneg = (PacienteNegocio)appContext.getBean("beanPacienteNegocio");
	 
	 Medico m = (Medico)appContext.getBean("beanMedico");
     MedicoNegocio mneg = (MedicoNegocio)appContext.getBean("beanMedicoNegocio");
     
     Especialidad e = (Especialidad)appContext.getBean("beanEspecialidad");
     EspecialidadNegocio eneg = (EspecialidadNegocio)appContext.getBean("beanEspecialidadNegocio");
   
	
	@RequestMapping("turnos.html")
	public ModelAndView turnos(ModelAndView mav)
	{
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.setViewName("abmlTurnos");
		return mav;
	}
	
	@RequestMapping("altaTurno.html")
	public ModelAndView altaTurno(ModelAndView mav)
	{
		List <Especialidad> especialidades = eneg.ReadAll();
    	mav.addObject("especialidades",especialidades);
		
		List<Medico> listaMedicos = mneg.ReadAll();
		
	
	/*	 List<MedicoDTO> medicoDTOs = new ArrayList<>();

		 for (Medico medico : listaMedicos) {
		     List<HorarioDTO> horariosDTO = new ArrayList<>();

		     for (Horario horario : medico.getListaHorarios()) {
		    	 int idHorario = horario.getId();
		         String diaNombre = horario.getDia().getDia(); // ej: "Lunes"
		         String entradaStr = horario.getEntrada() != null ? horario.getEntrada().toString().substring(0, 5) : null;
		         String salidaStr = horario.getSalida() != null ? horario.getSalida().toString().substring(0, 5) : null;

		         horariosDTO.add(new HorarioDTO(idHorario,diaNombre, entradaStr, salidaStr));
		     }

		     MedicoDTO dto = new MedicoDTO(
		         medico.getLegajo(),
		         medico.getNombre(),
		         medico.getApellido(),
		         horariosDTO
		     );

		     medicoDTOs.add(dto);
		 }
		 
		 
		 	try {
			ObjectMapper mapper = new ObjectMapper();
	        String medicosJson = mapper.writeValueAsString(medicoDTOs);
	        mav.addObject("medicosJson",medicosJson);
		}catch(Exception e) {
			System.out.println("HUBO ERROR------------");
			e.printStackTrace();
			 mav.addObject("medicosJson",null);
		}
		
		
		 */
		 
		 
		 mav.addObject("listaMedicos",listaMedicos);
		 
		
		mav.setViewName("agregarTurno");
		return mav;
	}
	
	@RequestMapping(value="altaTurno2.html", method=RequestMethod.POST)
	public ModelAndView altaTurno2(ModelAndView mav, String txtDni, String txtLegajo, String txtFecha, String txtHora)
	{
		System.out.println(txtHora);
		System.out.println(txtFecha);
		t.setMedico(mneg.ReadOne(Integer.parseInt(txtLegajo)));
		t.setPaciente(pneg.ReadOne(txtDni));
		t.setFecha(java.sql.Date.valueOf(txtFecha));
		t.setHora(java.sql.Time.valueOf(txtHora+":00"));
		t.setEstado("pendiente");
		neg.Add(t);
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.setViewName("abmlTurnos");
		return mav;
	}
	
	@RequestMapping(value="bajaTurno{id}.html", method= RequestMethod.GET)
	public ModelAndView bajaTurno( ModelAndView mav, @PathVariable int id)
	{
		neg.Delete(neg.ReadOne(id));
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.setViewName("abmlTurnos");
		return mav;
	}
	
	@RequestMapping(value="modificarTurno{id}.html", method= RequestMethod.GET)
	public ModelAndView modificarTurno(ModelAndView mav, @PathVariable int id)
	{
		mav.addObject("turno",neg.ReadOne(id));
		mav.setViewName("modificarTurno");
		return mav;
	}
	@RequestMapping("modificarTurno2.html")
	public ModelAndView modificarTurno2(ModelAndView mav, int txtId, String txtFecha, String txtHora)
	{
		t = neg.ReadOne(txtId);
		t.setFecha(java.sql.Date.valueOf(txtFecha));
		t.setHora(java.sql.Time.valueOf(txtHora+":00"));
		neg.Update(t);
		mav.addObject("listaTurnos",neg.ReadAll());
		mav.setViewName("abmlTurnos");
		return mav;
	}
	
	@RequestMapping(value = "verificarTurnosmedico{id}fecha{fecha}.html", method = RequestMethod.GET, produces ="application/json")
	@ResponseBody
	public List<String> obtenerTurnosOcupados(
			@PathVariable int medicoId,
	        @PathVariable String fechaStr) {

		System.out.println("--------- EN CONTROLLER POR FECHA Y MEDICO --------- ");
		
	    List<Turno> turnos = neg.traerPorFechaYmedico(java.sql.Date.valueOf(fechaStr), mneg.ReadOne(medicoId));

	    List<String> respuesta = new ArrayList<>();
	    
	    for (Turno t : turnos) {
	    	
	        respuesta.add(t.getHora().toString().substring(0,5));
	    }
	    
	    for(String fila : respuesta)
	    {
	    	System.out.println(fila);
	    }
	    return respuesta;

	}
	
	@RequestMapping(value="pruebaFetch.html",method=RequestMethod.GET)
	@ResponseBody
	public Boolean pruebaFetch()
	{
		System.out.println("dentro del backend en el controller ---------------------");
		System.out.println("dentro del backend en el controller ---------------------");
		System.out.println("dentro del backend en el controller ---------------------");
		
		return true;
	}
	
	@RequestMapping(value="cargarWorkplace.html", method= RequestMethod.GET)
	public ModelAndView turnosCliente(ModelAndView mav, HttpSession session)
	{
		System.out.println("en cargar workplace controller");
		Medico medico = (Medico) session.getAttribute("medico");
		System.out.println("MEDICO EN EL SESSION:"+medico.toString());
		mav.addObject("listaTurnos",neg.traerPorFechaYmedico(java.sql.Date.valueOf(LocalDate.now()),medico));
		
		mav.setViewName("vistaCliente");
		return mav;
	}
}
