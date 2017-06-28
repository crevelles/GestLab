package evento;

public class Evento {


	
	int codigo_evento;
	String tipo_evento, descripcion, fecha_inicio, fecha_fin, mentor, lugar;
	public Evento(int codigo_evento, String tipo_evento, String descripcion, String fecha_inicio, 
			String fecha_fin, String mentor, String lugar) {
		super();
		this.codigo_evento = codigo_evento;
		this.tipo_evento = tipo_evento;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.mentor = mentor;
		this.lugar = lugar;
	}
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public int getCodigo_evento() {
		return codigo_evento;
	}
	public void setCodigo_evento(int codigo_evento) {
		this.codigo_evento = codigo_evento;
	}
	public String getTipo_evento() {
		return tipo_evento;
	}
	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	
	
	
	
}
