package reserva;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSliderUI;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import OracleAcceso.AccesoOracle;
import evento.Evento;
import evento.GestionBBDD_Eventos;
import evento.VistaEventosRegistrados;
import maquina.ControladorMaquinas;
import maquina.GestionBBDD_Maquinas;
import maquina.Maquina;
import maquina.VistaMaquinas;
import material.Gestion_BBDD_mat;
import material.Material;
import material.VistaMateriales;
import portada.GestionBBDDPortada;
import proyecto.ConstroladorVistaProyectos;
import proyecto.Gestion_BBDD_Proyectos;
import proyecto.Proyecto;
import proyecto.VistaProyectos;
import usuario.GestionBBDD_Usuarios;
import usuario.Usuario;

public class ControladorVistaReserva implements ActionListener, MouseListener {

	int contador = 0;
	AccesoOracle bbdd;

	VistaReservas vr = new VistaReservas();
	
	GestionBBDD_Maquinas gBDmaq;
	GestionBBDDPortada gBDus;
	Gestion_BBDD_Proyectos gBDp;
	Gestion_BBDD_mat gBDmat;
	Gestion_BBDD_ResConfm gBDres;
	

	ArrayList<Usuario>   usuarios  = new ArrayList<>();
	ArrayList<Maquina>   maquinas  = new ArrayList<>();
	ArrayList<Proyecto>  proyectos = new ArrayList<>();
	ArrayList<Material>  materiales= new ArrayList<>();
	ArrayList<Reserva>   reservas  = new ArrayList<>();

	

	public ControladorVistaReserva(VistaReservas vr, AccesoOracle bbdd) {
		this.vr = vr;
		this.bbdd = bbdd;
		gBDmaq = new GestionBBDD_Maquinas(bbdd.conexion);
		gBDmaq.consultaMaquinas(maquinas);
		gBDus = new GestionBBDDPortada(bbdd.conexion);
		gBDus.cargarUsuarios(usuarios);
		gBDp = new Gestion_BBDD_Proyectos(bbdd.conexion);
		gBDp.consultaProyectos(proyectos);
		gBDmat = new Gestion_BBDD_mat(bbdd.conexion);
		gBDmat.consultaMaterial(materiales);
		gBDres = new Gestion_BBDD_ResConfm(bbdd.conexion);
		gBDres.consultaReservas(reservas);
		cargarComboUser();
		cargarComboProyectos();
		cargarComboMaterial();
		cargarStockCombo();
		cargarComboMaquinas();
		cargarReservas();
	}

	private void cargarReservas() {

		//int filaMaquina = vr.comboMaq.getSelectedIndex();
		for (int i = 0; i < reservas.size(); i++) {
			DefaultTableModel tabla = (DefaultTableModel) vr.table.getModel();
			tabla.addRow(new Object[] { reservas.get(i).getNombre_proyecto(), reservas.get(i).getNombre_responsable(),
					reservas.get(i).getNombre_maquina(), reservas.get(i).getFecha_inicio(),
					reservas.get(i).getFecha_fin() });
		}
		
	}

	private void cargarComboMaterial() {
		String nombreMaterial ="";
		for (int i = 0; i < materiales.size(); i++) {
			nombreMaterial = materiales.get(i).getNombre_material();
			if(materiales.get(i).getTipo_material().equalsIgnoreCase("impresión") &&
					materiales.get(i).getStock() > 0){
					vr.comboMat.addItem(nombreMaterial);
			}
		}
	}
	
	private void cargarStockCombo(){
		for (int i = 0; i < materiales.size(); i++) {
			if(materiales.get(i).getTipo_material().equalsIgnoreCase("impresión")){
				String nombreStock = materiales.get(i).getNombre_material() +"- DISPONIBLE: "+ materiales.get(i).getStock();
				vr.comboStock.addItem(nombreStock);
			}
		}
	}
	
