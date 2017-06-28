package reserva;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class VistaReservas extends JFrame {

	public JPanel contentPane;
	public JLabel lblNewLabel;
	public JButton btnSalir;
	public JButton btnReservar;
	public JComboBox comboResponsables;
	public JLabel lblError;
	public JComboBox comboProyectos;
	public JComboBox comboBoxMaquinas;
	public JLabel lblSeleccioneMaquina_1;
	public JComboBox comboMaq;
	public JLabel lblProyectosEnCurso;
	public JTable table;
	public JLabel lblNewLabel_1;
	public JComboBox comboMat;
	public JComboBox comboCant;
	public JLabel lblCancelarReserva;
	public JButton btnCancelar;
	public JLabel lblResponsable;
	public JTextField textRespon;
	public JButton btnEliminar;
	public JCheckBox checkElimina;
	public JLabel lblHasta;
	public JDateChooser FechaI;
	public JDateChooser FechaF;
	public JButton btnExportarPdf;
	public JLabel lblReservas_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblGif;
	private JLabel lblCantidadMxima;
	JComboBox comboStock;

	public VistaReservas() {
		setUndecorated(true);
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Reservas");
		setBounds(100, 100, 940, 512);
		// origen
		// setBounds(100, 100, 742, 530);
		// destino
		// setBounds(100, 100, 742, 599);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(10, 1, 10, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon = new ImageIcon(getClass().getResource("/ue.png")).getImage();
	    setIconImage(icon);

		btnSalir = new JButton("SALIR");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(777, 433, 135, 49);
		contentPane.add(btnSalir);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 157, 147);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/reserva.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));

		btnReservar = new JButton("Reservar");
		btnReservar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservar.setForeground(SystemColor.text);
		btnReservar.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnReservar.setBackground(SystemColor.textHighlight);
		btnReservar.setBounds(777, 236, 135, 25);
		contentPane.add(btnReservar);

		JLabel lblResponsableProyecto = new JLabel("Responsable proyecto:");
		lblResponsableProyecto.setForeground(Color.LIGHT_GRAY);
		lblResponsableProyecto.setFont(new Font("Levenim MT", Font.PLAIN, 13));
		lblResponsableProyecto.setBounds(386, 165, 181, 23);
		contentPane.add(lblResponsableProyecto);

		comboResponsables = new JComboBox();
		comboResponsables.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboResponsables.setForeground(SystemColor.textHighlight);
		comboResponsables.setBackground(Color.WHITE);
		comboResponsables.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		comboResponsables.setBounds(546, 163, 365, 25);
		contentPane.add(comboResponsables);

		JLabel lblProyecto = new JLabel("Nombre Proyecto:");
		lblProyecto.setForeground(Color.LIGHT_GRAY);
		lblProyecto.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblProyecto.setBounds(22, 238, 121, 23);
		contentPane.add(lblProyecto);

		comboProyectos = new JComboBox();
		comboProyectos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboProyectos.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONE" }));
		comboProyectos.setBackground(Color.WHITE);
		comboProyectos.setForeground(SystemColor.textHighlight);
		comboProyectos.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		comboProyectos.setBounds(134, 236, 210, 25);
		contentPane.add(comboProyectos);

		JLabel lblFechaFin = new JLabel("Inicio reserva:");
		lblFechaFin.setForeground(Color.LIGHT_GRAY);
		lblFechaFin.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		lblFechaFin.setBounds(354, 236, 83, 23);
		contentPane.add(lblFechaFin);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		lblError.setBounds(189, 272, 565, 25);
		contentPane.add(lblError);

		// comboBox = new JComboBox();
		// comboBox.setBounds(186, 294, 316, 20);
		// contentPane.add(comboBox);

		lblSeleccioneMaquina_1 = new JLabel("M\u00E1quina:");
		lblSeleccioneMaquina_1.setForeground(Color.LIGHT_GRAY);
		lblSeleccioneMaquina_1.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		lblSeleccioneMaquina_1.setBounds(22, 166, 136, 23);
		contentPane.add(lblSeleccioneMaquina_1);

		comboMaq = new JComboBox();
		comboMaq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMaq.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONE" }));
		comboMaq.setForeground(SystemColor.textHighlight);
		comboMaq.setBackground(Color.WHITE);
		comboMaq.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		comboMaq.setBounds(134, 165, 242, 25);
		contentPane.add(comboMaq);

		lblProyectosEnCurso = new JLabel("Proyectos en curso:");
		lblProyectosEnCurso.setForeground(SystemColor.textHighlight);
		lblProyectosEnCurso.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblProyectosEnCurso.setBounds(22, 274, 162, 23);
		contentPane.add(lblProyectosEnCurso);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 303, 732, 179);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(0, 0, 139));
		table.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "PROYECTO", "RESPONSABLE", "M\u00E1quina", "Inicio reserva", "Fin reserva" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(153);
		table.getColumnModel().getColumn(2).setPreferredWidth(126);
		table.getColumnModel().getColumn(3).setPreferredWidth(107);
		table.getColumnModel().getColumn(4).setPreferredWidth(127);
		scrollPane.setViewportView(table);

		lblNewLabel_1 = new JLabel("Rellene todos los campos y pulse RESERVAR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(578, 133, 334, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblMaterial = new JLabel("C\u00F3digo Material:");
		lblMaterial.setForeground(Color.LIGHT_GRAY);
		lblMaterial.setFont(new Font("Leelawadee", Font.PLAIN, 14));
		lblMaterial.setBounds(22, 199, 121, 23);
		contentPane.add(lblMaterial);

		comboMat = new JComboBox();
		comboMat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMat.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONE" }));
		comboMat.setForeground(SystemColor.textHighlight);
		comboMat.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		comboMat.setBackground(Color.WHITE);
		comboMat.setBounds(134, 200, 242, 25);
		contentPane.add(comboMat);

		comboCant = new JComboBox();
		comboCant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboCant.setModel(new DefaultComboBoxModel(
				new String[] { "SELECCIONE", "1", "5", "10", "20", "30", "50", "70", "100", "120", "150","200" }));
		comboCant.setForeground(SystemColor.textHighlight);
		comboCant.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		comboCant.setBackground(Color.WHITE);
		comboCant.setBounds(817, 200, 95, 25);
		contentPane.add(comboCant);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.LIGHT_GRAY);
		lblCantidad.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		lblCantidad.setBounds(748, 202, 59, 23);
		contentPane.add(lblCantidad);

		lblCancelarReserva = new JLabel("Cancelar reserva:");
		lblCancelarReserva.setForeground(SystemColor.textHighlight);
		lblCancelarReserva.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblCancelarReserva.setBounds(777, 368, 147, 26);
		contentPane.add(lblCancelarReserva);

		btnCancelar = new JButton("CANCELAR\r\n");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(777, 397, 135, 25);
		contentPane.add(btnCancelar);

		lblResponsable = new JLabel("Responsable:");
		lblResponsable.setForeground(SystemColor.textHighlight);
		lblResponsable.setFont(new Font("Levenim MT", Font.PLAIN, 15));
		lblResponsable.setBounds(22, 513, 108, 26);
		contentPane.add(lblResponsable);

		textRespon = new JTextField();
		textRespon.setBounds(145, 516, 147, 20);
		contentPane.add(textRespon);
		textRespon.setColumns(10);

		checkElimina = new JCheckBox("Confirmaci\u00F3n\r\n");
		checkElimina.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		checkElimina.setBackground(Color.WHITE);
		checkElimina.setBounds(317, 515, 108, 23);
		contentPane.add(checkElimina);

		btnEliminar = new JButton("eliminar");
		btnEliminar.setForeground(new Color(0, 0, 128));
		btnEliminar.setFont(new Font("Levenim MT", Font.PLAIN, 12));
		btnEliminar.setBackground(new Color(102, 205, 170));
		btnEliminar.setBounds(443, 518, 108, 19);
		contentPane.add(btnEliminar);
		Image img1 = new ImageIcon(this.getClass().getResource("/okF.png")).getImage();

		lblHasta = new JLabel("Fin reserva:\r\n");
		lblHasta.setForeground(Color.LIGHT_GRAY);
		lblHasta.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		lblHasta.setBounds(578, 236, 83, 23);
		contentPane.add(lblHasta);

		FechaI = new JDateChooser();
		FechaI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FechaI.setBounds(447, 236, 121, 25);
		contentPane.add(FechaI);

		FechaF = new JDateChooser();
		FechaF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FechaF.setBounds(656, 236, 108, 25);
		contentPane.add(FechaF);

		btnExportarPdf = new JButton("Exportar PDF");
		btnExportarPdf.setForeground(Color.WHITE);
		btnExportarPdf.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		btnExportarPdf.setBackground(new Color(255, 215, 0));
		btnExportarPdf.setBounds(777, 332, 135, 25);
		contentPane.add(btnExportarPdf);

		lblReservas_1 = new JLabel("RESERVA MAQUINA\r\n");
		lblReservas_1.setForeground(new Color(30, 144, 255));
		lblReservas_1.setFont(new Font("Levenim MT", Font.PLAIN, 32));
		lblReservas_1.setBounds(166, 44, 334, 80);
		contentPane.add(lblReservas_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(646, 11, 278, 90);
		contentPane.add(lblNewLabel_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/gestLab.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		
		lblNewLabel_3 = new JLabel("___________________________");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setBounds(168, 79, 322, 25);
		contentPane.add(lblNewLabel_3);
		
		lblGif = new JLabel("");
		lblGif.setBounds(820, 261, 68, 90);
		contentPane.add(lblGif);
		Image img3 = new ImageIcon(this.getClass().getResource("/gifImpre.gif")).getImage();
		lblGif.setIcon(new ImageIcon(img3));
		
		lblCantidadMxima = new JLabel("Disponibilidad:");
		lblCantidadMxima.setForeground(Color.LIGHT_GRAY);
		lblCantidadMxima.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		lblCantidadMxima.setBounds(386, 202, 95, 23);
		contentPane.add(lblCantidadMxima);
		
		comboStock = new JComboBox();
		comboStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboStock.setModel(new DefaultComboBoxModel(new String[] {"DISPONIBILIDAD DE MATERIAL"}));
		comboStock.setForeground(new Color(192, 192, 192));
		comboStock.setBackground(new Color(255, 255, 255));
		comboStock.setFont(new Font("Levenim MT", Font.PLAIN, 10));
		comboStock.setBounds(479, 199, 259, 23);
		contentPane.add(comboStock);
		
		// btnExportarPdf.setVisible(false);
	}

	public void setControladorVistaReserva(ControladorVistaReserva c) {
		btnSalir.addActionListener(c);
		btnReservar.addActionListener(c);
		btnCancelar.addActionListener(c);
		table.addMouseListener(c);
		btnEliminar.addActionListener(c);
		btnExportarPdf.addActionListener(c);
	}
}
