package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.ProyectoDAO;
import models.dto.Proyecto;
import vistas.VistaProyectoIndex;
import vistas.VistaProyectoUpdate;

public class ControllerProyectoUpdate {

	
	// atributos,
		private Proyecto proyecto;
		private ProyectoDAO proyectoDAO;
		private VistaProyectoUpdate vistaUpdate;
		private String id;

		// constructor,
		public ControllerProyectoUpdate(String id, VistaProyectoUpdate vistaUpdate) {

			this.id = id;			
			this.proyectoDAO = new ProyectoDAO();
			this.vistaUpdate = vistaUpdate;
			this.proyecto = this.proyectoDAO.show(id);
		}

		// iniciamos la vista se creación de datos,
		public void iniciarVista() {
			this.vistaUpdate.setTitle("Actualizar el Proyecto" + this.id);
			this.vistaUpdate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.vistaUpdate.setVisible(true);
			
			this.vistaUpdate.textField_Id.setText(this.proyecto.getId());
			this.vistaUpdate.textFieldNombre.setText(this.proyecto.getNombre());
			this.vistaUpdate.textFieldHoras.setText(this.proyecto.getHoras() + "");

			this.vistaUpdate.btnUpdate.addMouseListener(this.newMouseListener());
		}

		// listeners para botón update,
		public MouseAdapter newMouseListener() {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if (!"".equals(vistaUpdate.textFieldNombre.getText())) {

						proyecto.setNombre(vistaUpdate.textFieldNombre.getText());

					} else {

						proyecto.setNombre(proyecto.getNombre());
					}

					
					if (!"".equals(vistaUpdate.textFieldHoras.getText())) {
						proyecto.setHoras(Integer.parseInt(vistaUpdate.textFieldHoras.getText()));
					} else {
						proyecto.setHoras(proyecto.getHoras());
					}

					proyectoDAO.update(id, proyecto);

					vistaUpdate.dispose();
					JOptionPane.showMessageDialog(vistaUpdate, "Proyecto ha sido actualizado correctamente");

					// actualizamos vista principal,
					VistaProyectoIndex frameIndex = new VistaProyectoIndex();
					ControllerProyectoIndex controllerIndex = new ControllerProyectoIndex(frameIndex);
					controllerIndex.iniciarVista();
				}
			};

			return mouse;
		}
}
