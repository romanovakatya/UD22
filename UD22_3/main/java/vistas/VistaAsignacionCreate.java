package vistas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class VistaAsignacionCreate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JButton btnCreate;
	public JComboBox<String> comboBoxDni;
	public JComboBox<String> comboBoxProyecto;


	/**
	 * Create the frame.
	 */
	public VistaAsignacionCreate() {
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDni = new JLabel("DNI de Cientifico");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.fill = GridBagConstraints.BOTH;
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 0;
		contentPane.add(lblDni, gbc_lblDni);
		
		JLabel lblIdProyecto = new JLabel("Id de Proyecto");
		lblIdProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIdProyecto = new GridBagConstraints();
		gbc_lblIdProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdProyecto.fill = GridBagConstraints.BOTH;
		gbc_lblIdProyecto.gridx = 0;
		gbc_lblIdProyecto.gridy = 1;
		contentPane.add(lblIdProyecto, gbc_lblIdProyecto);


		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		btnCreate = new JButton("Crear");
		panel.add(btnCreate);
		
		comboBoxDni = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxDni = new GridBagConstraints();
		gbc_comboBoxDni.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDni.gridx = 1;
		gbc_comboBoxDni.gridy = 0;
		contentPane.add(comboBoxDni, gbc_comboBoxDni);
		
		comboBoxProyecto = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxProyecto = new GridBagConstraints();
		gbc_comboBoxProyecto.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxProyecto.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProyecto.gridx = 1;
		gbc_comboBoxProyecto.gridy = 1;
		contentPane.add(comboBoxProyecto, gbc_comboBoxProyecto);
	}

}
