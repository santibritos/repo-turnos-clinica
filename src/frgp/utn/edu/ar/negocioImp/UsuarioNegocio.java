package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocio.IusuarioNegocio;

public class UsuarioNegocio implements IusuarioNegocio{
	
	@Autowired
	@Qualifier("beanDaoUsuario")
	private IdaoUsuario dao;

	public UsuarioNegocio()
	{
		
	}
	
	public UsuarioNegocio(IdaoUsuario dao)
	{
		this.dao = dao;
	}
	public boolean Add(Usuario user) {
		// TODO Auto-generated method stub
		return dao.Add(user);
	}

	public Usuario ReadOne(String legajo) {
		// TODO Auto-generated method stub
		return dao.ReadOne(legajo);
	}

	public List<Usuario> ReadAll() {
		// TODO Auto-generated method stub
		return dao.ReadAll();
	}

	public boolean Exist(String u) {
		// TODO Auto-generated method stub
		return dao.Exist(u);
	}

	public boolean Update(Usuario u) {
		// TODO Auto-generated method stub
		return dao.Update(u);
	}

	public boolean Delete(Usuario u) {
		// TODO Auto-generated method stub
		return dao.Delete(u);
	}

	public IdaoUsuario getDao() {
		return dao;
	}

	public void setDao(IdaoUsuario dao) {
		this.dao = dao;
	}

	
	
}
