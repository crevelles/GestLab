package proyecto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;
import reserva.VistaReservas;

public class ConstroladorVistaProyectos implements ActionListener, MouseListener {

	VistaProyectos vp;
	VistaReservas vr;
	AccesoOracle bbdd;
	ArrayList <Proyecto> proyectos = new ArrayList<>();
	Gestion_BBDD_Proyectos gBBDDp;
	
	
	public ConstroladorVistaProyectos(VistaProyectos vp,AccesoOracle bbdd ) {
		super();
		this.vp = vp;
		this.bbdd = bbdd;
		gBBDDp = new Gestion_BBDD_Proyectos(bbdd.conexion);
		gBBDDp.consultaProyectos(proyectos);
		cargarLista();
	}

	private void cargarLista() {
		for (Proyecto p : proyectos) {
			DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
			tabla.addRow(new Object[]{
					p.getCodigo_proyecto(), 
					p.getNombre_proyecto(), 
					p.getDescripcion()
					});
		}
	
	}
	
	public void cargarComboProyectos() {
		String nombreProyecto = "";
		for (int i = 0; i < proyectos.size(); i++) {
			
			nombreProyecto = proyectos.get(i).getNombre_proyecto();
				vr.comboMaq.addItem(nombreProyecto);
				
			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		String registrar = "REGISTRAR";
		
		if(o == vp.btnSalirr){
			vp.dispose();
		} else if(o == vp.btnNuevo){
			pideNuevo();
		} else if(o == vp.btnRegistrar){
			registrarNuevo();
		} else if(o == vp.btnLimpiar) {
			limpiarCampos();
		} else if(o == vp.btnEliminar){
			modificaVentana();
			elimnarProyecto();
		} else if(o == vp.btnBorrar){
			confirmaElimina();
		} else if (o == vp.btnAsistencia){
			abreAsistencia();
		}
		
	}
	
	
	private void abreAsistencia() {
		VistaUsuariosProyectos vup = new VistaUsuariosProyectos();
		ConstroladorVistaUsuariosProyectos c = new ConstroladorVistaUsuariosProyectos(vup, bbdd);
		vup.setControlador(c);
		vup.setVisible(true);
		
	}

	private void confirmaElimina(){
		int codP = Integer.parseInt(vp.textCod.getText());
		int fila = vp.table.getSelectedRow();
		DefaultTableModel tabla  = (DefaultTableModel) vp.table.getModel();
		tabla.removeRow(fila);
		if(gBBDDp.eliminaProyecto(codP)){
			vp.lblError.setText("Proyecto eliminado");
			vp.textCod.setText(null);
			vp.textNombre.setText(null);
			vp.textDesc.setText(null);
			
		} else {
			vp.lblError.setText("Error en el borrado, revise la operación");
		}
		proyectos.remove(fila);
	}
	
	private void elimnarProyecto() {
		vp.btnBorrar.setVisible(true);
		String codP = vp.textCod.getText();
		if(!codP.matches("[0-9]*")){
			vp.lblError.setText("EL campo código no puede quedar vacio");
		} else{
			try{
				int codPr = Integer.parseInt(codP);
				if(codP.length() == 0){
					vp.lblError.setText("Debe introducir el código del proyecto que desea eliminar");
				} else {
					if(gBBDDp.buscaCod(codPr)){
						vp.lblError.setText("El codigo introducido es correcto, pulse el botón eliminar");
					
					} else {
						vp.lblError.setText("no hay ningun proyecto con el código introducido");
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void consulta() {
		vp.btnLimpiar.setVisible(true);
		vp.btnRegistrar.setVisible(false);
		vp.scrollPane.setBounds(21, 107, 666, 192);
		vp.lblCodigo.setVisible(true);
		vp.lblNombre.setVisible(true);
		vp.lblDescripcion.setVisible(true);
		vp.textCod.setVisible(true);
		vp.textNombre.setVisible(true);
		vp.textDesc.setVisible(true);
		vp.btnBuscar.setVisible(true);
		vp.textNombre.setEditable(false);
		vp.textDesc.setEditable(false);
		vp.textCod.setEditable(true);
		vp.textCod.setEnabled(true);
		vp.lblError.setText("Introduce el codigo del proyecto que desea buscar");
		boolean encontrado = false;
		int codP;
		String nombre, desc;
		try{
			codP = Integer.parseInt(vp.textCod.getText());
			nombre = vp.textNombre.getText();
			desc = vp.textDesc.getText();
			
			if(codP == 0){
				vp.lblError.setText("Debe introducir el codigo del proyecto que desea buscar");
			} else {
				for (int i = 0; i < proyectos.size(); i++) {
					if(proyectos.get(i).getCodigo_proyecto() == codP){
						vp.textNombre.setText(proyectos.get(i).getNombre_proyecto());
						vp.textDesc.setText(proyectos.get(i).getDescripcion());
						encontrado=true;
					}
				}
				if(!encontrado){
					vp.lblError.setText("Proyecto NO encontrado");
				}
			}
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		
		
		
	}

	private void limpiarCampos() {
		vp.textCod.setText(null);
		vp.textNombre.setText(null);
		vp.textDesc.setText(null);
	}

	public void pideNuevo(){
		limpiarCampos();
		vp.lblError.setText(null);
		vp.scrollPane.setBounds(21, 107, 666, 192);
		vp.lblCodigo.setVisible(true);
		vp.lblNombre.setVisible(true);
		vp.lblDescripcion.setVisible(true);
		vp.textCod.setVisible(true);
		vp.textCod.setEditable(true);
		vp.textDesc.setEditable(true);
		vp.textNombre.setEditable(true);
		vp.textNombre.setVisible(true);
		vp.textDesc.setVisible(true);
		vp.btnRegistrar.setVisible(true);
		vp.btnLimpiar.setVisible(true);
		vp.btnBuscar.setVisible(false);
	}
	
	public void registrarNuevo(){
		try{
			String nombre, desc;
			int codP = proyectos.get(proyectos.size()-1).getCodigo_proyecto() + 1;
			nombre = vp.textNombre.getText();
			desc = vp.textDesc.getText();
			boolean continuar = true;
			if(nombre.length() == 0 || desc.length() == 0){
				vp.lblError.setText("No puede quedar ningun campo vacio");
				continuar = false;
			}
//			if(codP.length() > 5){
//				vp.lblError.setText("Longitud del campo COD debe ser máximo 5 dígitos");
//				continuar = false;
//			} 
			if(desc.length() > 50){
				vp.lblError.setText("Longitud del campo DESCRIPCION debe ser máximo 50 dígitos");
				continuar = false;
			}
			if(gBBDDp.buscaCod(codP)){
				continuar=false;
				vp.lblError.setText("El codigo introducido está asociado a otro proyecto");
			} else {
				if(continuar){
					Proyecto p = new Proyecto(codP, nombre, desc);
					proyectos.add(p);
					gBBDDp.insertarProyecto(p);
					DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
					tabla.addRow(new Object[]{
							proyectos.get(proyectos.size()-1).getCodigo_proyecto(),
							proyectos.get(proyectos.size()-1).getNombre_proyecto(),
							proyectos.get(proyectos.size()-1).getDescripcion()
					});
					vp.lblError.setForeground(Color.BLUE);
					vp.lblError.setText("PROYECTO REGISTRADO");
					vp.textCod.setText(null);
					vp.textNombre.setText(null);
					vp.textDesc.setText(null);
				} else {
					vp.lblError.setText("Error en el registro, realice la operación de nuevo o contacte con Jairo");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

//	private void consulta() {
//		vp.lblError.setText("Introduce codigo y pulse el boton consultar");
//		vp.scrollPane.setBounds(21, 107, 672, 200);
//		vp.lblError.setText("Introduce el codigo del proyecto que desea consultar");
//		
//		vp.lblCodigo.setVisible(true);
//		vp.lblNombre.setVisible(true);
//		vp.lblDescripcion.setVisible(true);
//		vp.textCod.setVisible(true);
//		vp.textNombre.setVisible(true);
//		vp.textDesc.setVisible(true);
//		
//		vp.btnModificar.setVisible(false);
//		boolean encontrado = false;
//		String cod = vp.textCod.getText();
//		if(cod.length()==0){
//			vp.lblError.setText("Debe introducir un codigo");
//		} else {
//			for (Proyecto proyecto : proyectos) {
//				if(proyecto.getCod_Pr().equalsIgnoreCase(cod)){
//					encontrado = true;
//					vp.textNombre.setText(proyecto.getNombre());
//					vp.textDesc.setText(proyecto.getDesc());
//				}
//			}
//		}
//		if(!encontrado){
//			vp.lblError.setText("No hay ningun proyecto con el codigo inntroducido");
//			vp.textNombre.setText(null);
//			vp.textDesc.setText(null);
//		}
//		
//		
//	}

	private void modificaVentana(){
		limpiarCampos();
		vp.lblError.setText(null);
		vp.scrollPane.setBounds(21, 107, 666, 192);
		vp.lblCodigo.setVisible(true);
		vp.lblNombre.setVisible(true);
		vp.lblDescripcion.setVisible(true);
		vp.textCod.setVisible(true);
		vp.textCod.setEditable(true);
		vp.textDesc.setEditable(false);
		vp.textNombre.setEditable(false);
		vp.textNombre.setVisible(true);
		vp.textDesc.setVisible(true);
		vp.btnRegistrar.setVisible(false);
		vp.btnLimpiar.setVisible(true);
		vp.btnBuscar.setVisible(false);
		vp.lblError.setText("Seleccione con el cursor el proyecto que desea modificar");
	}
	
	private void modificar() {
//		
//		vp.textNombre.setText(null);
//		vp.textDesc.setText(null);
//		vp.textCod.setText(null);
//		int fila = vp.table.getSelectedRow();
//		Proyecto p = new Proyecto();
//		DefaultTableModel tabla = (DefaultTableModel) vp.table.getModel();
//		p.setCod_Pr(vp.textCod.getText());
//		p.setNombre(vp.textNombre.getText());
//		p.setDesc(vp.textDesc.getText());
//		gBBDDp.modificaProyecto(p);
//		try{
//			proyectos.set(fila, p);
//			tabla.setValueAt(p.getCod_Pr(), fila, 0);
//			tabla.setValueAt(p.getNombre(), fila, 1);
//			tabla.setValueAt(p.getDesc(), fila, 2);
//		} catch (Exception e) {vp.lblError.setText("Seleccione una fila");// TODO: handle exception
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == vp.table){
			int fila = vp.table.rowAtPoint(e.getPoint());
			vp.textNombre.setText(proyectos.get(fila).getNombre_proyecto());
			
			vp.textDesc.setText(proyectos.get(fila).getDescripcion());
			vp.textCod.setText(proyectos.get(fila).getCodigo_proyecto()+"");
		} else {
			vp.lblError.setText("hola");
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
