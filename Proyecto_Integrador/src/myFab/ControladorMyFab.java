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
import reserva.Reserva;
import usuario.GestionBBDD_Usuarios;
import usuario.Usuario;

public class ControladorMyFab implements ActionListener{



	
	VistaEvento ve;
	AccesoOracle bbdd;
	GestionBBDD_Usuarios gestionBDUsuarios;
	Gestion_BBDD_ResConfm gestionBDReservas;
	GestionBBDD_Eventos gestionBDEventos;
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Reserva> reservas = new ArrayList<>();
	ArrayList<Evento> eventos = new ArrayList<>();
	Vista_MyFab vmy = new Vista_MyFab();
	
	
	public ControladorMyFab(Vista_MyFab vmy, AccesoOracle bbdd) {
		super();
		this.vmy = vmy;
		this.bbdd = bbdd;
		gestionBDUsuarios = new GestionBBDD_Usuarios(bbdd.conexion);
		gestionBDUsuarios.cargarUsuarios(usuarios);
		gestionBDReservas = new Gestion_BBDD_ResConfm(bbdd.conexion);
		gestionBDReservas.consultaReservas(reservas);
		gestionBDEventos = new GestionBBDD_Eventos(bbdd.conexion);
		gestionBDEventos.cargarEventos(eventos);
		cargarCombo();
		
	}



	private void cargarCombo() {
		for (Usuario usuario : usuarios) {
			String nombre = usuario.getNombre_usuario() + " "+usuario.getApellidos();
			vmy.comboBox.addItem(nombre);
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

	int usarioSeleccionado = vmy.comboBox.getSelectedIndex();

	private void buscar() {
		limpiar();
		int codigo = vmy.comboBox.getSelectedIndex();
		 for (int x=0; x<usuarios.size();x++) {
			if(usuarios.get(x).equals(usuarios.get(codigo))){
				DefaultTableModel tabla = (DefaultTableModel) vmy.tablaUsuario.getModel();
				tabla.addRow(new Object[]{
					usuarios.get(x).getNombre_usuario(),
					usuarios.get(x).getApellidos(),
					usuarios.get(x).getMail(),
					usuarios.get(x).getTelefono(),
					usuarios.get(x).getTipo_usuario()
				});
			}
		}
		String nombreSeleccionado = usuarios.get(codigo).getNombre_usuario() + " "+ usuarios.get(codigo).getApellidos();
		
		for (int i = 0; i < reservas.size(); i++) {
			if(reservas.get(i).getNombre_responsable().equalsIgnoreCase(nombreSeleccionado)){
				DefaultTableModel tabla1 = (DefaultTableModel) vmy.tablaReservas.getModel();
				tabla1.addRow(new Object[]{
					reservas.get(i).getNombre_proyecto(),
					reservas.get(i).getNombre_responsable(),
					reservas.get(i).getNombre_maquina(),
					reservas.get(i).getFecha_inicio(),
					reservas.get(i).getFecha_fin()
				});
			}
		}
		String nombreSeleccionado2 = usuarios.get(codigo).getNombre_usuario();
		ArrayList<Evento> even = new ArrayList<>();
		gestionBDEventos.controlEventosMyFab(even,nombreSeleccionado2);
		for (int i = 0; i < even.size(); i++) {
			DefaultTableModel tabla2 = (DefaultTableModel)vmy.tableEventos.getModel();
			tabla2.addRow(new Object[]{
					even.get(i).getMentor(),
					even.get(i).getDescripcion(),
					even.get(i).getTipo_evento(),
					even.get(i).getFecha_inicio()
			});
		}
	}



	private void limpiar() {

		try {
			while (vmy.tablaUsuario.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.tablaUsuario.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			while (vmy.tablaReservas.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.tablaReservas.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			while (vmy.tableEventos.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmy.tableEventos.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
		}
	}
	

}
