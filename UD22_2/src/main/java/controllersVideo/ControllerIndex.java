package controllersVideo;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Cliente;
import models.Video;
import vistasVideos.VistaCreate;
import vistasVideos.VistaIndex;
import vistasVideos.VistaShow;


public class ControllerIndex {

	private List<Video> videos = new ArrayList<Video>();
	private VistaIndex vistaIndex;

	// constructor con modelo y vista index,
	public ControllerIndex(Video video, VistaIndex index) {

		this.videos = video.index();
		this.vistaIndex = index;
	}

	//vista principal,
	public void iniciarVista() {
		this.vistaIndex.setTitle("Videos");
		this.vistaIndex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaIndex.setVisible(true);

		this.vistaIndex.panel_3.setLayout(new GridLayout(videos.size(), 1, 0, 0));

		//añadimos filas con datos,
		for (int i = 0; i < videos.size(); i++) {
			this.vistaIndex.addFila();
			this.vistaIndex.textField_Id.setText(videos.get(i).getId() + "");
			this.vistaIndex.textFieldTitle.setText(videos.get(i).getTitle());
			
			//listeners para botones que muestran y eliminan registros,
			this.vistaIndex.btnShow.addMouseListener(this.newMouseListenerShow(videos.get(i).getId()));
			this.vistaIndex.btnDelete.addMouseListener(this.newMouseListenerDelete(videos.get(i)));
		}

		//para añadir un registro nuevo,
		this.vistaIndex.btnAdd.addMouseListener(this.newMouseListenerAdd());
	}

	// listener para botón add,
	public MouseAdapter newMouseListenerAdd() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VistaCreate frameCreate = new VistaCreate();
				Cliente cliente = new Cliente();
				ControllerCreate controllerCreate = new ControllerCreate(frameCreate, cliente);
				controllerCreate.iniciarVista();
			}
		};

		return mouse;
	}

	//listener para los botónes show	

	public MouseAdapter newMouseListenerShow(int id) {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("lala");

				VistaShow frameShow = new VistaShow();												
				ControllerShow controllerShow = new ControllerShow(id, frameShow);
				controllerShow.iniciarVista();
			}
		};

		return mouse;
	}
	
	//listener para los botónes eliminar,	

	public MouseAdapter newMouseListenerDelete(Video video) {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("lala");

				video.delete(video);
				JOptionPane.showMessageDialog(vistaIndex, "Video ha sido eliminado");
				
				vistaIndex.dispose();
				
				VistaIndex frameIndex = new VistaIndex();
				ControllerIndex controllerIndex = new ControllerIndex(video, frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}
}
