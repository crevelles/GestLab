package reserva;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import material.Material;

public class Gestion_BBDD_ResConfm {

	Connection conexion;

	public Gestion_BBDD_ResConfm(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	

	
	public void consultaReservas(ArrayList<Reserva> resConfm) {
		try {
			Statement stmt = conexion.createStatement();
			String query = "SELECT NOMBRE_PROYECTO,NOMBRE_RESPONSABLE, NOMBRE_MAQUINA, TO_CHAR(FECHA_INICIO, 'DD-MM-YYYY') AS FECHA_INICIO,"
					+ " TO_CHAR(FECHA_FIN, 'DD-MM-YYYY') AS FECHA_FIN FROM RESERVA ORDER BY FECHA_FIN DESC";

			
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				Reserva r = new Reserva();
				r.setNombre_proyecto(rset.getString("NOMBRE_PROYECTO"));
				r.setNombre_responsable(rset.getString("NOMBRE_RESPONSABLE"));
				r.setNombre_maquina(rset.getString("NOMBRE_MAQUINA"));;
				r.setFecha_inicio(rset.getString("FECHA_INICIO"));
				r.setFecha_fin(rset.getString("FECHA_FIN"));
				resConfm.add(r);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public boolean insertarReserva(Reserva rc) {
		Statement stat;
		try {
			stat = conexion.createStatement();			
			String insert = "INSERT INTO RESERVA (CODIGO_USUARIO, NOMBRE_PROYECTO,NOMBRE_RESPONSABLE, NOMBRE_MAQUINA, CODIGO_PROYECTO, CODIGO_MAQUINA,"
					+ " FECHA_INICIO, FECHA_FIN) VALUES('"
					+ rc.getCodigoU()+"','"
					+ rc.getNombre_proyecto()+"','"
					+ rc.getNombre_responsable()+"','"
					+ rc.getNombre_maquina()+"',"
					+ rc.getCodigo_proyecto()   + "," 		
					+ rc.getCodigo_maquina()  + ",TO_DATE ('"
					+ rc.getFecha_inicio()+"'"+ ", 'DD-MM-YYYY'), TO_DATE ('"
					+ rc.getFecha_fin()+"'"+ ", 'DD-MM-YYYY')" + ")";
			stat.executeUpdate(insert);
			stat.close();
			return true;	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Contacte con Jairo","Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}	
		return false;
	}

		public boolean compruebaFecha(String fechaI,String fechaF, int codMaquina) {
			try {
			Statement stmt = conexion.createStatement();			
			String select = "SELECT *FROM RESERVA "
					+ "WHERE  ((TO_DATE('"+fechaI+"', 'DD-MM-YY') >= FECHA_INICIO"
							+ " AND TO_DATE('"+fechaI+"', 'DD-MM-YY') <= FECHA_FIN )"
							+ " OR (TO_DATE('"+fechaF+"', 'DD-MM-YY') >= FECHA_INICIO"
							+ " AND TO_DATE('"+fechaF+"', 'DD-MM-YY') <= FECHA_FIN))"
							+ " AND CODIGO_MAQUINA = '"+codMaquina+"'";
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

	

		public boolean cancelaReserva(String fechaI, String nombreMaquina) {
			try {
				Statement stmt = conexion.createStatement();
				String delete = "DELETE FROM RESERVA "
						+ "WHERE FECHA_INICIO = TO_DATE('"+fechaI+"', 'DD-MM-YY') "
								+ "AND NOMBRE_MAQUINA = '"+nombreMaquina+"'";
				stmt.executeUpdate(delete);
				stmt.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}



		public Reserva siguienteFecha(int codigoMaquina) {
			Reserva r = new Reserva();
			try {
				//SELECT MAX(TO_CHAR(FECHA_FIN, 'DD-MM-YYYY'))AS FECHA_FIN FROM RESERVA WHERE CODIGO_MAQUINA = 1;
				Statement stmt = conexion.createStatement();
				String select = "SELECT MAX(TO_CHAR (FECHA_FIN, 'DD-MM-YYYY')) AS FECHA_FIN "
						+ "FROM RESERVA "
						+ "WHERE CODIGO_MAQUINA = "+codigoMaquina+"";				
				ResultSet rset = stmt.executeQuery(select);
				while(rset.next()){
					r.setFecha_fin(rset.getString("FECHA_FIN"));
				}
				
				rset.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return r;			
		}



		public boolean compruebaFechaHoy(String fechaI, String fechaF) {
			try {
				Statement stmt = conexion.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}





	
	
	
}
