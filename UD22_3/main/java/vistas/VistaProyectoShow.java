package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
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

public class VistaProyectoShow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_Id;
	public JTextField textFieldNombre;
	public JTextField textFieldHoras;
	private JPanel panel_1;
	private JPanel panel_2;
	public JButton btnClose;
	public JButton btnUpdate;
	
	/**
	 * Create the frame.
	 */
	public VistaProyectoShow() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 35};
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
		
		textField_Id = new JTextField();
		textField_Id.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_Id.setEditable(false);
		textField_Id.setColumns(10);
		GridBagConstraints gbc_textFieldId = new GridBagConstraints();
		gbc_textFieldId.ipady = 5;
		gbc_textFieldId.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 0;
		contentPane.add(textField_Id, gbc_textFieldId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder((Border) new LineBorder(new Color(171, 173, 179)));
		textFieldNombre.setEditable(false);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas");
		GridBagConstraints gbc_lblHoras = new GridBagConstraints();
		gbc_lblHoras.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoras.gridx = 0;
		gbc_lblHoras.gridy = 2;
		contentPane.add(lblHoras, gbc_lblHoras);
		
		textFieldHoras = new JTextField();
		textFieldHoras.setBorder((Border) new LineBorder(new Color(171, 173, 179)));
		textFieldHoras.setEditable(false);
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
		
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1);

		btnClose = new JButton("Back");
		panel_1.add(btnClose);

		panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);

		btnUpdate = new JButton("Actualizar");
		panel_2.add(btnUpdate);
				
	}

}
