package models.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Conexion;
import models.DataBase;
import models.dto.Proyecto;

public class ProyectoDAO extends Conexion{

	
	// atributos,
		protected Connection conexion;
		protected String db = "UD22";
		protected String tableName = "proyectos";
		protected DataBase dataBase;
		
		// métodos de CRUD
		// Read - show todos los datos,
		public List<Proyecto> index() {

			List<Proyecto> proyectos = new ArrayList<Proyecto>();

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

					System.out.println(resultado.getString("id") + " " + resultado.getString("nombre") 
					+ " " + resultado.getString("horas"));

					// crear un objeto de tipo cliente para cada registro de BBDD,
					Proyecto proyecto = new Proyecto(resultado.getString("id"), resultado.getString("nombre"), 
							Integer.parseInt(resultado.getString("horas")));

					// añadir objetos recien creados a un arrayList,
					proyectos.add(proyecto);
				}

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				System.out.println("Error en el SELECT de todos los datos");
			}

			cerrarConexion();
			return proyectos;
		}
		
		// Create - añadir un elemento nuevo a la base de datos,
		public Proyecto create(Proyecto proyectoNuevo) {

			this.conexion = getConexion();

			try {

				String QueryInsertData = "INSERT INTO " + this.tableName + " " + "VALUES ('" + proyectoNuevo.getId()
						+ "', '" + proyectoNuevo.getNombre() + "', '" + proyectoNuevo.getHoras()+ "'); ";

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
			return proyectoNuevo;
		}
		
		// Update
		// SELECT por id para leer datos de un proyecto READ,

		public Proyecto show(String id) {

			Proyecto findProyecto = new Proyecto();
			String QuerySelect = "SELECT * FROM " + this.tableName + " WHERE id = '" + id + "';";

			this.conexion = getConexion();

			try {
				String Querydb = "USE " + this.db + ";";
				Statement statementdb = this.conexion.createStatement();
				statementdb.executeUpdate(Querydb);

				Statement statement = this.conexion.createStatement();
				java.sql.ResultSet resultado;
				resultado = statement.executeQuery(QuerySelect);

				while (resultado.next()) {

					System.out.println(resultado.getString("id") + " " + resultado.getString("nombre") 
					+ " " + resultado.getString("horas"));

					findProyecto = new Proyecto(resultado.getString("id"), resultado.getString("nombre"), 
							Integer.parseInt(resultado.getString("horas")));;
				}

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				System.out.println("Error en el SELECT de datos de un registro de table " + this.tableName);
			}

			cerrarConexion();
			return findProyecto;
		}
		
		// Actualiza datos del proyecto indicado,

		public Proyecto update(String id, Proyecto newData) {

			Proyecto proyectoToUpdate = this.show(id);

			String QueryUpdate = "UPDATE " + this.tableName + " SET nombre = '" + newData.getNombre()
									+ "', horas= '" + newData.getHoras() 
									+ "' WHERE id = '" + id + "';";

			this.conexion = getConexion();

			try {
				String Querydb = "USE " + this.db + ";";
				Statement statementdb = this.conexion.createStatement();
				statementdb.executeUpdate(Querydb);

				Statement statement = this.conexion.createStatement();
				statement.executeUpdate(QueryUpdate);

				proyectoToUpdate = new Proyecto(id, newData.getNombre(), newData.getHoras());
				System.out.println(proyectoToUpdate.toString());

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				System.out.println("Error en Update registro");
			}

			cerrarConexion();

			return proyectoToUpdate;
		}
		

		// Delete
		// para eliminar un registro,
		public void delete(Proyecto proyecto) {

			String QueryDeleteData = "DELETE FROM " + this.tableName + " WHERE id='" + proyecto.getId() + "';";

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
