package models.dto;

public class Cientifico {
	
	//atributos,
	String DNI;
	String nomApells;
	
	
	//constructores,
	//por defecto,
	public Cientifico() {
		super();
		
	}

	//con todos atributos que tiene un cientifico,
	public Cientifico(String dNI, String nomApells) {
		super();
		this.DNI = dNI;
		this.nomApells = nomApells;
	}

	
	//los getters y setters,
	public String getdNI() {
		return DNI;
	}

	public void setdNI(String dNI) {
		this.DNI = dNI;
	}

	public String getNomApells() {
		return nomApells;
	}

	public void setNomApells(String nomApells) {
		this.nomApells = nomApells;
	}

	//para mostrar datos de un cientifico,
	@Override
	public String toString() {
		return "Cientifico [dNI=" + DNI + ", nomApells=" + nomApells + "]";
	}
	
}
