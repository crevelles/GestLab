package seleccion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class Vseleccion extends JFrame {

	private JPanel contentPane;
	public JButton btnProveedor;
	public JButton btnUsuarios;
	public JButton btnMaterial;
	public JButton btnEvento;
	public JButton btnMyFab;
	public JButton btnSomos;
	public JButton btnMaquina;
	public JButton btnReserva;
	public JButton btnPedidos;
	public JButton btnProyectos;
	public JButton btnSalir;
	private JLabel lblNewLabel_2;
	public JLabel lblMensaje;
	public JLabel lbl_ImagenM;
	public JLabel lblImagen;


	public Vseleccion() {
		setUndecorated(true);
		setTitle("Bienvenido a gestLab");
		setType(Type.POPUP);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		setResizable(false);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(100, 149, 237)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		//lblNewLabel_1.setIcon(new ImageIcon(img4));
		
		JLabel lblNewLabel = new JLabel("Bienvenido a ");
		lblNewLabel.setFont(new Font("Levenim MT", Font.PLAIN, 40));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(22, 49, 268, 47);
		contentPane.add(lblNewLabel);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(652, 37, 200, 195);
		contentPane.add(lblImagen);
		Image img1 = new ImageIcon(this.getClass().getResource("/opcion.png")).getImage();
		lblImagen.setIcon(new ImageIcon(img1));
		
		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setFocusPainted(false);
		btnUsuarios.setForeground(SystemColor.textHighlight);
		btnUsuarios.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnUsuarios.setBackground(SystemColor.text);
		btnUsuarios.setBounds(332, 270, 200, 36);
		contentPane.add(btnUsuarios);
		
		btnMaterial = new JButton("MATERIALES");
		btnMaterial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMaterial.setForeground(Color.WHITE);
		btnMaterial.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnMaterial.setBackground(new Color(102, 205, 170));
		btnMaterial.setBounds(332, 394, 200, 36);
		contentPane.add(btnMaterial);
		
		btnEvento = new JButton("EVENTOS");
		btnEvento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEvento.setForeground(SystemColor.text);
		btnEvento.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnEvento.setBackground(SystemColor.textHighlight);
		btnEvento.setBounds(22, 270, 200, 36);
		contentPane.add(btnEvento);
		
		btnMyFab = new JButton("MyFab");
		btnMyFab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMyFab.setForeground(new Color(255, 255, 255));
		btnMyFab.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnMyFab.setBackground(new Color(0, 191, 255));
		btnMyFab.setBounds(22, 333, 200, 36);
		contentPane.add(btnMyFab);
		
		btnSomos = new JButton("Acerca de");
		btnSomos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSomos.setForeground(new Color(0, 0, 128));
		btnSomos.setFont(new Font("Levenim MT", Font.BOLD, 15));
		btnSomos.setBackground(Color.WHITE);
		btnSomos.setBounds(22, 394, 200, 36);
		contentPane.add(btnSomos);
		
		btnMaquina = new JButton("MAQUINAS");
		btnMaquina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMaquina.setForeground(SystemColor.textHighlight);
		btnMaquina.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnMaquina.setBackground(Color.WHITE);
		btnMaquina.setBounds(332, 206, 200, 36);
		contentPane.add(btnMaquina);
		
		btnReserva = new JButton("RESERVAS");
		btnReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReserva.setForeground(Color.WHITE);
		btnReserva.setFont(new Font("Levenim MT", Font.BOLD, 15));
		btnReserva.setBackground(new Color(0, 191, 255));
		btnReserva.setBounds(22, 140, 200, 40);
		contentPane.add(btnReserva);
		
		btnPedidos = new JButton("PEDIDOS");
		btnPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnPedidos.setBackground(new Color(102, 205, 170));
		btnPedidos.setBounds(332, 333, 200, 36);
		contentPane.add(btnPedidos);
		
		btnProyectos = new JButton("PROYECTOS");
		btnProyectos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProyectos.setForeground(SystemColor.text);
		btnProyectos.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnProyectos.setBackground(SystemColor.textHighlight);
		btnProyectos.setBounds(22, 206, 200, 36);
		contentPane.add(btnProyectos);
		
		btnProveedor = new JButton("PROVEEDORES");
		btnProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProveedor.setForeground(Color.WHITE);
		btnProveedor.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnProveedor.setBackground(new Color(102, 205, 170));
		btnProveedor.setBounds(332, 142, 200, 36);
		contentPane.add(btnProveedor);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(new Color(100, 149, 237));
		btnSalir.setFont(new Font("Levenim MT", Font.BOLD, 14));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(728, 394, 150, 36);
		contentPane.add(btnSalir);
		
		JTextPane txtpnDesdeGestlabPodr = new JTextPane();
		txtpnDesdeGestlabPodr.setEditable(false);
		txtpnDesdeGestlabPodr.setForeground(Color.LIGHT_GRAY);
		txtpnDesdeGestlabPodr.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtpnDesdeGestlabPodr.setText("Bienvenido a gestLab, desde la aplicaci\u00F3n puede gestionar el uso de m\u00E1quinas , control de stock y materiales. Registro de usuarios, eventos, proveedores y pedidos.");
		txtpnDesdeGestlabPodr.setBounds(627, 243, 268, 126);
		contentPane.add(txtpnDesdeGestlabPodr);
		Image img2 = new ImageIcon(this.getClass().getResource("/ue.png")).getImage();
		
		lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setBounds(281, 21, 268, 75);
		contentPane.add(lblNewLabel_2);
		Image img3 = new ImageIcon(this.getClass().getResource("/gestLab2.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		
		lblMensaje = new JLabel("Ud se ha identificado como USUARIO, puede realizar una RESERVA, consultar MyFab, registrarse en Eventos y Proyectos");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(SystemColor.textHighlight);
		lblMensaje.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblMensaje.setBounds(22, 453, 877, 36);
		contentPane.add(lblMensaje);
		
		lbl_ImagenM = new JLabel("");
		lbl_ImagenM.setBounds(281, 123, 288, 255);
		contentPane.add(lbl_ImagenM);
		Image img4 = new ImageIcon(this.getClass().getResource("/muP.png")).getImage();
		lbl_ImagenM.setIcon(new ImageIcon(img4));
		lbl_ImagenM.setVisible(false);
		
		lblMensaje.setVisible(false);
	}

	
	public void setControladorVistaSeleccion(ControladorVistaSeleccion c){
		btnEvento.addActionListener(c);
		btnMaquina.addActionListener(c);
		btnMaterial.addActionListener(c);
		btnMyFab.addActionListener(c);
		btnPedidos.addActionListener(c);
		btnProveedor.addActionListener(c);
		btnProyectos.addActionListener(c);
		btnReserva.addActionListener(c);
		btnSalir.addActionListener(c);
		btnSomos.addActionListener(c);
		btnUsuarios.addActionListener(c);
	}
}
