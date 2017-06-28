package material;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import oracle.jdbc.driver.Message;
import reserva.ControladorVistaReserva;

public class COntroladorVistaMaterial implements ActionListener, MouseListener{

	VistaMateriales vmat;
	ArrayList <Material> materiales = new ArrayList<Material>();
	AccesoOracle bbdd;
	Gestion_BBDD_mat gbbddMat;
	ControladorVistaReserva cv;
	
	
	public COntroladorVistaMaterial(VistaMateriales vmat,AccesoOracle bbdd) {
		super();
		this.vmat = vmat;
		this.bbdd = bbdd;
		gbbddMat = new Gestion_BBDD_mat(bbdd.conexion);
		gbbddMat.consultaMaterial(materiales);
		cargarLista();
	}

	
	public void cargarLista(){
		boolean control = true;
		for (Material m : materiales) {
			DefaultTableModel tabla = (DefaultTableModel) vmat.table.getModel();
			tabla.addRow(new Object[]{
					m.getCodigo_material(), 
					m.getNombre_material(), 
					m.getDescripcion(),
					m.getTipo_material(), 
					m.getStock()});
			if(m.getTipo_material().equalsIgnoreCase("impresión")){
				if(m.getStock() <= 10)
				control = false;
			}
		}
		if(!control){
			JOptionPane.showMessageDialog(null, "Revise el Stock y contacte con el proveedor");
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == vmat.btnSalirr) {
			vmat.dispose();
		} 
		if(o == vmat.btnNuevo){
			vmat.btnAñadir.setVisible(true);
			setCodigo();
		} 
		if(o == vmat.btnLimpiar){
			limpiaRegistro();
		}
		if(o == vmat.btnBuscar){
			buscar();
		}if(o == vmat.btnModificar){
			modificaStock();
		}
		if (o == vmat.btnModificaciones){
			habilitaModificar();
		}
		if(o == vmat.btnAñadir){
			registroMaterial();
		}
		if(o == vmat.btnEliminar){
			eliminarMaterial();
		}
		
		
		
	}
	

