package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Video extends Conexion{

	// atributos,
		protected Connection conexion;
		protected String db = "UD22";
		protected String tableName = "videos";
		protected DataBase dataBase;
		
		// atributos de un video (corresponden a las columnas de tabla cliente),
		private int id;
		private String title;
		private String director;
		private int cliente_id;
		
		
		// constructor por defecto,
		public Video() {
			super();
			
		}

		// constructor con todos los parametros,
		public Video(int id, String title, String director, int cliente_id) {
			super();
			this.id = id;
			this.title = title;
			this.director = director;
			this.cliente_id = cliente_id;
		}

		// constructor sin id,
		public Video(String title, String director, int cliente_id) {

			this.title = title;
			this.director = director;
			this.cliente_id = cliente_id;
		}
		
		
		// métodos de CRUD
		// Read - show todos los datos,
		public List<Video> index() {

			List<Video> videos = new ArrayList<Video>();
			
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

					System.out.println(resultado.getString("id") + " " + resultado.getString("title") + " "
							+ resultado.getString("director") + " " + resultado.getString("cliente_id"));
					
					//crear un objeto de tipo cliente para cada registro de BBDD,
					Video video = new Video(Integer.parseInt(resultado.getString("id")),
											resultado.getString("title"), resultado.getString("director"),
											Integer.parseInt(resultado.getString("cliente_id")));

					//añadir objetos recien creados a un arrayList,
					videos.add(video);
				}

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				System.out.println("Error en el SELECT de todos los datos");
			}

			cerrarConexion();
			return videos;
		}
		
		
		// Create - añadir un elemento nuevo a la base de datos,
		public Video create(Video videoNuevo) {

			this.conexion = getConexion();

			try {
				
				String QueryInsertData = "INSERT INTO " + this.tableName + " (title, director, cliente_id)"
					+ "VALUES ('" + videoNuevo.getTitle()+ "', '" + videoNuevo.getDirector() + "', '" 
					+ videoNuevo.getCliente_id() +  "'); ";

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
			return videoNuevo;
		}
		
		
		// Update
		// select por id para leer datos de un video READ,

		public Video show(int id) {

			Video findVideo = new Video();
			String QuerySelect = "SELECT * FROM " + this.tableName + " WHERE id = " + id + ";";

			this.conexion = getConexion();

			try {
				String Querydb = "USE " + this.db + ";";
				Statement statementdb = this.conexion.createStatement();
				statementdb.executeUpdate(Querydb);

				Statement statement = this.conexion.createStatement();
				java.sql.ResultSet resultado;
				resultado = statement.executeQuery(QuerySelect);

				while (resultado.next()) {

					System.out.println(resultado.getString("id") + " " + resultado.getString("title") + " "
							+ resultado.getString("director") + " " + resultado.getString("cliente_id"));

					
					findVideo = new Video(Integer.parseInt(resultado.getString("id")), resultado.getString("title"),
							resultado.getString("director"), Integer.parseInt(resultado.getString("cliente_id")));
				}

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				System.out.println("Error en el SELECT de datos de un registro de table " + this.tableName);
			}

			cerrarConexion();
			return findVideo;
		}

		
		// Actualiza datos del video indicado,
		
		public Video update(int id, Video newData) {
			
			Video videoToUpdate = this.show(id);

			
			String QueryUpdate = "UPDATE " + this.tableName 
					+ " SET title = '" + newData.getTitle()
					+ "', director= '" + newData.getDirector()
					+ "', cliente_id= " + newData.getCliente_id()
					+ " WHERE id = " + id + ";";

			this.conexion = getConexion();
		
			try {
				String Querydb = "USE " + this.db + ";";
				Statement statementdb = this.conexion.createStatement();
				statementdb.executeUpdate(Querydb);

				Statement statement = this.conexion.createStatement();
				statement.executeUpdate(QueryUpdate);
				
				videoToUpdate = new Video(id, newData.getTitle(), newData.getDirector(), newData.getCliente_id());
				System.out.println(videoToUpdate.toString());

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				System.out.println("Error en Update registro");
			}

			cerrarConexion();
			
			return videoToUpdate;
		}
		
		
		// Delete
		// para eliminar un registro,
		public void delete(Video video) {

			String QueryDeleteData = "DELETE FROM " + this.tableName + " WHERE id=" + video.getId() + ";";

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

		
		
		//los getters y setters,
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public int getCliente_id() {
			return cliente_id;
		}

		public void setCliente_id(int cliente_id) {
			this.cliente_id = cliente_id;
		}

		
		//para mostrar todos los datos de un video,
		@Override
		public String toString() {
			return "Video [id=" + id + ", title=" + title + ", director=" + director + ", cliente_id=" + cliente_id
					+ "]";
		}
		

		
		
}
