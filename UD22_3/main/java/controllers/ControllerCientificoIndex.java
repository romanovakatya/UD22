package controllers;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.CientificoDAO;
import models.dto.Cientifico;
import vistas.VistaCientificoCreate;
import vistas.VistaCientificoIndex;
import vistas.VistaCientificoShow;



public class ControllerCientificoIndex {

	//atributos,
	private List<Cientifico> cientificos = new ArrayList<Cientifico>();
	private VistaCientificoIndex vistaIndex;
	private CientificoDAO cientificoDAO; 
	
	
	// constructor con modelo y vista index,
		public ControllerCientificoIndex(VistaCientificoIndex index) {

			this.cientificoDAO = new CientificoDAO();
			this.cientificos = cientificoDAO.index();
			this.vistaIndex = index;
		}
		
		//vista principal,
		public void iniciarVista() {
			this.vistaIndex.setTitle("Cientificos");
			this.vistaIndex.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.vistaIndex.setVisible(true);
			
			this.vistaIndex.panel_3.setLayout(new GridLayout(this.cientificos.size(), 1, 0, 0));
			
			//añadimos filas con datos,
			for (int i = 0; i < cientificos.size(); i++) {
				this.vistaIndex.addFila();
				this.vistaIndex.textField_DNI.setText(cientificos.get(i).getdNI() + "");
				this.vistaIndex.textFieldNomApells.setText(cientificos.get(i).getNomApells());				
				
				//listeners para botones que muestran y eliminan registros,
				this.vistaIndex.btnShow.addMouseListener(this.newMouseListenerShow(cientificos.get(i).getdNI()));
				this.vistaIndex.btnDelete.addMouseListener(this.newMouseListenerDelete(cientificos.get(i)));
			}

			//para añadir un registro nuevo,
			this.vistaIndex.btnAdd.addMouseListener(this.newMouseListenerAdd());
		}
		
		// listener para botón add,
		public MouseAdapter newMouseListenerAdd() {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					System.out.println("add");
					VistaCientificoCreate frameCreate = new VistaCientificoCreate();
					ControllerCientificoCreate controllerCreate = new ControllerCientificoCreate(frameCreate);
					controllerCreate.iniciarVista();
				}
			};

			return mouse;
		}

		//listener para los botónes show	

		public MouseAdapter newMouseListenerShow(String dNI) {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("show");

					VistaCientificoShow frameShow = new VistaCientificoShow();												
					ControllerCientificoShow controllerShow = new ControllerCientificoShow(dNI, frameShow);
					controllerShow.iniciarVista();
				}
			};

			return mouse;
		}
		
		//listener para los botónes eliminar,	

		public MouseAdapter newMouseListenerDelete(Cientifico cientifico) {
			MouseAdapter mouse = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("delete");
					
					cientificoDAO.delete(cientifico);
					JOptionPane.showMessageDialog(vistaIndex, "Cientifico ha sido eliminado");
					
					vistaIndex.dispose();
					
					VistaCientificoIndex frameIndex = new VistaCientificoIndex();
					ControllerCientificoIndex controllerIndex = new ControllerCientificoIndex(frameIndex);
					controllerIndex.iniciarVista();
				}
			};

			return mouse;
		}
}
