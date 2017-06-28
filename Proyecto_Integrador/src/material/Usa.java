package material;

public class Usa {

	int codigo_proyecto, codigo_material, cantidad;

	public Usa(int codigo_proyecto, int codigo_material, int cantidad) {
		super();
		this.codigo_proyecto = codigo_proyecto;
		this.codigo_material = codigo_material;
		this.cantidad = cantidad;
	}

	public Usa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo_proyecto() {
		return codigo_proyecto;
	}

	public void setCodigo_proyecto(int codigo_proyecto) {
		this.codigo_proyecto = codigo_proyecto;
	}

	public int getCodigo_material() {
		return codigo_material;
	}

	public void setCodigo_material(int codigo_material) {
		this.codigo_material = codigo_material;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
