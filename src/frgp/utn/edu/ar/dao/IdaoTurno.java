package frgp.utn.edu.ar.dao;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;

public interface IdaoTurno {
	
	public boolean Add(Turno turno);
	public Turno ReadOne(int id);
	public List<Turno> ReadAll();
	public boolean Exist(String aux);
	public boolean Update(Turno turno);
	public boolean Delete(Turno turno);
	public List<Turno> traerPorFechaYmedico(Date fecha,Medico medico);
	public String traerHistoriaClinica(Medico medico, Paciente paciente);
	public List<Object[]> turnosPorEspecialidadYfecha(Date inicio, Date fin);
	public List<Object[]>traerPorEspecialidadYaño(Integer año);
	public List<Object[]>traerPorEstadoYaño(String estado,Integer año);
	public List<Object[]>traerTop5Medicos(Date inicio, Date fin);
	public List<Object[]>traerTop5MedicosDelAño(Integer año);

}
