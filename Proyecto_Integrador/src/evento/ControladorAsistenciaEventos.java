package evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import portada.GestionBBDDPortada;
import usuario.Usuario;
import evento.Evento;

public class ControladorAsistenciaEventos implements ActionListener{

	//Autor
	VistaEventosRegistrados vEv;
	ArrayList<Evento> eventos = new ArrayList<>();
	ArrayList<Evento> eventosR = new ArrayList<>();
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Usuario> usuariosR = new ArrayList<>();
	AccesoOracle bbdd;
	GestionBBDD_Eventos gBe;
	GestionBBDDPortada gBu;
	
	public ControladorAsistenciaEventos(VistaEventosRegistrados vEv, AccesoOracle bbdd) {
		this.vEv = vEv;
		this.bbdd = bbdd;
		gBe = new GestionBBDD_Eventos(bbdd.conexion);
		gBe.cargarEventos(eventos);
		gBu = new GestionBBDDPortada(bbdd.conexion);
		gBu.cargarUsuarios(usuarios);
		cargarEventosCombo();
	}
	
	public void cargarEventosCombo(){
		vEv.comboEventos.addItem("SELECCIONE");
		int evento=0;
		String mentorDescripcion;
		for(int x=0; x<eventos.size(); x++){
			evento = eventos.get(x).getCodigo_evento();
			mentorDescripcion = "Mentor: "+eventos.get(x).getMentor() +" -- Descripción: "+eventos.get(x).getDescripcion() + ", lugar: " + eventos.get(x).getLugar();
			vEv.comboEventos.addItem(mentorDescripcion);
		}
		//return evento;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == vEv.btnConsultar){
			limpiar();
			limpiar2();
			consultarEvento();
		} else if(o == vEv.btnSalir){
			vEv.dispose();
		} else if(o == vEv.btnLimpiar){
			limpiar();
			limpiar2();
		}
		
	}

	
	private void limpiar() {
		try {
			while (vEv.tableEvento.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vEv.tableEvento.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	
	private void limpiar2() {
		try {
			while (vEv.tableUsuario.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vEv.tableUsuario.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	private void consultarEvento() {
		 int codigo = vEv.comboEventos.getSelectedIndex();
		 ArrayList<Evento> e = new ArrayList<>();
		 gBe.consultarEventosRegistrados(e, codigo);
		 for (Evento evento : e) {
			 DefaultTableModel tabla = (DefaultTableModel) vEv.tableEvento.getModel();
			 tabla.addRow(new Object[]{
					 evento.getMentor(),
					 evento.getDescripcion(),
					 evento.getFecha_inicio(),
					 evento.getFecha_fin(), 
					 evento.getTipo_evento()
			 });	
		}
		 cargarUsuariosEvenrtos();
	}

	private void cargarUsuariosEvenrtos(){
		 int codigo = vEv.comboEventos.getSelectedIndex();
		 ArrayList<Usuario> u = new ArrayList<>();
		 gBe.consultarUsuariosEventos(u, codigo);
		 for (Usuario usuario : u) {
			DefaultTableModel tabla = (DefaultTableModel) vEv.tableUsuario.getModel();
			tabla.addRow(new Object[]{
					usuario.getNombre_usuario(),
					usuario.getApellidos(),
					usuario.getMail()
			});
		}
	}




}
