package frgp.utn.edu.ar.daoImp;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoTurno;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;

public class DaoTurno implements IdaoTurno{

	public boolean Add(Turno turno) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
		        
			session.beginTransaction();						
			session.save(turno);			
			session.getTransaction().commit();
			ch.cerrarConexion();
			System.out.println("Se aÃ±adio exitosamente.");
			return true;
			
		}catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			ch.cerrarConexion();
			System.out.println("Error al aÃ±adir.");
			return false;
			
		}
	}

	public Turno ReadOne(int id) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {
			session.beginTransaction();
			Turno aux = (Turno)session.get(Turno.class, id);	
			return aux;
		} catch(Exception e) {
			System.out.println("Error al buscar el turno.");
			return null;
		} finally {
			config.cerrarConexion();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Turno> ReadAll() {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		List<Turno> lista = (List<Turno>) session.createQuery("FROM Turno").list();
		
		System.out.println("READ ALL TURNOS ------");
	    for (Turno reg : lista) {
	    	if(reg.getEstado()!="cancelado")
	    	{
	    		System.out.println(reg.toString());
	    	}
		}
	    config.cerrarConexion();
	    return lista;
	}

	public boolean Exist(String aux) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Turno reg = (Turno)session.get(Turno.class, aux);
		if (reg !=null) {
			System.out.println("existe");
			ch.cerrarConexion();
			return true;
		}
		ch.cerrarConexion();
		System.out.println("no existe");
		return false;
	}

	public boolean Update(Turno turno) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {	 
			session.beginTransaction();		
			session.update(turno);
			session.flush();
			session.getTransaction().commit();	
			System.out.println("Se ha modificado el turno");
			config.cerrarConexion();
			return true;
		} catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			System.out.println("Error al modificar el turno.");
			config.cerrarConexion();
			return false;
		} 
	}

	public boolean Delete(Turno turno) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {	 
			session.beginTransaction();		
			session.update(turno);			
			session.getTransaction().commit();	
			System.out.println("turno borrado.");
			return true;
		} catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			System.out.println("Error al borrar el turno.");
			return false;
		} 
	}

	
	@SuppressWarnings("unchecked")
	public List<Turno> traerPorFechaYmedico(Date fecha, Medico m)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Turno> lista = null;
		
		try
		{	
				String hql = " from Turno t where t.medico.legajo = :medicoId and t.fecha = :fecha and t.estado = :estado";
				Query query = session.createQuery(hql);
				query.setParameter("medicoId", m.getLegajo());
				query.setParameter("fecha", fecha);
				query.setParameter("estado", "pendiente");
			 lista = (List<Turno>) query.list(); 
			return lista;
		}catch(Exception e)
		{
			e.printStackTrace();
			return lista;
		}finally {
			ch.cerrarConexion();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String traerHistoriaClinica(Medico medico, Paciente paciente) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Turno> lista = null;
		
		String respuesta = null;
		
		try
		{
			String hql = "from Turno t where t.medico.legajo = :medicoId and t.paciente.dni = :pacienteId";
			Query query = session.createQuery(hql);
			query.setParameter("medicoId", medico.getLegajo());
			query.setParameter("pacienteId",paciente.getDni());
			 lista = (List<Turno>) query.list(); 
			respuesta ="";
			 for(Turno turno : lista)
			 {
				 respuesta += turno.getFecha().toString() +" \n "+ turno.getObservacion()+"\n ";
			 }
			 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("HISTORIA CLINICA EN EL DAO:"+respuesta);
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> turnosPorEspecialidadYfecha(Date inicio, Date fin) {

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Object[]> lista = null;
		
		try
		{
			String hql = "SELECT COUNT(*) as turnos, e.nombre FROM Turno t join t.medico m join m.especialidad e "
					+ "where t.fecha between :fechaInicio and :fechaFin group by e.nombre";
			Query query = session.createQuery(hql);
			query.setParameter("fechaInicio", inicio);
			query.setParameter("fechaFin", fin);
			lista = (List<Object[]>) query.list();
			
			System.out.println("----- TRAER CANT TURNOS POR ESPECIALIDAD ENTRE FECHAS: "+inicio.toString()+" - "+fin.toString()+" -------");
			for(Object[] row : lista)
			{
				System.out.println(row[0]+" "+row[1]);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> traerPorEspecialidadYaño(Integer year) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Object[]> lista = null;
		
		try
		{
			String hql = "SELECT COUNT(*) as turnos, e.nombre as nombre FROM Turno t join t.medico m join m.especialidad e"
					+ " where year(t.fecha) = :year group by e.nombre ";
			Query query = session.createQuery(hql);
			query.setParameter("year", year);
			lista = (List<Object[]>) query.list();
			
			System.out.println("----- TRAER CANT TURNOS POR ESPECIALIDAD DEL AÑO: "+year+" -------");
			for(Object[] row : lista)
			{
				System.out.println(row[0]+" "+row[1]);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> traerPorEstadoYaño(String estado, Integer year) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Object[]> lista = null;
		
		try 
		{
			String hql = "select count(*), month(t.fecha) from Turno t where year(t.fecha) = :year group by month(t.fecha)";
			Query query = session.createQuery(hql);
			if(estado != "todos")
			{
				hql  = "select count(*), month(t.fecha) as mes from Turno t where year(t.fecha) = :year and t.estado = :estado group by mes";
				query.setParameter("estado", estado);
			}
			
			query.setParameter("year", year);
			
			lista = (List<Object[]>) query.list();
			
			System.out.println("----- TRAER CANT TURNOS POR AÑO AÑO: "+year+" y estado: "+estado);
			for(Object[] row : lista)
			{
				System.out.println(row[0]+" "+row[1]);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}


}
