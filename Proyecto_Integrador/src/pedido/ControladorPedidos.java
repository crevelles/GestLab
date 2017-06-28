package pedido;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import evento.Evento;
import proveedor.Gestion_BBDD_Proveedores;
import proveedor.Proveedor;


public class ControladorPedidos implements ActionListener, MouseListener{

	int codP;
	
	VistaPedidos vp;
	AccesoOracle bbdd;
	
	ArrayList<Pedido> pedidos = new ArrayList<>();
	ArrayList<Proveedor> proveedores = new ArrayList<>();
	GestionBBDDpedidos gBBDDped;
	Gestion_BBDD_Proveedores gBDprov;

	
	
	public ControladorPedidos(VistaPedidos vp,AccesoOracle bbdd) {
		this.vp = vp;
		this.bbdd = bbdd;
		gBBDDped =new GestionBBDDpedidos(bbdd.conexion);
		gBBDDped.consultaTablaPedidos(pedidos);
		gBDprov = new Gestion_BBDD_Proveedores(bbdd.conexion);
		gBDprov.consultaProveedores(proveedores);
		cargarLista();
		cargarComboCIF();
		cargarComboPROVEEDORES();
		
	}
	

	
	private int generaCodigo(){
		int codigo = (int) Math.floor(Math.random()*1000+1);
		if(gBBDDped.compreubaCod(codigo)){
			codigo = (int) Math.floor(Math.random()*1000+1);
		}
		return codigo;
	}

	private void cargarComboCIF() {
		for (Proveedor proveedor : proveedores) {
			String cif = proveedor.getCif();
			vp.comboCIF.addItem(cif);
		}
		
	}



	private void cargarComboPROVEEDORES() {
		for (Proveedor proveedor : proveedores) {
			String proveedorNombre = proveedor.getNombre_proveedor();
			vp.comboPRO.addItem(proveedorNombre);
		}
		
	}



	private void cargarLista() {
		for (Pedido p : pedidos) {
			DefaultTableModel t  = (DefaultTableModel) vp.table.getModel();
			t.addRow(new Object[]{
				p.getCodigo_pedido(), p.getFecha(), p.getPrecio_total(),
				p.getCif_proveedor()
			});
		}
		
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object o = e.getSource();
		if(o == vp.buttonSalir){
			vp.dispose();
		} else if(o == vp.btnNuevoProveedor) {
			modificarVentana();
		} else if(o == vp.btnRegistrar){
			registroPedido();
		} else if(o == vp.btnLimpiar){
			limpiarCampos();
		} else if(o == vp.btnConsultar){
			consultarPedido();
		} else if(o == vp.btnBaja){
			elimina();
		}
		
		
	}
	
	
	private void elimina(){
		vp.lblError.setText(null);
		try{
			int codP = Integer.parseInt(vp.textCod.getText());
			int fila = vp.table.getSelectedRow();
			DefaultTableModel tabla  = (DefaultTableModel) vp.table.getModel();
			try{
				tabla.removeRow(fila);
				vp.lblError.setForeground(Color.BLUE);
				vp.lblError.setText("Pedido cancelado/eliminado");
				if(gBBDDped.eliminaPedido(codP)){
					pedidos.remove(fila);
					vp.lblError.setForeground(Color.BLUE);
					vp.lblError.setText("Pedido cancelado/eliminado");
				}
				
			}catch (Exception e) {
				vp.lblError.setForeground(Color.RED);
				vp.lblError.setText("Seleccione con el cursor el pedido que desea cancelar");
			}
		}catch (NumberFormatException e) {
			vp.lblError.setForeground(Color.RED);
			vp.lblError.setText("Seleccione con el cursor el pedido que desea cancelar");
		}
		
		
	}
	
