package Biblioteca;

public class PrestamoComputadora extends Computadora{

	String nombreEstudiante;
	String grupo;
	String entrega;
	String devolucion;
	
	public PrestamoComputadora(int nro, String estado, String nombreEstudiante, String grupo, String entrega, String devolucion) {
		super(nro, estado);
		this.entrega = entrega;
		this.devolucion = devolucion;
		this.nombreEstudiante = nombreEstudiante;
		this.grupo = grupo;
	}
	
	
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	public String getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}
	
	
}
