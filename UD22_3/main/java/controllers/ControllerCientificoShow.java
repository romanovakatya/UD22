package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import models.dao.CientificoDAO;
import models.dto.Cientifico;
import vistas.VistaCientificoIndex;
import vistas.VistaCientificoShow;
import vistas.VistaCientificoUpdate;

public class ControllerCientificoShow {

	// atributos,
	private Cientifico cientifico = new Cientifico();
	private CientificoDAO cientificoDAO;
	private VistaCientificoShow vistaShow;
	private String dNI;

	// constructor con modelo y vista para mostrar datos de un cientifico,
	public ControllerCientificoShow(String dNI, VistaCientificoShow vistaShow) {

		this.dNI = dNI;
		this.cientificoDAO = new CientificoDAO();
		this.vistaShow = vistaShow;
		this.cientifico = this.cientificoDAO.show(this.dNI);

	}

	// iniciamos la vista de un cientifico,
	public void iniciarVista() {
		this.vistaShow.setTitle("Show cientifico" + this.dNI);
		this.vistaShow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaShow.setVisible(true);

		this.vistaShow.textFieldDni.setText(this.cientifico.getdNI());
		this.vistaShow.textFieldNomApels.setText(this.cientifico.getNomApells());

		this.vistaShow.btnUpdate.addMouseListener(this.newMouseListener());
		this.vistaShow.btnClose.addMouseListener(this.cerrarVentana());

	}

	// listeners para botón actualizar,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("update");

				VistaCientificoUpdate frameUpdate = new VistaCientificoUpdate();
				ControllerCientificoUpdate controllerUpdate = new ControllerCientificoUpdate(dNI, frameUpdate);
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

				VistaCientificoIndex frameIndex = new VistaCientificoIndex();
				ControllerCientificoIndex controllerIndex = new ControllerCientificoIndex(frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}
}
