package material;

public class Material {

	
	int codigo_material, stock;
	String nombre_material, tipo_material, descripcion;
	public Material(int codigo_material, int stock, String nombre_material, String tipo_material, String descripcion) {
		super();
		this.codigo_material = codigo_material;
		this.stock = stock;
		this.nombre_material = nombre_material;
		this.tipo_material = tipo_material;
		this.descripcion = descripcion;
	}
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo_material() {
		return codigo_material;
	}
	public void setCodigo_material(int codigo_material) {
		this.codigo_material = codigo_material;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getNombre_material() {
		return nombre_material;
	}
	public void setNombre_material(String nombre_material) {
		this.nombre_material = nombre_material;
	}
	public String getTipo_material() {
		return tipo_material;
	}
	public void setTipo_material(String tipo_material) {
		this.tipo_material = tipo_material;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
