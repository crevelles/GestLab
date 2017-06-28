package proyecto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestion_BBDD_Proyectos {

	Connection conexion;

	public Gestion_BBDD_Proyectos(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	
	public void consultaProyectos(ArrayList<Proyecto> proyectos) {
		try {
			Statement stmt = conexion.createStatement();
			String query = "SELECT  * FROM PROYECTO ORDER BY CODIGO_PROYECTO";
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				Proyecto p = new Proyecto();
				p.setCodigo_proyecto(rset.getInt("CODIGO_PROYECTO"));
				p.setNombre_proyecto(rset.getString("NOMBRE_PROYECTO"));
				p.setDescripcion(rset.getString("DESCRIPCION"));
				proyectos.add(p);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Fallo en consulta");
			e.printStackTrace();
		}
	}
	
	public void modificaProyecto(Proyecto p){
		try {
			Statement stat = conexion.createStatement();
			String update = "UPDATE PROYECTO SET CODIGO_PROYECTO ='"+ p.getCodigo_proyecto() 
								+"', NOMBRE_PROYECTO ='" +p.getNombre_proyecto()
								+"', DESCRIPCION ='" +p.getDescripcion()
								+"' WHERE CODIGO_PROYECTO='" + p.getCodigo_proyecto()+ "'";
			stat.executeUpdate(update);
			stat.close();
		} catch (SQLException e) {
			System.out.println("Fallo en consulta");
			e.printStackTrace();
		}
	}
	

	public void borrarProyecto(String codProyecto) {
		try {
			Statement stmt = conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertarProyecto(Proyecto p){
		try {
			Statement stmt = conexion.createStatement();
			String insert = "INSERT INTO PROYECTO VALUES ('" 
					+ p.getCodigo_proyecto()   + "','" 
					+ p.getNombre_proyecto()   + "','" 
					+ p.getDescripcion()+ "')";
			stmt.executeUpdate(insert);
					stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean buscarProyecto(String codP) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM PROYECTO WHERE CODIGO_PROYECTO = '"+codP+"' ";
			System.out.println(select);
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Proyecto p = new Proyecto();
				p.setCodigo_proyecto(rset.getInt("CODIGO_PROYECTO"));
				p.setNombre_proyecto(rset.getString("NOMBRE_PROYECTO"));
				p.setDescripcion(rset.getString("DESCRIPCION"));
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

	public boolean buscaCod(int codP) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT * FROM PROYECTO WHERE CODIGO_PROYECTO = '"+codP+"'";
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
	
	public boolean eliminaProyecto(int codP){
		try {
			Statement stmt = conexion.createStatement();
			String update = "DELETE FROM PROYECTO WHERE CODIGO_PROYECTO = '"+codP+"'";
			int rset = stmt.executeUpdate(update);
			if(rset==1){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

	


