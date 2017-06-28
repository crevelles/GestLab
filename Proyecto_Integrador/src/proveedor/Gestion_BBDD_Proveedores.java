package proveedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestion_BBDD_Proveedores {

	
	Connection conexion;
	
	public Gestion_BBDD_Proveedores(Connection conexion){
		this.conexion = conexion;
	}
	
	public void consultaProveedores(ArrayList<Proveedor> proveedores) {
		try {
			Statement stmt = conexion.createStatement();
			String query = "SELECT  * FROM PROVEEDOR";
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				Proveedor p = new Proveedor();
				p.setCif(rset.getString("CIF"));
				p.setNombre_proveedor(rset.getString("NOMBRE_PROVEEDOR"));
				p.setDireccion(rset.getString("DIRECCION"));
				p.setCiudad(rset.getString("CIUDAD"));
				p.setCp(rset.getInt("CP"));
				p.setTelefono(rset.getString("TELEFONO"));
				p.setMail(rset.getString("MAIL"));
				proveedores.add(p);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Fallo en consulta");
			e.printStackTrace();
		}
	}
	
	public boolean insertarProveedor(Proveedor p){
		try {
			Statement stmt = conexion.createStatement();
			String insert = "INSERT INTO PROVEEDOR VALUES('"
							+p.getCif()+"', '"
							+p.getNombre_proveedor()+"','"
							+p.getDireccion()+"','"
							+p.getCiudad()+"','"
							+p.getCp()+"','"
							+p.getTelefono()+"','"
							+p.getMail()+"')";
			stmt.executeUpdate(insert);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modoficarProveedor(Proveedor p){
		try {
			Statement stmt = conexion.createStatement();
			String update = "UPDATE PROVEEDOR SET CIF='"
					+p.getCif()+"', NOMBRE_PROVEEDOR = '"
					+p.getNombre_proveedor()+"', DIRECCION ='"
					+p.getDireccion()+"', CIUDAD = '"
					+p.getCiudad()+"',CP='"
					+p.getCp()+"', TELEFONO='"
					+p.getTelefono()+"', MAIL='"
					+p.getMail()+"' WHERE CIF = '"
					+p.getCif()+"'";
			stmt.executeUpdate(update);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean bajaProveedor(String cif) {
		try {
			Statement stmt = conexion.createStatement();
			String delete = "DELETE FROM PROVEEDOR WHERE CIF LIKE '"+cif+"'";
			stmt.executeUpdate(delete);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean compruebaCIF(String cif) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT * FROM PROVEEDOR WHERE CIF = '"+cif+"'";
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
	
}
