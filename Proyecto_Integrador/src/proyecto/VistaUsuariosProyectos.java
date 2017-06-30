package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaUsuariosProyectos extends JFrame {

	JPanel contentPane;
	JComboBox comboProyectos;
	JButton btnConsultarUsuProyectos;
	JComboBox comboUsuarios;
	JButton btnRegistrar;
	JTable table;
	JButton btnSalir;
	JButton btnBaja;
	JLabel lblNmeroDeUsuarios;

	public VistaUsuariosProyectos() {
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
		
		JLabel lblProyectos = new JLabel("Registro y consulta de usuarios en proyectos");
		lblProyectos.setForeground(new Color(30, 144, 255));
		lblProyectos.setFont(new Font("Levenim MT", Font.PLAIN, 32));
		lblProyectos.setBounds(20, 42, 683, 46);
		contentPane.add(lblProyectos);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setBounds(701, 46, 216, 181);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/pro.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione proyecto");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 95, 147, 32);
		contentPane.add(lblNewLabel_1);
		
		comboProyectos = new JComboBox();
		comboProyectos.setBackground(Color.WHITE);
		comboProyectos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		comboProyectos.setBounds(20, 128, 378, 20);
		contentPane.add(comboProyectos);
		
		btnConsultarUsuProyectos = new JButton("Consultar");
		btnConsultarUsuProyectos.setBounds(426, 125, 147, 23);
		contentPane.add(btnConsultarUsuProyectos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 229, 896, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellidos", "Correo", "Tipo Usuario", "Proyecto"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(173);
		table.getColumnModel().getColumn(2).setPreferredWidth(158);
		table.getColumnModel().getColumn(4).setPreferredWidth(124);
		scrollPane.setViewportView(table);
		
		JLabel lblSeleccioneUsuarioQue = new JLabel("Seleccione usuario que desea registrar en el proyecto");
		lblSeleccioneUsuarioQue.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblSeleccioneUsuarioQue.setBounds(20, 149, 378, 32);
		contentPane.add(lblSeleccioneUsuarioQue);
		
		comboUsuarios = new JComboBox();
		comboUsuarios.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		comboUsuarios.setBackground(Color.WHITE);
		comboUsuarios.setBounds(20, 185, 378, 20);
		contentPane.add(comboUsuarios);
		
		btnRegistrar = new JButton("Registrar\r\n");
		btnRegistrar.setBounds(426, 182, 147, 23);
		contentPane.add(btnRegistrar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(770, 459, 147, 23);
		contentPane.add(btnSalir);
		
		JLabel lblSiDeseaDar = new JLabel("Si desea dar de baja a un usuario en un proyecto pulse el bot\u00F3n BAJA");
		lblSiDeseaDar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblSiDeseaDar.setBounds(20, 451, 505, 32);
		contentPane.add(lblSiDeseaDar);
		
		btnBaja = new JButton("BAJA");
		btnBaja.setBounds(512, 460, 103, 23);
		contentPane.add(btnBaja);
		
		lblNmeroDeUsuarios = new JLabel("N\u00FAmero de usuarios que conforman el proyecto: ");
		lblNmeroDeUsuarios.setForeground(new Color(100, 149, 237));
		lblNmeroDeUsuarios.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNmeroDeUsuarios.setBounds(20, 427, 378, 32);
		contentPane.add(lblNmeroDeUsuarios);
	}
		public void setControlador(ConstroladorVistaUsuariosProyectos c){
			btnBaja.addActionListener(c);
			btnConsultarUsuProyectos.addActionListener(c);
			btnRegistrar.addActionListener(c);
			btnSalir.addActionListener(c);
		}
}
