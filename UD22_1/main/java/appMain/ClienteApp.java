package appMain;

import java.awt.EventQueue;

import controllers.ControllerIndex;
import models.Cliente;
import vistas.VistaIndex;


public class ClienteApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					//llamamos la vista principal con datos de todos clientes,
					Cliente cliente = new Cliente();
					VistaIndex frameIndex = new VistaIndex();
					ControllerIndex controllerIndex = new ControllerIndex(cliente, frameIndex);
					controllerIndex.iniciarVista();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
