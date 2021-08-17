package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Conexion {

	// atributos,
	protected Connection conexion;
	protected String db = "UD22";
	protected String tableName = "clientes";
	protected DataBase dataBase;

	// atributos de un cliente (corresponden a las columnas de tabla cliente),
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;

	// constructor por defecto,
	public Cliente() {
		super();

	}

	// constructor con todos los parametros,
	public Cliente(int id, String nombre, String apellido, String direccion, int dni, String fecha) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = fecha;
	}

	// constructor sin id,
	public Cliente(String nombre, String apellido, String direccion, int dni, String fecha) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = fecha;
	}

	// métodos de CRUD
	// Read - show todos los datos,
	public List<Cliente> index() {

		List<Cliente> clientes = new ArrayList<Cliente>();
		
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

				System.out.println(resultado.getString("id") + " " + resultado.getString("nombre") + " "
						+ resultado.getString("apellido") + " " + resultado.getString("direccion") + " "
						+ resultado.getString("dni") + " " + resultado.getString("fecha"));
				
				//crear un objeto de tipo cliente para cada registro de BBDD,
				Cliente cliente = new Cliente(Integer.parseInt(resultado.getString("id")),
						resultado.getString("nombre"), resultado.getString("apellido"),
						resultado.getString("direccion"), Integer.parseInt(resultado.getString("dni")),
						resultado.getString("fecha"));

				//añadir objetos recien creados a un arrayList,
				clientes.add(cliente);
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en el SELECT de todos los datos");
		}

		cerrarConexion();
		return clientes;
	}

	// Create - añadir un elemento nuevo a la base de datos,
	public Cliente create(Cliente clienteNuevo) {

		this.conexion = getConexion();

		try {
			
			String QueryInsertData = "INSERT INTO " + this.tableName + " (nombre, apellido, direccion, dni, fecha)"
				+ "VALUES ('" + clienteNuevo.getNombre() + "', '" + clienteNuevo.getApellido() + "', '" 
					+ clienteNuevo.getDireccion() + "', " + clienteNuevo.getDni() + ", '" + clienteNuevo.getFecha() + "'); ";

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
		return clienteNuevo;
	}

	// Update
	// select por id para leer datos de un cliente READ,

	public Cliente show(int id) {

		Cliente findCliente = new Cliente();
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

				System.out.println(resultado.getString("id") + " " + resultado.getString("nombre") + " "
						+ resultado.getString("apellido") + " " + resultado.getString("direccion") + " "
						+ resultado.getString("dni") + " " + resultado.getString("fecha"));

				findCliente = new Cliente(Integer.parseInt(resultado.getString("id")), resultado.getString("nombre"),
						resultado.getString("apellido"), resultado.getString("direccion"),
						Integer.parseInt(resultado.getString("dni")), resultado.getString("fecha"));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en el SELECT de datos de un registro de table " + this.tableName);
		}

		cerrarConexion();
		return findCliente;
	}
	
	// Actualiza datos del cliente indicado,
	
	public Cliente update(int id, Cliente newData) {
		
		Cliente clientToUpdate = this.show(id);

		
		String QueryUpdate = "UPDATE " + this.tableName 
				+ " SET nombre = '" + newData.getNombre()
				+ "', apellido= '" + newData.getApellido() 
				+ "', direccion= '" + newData.getDireccion()
				+ "', dni= " + newData.getDni()
				+ ", fecha= '" + newData.getFecha()
				+ "' WHERE id = " + id + ";";

		this.conexion = getConexion();
	
		try {
			String Querydb = "USE " + this.db + ";";
			Statement statementdb = this.conexion.createStatement();
			statementdb.executeUpdate(Querydb);

			Statement statement = this.conexion.createStatement();
			statement.executeUpdate(QueryUpdate);
			
			clientToUpdate = new Cliente(id, newData.getNombre(), newData.getApellido(), newData.getDireccion(), newData.getDni(), newData.getFecha());
			System.out.println(clientToUpdate.toString());

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error en Update registro");
		}

		cerrarConexion();
		
		return clientToUpdate;
	}
	

	// Delete
	// para eliminar un registro,
	public void delete(Cliente cliente) {

		String QueryDeleteData = "DELETE FROM " + this.tableName + " WHERE id=" + cliente.getId() + ";";

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
	
	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	//para mostrar todos los datos de un cliente,
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", dni=" + dni + ", fecha=" + fecha + "]";
	}
}
