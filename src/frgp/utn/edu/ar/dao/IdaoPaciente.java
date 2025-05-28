package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;

public interface IdaoPaciente {

	
	public boolean Add(Paciente paciente);
	public boolean Exist(String dniPaciente);
	public Paciente ReadOne(String dniPaciente);
	public List<Paciente> Readall();
	public boolean Delete(Paciente paciente);
	public boolean Update(Paciente paciente);
	public List<Paciente> traerPorMedico(Medico medico);
}
