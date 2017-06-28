package pideUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import OracleAcceso.AccesoOracle;
import material.VistaMateriales;
import portada.Vportada;
import seleccion.ControladorVistaSeleccion;
import seleccion.Vseleccion;
import usuario.GestionBBDD_Usuarios;
import usuario.Usuario;

public class ControladorPU implements ActionListener{

	boolean userOk = false;
	VistaPideU vpu;
	Vportada vp  = new Vportada();
	VistaMateriales vmat = new VistaMateriales();
	AccesoOracle bbdd;
	GestionBBDD_Usuarios gBBDDu;
	ArrayList<Usuario> usuarios = new ArrayList<>();
	
	
	public ControladorPU(VistaPideU vpu, AccesoOracle bbdd) {
		super();
		this.vpu = vpu;
		this.bbdd = bbdd;
		gBBDDu = new GestionBBDD_Usuarios(bbdd.conexion);
		gBBDDu.cargarUsuarios(usuarios);
		limpiarCampos();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == vpu.btnSalir){
			vpu.dispose();
		} else if(o == vpu.btnAcceso){
			pideUsuario();
		}
		
	}


	private void limpiarCampos(){
		vpu.textID.setText(null);
		vpu.textPassw.setText(null);
	}
	private void pideUsuario() {
		boolean userOK = true;
		String codUser = vpu.textID.getText();
		String passwd = vpu.textPassw.getText();
		boolean acceso = false;
		int codigoUsuario = 0;
		if(codUser.length()==0 || passwd.length()==0){
			vpu.lblError.setText("No debe dejar campos vacíos");
		} else {
			try{
				codigoUsuario = Integer.parseInt(codUser);
			}catch (NumberFormatException e) {
				vpu.lblError.setText("El campo IDENTIFICADOR solo puede ser numérico");
			}
			for (Usuario usuario : usuarios) {
				if(usuario.getCodigo_usuario()==codigoUsuario && usuario.getApellidos().equalsIgnoreCase(passwd)){
						acceso = true;
						userOK = false;
						accedeer();
				}
			}
			if(!acceso){
				vpu.lblError.setText("Usuario/passwd erroeneo");
				limpiarCampos();
			}
		}
		
		
	}



private void accedeer() {
		
		if(!userOk){
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
			vs.btnMaterial.setVisible(false);
			vs.btnUsuarios.setVisible(false);
			vs.btnMaquina.setVisible(false);
			vs.btnPedidos.setVisible(false);
			vs.btnProveedor.setVisible(false);
			vs.lbl_ImagenM.setVisible(true);
			vs.lblImagen.setVisible(true);
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


