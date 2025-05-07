package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;

public interface IdaoMedico {
	
	public boolean Add(Medico user);
	public Medico ReadOne(int legajo);
	public List<Medico> ReadAll();
	public boolean Exist(int m);
	public boolean Update(Medico m);
	public boolean Delete(Medico m);

}
