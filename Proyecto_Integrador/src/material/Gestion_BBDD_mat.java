package material;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestion_BBDD_mat {

	Connection conexion;

	public Gestion_BBDD_mat(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	
	public void consultaMaterial(ArrayList<Material> materiales) {
		try {
			Statement stmt = conexion.createStatement();
			String query = "SELECT  * FROM MATERIAL ORDER BY CODIGO_MATERIAL";
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				Material m = new Material();
				m.setCodigo_material(rset.getInt("CODIGO_MATERIAL"));
				m.setNombre_material(rset.getString("NOMBRE_MATERIAL"));
				m.setTipo_material(rset.getString("TIPO_MATERIAL"));
				m.setDescripcion(rset.getString("DESCRIPCION"));
				m.setStock(rset.getInt("STOCK"));
				materiales.add(m);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Fallo en consulta");
			e.printStackTrace();
		}
	}



	public void modificaStock(Material m) {

		try {
			Statement stmt = conexion.createStatement();
			String update = "UPDATE MATERIAL SET CODIGO_MATERIAL ='" 
							+ m.getCodigo_material() + "', NOMBRE_MATERIAL ='" + m.getNombre_material()
					+ "', TIPO_MATERIAL ='" + m.getTipo_material() +  "', DESCRIPCION ='" + m.getDescripcion() +"', STOCK ='" + m.getStock()
					+ "' WHERE CODIGO_MATERIAL='" + m.getCodigo_material() + "'";
			ResultSet res = stmt.executeQuery(update);
			stmt.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			}
	}
	
	
	
	public void insertatMaterial(Material m){
		try {
			Statement stmt = conexion.createStatement();
			String insert = "INSERT INTO MATERIAL VALUES('"
					+ m.getCodigo_material()  +
					"', '" +m.getNombre_material()+
					"', '" +m.getTipo_material() +
					"','" +m.getDescripcion()+ 
					"'," +m.getStock()+")";
			stmt.execute(insert);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean eliminarMaterial(int cod){
		try {
			Statement stmt = conexion.createStatement();
			String update = "DELETE FROM MATERIAL WHERE CODIGO_MATERIAL LIKE '"+cod+"'";
			stmt.executeUpdate(update);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public void modificaSoloStock(int cod, int stock) {
		try {
			Statement stmt = conexion.createStatement();
			String update = "UPDATE MATERIAL SET STOCK = "+stock+" WHERE CODIGO_MATERIAL = "+cod+" ";
			stmt.executeQuery(update);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	
	
	
	

	

