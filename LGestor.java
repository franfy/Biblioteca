package Biblioteca;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.beans.BeanDescriptor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LGestor {
	
	public static DBPersistencia DB = new DBPersistencia();

	
	/*
	 * FUNCION: main
	 * INPUT: String[] args
	 * OUTPUT:
	 * 
	 * Metodo existente previamente en java que permite indicar el inicio de un programa.
	 * 
	 */
	public static void main(String[] args) {
		WLogin ventana = new WLogin();
		ventana.setVisible(true);
	}
	
	
	
	/*
	 * FUNCION: MostrarVentana
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Metodo encargado de solo mostrar al usuario la interfaz principal del programa luego de iniciar sesion
	 * 
	 */
	public static void MostrarVentana() {
		WMenuPrincipal VentanaPrime = new WMenuPrincipal();
		VentanaPrime.setVisible(true);
	}
	
	
	
	/*
	 * FUNCION: SubirLibro
	 * INPUT:
	 * OUTPUT:
	 * 
	 * 
	 */
	public Boolean SubirLibro(String isbn, String titulo, String autor, String genero, String materia, int cantidad, String pais, String observacion) {
		
		Boolean res;
		
		if (isbn.equals(null) || titulo.equals(null) || autor.equals(null) || genero.equals(null) || materia.equals(null) || cantidad <= 0 || pais.equals(null)) {
			res = false;
		} else {
			res = DB.subirLibro(isbn, titulo, autor, genero, materia, cantidad, pais, observacion);
		}
		
		return res;
	}
	
	public Boolean SubirComputadora(int numero, String observacion) {
		
		Boolean res;
		
		if (numero <= 0) {
			res = false;
		} else {
			res = DB.subirComputadora(numero, observacion);
		}
		
		return res;
	}
	
	public Boolean SubirImpresion(int monto, int cantidad) {
		
		Boolean res;
		
		if (monto <=0 || cantidad <=0) {
			res = false;
		} else {
			res = DB.subirImpresion(monto, cantidad);
		}
		
		return res;
		
	}
	
	public Boolean SubirPrestamoLibro(String isbn, String estudiante, String grupo, String devolucion) {
		
		Boolean res = false;
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String entrega = fechaActual.format(formatoFecha);
		
		if (isbn.equals(null) || estudiante.equals(null) || grupo.equals(null) || devolucion.equals(null)) {
			res = false;
		} else {
			res = DB.subirPrestamoLibro(isbn, estudiante, grupo, entrega, devolucion);
		}
		
		return res;
	
	}
	
	public Boolean SubirPrestamoComputadora(int numero, String estudiante, String grupo, String devolucion) {
		
		Boolean res = false;
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String entrega = fechaActual.format(formatoFecha);
		
		if (numero <= 0 || estudiante.equals(null) || grupo.equals(null) || devolucion.equals(null)) {
			res = false;
		} else {
			res = DB.subirPrestamoComputadora(numero, estudiante, grupo, entrega, devolucion);
		}
		
		return res;
	
	}
	
	public Boolean BajaLibro(String isbn) {
		
		Boolean res = DB.BajaLibro(isbn);
		
		return res;
		
	}
	
	public Boolean BajaComputadora(int numero) {
		
		Boolean res = DB.BajaComputadora(numero);
		
		return res;
		
	}
	
	public Boolean BajaImpresion(int id) {
		
		Boolean res = DB.BajaImpresion(id);
		
		return res;
		
	}
	
	public Boolean BajaPrestamoLibro(int id) {
		
		Boolean res = DB.BajaPrestamoLibro(id);
		
		return res;
		
	}
	
	public Boolean BajaPrestamoComputadora(int id) {
		
		Boolean res = DB.BajaPrestamoComputadora(id);
		
		return res;
		
	}
	
	public Boolean ListarLibro(DefaultTableModel modelo,ArrayList array) {
		
		Boolean res = DB.ListarLibro(modelo, array);
		
		return res;
	}
	
	public Boolean ListarComputadora(DefaultTableModel modelo, ArrayList array) {
		
		Boolean res = DB.ListarComputadora(modelo, array);
		
		return res;
	}
	
    public Boolean ListarImpresion(DefaultTableModel modelo, ArrayList array) {
		
		Boolean res = DB.ListarImpresion(modelo, array);
		
		return res;
	}
	
	public Boolean ListarPrestamoLibro(DefaultTableModel modelo,ArrayList array) {
		
		Boolean res = DB.ListarPrestamoLibro(modelo, array);
		
		return res;
	}
	
	public Boolean ListarPrestamoComputadora(DefaultTableModel modelo,ArrayList array) {
		
		Boolean res = DB.ListarPrestamoComputadora(modelo, array);
		
		return res;
	}

}