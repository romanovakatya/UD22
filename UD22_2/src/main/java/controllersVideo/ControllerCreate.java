package controllersVideo;

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



public class ControllerCreate {
	
	//atributos,
		private Video video;
		private VistaCreate vistaCreate;
		private List<Cliente> clientes = new ArrayList<Cliente>();
		
		//constructor,
		public ControllerCreate(VistaCreate vistaCreate, Cliente cliente) {
			
			this.video = new Video();
			this.vistaCreate = vistaCreate;
			this.clientes = cliente.index();
		}

		//iniciamos la vista se creación de datos,
		public void iniciarVista() {
			this.vistaCreate.setTitle("Crear Video");
			this.vistaCreate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.vistaCreate.setVisible(true);
			
			//añadimos clientos en el menu desplegable,
			for (int i = 0; i < clientes.size(); i++) {
				this.vistaCreate.comboBox.addItem(clientes.get(i).getId() + " - " + clientes.get(i).getNombre());
			}
			
			
			this.vistaCreate.btnCreate.addMouseListener(this.newMouseListener());
		}
		
		// listeners para botón crear,
		public MouseAdapter newMouseListener() {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					//guardamos id de cliente como un char,
					char sacarId = ((String) vistaCreate.comboBox.getSelectedItem()).charAt(0);
					System.out.println("create");

														
					if (!"".equals(vistaCreate.textFieldTitle.getText())) {
						video.setTitle(vistaCreate.textFieldTitle.getText());
					}else {
						video.setTitle(null);
					}
					
					if (!"".equals(vistaCreate.textFieldDirector.getText())) {
						video.setDirector(vistaCreate.textFieldDirector.getText());
					}else {
						video.setDirector(null);
					}

					
					if (!"".equals(String.valueOf(sacarId))) {
						video.setCliente_id(Integer.parseInt(String.valueOf(sacarId)));
					}else {
						video.setCliente_id(0);
					}
							
													
					video.create(video);
					
					vistaCreate.dispose();
					JOptionPane.showMessageDialog(vistaCreate, "Película ha sido añadida correctamente");
					
					//actualizamos vista principal,
					VistaIndex frameIndex = new VistaIndex();
					ControllerIndex controllerIndex = new ControllerIndex(video, frameIndex);
					controllerIndex.iniciarVista();
				}
			};

			return mouse;
		}
}
