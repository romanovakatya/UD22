package controllers;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.ProyectoDAO;
import models.dto.Proyecto;
import vistas.VistaProyectoCreate;
import vistas.VistaProyectoIndex;
import vistas.VistaProyectoShow;

public class ControllerProyectoIndex {
	
	//atributos,
		private List<Proyecto> proyectos = new ArrayList<Proyecto>();
		private VistaProyectoIndex vistaIndex;
		private ProyectoDAO proyectoDAO; 
		
		
		// constructor con modelo y vista index,
			public ControllerProyectoIndex(VistaProyectoIndex index) {

				this.proyectoDAO = new ProyectoDAO();
				this.proyectos = proyectoDAO.index();
				this.vistaIndex = index;
			}
			
			//vista principal,
			public void iniciarVista() {
				this.vistaIndex.setTitle("Proyectos");
				this.vistaIndex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				this.vistaIndex.setVisible(true);
				
				this.vistaIndex.panel_3.setLayout(new GridLayout(this.proyectos.size(), 1, 0, 0));
				
				//añadimos filas con los datos de proyectos,
				for (int i = 0; i < proyectos.size(); i++) {
					this.vistaIndex.addFila();
					this.vistaIndex.textField_Id.setText(proyectos.get(i).getId() + "");
					this.vistaIndex.textFieldNombre.setText(proyectos.get(i).getNombre());	
					this.vistaIndex.textFieldHoras.setText(proyectos.get(i).getHoras() + "");
					
					//listeners para botones que muestran y eliminan registros,
					this.vistaIndex.btnShow.addMouseListener(this.newMouseListenerShow(proyectos.get(i).getId()));
					this.vistaIndex.btnDelete.addMouseListener(this.newMouseListenerDelete(proyectos.get(i)));
				}

				//para añadir un registro nuevo,
				this.vistaIndex.btnAdd.addMouseListener(this.newMouseListenerAdd());
			}
			
			// listener para botón add,
			public MouseAdapter newMouseListenerAdd() {
				MouseAdapter mouse = new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						vistaIndex.dispose();
						
						System.out.println("add");
						VistaProyectoCreate frameCreate = new VistaProyectoCreate();
						ControllerProyectoCreate controllerCreate = new ControllerProyectoCreate(frameCreate);
						controllerCreate.iniciarVista();
					}
				};

				return mouse;
			}

			//listener para los botónes show	

			public MouseAdapter newMouseListenerShow(String id) {
				MouseAdapter mouse = new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("show");

						vistaIndex.dispose();
						
						VistaProyectoShow frameShow = new VistaProyectoShow();												
						ControllerProyectoShow controllerShow = new ControllerProyectoShow(id, frameShow);
						controllerShow.iniciarVista();
					}
				};

				return mouse;
			}
			
			//listener para los botónes eliminar,	

			public MouseAdapter newMouseListenerDelete(Proyecto proyecto) {
				MouseAdapter mouse = new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("delete");
						
						proyectoDAO.delete(proyecto);
						JOptionPane.showMessageDialog(vistaIndex, "Proyecto ha sido eliminado");
						
						vistaIndex.dispose();
						
						VistaProyectoIndex frameIndex = new VistaProyectoIndex();
						ControllerProyectoIndex controllerIndex = new ControllerProyectoIndex(frameIndex);
						controllerIndex.iniciarVista();
					}
				};

				return mouse;
			}

}
