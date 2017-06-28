package pedido;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class VistaPedidos extends JFrame {

	public JPanel contentPane;
	public JLabel lblimagen;
	public JLabel lblControlYGestin;
	public JButton buttonSalir;
	public JTable table;
	public JScrollPane scrollPane;
	private JLabel lblNewLabel;
	public JButton btnNuevoProveedor;
	public JTextField textImporte;
	public JFormattedTextField textDetalle;
	public JLabel lblCdigo;
	public JLabel lblFecha;
	public JLabel lblImporte;
	public JLabel lblDetalle;
	public JLabel lblCif;
	public JButton btnConsultar;
	public JLabel lblProveedor;
	public JButton btnRegistrar;
	public JLabel lblError;
	public JDateChooser dateChooser;
	JButton btnLimpiar;
	JComboBox comboPRO;
	JComboBox comboCIF;
	JTextField textCod;
	JButton btnBaja;


	public VistaPedidos() {
		setUndecorated(true);
		setResizable(false);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);
		setTitle("Pedidos");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setForeground(SystemColor.textHighlight);
		lblPedidos.setFont(new Font("Levenim MT", Font.PLAIN, 27));
		lblPedidos.setBounds(187, 32, 118, 39);
		contentPane.add(lblPedidos);
		
		lblimagen = new JLabel("");
		lblimagen.setBounds(35, 11, 150, 130);
		contentPane.add(lblimagen);
		Image img = new ImageIcon(this.getClass().getResource("/pedido.jpg")).getImage();
		lblimagen.setIcon(new ImageIcon(img));
		
		lblControlYGestin = new JLabel("Control y gesti\u00F3n de los pedidos registrados en el fabLab");
		lblControlYGestin.setForeground(SystemColor.textInactiveText);
		lblControlYGestin.setFont(new Font("Gulim", Font.PLAIN, 15));
		lblControlYGestin.setBounds(187, 67, 383, 39);
		contentPane.add(lblControlYGestin);
		
		buttonSalir = new JButton("SALIR");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonSalir.setForeground(new Color(0, 0, 128));
		buttonSalir.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		buttonSalir.setBackground(Color.WHITE);
		buttonSalir.setBounds(782, 449, 118, 25);
		contentPane.add(buttonSalir);
		
		scrollPane = new JScrollPane();
		//original
		scrollPane.setBounds(35, 139, 865, 289);
		//modificado
		//scrollPane.setBounds(35, 139, 864, 137);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Fecha", "Importe", "CIF"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(657, 27, 258, 79);
		contentPane.add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		
		btnNuevoProveedor = new JButton("NUEVO - BUSCAR\r\n");
		btnNuevoProveedor.setForeground(new Color(0, 0, 128));
		btnNuevoProveedor.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		btnNuevoProveedor.setBackground(Color.WHITE);
		btnNuevoProveedor.setBounds(35, 449, 187, 25);
		contentPane.add(btnNuevoProveedor);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setForeground(SystemColor.textInactiveText);
		lblCdigo.setFont(new Font("Gulim", Font.PLAIN, 15));
		lblCdigo.setBounds(35, 252, 66, 39);
		contentPane.add(lblCdigo);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(SystemColor.textInactiveText);
		lblFecha.setFont(new Font("Gulim", Font.PLAIN, 15));
		lblFecha.setBounds(239, 252, 66, 39);
		contentPane.add(lblFecha);
		
		lblImporte = new JLabel("Importe:");
		lblImporte.setForeground(SystemColor.textInactiveText);
		lblImporte.setFont(new Font("Gulim", Font.PLAIN, 15));
		lblImporte.setBounds(439, 252, 66, 39);
		contentPane.add(lblImporte);
		
		lblCif = new JLabel("Cif:");
		lblCif.setForeground(SystemColor.textInactiveText);
		lblCif.setFont(new Font("Gulim", Font.PLAIN, 15));
		lblCif.setBounds(646, 252, 49, 39);
		contentPane.add(lblCif);
		
		lblDetalle = new JLabel("Detalle:");
		lblDetalle.setForeground(SystemColor.textInactiveText);
		lblDetalle.setFont(new Font("Gulim", Font.PLAIN, 15));
		lblDetalle.setBounds(35, 288, 66, 39);
		contentPane.add(lblDetalle);
		
		textImporte = new JTextField();
		textImporte.setEditable(false);
		textImporte.setColumns(10);
		textImporte.setBounds(500, 262, 119, 20);
		contentPane.add(textImporte);
		
		textDetalle = new JFormattedTextField();
		textDetalle.setEditable(false);
		textDetalle.setBounds(35, 320, 865, 96);
		contentPane.add(textDetalle);
		
		btnConsultar = new JButton("consultar\r\n");
		btnConsultar.setForeground(new Color(0, 0, 128));
		btnConsultar.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(461, 449, 98, 25);
		contentPane.add(btnConsultar);
		
		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setForeground(SystemColor.textHighlight);
		lblProveedor.setFont(new Font("Levenim MT", Font.PLAIN, 16));
		lblProveedor.setBounds(584, 288, 83, 32);
		contentPane.add(lblProveedor);
		
		btnRegistrar = new JButton("registrar");
		btnRegistrar.setForeground(new Color(0, 0, 128));
		btnRegistrar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(569, 449, 98, 25);
		contentPane.add(btnRegistrar);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		lblError.setBounds(187, 104, 480, 25);
		contentPane.add(lblError);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(295, 260, 134, 20);
		contentPane.add(dateChooser);
		btnRegistrar.setVisible(false);
		dateChooser.setEnabled(false);
		
		btnLimpiar = new JButton("limpiar");
		btnLimpiar.setForeground(new Color(0, 0, 128));
		btnLimpiar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(674, 449, 98, 25);
		contentPane.add(btnLimpiar);
		
		comboCIF = new JComboBox();
		comboCIF.setBackground(Color.WHITE);
		comboCIF.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		comboCIF.setBounds(677, 262, 223, 20);
		contentPane.add(comboCIF);
		
		comboPRO = new JComboBox();
		comboPRO.setBackground(Color.WHITE);
		comboPRO.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		comboPRO.setBounds(677, 293, 223, 20);
		contentPane.add(comboPRO);
		
		textCod = new JTextField();
		textCod.setBounds(99, 262, 123, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		btnBaja = new JButton("BAJA");
		btnBaja.setBackground(SystemColor.text);
		btnBaja.setForeground(new Color(255, 0, 0));
		btnBaja.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		btnBaja.setBounds(362, 450, 89, 23);
		contentPane.add(btnBaja);
		textCod.setVisible(false);
		dateChooser.setVisible(false);
		textImporte.setVisible(false);
		textDetalle.setVisible(false);
		lblCif.setVisible(false);
		lblCdigo.setVisible(false);
		lblFecha.setVisible(false);
		lblImporte.setVisible(false);
		lblDetalle.setVisible(false);
		btnConsultar.setVisible(false);
		lblProveedor.setVisible(false);
		btnLimpiar.setVisible(false);
	}
		public void setControlador(ControladorPedidos c){
			buttonSalir.addActionListener(c);
			btnNuevoProveedor.addActionListener(c);
			btnConsultar.addActionListener(c);
			btnRegistrar.addActionListener(c);
			table.addMouseListener(c);
			btnLimpiar.addActionListener(c);
			btnBaja.addActionListener(c);
		}
}
