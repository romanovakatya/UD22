package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Cliente;
import vistas.VistaCreate;
import vistas.VistaIndex;

public class ControllerCreate {
	
	//atributos,
		private Cliente cliente;
		private VistaCreate vistaCreate;
		
		//constructor,
		public ControllerCreate(VistaCreate vistaCreate) {
			
			this.cliente = new Cliente();
			this.vistaCreate = vistaCreate;
		}

		//iniciamos la vista se creación de datos,
		public void iniciarVista() {
			this.vistaCreate.setTitle("Crear Cliente");
			this.vistaCreate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.vistaCreate.setVisible(true);

			
			this.vistaCreate.btnCreate.addMouseListener(this.newMouseListener());
		}
		
		// listeners para botón crear,
		public MouseAdapter newMouseListener() {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					System.out.println("create");
														
					if (!"".equals(vistaCreate.textFieldNombre.getText())) {
						cliente.setNombre(vistaCreate.textFieldNombre.getText());
					}else {
						cliente.setNombre(null);
					}
					
					if (!"".equals(vistaCreate.textFieldApellido.getText())) {
						cliente.setApellido(vistaCreate.textFieldApellido.getText());
					}else {
						cliente.setApellido(null);
					}
					
					if (!"".equals(vistaCreate.textFieldDireccion.getText())) {
						cliente.setDireccion(vistaCreate.textFieldDireccion.getText());
					}else {
						cliente.setDireccion(null);
					}
					
					if (!"".equals(vistaCreate.textFieldDNI.getText())) {
						cliente.setDni(Integer.parseInt(vistaCreate.textFieldDNI.getText()));
					}else {
						cliente.setDni(0);
					}
					
					if (!"".equals(vistaCreate.textFieldFecha.getText())) {
						cliente.setFecha(vistaCreate.textFieldFecha.getText());
					}else {
						cliente.setFecha("1961-01-01");
					}
													
					cliente.create(cliente);
					
					vistaCreate.dispose();
					JOptionPane.showMessageDialog(vistaCreate, "Usuario ha sido creado correctamente");
					
					//actualizamos vista principal,
					VistaIndex frameIndex = new VistaIndex();
					ControllerIndex controllerIndex = new ControllerIndex(cliente, frameIndex);
					controllerIndex.iniciarVista();
				}
			};

			return mouse;
		}
}
