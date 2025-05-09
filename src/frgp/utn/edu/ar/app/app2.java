
package frgp.utn.edu.ar.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import frgp.utn.edu.ar.daoImp.DaoTurno;
import frgp.utn.edu.ar.entidades.Horario;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.resources.Config;

public class app2 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		Date date1 = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-YY");
		
		
		
		date1 = java.sql.Date.valueOf("2000-12-05");
		
		System.out.println(date1);
		
		date1 =simpledateformat.parse("18-05-2000");
		System.out.println(date1);
		
		System.out.println(LocalTime.parse("14:00:00"));
		System.out.println((java.sql.Time.valueOf("11:45:00")));
		
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		Medico m = (Medico) appContext.getBean("beanMedico");
    	MedicoNegocio mneg = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
    	
    	m = mneg.ReadOne(2222);
    	System.out.println("-------------------------------");
    	for(Horario med: m.getListaHorarios())
    	{
    		System.out.println(med);
    	}
    	System.out.println("-------------------------------");
    	
    	System.out.println(m.getListaHorarios());
    	
    	Turno t = (Turno) appContext.getBean("beanTurno");
    	DaoTurno dt = (DaoTurno) appContext.getBean("beanDaoTurno");
    	
    	List<Turno> lista = (List<Turno>) dt.traerPorFechaYmedico(java.sql.Date.valueOf("2024-11-11"),m);
    	
    	int i = 0;
    	for(Turno reg : lista)
    	{
    		System.out.println("turno:"+i);
    			System.out.println(reg.toString());
    			i++;
    	}
    	
    	
    	
		
    	((ConfigurableApplicationContext)(appContext)).close();
	}

}
