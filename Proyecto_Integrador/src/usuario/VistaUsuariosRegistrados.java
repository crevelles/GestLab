package usuario;
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
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class VistaUsuariosRegistrados extends JFrame {

	private JPanel contentPane;
	public JTable table2;
	public JTable table3;
	public JButton btnSalir;
	private JLabel lblNewLabel;
	public JScrollPane scrollPane;
	public JTable table;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JLabel lblIdSocio;
	public JLabel lblNombre;
	public JLabel lblApellidos;
	public JLabel lblEmail;
	public JLabel lblTfno;
	public JLabel lblTipoUsuario;
	public JTextField textId;
	public JTextField textNombre;
	public JTextField textApellidos;
	public JTextField textEmail;
	public JTextField textTfno;
	public JTextField textTipoUs;
	public JButton btnBuscar;
	public JLabel lblParaModificarUn;
	public JLabel lblParaBuscarInformacion;
	public JLabel lblError;
	public  JButton btnLimpiar;
	public JLabel lbl_Imagen;
	public JButton btnModificarId;


	public VistaUsuariosRegistrados() {
		setUndecorated(true);
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Usuarios registrados");
		
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) new Color(100, 149, 237)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		
		JLabel lblUsuariosRegistrados = new JLabel("Usuarios registrados");
		lblUsuariosRegistrados.setBackground(SystemColor.textHighlight);
		lblUsuariosRegistrados.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuariosRegistrados.setForeground(SystemColor.textHighlight);
		lblUsuariosRegistrados.setFont(new Font("Levenim MT", Font.PLAIN, 24));
		lblUsuariosRegistrados.setBounds(112, 27, 253, 44);
		contentPane.add(lblUsuariosRegistrados);
		
		btnSalir = new JButton("salir");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 16));
		btnSalir.setBackground(new Color(30, 144, 255));
		btnSalir.setBounds(753, 429, 161, 43);
		contentPane.add(btnSalir);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Apellidos", "email"
			}
		));
		table2.getColumnModel().getColumn(3).setPreferredWidth(213);
		
		
		
		lblNewLabel = new JLabel("Consulta o modificacion de usuarios registrados");
		lblNewLabel.setBackground(SystemColor.textInactiveText);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 82, 332, 23);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 904, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.text);
		table.setForeground(SystemColor.activeCaptionText);
		table.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Socio", "Nombre", "Apellidos", "email", "Telefono", "Tipo Usuario"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setMinWidth(32);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(177);
		table.getColumnModel().getColumn(4).setPreferredWidth(101);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		btnModificar = new JButton("modificar");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnModificar.setBackground(new Color(30, 144, 255));
		btnModificar.setBounds(568, 386, 161, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(30, 144, 255));
		btnEliminar.setBounds(823, 312, 91, 23);
		contentPane.add(btnEliminar);
		
		lblIdSocio = new JLabel("Id Socio:");
		lblIdSocio.setForeground(Color.GRAY);
		lblIdSocio.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblIdSocio.setBackground(SystemColor.textInactiveText);
		lblIdSocio.setBounds(10, 270, 67, 23);
		contentPane.add(lblIdSocio);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblNombre.setBackground(SystemColor.textInactiveText);
		lblNombre.setBounds(196, 270, 67, 23);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.GRAY);
		lblApellidos.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblApellidos.setBackground(SystemColor.textInactiveText);
		lblApellidos.setBounds(486, 270, 72, 23);
		contentPane.add(lblApellidos);
		
		lblEmail = new JLabel("email:");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblEmail.setBackground(SystemColor.textInactiveText);
		lblEmail.setBounds(10, 312, 67, 23);
		contentPane.add(lblEmail);
		
		lblTfno = new JLabel("Telefono:");
		lblTfno.setForeground(Color.GRAY);
		lblTfno.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblTfno.setBackground(SystemColor.textInactiveText);
		lblTfno.setBounds(486, 312, 72, 23);
		contentPane.add(lblTfno);
		
		lblTipoUsuario = new JLabel("Tipo usuario:");
		lblTipoUsuario.setForeground(Color.GRAY);
		lblTipoUsuario.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblTipoUsuario.setBackground(SystemColor.textInactiveText);
		lblTipoUsuario.setBounds(10, 352, 105, 23);
		contentPane.add(lblTipoUsuario);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(75, 271, 111, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(274, 271, 202, 20);
		contentPane.add(textNombre);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setColumns(10);
		textApellidos.setBounds(568, 271, 346, 20);
		contentPane.add(textApellidos);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(75, 313, 401, 20);
		contentPane.add(textEmail);
		
		textTfno = new JTextField();
		textTfno.setEditable(false);
		textTfno.setColumns(10);
		textTfno.setBounds(568, 313, 245, 20);
		contentPane.add(textTfno);
		
		textTipoUs = new JTextField();
		textTipoUs.setEditable(false);
		textTipoUs.setColumns(10);
		textTipoUs.setBounds(112, 353, 364, 20);
		contentPane.add(textTipoUs);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(new Color(0, 0, 128));
		btnBuscar.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(568, 352, 161, 23);
		contentPane.add(btnBuscar);
		
		lblParaModificarUn = new JLabel("- Modificacion USUARIO --> Seleccione el campo a modificar, ingrese los nuevos valores y pulse el boton modificar");
		lblParaModificarUn.setForeground(Color.GRAY);
		lblParaModificarUn.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblParaModificarUn.setBackground(SystemColor.textInactiveText);
		lblParaModificarUn.setBounds(10, 419, 719, 23);
		contentPane.add(lblParaModificarUn);
		
		lblParaBuscarInformacion = new JLabel("- Busqueda USUARIO --> Ingrese el Id Socio o Nombre y apellidos y pulse el boton buscar");
		lblParaBuscarInformacion.setForeground(Color.GRAY);
		lblParaBuscarInformacion.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblParaBuscarInformacion.setBackground(SystemColor.textInactiveText);
		lblParaBuscarInformacion.setBounds(10, 440, 600, 23);
		contentPane.add(lblParaBuscarInformacion);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Levenim MT", Font.BOLD, 11));
		lblError.setBounds(20, 385, 549, 23);
		contentPane.add(lblError);
		
		btnLimpiar = new JButton("limpiar");
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnLimpiar.setBackground(new Color(143, 188, 143));
		btnLimpiar.setBounds(753, 352, 161, 23);
		contentPane.add(btnLimpiar);
		
		lbl_Imagen = new JLabel("");
		lbl_Imagen.setBounds(10, 11, 112, 75);
		contentPane.add(lbl_Imagen);
		Image img = new ImageIcon(this.getClass().getResource("/registro.jpg")).getImage();
		lbl_Imagen.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(666, 11, 258, 75);
		contentPane.add(lblNewLabel_1);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		btnModificarId = new JButton("modificar ID");
		btnModificarId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarId.setForeground(new Color(30, 144, 255));
		btnModificarId.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnModificarId.setBackground(new Color(255, 255, 255));
		btnModificarId.setBounds(753, 386, 161, 23);
		contentPane.add(btnModificarId);
		
		
	}
		public void setCOntroladorUsuariosRegistrados(ControladorVistaUsuaRegist c){
			btnModificar.addActionListener(c);
			btnEliminar.addActionListener(c);
			table.addMouseListener(c);
			btnBuscar.addActionListener(c);
			btnLimpiar.addActionListener(c);
			btnSalir.addActionListener(c);
			btnModificarId.addActionListener(c);
		}
}
