package appMain;

import java.awt.EventQueue;

import controllers.ControllerMain;
import models.DataBase;
import vistas.VistaMain;

public class App 
{
    public static void main( String[] args )
    {
    	
  	 /* DataBase db = new DataBase("UD22");
     	db.crearTabla("cientificos", db.QueryCreateTableCientificos);
    	
    	db.insertData("cientificos", db.QueryInsertDataCientificos);
    	
    	db.crearTabla("proyectos", db.QueryCreateTableProyectos);
    	
    	db.insertData("proyectos", db.QueryInsertDataProyectos);
    	
    	db.crearTabla("cientificos_asignado_a_proyectos", db.QueryCreateTableAsignar);
    	
    	db.insertData("cientificos_asignado_a_proyectos", db.QueryInsertDataAsignar);*/
    	
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
