package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import usuario.GestionBBDD_Usuarios;
import usuario.Usuario;

public class ConstroladorVistaUsuariosProyectos implements ActionListener{
	
	VistaUsuariosProyectos vup;
	AccesoOracle bbdd;
	Gestion_BBDD_Proyectos gBBDD;
	GestionBBDD_Usuarios gBBDDu;
	ArrayList<Proyecto> proyectos = new ArrayList<>();
	ArrayList<Usuario> usuarios = new ArrayList<>();

	public ConstroladorVistaUsuariosProyectos(VistaUsuariosProyectos vup, AccesoOracle bbdd) {
		super();
		this.vup = vup;
		this.bbdd = bbdd;
		gBBDD = new Gestion_BBDD_Proyectos(bbdd.conexion);
		gBBDD.consultaProyectos(proyectos);
		cargarComboProyectos();
		gBBDDu = new GestionBBDD_Usuarios(bbdd.conexion);
		gBBDDu.cargarUsuarios(usuarios);
		cargarComboUsuarios();
	}



	private void cargarComboUsuarios() {
		for (Usuario usuario : usuarios) {
			vup.comboUsuarios.addItem(usuario.getNombre_usuario() + " " + usuario.getApellidos());
		}
		
	}



	private void cargarComboProyectos() {
		for (Proyecto proyecto : proyectos) {
			vup.comboProyectos.addItem(proyecto.getNombre_proyecto());
		}	
	}

	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == vup.btnSalir){
			vup.dispose();
		} else if(o == vup.btnConsultarUsuProyectos){
			consultarUsuariosProyectos();
		}
		
	}


	private void limpiar() {
		try {
			while (vup.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vup.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}

	private void consultarUsuariosProyectos() {
		limpiar();
		int codigoProyecto = vup.comboProyectos.getSelectedIndex()+1;
		ArrayList<Usuario> usu = new ArrayList<Usuario>();
		gBBDDu.consultarUsuariosEnProyectos(codigoProyecto, usu);
		for (Usuario usuario : usu) {
			DefaultTableModel tabla = (DefaultTableModel) vup.table.getModel();
			tabla.addRow(new Object[]{
				usuario.getNombre_usuario(),
				usuario.getApellidos(),
				usuario.getMail()	
			});
			
		}
	}

}
