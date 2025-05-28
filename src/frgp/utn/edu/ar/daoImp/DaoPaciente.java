package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;

public class DaoPaciente implements IdaoPaciente {

	private ConfigHibernate conexion ;
	
	public DaoPaciente() {
		
	}
	
	public DaoPaciente(ConfigHibernate conexion) {
		this.conexion = conexion;
	}
	
	
	public ConfigHibernate getConexion() {
		return conexion;
	}

	public void setConexion(ConfigHibernate conexion) {
		this.conexion = conexion;
	}

	public boolean Add(Paciente paciente) {
		
		boolean estado = true;
	    conexion = new ConfigHibernate();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        

	        session.save(paciente);
	        session.flush();
	        session.getTransaction().commit();
	        Paciente savedPaciente = (Paciente) session.get(Paciente.class,paciente.getNombre() );
	        
	        if (savedPaciente == null) {
	            estado = false;
	        }
	        
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    	conexion.cerrarConexion();
	    }
	    
	    return estado;
	}

	public boolean Exist(String dniPaciente) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente = (Paciente)session.get(Paciente.class, dniPaciente);
		if (paciente!=null) {
			conexion.cerrarConexion();
			return true;
		}
		conexion.cerrarConexion();
		return false;
	}
	
	public Paciente ReadOne(String dniPaciente) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		System.out.println("en dao");
		try {
			session.beginTransaction();
			Paciente aux = (Paciente)session.get(Paciente.class, dniPaciente);	
			return aux;
		} catch(Exception e) {
			System.out.println("Error al buscar el paciente.");
			return null;
		} finally {
			config.cerrarConexion();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> Readall() {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<Paciente> pacientes = session.createQuery("FROM Paciente WHERE estado = true").list();
		conexion.cerrarConexion();
		return pacientes;
	}

	public boolean Delete(Paciente m) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {	 
			session.beginTransaction();		
			session.update(m);
			session.flush();
			session.getTransaction().commit();	
			System.out.println("paciente borrado.");
			config.cerrarConexion();
			return true;
		} catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
				System.out.println("Error al borrar el paciente.");
			}
			
			config.cerrarConexion();
			return false;
		} 
	}

	public boolean Update(Paciente m) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {	 
			session.beginTransaction();		
			session.update(m);			
			session.getTransaction().commit();	
			System.out.println("Se ha modificado el paciente");
			return true;
		} catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			
			System.out.println("Error al modificar el medico.");
			return false;
		} finally
		{
			config.cerrarConexion();
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> traerPorMedico(Medico medico) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		List<Paciente> lista = null;
		
		try
		{
			String hql = "SELECT DISTINCT t.paciente FROM Turno t where t.medico.legajo = :medicoId and t.paciente.estado = true";
			Query query = session.createQuery(hql);
			query.setParameter("medicoId", medico.getLegajo());
			lista = (List<Paciente>) query.list();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

}
