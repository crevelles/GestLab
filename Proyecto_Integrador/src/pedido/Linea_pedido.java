package pedido;

public class Linea_pedido {
	
	int codigo_pedido, codigo_material, cantidad;
	double precio;
	public Linea_pedido(int codigo_pedido, int codigo_material, int cantidad, double precio) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.codigo_material = codigo_material;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public Linea_pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
