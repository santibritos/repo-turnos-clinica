package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;

public interface IturnoNegocio {
	
	public boolean Add(Turno turno);
	public Turno ReadOne(int id);
	public List<Turno> ReadAll();
	public boolean Exist(String aux);
	public boolean Update(Turno turno);
	public boolean Delete(Turno turno);
	public List<Turno> readAllFrom(Medico m);

}
