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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VistaAsignacionIndex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnAdd;
	private JPanel panel_2;
	public JPanel panel_3;
	private JLabel lblDNICientifico;
	private JLabel lblIdProyecto;
	private JLabel lblMostrar;
	private JLabel lblDelete;
	public JPanel panel_4;
	public JTextField textField_DNICientifico;
	public JTextField textFieldIdProyecto;
	public JButton btnShow;
	public JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public VistaAsignacionIndex() {
		
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 424 };
		gbl_contentPane.rowHeights = new int[] { 25, 125 };
		gbl_contentPane.columnWeights = new double[] { 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 4, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);

		btnAdd = new JButton(" Add Asignación");
		panel.add(btnAdd);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 424 };
		gbl_panel_1.rowHeights = new int[] { 15, 200 };
		gbl_panel_1.columnWeights = new double[] { 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {50, 50, 50, 50};
		gbl_panel_2.rowHeights = new int[] { 14 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0 };
		panel_2.setLayout(gbl_panel_2);

		lblDNICientifico = new JLabel("DNICientifico");
		lblDNICientifico.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDNICientifico = new GridBagConstraints();
		gbc_lblDNICientifico.weightx = 0.4;
		gbc_lblDNICientifico.insets = new Insets(0, 0, 0, 5);
		gbc_lblDNICientifico.gridx = 0;
		gbc_lblDNICientifico.gridy = 0;
		panel_2.add(lblDNICientifico, gbc_lblDNICientifico);

		lblIdProyecto = new JLabel("IdProyecto");
		lblIdProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIdProyecto = new GridBagConstraints();
		gbc_lblIdProyecto.weightx = 0.4;
		gbc_lblIdProyecto.insets = new Insets(0, 0, 0, 5);
		gbc_lblIdProyecto.gridx = 1;
		gbc_lblIdProyecto.gridy = 0;
		panel_2.add(lblIdProyecto, gbc_lblIdProyecto);

		lblMostrar = new JLabel("Mostrar");
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMostrar = new GridBagConstraints();
		gbc_lblMostrar.weightx = 0.4;
		gbc_lblMostrar.insets = new Insets(0, 0, 0, 5);
		gbc_lblMostrar.gridx = 3;
		gbc_lblMostrar.gridy = 0;
		panel_2.add(lblMostrar, gbc_lblMostrar);

		lblDelete = new JLabel("Eliminar");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDelete = new GridBagConstraints();
		gbc_lblDelete.weightx = 0.4;
		gbc_lblDelete.gridx = 4;
		gbc_lblDelete.gridy = 0;
		panel_2.add(lblDelete, gbc_lblDelete);

		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
	}

	public void addFila() {
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 5, 0, 0));

		textField_DNICientifico = new JTextField();
		textField_DNICientifico.setText("");
		textField_DNICientifico.setEditable(false);
		panel_4.add(textField_DNICientifico);
		textField_DNICientifico.setColumns(10);

		textFieldIdProyecto = new JTextField();
		textFieldIdProyecto.setEditable(false);
		panel_4.add(textFieldIdProyecto);
		textFieldIdProyecto.setColumns(10);

		btnShow = new JButton("Show");
		panel_4.add(btnShow);

		btnDelete = new JButton("Delete");
		panel_4.add(btnDelete);
	}

}
