package somos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import instrucciones.ControladorInstru;
import instrucciones.VistaInstrucciones;

public class ControladorSomos implements ActionListener{

	VistaSomos vs;
	
	
	
	public ControladorSomos(VistaSomos vs) {
		super();
		this.vs = vs;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == vs.btnCerrar){
			vs.dispose();
		}
		if(o == vs.btnInstrucciones){
			instrucciones();
			vs.dispose();
		}
		
	}



	private void instrucciones() {
		VistaInstrucciones vi = new VistaInstrucciones();
		ControladorInstru ci = new ControladorInstru(vi);
		vi.setControlador(ci);
		vi.setVisible(true);
		
	}

}
