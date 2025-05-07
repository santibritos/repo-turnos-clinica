package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Dia;

public interface IdaoDia {
	
	public Boolean add(Dia dia);
	public Dia readOne(int id);
	public List<Dia> readAll();

}
