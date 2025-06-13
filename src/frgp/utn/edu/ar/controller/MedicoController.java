package frgp.utn.edu.ar.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Dia;
import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Horario;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.DiaNegocio;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;
import frgp.utn.edu.ar.util.Validador;


@Controller
public class MedicoController {
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	 Medico m = (Medico)appContext.getBean("beanMedico");
     MedicoNegocio neg = (MedicoNegocio)appContext.getBean("beanMedicoNegocio");
     Especialidad e = (Especialidad)appContext.getBean("beanEspecialidad");
     EspecialidadNegocio eneg = (EspecialidadNegocio)appContext.getBean("beanEspecialidadNegocio");
     Usuario u = (Usuario)appContext.getBean("beanUsuario");
     UsuarioNegocio uneg = (UsuarioNegocio)appContext.getBean("beanUsuarioNegocio");
     
     Dia d = (Dia)appContext.getBean("beanDia");
     DiaNegocio dneg = (DiaNegocio) appContext.getBean("beanDiaNegocio");
     
     
     Horario h1 = (Horario)appContext.getBean("beanHorario");
     Horario h2 = (Horario)appContext.getBean("beanHorario");
     Horario h3 = (Horario)appContext.getBean("beanHorario");
     Horario h4 = (Horario)appContext.getBean("beanHorario");
     Horario h5 = (Horario)appContext.getBean("beanHorario");
     
     List<Horario>listaHorarios = null;
     
     @RequestMapping("Medicos.html")
     public ModelAndView cargar(ModelAndView mav)
     {
    	 List<Medico> lista = neg.ReadAll();
    	 mav.addObject("listaMedicos",lista);
    	 mav.setViewName("abmlMedicos");
    	 return mav;
     }
     
     @RequestMapping("AgregarMedico.html")
     public ModelAndView agrega(ModelAndView mav)
     {
    	List <Especialidad> especialidades = eneg.ReadAll();
    	mav.addObject("especialidades",especialidades);
    	 mav.setViewName("agregarMedico");
    	 return mav;
     }
     
