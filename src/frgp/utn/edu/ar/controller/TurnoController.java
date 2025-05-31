package frgp.utn.edu.ar.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.fasterxml.jackson.core.JsonProcessingException;
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
   
     
 	@RequestMapping(value = "verificarTurnosMedico.html", method = RequestMethod.GET)
 	@ResponseBody
 	public String obtenerTurnosOcupados(@RequestParam("medicoId") int medicoId, @RequestParam("fechaStr") String fechaStr) throws JsonProcessingException {

 		System.out.println("--------- EN CONTROLLER POR FECHA Y MEDICO --------- ");
 		System.out.println("--------- EN CONTROLLER POR FECHA Y MEDICO --------- ");
 		System.out.println("--------- EN CONTROLLER POR FECHA Y MEDICO --------- ");
 		System.out.println("--------- EN CONTROLLER POR FECHA Y MEDICO --------- ");
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
 	    return new ObjectMapper().writeValueAsString(respuesta);

 	}
 	
	
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
		
		
		
		mav.setViewName("workplace");
		return mav;
	}
	@RequestMapping(value="cargarTurnoActual.html", method= RequestMethod.GET)
	public ModelAndView cargarTurnoActual(ModelAndView mav, HttpSession session,@RequestParam("id") Integer txtId)
	{
		List<Turno> lista = null;
		Turno t = null;
		Medico medico = null;
		String historiaClinica = null;
		try {
			 t = neg.ReadOne(txtId);
			 medico = (Medico) session.getAttribute("medico");
			lista  = neg.traerPorFechaYmedico(java.sql.Date.valueOf(LocalDate.now()),medico);
			
			historiaClinica = neg.traerHistoriaClinica(medico, t.getPaciente());
			System.out.println("historia clinica en controller: "+historiaClinica);
			
			int i = 0;
			int remover = 9999;
			for(Turno reg : lista)
			{
				System.out.println(reg.toString());
				if(reg.getId() == t.getId())
				{
					System.out.println("Encontro el turno actual en la lista");
					remover = i;
				}
				i++;
			}
				lista.remove(remover);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("historiaClinica",historiaClinica);
		mav.addObject("turnoActual",t);
		mav.addObject("listaTurnos",lista);
		
		mav.setViewName("workplace");
		return mav;
	}
	
	@RequestMapping(value="guardarObservacion.html", method= RequestMethod.GET)
	public ModelAndView guardarObservacion(ModelAndView mav, HttpSession session, Integer turnoActualId, String taObservacion)
	{
		List<Turno> lista = null;
		Turno t = null;
		Medico medico = null;
		
		try {
			 t = neg.ReadOne(turnoActualId);
			 t.setObservacion(taObservacion);
			 t.setEstado("completado");
			 medico = (Medico) session.getAttribute("medico");
			 neg.Update(t);
			 lista  = neg.traerPorFechaYmedico(java.sql.Date.valueOf(LocalDate.now()),medico);
			 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		mav.addObject("mensajeExito",true);
		mav.addObject("listaTurnos",lista);
		mav.setViewName("workplace");
		
		return mav;
	}
	
	@RequestMapping(value="traerHistoriaClinica.html", method=RequestMethod.GET)
	@ResponseBody
	public String traerHistoriaClinica(@RequestParam("medicoId") Integer medicoId, @RequestParam("pacienteId") String pacienteId)
	{
		String respuesta ="No se encontro historia clinica";
		
		try
		{
			respuesta = neg.traerHistoriaClinica(mneg.ReadOne(medicoId), pneg.ReadOne(pacienteId));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	@SuppressWarnings("null")
	@RequestMapping("informe.html")
	public ModelAndView informe(ModelAndView mav) throws JsonProcessingException
	{
		List<String> especialidades = new ArrayList<>();
		List<Long> turnos = new ArrayList<>();
		try
		{
			List<Object[]> lista = neg.turnosPorEspecialidadYfecha(java.sql.Date.valueOf("2025-05-09"),java.sql.Date.valueOf(LocalDate.now()));
			
			for(Object[] row : lista)
			{
				especialidades.add((String) row[1]);
				turnos.add((Long) row[0]);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
			/*List<String> dias = Arrays.asList("Lunes", "Martes", "Miercoles");
	        List<Integer> turnos = Arrays.asList(5, 8, 3);*/
			
	        ObjectMapper mapper = new ObjectMapper();
	        mav.addObject("labels", mapper.writeValueAsString(especialidades));
	        mav.addObject("data",  mapper.writeValueAsString(turnos));
		mav.setViewName("informe");
		return mav;
	}
}
