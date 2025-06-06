package frgp.utn.edu.ar.negocioImp;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import frgp.utn.edu.ar.dao.IdaoTurno;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.negocio.IturnoNegocio;

public class TurnoNegocio implements IturnoNegocio{
	
	
	@Autowired
	@Qualifier("beanDaoTurno")
	private IdaoTurno dao;
	
	
	public TurnoNegocio()
	{
		
	}

	public boolean Add(Turno turno) {
		// TODO Auto-generated method stub
		return dao.Add(turno);
	}

	public Turno ReadOne(int id) {
		// TODO Auto-generated method stub
		return dao.ReadOne(id);
	}

	public List<Turno> ReadAll() {
		// TODO Auto-generated method stub
		return dao.ReadAll();
	}

	public boolean Exist(String aux) {
		// TODO Auto-generated method stub
		return dao.Exist(aux);
	}

	public boolean Update(Turno turno) {
		// TODO Auto-generated method stub
		return dao.Update(turno);
	}

	public boolean Delete(Turno turno) {
		turno.setEstado("cancelado");
		return dao.Delete(turno);
	}

	public IdaoTurno getDao() {
		return dao;
	}

	public void setDao(IdaoTurno dao) {
		this.dao = dao;
	}

	@Override
	public List<Turno> traerPorFechaYmedico(Date fecha, Medico m) {
		// TODO Auto-generated method stub
		return dao.traerPorFechaYmedico(fecha, m);
	}

	@Override
	public String traerHistoriaClinica(Medico medico, Paciente paciente) {
		// TODO Auto-generated method stub
		return dao.traerHistoriaClinica(medico, paciente);
	}

	@Override
	public List<Object[]> turnosPorEspecialidadYfecha(Date inicio, Date fin) {
		// TODO Auto-generated method stub
		return dao.turnosPorEspecialidadYfecha(inicio, fin);
	}

	@Override
	public List<Object[]> traerPorEspecialidadYa�o(Integer a�o) {
		// TODO Auto-generated method stub
		return dao.traerPorEspecialidadYa�o(a�o);
	}

	@Override
	public List<Object[]> traerPorEstadoYa�o(String estado, Integer a�o) {
		// TODO Auto-generated method stub
		return dao.traerPorEstadoYa�o(estado, a�o);
	}

	@Override
	public List<Object[]> traerTop5Medicos(Date inicio, Date fin) {
		// TODO Auto-generated method stub
		return dao.traerTop5Medicos(inicio, fin);
	}

	@Override
	public List<Object[]> traerTop5MedicosDelA�o(Integer a�o) {
		// TODO Auto-generated method stub
		return dao.traerTop5MedicosDelA�o(a�o);
	}

	

}
