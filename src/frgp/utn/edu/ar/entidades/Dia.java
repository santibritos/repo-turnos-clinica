package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dia")
public class Dia implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String dia;
	
	public Dia()
	{}

	public Dia(int id, String dia) {
		super();
		this.id = id;
		this.dia = dia;
	}
	private static final long serialVersionUID = 1L;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return dia;
	}
	
	
	
}
