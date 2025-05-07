package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoDia;
import frgp.utn.edu.ar.entidades.Dia;

public class DaoDia implements IdaoDia{
	
	
	
	@Override
	public Boolean add(Dia dia) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		try {
			session.beginTransaction();
			session.save(dia);
			session.getTransaction().commit();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			ch.cerrarConexion();
		}
	}

	@Override
	public Dia readOne(int id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try 
		{
			session.beginTransaction();
			Dia dia = (Dia)session.get(Dia.class, id);
			return dia;
		}catch(Exception e) 
		{
			e.printStackTrace();
			return null;
		}finally
		{
			ch.cerrarConexion();
		}
		
	}

	@Override
	public List<Dia> readAll() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		try
		{
			session.beginTransaction();
			List<Dia> lista = (List<Dia>) session.createQuery("FROM dia").list();
			
			for(Dia dia : lista)
			{
				System.out.println(dia);
			}
			return lista;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
