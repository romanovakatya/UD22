package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import vistas.VistaAsignacionIndex;
import vistas.VistaCientificoIndex;
import vistas.VistaMain;
import vistas.VistaProyectoIndex;


public class ControllerMain {
	
	private VistaMain vistaMain;
	
	//controller,
	public ControllerMain(VistaMain vistaMain) {

		this.vistaMain = vistaMain;
	}

	public void iniciarVista() {
		this.vistaMain.setTitle("Elegir CRUD");
		this.vistaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.vistaMain.setVisible(true);

		this.vistaMain.btnCIENTIFICOS.addMouseListener(this.newMouseListenerCientificos());
		this.vistaMain.btnPROYECTOS.addMouseListener(this.newMouseListenerProyectos());
		this.vistaMain.btnAsignar.addMouseListener(this.newMouseListenerAsignar());
	}

	// listener para el botón que abre el crud de cientificos,
	public MouseAdapter newMouseListenerCientificos() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("Cientifico");
				// llamamos la vista principal con datos de todos los cienntificos,
				VistaCientificoIndex frameIndexCientificos = new VistaCientificoIndex();
				ControllerCientificoIndex controllerIndex = new ControllerCientificoIndex(frameIndexCientificos);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}

	// listener para el botón que abre el crud de proyectos,
	public MouseAdapter newMouseListenerProyectos() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("Proyecto");
				// llamamos la vista principal con datos de todos los proyectos,
				VistaProyectoIndex frameIndexProyectos = new VistaProyectoIndex();
				ControllerProyectoIndex controllerIndexProyectos = new ControllerProyectoIndex(
						frameIndexProyectos);
				controllerIndexProyectos.iniciarVista();
			}
		};

		return mouse;
	}


	// listener para el botón que abre el crud de asignación proyectos a cientificos,
		public MouseAdapter newMouseListenerAsignar() {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					System.out.println("Asignado");
					// llamamos la vista principal con datos de todas las asignaciones,
					VistaAsignacionIndex frameIndexAsignar = new VistaAsignacionIndex();
					ControllerAsignacionIndex controllerIndexAsignar = new ControllerAsignacionIndex(frameIndexAsignar);
					controllerIndexAsignar.iniciarVista();
				}
			};

			return mouse;
		}
}
