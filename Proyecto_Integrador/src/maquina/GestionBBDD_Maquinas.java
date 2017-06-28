package maquina;
import java.sql.*;

import java.util.ArrayList;

import javax.naming.CommunicationException;
import javax.swing.JOptionPane;




public class GestionBBDD_Maquinas {

	Connection conexion;
	
	
	

	public GestionBBDD_Maquinas(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	
	
	
	
	//Metodo para consultar maquinas 
	
	public void consultaMaquinas(ArrayList<Maquina> maquinas) {
		try {
			Statement stmt = conexion.createStatement();
			String query = "SELECT  * FROM MAQUINA ORDER BY CODIGO_MAQUINA ";
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				Maquina m = new Maquina();
				m.setCodigo_maquina(rset.getInt("CODIGO_MAQUINA"));
				m.setNombre_maquina(rset.getString("NOMBRE_MAQUINA"));
				m.setDescripcion(rset.getString("DESCRIPCION"));
				m.setDisponibilidad(rset.getString("DISPONIBILIDAD"));
				maquinas.add(m);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Fallo en consulta");
			e.printStackTrace();
		}
	}
	
	
	public void consultaMaquinasDisponibles(ArrayList<Maquina> maquinas) {

	}
	
	
	//Metodo para modificar el estado
	public void modificaEstado(){

	}
	
	
	//Metodo para cargar máquina 
	public void insertarMaquina(Maquina m) {
		Statement stat;
		try {
			stat = conexion.createStatement();
			String insert = "INSERT INTO MAQUINA VALUES ('" 
								+ m.getCodigo_maquina() + "','" 
								+ m.getNombre_maquina()+ "','"
								+ m.getDescripcion() + "','" 
								+ m.getDisponibilidad()+"')";
			stat.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Maquina registrada");
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//METODO PARA ELIMINAR MAQUINA
	public void eliminarMaquina(int cod) {
		Statement stat;
		try {
			stat = conexion.createStatement();
			String delete = "DELETE FROM MAQUINA WHERE CODIGO_MAQUINA ='" + cod + "'";
			stat.executeUpdate(delete);
			JOptionPane.showMessageDialog(null, "Maquina eliminada");
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//metodo modificar maquina
	private void modificarDepartamento(Maquina m) {
		Statement stat;
		try {
			stat = conexion.createStatement();;
			JOptionPane.showMessageDialog(null, "Maquina modificada");
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
