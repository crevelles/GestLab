package proyecto;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class VistaProyectos extends JFrame {

	private JPanel contentPane;
	private JLabel lblConsulteInformacinSobre;
	public JTable table;
	public JButton btnNuevo;
	public JButton btnEliminar;
	public JScrollPane scrollPane;
	public JButton btnAsistencia;
	public JTextField textCod;
	public JTextField textNombre;
	public JTextField textDesc;
	public JLabel lblCodigo;
	public JLabel lblNombre;
	public JLabel lblDescripcion;
	public JLabel lblError;
	public JButton btnRegistrar;
	public JButton btnSalirr;
	public JButton btnLimpiar;
	public JButton btnBuscar;
	public JButton btnBorrar;


	public VistaProyectos() {
		setUndecorated(true);
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Gesti\u00F3n de proyectos");
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		
		JLabel lblProyectos = new JLabel("Proyectos:\r\n");
		lblProyectos.setForeground(new Color(30, 144, 255));
		lblProyectos.setFont(new Font("Levenim MT", Font.PLAIN, 32));
		lblProyectos.setBounds(21, 24, 206, 46);
		contentPane.add(lblProyectos);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setBounds(697, 127, 216, 181);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/pro.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblConsulteInformacinSobre = new JLabel("Cree, modifique, consulte y elimine proyectos");
		lblConsulteInformacinSobre.setForeground(Color.LIGHT_GRAY);
		lblConsulteInformacinSobre.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblConsulteInformacinSobre.setBounds(21, 73, 348, 23);
		contentPane.add(lblConsulteInformacinSobre);
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(21, 107, 666, 345);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(213);
		scrollPane.setViewportView(table);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnNuevo.setBackground(new Color(100, 149, 237));
		btnNuevo.setBounds(717, 319, 196, 25);
		contentPane.add(btnNuevo);
		
		btnEliminar = new JButton("Eliminar\r\n");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnEliminar.setBackground(new Color(154, 205, 50));
		btnEliminar.setBounds(717, 391, 196, 25);
		contentPane.add(btnEliminar);
		
		btnAsistencia = new JButton("Asistencia");
		btnAsistencia.setForeground(new Color(255, 255, 255));
		btnAsistencia.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnAsistencia.setBackground(new Color(255, 215, 0));
		btnAsistencia.setBounds(717, 355, 197, 25);
		contentPane.add(btnAsistencia);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.LIGHT_GRAY);
		lblCodigo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblCodigo.setBounds(21, 313, 66, 23);
		contentPane.add(lblCodigo);
		lblCodigo.setVisible(false);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.LIGHT_GRAY);
		lblNombre.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblNombre.setBounds(194, 313, 66, 23);
		contentPane.add(lblNombre);
		lblNombre.setVisible(false);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.LIGHT_GRAY);
		lblDescripcion.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblDescripcion.setBounds(21, 347, 83, 23);
		contentPane.add(lblDescripcion);
		lblDescripcion.setVisible(false);
		
		textCod = new JTextField();
		textCod.setBounds(97, 314, 86, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		textCod.setVisible(false);
		textCod.setEnabled(false);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(272, 314, 278, 20);
		contentPane.add(textNombre);
		textNombre.setVisible(false);
		
		textDesc = new JTextField();
		textDesc.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		textDesc.setBounds(21, 381, 666, 71);
		contentPane.add(textDesc);
		textDesc.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Levenim MT", Font.BOLD, 12));
		lblError.setBounds(151, 345, 407, 25);
		contentPane.add(lblError);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnRegistrar.setBackground(new Color(255, 215, 0));
		btnRegistrar.setBounds(560, 310, 127, 25);
		contentPane.add(btnRegistrar);
		btnRegistrar.setVisible(false);
		
		btnSalirr = new JButton("SALIR");
		btnSalirr.setForeground(new Color(0, 0, 128));
		btnSalirr.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnSalirr.setBackground(Color.WHITE);
		btnSalirr.setBounds(717, 427, 197, 57);
		contentPane.add(btnSalirr);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(646, 11, 267, 77);
		contentPane.add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnLimpiar.setBackground(new Color(100, 149, 237));
		btnLimpiar.setBounds(560, 345, 127, 25);
		contentPane.add(btnLimpiar);
		
		btnBuscar = new JButton("Buscar\r\n");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnBuscar.setBackground(new Color(255, 69, 0));
		btnBuscar.setBounds(560, 313, 127, 25);
		contentPane.add(btnBuscar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnBorrar.setBackground(new Color(255, 215, 0));
		btnBorrar.setBounds(560, 313, 117, 25);
		contentPane.add(btnBorrar);
		btnLimpiar.setVisible(false);
		btnBuscar.setVisible(false);
		btnBorrar.setVisible(false);
		textDesc.setVisible(false);
	}
	
		public void setControladorProyectos(ConstroladorVistaProyectos c){
			btnNuevo.addActionListener(c);
		
			btnEliminar.addActionListener(c);
			btnSalirr.addActionListener(c);
			btnAsistencia.addActionListener(c);
			table.addMouseListener(c);
			btnRegistrar.addActionListener(c);
			btnLimpiar.addActionListener(c);
			btnBuscar.addActionListener(c);
			btnBorrar.addActionListener(c);
		}
}
