package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import frgp.utn.edu.ar.daoImp.DaoDia;
import frgp.utn.edu.ar.entidades.Dia;
import frgp.utn.edu.ar.negocio.IdiaNegocio;

public class DiaNegocio implements IdiaNegocio{
	@Autowired
	@Qualifier("beanDaoDia")
	private DaoDia dao;

	@Override
	public Boolean add(Dia dia) {
		// TODO Auto-generated method stub
		return dao.add(dia);
	}

	@Override
	public Dia readOne(int id) {
		// TODO Auto-generated method stub
		return dao.readOne(id);
	}

	@Override
	public List<Dia> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
