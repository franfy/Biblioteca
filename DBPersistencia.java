package Biblioteca;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class DBPersistencia {

	private final String DB_URL = "jdbc:mysql://23.111.185.242/program1_equipo4?useSSL=false";
	private final String DB_USER = "program1_estudiantes";
	private final String DB_PASS = "estudiantesarrayanes";
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	
	public Boolean subirLibro(String isbn, String titulo, String autor, String genero, String materia, int cantidad, String pais, String estado, String observacion) {
		
		var res = false;
		
		String sentencia = "INSERT INTO Libros VALUES('" + isbn + "','" + titulo + "','" + autor + "','" +  genero + "','" + materia + "'," + cantidad + ",'" + pais + "','" + estado + "','" + observacion + "')";
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
			System.out.println("Se hizo o intento el proceso");
			
		}
		
		return res;
		
	}
	
	public Boolean subirComputadora(int numero, String estado, String observacion) {
		
		var res = false;
		
		String sentencia = "INSERT INTO computadoras VALUES("+ numero+",'"+ estado +"','" + observacion+ "')";
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
			System.out.println("Se hizo o intento el proceso");
			
		}
		
		return res;
		
	}
}