package Biblioteca;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class DBPersistencia {

	private final String DB_URL = "jdbc:mysql://23.111.185.242/program1_equipo4?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	
	public Boolean subirLibro(int isbn, String titulo, String autor, String genero, String materia, int cantidad, String pais, String observacion) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Libros VALUES(" + isbn + ",'" + titulo + "','" + autor + "','" + genero + "','" + materia + "'," + cantidad + ",'" + pais + "','" + observacion + "')";
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
	
	
	
	public Boolean subirComputadora(int numero, String observacion) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Computadoras VALUES("+ numero +",'"+ observacion +"')";
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
	
	
	
	public Boolean subirImpresion(int monto, int cantidad) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Impresiones (cantidad, precio) VALUES("+ monto +","+ cantidad +")";
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
	
	
	
	public Boolean subirPrestamoLibro(String isbn, String estudiante, String grupo, String entrega, String devolucion) {
		
		String neoIsbn = "";
		String neoObservacion = "";
		var res = false;
		
		String sentencia = "SELECT isbn, observacion FROM Libros WHERE " + isbn;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				neoIsbn = rs.getString(1);
				neoObservacion = rs.getString(2);
				
			}
			
			sentencia = "INSERT INTO PrestamoLibro (isbn, observaciones, nombre, grupo, entrega, devolucion ) VALUES('"+neoIsbn+"','"+neoObservacion+"','"+estudiante+"','"+grupo+"','"+entrega+"','"+devolucion+"')";
			
			System.out.println(sentencia);
			
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia);
			declaracionSQL2.executeUpdate();
			
			res = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento subir el Prestamo de un Libro");
			
		}
		
		return res;
	}
	
	
	
	public Boolean subirPrestamoComputadora(int numero, String estudiante, String grupo, String entrega, String devolucion) {
		
		int neoNumero = 0;
		String neoObservacion = "";
		var res = false;
		
		String sentencia = "SELECT numero, observaciones FROM Computadoras WHERE " + numero;
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				neoNumero = rs.getInt(1);
				neoObservacion = rs.getString(2);
			}
			
			sentencia = "INSERT INTO PrestamoComputadora (nro, observaciones, nombre, grupo, entrega, devolucion ) VALUES("+ neoNumero +",'"+ neoObservacion +"','"+ estudiante +"','"+ grupo +"','"+ entrega +"','"+ devolucion +"')";
			
			System.out.println(sentencia);
			
			PreparedStatement declaracionSQL2 = conexion.prepareStatement(sentencia);
			declaracionSQL2.executeUpdate();
			
			res = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			res = false;
			
		} finally {
			System.out.println("Se hizo o intento subir el Prestamo de una Computadora");
			
		}
		
		return res;
	}
	
	
	
	public Boolean BajaLibro(int isbn) {
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
	
	
	
	public Boolean BajaComputadora() {
		var res = false;
		
		String sentencia = "";
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
	
	
	
	public Boolean ListarLibro(DefaultTableModel modelo, ArrayList array) {
		
		var res = false;
		
		String sentencia = "SELECT isbn, titulo, autor, genero, materia, pais, cantidad, observacion FROM Libros";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoISBN = rs.getInt(1);
				var neoTitulo = rs.getString(2);
				var neoAutor = rs.getString(3);
				var neoGenero = rs.getString(4);
				var neoMateria = rs.getString(5);
				var neoPais = rs.getString(6);
				var neoCantidad = rs.getInt(7);
				var neoObservacion = rs.getString(8);
				
				Object[] fila = {neoISBN, neoTitulo, neoAutor, neoGenero, neoMateria, neoPais, neoCantidad, neoObservacion};
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
		
		String sentencia = "SELECT numero, observaciones FROM Computadoras";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoNumero = rs.getInt(1);
				var neoEstado = rs.getString(2);
				
				Object[] fila = {neoNumero, neoEstado};
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
		
		String sentencia = "SELECT cantidad, precio FROM Impresiones";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoCantidad = rs.getInt(1);
				var neoPrecio = rs.getString(2);
				
				Object[] fila = {neoCantidad, neoPrecio};
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
		
		String sentencia = "SELECT id, isbn, observaciones, nombre, grupo, entrega, devolucion FROM PrestamoLibro";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoID = rs.getInt(1);
				var neoIsbn = rs.getString(2);
				var neoObservacion = rs.getString(3);
				var neoNombre = rs.getString(4);
				var neoGrupo = rs.getString(5);
				var neoEntrega = rs.getString(6);
				var neoDevolucion = rs.getString(7);
				
				Object[] fila = {neoID, neoIsbn, neoObservacion, neoNombre, neoGrupo, neoEntrega, neoDevolucion};
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
		String sentencia = "SELECT id, nro, observaciones, nombre, grupo, entrega, devolucion FROM PrestamoComputadora";
		System.out.println(sentencia);
		try {
			
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			
			while(rs.next()) {
				var neoId = rs.getInt(1);
				var neoNro = rs.getInt(2);
				var neoObservaciones = rs.getString(3);
				var neoNombre = rs.getString(4);
				var neoGrupo = rs.getString(5);
				var neoEntrega = rs.getString(6);
				var neoDevolucion = rs.getString(7);
				
				Object[] fila = {neoId, neoNro, neoObservaciones, neoNombre, neoGrupo, neoEntrega, neoDevolucion};
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

	
}