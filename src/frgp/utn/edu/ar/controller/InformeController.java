package frgp.utn.edu.ar.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class InformeController {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	 Paciente p = (Paciente)appContext.getBean("beanPaciente");
	 PacienteNegocio pneg = (PacienteNegocio)appContext.getBean("beanPacienteNegocio");
	 
	 
/*	 @RequestMapping("graficos.html")
	 @ResponseBody
	    public String mostrarGraficos() {
	        // Simulamos datos desde backend (ejemplo)
	        List<String> dias = Arrays.asList("Lunes", "Martes", "Miércoles");
	        List<Integer> turnos = Arrays.asList(5, 8, 3);

	        model.addAttribute("labels", dias);
	        model.addAttribute("data", turnos);

	        return "graficos"; // graficos.jsp
	    }*/
}
