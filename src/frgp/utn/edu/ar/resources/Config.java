package frgp.utn.edu.ar.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import frgp.utn.edu.ar.daoImp.DaoDia;
import frgp.utn.edu.ar.daoImp.DaoEspecialidad;
import frgp.utn.edu.ar.daoImp.DaoMedico;
import frgp.utn.edu.ar.daoImp.DaoPaciente;
import frgp.utn.edu.ar.daoImp.DaoTurno;
import frgp.utn.edu.ar.daoImp.DaoUsuario;
import frgp.utn.edu.ar.entidades.Dia;
import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Horario;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.DiaNegocio;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.util.Validador;

@Configuration
public class Config {
	

	/*
	//bean validador
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Validador beanValidador()
	{
		Validador v = new Validador();
		return v;
	}
	*/
	///bean de especialidad
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Especialidad beanEspecialidad()
	{
		Especialidad esp = new Especialidad();
		esp.setNombre("default");
		return esp;
	}
	
	// bean Dia
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Dia beanDia()
	{
		Dia d = new Dia();
		return d;
	}
	// bean Horario
		@Bean
		@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
		public Horario beanHorario()
		{
			Horario h = new Horario();
			return h;
		}
	
	// bean medico
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Medico beanMedico()
	{
		Medico m = new Medico();
		return m;
	}
	
	//bean turno
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Turno beanTurno()
	{
		Turno t = new Turno();
		return t;
	}
	// bean usuario
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario beanUsuario()
	{
		Usuario u = new Usuario();
		u.setPermiso("cliente");
		return u;
	}
	
	// bean paciente
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Paciente beanPaciente()
	{
		Paciente p = new Paciente();
		return p;
	}
	// BEAN DAO  DIA
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoDia beanDaoDia()
	{
		DaoDia dao = new DaoDia();
		return dao;
	}
	
	/// BEAN DAO ESPECIALIDAD
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoEspecialidad beanDaoEspecialidad()
	{
		DaoEspecialidad dao = new DaoEspecialidad();
		return dao;
	}
	
	// BEAN DAO MEDICO
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoMedico beanDaoMedico()
	{
		DaoMedico dao = new DaoMedico();
		return dao;
	}
	// BEAN DAO PACIENTE
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoPaciente beanDaoPaciente()
	{
		DaoPaciente dao = new DaoPaciente();
		return dao;
	}
	
	// BEAN DAO TURNO
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoTurno beanDaoTurno()
	{
		DaoTurno dao = new DaoTurno();
		return dao;
	}
	// BEAN DAO USUARIO
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoUsuario beanDaoUsuario()
	{
		DaoUsuario dao = new DaoUsuario();
		return dao;
	}
	
	// BEAN NEGOCIO ESPECIALIDAD
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EspecialidadNegocio beanEspecialidadNegocio()
	{
		EspecialidadNegocio neg = new EspecialidadNegocio();
		return neg;
	}
	// BEAN NEGOCIO MEDICO
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MedicoNegocio beanMedicoNegocio()
	{
		MedicoNegocio neg = new MedicoNegocio();
		return neg;
	}
	// BEAN NEGOCIO TURNO
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TurnoNegocio beanTurnoNegocio()
	{
		TurnoNegocio neg = new TurnoNegocio();
		return neg;
	}
	
	// BEAN NEGOCIO PACIENTE
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PacienteNegocio beanPacienteNegocio()
	{
		PacienteNegocio neg = new PacienteNegocio();
		return neg;
	}
	
	// BEAN NEGOCIO USUARIO
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UsuarioNegocio beanUsuarioNegocio()
	{
		UsuarioNegocio neg = new UsuarioNegocio();
		return neg;
	}
	// BEAN NEGOCIO DIA
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DiaNegocio beanDiaNegocio()
	{
		DiaNegocio neg = new DiaNegocio();
		return neg;
	}
	
}
