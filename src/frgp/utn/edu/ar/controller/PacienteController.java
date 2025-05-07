package frgp.utn.edu.ar.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.resources.Config;

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
    	p.setNombre(txtNombre);
    	p.setApellido(txtApellido);
    	p.setDni(txtDni);
    	p.setCorreo_electronico(txtEmail);
    	p.setTelefono(txtTelefono);
    	p.setDireccion(txtDireccion);
    	p.setLocalidad(txtLocalidad);
    	p.setFecha_nacimiento(java.sql.Date.valueOf(txtNacimiento));
    	p.setEstado(true);
    	
    	neg.Add(p);
    	mav.setViewName("abmlPacientes");
    	List<Paciente> listaPacientes = neg.ReadAll();
    	mav.addObject("listaPacientes",listaPacientes);
    	return mav;
    }
}
