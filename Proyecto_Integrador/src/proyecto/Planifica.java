package proyecto;

public class Planifica {
	
	int codigo_usuario, codigo_proyeto;

	public Planifica(int codigo_usuario, int codigo_proyeto) {
		super();
		this.codigo_usuario = codigo_usuario;
		this.codigo_proyeto = codigo_proyeto;
	}

	public Planifica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public int getCodigo_proyeto() {
		return codigo_proyeto;
	}

	public void setCodigo_proyeto(int codigo_proyeto) {
		this.codigo_proyeto = codigo_proyeto;
	}
	
	
}
