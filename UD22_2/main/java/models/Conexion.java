package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	
	//atributos,
	private Connection connection = null;
	private String IP = "192.168.1.134:3306";
	private String user = "remote";
	private String password = "katia";
	
	//constructores,
	//por defecto,
	public Conexion() {		
		super();
	
	}

	//método para conectarse al servidor MySQL de bases de datos,
		public Connection getConexion() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.IP +"?"
						+ "userTimezone=true&serverTimezone=UTC", this.user, this.password);
				
				System.out.println("Server Connected");
				
			} catch (SQLException | ClassNotFoundException ex) {
				System.out.println("No se ha podido conectar con base de datos");
				System.out.println(ex);
			}
			
			return this.connection;
		}
		
		
		//método que acaba la conexión a MySQL,
		public void cerrarConexion() {
			try {
				
				this.connection.close();
				System.out.println("Se ha finalizado la conexión con el servidor");
				
			} catch (SQLException ex) {
				Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
			}	
		}
}
