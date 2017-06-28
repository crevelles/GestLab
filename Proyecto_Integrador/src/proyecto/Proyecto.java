package proyecto;

public class Proyecto {
	
	int codigo_proyecto;
	String nombre_proyecto, descripcion;
	
	
	public Proyecto(int codigo_proyecto, String nombre_proyecto, String descripcion) {
		super();
		this.codigo_proyecto = codigo_proyecto;
		this.nombre_proyecto = nombre_proyecto;
		this.descripcion = descripcion;
	}


	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCodigo_proyecto() {
		return codigo_proyecto;
	}


	public void setCodigo_proyecto(int codigo_proyecto) {
		this.codigo_proyecto = codigo_proyecto;
	}


	public String getNombre_proyecto() {
		return nombre_proyecto;
	}


	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}

