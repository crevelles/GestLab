package maquina;

public class Maquina {

	
	int codigo_maquina;
	String nombre_maquina, descripcion, disponibilidad;
	public Maquina(int codigo_maquina, String nombre_maquina, String descripcion, String disponibilidad) {
		super();
		this.codigo_maquina = codigo_maquina;
		this.nombre_maquina = nombre_maquina;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
	}
	public Maquina() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo_maquina() {
		return codigo_maquina;
	}
	public void setCodigo_maquina(int codigo_maquina) {
		this.codigo_maquina = codigo_maquina;
	}
	public String getNombre_maquina() {
		return nombre_maquina;
	}
	public void setNombre_maquina(String nombre_maquina) {
		this.nombre_maquina = nombre_maquina;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
}
