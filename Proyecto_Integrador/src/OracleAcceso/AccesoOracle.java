package OracleAcceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoOracle {
	private String surl = "jdbc:oracle:thin:@localhost:1521:XE";
	public Connection conexion;

	public AccesoOracle() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(surl, "integrador", "integrador");
			System.out.println(" -Conexión con ORACLE establecida -");

			//conexion.close();
		} catch (Exception e) {
			System.out.println(" –Error de Conexión con ORACLE -");
			e.printStackTrace();
		}
	}

	public void cerrarBaseDatos() {
		try {
			conexion.close();
			System.out.println("BBDD cerrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cerrar BBDD");
			e.printStackTrace();
		}
	}
}
