package seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestion_BBDD_Seleccion {

Vseleccion vs;	
	Connection conexion;
	
	public Gestion_BBDD_Seleccion(Connection conexion){
		this.conexion = conexion;
	}
	
//	public void  fecha(String fecha){
//		try {
//			
//			Statement stmt = conexion.createStatement();
//			String select = "SELECT DISTINCT to_char (sysdate, 'Day, DD MONTH YYYY','nls_date_language = spanish') from usuarios";
//			ResultSet rset = stmt.executeQuery(select);
//			String fe = 
//			rset.close();
//			stmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
}
