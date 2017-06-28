 package proveedor;

public class Proveedor {

	
	String cif, nombre_proveedor, direccion, ciudad, telefono, mail;
	int cp;
	
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(String cif, String nombre_proveedor, String direccion, String ciudad, String telefono, String mail,
			int cp) {
		super();
		this.cif = cif;
		this.nombre_proveedor = nombre_proveedor;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.mail = mail;
		this.cp = cp;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	
}
