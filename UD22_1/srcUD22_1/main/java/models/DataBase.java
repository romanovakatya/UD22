package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase extends Conexion{

	// atributos,
	protected Connection conexion;
	protected String db;
	protected String tableName = "cliente";

	private String QueryCreateTable = "CREATE TABLE clientes (\r\n" + "id int(11) AUTO_INCREMENT NOT NULL,\r\n"
			+ "nombre varchar(250) DEFAULT NULL,\r\n" + "apellido varchar(250) DEFAULT NULL,\r\n"
			+ "direccion varchar(250) DEFAULT NULL,\r\n" + "dni int(11) DEFAULT NULL,\r\n"
			+ "fecha date DEFAULT NULL,\r\n" + "primary key (id)" + ");";

	private String QueryInsertData = "INSERT INTO clientes (nombre, apellido, direccion, dni, fecha)"
			+ "VALUES ('Pepe', 'Rocio', 'París', 109283745, '1987-02-22'), "
			+ "('Laura', 'Bennet', 'Madrid', 981236547, '2001-04-01'), "
			+ "('Felipe', 'Josep', 'London', 258741369, '1999-01-18'), "
			+ "('Maria', 'Rubenz', 'Barcelona', 335526784, '2019-12-31'), "
			+ "('Frank', 'Bolla', 'Reus', 159357482, '1965-06-09'), "
			+ "('Enrique', 'Iglesias', 'Tarragona', 653198725, '2010-09-26'); ";
	
	
	//constructor,
	 public DataBase(String nameDB) {
		 this.db = nameDB;
	 }
	 

	// método para crear una base de datos,
	protected void crearBD() {
		
		this.conexion = getConexion();

		try {

			String Query = "CREATE DATABASE IF NOT EXISTS " + this.db;
			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(Query);

			System.out.println("Se ha creado la base de datos " + this.db + " de forma exitosa");

		} catch (SQLException ex) {

			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		
			cerrarConexion();
	}

	// método para crear tabla en MySQL,
	public void crearTabla(String tableName, String Query) {
		
		this.conexion = getConexion();

		try {
			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			String Querydrop = "DROP TABLE IF EXISTS " + tableName + ";";
			Statement statementdrop = this.conexion.createStatement();
			statementdrop.executeUpdate(Querydrop);

			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(Query);

			System.out.println("Tabla " + tableName + " creada con éxito");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}
		
		cerrarConexion();
	}

	// método que inserta datos a una tabla,

	public void insertData(String tableName, String Query) {
		
		this.conexion = getConexion();

		try {

			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente en " + tableName);

		} catch (SQLException ex) {

			// Logger.getLogger(BDMySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex.getMessage());
			System.out.println("Error en el almacenamiento");
		}
		
		cerrarConexion();
	}

}
