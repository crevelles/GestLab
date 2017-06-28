package evento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;

public class VistaEventosRegistrados extends JFrame {

	private JPanel contentPane;

	JButton btnSalir;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	JComboBox comboEventos;
	JButton btnConsultar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	JTable tableEvento;
	JTable tableUsuario;
	private JLabel lblDatosDelEvento;
	 JButton btnLimpiar;
	 private JLabel lblUsuariosRegistradosEn;
	 private JLabel lblConsulteLosUsuarios;

	public VistaEventosRegistrados() {
		setUndecorated(true);
		setTitle("Eventos");
		setResizable(false);
		setType(Type.POPUP);
		setBackground(SystemColor.text);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) new Color(51, 153, 255)));
		contentPane.setBackground(SystemColor.text);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
	    
	    
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(21, 27, 125, 116);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/evento.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(656, 11, 268, 94);
		contentPane.add(lblNewLabel_1);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(805, 448, 109, 25);
		contentPane.add(btnSalir);
		
		lblNewLabel_2 = new JLabel("Asistencia a eventos");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Levenim MT", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(145, 27, 340, 53);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Selecciona el evento que desee consultar");
		lblNewLabel_3.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 154, 340, 25);
		contentPane.add(lblNewLabel_3);
		
		comboEventos = new JComboBox();
		comboEventos.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		comboEventos.setBounds(348, 157, 447, 20);
		contentPane.add(comboEventos);
		
		btnConsultar = new JButton("consultar");
		btnConsultar.setForeground(new Color(0, 0, 128));
		btnConsultar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(805, 154, 109, 25);
		contentPane.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 904, 43);
		contentPane.add(scrollPane);
		
		tableEvento = new JTable();
		tableEvento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mentor", "Tema", "Fecha Inicio", "Fecha Fin", "Tipo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEvento.getColumnModel().getColumn(0).setPreferredWidth(178);
		tableEvento.getColumnModel().getColumn(1).setPreferredWidth(186);
		tableEvento.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane.setViewportView(tableEvento);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 301, 904, 139);
		contentPane.add(scrollPane_1);
		
		tableUsuario = new JTable();
		tableUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellidos", "Correo"
			}
		));
		tableUsuario.getColumnModel().getColumn(1).setPreferredWidth(248);
		tableUsuario.getColumnModel().getColumn(2).setPreferredWidth(294);
		scrollPane_1.setViewportView(tableUsuario);
		
		lblDatosDelEvento = new JLabel("Datos del evento");
		lblDatosDelEvento.setForeground(Color.GRAY);
		lblDatosDelEvento.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblDatosDelEvento.setBounds(10, 190, 169, 25);
		contentPane.add(lblDatosDelEvento);
		
		btnLimpiar = new JButton("limpiar\r\n");
		btnLimpiar.setForeground(new Color(30, 144, 255));
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		btnLimpiar.setBounds(10, 449, 89, 23);
		contentPane.add(btnLimpiar);
		
		lblUsuariosRegistradosEn = new JLabel("Usuarios registrados en el evento");
		lblUsuariosRegistradosEn.setForeground(Color.GRAY);
		lblUsuariosRegistradosEn.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblUsuariosRegistradosEn.setBounds(10, 277, 250, 25);
		contentPane.add(lblUsuariosRegistradosEn);
		
		lblConsulteLosUsuarios = new JLabel("Consulte los usuarios registrados para el evento");
		lblConsulteLosUsuarios.setForeground(Color.GRAY);
		lblConsulteLosUsuarios.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblConsulteLosUsuarios.setBounds(145, 79, 447, 25);
		contentPane.add(lblConsulteLosUsuarios);
		//Image img4 = new ImageIcon(this.getClass().getResource("/lan.png")).getImage();
	}
		public void setControladorAsistenciaEventos(ControladorAsistenciaEventos c){
			btnConsultar.addActionListener(c);
			btnSalir.addActionListener(c);
//			tableEvento.addMouseListener(c);
//			tableUsuario.addMouseListener(c);
			btnLimpiar.addActionListener(c);
		}
}
