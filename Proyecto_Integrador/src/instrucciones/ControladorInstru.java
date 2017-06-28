package instrucciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControladorInstru implements ActionListener{
	
	instrucciones.VistaInstrucciones vi;

	public ControladorInstru(VistaInstrucciones vi) {
		super();
		this.vi = vi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == vi.btnSalir){
			vi.dispose();
		}
		
	}
}
