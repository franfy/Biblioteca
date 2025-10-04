package Biblioteca;

public class Libro {

	int ISBN;
	String titulo;
	String autor;
	String genero;
	String materia;
	String pais;
	
	public Libro(int ISBN, String titulo, String autor, String genero, String materia, String pais) {
		super();
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.materia = materia;
		this.pais = pais;
	}

	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}