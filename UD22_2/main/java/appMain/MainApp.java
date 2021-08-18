package appMain;

import java.awt.EventQueue;

import controllerMain.ControllerMain;
import models.DataBase;
import vistaMain.VistaMain;


public class MainApp {
	

	public static void main(String[] args) {
		
		//DataBase db = new DataBase("UD22");
		//db.crearTabla("clientes", db.QueryCreateTable);
		//db.insertData("clientes", db.QueryInsertData);
		//db.crearTabla("videos", db.QueryCreateTableVideo);
		//db.insertData("videos", db.QueryInsertDataVideo);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VistaMain frame = new VistaMain();
					ControllerMain controllerMain = new ControllerMain(frame);
					controllerMain.iniciarVista();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
