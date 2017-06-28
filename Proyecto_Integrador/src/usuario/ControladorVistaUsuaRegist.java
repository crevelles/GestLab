package usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import reserva.Gestion_BBDD_ResConfm;
import reserva.Reserva;
import reserva.VistaReservas;

public class ControladorVistaUsuaRegist implements ActionListener, MouseListener{
	
	
	VistaUsuariosRegistrados vur;
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	AccesoOracle bbdd;
	GestionBBDD_Usuarios gBBDDu;
	

	public ControladorVistaUsuaRegist(VistaUsuariosRegistrados vur,AccesoOracle bbdd) {
		super();
		this.vur = vur;
		this.bbdd = bbdd;
		gBBDDu = new GestionBBDD_Usuarios(bbdd.conexion);
		gBBDDu.cargarUsuarios(usuarios);
		cargarLista();
	}
	
	
	public void cargarLista(){
		for (Usuario u : usuarios) {
			DefaultTableModel tabla = (DefaultTableModel) vur.table.getModel();
			tabla.addRow(new Object[]{
					u.getCodigo_usuario(),
					u.getNombre_usuario(),
					u.getApellidos(), 
					u.getMail(),
					u.getTelefono(), 
					u.getTipo_usuario()
					});
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o == vur.btnSalir) {
			vur.dispose();
		}
		if(o == vur.btnEliminar) {
			eliminaUsuario();
		}
		if(o == vur.btnBuscar) {
			buscarUsuario();
		}
		if(o == vur.btnModificar) {
			modificaUsuario();
		}
		if(o == vur.btnLimpiar) {
			limpiarBusqueda();
		}
		if(o == vur.btnModificarId){
			modificaId();
		}
		
		
		
	}
	
	
	
	

	private void modificaId() {
		try{
			String mensaje = JOptionPane.showInputDialog("Solo puede modificar el ID un administrador");
			if(mensaje.equalsIgnoreCase("admin")){
				vur.textId.setEditable(true);
				JOptionPane.showMessageDialog(null, "Acceso correcto");
			} else {
				JOptionPane.showMessageDialog(null, "Acceso denegado, contacte con el administrador");
			}
		}catch (NullPointerException e) {
			vur.lblError.setText("Error");
		}
	}


	private void limpiarBusqueda() {
		vur.textId.setText(null);
		vur.textNombre.setText(null);
		vur.textApellidos.setText(null);
		vur.textEmail.setText(null);
		vur.textTfno.setText(null);
		vur.textTipoUs.setText(null);
		vur.lblError.setText(null);
	}


	int contador = 0;

	private void modificaUsuario() {
		contador++;
		if (contador > 0) {
			vur.textNombre.setEditable(true);
			vur.textApellidos.setEditable(true);
			// vur.textId.setEditable(true);
			vur.textEmail.setEditable(true);
			vur.textTfno.setEditable(true);
			vur.textTipoUs.setEditable(true);
		}
		try {
			try{
				int fila = vur.table.getSelectedRow();
				Usuario u = new Usuario();
				DefaultTableModel tabla = (DefaultTableModel) vur.table.getModel();
				u.setCodigo_usuario(Integer.parseInt(vur.textId.getText()));
				u.setNombre_usuario(vur.textNombre.getText());
				u.setApellidos(vur.textApellidos.getText());
				u.setMail(vur.textEmail.getText());
				u.setTelefono(vur.textTfno.getText());
				u.setTipo_usuario(vur.textTipoUs.getText());
				// gBBDDu.modificarUsuario(u);

				if(gBBDDu.modificarUsuario(u)){
					usuarios.set(fila, u);
					tabla.setValueAt(u.getTipo_usuario(), fila, 0);
					tabla.setValueAt(u.getNombre_usuario(), fila, 1);
					tabla.setValueAt(u.getApellidos(), fila, 2);
					tabla.setValueAt(u.getMail(), fila, 3);
					tabla.setValueAt(u.getTelefono(), fila, 4);
					tabla.setValueAt(u.getTipo_usuario(), fila, 5);
					if(contador>1){
						JOptionPane.showMessageDialog(null, "Usuario modificado");
					}
					
				} else {
					vur.lblError.setText("Error en la modificacion");
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
		} catch (IndexOutOfBoundsException e) {
			vur.lblError.setText("Warning!!!!");
		}
		
		
		
		
	}

	
	private boolean buscarUsuario() {
		boolean encontrado = false;
		//vur.textId.setEditable(true);
		vur.textNombre.setEditable(true);
		vur.textApellidos.setEditable(true);
		String nombre, apellidos;
		//int identificador;
		nombre = vur.textNombre.getText().toLowerCase();
		apellidos = vur.textApellidos.getText().toLowerCase();
		
		try {
			if (nombre.length() == 0 && apellidos.length() == 0) {
				vur.lblError.setText("Debe introducir  Nombre y Apellidos");
			} else {
				for (Usuario usuario : usuarios) {
					if(usuario.getNombre_usuario().equalsIgnoreCase(nombre) && usuario.getApellidos().equalsIgnoreCase(apellidos)) {
						vur.textId.setText(usuario.getCodigo_usuario() + "");
						vur.textNombre.setText(usuario.getNombre_usuario());
						vur.textApellidos.setText(usuario.getApellidos());
						vur.textEmail.setText(usuario.getMail());
						vur.textTfno.setText(usuario.getTelefono());
						vur.textTipoUs.setText(usuario.getTipo_usuario());
						encontrado = true;
						vur.lblError.setText("");
					}
				}
			}
			if (!encontrado) {
				vur.lblError.setText("Usuario NO registrado");
				vur.textNombre.setText(null);
				vur.textApellidos.setText(null);
				vur.textEmail.setText(null);
				vur.textTfno.setText(null);
				vur.textTipoUs.setText(null);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return encontrado;
	}


	private void eliminaUsuario() {
		if(vur.textId.getText().equals("")){
			vur.lblError.setVisible(true);
			vur.lblError.setText("Seleccione Usuario");
		} else {
			int cod = Integer.parseInt(vur.textId.getText()+"");
			int fila = vur.table.getSelectedRow();
			vur.textId.setText(null);
			vur.textNombre.setText(null);
			vur.textApellidos.setText(null);
			vur.textEmail.setText(null);
			vur.textTfno.setText(null);
			vur.textTipoUs.setText(null);
			DefaultTableModel tablaMod = (DefaultTableModel) vur.table.getModel();
			tablaMod.removeRow(fila);
			usuarios.remove(fila);
			if(gBBDDu.eliminarUsuario(cod)){
				JOptionPane.showMessageDialog(null, "Usuario eliminado");
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == vur.table){
			int fila = vur.table.rowAtPoint(e.getPoint());
			vur.textId.setText(usuarios.get(fila).getCodigo_usuario()+"");
			vur.textNombre.setText(usuarios.get(fila).getNombre_usuario());
			vur.textApellidos.setText(usuarios.get(fila).getApellidos());
			vur.textEmail.setText(usuarios.get(fila).getMail());
			vur.textTfno.setText(usuarios.get(fila).getTelefono());
			vur.textTipoUs.setText(usuarios.get(fila).getTipo_usuario());
		} else {
			vur.lblError.setText("Error");
		}
		
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
