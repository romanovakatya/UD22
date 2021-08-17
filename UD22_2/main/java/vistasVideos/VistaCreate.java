package vistasVideos;

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
import javax.swing.JComboBox;

public class VistaCreate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldTitle;
	public JTextField textFieldDirector;
	public JButton btnCreate;
	public JComboBox<String> comboBox;
	private JLabel lblClientes;

	/**
	 * Create the frame.
	 */
	public VistaCreate() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 35, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.fill = GridBagConstraints.BOTH;
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		contentPane.add(lblTitle, gbc_lblTitle);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDirector = new GridBagConstraints();
		gbc_lblDirector.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirector.fill = GridBagConstraints.BOTH;
		gbc_lblDirector.gridx = 0;
		gbc_lblDirector.gridy = 1;
		contentPane.add(lblDirector, gbc_lblDirector);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setBorder((Border) new LineBorder(new Color(171, 173, 179)));
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 1;
		contentPane.add(textFieldDirector, gbc_textFieldApellido);
		textFieldDirector.setColumns(10);
		
		lblClientes = new JLabel("Clientes");
		GridBagConstraints gbc_lblClientes = new GridBagConstraints();
		gbc_lblClientes.insets = new Insets(0, 0, 5, 0);
		gbc_lblClientes.gridx = 0;
		gbc_lblClientes.gridy = 2;
		contentPane.add(lblClientes, gbc_lblClientes);
	
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		btnCreate = new JButton("Crear");
		panel.add(btnCreate);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldTitle.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.ipady = 4;
		gbc_textFieldNombre.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		contentPane.add(textFieldTitle, gbc_textFieldNombre);

	}

}
