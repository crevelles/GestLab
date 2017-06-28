package evento;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;

import javax.crypto.NullCipher;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import portada.GestionBBDDPortada;
import usuario.Usuario;

public class COntroladorEventos implements ActionListener, MouseListener{

	VistaEvento ve = new VistaEvento();
	ArrayList<Evento> eventos = new ArrayList<Evento>();
	ArrayList<Usuario> usuarios = new ArrayList<>();
	AccesoOracle bbdd;
	GestionBBDD_Eventos gBBDDe;
	GestionBBDDPortada gBDu;
	
	
	public COntroladorEventos(VistaEvento ve, AccesoOracle bbdd) {
		super();
		this.ve = ve;
		this.bbdd = bbdd;
		gBBDDe = new GestionBBDD_Eventos(bbdd.conexion);
		gBBDDe.cargarEventos(eventos);
		gBDu = new GestionBBDDPortada(bbdd.conexion);
		gBBDDe.cargarUsuarios(usuarios);
		cargarLista();
	}


	
	
	public void cargarUsuariosCombo(){
		ve.comboUsu.addItem("SELECCIONE");
		for (Usuario usuario : usuarios) {
			String nombre = +usuario.getCodigo_usuario() + " "+usuario.getNombre_usuario() +" "+ usuario.getApellidos() ;
			ve.comboUsu.addItem(nombre);
		}
	}
	
	
	public void cargarEventosCombo(){
		ve.comboEvento.addItem("SELECCIONE");
		int evento=0;
		String mentorDescripcion;
		for(int x=0; x<eventos.size(); x++){
			evento = eventos.get(x).getCodigo_evento();
			mentorDescripcion = "Mentor: "+eventos.get(x).getMentor() +" -- Descripción: "+eventos.get(x).getDescripcion() + ", lugar: " + eventos.get(x).getLugar();
			ve.comboEvento.addItem(mentorDescripcion);
		}
		//return evento;
	}

