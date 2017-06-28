package evento;

public class Asiste {

	
	int codigo_usuario, codigo_evento;

	public Asiste(int codigo_usuario, int codigo_evento) {
		super();
		this.codigo_usuario = codigo_usuario;
		this.codigo_evento = codigo_evento;
	}

	public Asiste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public int getCodigo_evento() {
		return codigo_evento;
	}

	public void setCodigo_evento(int codigo_evento) {
		this.codigo_evento = codigo_evento;
	}
	
}
