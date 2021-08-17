package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


import models.dao.CientificoDAO;
import models.dto.Cientifico;
import vistas.VistaCientificoShow;
import vistas.VistaCientificoUpdate;


public class ControllerCientificoUpdate {
	
	// atributos,
			private Cientifico cientifico = new Cientifico();
			private CientificoDAO cientificoDAO;
			private VistaCientificoUpdate vistaUpdate;
			private String dNI;

			
			// constructor con modelo y vista para actualizar datos de un cientifico,
			public ControllerCientificoUpdate(String dNI, VistaCientificoUpdate vistaUpdate) {

				this.dNI = dNI;
				this.cientificoDAO = new CientificoDAO();
				this.vistaUpdate = vistaUpdate;
				this.cientifico = this.cientificoDAO.show(this.dNI);

			}

			// iniciamos la vista de actualización de un cientifico,
			public void iniciarVista() {
				this.vistaUpdate.setTitle("Actualizar cientifico" + this.dNI);
				this.vistaUpdate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				this.vistaUpdate.setVisible(true);

				this.vistaUpdate.textFieldDni.setText(this.cientifico.getdNI());
				this.vistaUpdate.textFieldNomApels.setText(this.cientifico.getNomApells());

				this.vistaUpdate.btnUpdate.addMouseListener(this.newMouseListener());

			}
			
			// listeners para botón actualizar,
			public MouseAdapter newMouseListener() {
				MouseAdapter mouse = new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					

						if (!"".equals(vistaUpdate.textFieldNomApels.getText())) {
							cientifico.setNomApells(vistaUpdate.textFieldNomApels.getText());
						} else {
							cientifico.setNomApells("Un cientifico desconocido");
						}
						
						cientificoDAO.update(dNI, cientifico);
						
						//para actualizar datos de tabla inicial,
						VistaCientificoShow frameShow = new VistaCientificoShow();												
						ControllerCientificoShow controllerShow = new ControllerCientificoShow(dNI, frameShow);
						controllerShow.iniciarVista();

						vistaUpdate.dispose();

					}
				};

				return mouse;
			}
}
