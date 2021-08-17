package controllersVideo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import models.Cliente;
import models.Video;
import vistasVideos.VistaShow;
import vistasVideos.VistaUpdate;


public class ControllerUpdate {
	
	//atributos,
	private Video video = new Video();
	private VistaUpdate vistaUpdate;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private int id;

	
	//constructor,
	public ControllerUpdate(int id, VistaUpdate vistaUpdate, Cliente cliente) {
	
		this.id = id;
		this.video = this.video.show(this.id);
		this.vistaUpdate = vistaUpdate;
		this.clientes = cliente.index();
		
	}

	//iniciamos vista se actualización de datos,
	public void iniciarVista() {
		this.vistaUpdate.setTitle("Actualizar el Video" + this.id);
		this.vistaUpdate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaUpdate.setVisible(true);

		this.vistaUpdate.textField_Id.setText(this.video.getId() + "");
		this.vistaUpdate.textFieldTitle.setText(this.video.getTitle());
		this.vistaUpdate.textFieldDirector.setText(this.video.getDirector());

		//añadimos clientos en el menu desplegable,
		for (int i = 0; i < clientes.size(); i++) {
			this.vistaUpdate.comboBox.addItem(clientes.get(i).getId() + " - " + clientes.get(i).getNombre());
		}
		
		this.vistaUpdate.btnUpdate.addMouseListener(this.newMouseListener());
	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				char sacarId = ((String) vistaUpdate.comboBox.getSelectedItem()).charAt(0);
				System.out.println("actualizar");								
				
				if (!"".equals(vistaUpdate.textFieldTitle.getText())) {
					video.setTitle(vistaUpdate.textFieldTitle.getText());
				}else {
					video.setTitle(null);
				}
				
				if (!"".equals(vistaUpdate.textFieldDirector.getText())) {
					video.setDirector(vistaUpdate.textFieldDirector.getText());
				}else {
					video.setDirector(null);
				}
				
				if (!"".equals(String.valueOf(sacarId))) {
					video.setCliente_id(Integer.parseInt(String.valueOf(sacarId)));
				}else {
					video.setCliente_id(0);
				}
																		
				video.update(id, video);
				
				//para actualizar datos de tabla inicial,
				VistaShow frameShow = new VistaShow();												
				ControllerShow controllerShow = new ControllerShow(id, frameShow);
				controllerShow.iniciarVista();
				
				vistaUpdate.dispose();
								
			}
		};

		return mouse;
	}
}