	private void limpiar() {
		try {
			while (vmat.table.getColumnCount() > 1) {
				DefaultTableModel t = (DefaultTableModel) vmat.table.getModel();
				t.removeRow(0);
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	



	private void habilitaModificar() {
		vmat.btnModificar.setVisible(true);;
		vmat.textStock.setEditable(true);
		vmat.checkCOnfirm.setVisible(true);
		vmat.lblSeleModi.setVisible(true);
		vmat.lblSeleModi.setEnabled(true);
	}
		
	public void eliminarMaterial(){
		int fila = vmat.table.getSelectedRow();
		int cod = materiales.get(fila).getCodigo_material();
		if(gbbddMat.eliminarMaterial(cod)){
			materiales.remove(fila);
			DefaultTableModel tabla = (DefaultTableModel) vmat.table.getModel();
			tabla.removeRow(fila);
			JOptionPane.showMessageDialog(null, "Material con código " + cod + " eliminado");
		} else {
			vmat.lblError.setText("Error en el borrado");
		}
		
		
	}
		
		
	public void setCodigo(){
		int cod = materiales.get(materiales.size()-1).getCodigo_material()+10;
		vmat.textCod.setText(cod+"");
		vmat.textNombre.setEditable(true);
		vmat.textDescrip.setEditable(true);
		//vmat.textTipo.setEditable(true);
		vmat.textStock.setEditable(true);
	}


	public void vantanaConfirmacion(String text){
		JOptionPane miVentana = new JOptionPane();
		miVentana.setForeground(Color.CYAN);
		miVentana.setBackground(Color.GREEN);
		//miVentana.showMessageDialog(null, text);
	}



	private void modificaStock() {
		try {
			int fila = vmat.table.getSelectedRow();
			Material m = new Material();
			DefaultTableModel tabla = (DefaultTableModel) vmat.table.getModel();
			boolean modificado = false;
			int stock = Integer.parseInt(vmat.textStock.getText());
			int cod = materiales.get(fila).getCodigo_material();
			//materiales.get(fila).setStock(stock);

			if(vmat.checkCOnfirm.isSelected()){
				gbbddMat.modificaSoloStock(cod, stock);
//				if (modificado) {
//					vantanaConfirmacion("Material modificado");
//					vmat.checkCOnfirm.setSelected(false);
//					limpiaRegistro();
//				}
//				materiales.set(fila, m);
				limpiar();
				cargarLista();
				JOptionPane.showMessageDialog(null,"Material modificado");
				vmat.checkCOnfirm.setSelected(false);
				limpiaRegistro();
			} else {
				vmat.lblError.setText("Debe marcar la casilla de confirmación");
			}
		} catch (NumberFormatException e) {
			vmat.lblError.setText("Debe seleccionar previamente un material de la lista");
		}
	}
	
	
	
	
	
	


	private void buscar() {
		boolean encontado2 =false;
		int contador=0;
		vmat.textCod.setEditable(true);
		vmat.checkCOnfirm.setVisible(false);
		vmat.textDescrip.setEditable(false);
		vmat.textStock.setEditable(false);
		vmat.lblSeleModi.setVisible(false);
		
		String  nombre;
		boolean encontrado = false;
		vmat.lblRegistroNuevosMateriales.setForeground(Color.RED);
		vmat.lblRegistroNuevosMateriales.setText("Introduce codigo del material que desea buscar");
		int codMat = 0;
		try{
			codMat = Integer.parseInt(vmat.textCod.getText()+"");
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		if(codMat == 0){
			vmat.lblRegistroNuevosMateriales.setText("Introduce codigo del material que desea buscar");
		} else {
			for (Material material : materiales) {
				if(material.getCodigo_material()==codMat){
					vmat.textStock.setText(material.getStock()+"");
					vmat.textDescrip.setText(material.getDescripcion());
					vmat.textNombre.setText(material.getNombre_material());
					vmat.lblError.setText(null);
					encontrado = true;
				} 
			}
			
		}
	
		if(!encontrado){
			vmat.lblError.setText("No hay material con esos datos");
			vmat.textNombre.setText(null);
			vmat.textDescrip.setText(null);
			vmat.textStock.setText(null);
			//vmat.textTipo.setText(null);
		}
	}



	private void limpiaRegistro() {
		vmat.textNombre.setText(null);
		vmat.textCod.setText(null);
		vmat.textDescrip.setText(null);
		vmat.textStock.setText(null);
		//vmat.textTipo.setText(null);
		vmat.lblError.setText(null);
		
	}


	private void registroMaterial() {
		try {
			String nombre, desc, tipo;
			int stock;
			vmat.textCod.setEditable(false);
			int cod_Mat = Integer.parseInt(vmat.textCod.getText() + "");
			nombre = vmat.textNombre.getText();
			desc = vmat.textDescrip.getText();
			if (vmat.comboTipo.getSelectedItem().equals("seleccione")) {
				vmat.lblError.setText("Seleccione el tipo de material");
			} else {
				tipo = (String) vmat.comboTipo.getSelectedItem();
				stock = Integer.parseInt(vmat.textStock.getText());
				if (cod_Mat == 0 && nombre.length() == 0 && desc.length() == 0 && tipo.length() == 0) {
					vmat.lblError.setText("Revise los campos");
				}
				if (comprueboCodigo(cod_Mat)) {
					for (Material material : materiales) {
						material.setStock(material.getStock() + stock);
					}
				} else {
					// (int codigo_material, int stock, String nombre_material,
					// String tipo_material, String descripcion)
					Material m = new Material(cod_Mat, stock, nombre, tipo, desc);
					materiales.add(m);
					gbbddMat.insertatMaterial(m);
					vmat.lblError.setText("Material registrado");
					JOptionPane.showMessageDialog(null, "Material registrado");
					DefaultTableModel tabla = (DefaultTableModel) vmat.table.getModel();
					tabla.addRow(new Object[] { materiales.get(materiales.size() - 1).getCodigo_material(),
							materiales.get(materiales.size() - 1).getNombre_material(),
							materiales.get(materiales.size() - 1).getDescripcion(),
							materiales.get(materiales.size() - 1).getTipo_material(),
							materiales.get(materiales.size() - 1).getStock() });
				}
			}
		} catch (Exception e) {
			vmat.lblError.setText("Revise los campos");
		}
	}	
	



	private boolean comprueboCodigo(int cod_Mat) {
		boolean encontrado = false;
		for (Material material : materiales) {
			if(material.getCodigo_material() == cod_Mat){
				encontrado = true;
			}
		}
		return encontrado;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		
		if(o == vmat.table){
			int fila = vmat.table.rowAtPoint(e.getPoint());
			vmat.textCod.setText(materiales.get(fila).getCodigo_material()+"");
			vmat.textNombre.setText(materiales.get(fila).getNombre_material());
			vmat.textDescrip.setText(materiales.get(fila).getDescripcion());
			//vmat.textTipo.setText(materiales.get(fila).getTipo_material());
			//vmat.textStock.setText(Integer.toString((materiales.get(fila).getStock())));
			vmat.textStock.setText(materiales.get(fila).getStock()+"");
			vmat.lblError.setText(null);
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
