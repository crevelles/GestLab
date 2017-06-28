package material;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class VistaMateriales extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblConsulteActualiceE;
	public JButton btnBuscar;
	public JButton btnAñadir;
	public JButton btnEliminar;
	public JButton btnModificar;
	public JScrollPane scrollPane;
	public JTable table;
	public JLabel lblCodigo;
	public JTextField textCod;
	public JTextField textNombre;
	public JTextField textStock;
	public JLabel lblError;
	public JTextField textDescrip;
	public JLabel lblRegistroNuevosMateriales;
	public JButton btnLimpiar;
	public JButton btnNuevo;
	public JButton btnModificaciones;
	public JButton btnSalirr;
	public JLabel lblNewLabel_1;
	public JLabel lblSeleModi;
	public JCheckBox checkCOnfirm;
	 JComboBox comboTipo;


	public VistaMateriales() {
		setUndecorated(true);
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Gesti\u00F3n de materiales");
		setBackground(new Color(255, 255, 255));
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
	
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblMateriales = new JLabel("Materiales");
		lblMateriales.setForeground(new Color(30, 144, 255));
		lblMateriales.setFont(new Font("Levenim MT", Font.PLAIN, 33));
		lblMateriales.setBounds(225, 35, 205, 46);
		contentPane.add(lblMateriales);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 23, 205, 87);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/mat.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblConsulteActualiceE = new JLabel("Consulte, actualice e ingrese nuevos materiales\r\n");
		lblConsulteActualiceE.setForeground(Color.LIGHT_GRAY);
		lblConsulteActualiceE.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblConsulteActualiceE.setBounds(225, 75, 362, 23);
		contentPane.add(lblConsulteActualiceE);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnBuscar.setBackground(new Color(70, 130, 180));
		btnBuscar.setBounds(752, 140, 162, 25);
		contentPane.add(btnBuscar);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setForeground(new Color(255, 255, 255));
		btnAñadir.setFont(new Font("Leelawadee", Font.PLAIN, 15));
		btnAñadir.setBackground(new Color(255, 215, 0));
		btnAñadir.setBounds(752, 354, 163, 25);
		contentPane.add(btnAñadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnEliminar.setBackground(new Color(220, 20, 60));
		btnEliminar.setBounds(752, 176, 162, 25);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnModificar.setBackground(new Color(192, 192, 192));
		btnModificar.setBounds(752, 390, 162, 25);
		contentPane.add(btnModificar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 706, 146);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
		table.setBackground(new Color(240, 248, 255));
		table.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion", "Tipo", "Stock"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(119);
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		scrollPane.setViewportView(table);
		
		lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblCodigo.setBounds(10, 300, 61, 14);
		contentPane.add(lblCodigo);
		
		textCod = new JTextField();
		textCod.setBounds(63, 296, 108, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblNombre.setBounds(181, 300, 61, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(240, 296, 476, 20);
		contentPane.add(textNombre);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblTipo.setBounds(10, 325, 44, 14);
		contentPane.add(lblTipo);
		
		JLabel lblDescripcion = new JLabel("Stock:");
		lblDescripcion.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblDescripcion.setBounds(181, 325, 61, 14);
		contentPane.add(lblDescripcion);
		
		textStock = new JTextField();
		textStock.setColumns(10);
		textStock.setBounds(240, 321, 68, 20);
		contentPane.add(textStock);
		
		JLabel lblDescripcion_1 = new JLabel("Descripci\u00F3n: ");
		lblDescripcion_1.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		lblDescripcion_1.setBounds(10, 354, 79, 14);
		contentPane.add(lblDescripcion_1);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblError.setBounds(99, 354, 617, 14);
		contentPane.add(lblError);
		
		textDescrip = new JTextField();
		textDescrip.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		textDescrip.setBounds(10, 379, 706, 83);
		contentPane.add(textDescrip);
		textDescrip.setColumns(10);
		
		lblRegistroNuevosMateriales = new JLabel("Registro y consulta de nuevos materiales\r\n");
		lblRegistroNuevosMateriales.setForeground(Color.LIGHT_GRAY);
		lblRegistroNuevosMateriales.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblRegistroNuevosMateriales.setBounds(10, 266, 476, 23);
		contentPane.add(lblRegistroNuevosMateriales);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setForeground(new Color(0, 0, 0));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.setBounds(752, 212, 162, 25);
		contentPane.add(btnLimpiar);
		
		btnModificaciones = new JButton("STOCK");
		btnModificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaciones.setForeground(Color.BLACK);
		btnModificaciones.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnModificaciones.setBackground(Color.WHITE);
		btnModificaciones.setBounds(752, 251, 162, 29);
		contentPane.add(btnModificaciones);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setForeground(Color.BLACK);
		btnNuevo.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(752, 291, 162, 46);
		contentPane.add(btnNuevo);
		
		btnSalirr = new JButton("SALIR");
		btnSalirr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalirr.setForeground(new Color(0, 0, 128));
		btnSalirr.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnSalirr.setBackground(Color.WHITE);
		btnSalirr.setBounds(752, 437, 162, 46);
		contentPane.add(btnSalirr);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(656, 11, 258, 87);
		contentPane.add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		
		ButtonGroup bg = new ButtonGroup();
		btnAñadir.setVisible(false);
		btnModificar.setVisible(false);
		
		textCod.setEditable(false);
		textNombre.setEditable(false);
		textStock.setEditable(false);
		textDescrip.setEditable(false);
		
		lblSeleModi = new JLabel("Selecciona e introduce el nuevo valor, despues pulse MODIFICAR");
		lblSeleModi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleModi.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblSeleModi.setBounds(309, 324, 407, 23);
		contentPane.add(lblSeleModi);
		
		checkCOnfirm = new JCheckBox("Confirma MODIFICAR");
		checkCOnfirm.setHorizontalAlignment(SwingConstants.RIGHT);
		checkCOnfirm.setBackground(SystemColor.text);
		checkCOnfirm.setForeground(SystemColor.desktop);
		checkCOnfirm.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		checkCOnfirm.setBounds(537, 350, 179, 23);
		contentPane.add(checkCOnfirm);
		
		comboTipo = new JComboBox();
		comboTipo.setBackground(Color.WHITE);
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"seleccione", "papeleria", "impresi\u00F3n", "mantenimento", "varios"}));
		comboTipo.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		comboTipo.setBounds(63, 321, 108, 20);
		contentPane.add(comboTipo);
		lblSeleModi.setVisible(false);
		checkCOnfirm.setVisible(false);
	}
	
		public void setControladorVistaMaterial(COntroladorVistaMaterial c){
			btnBuscar.addActionListener(c);
			btnEliminar.addActionListener(c);
			btnModificar.addActionListener(c);
			btnAñadir.addActionListener(c);
			btnSalirr.addActionListener(c);
			btnLimpiar.addActionListener(c);
			table.addMouseListener(c);
			btnModificaciones.addActionListener(c);
			btnNuevo.addActionListener(c);
		}
}
