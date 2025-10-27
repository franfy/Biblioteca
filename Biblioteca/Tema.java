package Biblioteca;

import java.awt.Color;

public class Tema {

	private Color fondo;
	private Color botones;
	private Color letras;
	private Color seleccionado;
	
	public Tema(Color fondo, Color botones, Color letras, Color seleccionado) {
		super();
		this.fondo = fondo;
		this.botones = botones;
		this.letras = letras;
		this.seleccionado = seleccionado;
	}

	public Color getFondo() {
		return fondo;
	}

	public void setFondo(Color fondo) {
		this.fondo = fondo;
	}

	public Color getBotones() {
		return botones;
	}

	public void setBotones(Color botones) {
		this.botones = botones;
	}

	public Color getLetras() {
		return letras;
	}

	public void setLetras(Color letras) {
		this.letras = letras;
	}

	public Color getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Color seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	
	
}
