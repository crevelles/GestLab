package seleccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import OracleAcceso.AccesoOracle;
import evento.COntroladorEventos;
import evento.VistaEvento;
import maquina.ControladorMaquinas;
import maquina.Maquina;
import maquina.VistaMaquinas;
import material.COntroladorVistaMaterial;
import material.Material;
import material.VistaMateriales;
import myFab.ControladorMyFab;
import myFab.Vista_MyFab;
import pedido.ControladorPedidos;
import pedido.VistaPedidos;
import portada.ControladorPortada;
import portada.GestionBBDDPortada;
import portada.Vportada;
import proveedor.ControladorVistaProveedor;
import proveedor.Proveedor;
import proveedor.VistaProveedor;
import proyecto.ConstroladorVistaProyectos;
import proyecto.Proyecto;
import proyecto.VistaProyectos;
import reserva.ControladorVistaReserva;
import reserva.VistaReservas;
import somos.ControladorSomos;
import somos.VistaSomos;
import usuario.ControladorUsuario;
import usuario.Usuario;
import usuario.VistaUsuarios;

public class ControladorVistaSeleccion implements ActionListener {

	Vseleccion vs;
	AccesoOracle bbdd;
	Gestion_BBDD_Seleccion gBBDDsele;

	Vportada vp = new Vportada();
	ArrayList<Usuario>   usuarios  = new ArrayList<>();
	GestionBBDDPortada gBBDD;

	
	
	
	
	public ControladorVistaSeleccion(Vseleccion vs,AccesoOracle bbdd) {
		this.vs = vs;
		this.bbdd = bbdd;
		gBBDDsele = new Gestion_BBDD_Seleccion(bbdd.conexion);
		gBBDD = new GestionBBDDPortada(bbdd.conexion);
		gBBDD.cargarUsuarios(usuarios);

	}
	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == vs.btnSalir){
			accesoInicio();
			vs.dispose();
			//bbdd.cerrarBaseDatos();
		} else if (o == vs.btnUsuarios) {
			usuarios();
		} else if(o == vs.btnProveedor) {
			proveedores();
		} else if(o == vs.btnProyectos) {
			proyectos();
		} else if(o == vs.btnReserva) {
		//	JOptionPane.showMessageDialog(null, vp.textID.getText());
			reservas();
		} else if(o == vs.btnMaterial) {
			materiales();
		} else if(o == vs.btnEvento) {
			eventos();
		} else if(o == vs.btnMaquina) {
			maquinas();
		} else if(o == vs.btnPedidos) {
			pedidos();
		} else if(o == vs.btnSomos){
			somos();
		} else if(o == vs.btnMyFab){
			myFab();
		}
		if(o== vp.btnSalir){
			System.out.println("botin salir portada pulsado");
			vp.dispose();
			//bbdd.cerrarBaseDatos();
		}

		

	}

	

	private void accesoInicio() {
		Vportada vp = new Vportada();
		ControladorPortada cp = new ControladorPortada(vp, bbdd);
		vp.setControlador(cp);
		vp.setVisible(true);
	}



	private void myFab() {
		Vista_MyFab my = new Vista_MyFab();
		ControladorMyFab c = new ControladorMyFab(my, bbdd);
		my.setControlador(c);
		my.setVisible(true);
	}




	private void somos() {
		VistaSomos vs = new VistaSomos();
		ControladorSomos cs = new ControladorSomos(vs);
		vs.setControladorSomos(cs);
		vs.setVisible(true);
	}




	private void pedidos() {
		VistaPedidos vp = new VistaPedidos();
		ControladorPedidos c = new ControladorPedidos(vp, bbdd);
		vp.setControlador(c);
		vp.setVisible(true);
	}




	private void maquinas() {
		VistaMaquinas vmaq = new VistaMaquinas();
		ControladorMaquinas c = new ControladorMaquinas(vmaq, bbdd);
		vmaq.setControladorVistaMaquinas(c);
		vmaq.setVisible(true);
	}




	private void eventos() {
		VistaEvento ve = new VistaEvento();
		COntroladorEventos ce = new COntroladorEventos(ve, bbdd);
		ve.setControladorEventos(ce);
		ve.setVisible(true);
		
	}




	private void materiales() {
		ArrayList <Material> materiales = new ArrayList<>();
		VistaMateriales vmat = new VistaMateriales();
		COntroladorVistaMaterial c = new COntroladorVistaMaterial(vmat, bbdd);
		//c.stockBajo();
		vmat.setVisible(true);
		vmat.setControladorVistaMaterial(c);
	}




	private void reservas() {
		ArrayList<Maquina> maquinas = new ArrayList<>();
		ArrayList<Proyecto> proyectos = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<Material> materiales = new ArrayList<>();
		VistaReservas vrer = new VistaReservas();
		ControladorVistaReserva c = new ControladorVistaReserva(vrer, bbdd);
		vrer.setVisible(true);
		vrer.setControladorVistaReserva(c);
	}




	private void proyectos() {
		ArrayList <Proyecto> proyectos = new ArrayList<>();
		VistaProyectos vpy = new VistaProyectos();
		ConstroladorVistaProyectos cp = new ConstroladorVistaProyectos(vpy, bbdd);
		vpy.setVisible(true);
		vpy.setControladorProyectos(cp);
	}




	private void proveedores() {
		ArrayList <Proveedor> proveedores = new ArrayList<>();
		VistaProveedor vp = new VistaProveedor();
		ControladorVistaProveedor c = new ControladorVistaProveedor(vp, bbdd);
		vp.setVisible(true);
		vp.setControladorProveedor(c);
	}




	private void usuarios() {
		ArrayList <Usuario> usuarios = new ArrayList<>();
		VistaUsuarios vu = new VistaUsuarios();
		ControladorUsuario cu = new ControladorUsuario(vu,bbdd);
		vu.setVisible(true);
		vu.setControladorUsuario(cu);
	}
		
	
	
	}


