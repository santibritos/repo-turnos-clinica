package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity
	@Table(name="Especialidad")
	public class Especialidad implements Serializable{

		
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column
		private String nombre;
		
		public Especialidad() {
			
		}
		
		public Especialidad(String nombre)
		{
			this.setNombre(nombre);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public String toString() {
			return "Especialidad [id=" + id + ", nombre=" + nombre + "]";
		}
		

}
