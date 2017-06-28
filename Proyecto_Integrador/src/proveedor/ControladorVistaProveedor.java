package proveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;

public class ControladorVistaProveedor implements ActionListener, MouseListener{

	VistaProveedor vp;
	AccesoOracle bbdd;
	ArrayList<Proveedor> proveedores = new ArrayList<>();
	Gestion_BBDD_Proveedores gBBDDprove;
	
	
	public ControladorVistaProveedor(VistaProveedor vp, AccesoOracle bbdd) {
		super();
		this.vp = vp;
		this.bbdd = bbdd;
		gBBDDprove = new Gestion_BBDD_Proveedores(bbdd.conexion);
		gBBDDprove.consultaProveedores(proveedores);
		cargarLista();
	}



	private void cargarLista() {
		for (Proveedor p : proveedores) {
			DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
			tabla.addRow(new Object[]{
					p.getCif(), 
					p.getNombre_proveedor(), 
					p.getMail(),
					p.getTelefono(), 
					p.getDireccion(), 
					p.getCiudad(),
					p.getCp()
					});
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == vp.btnSalir){
			vp.dispose();
		} else if(o == vp.btnIngresar_1){
			nuevoProveedor();
			
		} else if(o == vp.btnLimpiar){
			lipiarCampos();
		} else if(o == vp.btnEliminar){
			bajaProveedor();
		} else if(o == vp.btnModificar){
			modificarProveedor();
		} else if(o == vp.btnNuevo){
			habilitarRegistro();
		}
		
	}



	



	private void modificarProveedor() {
		habilitarRegistro();
		vp.btnIngresar_1.setVisible(false);
		try{
			String cif = vp.textCif.getText();
			String nombre = vp.textNombre.getText();
			String correo = vp.textCorreo.getText();
			String telefono = vp.textTfno.getText();
			String dire = vp.textDirecc.getText();
			String ciudad = vp.textCiudad.getText();
			int cp = Integer.parseInt(vp.textCP.getText());
			if(cif.length()==0 && nombre.length()==0 || correo.length()==0 || telefono.length() == 0 || dire.length() == 0
					|| ciudad.length() == 0 || cp == 0){
				vp.lblError.setText("Revise los campos");
			} else {
				Proveedor p = new Proveedor();
				p.setCif(cif);
				p.setNombre_proveedor(nombre);
				p.setMail(correo);
				p.setTelefono(telefono);
				p.setDireccion(dire);
				p.setCiudad(ciudad);
				p.setCp(cp);
				gBBDDprove.modoficarProveedor(p);
					int fila = vp.table.getSelectedRow();
					proveedores.set(fila, p);
					vp.table.setValueAt(p.getCif(), fila, 0);
					vp.table.setValueAt(p.getNombre_proveedor(), fila, 1);
//					vp.table.setValueAt(p.getDireccion(), fila, 2);
//					vp.table.setValueAt(p.getCiudad(), fila, 3);
//					vp.table.setValueAt(p.getCp(), fila, 4);
					vp.table.setValueAt(p.getTelefono(), fila, 3);
					vp.table.setValueAt(p.getMail(), fila, 2);
					JOptionPane.showMessageDialog(null, "Proveedor modificado");
				
			}
		}catch (Exception e) {
			vp.lblError.setText("REVISE LOS CAMPOS");
		}
		
	}



	private void habilitarRegistro() {
		vp.btnIngresar_1.setVisible(true);
		vp.textCif.setEnabled(true);
		vp.textNombre.setEnabled(true);
		vp.textCorreo.setEnabled(true);
		vp.textCorreo.setEnabled(true);
		vp.textTfno.setEnabled(true);
		vp.textDirecc.setEnabled(true);
		vp.textCiudad.setEnabled(true);
		vp.textCP.setEnabled(true);
	}



