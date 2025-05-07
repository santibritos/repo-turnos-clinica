package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Usuario;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	
	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private String usuario;	
	@Column
	private String password;
	
	@OneToOne(mappedBy="usuario", fetch=FetchType.EAGER)
	private Medico medico;
	@Column
	private String permiso;

	public Usuario() {
		
	}
	
	public Usuario(String uss,String pass) {
		this.setUsuario(uss);
		this.setPassword(pass);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", medico=" + medico.getLegajo() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
