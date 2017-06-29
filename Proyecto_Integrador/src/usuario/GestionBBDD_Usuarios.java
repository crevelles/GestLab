package usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionBBDD_Usuarios {

	
	Connection conexion;
	VistaUsuarios vu = new VistaUsuarios();
	
	public GestionBBDD_Usuarios(Connection conexion){
		this.conexion = conexion;
	}
	
	
	public void cargarUsuarios(ArrayList<Usuario> usuarios){
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM USUARIO ORDER BY CODIGO_USUARIO";
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
	

	public boolean compueboRegistro(int codigo_usuario) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM USUARIO WHERE CODIGO_USUARIO = '"+codigo_usuario+"' ";
			ResultSet rset = stmt.executeQuery(select);
			if(rset.next()){
				return true;
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

	public void insertarUsuario(Usuario u) {
		try {
			Statement stmt = conexion.createStatement();
			String update = "INSERT INTO USUARIO VALUES("
							+u.getCodigo_usuario()+",'"
							+u.getNombre_usuario()+"','"
							+u.getApellidos()+"','"
							+u.getMail()+"','"
							+u.getTelefono()+"','"
							+u.getTipo_usuario()+"')";
			stmt.executeUpdate(update);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void consultaUsuarios(ArrayList<Usuario> usuarios) {
		// TODO Auto-generated method stub
		
	}

	public void consultaUcargarLista() {
		// TODO Auto-generated method stub
		
	}


	public boolean eliminarUsuario(int cod) {
		try {
			Statement stmt = conexion.createStatement();
			String update = "DELETE FROM USUARIO WHERE CODIGO_USUARIO = " + cod;
			stmt.executeUpdate(update);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}


	public boolean modificarUsuario(Usuario u) {
		try {
			Statement stmt = conexion.createStatement();
			String update = "UPDATE USUARIO SET NOMBRE_USUARIO ='" +u.getNombre_usuario()
			+"', APELLIDOS ='" +u.getApellidos()
			+"', MAIL ='" +u.getMail()
			+"', TELEFONO ='" +u.getTelefono()
			+"', TIPO_USUARIO ='" +u.getTipo_usuario()
			+"' WHERE CODIGO_USUARIO='" + u.getCodigo_usuario()+ "'";
			stmt.executeUpdate(update);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public boolean consultaID(int id) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT CODIGO_USUARIO FROM USUARIO";
			ResultSet rset = stmt.executeQuery(select);
			if(rset.next()){
				return true;
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public int obtenerId() {
		int n = 0;
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT MAX(CODIGO_USUARIO) FROM USUARIO";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				n = rset.getInt("CODIGO_USUARIO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}


	public void consultarUsuariosEnProyectos(int codigoProyecto, ArrayList<Usuario> usuarios) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM USUARIO, PROYECTO, PLANIFICA "
					+ "WHERE USUARIO.CODIGO_USUARIO = PLANIFICA.CODIGO_USUARIO AND "
					+ "PROYECTO.CODIGO_PROYECTO = PLANIFICA.CODIGO_PROYECTO AND PROYECTO.CODIGO_PROYECTO="+codigoProyecto;
			System.out.println(select);
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Usuario u = new Usuario();
				u.setNombre_usuario(rset.getString("NOMBRE_USUARIO"));
				u.setApellidos(rset.getString("APELLIDOS"));
				u.setMail(rset.getString("MAIL"));
				usuarios.add(u);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
