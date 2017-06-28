package portada;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class Vportada extends JFrame {

	private JPanel contentPane;
	public JButton btnSalir;
	private JLabel lblNewLabel_3;
	JComboBox comboUS;
	 JButton btnAcceder;


	public Vportada() {
		setUndecorated(true);
		
		//Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	   // setIconImage(icon);
		setTitle("gestLab - V 1.0 - 2017\u00A9");
		setBackground(Color.WHITE);
		setResizable(false);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(UIManager.getColor("Button.disabledShadow"));
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) new Color(100, 149, 237)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
//		lblNewLabel_3 = new JLabel("");
//		lblNewLabel_3.setBounds(297, 366, 272, 64);
//		contentPane.add(lblNewLabel_3);
//		lblNewLabel_3.setIcon(new ImageIcon(img3));
		
		
		JLabel label = new JLabel("Wellcome - Bienvenido - Hallo - Bonjour");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Levenim MT", Font.PLAIN, 31));
		label.setBounds(0, 65, 914, 32);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 77, 934, 293);
		contentPane.add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/portada.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		
		btnSalir = new JButton("Salir\r\n");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(SystemColor.textHighlight);
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(129, 448, 83, 21);
		contentPane.add(btnSalir);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		
		comboUS = new JComboBox();
		comboUS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboUS.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE  USUARIO", "NUEVO USUARIO", "USUARIOS REGISTRADOS", "ADMINISTRADOR"}));
		comboUS.setForeground(new Color(100, 149, 237));
		comboUS.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		comboUS.setBackground(new Color(255, 255, 255));
		comboUS.setBounds(28, 423, 184, 20);
		contentPane.add(comboUS);
		
		btnAcceder = new JButton("Acceder\r\n");
		btnAcceder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcceder.setForeground(SystemColor.textHighlight);
		btnAcceder.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnAcceder.setBorder(UIManager.getBorder("Button.border"));
		btnAcceder.setBackground(Color.WHITE);
		btnAcceder.setBounds(27, 448, 101, 21);
		contentPane.add(btnAcceder);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(631, 378, 283, 91);
		contentPane.add(lblNewLabel_1);
		Image img3 = new ImageIcon(this.getClass().getResource("/gestlab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img3));
	}
	
	public void setControlador(ControladorPortada c){
		btnSalir.addActionListener(c);
		btnAcceder.addActionListener(c);
	}
}
