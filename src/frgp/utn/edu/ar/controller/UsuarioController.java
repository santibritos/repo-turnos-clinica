package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class UsuarioController {
	
	
	
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	Usuario u = (Usuario)appContext.getBean("beanUsuario");


	UsuarioNegocio neg = (UsuarioNegocio)appContext.getBean("beanUsuarioNegocio");
	
	
	@RequestMapping("login.html")
	public ModelAndView login(String name, String pass, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		
		System.out.println("en el controller ---------------------------------------");
		if(neg.Exist(name)==true)
		{
			System.out.println("existeee");
			u.setUsuario(name);
			u.setPassword(pass);
			
			
			Usuario aux = neg.ReadOne(name);
			if(u.equals(aux)==true&& aux.getPermiso().equals("admin"))
			{
					session.setAttribute("user",aux);
					mav.addObject("session",session);
					mav.setViewName("abmlMedicos");
					
			}else
			{
				if(u.equals(aux)==true&& aux.getPermiso().equals("cliente"))
				{
					session.setAttribute("medico", aux.getMedico());
					session.setAttribute("user",aux);
					mav.addObject("session",session);
					mav.setViewName("workplace");
				}
				else
				{
					mav.setViewName("index");
				}
			}
		
		}else
		{
			mav.setViewName("index");
		}
		
		return mav;
	}
	

}
