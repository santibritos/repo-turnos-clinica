package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Especialidad;

public interface IespecialidadNegocio {
	
	public boolean Add(Especialidad esp);
	public Especialidad ReadOne(int id);
	public List<Especialidad> ReadAll();
	public boolean Exist(String aux);

}
