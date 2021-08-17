package vistasVideos;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class VistaShow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JTextField textField_Id;
	public JTextField textFieldTitle;
	public JTextField textFieldDirector;
	public JTextField textFieldCliente;
	private JPanel panel_1;
	private JPanel panel_2;
	public JButton btnClose;
	public JButton btnUpdate;
	
	/**
	 * Create the frame.
	 */
	public VistaShow() {		
	
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {212, 212};
		gbl_contentPane.rowHeights = new int[] {35, 35, 35, 35, 35};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 0, 10);
		gbc_lblTitle.fill = GridBagConstraints.BOTH;
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		contentPane.add(lblTitle, gbc_lblTitle);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDirector = new GridBagConstraints();
		gbc_lblDirector.insets = new Insets(0, 0, 0, 10);
		gbc_lblDirector.fill = GridBagConstraints.BOTH;
		gbc_lblDirector.gridx = 0;
		gbc_lblDirector.gridy = 2;
		contentPane.add(lblDirector, gbc_lblDirector);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldDirector.setEditable(false);
		GridBagConstraints gbc_textFieldDirector = new GridBagConstraints();
		gbc_textFieldDirector.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldDirector.fill = GridBagConstraints.BOTH;
		gbc_textFieldDirector.gridx = 1;
		gbc_textFieldDirector.gridy = 2;
		contentPane.add(textFieldDirector, gbc_textFieldDirector);
		textFieldDirector.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 0, 10);
		gbc_lblCliente.fill = GridBagConstraints.BOTH;
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 3;
		contentPane.add(lblCliente, gbc_lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldCliente.setEditable(false);
		GridBagConstraints gbc_textFieldCliente = new GridBagConstraints();
		gbc_textFieldCliente.fill = GridBagConstraints.BOTH;
		gbc_textFieldCliente.insets = new Insets(5, 0, 5, 0);
		gbc_textFieldCliente.gridx = 1;
		gbc_textFieldCliente.gridy = 3;
		contentPane.add(textFieldCliente, gbc_textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 0, 10);
		gbc_lblId.fill = GridBagConstraints.BOTH;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		contentPane.add(lblId, gbc_lblId);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
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
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldTitle.setEditable(false);
		textFieldTitle.setColumns(10);
		GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
		gbc_textFieldTitle.ipady = 4;
		gbc_textFieldTitle.insets = new Insets(5, 0, 0, 0);
		gbc_textFieldTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitle.gridx = 1;
		gbc_textFieldTitle.gridy = 1;
		contentPane.add(textFieldTitle, gbc_textFieldTitle);
		
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