	public void cargarComboUser(){
		String nombreUsuario="";
		for (int i = 0; i < usuarios.size(); i++) {
			nombreUsuario = usuarios.get(i).getNombre_usuario()+" "+usuarios.get(i).getApellidos();
			vr.comboResponsables.addItem(nombreUsuario);
		}
	}
	public void cargarComboProyectos(){
		String nombreProyecto="";
		for (int i = 0; i < proyectos.size(); i++) {
			nombreProyecto = proyectos.get(i).getNombre_proyecto();
			vr.comboProyectos.addItem(nombreProyecto);
		}
	}
	public void cargarComboMaquinas(){
		String nM = " ";
		for (int i = 0; i < maquinas.size(); i++) {
			if( maquinas.get(i).getDisponibilidad().equals("DISPONIBLE")){
				nM = maquinas.get(i).getNombre_maquina();
				vr.comboMaq.addItem(nM);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == vr.btnSalir){
			vr.dispose();
		} else if(o == vr.btnReservar){
			reservarMaquina();
		} else if(o == vr.btnCancelar){
			vr.lblError.setText("Debe seleccionar con el cursor la RESERVA que desee cancelar");
			cancelarReserva();
		}
	}
	
	
	


	private void limpiarTabla() {
		try {
			while (vr.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vr.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	
	
	
	private void cancelarReserva() {
		try {
			int seleccion = vr.table.getSelectedRow();
			String fechaI = reservas.get(seleccion).getFecha_inicio();
			String nombreMaquina = reservas.get(seleccion).getNombre_maquina();
			String psw = JOptionPane.showInputDialog(null,
					"Para cancelar una reserva ingrese la contraseña del ADMNISTRADOR");
			if (psw.equalsIgnoreCase("admin")) {
				if (gBDres.cancelaReserva(fechaI, nombreMaquina)) {
					reservas.remove(seleccion);
					limpiarTabla();
					cargarReservas();
					JOptionPane.showMessageDialog(null, "Reserva cancelada");
					vr.lblError.setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Contraseña invalida");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	private void reservarMaquina() {
		int codigoMaquina = 0;
		boolean continua = true;
		java.util.Date fechaActual = new Date();
		
//		if(fechaActual.before(vr.FechaI.getDate())){
//			System.out.println("Mal fecha");
//		}
		
		String fechaI="", fechaF="";
		int cant = 0;
		int codigoProyecto = vr.comboProyectos.getSelectedIndex();
		codigoMaquina  = vr.comboMaq.getSelectedIndex(); 
		String codigoMat = (String) vr.comboMat.getSelectedItem();
		String nResponsable = (String) vr.comboResponsables.getSelectedItem();
		String nMaquina = (String) vr.comboMaq.getSelectedItem();
		String nProyecto = (String) vr.comboProyectos.getSelectedItem();
		
		int idU = 0;
		
		for (int i = 0; i < usuarios.size(); i++) {
			String nom = usuarios.get(i).getNombre_usuario() + " "+ usuarios.get(i).getApellidos();
			if(nom.equalsIgnoreCase(nResponsable)){
				idU = usuarios.get(i).getCodigo_usuario();
			}
		}
		
		try {
			if (vr.FechaI.getCalendar().after(vr.FechaF.getCalendar())) {
				vr.lblError.setText("La fecha final no puede ser anterior a la inicial");
				continua = false;
			}
		} catch (Exception e) {
			vr.lblError.setText("Seleccione fecha");
			continua = false;
		}

		try {
			fechaI = vr.FechaI.getJCalendar().getDayChooser().getDay() + "-"
					+ Integer.toString(vr.FechaI.getCalendar().get(Calendar.MONTH) + 1) + "-"
					+ vr.FechaI.getJCalendar().getYearChooser().getYear();
		} catch (NullPointerException e) {
			vr.lblError.setText("Seleccione fecha");
			continua = false;
		}

		try {
			fechaF = vr.FechaF.getJCalendar().getDayChooser().getDay() + "-"
					+ Integer.toString(vr.FechaF.getCalendar().get(Calendar.MONTH) + 1) + "-"
					+ vr.FechaF.getJCalendar().getYearChooser().getYear();
		} catch (NullPointerException e) {
			vr.lblError.setText("Seleccione fecha");
			continua = false;
		}
		
		
		if (vr.comboCant.getSelectedIndex() == 1) {
			cant = 1;
		} else if (vr.comboCant.getSelectedIndex() == 2) {
			cant = 5;
		} else if (vr.comboCant.getSelectedIndex() == 3) {
			cant = 10;
		} else if (vr.comboCant.getSelectedIndex() == 4) {
			cant = 20;
		} else if (vr.comboCant.getSelectedIndex() == 5) {
			cant = 30;
		} else if (vr.comboCant.getSelectedIndex() == 6) {
			cant = 50;
		} else if (vr.comboCant.getSelectedIndex() == 7) {
			cant = 70;
		} else if (vr.comboCant.getSelectedIndex() == 8) {
			cant = 100;
		} else if (vr.comboCant.getSelectedIndex() == 9) {
			cant = 120;
		} else if (vr.comboCant.getSelectedIndex() == 10) {
			cant = 150;
		} else if (vr.comboCant.getSelectedIndex() == 11) {
			cant = 200;
		}
		


			
		
		else if (fechaI.length() == 0 || fechaF.length() == 0) {
			vr.lblError.setText("Seleccione una fecha");
			continua = false;
		} else if (vr.comboMat.getSelectedItem().equals("SELECCIONE")) {
			vr.lblError.setText("Seleccione el codigo del material");
			continua = false;
		} else if (vr.comboMaq.getSelectedItem().equals("SELECCIONE")) {
			vr.lblError.setText("Seleccione máquina");
			continua = false;
		} else if (vr.comboResponsables.getSelectedItem().equals("SELECCIONE")) {
			vr.lblError.setText("Seleccione RESPONSABLE del proyecto");
			continua = false;
		} else if (vr.comboProyectos.getSelectedItem().equals("SELECCIONE")) {
			vr.lblError.setText("Seleccione el PROYECTO asociado a la reserva");
			continua = false;
		} else if (vr.comboCant.getSelectedItem().equals("SELECCIONE")) {
			vr.lblError.setText("Seleccione CANTIDAD de material que usará");
			continua = false;
		}
		
		
		if (gBDres.compruebaFecha(fechaI,fechaF, codigoMaquina)) {
			continua = false;
			vr.lblError.setText("La máquina seleccionada está ocupada en la fecha seleccionada");
			String proxReserva;
			proxReserva = gBDres.siguienteFecha(codigoMaquina).getFecha_fin();
			JOptionPane.showMessageDialog(null, "La máquina seleccionada está ocupada hasta : "+proxReserva.substring(0,10)+ " (inclusive)");
		}	
		
		if (continua) {
			// modificacion de stock
			for (int i = 0; i < materiales.size(); i++) {
				if (materiales.get(i).getNombre_material().equalsIgnoreCase(codigoMat)){
					Material ma = materiales.get(i);;

					if (ma.getStock() > cant) {
						ma.setStock(ma.getStock() - cant);
						gBDmat.modificaStock(ma);
						if (continua) {
							Reserva rc1 = new Reserva(codigoProyecto, codigoMaquina,idU, fechaI, fechaF, nResponsable, nMaquina, nProyecto);
							reservas.add(rc1);
							gBDres.insertarReserva(rc1);

							DefaultTableModel tabla = (DefaultTableModel) vr.table.getModel();
							tabla.addRow(new Object[] {
									reservas.get(reservas.size() - 1).getNombre_proyecto(),
									reservas.get(reservas.size() - 1).getNombre_responsable(),
									reservas.get(reservas.size() - 1).getNombre_maquina(),
									reservas.get(reservas.size() - 1).getFecha_inicio(),
									reservas.get(reservas.size() - 1).getFecha_fin()
									});
							vr.lblError.setForeground(Color.BLUE);
							vr.lblError.setText("RESERVA REALIZADA");
							JOptionPane miBoton = new JOptionPane();
							miBoton.showMessageDialog(null, "RESERVA REALIZADA");
							actualizaComboStock();
							if(ma.getStock()==0){
								String nombreMat = ma.getNombre_material();
								vr.comboMat.removeItem(nombreMat);
							}
						}

					} else if (ma.getStock() == cant) {
						ma.setStock(ma.getStock() - cant);
						materiales.remove(i);
						gBDmat.modificaStock(ma);

						if (continua) {
							Reserva rc1 = new Reserva(codigoProyecto, codigoMaquina,idU, fechaI, fechaF, nResponsable, nMaquina, nProyecto);
							// vr.lblOKimagen.setVisible(true);
							reservas.add(rc1);
							gBDres.insertarReserva(rc1);

							DefaultTableModel tabla = (DefaultTableModel) vr.table.getModel();
							tabla.addRow(new Object[] { 
									reservas.get(reservas.size() - 1).getNombre_proyecto(),
									reservas.get(reservas.size() - 1).getNombre_responsable(),
									reservas.get(reservas.size() - 1).getNombre_maquina(),
									reservas.get(reservas.size() - 1).getFecha_inicio(),
									reservas.get(reservas.size() - 1).getFecha_fin()
									});
							vr.lblError.setForeground(Color.BLUE);
							vr.lblError.setText("RESERVA REALIZADA");
							JOptionPane.showMessageDialog(null, "RESERVA REALIZADA");
							if(ma.getStock()==0){
								String nombreMat = ma.getNombre_material();
								vr.comboMat.removeItem(nombreMat);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "No disponemos de la cantidad del material selecciondo");
						JOptionPane.showMessageDialog(null, "Cantidad máxima: " + ma.getStock());
						continua = false;
					}
				}
			}
		}
		}
		
		
	private void actualizaComboStock() {
		vr.comboStock.removeAllItems();
		for (int i = 0; i < materiales.size(); i++) {
			if(materiales.get(i).getTipo_material().equalsIgnoreCase("impresión")){
				String m = materiales.get(i).getNombre_material() +"- DISPONIBLE: "+ materiales.get(i).getStock();
				vr.comboStock.addItem(m);
//				if(materiales.get(i).getStock()==0){
//					vr.comboStock.remove(i);
//				}
			}
		}		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	

}
