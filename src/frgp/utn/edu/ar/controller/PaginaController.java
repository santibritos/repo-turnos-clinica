package frgp.utn.edu.ar.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PaginaController {
	
	
	@RequestMapping("redireccionar.html")
	public ModelAndView eventoRedireccionar(String nombre,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		String id = session.getId();
		session.setAttribute("identidad", id);
		session.setAttribute("edad", 10);
		session.setAttribute("nombre", nombre);
		mv.addObject("session1",session);
		mv.setViewName("adminSideBar");
		return mv;
	}
	@RequestMapping("redireccionarLogin.html")
	public ModelAndView traerLogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("traerFile2.html")
	public ModelAndView traerFile2(ModelAndView mav)
	{
		mav.setViewName("file2");
		return mav;
	}
	
	@RequestMapping("abmlMedicos.html")
	public ModelAndView abmlMedicos(ModelAndView mav)
	{
		mav.setViewName("abmlMedicos");
		return mav;
	}
	
	@RequestMapping("modificarNombre.html")
	public ModelAndView modificarNombre(ModelAndView mav, HttpSession session)
	{
		session.setAttribute("nombre", "MODIFICADO");
		mav.setViewName("file2");
		return mav;
	}

}
