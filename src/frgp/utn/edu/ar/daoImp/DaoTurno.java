package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoTurno;
import frgp.utn.edu.ar.entidades.Medico;
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
			System.out.println("Se añadio exitosamente.");
			return true;
			
		}catch(Exception e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();				
			}
			ch.cerrarConexion();
			System.out.println("Error al añadir.");
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
	public List<Turno> readAllFrom(Medico medico) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		List<Turno> lista = (List<Turno>) session.createQuery("FROM Turno WHERE medico.legajo ="+medico.getLegajo()).list();
		
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


}
