package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import models.dao.CientificoAsignadoAProyectoDAO;
import models.dao.CientificoDAO;
import models.dao.ProyectoDAO;
import models.dto.Cientifico;
import models.dto.CientificoAsignadoAProyecto;
import models.dto.Proyecto;
import vistas.VistaAsignacionIndex;
import vistas.VistaAsignacionShow;

public class ControllerAsignacionShow {

	// atributos,
	private CientificoAsignadoAProyecto asignacion;
	private CientificoAsignadoAProyectoDAO asignacionDAO;
	private VistaAsignacionShow vistaShow;
	private Cientifico cientifico;
	private Proyecto proyecto;
	private CientificoDAO cientificoDAO;
	private ProyectoDAO proyectoDAO;
	private String DNICientifico;
	private String idProyecto;

	// constructor,
	public ControllerAsignacionShow(String DNICientifico, String idProyecto, VistaAsignacionShow vistaShow) {
		this.DNICientifico = DNICientifico;
		this.idProyecto = idProyecto;
		this.asignacionDAO = new CientificoAsignadoAProyectoDAO();
		this.cientificoDAO = new CientificoDAO();
		this.proyectoDAO = new ProyectoDAO();
		this.asignacion = this.asignacionDAO.show(this.DNICientifico, this.idProyecto);
		this.vistaShow = vistaShow;
		this.cientifico = cientificoDAO.show(this.asignacion.getDNICientifico());
		this.proyecto = proyectoDAO.show(this.asignacion.getIdProyecto());
	}

	// iniciamos la vista de una asignación,
	public void iniciarVista() {

		this.vistaShow.setTitle("Mostrar asignación");
		this.vistaShow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaShow.setVisible(true);

		this.vistaShow.textField_Id_proyecto.setText(this.asignacion.getIdProyecto());
		this.vistaShow.textFieldDni.setText(this.asignacion.getDNICientifico());
		this.vistaShow.textFieldHoras.setText(this.proyecto.getHoras() + "");
		this.vistaShow.textFieldNombre.setText(this.proyecto.getNombre());
		this.vistaShow.textFieldNomApels.setText(this.cientifico.getNomApells());

		this.vistaShow.btnClose.addMouseListener(this.cerrarVentana());

	}

	// para actualizar datos cuando se cierra ventana "mostrar un registro",
	public MouseAdapter cerrarVentana() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				vistaShow.dispose();

				VistaAsignacionIndex frameIndex = new VistaAsignacionIndex();
				ControllerAsignacionIndex controllerIndex = new ControllerAsignacionIndex(frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}

}
