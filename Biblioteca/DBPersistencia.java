package Biblioteca;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class DBPersistencia {

	//private final String DB_URL = "jdbc:mysql://170.249.219.114/program1_equipo4?useSSL=false";
	//private final String DB_USER = "program1_estudiantes";
	//private final String DB_PASS = "estudiantesarrayanes";

	private final String DB_URL = "jdbc:mysql://localhost/BibliotecaPanDeAzucar?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	
	public Boolean subirLibro(String isbn, String titulo, String autor, String genero, String materia, int cantidad, String pais, String observacion, String hora, String fecha) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Libros VALUES(" + isbn + ",'" + titulo + "','" + autor + "','" + genero + "','" + materia + "'," + cantidad + ",'" + pais + "','" + observacion + "','" + hora + "','" + fecha + "')";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento la subida del Libro");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean subirComputadora(int numero, String observacion, String hora, String fecha) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Computadoras VALUES("+ numero +",'"+ observacion +"','"+ hora +"','"+ fecha +"')";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento subir la Computadora");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean subirImpresion(int monto, int cantidad, String fecha, String hora) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Impresiones (cantidad, precio, fecha, hora) VALUES("+ monto +","+ cantidad +",'"+ fecha +"','"+ hora +"')";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento subir la Impresion");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean subirPrestamoLibro(String isbn, String estudiante, String apellido, String mail, String telefono, String grupo, String hora, String entrega, String devolucion) {
		
		String neoIsbn = "";
		String neoObservacion = "";
		var res = false;
		System.out.println(isbn);
		
		String sentencia = "SELECT isbn, observacion FROM Libros WHERE isbn = " + isbn;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			if(!rs.next()) {
				System.out.println("no existe");
			} else {
				
				neoIsbn = rs.getString(1);
				neoObservacion = rs.getString(2);
				
				sentencia = "INSERT INTO PrestamoLibro (isbn, nombre, apellido, grupo, hora, mail, telefono, observaciones, entrega, devolucion ) VALUES('"+neoIsbn+"','"+estudiante+"','"+apellido+"','"+grupo+"','"+hora+"','"+mail+"','"+telefono+"','"+neoObservacion+"','"+entrega+"','"+devolucion+"')";
				
				System.out.println(sentencia);
				
				PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia);
				declaracionSQL2.executeUpdate();

				res = true;
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento subir el Prestamo de un Libro");
			
		}
		
		return res;
	}
	
	
	
	public Boolean subirPrestamoComputadora(int numero, String estudiante, String apellido, String mail, String telefono, String grupo, String hora, String entrega, String devolucion) {
		
		int neoNumero = 0;
		String neoObservacion = "";
		var res = false;
		System.out.println(numero);
		
		String sentencia = "SELECT numero, observaciones FROM Computadoras WHERE numero = " + numero;
		//String sentencia = "SELECT isbn, observacion FROM Libros WHERE isbn = " + isbn;
		System.out.println(sentencia);
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			 
			if (!rs.next()) {
				System.out.println("no existe");
			} else {
				
				neoNumero = rs.getInt(1);
				neoObservacion = rs.getString(2);
				System.out.println(neoNumero);
				
				sentencia = "INSERT INTO PrestamoComputadora (nro, nombre, apellido, grupo, hora, mail, telefono, observaciones, entrega, devolucion ) VALUES("+ neoNumero +",'"+estudiante+"','"+apellido+"','"+grupo+"','"+hora+"','"+mail+"','"+telefono+"','"+neoObservacion+"','"+entrega+"','"+devolucion+"')";
				System.out.println(sentencia);
				
				PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia);
				declaracionSQL2.executeUpdate();
				
				res = true;
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento subir el Prestamo de una Computadora");
			
		}
		
		return res;
	}
	
	
	
	public Boolean BajaLibro(String isbn) {
		var res = false;
		
		String sentencia = "DELETE FROM Libros WHERE isbn = " + isbn;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los Libros");
			
		}
		
		return res;
	}
	
	
	
	public Boolean BajaComputadora(int numero) {
		
		var res = false;
		
		String sentencia = "DELETE FROM Computadoras WHERE numero = " + numero;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los Libros");
			
		}
		
		return res;
	}
	
	
	
	public Boolean BajaImpresion(int id) {
		
		var res = false;
		
		String sentencia = "DELETE FROM Impresiones WHERE id = " + id;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar las impresiones");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean BajaPrestamoLibro(int id) {
		
		var res = false;
		
		String sentencia = "DELETE FROM PrestamoLibro WHERE id = " + id;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los prestamos de libros");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean BajaPrestamoComputadora(int id) {
		
		var res = false;
		
		String sentencia = "DELETE FROM PrestamoComputadora WHERE id = " + id;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los prestamos de libros");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean ListarLibro(DefaultTableModel modelo, ArrayList array) {
		
		var res = false;
		
		String sentencia = "SELECT isbn, titulo, autor, genero, materia, pais, cantidad, observacion, hora, fecha FROM Libros";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoISBN = rs.getString(1);
				var neoTitulo = rs.getString(2);
				var neoAutor = rs.getString(3);
				var neoGenero = rs.getString(4);
				var neoMateria = rs.getString(5);
				var neoPais = rs.getString(6);
				var neoCantidad = rs.getInt(7);
				var neoObservacion = rs.getString(8);
				var neoHora = rs.getString(9);
				var neoFecha = rs.getString(10);
				
				Object[] fila = {neoISBN, neoTitulo, neoAutor, neoGenero, neoMateria, neoPais, neoCantidad, neoObservacion, neoHora, neoFecha};
				modelo.addRow(fila);
			}
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los Libros");
			
		}
		
		return res;
	}
	
	
	
	public Boolean ListarComputadora(DefaultTableModel modelo, ArrayList array) {
		
		var res = false;
		
		String sentencia = "SELECT numero, observaciones, hora, fecha FROM Computadoras";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoNumero = rs.getInt(1);
				var neoEstado = rs.getString(2);
				var neoHora = rs.getString(3);
				var neoFecha = rs.getString(4);
				
				Object[] fila = {neoNumero, neoEstado, neoHora, neoFecha};
				modelo.addRow(fila);
			}
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar las Computadoras");
			
		}
		
		return res;
	}
	
	
	
	public Boolean ListarImpresion(DefaultTableModel modelo, ArrayList array) {
		
		var res = false;
		
		String sentencia = "SELECT id, cantidad, precio, hora, fecha FROM Impresiones";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoID = rs.getString(1);
				var neoCantidad = rs.getInt(2);
				var neoPrecio = rs.getInt(3);
				var neoHora = rs.getString(4);
				var neoFecha = rs.getString(5);
				
				Object[] fila = {neoID, neoCantidad, neoPrecio, neoHora, neoFecha};
				modelo.addRow(fila);
			}
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar las Impresiones");
			
		}
		
		return res;
		
	}
	
	
	
	public Boolean ListarPrestamoLibro(DefaultTableModel modelo, ArrayList array) {
		
		var res = false;
		
		String sentencia = "SELECT id, isbn, nombre, apellido, grupo, mail, telefono, observaciones, hora, entrega, devolucion FROM PrestamoLibro";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoID = rs.getInt(1);
				var neoIsbn = rs.getString(2);
				var neoNombre = rs.getString(3);
				var neoApellido = rs.getString(4);
				var neoGrupo = rs.getString(5);
				var neoHora = rs.getString(6);
				var neoMail = rs.getString(7);
				var neoTelefono = rs.getString(8);
				var neoObservacion = rs.getString(9);
				var neoEntrega = rs.getString(10);
				var neoDevolucion = rs.getString(11);
				
				Object[] fila = {neoID, neoIsbn, neoNombre, neoApellido, neoGrupo, neoHora, neoMail, neoTelefono, neoObservacion, neoEntrega, neoDevolucion};
				modelo.addRow(fila);
			}
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los Prestamos de los Libros");
			
		}
		
		return res;
	}
	
	
	
	public Boolean ListarPrestamoComputadora(DefaultTableModel modelo, ArrayList array) {
		
		var res = false;
		String sentencia = "SELECT id, nro, nombre, apellido, grupo, hora, mail, telefono, observaciones, entrega, devolucion FROM PrestamoComputadora";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoId = rs.getInt(1);
				var neoNro = rs.getInt(2);
				var neoNombre = rs.getString(3);
				var neoApellido = rs.getString(4);
				var neoGrupo = rs.getString(5);
				var neoHora = rs.getString(6);
				var neoMail = rs.getString(7);
				var neoTelefono = rs.getString(8);
				var neoObservacion = rs.getString(9);
				var neoEntrega = rs.getString(10);
				var neoDevolucion = rs.getString(11);
				
				Object[] fila = {neoId, neoNro, neoNombre, neoApellido, neoGrupo, neoMail, neoTelefono, neoObservacion, neoHora, neoEntrega, neoDevolucion};
				modelo.addRow(fila);
			}
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los Prestamos de las Computadoras");
			
		}
		
		return res;
	}
	
	
	
	public Boolean ComprobarExistenciaISBN(String isbn) {
		
		Boolean res = false;
		
		String sentencia = "SELECT isbn FROM Libros WHERE isbn = '" + isbn + "'";
		
		System.out.println(sentencia);
		
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				isbn = rs.getString(1);
			}
			
			res = true;
			System.out.println(res);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento listar los Libros");
			
		}
		
		return res;
	}
		
}