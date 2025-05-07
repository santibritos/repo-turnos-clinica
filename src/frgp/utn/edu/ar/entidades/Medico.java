package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Usuario;
	
	@Entity
	@Table(name="Medico")
	public class Medico implements Serializable{

	private static final long serialVersionUID = 1L;
		
		@Id
		@Column
		private int legajo;	
		@Column
		private String nombre;	
		@Column
		private String apellido;	
		@Column
		private Date fecha_nacimiento;	
		@Column
		private String direccion;
		@Column
		private String localidad;
		@Column
		private String correoElectronico;
		@Column
		private String telefono;
		@Column
		private Boolean estado;
		
		@OneToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name="usuario_m")
		private Usuario usuario;
		
		@ManyToOne
		@JoinColumn(name="especialidad_id")
		private Especialidad especialidad;
		
		
		@ManyToMany(cascade = (CascadeType.ALL),fetch = (FetchType.EAGER))
		@JoinTable(name="medico_x_horario",joinColumns= {@JoinColumn(name="legajo_medico")},inverseJoinColumns={@JoinColumn(name="id_horario")})
		private List<Horario> listaHorarios;

		public Boolean getEstado() {
			return estado;
		}

		public void setEstado(Boolean estado) {
			this.estado = estado;
		}

		public Medico() {
			
		}
		
		
		
		public int getLegajo() {
			return legajo;
		}


		public void setLegajo(int legajo) {
			this.legajo = legajo;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}



		public Date getFecha_nacimiento() {
			return fecha_nacimiento;
		}


		public void setFecha_nacimiento(Date fecha_nacimiento) {
			this.fecha_nacimiento = fecha_nacimiento;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getLocalidad() {
			return localidad;
		}


		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}


		public String getCorreoElectronico() {
			return correoElectronico;
		}


		public void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		

		public Especialidad getEspecialidad() {
			return especialidad;
		}


		public void setEspecialidad(Especialidad especialidad) {
			this.especialidad = especialidad;
		}


		public List<Horario> getListaHorarios() {
			return listaHorarios;
		}

		public void setListaHorarios(List<Horario> listaHorarios) {
			this.listaHorarios = listaHorarios;
		}

		@Override
		public String toString() {
			return "Medico [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nacimiento="
					+ fecha_nacimiento + ", direccion=" + direccion + ", localidad=" + localidad
					+ ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", estado=" + estado
					+ ", usuario=" + usuario + ", especialidad=" + especialidad;
		}
		

}