	private void consultarPedido() {
		vp.textCod.setEditable(true);
		vp.textCod.setEnabled(true);
		boolean encontrado = false;
		try{
			int codigoPedido = Integer.parseInt(vp.textCod.getText());
			for (Pedido pedido : pedidos) {
				if(pedido.getCodigo_pedido() == codigoPedido){
					encontrado = true;
					vp.comboCIF.setSelectedItem(pedido.getCif_proveedor());
					vp.textImporte.setText(pedido.getPrecio_total()+"");
					vp.textDetalle.setText(pedido.getDescripcion());
					for(int x = 0; x<proveedores.size(); x++){
						if(proveedores.get(x).getCif() == pedido.getCif_proveedor()){
							vp.comboPRO.setSelectedItem(proveedores.get(x).getNombre_proveedor());
						}
					}
				}
			}
			if(!encontrado){
				vp.lblError.setText("No hay ningún pedido con el código introducido");
			}
			
		}catch (NumberFormatException e) {
			vp.lblError.setText("Rellene todos los campos");
		}
		
	}



	private void limpiarCampos() {
		//vp.textCif.setText(null);
		vp.textCod.setText(null);
		vp.textDetalle.setText(null);
		vp.textImporte.setText(null);
		//vp.textProveedor.setText(null);
		
	}


	
	
	private void registroPedido() {
		String  fecha, cif, contenido, descripcion;
		int importe, codPed = 0;
		cif = (String) vp.comboCIF.getSelectedItem();
		contenido = vp.textDetalle.getText();
		importe = vp.textImporte.getHeight();
		try{
			codPed = Integer.parseInt(vp.textCod.getText());
		}catch (NumberFormatException e) {
			vp.lblError.setText("El campo codigo es numérico");
		}
		
		try{
			fecha = vp.dateChooser.getJCalendar().getDayChooser().getDay() + "-"
					+ Integer.toString( vp.dateChooser.getCalendar().get(Calendar.MONTH) + 1) + "-"
					+  vp.dateChooser.getJCalendar().getYearChooser().getYear();
			descripcion = vp.textDetalle.getText();
			if( cif.length() ==0 || contenido.length()==0 || importe <=0){
				vp.lblError.setText("No pueden quedar campos vacios");
			}  else {
				Pedido p = new Pedido(codPed , fecha, cif, importe,contenido);
				pedidos.add(p);
				DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
				tabla.addRow(new Object[]{
					pedidos.get(pedidos.size() - 1).getCodigo_pedido(),
					pedidos.get(pedidos.size() - 1).getFecha(),
					pedidos.get(pedidos.size() - 1).getCif_proveedor(),
					pedidos.get(pedidos.size() - 1).getPrecio_total()
				});
				if(gBBDDped.registrarPedido(p)){
					JOptionPane.showMessageDialog(null, "Pedido registrado correctamaente");
				} else {
					vp.lblError.setText("Error en el registro, revise la operación");
				}
			}

		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}



	private void modificarVentana() {
		vp.scrollPane.setBounds(35, 139, 864, 112);
		vp.btnNuevoProveedor.setVisible(false);
		vp.textCod.setEditable(true);
		vp.textCod.setEnabled(true);
		vp.textCod.setVisible(true);
		//vp.textFecha.setVisible(true);
		vp.textImporte.setVisible(true);
		vp.textDetalle.setVisible(true);
		vp.lblCif.setVisible(true);
		vp.lblCdigo.setVisible(true);
		vp.lblFecha.setVisible(true);
		vp.lblImporte.setVisible(true);
		vp.lblDetalle.setVisible(true);
		vp.btnConsultar.setVisible(true);
		vp.btnRegistrar.setVisible(true);
		vp.lblProveedor.setVisible(true);
		vp.textDetalle.setEditable(true);
		vp.textImporte.setEditable(true);
		//vp.textProveedor.setEditable(true);
		vp.btnLimpiar.setVisible(true);
		vp.dateChooser.setEnabled(true);
		vp.dateChooser.setVisible(true);
		//vp.textCod.setText(codP+"");
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		int fila = vp.table.rowAtPoint(e.getPoint());
		vp.textCod.setText(pedidos.get(fila).getCodigo_pedido()+"");
		vp.textImporte.setText(pedidos.get(fila).getPrecio_total()+"");
		
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
