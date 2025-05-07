package frgp.utn.edu.ar.entidades;

import java.util.List;

public class MedicoDTO {
	
	public MedicoDTO(int id, String nombre, String apellido, List<HorarioDTO> horarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		Apellido = apellido;
		this.horarios = horarios;
	}

	private int id;
	private String nombre;
	private String Apellido;
	private String email;
	private String telefono;
	private List<HorarioDTO> horarios;
	
	public MedicoDTO() {}

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

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<HorarioDTO> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioDTO> horarios) {
		this.horarios = horarios;
	};
}
