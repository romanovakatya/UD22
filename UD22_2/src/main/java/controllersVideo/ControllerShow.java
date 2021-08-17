package controllersVideo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import models.Cliente;
//import models.Cliente;
import models.Video;
import vistasVideos.VistaIndex;
import vistasVideos.VistaShow;
import vistasVideos.VistaUpdate;


public class ControllerShow {

	// atributos,
	private Video video = new Video();
	private VistaShow vistaShow;
	private int id;

	// constructor con modelo y vista para mostrar datos de un cliente,,
	public ControllerShow(int id, VistaShow vistaShow) {

		this.id = id;
		this.vistaShow = vistaShow;
		this.video = this.video.show(this.id);

	}

	//iniciamos la vista de un cliente,
	public void iniciarVista() {
		this.vistaShow.setTitle("Show película" + this.id);
		this.vistaShow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaShow.setVisible(true);

		this.vistaShow.textField_Id.setText(this.video.getId() + "");
		this.vistaShow.textFieldTitle.setText(this.video.getTitle());
		this.vistaShow.textFieldDirector.setText(this.video.getDirector());
		this.vistaShow.textFieldCliente.setText(this.video.getCliente_id() + "");

		this.vistaShow.btnUpdate.addMouseListener(this.newMouseListener());
		this.vistaShow.btnClose.addMouseListener(this.cerrarVentana());
		
	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VistaUpdate frameUpdate = new VistaUpdate();
				Cliente cliente = new Cliente();
				ControllerUpdate controllerUpdate = new ControllerUpdate(id, frameUpdate, cliente);
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
				
				VistaIndex frameIndex = new VistaIndex();
				ControllerIndex controllerIndex = new ControllerIndex(video, frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}

}