package portada;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import usuario.Usuario;

public class GestionBBDDPortada {

	
	Connection conexion;
	
	
	public GestionBBDDPortada(Connection conexion){
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
	
	
}
