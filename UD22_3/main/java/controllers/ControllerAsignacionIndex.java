package controllers;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.CientificoAsignadoAProyectoDAO;
import models.dto.CientificoAsignadoAProyecto;
import vistas.VistaAsignacionCreate;
import vistas.VistaAsignacionIndex;
import vistas.VistaAsignacionShow;

public class ControllerAsignacionIndex {

	// atributos,
	private List<CientificoAsignadoAProyecto> asignaciones = new ArrayList<CientificoAsignadoAProyecto>();
	private VistaAsignacionIndex vistaIndex;
	private CientificoAsignadoAProyectoDAO asignacionDAO;

	// constructor con modelo y vista index,
	public ControllerAsignacionIndex(VistaAsignacionIndex index) {

		this.asignacionDAO = new CientificoAsignadoAProyectoDAO();
		this.asignaciones = asignacionDAO.index();
		this.vistaIndex = index;
	}

	// vista principal,
	public void iniciarVista() {
		this.vistaIndex.setTitle("Cientificos asignados a los proyectos");
		this.vistaIndex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaIndex.setVisible(true);

		this.vistaIndex.panel_3.setLayout(new GridLayout(this.asignaciones.size(), 1, 0, 0));

		// añadimos filas con datos,
		for (int i = 0; i < asignaciones.size(); i++) {
			this.vistaIndex.addFila();
			this.vistaIndex.textField_DNICientifico.setText(asignaciones.get(i).getDNICientifico());
			this.vistaIndex.textFieldIdProyecto.setText(asignaciones.get(i).getIdProyecto());

			// listeners para botones que muestran y eliminan registros,
			this.vistaIndex.btnShow.addMouseListener(this.newMouseListenerShow(asignaciones.get(i).getDNICientifico(),
					asignaciones.get(i).getIdProyecto()));
			this.vistaIndex.btnDelete.addMouseListener(this.newMouseListenerDelete(asignaciones.get(i)));
		}

		// para añadir un registro nuevo,
		this.vistaIndex.btnAdd.addMouseListener(this.newMouseListenerAdd());
	}

	// listener para botón add,
	public MouseAdapter newMouseListenerAdd() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				vistaIndex.dispose();

				System.out.println("add");
				VistaAsignacionCreate frameCreate = new VistaAsignacionCreate();
				ControllerAsignacionCreate controllerCreate = new ControllerAsignacionCreate(frameCreate);
				controllerCreate.iniciarVista();
			}
		};

		return mouse;
	}

	// listener para los botónes show

	public MouseAdapter newMouseListenerShow(String DNICientifico, String idProyecto) {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("show");

				vistaIndex.dispose();
				VistaAsignacionShow frameShow = new VistaAsignacionShow();
				ControllerAsignacionShow controllerShow = new ControllerAsignacionShow(DNICientifico, idProyecto,
						frameShow);
				controllerShow.iniciarVista();
			}
		};

		return mouse;
	}

	// listener para los botónes eliminar,

	public MouseAdapter newMouseListenerDelete(CientificoAsignadoAProyecto asignacion) {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("delete");

				asignacionDAO.delete(asignacion);
				JOptionPane.showMessageDialog(vistaIndex, "Asignacion ha sido eliminada");

				vistaIndex.dispose();

				VistaAsignacionIndex frameIndex = new VistaAsignacionIndex();
				ControllerAsignacionIndex controllerIndex = new ControllerAsignacionIndex(frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}
}
