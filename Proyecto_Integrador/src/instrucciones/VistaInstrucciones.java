package instrucciones;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class VistaInstrucciones extends JFrame {

	private JPanel contentPane;
	public JButton btnSalir;


	public VistaInstrucciones() {
		setResizable(false);
		setTitle("Instrucciones");
		setType(Type.POPUP);
		
		setBounds(650, 100, 509, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
	    setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Instrucciones\r\n");
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		lblNewLabel_1.setFont(new Font("Levenim MT", Font.PLAIN, 39));
		lblNewLabel_1.setBounds(230, 11, 253, 73);
		contentPane.add(lblNewLabel_1);
		
		JTextPane txtpnSiEsLa = new JTextPane();
		txtpnSiEsLa.setText("1.\r\n2.\r\n3.\r\n4.\r\n5.\r\nCONTACTO: ");
		txtpnSiEsLa.setEditable(false);
		txtpnSiEsLa.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		txtpnSiEsLa.setBounds(20, 134, 443, 174);
		contentPane.add(txtpnSiEsLa);
		
		btnSalir = new JButton("salir");
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(356, 315, 107, 23);
		contentPane.add(btnSalir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(20, 11, 107, 112);
		contentPane.add(lblImagen);
		Image img = new ImageIcon(this.getClass().getResource("/instru.png")).getImage();
		lblImagen.setIcon(new ImageIcon(img));
	}

		public void setControlador(ControladorInstru c){
			btnSalir.addActionListener(c);
		}
}
