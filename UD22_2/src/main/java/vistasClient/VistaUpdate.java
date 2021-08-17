package vistasClient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VistaUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_Id;
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldDireccion;
	public JTextField textFieldDNI;
	public JTextField textFieldFecha;
	public JButton btnUpdate;
	
	/**
	 * Create the frame.
	 */
	public VistaUpdate() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 35, 35, 35, 35};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.fill = GridBagConstraints.BOTH;
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBorder((Border) new LineBorder(new Color(171, 173, 179)));
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 2;
		contentPane.add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.fill = GridBagConstraints.BOTH;
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 3;
		contentPane.add(lblDireccion, gbc_lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBorder(new LineBorder(new Color(171, 173, 179)));
		GridBagConstraints gbc_textFieldDireccion = new GridBagConstraints();
		gbc_textFieldDireccion.fill = GridBagConstraints.BOTH;
		gbc_textFieldDireccion.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldDireccion.gridx = 1;
		gbc_textFieldDireccion.gridy = 3;
		contentPane.add(textFieldDireccion, gbc_textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.fill = GridBagConstraints.BOTH;
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 4;
		contentPane.add(lblDNI, gbc_lblDNI);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.fill = GridBagConstraints.BOTH;
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 5;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.fill = GridBagConstraints.BOTH;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		contentPane.add(lblId, gbc_lblId);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		
		btnUpdate = new JButton("Guardar");
		panel.add(btnUpdate);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldNombre.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.ipady = 4;
		gbc_textFieldNombre.insets = new Insets(5, 0, 0, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldDNI.setColumns(10);
		GridBagConstraints gbc_textFieldDNI = new GridBagConstraints();
		gbc_textFieldDNI.ipady = 4;
		gbc_textFieldDNI.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDNI.gridx = 1;
		gbc_textFieldDNI.gridy = 4;
		contentPane.add(textFieldDNI, gbc_textFieldDNI);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBorder(new LineBorder(new Color(171, 173, 179)));
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldFecha.fill = GridBagConstraints.BOTH;
		gbc_textFieldFecha.gridx = 1;
		gbc_textFieldFecha.gridy = 5;
		contentPane.add(textFieldFecha, gbc_textFieldFecha);
		textFieldFecha.setColumns(10);
		
		textField_Id = new JTextField();
		textField_Id.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_Id.setEditable(false);
		GridBagConstraints gbc_textField_Id = new GridBagConstraints();
		gbc_textField_Id.fill = GridBagConstraints.BOTH;
		gbc_textField_Id.insets = new Insets(5, 0, 5, 0);
		gbc_textField_Id.gridx = 1;
		gbc_textField_Id.gridy = 0;
		contentPane.add(textField_Id, gbc_textField_Id);
		textField_Id.setColumns(10);
	}
}



