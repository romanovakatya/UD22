package vistaMain;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VistaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnVideos;
	public JButton btnClientes;

	/**
	 * Create the frame.
	 */
	public VistaMain() {

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnVideos = new JButton("CRUD Videos");
		btnVideos.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(btnVideos);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		btnClientes = new JButton("CRUD Clientes");
		panel_1.add(btnClientes);
	}

}
