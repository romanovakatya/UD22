package controllerMain;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import controllersClient.ControllerIndex;
import models.Cliente;
import models.Video;
import vistaMain.VistaMain;
import vistasClient.VistaIndex;


public class ControllerMain {

	private VistaMain vistaMain;

	public ControllerMain(VistaMain vistaMain) {

		this.vistaMain = vistaMain;
	}

	public void iniciarVista() {
		this.vistaMain.setTitle("Elegir CRUD");
		this.vistaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.vistaMain.setVisible(true);

		this.vistaMain.btnClientes.addMouseListener(this.newMouseListenerClientes());
		this.vistaMain.btnVideos.addMouseListener(this.newMouseListenerVideos());
	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListenerClientes() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// llamamos la vista principal con datos de todos los clientes,
				Cliente cliente = new Cliente();
				VistaIndex frameIndex = new VistaIndex();
				ControllerIndex controllerIndex = new ControllerIndex(cliente, frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListenerVideos() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// llamamos la vista principal con datos de todos los videos,
				Video video = new Video();
				vistasVideos.VistaIndex frameIndexVideos = new vistasVideos.VistaIndex();
				controllersVideo.ControllerIndex controllerIndexVideos = new controllersVideo.ControllerIndex(video,
						frameIndexVideos);
				controllerIndexVideos.iniciarVista();
			}
		};

		return mouse;
	}

}