	private void lipiarCampos() {
		vp.textCif.setText(null);
		vp.textNombre.setText(null);
		vp.textCorreo.setText(null);
		vp.textDirecc.setText(null);
		vp.textTfno.setText(null);
		vp.textCP.setText(null);
		vp.textCiudad.setText(null);

	}
	
	private void bajaProveedor(){
		try{
			int fila = vp.table.getSelectedRow();
			String cif = proveedores.get(fila).getCif();
			if(gBBDDprove.bajaProveedor(cif)){
				DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
				tabla.removeRow(fila);
				proveedores.remove(fila);
				JOptionPane.showMessageDialog(null, "Se ha dado de  baja al proveedor con CIF " + cif);
			} else {
				vp.lblError.setText("Error");
			}
		}catch (Exception e) {
			vp.lblError.setText("Seleccione un proveedor");
		}
	}



	private void nuevoProveedor() {
		String cif, nombre, correo, tfno,dire, ciudad;
		int cod_po;
		boolean continua = true;
		try{
			cif = vp.textCif.getText();
			nombre = vp.textNombre.getText();
			correo = vp.textCorreo.getText();
			tfno = vp.textTfno.getText();
			dire = vp.textDirecc.getText();
			cod_po = Integer.parseInt(vp.textCP.getText());
			ciudad = vp.textCiudad.getText();
			if(cif.length()==0 || nombre.length()==0 || correo.length()==0 
					|| tfno.length()==0 || dire.length()==0){
				vp.lblError.setText("No puede quedar ningun campo vacio");
				continua = false;
			}
			if(cif.length() > 10){
				vp.lblError.setText("Campo CIF no puede superar 10 digitos");
				continua = false;
			}
			if(nombre.length() > 20){
				vp.lblError.setText("Campo NOMBRE no puede superar 20 digitos");
				continua = false;
			}
			if(correo.length() > 30) {
				vp.lblError.setText("Campo CORREO no puede superar 30 digitos");
				continua = false;
			}
			if(tfno.length() > 9) {
				vp.lblError.setText("Campo TELEFONO no puede superar 9 digitos");
				continua = false;
			}
			if(dire.length() > 30) {
				vp.lblError.setText("Campo DIRECCION no puede superar 30 digitos");
				continua = false;
			} else {
				if(gBBDDprove.compruebaCIF(cif)){
					vp.lblError.setText("EL Cif ya está registrado");
					continua = false;
				} else {
					if(continua){
						Proveedor p = new Proveedor(cif, nombre, dire, ciudad, tfno, correo, cod_po);
						proveedores.add(p);
						if(gBBDDprove.insertarProveedor(p)){
							DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
							tabla.addRow(new Object[] {
									proveedores.get(proveedores.size() - 1).getCif(),
									proveedores.get(proveedores.size() -1).getNombre_proveedor(),
									proveedores.get(proveedores.size() -1).getMail(),
									proveedores.get(proveedores.size() -1).getTelefono(),
									proveedores.get(proveedores.size() -1).getDireccion(),
									proveedores.get(proveedores.size() -1).getCp()
							});
							JOptionPane.showMessageDialog(null, "Proveedor registrado");
							vp.lblError.setText("REGISTRO CORRECTO");
						} else {
							vp.lblError.setText("Error en el registro, vuelva a realizar la operación");
						}
					}
				}
			}
		}catch (Exception e) {
			vp.lblError.setText("Revise los campos");
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		int fila = vp.table.rowAtPoint(e.getPoint());
		vp.textCif.setText(proveedores.get(fila).getCif());
		vp.textNombre.setText(proveedores.get(fila).getNombre_proveedor());
		vp.textDirecc.setText(proveedores.get(fila).getDireccion());
		vp.textTfno.setText(proveedores.get(fila).getTelefono());
		vp.textCorreo.setText(proveedores.get(fila).getMail());
		vp.textCiudad.setText(proveedores.get(fila).getCiudad());
		vp.textCP.setText(proveedores.get(fila).getCp()+"");
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
