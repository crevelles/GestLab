package principal;

import OracleAcceso.AccesoOracle;
import portada.ControladorPortada;
import portada.Vportada;

public class Principal {

	public static void main(String[] args) {
		
		
		AccesoOracle bbdd = new AccesoOracle();
		Vportada vp = new Vportada();
		ControladorPortada cp = new ControladorPortada(vp, bbdd);
		vp.setControlador(cp);
		vp.setVisible(true);
		
		System.out.print("Version JAVA:");
		System.out.println(System.getProperty("java.runtime.version"));

	}

}
