package maquina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import OracleAcceso.AccesoOracle;

public class ControladorMaquinas implements ActionListener, MouseListener{

	VistaMaquinas vmq;
	AccesoOracle bbdd;
	GestionBBDD_Maquinas gestionBDMaquinas;
	ArrayList <Maquina> maquinas = new ArrayList<>();
	
	public ControladorMaquinas(VistaMaquinas vmq, AccesoOracle bbdd) {
		super();
		this.vmq = vmq;
		this.bbdd = bbdd;
		gestionBDMaquinas = new GestionBBDD_Maquinas(bbdd.conexion);
		gestionBDMaquinas.consultaMaquinas(maquinas);
		cargarLista();
	}


	public void cargarLista(){
		for (Maquina m : maquinas) {
			DefaultTableModel tabla = (DefaultTableModel) vmq.table.getModel();
			tabla.addRow(new Object[]{
					m.getCodigo_maquina(),
					m.getDisponibilidad(),
					m.getNombre_maquina(),
					m.getDescripcion()
					});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == vmq.btnSalir){
			vmq.dispose();
		}
		if(o == vmq.btnIntroducirMquina) {
			introMaquina();
		}
		if(o == vmq.btnBorrar) {
			borrarMaquina();
		}
		if(o == vmq.btnLimpiar) {
			limpiarCampos();
		}
		
	}
	

	private void limpiarCampos() {
		vmq.textCodigo.setText(null);
		vmq.textDescrip.setText(null);
		//vmq.textEstado.setText(null);
		vmq.textNombre.setText(null);
		vmq.lblError.setText(null);
	}


	private void borrarMaquina() {
		if(vmq.textCodigo.getText().equals("")){
			vmq.lblError.setVisible(true);
			vmq.lblError.setText("Seleccione la maquina");
		} else {
			int cod = Integer.parseInt(vmq.textCodigo.getText());
			int fila = vmq.table.getSelectedRow();
			vmq.textCodigo.setText(null);
			vmq.textNombre.setText(null);
			vmq.textDescrip.setText(null);
			//vmq.textEstado.setText(null);
			DefaultTableModel tablaMod = (DefaultTableModel) vmq.table.getModel();
			tablaMod.removeRow(fila);
			maquinas.remove(fila);
			gestionBDMaquinas.eliminarMaquina(cod);
		}
		
		
	}

	
	private boolean compruebaCod(int cod){
		boolean encontrado = false;
		for (Maquina maquina : maquinas) {
			if(maquina.getCodigo_maquina() == cod){
				encontrado = true;
			}
		}
		
		return encontrado;
	}

	private void introMaquina() {
		int cod;
		String estado, nombre, desc;
		try{
			cod = Integer.parseInt(vmq.textCodigo.getText());
		
			if(vmq.comboBox.getSelectedIndex() == 1){
				estado = "DISPONIBLE";
			} else if (vmq.comboBox.getSelectedIndex() == 2){
				estado = "RESERVADA";
			} else if (vmq.comboBox.getSelectedIndex() == 3){
				estado = "REVISION";
			}
			estado = (String) vmq.comboBox.getSelectedItem();
			nombre = vmq.textNombre.getText();
			desc = vmq.textDescrip.getText();
			String mensa1 = "Campo clave máximo 5 digitos";
			String mensa2 = "Hay que rellenar todos los campos";
			String mensa3 = "Codigo ya esta registrado";
					
				if (vmq.textNombre.getText().equals("") ||// vmq.textEstado.getText().length()==0 ||
						vmq.textCodigo.getText().length()==0 || vmq.textDescrip.getText().length()==0){
					vmq.lblError.setVisible(true);
					vmq.lblError.setText(mensa2);
					
				}else if(vmq.textCodigo.getText().length()>5){
					vmq.lblError.setVisible(true);
					vmq.lblError.setText(mensa1);
					
				}else if(compruebaCod(cod)){
					vmq.lblError.setVisible(true);
					vmq.lblError.setText(mensa3);
					
				} else {
					try{
						
						Maquina m = new Maquina(cod, nombre, desc, estado);
						maquinas.add(m);
				
						DefaultTableModel tabla = (DefaultTableModel) vmq.table.getModel();
						tabla.addRow(new Object[]{
								maquinas.get(maquinas.size()-1).getCodigo_maquina(),
								maquinas.get(maquinas.size()-1).getDisponibilidad(),
								maquinas.get(maquinas.size()-1).getNombre_maquina(),
								maquinas.get(maquinas.size()-1).getDescripcion()
								});
						vmq.textNombre.setText("");
						//vmq.textEstado.setText("");
						vmq.textCodigo.setText(null);
						vmq.textDescrip.setText(null);
						gestionBDMaquinas.insertarMaquina(m);
						vmq.lblError.setVisible(false);
					}catch(NumberFormatException e){
						vmq.lblError.setVisible(true);
						vmq.lblError.setText("Este campo tiene que ser númerico");
				}
			}
	
		}catch (NumberFormatException e) {
			vmq.lblError.setText("Rellene todos los campos");
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == vmq.table){
			int fila = vmq.table.rowAtPoint(e.getPoint());
			vmq.textNombre.setText(maquinas.get(fila).getNombre_maquina());
			vmq.textDescrip.setText(maquinas.get(fila).getDescripcion());
			vmq.textCodigo.setText(maquinas.get(fila).getCodigo_maquina()+"");
		} else {
			vmq.lblError.setText("hola");
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
