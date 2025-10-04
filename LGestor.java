package Biblioteca;

public class LGestor {
	
	public static DBPersistencia DB = new DBPersistencia();

	public static void main(String[] args) {
		WLogin ventana = new WLogin();
		ventana.setVisible(true);
		//WPrime VentanaPrime = new WPrime();
		//VentanaPrime.setVisible(true);
	}
	
	public static void MostrarVentana() {
		WPrime VentanaPrime = new WPrime();
		VentanaPrime.setVisible(true);
	}
	
	public Boolean SubirLibro(String isbn, String titulo, String autor, String genero, String materia, int cantidad, String pais, String estado, String observacion) {
		
		Boolean res;
		
		if (isbn.equals(null) || titulo.equals(null) || autor.equals(null) || genero.equals(null) || materia.equals(null) || cantidad <= 0 || pais.equals(null)) {
			res = false;
		} else {
			res = DB.subirLibro(isbn, titulo, autor, genero, materia, cantidad, pais, estado, observacion);
		}
		
		return res;
	}
	
	public Boolean SubirComputadora(int numero, String estado, String observacion) {
		
		Boolean res;
		
		if (numero <= 0 || estado.equals(null) || estado.equals(null)) {
			res = false;
		} else {
			res = DB.subirComputadora(numero, estado, observacion);
		}
		
		return res;
	}

}