     @RequestMapping(value="NuevoMedico.html", method = RequestMethod.POST)
     public ModelAndView agregarMedico(ModelAndView mav, String txtNombre, String txtApellido, String txtTelefono, String txtEmail, String
    		 txtDireccion, String txtLocalidad, int txtLegajo, int txtEspecialidad, String txtUsuario, String txtPassword,String txtPassword2,
    		 String cbLunes, String cbMartes, String cbMiercoles, String cbJueves, String cbViernes,
    		 String tLunes1, String tLunes2, String tMartes1, String tMartes2, String tMiercoles1, String tMiercoles2,
    		 String tJueves1, String tJueves2, String tViernes1, String tViernes2) 
     {
    	 
    	 Validador v = new Validador();
    	 
    	 List<String> alertas = v.validarMedicoNuevo(txtNombre, txtApellido, txtTelefono, txtEmail, txtLegajo, txtPassword, txtPassword2);
    	 
    	 if(alertas.isEmpty())
    	 {
    		 // creo el usuario primero
        	 u.setUsuario(txtUsuario);
        	 u.setPassword(txtPassword);
        	 uneg.Add(u);
        	 
        	 System.out.println("<<<<<<<<<<<<<<<<<< ----- EN CREAR MEDICO ------------- >>>>>");
        	 System.out.println("Lunes "+tLunes1+" "+tLunes2+ "Martes "+tMartes1+" "+tMartes2+" Miercoles "+tMiercoles1+" "+tMiercoles2+" Jueves "
        	 +tJueves1+" "+tJueves2+ "Viernes "+tViernes1+" "+tViernes2);
        	 
        	 // se lo paso al nuevo medico
        	 m.setUsuario(u);
        	 m.setNombre(txtNombre);
        	 m.setApellido(txtApellido);
        	 m.setLegajo(txtLegajo);
        	 m.setEspecialidad(eneg.ReadOne(txtEspecialidad));
        	 m.setCorreoElectronico(txtEmail);
        	 m.setTelefono(txtTelefono);
        	 m.setLocalidad(txtLocalidad);
        	 m.setDireccion(txtDireccion);
        	 //m.setHorario(txtHorario);
        	 m.setEstado(true);
        	 
        	 if(cbLunes != null) 
        	 {
        		 try
        		 {
        			 h1.setEntrada(Time.valueOf(tLunes1+":00"));
            		 h1.setSalida(Time.valueOf(tLunes2+":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tLunes1);
        		 }
        		 
        	 }
        	 if(cbMartes != null) 
        	 {
        		 try
        		 {
        			 h2.setEntrada(Time.valueOf(tMartes1+=":00"));
            		 h2.setSalida(Time.valueOf(tMartes2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tMartes1);
        			 System.out.println(tMartes2);
        		 }
        		
        	 }
        	 if(cbMiercoles != null) 
        	 {
        		 try
        		 {
        			 h3.setEntrada(Time.valueOf(tMiercoles1+=":00"));
            		 h3.setSalida(Time.valueOf(tMiercoles2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tMiercoles1);
        			 System.out.println(tMiercoles2);
        		 }
        	 }
        	 if(cbJueves != null) 
        	 {
        		 try
        		 {
        			 h4.setEntrada(Time.valueOf(tJueves1+=":00"));
            		 h4.setSalida(Time.valueOf(tJueves2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tJueves1);
        			 System.out.println(tJueves2);
        		 }
        	 }
        	 if(cbViernes != null) 
        	 {
        		 try
        		 {
        			 h5.setEntrada(Time.valueOf(tViernes1+=":00"));
            		 h5.setSalida(Time.valueOf(tViernes2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tViernes1);
        			 System.out.println(tViernes2);
        		 }
        	 }
        	 
        	 
    		 h1.setDia(dneg.readOne(1));
    		 h2.setDia(dneg.readOne(2));
    		 h3.setDia(dneg.readOne(3));
    		 h4.setDia(dneg.readOne(4));
    		 h5.setDia(dneg.readOne(5));
        	 
        	 listaHorarios = new ArrayList<Horario>();
        	 
        	 listaHorarios.add(h1);
        	 listaHorarios.add(h2);
        	 listaHorarios.add(h3);
        	 listaHorarios.add(h4);
        	 listaHorarios.add(h5);
        	 
        	 m.setListaHorarios(listaHorarios);
        	 
        	 neg.Add(m);
        	 
        	 List<Medico> lista = neg.ReadAll();
        	 mav.addObject("listaMedicos",lista);
         	 mav.setViewName("abmlMedicos");
    	 }else
    	 {
    		 List <Especialidad> especialidades = eneg.ReadAll();
    	    	mav.addObject("especialidades",especialidades);
    		 mav.addObject("alertas",alertas);
    		 mav.setViewName("agregarMedico");
    	 }
    	 return mav;
     }
     @RequestMapping(value="modificarMedico{legajo}.html", method = RequestMethod.GET)
     public ModelAndView modificarM(ModelAndView mav, @PathVariable int legajo)
     {
    	 List <Especialidad> especialidades = eneg.ReadAll();
    	 mav.addObject("especialidades",especialidades);
    	 mav.addObject("medico",neg.ReadOne(legajo));
    	 mav.setViewName("modificarMedico");
    	 return mav;
     }
     
     @RequestMapping(value="modificarMedico2.html")
     public ModelAndView probarcosa(ModelAndView mav,String txtNombre, String txtApellido, String txtTelefono, String txtEmail, String
    		 txtDireccion, String txtLocalidad, int txtLegajo, int txtEspecialidad, String txtUsuario, String txtPassword,String txtPassword2,
    		 String cblunes, String cbmartes, String cbmiercoles, String cbjueves, String cbviernes,
    		 String tlunes1, String tlunes2, String tmartes1, String tmartes2, String tmiercoles1, String tmiercoles2,
    		 String tjueves1, String tjueves2, String tviernes1, String tviernes2) 
     {
    	 Validador v = new Validador();
    	 
    	 List<String> alertas = v.validarMedico(txtNombre, txtApellido, txtTelefono, txtEmail, txtLegajo, txtPassword, txtPassword2);
    	 
    	 if(alertas.isEmpty())
    	 {
    		 u.setUsuario(txtUsuario);
        	 u.setPassword(txtPassword);
        	 uneg.Update(u);
        	 
        	 System.out.println("<<<<<<<<<<<<<<<<<< ----- EN MODIFICAR MEDICO ------------- >>>>>");
        	 System.out.println("Lunes "+tlunes1+" "+tlunes2+ "Martes "+tmartes1+" "+tmartes2+" Miercoles "+tmiercoles1+" "+tmiercoles2+" Jueves "
        	 +tjueves1+" "+tjueves2+ "Viernes "+tviernes1+" "+tviernes2);
        	 
        	 m.setUsuario(u);
        	 m.setNombre(txtNombre);
        	 m.setApellido(txtApellido);
        	 m.setLegajo(txtLegajo);
        	 m.setEspecialidad(eneg.ReadOne(txtEspecialidad));
        	 m.setCorreoElectronico(txtEmail);
        	 m.setTelefono(txtTelefono);
        	 m.setLocalidad(txtLocalidad);
        	 m.setDireccion(txtDireccion);
        	// m.setHorario(txtHorario);
        	 m.setEstado(true);
        	 
        	 if(cblunes != null) 
        	 {
        		 try
        		 {
        			 h1.setEntrada(Time.valueOf(tlunes1+":00"));
            		 h1.setSalida(Time.valueOf(tlunes2+":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tlunes1);
        		 }
        		 
        	 }
        	 if(cbmartes != null) 
        	 {
        		 try
        		 {
        			 h2.setEntrada(Time.valueOf(tmartes1+=":00"));
            		 h2.setSalida(Time.valueOf(tmartes2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tmartes1);
        			 System.out.println(tmartes2);
        		 }
        		
        	 }
        	 if(cbmiercoles != null) 
        	 {
        		 try
        		 {
        			 h3.setEntrada(Time.valueOf(tmiercoles1+=":00"));
            		 h3.setSalida(Time.valueOf(tmiercoles2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tmiercoles1);
        			 System.out.println(tmiercoles2);
        		 }
        	 }
        	 if(cbjueves != null) 
        	 {
        		 try
        		 {
        			 h4.setEntrada(Time.valueOf(tjueves1+=":00"));
            		 h4.setSalida(Time.valueOf(tjueves2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tjueves1);
        			 System.out.println(tjueves2);
        		 }
        	 }
        	 if(cbviernes != null) 
        	 {
        		 try
        		 {
        			 h5.setEntrada(Time.valueOf(tviernes1+=":00"));
            		 h5.setSalida(Time.valueOf(tviernes2+=":00"));
        		 }catch(IllegalArgumentException e)
        		 {
        			 System.out.println(tviernes1);
        			 System.out.println(tviernes2);
        		 }
        	 }
        	
        	 h1.setDia(dneg.readOne(1));
    		 h2.setDia(dneg.readOne(2));
    		 h3.setDia(dneg.readOne(3));
    		 h4.setDia(dneg.readOne(4));
    		 h5.setDia(dneg.readOne(5));
        	 
        	 listaHorarios = new ArrayList<Horario>();
        	 
        	 listaHorarios.add(h1);
        	 listaHorarios.add(h2);
        	 listaHorarios.add(h3);
        	 listaHorarios.add(h4);
        	 listaHorarios.add(h5);
        	 
        	 m.setListaHorarios(listaHorarios);
        	
        	 neg.Update(m);
        	 
        	 List<Medico> lista = neg.ReadAll();
        	 mav.addObject("listaMedicos",lista);
        	 mav.setViewName("abmlMedicos");
    	 }else {
    		 
    		 mav.addObject("alertas",alertas);
    		 List <Especialidad> especialidades = eneg.ReadAll();
        	 mav.addObject("especialidades",especialidades);
        	 mav.addObject("medico",neg.ReadOne(txtLegajo));
        	 mav.setViewName("modificarMedico");
    	 }
    	 return mav;
     }
     
     @RequestMapping(value="bajaMedico{legajo}")
     public ModelAndView bajaMedico(ModelAndView mav,@PathVariable int legajo)
     {
    	 List<Medico> lista = neg.ReadAll();
    	 mav.addObject("listaMedicos",lista);
    	 neg.Delete(neg.ReadOne(legajo));
    	 mav.setViewName("abmlMedicos");
    	 return mav;
     }
}
