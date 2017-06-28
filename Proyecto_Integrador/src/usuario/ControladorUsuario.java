package usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Templates;

import OracleAcceso.AccesoOracle;
import material.VistaMateriales;
import oracle.net.aso.n;
import portada.Vportada;
import seleccion.ControladorVistaSeleccion;
import seleccion.Gestion_BBDD_Seleccion;
import seleccion.Vseleccion;

public class ControladorUsuario implements ActionListener{

	
	VistaUsuarios vu;
	public ArrayList <Usuario> usuarios = new ArrayList<>();
	AccesoOracle bbdd;
	GestionBBDD_Usuarios gestionBBDDUsuarios;
	VistaMateriales vmat = new VistaMateriales();
	Vportada vp = new Vportada();
	
	public ControladorUsuario(VistaUsuarios vu,AccesoOracle bbdd) {
		this.vu = vu;
		this.bbdd = bbdd;
		gestionBBDDUsuarios = new GestionBBDD_Usuarios(bbdd.conexion);
		gestionBBDDUsuarios.cargarUsuarios(usuarios);
		vu.textIDsocio.setText(usuarios.get(usuarios.size()-1).getCodigo_usuario()+1+"");
		//vDept.textCodigo.setText(departamentos.get(departamentos.size()-1).getCodigo()+10+"");
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		
		if(o == vu.btnRegistrar){
			registroUsuario();	
		}
		if(o == vu.btnSalir){
			vu.dispose();
		}
		if(o == vu.btnUsuariosRegistrados){
			verUsuarios();
			vu.dispose();
		}
		if(o == vu.btnLimpiar) {
			limpiaRegistro();
		}
		
		
		}
		
	

	private void limpiaRegistro() {
		vu.lblCheck.setVisible(false);
		vu.lblError.setText(null);
		vu.textNombre.setText(null);
		vu.textApellidos.setText(null);
		vu.textIDsocio.setText(null);
		vu.textCorreo.setText(null);
		vu.textTelefono.setText(null);
	}

	private void verUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		VistaUsuariosRegistrados vur = new VistaUsuariosRegistrados();
		ControladorVistaUsuaRegist c =new ControladorVistaUsuaRegist(vur, bbdd);
		vur.setCOntroladorUsuariosRegistrados(c);
		vur.setVisible(true);
	}
	
	

	
	private void registroUsuario() {
		boolean okk = false;
		vu.lblCheck.setVisible(false);
		int codigoUsuario = (usuarios.get(usuarios.size()-1).getCodigo_usuario()+1);
		try{
			
			vu.textIDsocio.setEnabled(false);
			//vu.textIDsocio.setText(cod_usuario+"");
			String  nombre, apellidos, correo, tfno, tipo = "";
			boolean ok = true;
			nombre = vu.textNombre.getText();
			apellidos = vu.textApellidos.getText();
			correo = vu.textCorreo.getText();
			tfno = vu.textTelefono.getText();
			if(vu.rdbtAsiste.isSelected()){
				tipo = "Asistente";
			} else if(vu.rdbtnResponsable.isSelected()){
				tipo = "Responsable";
			} else if(vu.rdbtnSocio.isSelected()) {
				tipo = "Socio";
			}

			if (!vu.rdbtAsiste.isSelected() && !vu.rdbtnResponsable.isSelected() && !vu.rdbtnSocio.isSelected()) {
				vu.lblError.setText("Seleccione el tipo de usuario");
			} else if(nombre.length()==0){
				vu.lblError.setText("Revise el campo nombre");
			} else if(apellidos.length()==0){
				vu.lblError.setText("Revise el campo apellidos");
			}else if (tfno.length() != 9 || !tfno.matches("[0-9]*")) {
				vu.lblError.setText("Revise el telefono");
			} else if (!correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
				vu.lblError.setText("Correo no valido");
			} else {
				// if(!gestionBBDDUsuarios.compueboRegistro(cod_usuario)){
						Usuario u = new Usuario(codigoUsuario, nombre, apellidos, correo, tfno, tipo);
						gestionBBDDUsuarios.insertarUsuario(u);
						usuarios.add(u);
						vu.lblError.setForeground(Color.BLUE);
						vu.lblError.setText("Usuario registrado");
						vu.lblCheck.setVisible(true);
						vu.btnSalir.setVisible(true);
						okk = true;
						if(okk){
							JOptionPane.showMessageDialog(null, "Usuario registrado");
							JOptionPane.showMessageDialog(null, "Anote su IDENTIFICADOR: " + codigoUsuario);
							accesoUsuario();
							vu.dispose();
							vp.dispose();
						}
//					} else {
//						vu.lblError.setText("EL IDENTIFICADOR YA ESTA REGISTRADO");
//					}
			}
		}catch (IndexOutOfBoundsException e) {
			vu.lblError.setText("Error en el registro de usuario");
		}
		
		
	}
		
		

	private boolean compruebaID(int Id_Soc) {
		boolean encontrado = false;
		for (Usuario usuario : usuarios) {
			if(usuario.getCodigo_usuario()==Id_Soc){
				encontrado = true;
			}
		}
		return encontrado;
	}

	
	public void accesoUsuario(){
		//vp.dispose();
		Vseleccion vs = new Vseleccion ();
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
//		vs.btnMaterial.setForeground(Color.white);

		vs.btnMaterial.setVisible(false);
		vs.btnUsuarios.setVisible(false);
		vs.btnMaquina.setVisible(false);
		vs.btnPedidos.setVisible(false);
		vs.btnProveedor.setVisible(false);
		vs.lbl_ImagenM.setVisible(true);
		vs.lblImagen.setVisible(true);

	}

	
}
