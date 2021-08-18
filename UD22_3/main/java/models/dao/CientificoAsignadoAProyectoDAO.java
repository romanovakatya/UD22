package models.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Conexion;
import models.DataBase;
import models.dto.CientificoAsignadoAProyecto;


public class CientificoAsignadoAProyectoDAO extends Conexion{

	
	// atributos,
			protected Connection conexion;
			protected String db = "UD22";
			protected String tableName = "cientificos_asignado_a_proyectos";
			protected DataBase dataBase;
			
			// métodos de CRUD
			// Read - show todos los datos,
			public List<CientificoAsignadoAProyecto> index() {

				List<CientificoAsignadoAProyecto> asignaciones = new ArrayList<CientificoAsignadoAProyecto>();

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

						System.out.println(resultado.getString("DNICientifico") + " " + resultado.getString("idProyecto"));

						// crear un objeto de tipo cliente para cada registro de BBDD,
						CientificoAsignadoAProyecto asignacion = new CientificoAsignadoAProyecto(resultado.getString("DNICientifico"),
								resultado.getString("idProyecto"));

						// añadir objetos recien creados a un arrayList,
						asignaciones.add(asignacion);
					}

				} catch (SQLException ex) {

					System.out.println(ex.getMessage());
					System.out.println("Error en el SELECT de todos los datos");
				}

				cerrarConexion();
				return asignaciones;
			}
			
			// Create - añadir un elemento nuevo a la base de datos,
			public CientificoAsignadoAProyecto create(CientificoAsignadoAProyecto asignacionNueva) {

				this.conexion = getConexion();

				try {

					String QueryInsertData = "INSERT INTO " + this.tableName + " " + "VALUES ('" + asignacionNueva.getDNICientifico()
							+ "', '" + asignacionNueva.getIdProyecto() + "'); ";

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
				return asignacionNueva;
			}
			
			// Update
			// SELECT por id para leer datos de un proyecto READ,

			public CientificoAsignadoAProyecto show(String DNICientifico, String idProyecto) {

				CientificoAsignadoAProyecto findAsignacion = new CientificoAsignadoAProyecto();
				String QuerySelect = "SELECT * FROM " + this.tableName + " WHERE DNICientifico = '" + DNICientifico + "' AND idProyecto = '" + 
						idProyecto + "';";

				this.conexion = getConexion();

				try {
					String Querydb = "USE " + this.db + ";";
					Statement statementdb = this.conexion.createStatement();
					statementdb.executeUpdate(Querydb);

					Statement statement = this.conexion.createStatement();
					java.sql.ResultSet resultado;
					resultado = statement.executeQuery(QuerySelect);

					while (resultado.next()) {

						System.out.println(resultado.getString("DNICientifico") + " " + resultado.getString("idProyecto"));

						findAsignacion = new CientificoAsignadoAProyecto(resultado.getString("DNICientifico"),
								resultado.getString("idProyecto"));
					}

				} catch (SQLException ex) {

					System.out.println(ex.getMessage());
					System.out.println("Error en el SELECT de datos de un registro de table " + this.tableName);
				}

				cerrarConexion();
				return findAsignacion;
			}
			
			// Actualiza datos del proyecto indicado,

			public CientificoAsignadoAProyecto update(String DNICientifico, String idProyecto, CientificoAsignadoAProyecto newData) {

				CientificoAsignadoAProyecto asignacionToUpdate = this.show(DNICientifico, idProyecto);

				String QueryUpdate = "UPDATE " + this.tableName + " SET DNICientifico = '" + newData.getDNICientifico()
										+ "', idProyecto= '" + newData.getIdProyecto() 
										+ "' WHERE DNICientifico = '" + DNICientifico + "' AND idProyecto = '" + idProyecto + "';";

				this.conexion = getConexion();

				try {
					String Querydb = "USE " + this.db + ";";
					Statement statementdb = this.conexion.createStatement();
					statementdb.executeUpdate(Querydb);

					Statement statement = this.conexion.createStatement();
					statement.executeUpdate(QueryUpdate);

					asignacionToUpdate = new CientificoAsignadoAProyecto(newData.getDNICientifico(), newData.getIdProyecto());
					System.out.println(asignacionToUpdate.toString());

				} catch (SQLException ex) {

					System.out.println(ex.getMessage());
					System.out.println("Error en Update registro");
				}

				cerrarConexion();

				return asignacionToUpdate;
			}
			

			// Delete
			// para eliminar un registro,
			public void delete(CientificoAsignadoAProyecto asignacion) {

				String QueryDeleteData = "DELETE FROM " + this.tableName + " WHERE DNICientifico = '" + asignacion.getDNICientifico() 
				+ "' AND idProyecto = '" + asignacion.getIdProyecto() + "';";

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
