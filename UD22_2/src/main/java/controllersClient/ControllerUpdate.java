package controllersClient;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import models.Cliente;
import vistasClient.VistaShow;
import vistasClient.VistaUpdate;

public class ControllerUpdate {
	
	//atributos,
	private Cliente cliente = new Cliente();
	private VistaUpdate vistaUpdate;
	private int id;

	
	//constructor,
	public ControllerUpdate(int id, VistaUpdate vistaUpdate) {
	
		this.id = id;
		this.cliente = this.cliente.show(this.id);
		this.vistaUpdate = vistaUpdate;
		
	}

	//iniciamos vista se actualización de datos,
	public void iniciarVista() {
		this.vistaUpdate.setTitle("Actualizar el Cliente" + this.id);
		this.vistaUpdate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaUpdate.setVisible(true);

		this.vistaUpdate.textField_Id.setText(this.cliente.getId() + "");
		this.vistaUpdate.textFieldNombre.setText(this.cliente.getNombre());
		this.vistaUpdate.textFieldApellido.setText(this.cliente.getApellido());
		this.vistaUpdate.textFieldDireccion.setText(this.cliente.getDireccion());
		this.vistaUpdate.textFieldDNI.setText(this.cliente.getDni() + "");
		this.vistaUpdate.textFieldFecha.setText(this.cliente.getFecha());
		
		this.vistaUpdate.btnUpdate.addMouseListener(this.newMouseListener());
	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("actualizar");								
				
				if (!"".equals(vistaUpdate.textFieldNombre.getText())) {
					cliente.setNombre(vistaUpdate.textFieldNombre.getText());
				}else {
					cliente.setNombre(null);
				}
				
				if (!"".equals(vistaUpdate.textFieldApellido.getText())) {
					cliente.setApellido(vistaUpdate.textFieldApellido.getText());
				}else {
					cliente.setApellido(null);
				}
				
				if (!"".equals(vistaUpdate.textFieldDireccion.getText())) {
					cliente.setDireccion(vistaUpdate.textFieldDireccion.getText());
				}else {
					cliente.setDireccion(null);
				}
				
				if (!"".equals(vistaUpdate.textFieldDNI.getText())) {
					cliente.setDni(Integer.parseInt(vistaUpdate.textFieldDNI.getText()));
				}else {
					cliente.setDni(0);
				}
				
				if (!"".equals(vistaUpdate.textFieldFecha.getText())) {
					cliente.setFecha(vistaUpdate.textFieldFecha.getText());
				}else {
					cliente.setFecha("1961-01-01");
				}
												
				cliente.update(id, cliente);
				
				//para actualizar datos de tabla inicial,
				VistaShow frameShow = new VistaShow();												
				ControllerShow controllerShow = new ControllerShow(id, frameShow);
				controllerShow.iniciarVista();
				
				vistaUpdate.dispose();
								
			}
		};

		return mouse;
	}
}
