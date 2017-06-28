package somos;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Window.Type;

public class VistaSomos extends JFrame {

	private JPanel contentPane;
	public JButton btnCerrar;
	public JButton btnInstrucciones;


	public VistaSomos() {
		setResizable(false);
		setType(Type.POPUP);
		setTitle("\u00BFQuienes somos?");
		setBackground(Color.WHITE);
		
		
		setBounds(100, 100, 565, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
	    setLocationRelativeTo(null);
		
		JLabel lblquienesSomos = new JLabel("\u00BFQuienes somos?");
		lblquienesSomos.setHorizontalAlignment(SwingConstants.CENTER);
		lblquienesSomos.setForeground(new Color(25, 25, 112));
		lblquienesSomos.setFont(new Font("Levenim MT", Font.PLAIN, 27));
		lblquienesSomos.setBounds(227, 38, 273, 32);
		contentPane.add(lblquienesSomos);
		
		JLabel lblDadlakdasdjajdajdkjasdjadjksadjkasjdksajdkasjdasjdkjaskdjaskdjaskdjkasdjkasjdkasjdksajdkasjdkasjdkajdjsa = new JLabel("El presente software se desarrolla durante los meses de Mayo y Junio de 2017");
		lblDadlakdasdjajdajdkjasdjadjksadjkasjdksajdkasjdasjdkjaskdjaskdjaskdjkasdjkasjdkasjdksajdkasjdkasjdkajdjsa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadlakdasdjajdajdkjasdjadjksadjkasjdksajdkasjdasjdkjaskdjaskdjaskdjkasdjkasjdkasjdksajdkasjdkasjdkajdjsa.setForeground(new Color(25, 25, 112));
		lblDadlakdasdjajdajdkjasdjadjksadjkasjdksajdkasjdasjdkjaskdjaskdjaskdjkasdjkasjdkasjdksajdkasjdkasjdkajdjsa.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblDadlakdasdjajdajdkjasdjadjksadjkasjdksajdkasjdasjdkjaskdjaskdjaskdjkasdjkasjdkasjdksajdkasjdkasjdkajdjsa.setBounds(10, 359, 529, 15);
		contentPane.add(lblDadlakdasdjajdajdkjasdjadjksadjkasjdksajdkasjdasjdkjaskdjaskdjaskdjkasdjkasjdkasjdksajdkasjdkasjdkajdjsa);
		
		JTextPane txtpnSomosUnGrupo = new JTextPane();
		txtpnSomosUnGrupo.setEditable(false);
		txtpnSomosUnGrupo.setForeground(Color.GRAY);
		txtpnSomosUnGrupo.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		txtpnSomosUnGrupo.setText("Somos un grupo de alumnos del CFGS en Desarrollo de Aplicaciones Multiplataforma de la Universidad Europea de Madrid. \r\nBajo la supervisi\u00F3n de Jairo Bilbao y Susana Rold\u00E1n se desarrolla el proyecto integrador  \"Club FabLab 2017\" para gestionar de una manera mas eficiente el control de m\u00E1quinas y materiales en el club fabLab de la Universidad. Tambi\u00E9n ofrece la posibilidad de gestionar eventos y asistencias en el club.");
		txtpnSomosUnGrupo.setBounds(228, 71, 296, 216);
		contentPane.add(txtpnSomosUnGrupo);
		
		btnCerrar = new JButton("cerrar");
		btnCerrar.setForeground(new Color(0, 0, 128));
		btnCerrar.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnCerrar.setBackground(Color.WHITE);
		btnCerrar.setBounds(443, 385, 96, 23);
		contentPane.add(btnCerrar);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(10, 11, 208, 337);
		contentPane.add(lblImg);
		Image img1 = new ImageIcon(this.getClass().getResource("/somos.jpg")).getImage();
		lblImg.setIcon(new ImageIcon(img1));
		
		btnInstrucciones = new JButton("Instrucciones");
		btnInstrucciones.setForeground(new Color(0, 0, 128));
		btnInstrucciones.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnInstrucciones.setBackground(Color.WHITE);
		btnInstrucciones.setBounds(10, 386, 121, 23);
		contentPane.add(btnInstrucciones);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(278, 260, 80, 88);
		contentPane.add(lblNewLabel);
		Image img3 = new ImageIcon(this.getClass().getResource("/java.gif")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(368, 295, 156, 53);
		contentPane.add(lblNewLabel_1);
		Image img4 = new ImageIcon(this.getClass().getResource("/ora.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img4));
		
//		Image img1 = new ImageIcon(this.getClass().getResource("/ue.png")).getImage();
//		label_1.setIcon(new ImageIcon(img1));
	}
		public void setControladorSomos(ControladorSomos c){
			btnCerrar.addActionListener(c);
			btnInstrucciones.addActionListener(c);
		}
}
