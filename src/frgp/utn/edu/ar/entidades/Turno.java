package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;

@Entity
@Table(name="Turno")
public class Turno implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Date fecha;
	@Column
	private Time hora;
	@Column
	private String observacion;
	@Column
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="legajo_medico")
	private Medico medico;
	
	
	@ManyToOne
	@JoinColumn(name="dni_paciente")
	private Paciente paciente;
	
	public Turno() {
		
	}
	public Turno(Paciente paciente,Medico medico,Date fecha,Time hora,String observacion,String estado) {
		this.paciente=paciente;
		this.medico=medico;
		this.fecha=fecha;
		this.hora=hora;
		this.observacion=observacion;
		this.estado=estado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time time) {
		this.hora = time;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Turno [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", observacion=" + observacion + ", estado="
				+ estado + ", medico=" + medico + ", paciente=" + paciente + "]";
	}
	

}