	public void cargarLista(){
		for (Evento e : eventos) {
			DefaultTableModel tabla = (DefaultTableModel) ve.table.getModel();
			tabla.addRow(new Object[]{
					e.getCodigo_evento(), 
					e.getMentor(),
					e.getTipo_evento(),
					e.getDescripcion(),
					e.getFecha_inicio().substring(0,10),
					e.getFecha_fin().substring(0,10),
					e.getLugar()
					});
		}
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == ve.btnSalir) {
			ve.dispose();
		} else if (o == ve.btnNuevo){
			modificaVentana();
		} else if(o == ve.btnRegistrar){
			registroEvento();
		} else if (o == ve.btnEliminar){
			//eliminarEvento();
			pideAdminEliminarEvento();
		} else if(o == ve.btnAsistencia){
			modificaVentnaAsistencia();
			cargarUsuariosCombo();
			cargarEventosCombo();
		} else if(o == ve.btnAsiste){
			registroAsistencia();
		} else if(o == ve.btnConsultarEventos){
			ve.dispose();
			consultaEventos();
		}
	}



	private void consultaEventos() {
		VistaEventosRegistrados vEv = new VistaEventosRegistrados();
		ControladorAsistenciaEventos c = new ControladorAsistenciaEventos(vEv, bbdd);
		vEv.setControladorAsistenciaEventos(c);
		vEv.setVisible(true);
	}



	private void pideAdminEliminarEvento(){
		String psw = JOptionPane.showInputDialog("Para eliminar un evento debe ser ADMINISTRADOR");
		ve.lblError.setText("Seleccione con el cursor el proyecto que desee eliminar");
		try{
			if(psw.equalsIgnoreCase("admin")){
				eliminarEvento();
			} else {
				JOptionPane.showMessageDialog(null, "Ud no está autorizado");
			}
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		
	}

	private void eliminarEvento() {
	
			int fila = ve.table.getSelectedRow();
			DefaultTableModel tabla = (DefaultTableModel) ve.table.getModel();
			int codEvento = eventos.get(fila).getCodigo_evento();
			if(gBBDDe.borrarEvento(codEvento)){
				JOptionPane.showMessageDialog(null, "Evento " + eventos.get(fila).getCodigo_evento() + " eliminado");
			}
			tabla.removeRow(fila);
			eventos.remove(fila);
		}
		
		
		
	

	private void modificaVentnaAsistencia() {
		ve.lblSeleccioneElEvento.setVisible(true);
		ve.comboEvento.setVisible(true);
		ve.lblUsuario.setVisible(true);
		ve.comboUsu.setVisible(true);
		ve.btnAsiste.setVisible(true);
		ve.scrollPane.setBounds(10, 156, 769, 61);
		ve.textCod.setVisible(true);
		ve.textCateg.setVisible(true);
		ve.textDescrip.setVisible(true);
		ve.textLugar.setVisible(true);
		ve.textMentor.setVisible(true);
		ve.lblRegistro.setVisible(true);
		ve.FechaIni.setVisible(true);
		ve.fechaFin.setVisible(true);
	}

	
	
	private void registroAsistencia() {
		int codigoEvento = 0;
		int x = 0;
		int codigoUsuario = 0;
		try {
			codigoEvento = (int) ve.comboEvento.getSelectedIndex();
			x = ve.comboUsu.getSelectedIndex()-1;
			
			//modifico
			codigoUsuario = usuarios.get(x).getCodigo_usuario();
			if (codigoEvento != 0 && codigoUsuario != 0) {
				if (gBBDDe.compruebaAsistencia(codigoUsuario, codigoEvento)) {
					JOptionPane.showMessageDialog(null, "Usuario ya está registrado en el evento");
				} else {
					System.out.println(codigoUsuario);
					if (gBBDDe.registrarAsistencia(codigoUsuario, codigoEvento)) {
						System.out.println(codigoUsuario);
						JOptionPane.showMessageDialog(null, "Usuario registrado en el evento");
					}
				}
			}
		} catch (Exception e) {
			ve.lblError.setText("Error en el registro, prueba otro usuario");
		}
	}
		
		
	

	
	private void registroEvento() {
		
		boolean continua = true;
		int codEv = eventos.get(eventos.size()-1).getCodigo_evento()+1;
		String codEven = "";
		codEven = String.valueOf(codEv);
		codEven = Integer.toString(codEv);
		ve.textCod.setText(codEven);
		int codiegoEvento = Integer.parseInt((codEven));
		String mentor, tipoEvento, descripcion, fechaI = null, fechaF = null, lugar;
		mentor = ve.textMentor.getText();
		tipoEvento = ve.textCateg.getText();
		descripcion = ve.textDescrip.getText();
		lugar = ve.textLugar.getText();
		if(mentor.length()==0 && tipoEvento.length()==0 && descripcion.length()==0 && lugar.length()==0){
			ve.lblError.setText("Debe rellenar todos los campos");
			continua = false;
		}
		
		try {
			fechaI = ve.FechaIni.getJCalendar().getDayChooser().getDay() + "-"
					+ Integer.toString(ve.FechaIni.getCalendar().get(Calendar.MONTH) + 1) + "-"
					+ ve.FechaIni.getJCalendar().getYearChooser().getYear();
		} catch (NullPointerException e) {
			ve.lblError.setText("Seleccione fecha");
			//continua = false;
		}

		try {
			fechaF = ve.fechaFin.getJCalendar().getDayChooser().getDay() + "-"
					+ Integer.toString(ve.fechaFin.getCalendar().get(Calendar.MONTH) + 1) + "-"
					+ ve.fechaFin.getJCalendar().getYearChooser().getYear();
		} catch (NullPointerException e) {
			ve.lblError.setText("Seleccione fecha");
			//continua = false;
		}
		if(continua){ 
			Evento e = new Evento(codiegoEvento,tipoEvento, descripcion, fechaI, fechaF, mentor, lugar);
			eventos.add(e);
			if(gBBDDe.nuevoEvento(e)){
				JOptionPane.showMessageDialog(null, "Evento registrado");
				DefaultTableModel tabla = (DefaultTableModel)ve.table.getModel();
				tabla.addRow(new Object[] {
						eventos.get(eventos.size() - 1).getCodigo_evento(),
						eventos.get(eventos.size() - 1).getMentor(),
						eventos.get(eventos.size() - 1).getTipo_evento(),
						eventos.get(eventos.size() - 1).getDescripcion(),
						eventos.get(eventos.size() - 1).getFecha_inicio(),
						eventos.get(eventos.size() - 1).getFecha_fin(),
						eventos.get(eventos.size() - 1).getLugar()
				});
			}
			ve.textCod.setText(null);
			ve.textMentor.setText(null);
			ve.textCateg.setText(null);
			ve.textDescrip.setText(null);
			ve.textLugar.setText(null);
		}
	}


	private void modificaVentana() {
		ve.scrollPane.setBounds(10, 106, 769, 214);
		ve.textCod.setVisible(true);
		ve.textCod.setEditable(false);
		ve.textMentor.setVisible(true);
		ve.textCateg.setVisible(true);;
		ve.textDescrip.setVisible(true);;
		ve.FechaIni.setVisible(true);;
		ve.fechaFin.setVisible(true);;
		ve.btnRegistrar.setVisible(true);
		ve.lblRegistro.setVisible(true);
		ve.textLugar.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
