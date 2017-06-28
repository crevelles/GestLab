package pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.net.aso.r;

public class GestionBBDDpedidos {

	
	Connection conexion;
	
	
	public GestionBBDDpedidos(Connection conexion){
		this.conexion = conexion;
	}


	public void consultaTablaPedidos(ArrayList <Pedido> pedidos) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT CODIGO_PEDIDO, TO_CHAR(FECHA, 'DD-MM-YYYY') AS FECHA, PRECIO_TOTAL, CIF_PROVEEDOR FROM PEDIDO ORDER BY FECHA DESC";
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()){
				Pedido p = new Pedido();
				p.setCodigo_pedido(rset.getInt("CODIGO_PEDIDO"));
				p.setFecha(rset.getString("FECHA"));
				p.setPrecio_total(rset.getInt("PRECIO_TOTAL"));
				p.setCif_proveedor(rset.getString("CIF_PROVEEDOR"));
			//	p.setContenido(rset.getString("DETALLE"));
				pedidos.add(p);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public boolean consultaCodigo(int codP) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM PEDIDO WHERE CODIGO_PEDIDO = '"+codP+"'";
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


	public boolean registrarPedido(Pedido p) {
		try {
			Statement stmt = conexion.createStatement();
			String insert = "INSERT INTO PEDIDO VALUES ('" 
					+ p.getCodigo_pedido() + "','" 
					+p.getFecha() + "','" 
					+ p.getPrecio_total()+ "','"
					+ p.getCif_proveedor()+ "','"
					+ p.getDescripcion()+ "')";
			stmt.executeQuery(insert);
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}


	public boolean compreubaCod(int codigo) {
		try {
			Statement stmt = conexion.createStatement();
			String select = "SELECT *FROM PEDIDO WHERE CODIGO_PEDIDO = "+codigo;
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


	public boolean eliminaPedido(int codP) {
		try {
			Statement stmt = conexion.createStatement();
			String delete = "DELETE FROM PEDIDO WHERE CODIGO_PEDIDO = " + codP;
			stmt.execute(delete);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
