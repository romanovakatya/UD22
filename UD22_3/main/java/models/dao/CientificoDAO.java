package models.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Conexion;
import models.DataBase;
import models.dto.Cientifico;

public class CientificoDAO extends Conexion {

	// atributos,
	protected Connection conexion;
	protected String db = "UD22";
	protected String tableName = "cientificos";
	protected DataBase dataBase;

	// métodos de CRUD
	// Read - show todos los datos,
	public List<Cientifico> index() {

		List<Cientifico> cientificos = new ArrayList<Cientifico>();

		String QuerySelect = "SELECT * FROM " + this.tableName;

		this.conexion = getConexion();

		try {
			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			java.sql.ResultSet resultado;
			resultado = statement.executeQuery(QuerySelect);

			while (resultado.next()) {

				System.out.println(resultado.getString("DNI") + " " + resultado.getString("nomApells"));

				// crear un objeto de tipo cliente para cada registro de BBDD,
				Cientifico cientifico = new Cientifico(resultado.getString("DNI"), resultado.getString("nomApells"));

				// añadir objetos recien creados a un arrayList,
				cientificos.add(cientifico);
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en el SELECT de todos los datos");
		}

		cerrarConexion();
		return cientificos;
	}

	// Create - añadir un elemento nuevo a la base de datos,
	public Cientifico create(Cientifico cientificoNuevo) {

		this.conexion = getConexion();

		try {

			String QueryInsertData = "INSERT INTO " + this.tableName + " " + "VALUES ('" + cientificoNuevo.getdNI()
					+ "', '" + cientificoNuevo.getNomApells() + "'); ";

			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(QueryInsertData);

			System.out.println("Datos almacenados correctamente en tabla " + this.tableName);

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en el almacenamiento");
		}

		cerrarConexion();
		return cientificoNuevo;
	}

	// Update
	// select por id para leer datos de un cliente READ,

	public Cientifico show(String dNI) {

		Cientifico findCientifico = new Cientifico();
		String QuerySelect = "SELECT * FROM " + this.tableName + " WHERE DNI = '" + dNI + "';";

		this.conexion = getConexion();

		try {
			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			java.sql.ResultSet resultado;
			resultado = statement.executeQuery(QuerySelect);

			while (resultado.next()) {

				System.out.println(resultado.getString("DNI") + " " + resultado.getString("nomApells"));

				findCientifico = new Cientifico(resultado.getString("DNI"), resultado.getString("nomApells"));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en el SELECT de datos de un registro de table " + this.tableName);
		}

		cerrarConexion();
		return findCientifico;
	}

	// Actualiza datos del cientifico indicado,

	public Cientifico update(String dNI, Cientifico newData) {

		Cientifico cientificoToUpdate = this.show(dNI);

		String QueryUpdate = "UPDATE " + this.tableName + " SET nomApells = '" + newData.getNomApells()
				+ "' WHERE DNI = '" + dNI + "';";

		this.conexion = getConexion();

		try {
			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(QueryUpdate);

			cientificoToUpdate = new Cientifico(dNI, newData.getNomApells());
			System.out.println(cientificoToUpdate.toString());

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en Update registro");
		}

		cerrarConexion();

		return cientificoToUpdate;
	}

	// Delete
	// para eliminar un registro,
	public void delete(Cientifico cientifico) {

		String QueryDeleteData = "DELETE FROM " + this.tableName + " WHERE DNI='" + cientifico.getdNI() + "';";

		this.conexion = getConexion();

		try {

			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(QueryDeleteData);

			System.out.println("Datos han sido eliminados correctamente de table" + this.tableName);

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en la eliminación de los datos de tabla " + this.tableName);
		}

		cerrarConexion();
	}
}
