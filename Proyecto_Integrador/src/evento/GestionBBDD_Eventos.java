package evento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import usuario.Usuario;



public class GestionBBDD_Eventos {

Connection conexion;
VistaEvento ve = new VistaEvento();


	public GestionBBDD_Eventos(Connection conexion) {
		super();
		this.conexion = conexion;
	}


	public void cargarEventos(ArrayList<Evento> eventos) {
		try {
			Statement stmt = conexion.createStatement();
			//String select = "SELECT *FROM EVENTO ORDER BY CODIGO_EVENTO ASC";
			String select = "SELECT CODIGO_EVENTO, MENTOR, TIPO_EVENTO, DESCRIPCION, "
					+ "TO_CHAR(FECHA_INICIO, 'DD-MM-YYYY') AS FECHA_INICIO, "
					+ "TO_CHAR(FECHA_FIN, 'DD-MM-YYYY') AS FECHA_FIN, LUGAR"
					+ "  FROM EVENTO ORDER BY CODIGO_EVENTO";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Evento e = new Evento();
				e.setCodigo_evento(rset.getInt("CODIGO_EVENTO"));
				e.setMentor(rset.getString("MENTOR"));
				e.setTipo_evento(rset.getString("TIPO_EVENTO"));
				e.setDescripcion(rset.getString("DESCRIPCION"));
				e.setFecha_inicio(rset.getString("FECHA_INICIO"));
				e.setFecha_fin(rset.getString("FECHA_FIN"));
				e.setLugar(rset.getString("LUGAR"));
				eventos.add(e);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public boolean nuevoEvento(Evento e) {
		try {
			Statement stmt = conexion.createStatement();
			//insert into evento values(273, 'david', 'tipoEvent','descrip', TO_DATE ('3-6-2017', 'DD-MM-YYYY'), TO_DATE ('3-6-2017', 'DD-MM-YYYY'), 'alcobendas')
			String insert = "INSERT INTO EVENTO VALUES('"
									+e.getCodigo_evento()+"','"
									+e.getMentor()+"','"
									+e.getTipo_evento()+"','"
									+e.getDescripcion()+"',TO_DATE ('"
					+ e.getFecha_inicio()+"'"+ ", 'DD-MM-YYYY'), TO_DATE ('"
					+ e.getFecha_fin()+"'"+ ", 'DD-MM-YYYY'), '"+e.getLugar()+"'" 
					+ ")";
			stmt.executeUpdate(insert);
			stmt.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
		
	}


	public boolean borrarEvento(int codEvento) {
		try {
			Statement stmt = conexion.createStatement();
			String delete = "DELETE FROM EVENTO WHERE CODIGO_EVENTO = "+codEvento;
			stmt.executeUpdate(delete);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}


	public boolean registrarAsistencia(int idAsistente, int idEvento) {
		try {
			Statement stmt = conexion.createStatement();
			String update = "INSERT INTO ASISTE VALUES ("+(idAsistente)+", "+idEvento+")";
			stmt.executeUpdate(update);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}


	public boolean compruebaAsistencia(int codigoUsuario, int codigoEvento) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM ASISTE WHERE CODIGO_USUARIO="+(codigoUsuario)+" AND CODIGO_EVENTO="+codigoEvento+"";
			ResultSet rset = stmt.executeQuery(select);
			if(rset.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public void consultarEventosRegistrados(ArrayList<Evento> eventosR, int codigo) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "select mentor, descripcion,tipo_evento,  "
					+ "TO_CHAR(FECHA_INICIO, 'DD-MM-YYYY') AS FECHA_INICIO, "
					+ "TO_CHAR(FECHA_FIN, 'DD-MM-YYYY') AS FECHA_FIN "
					+ "from evento where codigo_evento="+codigo+"";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Evento e = new Evento();
				e.setMentor(rset.getString("MENTOR"));
				e.setDescripcion(rset.getString("DESCRIPCION"));
				e.setFecha_inicio(rset.getString("FECHA_INICIO"));
				e.setFecha_fin(rset.getString("FECHA_FIN"));
				e.setTipo_evento(rset.getString("TIPO_EVENTO"));
				eventosR.add(e);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void consultarUsuariosEventos(ArrayList<Usuario> usuariosR, int codigo) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "select nombre_usuario, apellidos, mail "
									+ "from usuario, evento, asiste"
									+ " where usuario.codigo_usuario = asiste.codigo_usuario"
									+ " and evento.codigo_evento=asiste.codigo_evento"
									+ " and evento.codigo_evento="+codigo+"";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Usuario u = new Usuario();
				u.setNombre_usuario(rset.getString("NOMBRE_USUARIO"));
				u.setApellidos(rset.getString("APELLIDOS"));
				u.setMail(rset.getString("MAIL"));
				usuariosR.add(u);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void cargarUsuarios(ArrayList<Usuario> usuarios) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM USUARIO ORDER BY CODIGO_USUARIO asc";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Usuario u = new Usuario();
				u.setCodigo_usuario(rset.getInt("CODIGO_USUARIO"));
				u.setNombre_usuario(rset.getString("NOMBRE_USUARIO"));
				u.setApellidos(rset.getString("APELLIDOS"));
				u.setMail(rset.getString("MAIL"));
				u.setTelefono(rset.getString("TELEFONO"));
				u.setTipo_usuario(rset.getString("TIPO_USUARIO"));
				usuarios.add(u);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void controlEventosMyFab(ArrayList<Evento> even, String nombre){
		try {
			Statement stmt = conexion.createStatement();
			String select = "select mentor, descripcion, tipo_evento, TO_CHAR(FECHA_INICIO, 'DD-MM-YYYY') AS FECHA_INICIO "
					+ "from asiste, usuario, evento "
							+ "where asiste.codigo_evento = evento.codigo_evento "
								+ "and usuario.codigo_usuario = asiste.codigo_usuario "
								+ "and nombre_usuario = '"+nombre+"'";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Evento e = new Evento();
				e.setMentor(rset.getString("MENTOR"));
				e.setDescripcion(rset.getString("DESCRIPCION"));
				e.setTipo_evento(rset.getString("TIPO_EVENTO"));
				e.setFecha_inicio(rset.getString("FECHA_INICIO"));
				even.add(e);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	
	
	

	
	

	
	
	
	

}
