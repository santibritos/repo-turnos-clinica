package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Dia;

public interface IdiaNegocio {
	
	public Boolean add(Dia dia);
	public Dia readOne(int id);
	public List<Dia> readAll();

}
