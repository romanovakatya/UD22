package models.dto;

public class CientificoAsignadoAProyecto {

	// atributos,
	String DNICientifico;
	String idProyecto;

	// constructores,
	// por defecto,
	public CientificoAsignadoAProyecto() {
		super();

	}

	// con todos atributos
	public CientificoAsignadoAProyecto(String dNICientifico, String idProyecto) {
		
		DNICientifico = dNICientifico;
		this.idProyecto = idProyecto;
	}

	// los getters y setters,
	public String getDNICientifico() {
		return DNICientifico;
	}

	public void setDNICientifico(String dNICientifico) {
		DNICientifico = dNICientifico;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	// para mostrar datos
	@Override
	public String toString() {
		return "CientificoAsignadoAProyecto [DNICientifico=" + DNICientifico + ", idProyecto=" + idProyecto + "]";
	}

}
