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

public class VistaAsignacionShow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_Id_proyecto;
	public JTextField textFieldNombre;
	public JTextField textFieldHoras;
	public JTextField textFieldDni;
	public JTextField textFieldNomApels;	
	private JPanel panel_1;
	public JButton btnClose;

	/**
	 * Create the frame.
	 */
	public VistaAsignacionShow() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 35, 35, 35};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblIdProyecto = new JLabel("Id del Proyecto");
		lblIdProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIdProyecto = new GridBagConstraints();
		gbc_lblIdProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdProyecto.fill = GridBagConstraints.BOTH;
		gbc_lblIdProyecto.gridx = 0;
		gbc_lblIdProyecto.gridy = 0;
		contentPane.add(lblIdProyecto, gbc_lblIdProyecto);
		
		textField_Id_proyecto = new JTextField();
		textField_Id_proyecto.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_Id_proyecto.setEditable(false);
		textField_Id_proyecto.setColumns(10);
		GridBagConstraints gbc_textField_Id_proyecto = new GridBagConstraints();
		gbc_textField_Id_proyecto.ipady = 5;
		gbc_textField_Id_proyecto.insets = new Insets(5, 0, 5, 0);
		gbc_textField_Id_proyecto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Id_proyecto.gridx = 1;
		gbc_textField_Id_proyecto.gridy = 0;
		contentPane.add(textField_Id_proyecto, gbc_textField_Id_proyecto);
		
		JLabel lblNombre = new JLabel("Nombre del Proyecto");
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
		
		JLabel lblHoras = new JLabel("Horas del proyecto");
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
		
		JLabel lblDniCient = new JLabel("DNI del Cientifico");
		GridBagConstraints gbc_lblDniCient = new GridBagConstraints();
		gbc_lblDniCient.insets = new Insets(0, 0, 5, 5);
		gbc_lblDniCient.gridx = 0;
		gbc_lblDniCient.gridy = 3;
		contentPane.add(lblDniCient, gbc_lblDniCient);
		
		textFieldDni = new JTextField();
		textFieldDni.setEditable(false);
		GridBagConstraints gbc_textFieldDni = new GridBagConstraints();
		gbc_textFieldDni.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDni.gridx = 1;
		gbc_textFieldDni.gridy = 3;
		contentPane.add(textFieldDni, gbc_textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblNomApels = new JLabel("Nombre y Apellidos del Cientifico");
		GridBagConstraints gbc_lblNomApels = new GridBagConstraints();
		gbc_lblNomApels.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomApels.gridx = 0;
		gbc_lblNomApels.gridy = 4;
		contentPane.add(lblNomApels, gbc_lblNomApels);
		
		textFieldNomApels = new JTextField();
		textFieldNomApels.setEditable(false);
		GridBagConstraints gbc_textFieldNomApels = new GridBagConstraints();
		gbc_textFieldNomApels.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNomApels.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomApels.gridx = 1;
		gbc_textFieldNomApels.gridy = 4;
		contentPane.add(textFieldNomApels, gbc_textFieldNomApels);
		textFieldNomApels.setColumns(10);


		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		
		btnClose = new JButton("Back");
		panel_1.add(btnClose);
	}

}
