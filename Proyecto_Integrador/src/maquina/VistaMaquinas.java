package maquina;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class VistaMaquinas extends JFrame {

	private JPanel contentPane;
	public JButton btnSalir;
	public JLabel lblNewLabel;
	public JTable table;
	public JTextField textCodigo;
	public JTextField textNombre;
	public JTextField textDescrip;
	public JButton btnModificar;
	public JButton btnIntroducirMquina;
	public JButton btnBorrar;
	public JLabel lblError;
	public JButton btnLimpiar;
	public JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;


	public VistaMaquinas() {
		setUndecorated(true);
		setType(Type.POPUP);
		setTitle("Gesti\u00F3n de m\u00E1quinas");
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
		
		JLabel lblMaquinas = new JLabel("Maquinas:");
		lblMaquinas.setForeground(new Color(30, 144, 255));
		lblMaquinas.setFont(new Font("Levenim MT", Font.PLAIN, 31));
		lblMaquinas.setBounds(112, 11, 210, 46);
		contentPane.add(lblMaquinas);
		
		JLabel lblConsulteLasMaquinas = new JLabel("Control y modificaci\u00F3n de stock de m\u00E1quinas");
		lblConsulteLasMaquinas.setForeground(Color.LIGHT_GRAY);
		lblConsulteLasMaquinas.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblConsulteLasMaquinas.setBounds(112, 55, 302, 23);
		contentPane.add(lblConsulteLasMaquinas);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(816, 427, 102, 55);
		contentPane.add(btnSalir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 11, 102, 67);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/3d.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 241, 774, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Estado", "Nombre", "Descripci\u00F3n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(275);
		scrollPane.setViewportView(table);
		
		btnIntroducirMquina = new JButton("Introducir ");
		btnIntroducirMquina.setForeground(new Color(0, 0, 128));
		btnIntroducirMquina.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnIntroducirMquina.setBackground(Color.WHITE);
		btnIntroducirMquina.setBounds(816, 241, 102, 48);
		contentPane.add(btnIntroducirMquina);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		lblCodigo.setBounds(20, 101, 69, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		lblNombre.setBounds(20, 132, 69, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		lblEstado.setBounds(230, 97, 45, 23);
		contentPane.add(lblEstado);
		
		JLabel lblDescripcin = new JLabel("Descripcion: ");
		lblDescripcin.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		lblDescripcin.setBounds(20, 165, 85, 14);
		contentPane.add(lblDescripcin);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textCodigo.setBounds(83, 95, 124, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textNombre.setColumns(10);
		textNombre.setBounds(83, 128, 711, 20);
		contentPane.add(textNombre);
		
		textDescrip = new JTextField();
		textDescrip.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textDescrip.setColumns(10);
		textDescrip.setBounds(20, 190, 774, 40);
		contentPane.add(textDescrip);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 0, 128));
		btnModificar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(816, 334, 102, 23);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnBorrar.setBackground(new Color(0, 191, 255));
		btnBorrar.setBounds(816, 300, 102, 23);
		contentPane.add(btnBorrar);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblError.setBounds(115, 156, 679, 23);
		contentPane.add(lblError);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnLimpiar.setBackground(new Color(0, 191, 255));
		btnLimpiar.setBounds(816, 368, 102, 23);
		contentPane.add(btnLimpiar);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(0, 191, 255));
		comboBox.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE ESTADO", "DISPONIBLE", "Reservada", "Revision"}));
		comboBox.setBounds(285, 97, 509, 23);
		contentPane.add(comboBox);
		
		lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setBounds(662, 11, 262, 73);
		contentPane.add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(816, 132, 102, 75);
		contentPane.add(lblNewLabel_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/gR.gif")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
	}
	
		public void setControladorVistaMaquinas(ControladorMaquinas c){
			btnIntroducirMquina.addActionListener(c);
			btnBorrar.addActionListener(c);
			btnModificar.addActionListener(c);
			btnSalir.addActionListener(c);
			table.addMouseListener(c);
			btnLimpiar.addActionListener(c);
		}
}
