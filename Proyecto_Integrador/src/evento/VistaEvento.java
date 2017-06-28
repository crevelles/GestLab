package evento;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class VistaEvento extends JFrame {

	private JPanel contentPane;
	public JButton btnSalir;
	public JScrollPane scrollPane;
	public JLabel lblError;
	private JLabel lblConsultaAsistentesAl;
	private JLabel lblNewLabel_1;
	public JLabel labelCodigo;
	JButton btnNuevo;
	JButton btnAsistencia;
	JButton btnEliminar;
	JTextField textCod;
	JTextField textMentor;
	JTextField textCateg;
	JTextField textDescrip;
	JDateChooser FechaIni;
	JButton btnRegistrar;
	JDateChooser fechaFin;
	JLabel lblRegistro;
	private JLabel lblLugar;
	JTextField textLugar;
	JLabel lblSeleccioneElEvento;
	JComboBox comboEvento;
	JLabel lblUsuario;
	JComboBox comboUsu;
	JButton btnAsiste;
	JLabel labelMentor;
	JButton btnConsultarEventos;
	JTable table;


	public VistaEvento() {
		setUndecorated(true);
		setTitle("Eventos");
		setResizable(false);
		setType(Type.POPUP);
		setBackground(SystemColor.text);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) new Color(51, 153, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		
		JLabel lblEventos = new JLabel("Eventos ");
		lblEventos.setForeground(SystemColor.textHighlight);
		lblEventos.setFont(new Font("Levenim MT", Font.PLAIN, 38));
		lblEventos.setBounds(292, 53, 206, 44);
		contentPane.add(lblEventos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(799, 112, 125, 116);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/evento.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		btnSalir = new JButton("SALIR");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(805, 429, 109, 52);
		contentPane.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//ORIGINAL
		scrollPane.setBounds(10, 151, 769, 330);
		//MODIFÇ
		//scrollPane.setBounds(10, 106, 769, 221);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "MENTOR", "CATEGORIA", "DESCRIPCION", "INICIO", "FIN", "LUGAR"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(1).setPreferredWidth(148);
		table.getColumnModel().getColumn(2).setPreferredWidth(76);
		table.getColumnModel().getColumn(3).setPreferredWidth(124);
		table.getColumnModel().getColumn(4).setPreferredWidth(71);
		table.getColumnModel().getColumn(5).setMinWidth(40);
		table.setForeground(SystemColor.windowBorder);
		table.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblError.setBounds(10, 452, 648, 21);
		contentPane.add(lblError);
		
		lblConsultaAsistentesAl = new JLabel("Consulta, elige y apuntate a un evento!!");
		lblConsultaAsistentesAl.setForeground(SystemColor.windowBorder);
		lblConsultaAsistentesAl.setFont(new Font("Levenim MT", Font.PLAIN, 17));
		lblConsultaAsistentesAl.setBounds(292, 96, 366, 30);
		contentPane.add(lblConsultaAsistentesAl);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(664, 19, 260, 82);
		contentPane.add(lblNewLabel_1);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		labelCodigo = new JLabel("Evento:");
		labelCodigo.setForeground(Color.LIGHT_GRAY);
		labelCodigo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		labelCodigo.setBounds(10, 229, 102, 30);
		contentPane.add(labelCodigo);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setForeground(new Color(0, 0, 128));
		btnNuevo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(805, 256, 109, 43);
		contentPane.add(btnNuevo);
		
		btnAsistencia = new JButton("ASISTENCIA\r\n");
		btnAsistencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAsistencia.setForeground(new Color(0, 0, 128));
		btnAsistencia.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnAsistencia.setBackground(Color.WHITE);
		btnAsistencia.setBounds(805, 310, 109, 43);
		contentPane.add(btnAsistencia);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(new Color(0, 0, 128));
		btnEliminar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(805, 364, 109, 43);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel_2 = new JLabel("Cod. Evento");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 372, 81, 21);
		contentPane.add(lblNewLabel_2);
		
		textCod = new JTextField();
		textCod.setBounds(98, 371, 86, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblMentor = new JLabel("Mentor");
		lblMentor.setForeground(Color.LIGHT_GRAY);
		lblMentor.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblMentor.setBounds(193, 372, 81, 21);
		contentPane.add(lblMentor);
		
		textMentor = new JTextField();
		textMentor.setColumns(10);
		textMentor.setBounds(245, 371, 174, 20);
		contentPane.add(textMentor);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.LIGHT_GRAY);
		lblCategoria.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblCategoria.setBounds(429, 374, 81, 21);
		contentPane.add(lblCategoria);
		
		textCateg = new JTextField();
		textCateg.setColumns(10);
		textCateg.setBounds(499, 371, 280, 20);
		contentPane.add(textCateg);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.LIGHT_GRAY);
		lblDescripcion.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblDescripcion.setBounds(10, 404, 81, 21);
		contentPane.add(lblDescripcion);
		
		textDescrip = new JTextField();
		textDescrip.setColumns(10);
		textDescrip.setBounds(98, 401, 321, 20);
		contentPane.add(textDescrip);
		
		FechaIni = new JDateChooser();
		FechaIni.setBounds(499, 400, 109, 21);
		contentPane.add(FechaIni);
		
		JLabel lblFinicio = new JLabel("F.Inicio");
		lblFinicio.setForeground(Color.LIGHT_GRAY);
		lblFinicio.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblFinicio.setBounds(429, 404, 81, 21);
		contentPane.add(lblFinicio);
		
		JLabel lblFfin = new JLabel("F.Fin");
		lblFfin.setForeground(Color.LIGHT_GRAY);
		lblFfin.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblFfin.setBounds(618, 404, 81, 21);
		contentPane.add(lblFfin);
		
		fechaFin = new JDateChooser();
		fechaFin.setBounds(670, 400, 109, 21);
		contentPane.add(fechaFin);
		
		btnRegistrar = new JButton("registrar");
		btnRegistrar.setForeground(new Color(0, 0, 128));
		btnRegistrar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(670, 429, 109, 25);
		contentPane.add(btnRegistrar);
		
		lblRegistro = new JLabel("Registro nuevo evento");
		lblRegistro.setForeground(SystemColor.textHighlight);
		lblRegistro.setFont(new Font("Levenim MT", Font.PLAIN, 24));
		lblRegistro.setBounds(10, 323, 280, 38);
		contentPane.add(lblRegistro);
		
		lblLugar = new JLabel("Lugar");
		lblLugar.setForeground(Color.LIGHT_GRAY);
		lblLugar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblLugar.setBounds(10, 432, 81, 21);
		contentPane.add(lblLugar);
		
		textLugar = new JTextField();
		textLugar.setBounds(98, 429, 321, 20);
		contentPane.add(textLugar);
		textLugar.setColumns(10);
		
		lblSeleccioneElEvento = new JLabel("Seleccione el evento al que desee asistir:");
		lblSeleccioneElEvento.setForeground(Color.LIGHT_GRAY);
		lblSeleccioneElEvento.setFont(new Font("Levenim MT", Font.PLAIN, 19));
		lblSeleccioneElEvento.setBounds(10, 189, 526, 30);
		contentPane.add(lblSeleccioneElEvento);
		
		comboEvento = new JComboBox();
		comboEvento.setFont(new Font("Leelawadee", Font.PLAIN, 12));
		comboEvento.setBounds(136, 234, 643, 20);
		contentPane.add(comboEvento);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.LIGHT_GRAY);
		lblUsuario.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 270, 102, 38);
		contentPane.add(lblUsuario);
		
		comboUsu = new JComboBox();
		comboUsu.setFont(new Font("Leelawadee", Font.PLAIN, 12));
		comboUsu.setBounds(136, 279, 250, 20);
		contentPane.add(comboUsu);
		
		btnAsiste = new JButton("asistir");
		btnAsiste.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnAsiste.setBounds(421, 276, 89, 23);
		contentPane.add(btnAsiste);
		
		labelMentor = new JLabel("");
		labelMentor.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		labelMentor.setBounds(409, 237, 370, 17);
		contentPane.add(labelMentor);
		
		btnConsultarEventos = new JButton("cosultar eventos");
		btnConsultarEventos.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnConsultarEventos.setBounds(519, 276, 260, 23);
		contentPane.add(btnConsultarEventos);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 11, 250, 129);
		contentPane.add(lblNewLabel_3);
		Image img3 = new ImageIcon(this.getClass().getResource("/evv.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		
		textCod.setVisible(false);
		textMentor.setVisible(false);
		textCateg.setVisible(false);;
		textDescrip.setVisible(false);;
		FechaIni.setVisible(false);;
		fechaFin.setVisible(false);;
		btnRegistrar.setVisible(false);
		lblRegistro.setVisible(false);
		textLugar.setVisible(false);
		
		lblSeleccioneElEvento.setVisible(false);
		comboEvento.setVisible(false);
		lblUsuario.setVisible(false);
		comboUsu.setVisible(false);
		btnAsiste.setVisible(false);
		
		
		
	}
	
		public void setControladorEventos(COntroladorEventos c){
			btnAsistencia.addActionListener(c);	
			btnAsiste.addActionListener(c);
			btnSalir.addActionListener(c);
			table.addMouseListener(c);
			btnNuevo.addActionListener(c);
			btnRegistrar.addActionListener(c);
			btnEliminar.addActionListener(c);
			btnConsultarEventos.addActionListener(c);
		}
}
