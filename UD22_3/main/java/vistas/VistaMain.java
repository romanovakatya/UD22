package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VistaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnCIENTIFICOS;
	public JButton btnPROYECTOS;
	public JButton btnAsignar;

	/**
	 * Create the frame.
	 */
	public VistaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCIENTIFICOS = new JButton("CRUD CIENTIFICOS");
		contentPane.add(btnCIENTIFICOS);
		
		btnPROYECTOS = new JButton("CRUD PROYECTOS");
		contentPane.add(btnPROYECTOS);
		
		btnAsignar = new JButton("Asignar proyecto a cientifico");
		contentPane.add(btnAsignar);
	}

}
