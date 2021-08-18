package vistas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class VistaCientificoUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldDni;
	public JTextField textFieldNomApels;
	public JButton btnUpdate;


	/**
	 * Create the frame.
	 */
	public VistaCientificoUpdate() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.fill = GridBagConstraints.BOTH;
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 0;
		contentPane.add(lblDni, gbc_lblDni);
		
		JLabel lblNomApels = new JLabel("Nombre y Apellidos");
		lblNomApels.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNomApels = new GridBagConstraints();
		gbc_lblNomApels.fill = GridBagConstraints.BOTH;
		gbc_lblNomApels.gridx = 0;
		gbc_lblNomApels.gridy = 1;
		contentPane.add(lblNomApels, gbc_lblNomApels);
		
		textFieldNomApels = new JTextField();
		textFieldNomApels.setBorder((Border) new LineBorder(new Color(171, 173, 179)));
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 1;
		contentPane.add(textFieldNomApels, gbc_textFieldApellido);
		textFieldNomApels.setColumns(10);
		

		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
	
		btnUpdate = new JButton("Guardar");
		panel.add(btnUpdate);
		
		textFieldDni = new JTextField();
		textFieldDni.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldDni.setEditable(false);
		textFieldDni.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.ipady = 4;
		gbc_textFieldNombre.insets = new Insets(5, 0, 0, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		contentPane.add(textFieldDni, gbc_textFieldNombre);
	}
}
