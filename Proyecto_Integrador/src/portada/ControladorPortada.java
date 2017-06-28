package portada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import OracleAcceso.AccesoOracle;
import maquina.VistaMaquinas;
import material.VistaMateriales;
import myFab.Vista_MyFab;
import pedido.VistaPedidos;
import pideUsuario.ControladorPU;
import pideUsuario.VistaPideU;
import proveedor.VistaProveedor;

import reserva.VistaReservas;
import seleccion.ControladorVistaSeleccion;
import seleccion.Vseleccion;
import usuario.ControladorUsuario;
import usuario.Usuario;
import usuario.VistaUsuarios;

import javax.swing.UIManager;

public class ControladorPortada implements ActionListener{

	
	public boolean userOk = false;
	Vportada vp = new Vportada();
	VistaPideU vpu = new VistaPideU();
	AccesoOracle bbdd;
	GestionBBDDPortada gBDp;
	ArrayList<Usuario> usuariosS = new ArrayList<>();
	Vseleccion vs = new Vseleccion();
//	VistaMaquinas vmaq = new VistaMaquinas();
	VistaMateriales vmat = new VistaMateriales();


	public ControladorPortada (Vportada vp, AccesoOracle bbdd){
		this.vp = vp;
		this.bbdd = bbdd;
		gBDp = new GestionBBDDPortada(bbdd.conexion);
		gBDp.cargarUsuarios(usuariosS);
	}
	



	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == vp.btnSalir){
			vp.dispose();
			bbdd.cerrarBaseDatos();
			System.exit(0);
			
		} else if(o == vp.btnAcceder){
			seleccionUser();
		}
	}


	
	private void seleccionUser() {
		if(vp.comboUS.getSelectedItem().equals("SELECCIONE  USUARIO")){
			JOptionPane.showMessageDialog(null, "Seleccione tipo de usuario");
		} else if(vp.comboUS.getSelectedItem().equals("NUEVO USUARIO")){
			nuevoUsuario();
		} else if(vp.comboUS.getSelectedItem().equals("USUARIOS REGISTRADOS")){
			accesoUsuarios();
		} else if(vp.comboUS.getSelectedItem().equals("ADMINISTRADOR")){
			accesoAdmin();
		}
		
	}






//	private void accesoUsuarios() {
//		UIManager um = new UIManager();
//		um.put("OptionPane.background", Color.white);
//		boolean ok=false;
//		try{
//			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el IDENTIFICADOR DE USUARIO"));
//					for(int x=0; x<usuariosS.size();x++){
//						System.out.println(usuariosS.get(x).getCodigo_usuario());
//					if(usuariosS.get(x).getCodigo_usuario()==id){
//						String apell = JOptionPane.showInputDialog(null, "Identificación ID correcta, ingrese apellido");
//						if(usuariosS.get(x).getApellidos().equalsIgnoreCase(apell)){
//							JOptionPane.showMessageDialog(null, "Ud se ha identificado como " +
//									usuariosS.get(x).getNombre_usuario() +" "+ usuariosS.get(x).getApellidos());
//							
//							userOk = true;
//							acceder();
//							ok = true;
//							vs.lbl_ImagenM.setVisible(true);							
//						}
//					}
//				}
//		}catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(null, "EL Identificador debe ser valor numérico");
//		}
//		
//			if(!ok){
//				JOptionPane.showMessageDialog(null, "Identificación incorrecta");
//			}
//		}
	
	
	
	private void accesoUsuarios() {
		
		
		ControladorPU c = new ControladorPU(vpu, bbdd);
		vpu.setControlador(c);
		vpu.setVisible(true);
		
	}
	
		
	
	private void nuevoUsuario() {
		//vp.dispose();
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		VistaUsuarios vu = new VistaUsuarios();
		vu.btnUsuariosRegistrados.setVisible(false);
		ControladorUsuario cu = new ControladorUsuario(vu, bbdd);
		vu.setVisible(true);
		vu.setControladorUsuario(cu);
	}










	private void accesoAdmin() {
		String passwd;

		try {
			passwd = JOptionPane.showInputDialog(null, "ACCESO ADMINISTRADOR, INTRODUCE CONTRASEÑA");
			if (passwd.equalsIgnoreCase("admin")) {
				JOptionPane.showMessageDialog(null, "Acceso correcto, bienvenido a GestLab");
				acceder();
			} else {
				JOptionPane.showMessageDialog(null, "Identidicación incorrecta");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void acceder() {
		
		if(userOk){
			Vseleccion vs = new Vseleccion ();
			vp.dispose();
			vs.lblMensaje.setVisible(true);
			vs.btnUsuarios.setEnabled(false);
			vs.btnMaquina.setEnabled(false);
			vs.btnPedidos.setEnabled(false);
			vs.btnProveedor.setEnabled(false);
			vs.btnMaterial.setEnabled(false);
			ControladorVistaSeleccion c = new ControladorVistaSeleccion(vs, bbdd);
			vs.setControladorVistaSeleccion(c);
			vs.setVisible(true);
			vmat.btnModificaciones.setEnabled(false);
//			vs.btnMaterial.setForeground(Color.white);

			vs.btnMaterial.setVisible(false);
			vs.btnUsuarios.setVisible(false);
			vs.btnMaquina.setVisible(false);
			vs.btnPedidos.setVisible(false);
			vs.btnProveedor.setVisible(false);
			vs.lbl_ImagenM.setVisible(true);
			vs.lblImagen.setVisible(true);
			
//			vr.comboResponsables.setEnabled(false);
//			rc.setNombreResponsable(id);
			vp.dispose();
		} else {
			Vseleccion vs = new Vseleccion ();
			ControladorVistaSeleccion c = new ControladorVistaSeleccion(vs, bbdd);
			vs.setControladorVistaSeleccion(c);
			vs.setVisible(true);
			vs.lblMensaje.setVisible(true);
			vs.lblMensaje.setText("Ud se ha identificado como ADMINISTRADOR");;
			vp.dispose();
		}
		
	}



}
