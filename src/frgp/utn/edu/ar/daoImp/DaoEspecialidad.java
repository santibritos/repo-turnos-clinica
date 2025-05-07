package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.entidades.Especialidad;

public class DaoEspecialidad implements IdaoEspecialidad{

	public boolean Add(Especialidad esp) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
		        
			session.beginTransaction();						
			session.save(esp);			
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

	public Especialidad ReadOne(int id) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		try {
			session.beginTransaction();
			Especialidad aux = (Especialidad)session.get(Especialidad.class, id);	
			return aux;
		} catch(Exception e) {
			System.out.println("Error al buscar la especialidad.");
			return null;
		} finally {
			config.cerrarConexion();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Especialidad> ReadAll() {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
	
		List<Especialidad> lista = (List<Especialidad>) session.createQuery("FROM Especialidad").list();
		
		System.out.println("READ ALL ESPECIALIDAD ------");
	    for (Especialidad reg : lista) {
	    	
	    		System.out.println(reg.toString());
	    	
		}
	    config.cerrarConexion();
	    return lista;
	}

	public boolean Exist(String aux) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Especialidad reg = (Especialidad)session.get(Especialidad.class, aux);
		if (reg !=null) {
			System.out.println("existe");
			ch.cerrarConexion();
			return true;
		}
		ch.cerrarConexion();
		System.out.println("no existe");
		return false;
	}

}
