package models.dto;

public class Proyecto {

	
	//atributos,
	String id;
	String nombre;
	int horas;
	
	
	//constructores,
	//por defecto,
	public Proyecto() {
		super();
		
	}
	
	//con todos los atributos,
	public Proyecto(String id, String nombre, int horas) {
	
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}

	//getters y setters,
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	
	//toString,
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}

}
