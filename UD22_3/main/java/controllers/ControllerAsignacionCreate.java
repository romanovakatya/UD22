package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.CientificoAsignadoAProyectoDAO;
import models.dao.CientificoDAO;
import models.dao.ProyectoDAO;
import models.dto.Cientifico;
import models.dto.CientificoAsignadoAProyecto;
import models.dto.Proyecto;
import vistas.VistaAsignacionCreate;
import vistas.VistaAsignacionIndex;


public class ControllerAsignacionCreate {

	// atributos,
		private CientificoAsignadoAProyecto asignacion;
		private CientificoAsignadoAProyectoDAO asignacionDAO;
		private VistaAsignacionCreate vistaCreate;
		private List<Cientifico> cientificos = new ArrayList<Cientifico>();
		private List<Proyecto> proyectos = new ArrayList<Proyecto>();
		private CientificoDAO cientificoDAO;
		private ProyectoDAO proyectoDAO;

		// constructor,
		public ControllerAsignacionCreate(VistaAsignacionCreate vistaCreate) {

			this.asignacion = new CientificoAsignadoAProyecto();
			this.asignacionDAO = new CientificoAsignadoAProyectoDAO();
			this.vistaCreate = vistaCreate;
			
			this.cientificoDAO = new CientificoDAO();
			this.proyectoDAO = new ProyectoDAO();
			this.cientificos = cientificoDAO.index();
			this.proyectos = proyectoDAO.index();
		}

		// iniciamos la vista se creación de datos,
		public void iniciarVista() {
			this.vistaCreate.setTitle("Asignar Cientifico al proyecto");
			this.vistaCreate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.vistaCreate.setVisible(true);
			
			//añadimos cientificos y proyectos a los menus desplegable,
			for (int i = 0; i < cientificos.size(); i++) {
				this.vistaCreate.comboBoxDni.addItem(cientificos.get(i).getdNI());
			}
			
			
			for (int i = 0; i < proyectos.size(); i++) {
				this.vistaCreate.comboBoxProyecto.addItem(proyectos.get(i).getId());
			}
			
			
			this.vistaCreate.btnCreate.addMouseListener(this.newMouseListener());
		}

		// listeners para botón crear,
		public MouseAdapter newMouseListener() {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					System.out.println("create");
			
					asignacion.setDNICientifico(vistaCreate.comboBoxDni.getSelectedItem() + "");
					asignacion.setIdProyecto(vistaCreate.comboBoxProyecto.getSelectedItem() + "");


					asignacionDAO.create(asignacion);

					vistaCreate.dispose();
					JOptionPane.showMessageDialog(vistaCreate, "Cientifico ha sido asignado a un proyecto correctamente");

					// actualizamos vista principal,
					VistaAsignacionIndex frameIndex = new VistaAsignacionIndex();
					ControllerAsignacionIndex controllerIndex = new ControllerAsignacionIndex(frameIndex);
					controllerIndex.iniciarVista();
				}
			};

			return mouse;
		}
}
