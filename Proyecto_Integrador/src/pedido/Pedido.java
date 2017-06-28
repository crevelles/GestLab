package pedido;

public class Pedido {

	int codigo_pedido;
	String fecha, cif_proveedor;
	int precio_total;
	String descripcion;
	public Pedido(int codigo_pedido, String fecha, String cif_proveedor, int precio_total, String descripcion) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.fecha = fecha;
		this.cif_proveedor = cif_proveedor;
		this.precio_total = precio_total;
		this.descripcion = descripcion;
	}
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCif_proveedor() {
		return cif_proveedor;
	}
	public void setCif_proveedor(String cif_proveedor) {
		this.cif_proveedor = cif_proveedor;
	}
	public int getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
