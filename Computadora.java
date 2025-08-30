package Biblioteca;

public class Computadora {

	int nroSerie;
	String modelo;

	public Computadora(int nroSerie, String modelo) {
		super();
		this.nroSerie = nroSerie;
		this.modelo = modelo;
	}

	public int getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
