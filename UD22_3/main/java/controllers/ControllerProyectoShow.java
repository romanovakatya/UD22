package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import models.dao.ProyectoDAO;
import models.dto.Proyecto;
import vistas.VistaProyectoIndex;
import vistas.VistaProyectoShow;
import vistas.VistaProyectoUpdate;

public class ControllerProyectoShow {

	// atributos,
	private Proyecto proyecto = new Proyecto();
	private ProyectoDAO proyectoDAO;
	private VistaProyectoShow vistaShow;
	private String id;

	// constructor con modelo y vista para mostrar datos de un cientifico,
	public ControllerProyectoShow(String id, VistaProyectoShow vistaShow) {

			this.id = id;
			this.proyectoDAO = new ProyectoDAO();
			this.vistaShow = vistaShow;
			this.proyecto = this.proyectoDAO.show(this.id);

		}

	// iniciamos la vista de un cientifico,
	public void iniciarVista() {
		this.vistaShow.setTitle("Show proyecto" + this.id);
		this.vistaShow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaShow.setVisible(true);

		this.vistaShow.textField_Id.setText(this.proyecto.getId());
		this.vistaShow.textFieldNombre.setText(this.proyecto.getNombre());
		this.vistaShow.textFieldHoras.setText(this.proyecto.getHoras() + "");

		this.vistaShow.btnUpdate.addMouseListener(this.newMouseListener());
		this.vistaShow.btnClose.addMouseListener(this.cerrarVentana());

	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("update");

				VistaProyectoUpdate frameUpdate = new VistaProyectoUpdate();
				ControllerProyectoUpdate controllerUpdate = new ControllerProyectoUpdate(id, frameUpdate);
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

				VistaProyectoIndex frameIndex = new VistaProyectoIndex();
				ControllerProyectoIndex controllerIndex = new ControllerProyectoIndex(frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}

}
