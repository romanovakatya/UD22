package controllersClient;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import models.Cliente;
import vistasClient.VistaIndex;
import vistasClient.VistaShow;
import vistasClient.VistaUpdate;

public class ControllerShow {

	// atributos,
	private Cliente cliente = new Cliente();
	private VistaShow vistaShow;
	private int id;

	// constructor con modelo y vista para mostrar datos de un cliente,,
	public ControllerShow(int id, VistaShow vistaShow) {

		this.id = id;
		this.vistaShow = vistaShow;
		this.cliente = this.cliente.show(this.id);

	}

	//iniciamos la vista de un cliente,
	public void iniciarVista() {
		this.vistaShow.setTitle("Show cliente" + this.id);
		this.vistaShow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaShow.setVisible(true);

		this.vistaShow.textField_Id.setText(this.cliente.getId() + "");
		this.vistaShow.textFieldNombre.setText(this.cliente.getNombre());
		this.vistaShow.textFieldApellido.setText(this.cliente.getApellido());
		this.vistaShow.textFieldDireccion.setText(this.cliente.getDireccion());
		this.vistaShow.textFieldDNI.setText(this.cliente.getDni() + "");
		this.vistaShow.textFieldFecha.setText(this.cliente.getFecha());

		this.vistaShow.btnUpdate.addMouseListener(this.newMouseListener());
		this.vistaShow.btnClose.addMouseListener(this.cerrarVentana());
		
	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VistaUpdate frameUpdate = new VistaUpdate();
				ControllerUpdate controllerUpdate = new ControllerUpdate(id, frameUpdate);
				controllerUpdate.iniciarVista();

				vistaShow.dispose();

			}
		};

		return mouse;
	}

	// para actualizar datos cuando se cierra ventana "mostrar un registro",
	public MouseAdapter cerrarVentana() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				vistaShow.dispose();
				
				VistaIndex frameIndex = new VistaIndex();
				ControllerIndex controllerIndex = new ControllerIndex(cliente, frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}

}