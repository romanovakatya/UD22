package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.dao.CientificoDAO;
import models.dto.Cientifico;
import vistas.VistaCientificoCreate;
import vistas.VistaCientificoIndex;

public class ControllerCientificoCreate {

	// atributos,
	private Cientifico cientifico;
	private CientificoDAO cientificoDAO;
	private VistaCientificoCreate vistaCreate;

	// constructor,
	public ControllerCientificoCreate(VistaCientificoCreate vistaCreate) {

		this.cientifico = new Cientifico();
		this.cientificoDAO = new CientificoDAO();
		this.vistaCreate = vistaCreate;
	}

	// iniciamos la vista se creación de datos,
	public void iniciarVista() {
		this.vistaCreate.setTitle("Crear Cientifico");
		this.vistaCreate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.vistaCreate.setVisible(true);

		this.vistaCreate.btnCreate.addMouseListener(this.newMouseListener());
	}

	// listeners para botón crear,
	public MouseAdapter newMouseListener() {
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("create");

				if (!"".equals(vistaCreate.textFieldDni.getText())) {

					// controlamos el tamaño de DNI,
					if (vistaCreate.textFieldDni.getText().length() > 8) {
						cientifico.setdNI(vistaCreate.textFieldDni.getText().substring(0, 8));
					} else {
						cientifico.setdNI(vistaCreate.textFieldDni.getText());
					}

				} else {

					cientifico.setdNI("00000000");
				}

				if (!"".equals(vistaCreate.textFieldNomApels.getText())) {
					cientifico.setNomApells(vistaCreate.textFieldNomApels.getText());
				} else {
					cientifico.setNomApells("Un cientifico desconocido");
				}

				cientificoDAO.create(cientifico);

				vistaCreate.dispose();
				JOptionPane.showMessageDialog(vistaCreate, "Cientifico ha sido creado correctamente");

				// actualizamos vista principal,
				VistaCientificoIndex frameIndex = new VistaCientificoIndex();
				ControllerCientificoIndex controllerIndex = new ControllerCientificoIndex(frameIndex);
				controllerIndex.iniciarVista();
			}
		};

		return mouse;
	}
}
