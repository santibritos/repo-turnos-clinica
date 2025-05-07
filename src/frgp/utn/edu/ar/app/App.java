package frgp.utn.edu.ar.app;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImp.DaoEspecialidad;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.entidades.Dia;
import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Horario;
import frgp.utn.edu.ar.negocioImp.DiaNegocio;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static String MENSAJE_AGREGADO = "AGREGADO CORRECTAMENTE";
	private final static String MENSAJE_YA_EXISTE = "YA EXISTE EN LA BASE DE DATOS";
	private final static String MENSAJE_LISTADO_TODOS_LOS_PACIENTES = "LA INFORMACIÓN ES: ";
	private final static String MENSAJE_LISTADO_UN_PACIENTE = "LA INFORMACIÓN ES: ";
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
        
        
        
        
        
        EspecialidadNegocio neg = new EspecialidadNegocio();
        
      /*  Especialidad esp = (Especialidad) appContext.getBean("beanEspecialidad");
        
        esp.setNombre("Psiquiatria2");
        
        neg.Add(esp);/**/
        
        // cerrar el appcontext 
        
        
        
        // CARGA DE DATOS 
        
        // DIAS 
        
        Dia d = (Dia)appContext.getBean("beanDia");
        DiaNegocio dNeg = (DiaNegocio)appContext.getBean("beanDiaNegocio");
        
        d.setDia("lunes");
        dNeg.add(d);
        d.setDia("martes");
        dNeg.add(d);
        d.setDia("miercoles");
        dNeg.add(d);
        d.setDia("jueves");
        dNeg.add(d);
        d.setDia("viernes");
        dNeg.add(d);
        d.setDia("sabado");
        dNeg.add(d);
        d.setDia("domingo");
        dNeg.add(d);
        
        // ESPECIALIDADES
        
        Especialidad e = (Especialidad)appContext.getBean("beanEspecialidad");
        EspecialidadNegocio eneg = (EspecialidadNegocio)appContext.getBean("beanEspecialidadNegocio");
        
        e.setNombre("Cardiologia");
        eneg.Add(e);
        e.setNombre("Dermatologia");
        eneg.Add(e);
        e.setNombre("Cirugia General");
        eneg.Add(e);
        e.setNombre("Anestesia");
        eneg.Add(e);
        e.setNombre("Cirugia Plastica");
        eneg.Add(e);
        e.setNombre("Gastroenterologia");
        eneg.Add(e);
        e.setNombre("Hematologia");
        eneg.Add(e);
        e.setNombre("Neurologia");
        eneg.Add(e);
        e.setNombre("Traumatologia");
        eneg.Add(e);
        e.setNombre("Clinica");
        eneg.Add(e);
        
     /*   
        Dia lunes = (Dia) appContext.getBean("beanDia");
        lunes.setDia("Lunes");
        Dia martes = (Dia) appContext.getBean("beanDia");
        martes.setDia("Martes");
        Dia miercoles = (Dia) appContext.getBean("beanDia");
        miercoles.setDia("Mercoles");
        Dia jueves = (Dia) appContext.getBean("beanDia");
        jueves.setDia("Jueves");
        Dia viernes = (Dia) appContext.getBean("beanDia");
        viernes.setDia("Viernes");
        Dia sabado = (Dia) appContext.getBean("beanDia");
        sabado.setDia("Sabado");
        Dia domingo = (Dia) appContext.getBean("beanDia");
        domingo.setDia("Domingo");
        */
        Horario h1 = (Horario)appContext.getBean("beanHorario");
        h1.setDia(dNeg.readOne(1));
        h1.setEntrada(java.sql.Time.valueOf("07:45:00"));
        h1.setSalida(java.sql.Time.valueOf("16:45:00"));
        Horario h2 = (Horario)appContext.getBean("beanHorario");
        h2.setDia(dNeg.readOne(2));
        h2.setEntrada(java.sql.Time.valueOf("07:00:00"));
        h2.setSalida(java.sql.Time.valueOf("11:45:00"));
        List<Horario> listaHorario = new ArrayList<Horario>();
        listaHorario.add(h1);
        listaHorario.add(h2);
       
        Horario h3 = (Horario)appContext.getBean("beanHorario");
        h3.setDia(dNeg.readOne(2));
        h3.setEntrada(java.sql.Time.valueOf("10:45:00"));
        h3.setSalida(java.sql.Time.valueOf("19:45:00"));
        List<Horario> listaHorario2 = new ArrayList<Horario>();
        listaHorario2.add(h1);
        listaHorario2.add(h3);
       
        
    	// USUARIO
    	
    	Usuario u = (Usuario) appContext.getBean("beanUsuario");
    	UsuarioNegocio uneg = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
    	
    	
    	u.setUsuario("a");
    	u.setPassword("a");
    	u.setPermiso("admin");
    	uneg.Add(u);
    	
    	/*u.setMedico(m);
    	u.setUsuario("user1");
    	u.setPassword("123");*/
    	/*uneg.Add(u);*/
    	
        
        // MEDICOS
    	
    	Medico m = (Medico) appContext.getBean("beanMedico");
    	MedicoNegocio mneg = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
    	
    	m.setLegajo(2221);
    	m.setNombre("Homero");
    	m.setApellido("Simpson");
    	m.setTelefono("1199998888");
    	m.setCorreoElectronico("hsimpson@gmail.com");
    	m.setEspecialidad(e);
    	m.setDireccion("Av Siempreviva 742");
    	m.setLocalidad("SpringField");
    	m.setFecha_nacimiento(java.sql.Date.valueOf("1990-11-11"));
    	m.setUsuario(u);
    	m.setListaHorarios(listaHorario);
    	m.setEstado(true);
    	mneg.Add(m);
    	

    	

    	u.setUsuario("user3");
    	u.setPassword("123");
    	u.setPermiso("cliente");
    	uneg.Add(u);
    	
    	m.setLegajo(1234);
    	m.setNombre("Pedro");
    	m.setApellido("Avion");
    	m.setTelefono("1158998899");
    	m.setCorreoElectronico("pedrito1212@gmail.com");
    	m.setEspecialidad(e);
    	m.setDireccion("Peron 500");
    	m.setLocalidad("San Fernando");
    	m.setListaHorarios(listaHorario2);
    	m.setEstado(true);
    	mneg.Add(m);
    	
    	u.setUsuario("user4");
    	u.setPassword("123");
    	u.setPermiso("cliente");
    	uneg.Add(u);
    	
    	m.setLegajo(1235);
    	m.setNombre("Joaquin");
    	m.setApellido("Perez");
    	m.setTelefono("1144775588");
    	m.setCorreoElectronico("JP800@gmail.com");
    	m.setEspecialidad(e);
    	m.setDireccion("Cordero 1488");
    	m.setLocalidad("San Fernando");
    	m.setEstado(true);
    	mneg.Add(m);
    	
    	u.setUsuario("as");
    	u.setPassword("as");
    	u.setPermiso("cliente");
    	uneg.Add(u);
    	
    	m.setLegajo(2222);
    	m.setNombre("Marge");
    	m.setApellido("Simpson");
    	m.setTelefono("1158998899");
    	m.setCorreoElectronico("msimpson@gmail.com");
    	m.setEspecialidad(e);
    	m.setDireccion("Calle Falsa 123");
    	m.setLocalidad("SpringField");
    	m.setUsuario(u);
    	m.setEstado(true);
    	mneg.Add(m);

    	
    	//PACIENTE
    	
    	//ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
    	PacienteNegocio pneg = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
    	Paciente p1 = (Paciente) appContext.getBean("beanPaciente");
    	Paciente p2 = (Paciente) appContext.getBean("beanPaciente");
    	
    	p1.setDni("42589632");
    	p1.setNombre("Pedro");
    	p1.setApellido("Casas");
    	p1.setDireccion("Centenario 2343");
    	p1.setLocalidad("San Isidro");
    	p1.setProvincia("Buenos Aires");
    	p1.setTelefono("1169692323");
    	p1.setFecha_nacimiento(java.sql.Date.valueOf("2000-11-11"));
    	p1.setCorreo_electronico("pedrixrecargado@gmail.com");
    	p1.setEstado(true);
    	pneg.Add(p1);
    	
    	p2.setDni("20789456");
    	p2.setNombre("Juan");
    	p2.setApellido("Perez");
    	p2.setDireccion("Rolon 1478");
    	p2.setLocalidad("Beccar");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1145781212");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("1968-08-07"));
    	p2.setCorreo_electronico("juanjuanjuan@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("40506098");
    	p2.setNombre("Martin");
    	p2.setApellido("Rodriguez");
    	p2.setDireccion("Rolon 555");
    	p2.setLocalidad("Beccar");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1145784455");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("1968-08-17"));
    	p2.setCorreo_electronico("mr11@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("20560560");
    	p2.setNombre("Kevin");
    	p2.setApellido("Benitez");
    	p2.setDireccion("Centenario 3300");
    	p2.setLocalidad("San Isidro");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1162304488");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("1999-09-27"));
    	p2.setCorreo_electronico("keveeeen@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("50698100");
    	p2.setNombre("Maria");
    	p2.setApellido("Perez");
    	p2.setDireccion("Belgrano 1178");
    	p2.setLocalidad("San Fernando");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1158985511");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("2003-08-07"));
    	p2.setCorreo_electronico("maryp@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("46203159");
    	p2.setNombre("Laura");
    	p2.setApellido("Trinidad");
    	p2.setDireccion("Juan B Justo 478");
    	p2.setLocalidad("Beccar");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1145740023");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("2002-03-15"));
    	p2.setCorreo_electronico("trinidad.laura@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("40147258");
    	p2.setNombre("Jose");
    	p2.setApellido("Joestar");
    	p2.setDireccion("Cordero 666");
    	p2.setLocalidad("San Fernando");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1177770077");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("1999-01-06"));
    	p2.setCorreo_electronico("jojo@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("36987677");
    	p2.setNombre("Daniela");
    	p2.setApellido("Hernandez");
    	p2.setDireccion("Lavalle 1578");
    	p2.setLocalidad("San Fernando");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1178990909");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("1995-08-07"));
    	p2.setCorreo_electronico("dh1995@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	
    	p2.setDni("40555331");
    	p2.setNombre("Elme");
    	p2.setApellido("Jor");
    	p2.setDireccion("Corrientes 178");
    	p2.setLocalidad("CABA");
    	p2.setProvincia("Buenos Aires");
    	p2.setTelefono("1155770001");
    	p2.setFecha_nacimiento(java.sql.Date.valueOf("1998-04-07"));
    	p2.setCorreo_electronico("elmer10@gmail.com");
    	p2.setEstado(true);
    	pneg.Add(p2);
    	// TURNOS
    	
    	Turno t = (Turno) appContext.getBean("beanTurno");
    	TurnoNegocio tneg = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
    	
    	
    	
    	t.setEstado("pendiente");
    	t.setFecha(java.sql.Date.valueOf("2024-11-11"));
    	t.setHora(java.sql.Time.valueOf("09:45:00"));
    	t.setMedico(m);
    	t.setPaciente(p1);
    	t.setObservacion("consulta");
    	tneg.Add(t);
    	
    	t.setEstado("pendiente");
    	t.setFecha(java.sql.Date.valueOf("2024-11-11"));
    	t.setHora(java.sql.Time.valueOf("10:45:00"));
    	t.setMedico(m);
    	t.setPaciente(p1);
    	t.setObservacion("consulta");
    	tneg.Add(t);
    	
    	t.setEstado("pendiente");
    	t.setFecha(java.sql.Date.valueOf("2024-11-11"));
    	t.setHora(java.sql.Time.valueOf("10:45:00"));
    	t.setMedico(m);
    	t.setPaciente(p2);
    	t.setObservacion("consulta");
    	tneg.Add(t);
    	
    	
    	
    	// PRUEBA DE ESPECIALIDADES
    	
    	System.out.println("-----PRUEBA DE ESPECIALIDADES----");
    	
    	eneg.ReadAll();
    	
    	System.out.println("READ ONE: "+eneg.ReadOne(e.getId()).toString()); 
    	
    	// PRUEBA DE FUNCIONALIDAD MEDICOS
    	System.out.println("-----PRUEBA DE MEDICOS----");
        mneg.ReadAll();
        
        
        m.setNombre("Manuel");
        mneg.Update(m);
        
        System.out.println("READ ONE: "+mneg.ReadOne(m.getLegajo()).toString()); 
        
        mneg.Delete(m);
        
        mneg.Exist(m.getLegajo());
        
    	// PRUEBA DE PACIENTES 
        System.out.println("-----PRUEBA DE PACIENTES----");
        
        List<Paciente> pacientes = pneg.ReadAll();
        for (Paciente p : pacientes) {
        	System.out.println(MENSAJE_LISTADO_TODOS_LOS_PACIENTES + p.toString());
        }
        
    	
        // PRUEBA DE TURNOS
        System.out.println("-----PRUEBA DE TURNOS----");
       
        tneg.ReadAll();
        
        tneg.Delete(t);
        
        System.out.println("READ ONE: "+tneg.ReadOne(t.getId()).toString()); 
        
        t.setEstado("finalizado");
        tneg.Update(t);
        System.out.println("READ ONE: "+tneg.ReadOne(t.getId()).toString());  
       
        
        
        
        ((ConfigurableApplicationContext)(appContext)).close();
        
    }
}
