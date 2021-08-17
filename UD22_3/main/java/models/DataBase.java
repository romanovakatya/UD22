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


	public String QueryCreateTableCientificos = "CREATE TABLE cientificos (\r\n" + "DNI varchar(8) UNIQUE,\r\n"
			+ "nomApells varchar(255) DEFAULT NULL,\r\n"
			+ "primary key (DNI)" + ");";

	public String QueryInsertDataCientificos = "INSERT INTO cientificos "
			+ "VALUES ('10928374', 'Pepe Rocio'), "
			+ "('98236547', 'Laura Bennet'), "
			+ "('25871369', 'Felipe Josep'), "
			+ "('33526784', 'Maria Rubenz'), "
			+ "('59357482', 'Frank Bolla'), "
			+ "('63198725', 'Enrique Iglesias'); ";
	
	public String QueryCreateTableProyectos = "CREATE TABLE proyectos (\r\n" 
			+ "id char(4) UNIQUE,\r\n"
			+ "nombre varchar(255) DEFAULT NULL,\r\n" 
			+ "horas int DEFAULT NULL,\r\n"
			+ "primary key (id)\r\n"
			+ ");";
	
	public String QueryInsertDataProyectos = "INSERT INTO proyectos "
			+ "VALUES ('AD34', 'Proyecto 1', 233), "
			+ "('39DD', 'Proyecto 3', 60), "
			+ "('TeQW', 'Proyecto 8', 45), "
			+ "('Jo11', 'Proyecto 2', 90), "
			+ "('1524', 'Proyecto 6', 1200), "
			+ "('PQYU', 'Proyecto 11', 5); ";
	
	public String QueryCreateTableAsignar ="CREATE TABLE cientificos_asignado_a_proyectos(\r\n"
			+ "DNICientifico varchar(8),\r\n"
			+ "idProyecto char(4),\r\n"
			+ "KEY (DNICientifico, idProyecto),\r\n"
			+ "FOREIGN KEY (DNICientifico) \r\n"
			+ "references cientificos(DNI)\r\n"
			+ "on delete cascade\r\n"
			+ "on update cascade,\r\n"
			+ "FOREIGN KEY (idProyecto) \r\n"
			+ "references proyectos(id)\r\n"
			+ "on delete cascade\r\n"
			+ "on update cascade,\r\n"
			+ "PRIMARY KEY (DNICientifico, idProyecto)\r\n"
			+ ");";
	
	public String QueryInsertDataAsignar = "INSERT INTO cientificos_asignado_a_proyectos "
			+ "VALUES ('10928374', 'AD34'), "
			+ "('98236547', '39DD'), "
			+ "('25871369', 'TeQW'), "
			+ "('59357482', 'Jo11'), "
			+ "('63198725', '1524'), "
			+ "('33526784', 'PQYU'); ";
	
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
		
			System.out.println(ex.getMessage());
			System.out.println("Error en el almacenamiento");
		}
		
		cerrarConexion();
	}

}
