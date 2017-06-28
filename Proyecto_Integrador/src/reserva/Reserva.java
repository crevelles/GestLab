package reserva;

import java.util.Calendar;

public class Reserva {
	
	//private Calendar i;
	int codigo_proyecto, codigo_maquina, codigoU;
	String fecha_inicio, fecha_fin, nombre_responsable, nombre_maquina, nombre_proyecto;
	
	
	
	
	
	public Reserva(int codigo_proyecto, int codigo_maquina, int codigoU, String fecha_inicio, String fecha_fin,
			String nombre_responsable, String nombre_maquina, String nombre_proyecto) {
		super();
		this.codigo_proyecto = codigo_proyecto;
		this.codigo_maquina = codigo_maquina;
		this.codigoU = codigoU;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.nombre_responsable = nombre_responsable;
		this.nombre_maquina = nombre_maquina;
		this.nombre_proyecto = nombre_proyecto;
	}
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getCodigoU() {
		return codigoU;
	}
	public void setCodigoU(int codigoU) {
		this.codigoU = codigoU;
	}
	public int getCodigo_proyecto() {
		return codigo_proyecto;
	}
	public void setCodigo_proyecto(int codigo_proyecto) {
		this.codigo_proyecto = codigo_proyecto;
	}
	public int getCodigo_maquina() {
		return codigo_maquina;
	}
	public void setCodigo_maquina(int codigo_maquina) {
		this.codigo_maquina = codigo_maquina;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getNombre_responsable() {
		return nombre_responsable;
	}
	public void setNombre_responsable(String nombre_responsable) {
		this.nombre_responsable = nombre_responsable;
	}
	public String getNombre_maquina() {
		return nombre_maquina;
	}
	public void setNombre_maquina(String nombre_maquina) {
		this.nombre_maquina = nombre_maquina;
	}
	public String getNombre_proyecto() {
		return nombre_proyecto;
	}
	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}
	
	
	

	
}
