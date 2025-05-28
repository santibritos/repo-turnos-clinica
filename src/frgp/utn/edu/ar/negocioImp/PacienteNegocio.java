package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.daoImp.DaoPaciente;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.negocio.IpacienteNegocio;

public class PacienteNegocio implements IpacienteNegocio{

	@Autowired
	@Qualifier("beanDaoPaciente")
	private IdaoPaciente daoPaciente;
	
	public PacienteNegocio()
	{
		
	}
	public PacienteNegocio(DaoPaciente daoPaciente)
	{
		this.daoPaciente = daoPaciente;
	}
	
	public IdaoPaciente getDaoPaciente() {
		return daoPaciente;
	}
	
	public void setDaoPaciente(IdaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	public IdaoPaciente getDao() {
		return daoPaciente;
	}

	public void setDao(IdaoPaciente dao) {
		this.daoPaciente = dao;
	}
	
	
	
	public boolean Add(Paciente paciente) {
		return daoPaciente.Add(paciente);
	}
	public boolean Exist(String dniPaciente) {
		return daoPaciente.Exist(dniPaciente);
	}

	public Paciente ReadOne(String dniPaciente) {
		return daoPaciente.ReadOne(dniPaciente);
	}

	public List<Paciente> ReadAll() {
		
		/**for(Paciente p : daoPaciente.Readall())
		{
			System.out.println(p.toString());
		}*/
		
		return daoPaciente.Readall();
		
		
	}
	public boolean Delete(Paciente paciente) {
		paciente.setEstado(false);
		return daoPaciente.Delete(paciente);
	}
	public boolean Update(Paciente paciente) {
		// TODO Auto-generated method stub
		return daoPaciente.Update(paciente);
	}
	@Override
	public List<Paciente> traerPorMedico(Medico medico) {
		// TODO Auto-generated method stub
		return daoPaciente.traerPorMedico(medico);
	}
	

}
