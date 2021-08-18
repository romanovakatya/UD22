package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.ProyectoDAO;
import models.dto.Proyecto;
import vistas.VistaProyectoCreate;
import vistas.VistaProyectoIndex;

public class ControllerProyectoCreate {

	// atributos,
	private Proyecto proyecto;
	private ProyectoDAO proyectoDAO;
	private VistaProyectoCreate vistaCreate;

	// constructor,
	public ControllerProyectoCreate(VistaProyectoCreate vistaCreate) {

		this.proyecto = new Proyecto();
		this.proyectoDAO = new ProyectoDAO();
		this.vistaCreate = vistaCreate;
	}

	// iniciamos la vista se creación de datos,
	public void iniciarVista() {
		this.vistaCreate.setTitle("Crear un Proyecto nuevo");
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

				if (!"".equals(vistaCreate.textField_Id.getText())) {

					// para controlar el tamaño de id del proyecto,
					if (vistaCreate.textField_Id.getText().length() <= 4) {
						proyecto.setId(vistaCreate.textField_Id.getText());
					} else {
						proyecto.setId(vistaCreate.textField_Id.getText().substring(0, 4));
					}

				} else {

					proyecto.setId("0000");
				}

				
				if (!"".equals(vistaCreate.textFieldNombre.getText())) {

					proyecto.setNombre(vistaCreate.textFieldNombre.getText());

				} else {

					proyecto.setNombre("Proyecto 0");
				}

				
				if (!"".equals(vistaCreate.textFieldHoras.getText())) {
					proyecto.setHoras(Integer.parseInt(vistaCreate.textFieldHoras.getText()));
				} else {
					proyecto.setHoras(0);
				}

				proyectoDAO.create(proyecto);

				vistaCreate.dispose();
				JOptionPane.showMessageDialog(vistaCreate, "Proyecto ha sido creado correctamente");

				// actualizamos vista principal,
				VistaProyectoIndex frameIndex = new VistaProyectoIndex();
				ControllerProyectoIndex controllerIndex = new ControllerProyectoIndex(frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}
}
