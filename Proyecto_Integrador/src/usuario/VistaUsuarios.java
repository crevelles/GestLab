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

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import com.toedter.components.JLocaleChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class VistaUsuarios extends JFrame {

	private JPanel contentPane;
	public JRadioButton rdbtnSocio;
	public JRadioButton rdbtAsiste;
	public JTextField textIDsocio;
	public JTextField textNombre;
	public JTextField textApellidos;
	public JTextField textCorreo;
	public JTextField textTelefono;
	public JButton btnLimpiar;
	public JButton btnRegistrar;
	public JButton btnSalir;
	public JButton btnUsuariosRegistrados;
	public JLabel lblError;
	public JRadioButton rdbtnResponsable;
	public JLabel lblNewLabel;
	public JLabel lblSeleccioneElTipo;
	public JLabel lblCheck;
	private JLabel lblNewLabel_2;


	public VistaUsuarios() {
		setUndecorated(true);
		setType(Type.POPUP);
		setBounds(100, 100, 940, 512);
		setFont(new Font("Levenim MT", Font.PLAIN, 12));
		setTitle("Gesti\u00F3n de usuarios");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		
		JLabel lblSeleccioneTipoDe = new JLabel("Registro de usuarios");
		lblSeleccioneTipoDe.setForeground(new Color(30, 144, 255));
		lblSeleccioneTipoDe.setFont(new Font("Levenim MT", Font.PLAIN, 31));
		lblSeleccioneTipoDe.setBounds(230, 46, 323, 46);
		contentPane.add(lblSeleccioneTipoDe);
		
		rdbtAsiste = new JRadioButton("Asistente");
		rdbtAsiste.setBackground(Color.WHITE);
		rdbtAsiste.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		rdbtAsiste.setBounds(187, 143, 93, 23);
		contentPane.add(rdbtAsiste);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		rdbtnSocio.setBackground(Color.WHITE);
		rdbtnSocio.setBounds(422, 143, 78, 23);
		contentPane.add(rdbtnSocio);
		
		rdbtnResponsable = new JRadioButton("Responsable");
		rdbtnResponsable.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		rdbtnResponsable.setBackground(Color.WHITE);
		rdbtnResponsable.setBounds(614, 143, 111, 23);
		contentPane.add(rdbtnResponsable);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnResponsable);
		bg.add(rdbtnSocio);
		bg.add(rdbtAsiste);
		//rdbtnResponsable.setSelected(true);
		
		
		JLabel lblIdentificadorSocio = new JLabel("Identificador socio:");
		lblIdentificadorSocio.setForeground(Color.DARK_GRAY);
		lblIdentificadorSocio.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblIdentificadorSocio.setBounds(20, 180, 142, 46);
		contentPane.add(lblIdentificadorSocio);
		
		textIDsocio = new JTextField();
		textIDsocio.setBounds(172, 193, 274, 20);
		contentPane.add(textIDsocio);
		textIDsocio.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblNombre.setBounds(20, 225, 68, 46);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(172, 238, 737, 20);
		contentPane.add(textNombre);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(172, 295, 737, 20);
		contentPane.add(textApellidos);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(172, 339, 737, 20);
		contentPane.add(textCorreo);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(172, 388, 533, 20);
		contentPane.add(textTelefono);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.DARK_GRAY);
		lblApellidos.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblApellidos.setBounds(20, 282, 93, 46);
		contentPane.add(lblApellidos);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblCorreo.setBounds(20, 326, 68, 46);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblTelefono.setBounds(20, 375, 68, 46);
		contentPane.add(lblTelefono);
		
		btnLimpiar = new JButton("LIMPIAR\r\n");
		btnLimpiar.setForeground(new Color(100, 149, 237));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 10));
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(172, 430, 91, 23);
		contentPane.add(btnLimpiar);
		
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnRegistrar.setBackground(new Color(30, 144, 255));
		btnRegistrar.setBounds(732, 374, 181, 34);
		contentPane.add(btnRegistrar);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblError.setBounds(156, 464, 397, 20);
		contentPane.add(lblError);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnSalir.setBackground(new Color(102, 153, 255));
		btnSalir.setBounds(793, 450, 120, 23);
		contentPane.add(btnSalir);
		btnSalir.setVisible(true);
		
		btnUsuariosRegistrados = new JButton("CONSULTAR USUARIOS");
		btnUsuariosRegistrados.setForeground(new Color(100, 149, 237));
		btnUsuariosRegistrados.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		btnUsuariosRegistrados.setBackground(new Color(255, 255, 255));
		btnUsuariosRegistrados.setBounds(291, 430, 172, 23);
		contentPane.add(btnUsuariosRegistrados);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 11, 210, 125);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/regUsu.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblSeleccioneElTipo = new JLabel("SELECCIONE EL TIPO DE USUARIO Y RELLENE TODOS LOS CAMPOS");
		lblSeleccioneElTipo.setForeground(Color.LIGHT_GRAY);
		lblSeleccioneElTipo.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblSeleccioneElTipo.setBounds(226, 91, 414, 23);
		contentPane.add(lblSeleccioneElTipo);
		
		lblCheck = new JLabel("");
		lblCheck.setBounds(302, 446, 40, 55);
		contentPane.add(lblCheck);
		Image img11 = new ImageIcon(this.getClass().getResource("/ok4.png")).getImage();
		lblCheck.setIcon(new ImageIcon(img11));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(660, 25, 264, 78);
		contentPane.add(lblNewLabel_1);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		lblNewLabel_2 = new JLabel("El campo IDENTIFICADOR se genera por el sistema");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(467, 196, 442, 14);
		contentPane.add(lblNewLabel_2);
		lblCheck.setVisible(false);
		
//		lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setBounds(312, 11, 212, 173);
//		contentPane.add(lblNewLabel_1);
//		Image img = new ImageIcon(this.getClass().getResource("/opcion.png")).getImage();
//		lblNewLabel_1.setIcon(new ImageIcon(img));
		
		textIDsocio.setEnabled(false);
		
		
	}
	
		public void setControladorUsuario(ControladorUsuario c){
			btnLimpiar.addActionListener(c);
			btnRegistrar.addActionListener(c);
			
			btnSalir.addActionListener(c);
			btnUsuariosRegistrados.addActionListener(c);
		}
}
