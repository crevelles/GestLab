package myFab;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import evento.Evento;
import evento.GestionBBDD_Eventos;
import evento.VistaEvento;
import maquina.GestionBBDD_Maquinas;
import maquina.Maquina;
import material.Gestion_BBDD_mat;
import material.Material;
import proyecto.Gestion_BBDD_Proyectos;
import proyecto.Proyecto;
import reserva.Gestion_BBDD_ResConfm;
import reserva.ReservasConfirmadas;
import usuario.GestionBBDD_Usuarios;
import usuario.Usuario;

public class ControladorMyFab implements ActionListener{

	Vista_MyFab vmy;
	VistaEvento ve;
	AccesoOracle bbdd;
	ReservasConfirmadas rc;
	GestionBBDD_Maquinas gestionBDMaquinas;
	GestionBBDD_Usuarios gestionBDUsuarios;
	Gestion_BBDD_Proyectos gestionBDProyectos;
	Gestion_BBDD_mat gestMat;
	Gestion_BBDD_ResConfm gres;
	GestionBBDD_Eventos gEvent;

	ArrayList<Maquina> maquinas = new ArrayList<>();
	ArrayList<Proyecto> proyectos = new ArrayList<>();
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Material> materiales = new ArrayList<>();
	ArrayList<Evento> eventos = new ArrayList<>();
	ArrayList<ReservasConfirmadas> resConf = new ArrayList<>();
	DefaultTableModel tablaU ;
	
	
	public ControladorMyFab(Vista_MyFab vmy, AccesoOracle bbdd) {
		super();
		this.vmy = vmy;
		this.bbdd = bbdd;
		gres = new Gestion_BBDD_ResConfm(bbdd.conexion);
		gres.consultaReservas(resConf);
		gestionBDUsuarios = new GestionBBDD_Usuarios(bbdd.conexion);
		gestionBDUsuarios.consultaUsuarios(usuarios);
		gestionBDProyectos = new Gestion_BBDD_Proyectos(bbdd.conexion);
		gestionBDProyectos.consultaProyectos(proyectos);
		gEvent = new GestionBBDD_Eventos(bbdd.conexion);
		gEvent.consultaEventos(eventos);
		
		cargarCombo();
		
	}



	private void cargarCombo() {
		for (Usuario usuario : usuarios) {
			vmy.comboBox.addItem(usuario.getId_Soc());
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o == vmy.buttonSalir){
			vmy.dispose();
			
		} else if(o == vmy.btnBuscar){
			buscar();
		} else if(o == vmy.btnLimpiar){
			limpiar();
		}
		
	}


	private void limpiar(){
		
		
		
		try {
			while (vmy.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			while (vmy.table_1.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.table_1.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
	}

	private void buscar() {
		try {
			while (vmy.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			while (vmy.table_1.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.table_1.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		String id = (String) vmy.comboBox.getSelectedItem();
		String nU = "";
		boolean encontrado = false;
		
		for(int x=0; x < usuarios.size(); x++) {
			if(usuarios.get(x).getId_Soc().equalsIgnoreCase(id)){
				tablaU = (DefaultTableModel)vmy.table.getModel();
				tablaU.addRow(new Object[]{usuarios.get(x).getId_Soc(), usuarios.get(x).getNombre(),
						usuarios.get(x).getApellidos(), 
						usuarios.get(x).getCorreo(), usuarios.get(x).getTfno(), usuarios.get(x).getTipo()});
				nU = usuarios.get(x).getId_Soc();
				encontrado = true;
			}
		}
		for(int x=0; x < resConf.size(); x++){
			if(resConf.get(x).getNombreResponsable().equalsIgnoreCase(nU)){
				DefaultTableModel tabla1 = (DefaultTableModel) vmy.table_1.getModel();
				tabla1.addRow(new Object[] { resConf.get(x).getNombreProyecto(), resConf.get(x).getNombreResponsable(), resConf.get(x).getNombreMaquina(),
						resConf.get(x).getFechaI(), resConf.get(x).getFechaF() });
				encontrado = true;
			}
		}
		for(int x=0; x < eventos.size(); x++){
			if(eventos.get(x).getMentor().equalsIgnoreCase(nU)){
				DefaultTableModel tabla2 = (DefaultTableModel) ve.table.getModel();
				tabla2.addRow(new Object[]{
						eventos.get(x).getCod_Ev(),
						eventos.get(x).getMentor(),
						eventos.get(x).getCategoria(),
						eventos.get(x).getDuracion(),
						eventos.get(x).getLugar(),
						eventos.get(x).getFecha()
				});
			}
		}
		if(!encontrado){
			vmy.lblError.setText("El usuario introducido no esta registrado");
		}
	}

}
