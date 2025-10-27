package Biblioteca;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
	 * INPUT: String isbn, String titulo, String autor, String materia, int cantidad, String pais, String observacion
	 * OUTPUT: Boolean res
	 * 
	 * Metodo encargado de verificar que los datos que se vayan a subir no sean nulos y llama a la base de datos
	 * 
	 */
	public Boolean SubirLibro(String isbn, String titulo, String autor, String genero, String materia, String cantidad, String pais, String observacion) {
		
		Boolean res;
		String fecha = TomarFecha();
		String hora = TomarHora();
		
		try {
			
			int neoCantidad = Integer.parseInt(cantidad);
			
			if (isbn.equals("") || titulo.equals("") || autor.equals("") || genero.equals("") || materia.equals("") || neoCantidad <= 0 || pais.equals("")) {
				res = false;
			} else {
				if (observacion.equals("Opcional")) {
					observacion = "¡No hay observaciones!";
				}
				res = DB.subirLibro(isbn, titulo, autor, genero, materia, neoCantidad, pais, observacion, hora, fecha);
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			System.out.println("Algo salio mal");
		}
		
		return res;
	}
	
	public Boolean SubirComputadora(String numero, String observacion) {
		
		Boolean res;
		String fecha = TomarFecha();
		String hora = TomarHora();
		
		try	{
			
			int neoNumero = Integer.parseInt(numero);
			
			if (neoNumero <= 0) {
				res = false;
			} else {
				if (observacion.equals("Opcional")) {
					observacion = "¡No hay observaciones!";
				}
				res = DB.subirComputadora(neoNumero, observacion, hora, fecha);
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			System.out.println("Algo salio mal");
		}
		
		return res;
	}
	
	public Boolean SubirImpresion(String monto, String cantidad) {
		
		Boolean res;
		String fecha = TomarFecha();
		String hora = TomarHora();
		
		try {
			
			int neoMonto = Integer.parseInt(monto);
			int neoCantidad = Integer.parseInt(cantidad);
			
			if (neoMonto <=0 || neoCantidad <=0) {
				res = false;
			} else {
				res = DB.subirImpresion(neoMonto, neoCantidad, fecha, hora);
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			System.out.println("Algo salio mal");
		}
		
		return res;
		
	}
	
	public Boolean SubirPrestamoLibro(String isbn, String estudiante, String apellido, String mail, String telefono, String grupo, String devolucion) {
		
		Boolean res = false;
		String entrega = TomarFecha();
		String hora = TomarHora();
		
		if (isbn.equals(null) || estudiante.equals(null) || grupo.equals(null) || devolucion.equals(null)) {
			res = false;
		} else {
			if (apellido.equals("Opcional")) {
				apellido = "No se especificó un apellido";
			}
			
			if (mail.equals("Opcional")) {
				mail = "No se especificó un correo";
			}
			
			if (telefono.equals("Opcional")) {
				telefono = "No se especificó un número de teléfono";
			}
			
			res = DB.subirPrestamoLibro(isbn, estudiante, apellido, mail, telefono, grupo, hora, entrega, devolucion);
		}
		
		return res;
	
	}
	
	public Boolean SubirPrestamoComputadora(String numero, String estudiante, String apellido, String mail, String telefono, String grupo, String devolucion) {
		
		Boolean res = false;
		String entrega = TomarFecha();
		String hora = TomarHora();
		
		try {
			
			int neoNumero = Integer.parseInt(numero);
			
			if (neoNumero <= 0 || estudiante.equals("") || grupo.equals("") || devolucion.equals("")) {
				res = false;
			} else {
				if (apellido.equals("Opcional")) {
					apellido = "No se especificó un apellido";
				}
				
				if (mail.equals("Opcional")) {
					mail = "No se especificó un correo";
				}
				
				if (telefono.equals("Opcional")) {
					telefono = "No se especificó un número de teléfono";
				}
				
				res = DB.subirPrestamoComputadora(neoNumero, estudiante, apellido, mail, telefono, grupo, hora, entrega, devolucion);
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			System.out.println("Algo salio mal");
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
    
    public Boolean ListarFiltrarImpresion(DefaultTableModel modelo, ArrayList array, String fecha) {
    	
    	Boolean res = false;
    	
    	if (fecha.charAt(2) == '/' && fecha.charAt(5) == '/') {
    		String parte = fecha.substring(3,5);
    		System.out.println(parte);
    		
    	}
    	
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
	
	public int SumaMontoImpresion(JTable tabla, int filas) {
		
		int res = 0;
		int suma = 0;
		String valorString;
		
		for (int i = 0; i < filas; i++) {
		    Object valor = tabla.getValueAt(i, 1);
		    System.out.println("Fila " + i + ": " + valor);
		    valorString = String.valueOf(valor);
		    suma = Integer.parseInt(valorString);
		    res = res + suma;
		    System.out.println("Res: " + res + " Suma: " + suma);
		}
		
		return res;
	}
	
	public String TomarFecha() {
				
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fechaActual.format(formatoFecha);
		
	}
	
	public String TomarHora() {
		
		LocalTime tiempo = LocalTime.now();
		int horas = tiempo.getHour();
		int minutos = tiempo.getMinute();
		int segundos = tiempo.getSecond();
		
		return String.format("%02d:%02d:%02d", segundos, minutos, horas);
		
	}
	
	
    public static void ManualPDF() {
    	try {
            // Obtener la ruta absoluta del proyecto
            String rutaProyecto = System.getProperty("user.dir");

            // Crear objeto File con la ruta completa al PDF
            File archivo = new File(rutaProyecto, "src/Otros/Manual de Usuario - Sistema de Gestión de Biblioteca.pdf");

            // Verificar si el archivo existe
            if (!archivo.exists()) {
                System.err.println("No se encontró el archivo: " + archivo.getAbsolutePath());
                return;
            }

            // Usar xdg-open para abrir el archivo con la aplicación predeterminada
            ProcessBuilder pb = new ProcessBuilder("xdg-open", archivo.getAbsolutePath());
            pb.start();

            System.out.println("Abriendo en el navegador o visor predeterminado: " + archivo.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error al intentar abrir el PDF: " + e.getMessage());
        }
    }
	
}