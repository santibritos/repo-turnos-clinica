package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private String dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String telefono;
	@Column
	private String direccion;
	@Column
	private String localidad;
	@Column
	private String provincia;
	@Column
	private Date fecha_nacimiento;
	@Column
	private String correo_electronico;
	@Column
	private boolean estado;
	
	/**@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="lista_turnos")
	private List<Turno> turnos= new ArrayList<Turno>();*/
	
	public Paciente() {
		
	}
	public Paciente(String dni,String nombre,String apellido,String telefono,String direccion, String localidad,String provincia, Date fecha,String correo) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setFecha_nacimiento(fecha);
		this.setCorreo_electronico(correo);
		
	}

	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
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


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getCorreo_electronico() {
		return correo_electronico;
	}


	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", correo_electronico=" + correo_electronico + "]";
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


}
