package usuario;

public class Usuario {

	

	public Usuario(int codigo_usuario, String nombre_usuario, String apellidos, String mail, String telefono,
			String tipo_usuario) {
		super();
		this.codigo_usuario = codigo_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellidos = apellidos;
		this.mail = mail;
		this.telefono = telefono;
		this.tipo_usuario = tipo_usuario;
	}
	

	int codigo_usuario;
	String nombre_usuario, apellidos, mail, telefono, tipo_usuario;
	
	
	public int getCodigo_usuario() {
		return codigo_usuario;
	}


	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}


	public String getNombre_usuario() {
		return nombre_usuario;
	}


	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getTipo_usuario() {
		return tipo_usuario;
	}


	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
