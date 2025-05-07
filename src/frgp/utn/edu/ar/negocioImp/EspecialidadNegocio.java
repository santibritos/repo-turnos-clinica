package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.daoImp.DaoEspecialidad;
import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.negocio.IespecialidadNegocio;

public class EspecialidadNegocio implements IespecialidadNegocio{

	@Autowired
	@Qualifier("beanDaoEspecialidad")
	private IdaoEspecialidad dao;
	
	
	public EspecialidadNegocio()
	{
	}

	public boolean Add(Especialidad esp) {
		// TODO Auto-generated method stub
		return dao.Add(esp);
	}

	public Especialidad ReadOne(int id) {
		// TODO Auto-generated method stub
		return dao.ReadOne(id);
	}

	public List<Especialidad> ReadAll() {
		// TODO Auto-generated method stub
		return dao.ReadAll();
	}

	public boolean Exist(String aux) {
		// TODO Auto-generated method stub
		return dao.Exist(aux);
	}

	public IdaoEspecialidad getDao() {
		return dao;
	}

	public void setDao(IdaoEspecialidad dao) {
		this.dao = dao;
	}

}
