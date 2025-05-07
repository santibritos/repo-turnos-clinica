package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.negocio.ImedicoNegocio;

public class MedicoNegocio implements ImedicoNegocio{

	@Autowired
	@Qualifier("beanDaoMedico")
	private IdaoMedico  daoMedico;

	public MedicoNegocio()
	{
		
	}
	
	public boolean Add(Medico user) {
		
		return daoMedico.Add(user);
	}

	public Medico ReadOne(int legajo) {
		return daoMedico.ReadOne(legajo);
	}

	public List<Medico> ReadAll() {
		return daoMedico.ReadAll();
	}

	public boolean Exist(int m) {
		return daoMedico.Exist(m);
	}

	public boolean Update(Medico m) {
		return daoMedico.Update(m);
	}

	public boolean Delete(Medico m) {
		
		m.setEstado(false);
		return daoMedico.Delete(m);
	}

	public IdaoMedico getDaoMedico() {
		return daoMedico;
	}

	public void setDaoMedico(IdaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}
}
