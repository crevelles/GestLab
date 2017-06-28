package proveedor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class VistaProveedor extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnSalir;
	public JLabel lblIngreseUnNuevo;
	public JLabel lblCodigo;
	public JTextField textCif;
	public JLabel lblNombre;
	public JTextField textNombre;
	public JTextField textDirecc;
	public JLabel lblTfno;
	public JTextField textTfno;
	public JLabel lblCorreo;
	public JTextField textCorreo;
	public JButton btnIngresar_1;
	private JLabel lblNewLabel_1;
	private JLabel label;
	public JLabel lblError;
	public JButton btnLimpiar;
	JButton btnNuevo;
	 JTextField textCiudad;
	JTextField textCP;


	public VistaProveedor() {
		setUndecorated(true);
		setType(Type.POPUP);
		setTitle("Gesti\u00F3n de proveedores");
		setResizable(false);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
	    
		JLabel lblProveedores = new JLabel("Proveedores:");
		lblProveedores.setForeground(new Color(30, 144, 255));
		lblProveedores.setFont(new Font("Levenim MT", Font.PLAIN, 36));
		lblProveedores.setBounds(10, 30, 254, 46);
		contentPane.add(lblProveedores);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(796, 110, 128, 173);
		contentPane.add(lblNewLabel);
		//Image img = new ImageIcon(this.getClass().getResource("/proveedor.jpg")).getImage();
		Image img = new ImageIcon(this.getClass().getResource("/proU.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblConsulteActualiceE = new JLabel("Consulte, actualice e ingrese nuevos proveedores\r\n");
		lblConsulteActualiceE.setForeground(Color.LIGHT_GRAY);
		lblConsulteActualiceE.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblConsulteActualiceE.setBounds(10, 76, 354, 23);
		contentPane.add(lblConsulteActualiceE);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(806, 427, 118, 46);
		contentPane.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 776, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Correo", "Telefono"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(131);
		scrollPane.setViewportView(table);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 0, 128));
		btnModificar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(806, 322, 118, 25);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar\r\n");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnEliminar.setBackground(new Color(100, 149, 237));
		btnEliminar.setBounds(806, 358, 118, 25);
		contentPane.add(btnEliminar);
		
		lblIngreseUnNuevo = new JLabel("Ingrese un nuevo proveedor o modifique uno existente");
		lblIngreseUnNuevo.setForeground(Color.LIGHT_GRAY);
		lblIngreseUnNuevo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblIngreseUnNuevo.setBounds(10, 322, 404, 23);
		contentPane.add(lblIngreseUnNuevo);
		
		lblCodigo = new JLabel("CIF:");
		lblCodigo.setForeground(Color.LIGHT_GRAY);
		lblCodigo.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 348, 60, 23);
		contentPane.add(lblCodigo);
		
		textCif = new JTextField();
		textCif.setBounds(83, 348, 99, 20);
		contentPane.add(textCif);
		textCif.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.LIGHT_GRAY);
		lblNombre.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblNombre.setBounds(192, 348, 60, 23);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(256, 348, 530, 20);
		contentPane.add(textNombre);
		
		textDirecc = new JTextField();
		textDirecc.setColumns(10);
		textDirecc.setBounds(83, 386, 300, 20);
		contentPane.add(textDirecc);
		
		lblTfno = new JLabel("Tfno:");
		lblTfno.setForeground(Color.LIGHT_GRAY);
		lblTfno.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblTfno.setBounds(393, 386, 47, 23);
		contentPane.add(lblTfno);
		
		textTfno = new JTextField();
		textTfno.setColumns(10);
		textTfno.setBounds(450, 386, 195, 20);
		contentPane.add(textTfno);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.LIGHT_GRAY);
		lblCorreo.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 421, 70, 37);
		contentPane.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(83, 428, 300, 20);
		contentPane.add(textCorreo);
		
		btnIngresar_1 = new JButton("Ingresar");
		btnIngresar_1.setForeground(new Color(255, 255, 255));
		btnIngresar_1.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnIngresar_1.setBackground(new Color(30, 144, 255));
		btnIngresar_1.setBounds(666, 385, 120, 23);
		contentPane.add(btnIngresar_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(666, 11, 258, 77);
		contentPane.add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		
		label = new JLabel("Direccion:");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		label.setBounds(10, 386, 70, 23);
		contentPane.add(label);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblError.setBounds(10, 453, 620, 20);
		contentPane.add(lblError);
		
		btnLimpiar = new JButton("Limpiar\r\n");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnLimpiar.setBackground(new Color(100, 149, 237));
		btnLimpiar.setBounds(806, 391, 118, 25);
		contentPane.add(btnLimpiar);
		
		textCif.setEnabled(false);
		textNombre.setEnabled(false);
		textDirecc.setEnabled(false);
		textCorreo.setEnabled(false);
		textTfno.setEnabled(false);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(new Color(0, 0, 128));
		btnNuevo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(806, 283, 118, 25);
		contentPane.add(btnNuevo);
		
		JLabel lblCp = new JLabel("Ciudad");
		lblCp.setForeground(Color.LIGHT_GRAY);
		lblCp.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblCp.setBounds(393, 420, 60, 37);
		contentPane.add(lblCp);
		
		JLabel label_1 = new JLabel("CP:");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		label_1.setBounds(666, 421, 60, 37);
		contentPane.add(label_1);
		
		textCiudad = new JTextField();
		textCiudad.setEnabled(false);
		textCiudad.setColumns(10);
		textCiudad.setBounds(450, 427, 195, 20);
		contentPane.add(textCiudad);
		
		textCP = new JTextField();
		textCP.setEnabled(false);
		textCP.setColumns(10);
		textCP.setBounds(693, 428, 93, 20);
		contentPane.add(textCP);
		btnIngresar_1.setVisible(false);
	}
	
		public void setControladorProveedor(ControladorVistaProveedor c){
			
			btnEliminar.addActionListener(c);
			btnIngresar_1.addActionListener(c);
			btnModificar.addActionListener(c);
			btnSalir.addActionListener(c);
			table.addMouseListener(c);
			btnLimpiar.addActionListener(c);
			btnNuevo.addActionListener(c);
		}
}
