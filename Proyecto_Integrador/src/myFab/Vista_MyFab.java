package myFab;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class Vista_MyFab extends JFrame {

	public JPanel contentPane;
	public JButton btnBuscar;
	public JButton buttonSalir;
	public JTable tablaUsuario;
	public JTable tablaReservas;
	public JScrollPane scrollPane_1;
	public JLabel lblError;
	public JButton btnLimpiar;
	private JLabel lblNewLabel_2;
	public JComboBox comboBox;
	private JLabel lblNewLabel_3;
	public JTable tableEventos;


	
	public Vista_MyFab() {
		setUndecorated(true);
		setTitle("MyFab");
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a MyFab\r\n");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Levenim MT", Font.PLAIN, 34));
		lblNewLabel.setBounds(149, 11, 363, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntroduceElIdentificador = new JLabel("Consulte informaci\u00F3n y reserva de m\u00E1quinas por usuario");
		lblIntroduceElIdentificador.setForeground(SystemColor.inactiveCaption);
		lblIntroduceElIdentificador.setFont(new Font("Leelawadee", Font.PLAIN, 15));
		lblIntroduceElIdentificador.setBounds(149, 74, 381, 50);
		contentPane.add(lblIntroduceElIdentificador);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(6, 12, 133, 153);
		contentPane.add(lblNewLabel_1);
		Image img = new ImageIcon(this.getClass().getResource("/myFabl.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		
		JLabel lblIntroduceElIdentificador_1 = new JLabel("Seleccione el nombre del usuario:\r\n");
		lblIntroduceElIdentificador_1.setForeground(SystemColor.inactiveCaptionText);
		lblIntroduceElIdentificador_1.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblIntroduceElIdentificador_1.setBounds(221, 125, 244, 40);
		contentPane.add(lblIntroduceElIdentificador_1);
		
		buttonSalir = new JButton("SALIR");
		buttonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSalir.setForeground(SystemColor.text);
		buttonSalir.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		buttonSalir.setBackground(SystemColor.textHighlight);
		buttonSalir.setBounds(784, 438, 130, 35);
		contentPane.add(buttonSalir);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(new Color(0, 0, 128));
		btnBuscar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setBounds(784, 136, 130, 20);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 764, 40);
		contentPane.add(scrollPane);
		
		tablaUsuario = new JTable();
		tablaUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellidos", "Correo", "Telefono", "Tipo"
			}
		));
		tablaUsuario.getColumnModel().getColumn(1).setPreferredWidth(159);
		tablaUsuario.getColumnModel().getColumn(2).setPreferredWidth(120);
		tablaUsuario.getColumnModel().getColumn(3).setPreferredWidth(147);
		tablaUsuario.getColumnModel().getColumn(4).setPreferredWidth(123);
		tablaUsuario.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		scrollPane.setViewportView(tablaUsuario);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 267, 764, 96);
		contentPane.add(scrollPane_1);
		
		tablaReservas = new JTable();
		tablaReservas.setGridColor(new Color(204, 204, 255));
		tablaReservas.setBackground(new Color(255, 255, 255));
		tablaReservas.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		tablaReservas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PROYECTO", "RESPONSABLE", "MAQUINA", "INICIO", "FIN"
			}
		));
		tablaReservas.getColumnModel().getColumn(1).setPreferredWidth(94);
		scrollPane_1.setViewportView(tablaReservas);
		
		JLabel lblDatosDelUsuario = new JLabel("Datos del USUARIO");
		lblDatosDelUsuario.setForeground(SystemColor.inactiveCaption);
		lblDatosDelUsuario.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblDatosDelUsuario.setBounds(10, 164, 146, 27);
		contentPane.add(lblDatosDelUsuario);
		
		JLabel lblReservasDelUsuario = new JLabel("Reservas del USUARIO");
		lblReservasDelUsuario.setForeground(SystemColor.inactiveCaption);
		lblReservasDelUsuario.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblReservasDelUsuario.setBounds(10, 240, 170, 27);
		contentPane.add(lblReservasDelUsuario);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblError.setBounds(10, 456, 452, 22);
		contentPane.add(lblError);
		
		btnLimpiar = new JButton("limpiar");
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setForeground(new Color(0, 0, 128));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(784, 390, 130, 37);
		contentPane.add(btnLimpiar);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(656, 11, 258, 96);
		contentPane.add(lblNewLabel_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setOpaque(false);
		comboBox.setBackground(SystemColor.text);
		comboBox.setFont(new Font("Gulim", Font.PLAIN, 15));
		comboBox.setBounds(475, 135, 299, 20);
		contentPane.add(comboBox);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(784, 167, 130, 194);
		contentPane.add(lblNewLabel_3);
		Image img3 = new ImageIcon(this.getClass().getResource("/job2.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		
		JLabel lblEventos = new JLabel("Eventos del USUARIO");
		lblEventos.setForeground(SystemColor.inactiveCaption);
		lblEventos.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblEventos.setBounds(10, 365, 170, 27);
		contentPane.add(lblEventos);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 390, 764, 83);
		contentPane.add(scrollPane_2);
		
		tableEventos = new JTable();
		tableEventos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mentor", "Tema", "Tipo", "Fecha"
			}
		));
		tableEventos.getColumnModel().getColumn(0).setPreferredWidth(114);
		tableEventos.getColumnModel().getColumn(1).setPreferredWidth(183);
		tableEventos.getColumnModel().getColumn(2).setPreferredWidth(143);
		tableEventos.getColumnModel().getColumn(3).setPreferredWidth(116);
		scrollPane_2.setViewportView(tableEventos);
	}
	
		public void setControlador(ControladorMyFab c){
			btnBuscar.addActionListener(c);
			buttonSalir.addActionListener(c);
			btnLimpiar.addActionListener(c);
		}
}
