package frgp.utn.edu.ar.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.resources.Config;
import frgp.utn.edu.ar.util.Validador;

@Controller
public class PacienteController {
	
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	 Paciente p = (Paciente)appContext.getBean("beanPaciente");
    PacienteNegocio neg = (PacienteNegocio)appContext.getBean("beanPacienteNegocio");
    
    
  
    
    @RequestMapping("Pacientes.html")
    public ModelAndView pacientes(ModelAndView mav)
    {
    	List<Paciente> listaPacientes = neg.ReadAll();
    	
    	mav.addObject("listaPacientes",listaPacientes);
    	mav.setViewName("abmlPacientes");
    	return mav;
    }
    
    @RequestMapping(value="modificarPaciente{dni}.html", method= RequestMethod.GET)
    public ModelAndView modificarPaciente(ModelAndView mav, @PathVariable String dni)
    {
    	mav.addObject("paciente",neg.ReadOne(dni));
    	mav.setViewName("modificarPaciente");
    	return mav;
    }
    
    @RequestMapping(value="modificarPaciente2.html", method=RequestMethod.POST)
    public ModelAndView modificarPaciente2(ModelAndView mav, String txtDni, String txtNombre, String txtApellido,
    		String txtEmail, String txtTelefono, String txtDireccion, String txtLocalidad, String txtNacimiento)
    {
    	p.setNombre(txtNombre);
    	p.setApellido(txtApellido);
    	p.setDni(txtDni);
    	p.setCorreo_electronico(txtEmail);
    	p.setTelefono(txtTelefono);
    	p.setDireccion(txtDireccion);
    	p.setLocalidad(txtLocalidad);
    	p.setFecha_nacimiento(java.sql.Date.valueOf(txtNacimiento));
    	p.setEstado(true);
    	neg.Update(p);
    	
    	mav.setViewName("abmlPacientes");
    	List<Paciente> listaPacientes = neg.ReadAll();
    	mav.addObject("listaPacientes",listaPacientes);
    	return mav;
    }
    
    @RequestMapping(value="bajaPaciente{dni}.html",method= RequestMethod.GET)
    public ModelAndView bajaPaciente(ModelAndView mav, @PathVariable String dni)
    {
    	neg.Delete(neg.ReadOne(dni));
    	
    	List<Paciente> listaPacientes = neg.ReadAll();
    	mav.addObject("listaPacientes",listaPacientes);
    	mav.setViewName("abmlPacientes");
    	return mav;
    }
    
    @RequestMapping("altaPaciente.html")
    public ModelAndView altaPaciente(ModelAndView mav)
    {
    	mav.setViewName("agregarPaciente");
    	return mav;
    }
    
    @RequestMapping(value="altaPaciente2.html", method= RequestMethod.POST)
    public ModelAndView altaPaciente2(ModelAndView mav, String txtDni, String txtNombre, String txtApellido,
    		String txtEmail, String txtTelefono, String txtDireccion, String txtLocalidad, String txtNacimiento)
    {
    	Validador v = new Validador();
    	
    	List<String> alertas = v.validarPacienteNuevo(txtDni, txtNombre, txtApellido, txtTelefono, txtEmail);
    	
    	if(alertas.isEmpty())
    	{
    		p.setNombre(txtNombre);
        	p.setApellido(txtApellido);
        	p.setDni(txtDni);
        	p.setCorreo_electronico(txtEmail);
        	p.setTelefono(txtTelefono);
        	p.setDireccion(txtDireccion);
        	p.setLocalidad(txtLocalidad);
        	p.setFecha_nacimiento(java.sql.Date.valueOf(txtNacimiento));
        	p.setEstado(true);
        	
        	try {
        		neg.Add(p);
        		mav.setViewName("abmlPacientes");
            	List<Paciente> listaPacientes = neg.ReadAll();
            	mav.addObject("listaPacientes",listaPacientes);
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
    	}else
    	{
    		mav.addObject("alertas",alertas);
    		mav.setViewName("agregarPaciente");
    	}
    	return mav;
    }
	@RequestMapping("misPacientes.html")
	public ModelAndView misPacientes(ModelAndView mav,HttpSession session)
	{
		Medico medico = (Medico) session.getAttribute("medico");
		try
		{
			List<Paciente> lista = neg.traerPorMedico(medico);
			mav.addObject("listaPacientes",lista);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		mav.setViewName("misPacientes");
		return mav;
	}
	
}
