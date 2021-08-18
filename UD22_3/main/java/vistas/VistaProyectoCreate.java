package vistas;

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

public class VistaProyectoCreate extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_Id;
	public JTextField textFieldNombre;
	public JTextField textFieldHoras;
	
	public JButton btnCreate;
	private JLabel lblHoras;


	/**
	 * Create the frame.
	 */
	public VistaProyectoCreate() {
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 0, 35};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.fill = GridBagConstraints.BOTH;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		contentPane.add(lblId, gbc_lblId);
		
		JLabel lblNombre = new JLabel("Nombre del proyecto");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder((Border) new LineBorder(new Color(171, 173, 179)));
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldApellido);
		textFieldNombre.setColumns(10);
		
		lblHoras = new JLabel("Horas");
		GridBagConstraints gbc_lblHoras = new GridBagConstraints();
		gbc_lblHoras.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoras.gridx = 0;
		gbc_lblHoras.gridy = 2;
		contentPane.add(lblHoras, gbc_lblHoras);
		
		textFieldHoras = new JTextField();
		GridBagConstraints gbc_textFieldHoras = new GridBagConstraints();
		gbc_textFieldHoras.ipady = 4;
		gbc_textFieldHoras.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldHoras.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHoras.gridx = 1;
		gbc_textFieldHoras.gridy = 2;
		contentPane.add(textFieldHoras, gbc_textFieldHoras);
		textFieldHoras.setColumns(10);


		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		btnCreate = new JButton("Crear");
		panel.add(btnCreate);
		
		textField_Id = new JTextField();
		textField_Id.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_Id.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.ipady = 5;
		gbc_textFieldNombre.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		contentPane.add(textField_Id, gbc_textFieldNombre);
	}

}
