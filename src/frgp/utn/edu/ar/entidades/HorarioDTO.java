package frgp.utn.edu.ar.entidades;

public class HorarioDTO {
	
	public HorarioDTO(int id, String dia, String entrada, String salida) {
		super();
		this.id = id;
		this.dia = dia;
		this.entrada = entrada;
		this.salida = salida;
	}

	private int id;
	private String dia;
	private String entrada;
	private String salida;
	
	public HorarioDTO () {}

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

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	};

}
