package pideUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import javax.swing.border.MatteBorder;

public class VistaPideU extends JFrame {

	private JPanel contentPane;
	public JButton btnSalir;
	public JButton btnAcceso;
	public JTextField textID;
	public JLabel labelSocio;
	public JLabel lblContrasea;
	public JLabel lblError;
	private JLabel lblUsuariosRegistrados;
	 JPasswordField textPassw;


	public VistaPideU() {
		setUndecorated(true);
		setResizable(false);
		
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setBounds(650, 11, 274, 82);
		contentPane.add(lblNewLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		JLabel lblNewLabel_1 = new JLabel("Identificaci\u00F3n de acceso\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(24, 218, 910, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("______________________________________________________________________________________");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 238, 934, 23);
		contentPane.add(lblNewLabel_2);
		
		btnAcceso = new JButton("acceder");
		btnAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcceso.setBackground(SystemColor.text);
		btnAcceso.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnAcceso.setBounds(816, 437, 96, 23);
		contentPane.add(btnAcceso);
		
		ButtonGroup bg= new ButtonGroup();
		
		btnSalir = new JButton("salir");
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(24, 437, 96, 23);
		contentPane.add(btnSalir);
		
		labelSocio = new JLabel("ID Socio");
		labelSocio.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		labelSocio.setForeground(Color.GRAY);
		labelSocio.setBounds(337, 317, 71, 23);
		contentPane.add(labelSocio);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.GRAY);
		lblContrasea.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		lblContrasea.setBounds(337, 362, 80, 23);
		contentPane.add(lblContrasea);
		
		textID = new JTextField();
		textID.setBounds(454, 319, 162, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Leelawadee", Font.PLAIN, 15));
		lblError.setBounds(205, 396, 528, 31);
		contentPane.add(lblError);
		
		lblUsuariosRegistrados = new JLabel("USUARIOS REGISTRADOS");
		lblUsuariosRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuariosRegistrados.setForeground(Color.GRAY);
		lblUsuariosRegistrados.setFont(new Font("Levenim MT", Font.PLAIN, 20));
		lblUsuariosRegistrados.setBounds(10, 262, 934, 31);
		contentPane.add(lblUsuariosRegistrados);
		
		textPassw = new JPasswordField();
		textPassw.setBounds(454, 364, 162, 21);
		contentPane.add(textPassw);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(37, -5, 227, 256);
		contentPane.add(lblNewLabel_3);
		Image img = new ImageIcon(this.getClass().getResource("/login3.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
	}
		public void setControlador(ControladorPU c){
			btnAcceso.addActionListener(c);
			btnSalir.addActionListener(c);
		}
}
