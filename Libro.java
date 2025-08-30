package Biblioteca;

public class Libro {

	long ISBN;
	String titulo;
	String autor;
	String genero;
	String materia;
	
	public Libro(long iSBN, String titulo, String autor, String genero, String materia) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.materia = materia;
	}
	
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	
}
