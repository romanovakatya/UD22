package controllersClient;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Cliente;
import vistasClient.VistaCreate;
import vistasClient.VistaIndex;
import vistasClient.VistaShow;

public class ControllerIndex {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	private VistaIndex vistaIndex;

	// constructor con modelo y vista index,
	public ControllerIndex(Cliente cliente, VistaIndex index) {

		this.clientes = cliente.index();
		this.vistaIndex = index;
	}

	//vista principal,
	public void iniciarVista() {
		this.vistaIndex.setTitle("Clientes");
		this.vistaIndex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaIndex.setVisible(true);

		this.vistaIndex.panel_3.setLayout(new GridLayout(clientes.size(), 1, 0, 0));

		//añadimos filas con datos,
		for (int i = 0; i < clientes.size(); i++) {
			this.vistaIndex.addFila();
			this.vistaIndex.textField_Id.setText(clientes.get(i).getId() + "");
			this.vistaIndex.textFieldName.setText(clientes.get(i).getNombre());
			this.vistaIndex.textFieldApellido.setText(clientes.get(i).getApellido());
			
			//listeners para botones que muestran y eliminan registros,
			this.vistaIndex.btnShow.addMouseListener(this.newMouseListenerShow(clientes.get(i).getId()));
			this.vistaIndex.btnDelete.addMouseListener(this.newMouseListenerDelete(clientes.get(i)));
		}

		//para añadir un registro nuevo,
		this.vistaIndex.btnAdd.addMouseListener(this.newMouseListenerAdd());
	}

	// listener para botón add,
	public MouseAdapter newMouseListenerAdd() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VistaCreate frameCreate = new VistaCreate();
				ControllerCreate controllerCreate = new ControllerCreate(frameCreate);
				controllerCreate.iniciarVista();
			}
		};

		return mouse;
	}

	//listener para los botónes show	

	public MouseAdapter newMouseListenerShow(int id) {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("lala");

				VistaShow frameShow = new VistaShow();												
				ControllerShow controllerShow = new ControllerShow(id, frameShow);
				controllerShow.iniciarVista();
			}
		};

		return mouse;
	}
	
	//listener para los botónes eliminar,	

	public MouseAdapter newMouseListenerDelete(Cliente cliente) {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("lala");

				cliente.delete(cliente);
				JOptionPane.showMessageDialog(vistaIndex, "Usuario ha sido eliminado");
				
				vistaIndex.dispose();
				
				VistaIndex frameIndex = new VistaIndex();
				ControllerIndex controllerIndex = new ControllerIndex(cliente, frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}
}
