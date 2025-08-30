package Biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class WPrime2 extends JFrame{

	protected static JPanel PanelPadre = new JPanel(new BorderLayout());
	protected static JPanel PanelLocal = new JPanel(new GridBagLayout());
	protected static JPanel panelTabla = new JPanel(new BorderLayout());
	protected static LGestor logica = new LGestor();
	protected static Color[] coloresDireccion = {Color.white, Color.LIGHT_GRAY, Color.GRAY, Color.GREEN, Color.BLUE, Color.CYAN};
	protected static String[] coloresLetras = {"Blanco", "Gris Claro", "Gris", "Verde", "Azul", "Cyan"};
	protected static JComboBox temas = new JComboBox(coloresLetras);
	

	public WPrime2() {

		
		// Configuracion de la Ventana
		this.setTitle("Biblioteca Prototipo");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);

		
		// Se muestra la ventana
		PanelPadre.add(PanelLocal);
		this.add(PanelPadre);
		
		
		// Llamado a las funciones
		tab();
		systemInfo();

		

	}
		
	public static void tab() {
		
		
		//Imports
		JTabbedPane herramientas = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel menuRegistrar = new JPanel();
		JPanel menuBaja = new JPanel();
		JPanel menuListar = new JPanel();
		JPanel menuPrestamo = new JPanel();
		JPanel menuConfiguracion = new JPanel();
		JPanel menuOtros = new JPanel();
		
		JButton btnRegistrarLibro = new JButton("Registrar Libro");
		JButton btnRegistrarComputadora = new JButton("Registrar Computadora");
		JButton btnBajaLibro = new JButton("Dar de baja Libro");
		JButton btnBajaComputadora = new JButton("Dar de baja Computadora");
		JButton btnListarLibro = new JButton("Listar Libros");
		JButton btnListarComputadora = new JButton("Listar Computadora");
		JButton btnConfiguracionTemas = new JButton("Temas");
		JButton btnPrestamoLibro = new JButton("Hacer prestamo de Libro");
		JButton btnPrestamoComputadora = new JButton("Hacer prestamo de Computadora");
		JButton btnOtrosManual = new JButton("Acceder al manual de usuario");
		
		
		//Setters
		menuRegistrar.setLayout(new BoxLayout(menuRegistrar, BoxLayout.X_AXIS));
		menuBaja.setLayout(new BoxLayout(menuBaja, BoxLayout.X_AXIS));
		menuListar.setLayout(new BoxLayout(menuListar, BoxLayout.X_AXIS));
		menuPrestamo.setLayout(new BoxLayout(menuPrestamo, BoxLayout.X_AXIS));
		menuConfiguracion.setLayout(new BoxLayout(menuConfiguracion, BoxLayout.X_AXIS));
		menuOtros.setLayout(new BoxLayout(menuOtros, BoxLayout.X_AXIS));
		
		Negrita(btnRegistrarLibro, 16);
		Negrita(btnRegistrarComputadora, 16);
		Negrita(btnBajaLibro, 16);
		Negrita(btnBajaComputadora, 16);
		Negrita(btnListarLibro, 16);
		Negrita(btnListarComputadora, 16);
		Negrita(btnConfiguracionTemas, 16);
		Negrita(btnPrestamoLibro, 16);
		Negrita(btnPrestamoComputadora, 16);
		Negrita(btnOtrosManual, 16);
		
		
		//Adds
		menuRegistrar.add(btnRegistrarLibro);
		menuRegistrar.add(btnRegistrarComputadora);
		
		menuBaja.add(btnBajaLibro);
		menuBaja.add(btnBajaComputadora);
		
		menuListar.add(btnListarLibro);
		menuListar.add(btnListarComputadora);
		
		menuPrestamo.add(btnPrestamoLibro);
		menuPrestamo.add(btnPrestamoComputadora);
		
		menuConfiguracion.add(btnConfiguracionTemas);
		
		menuOtros.add(btnOtrosManual);
		
		herramientas.add("Registrar", menuRegistrar);
		herramientas.add("Dar de Baja", menuBaja);
		herramientas.add("Listar", menuListar);
		herramientas.add("Prestamos", menuPrestamo);
		herramientas.add("Configuracion", menuConfiguracion);
		herramientas.add("Otros", menuOtros);
		
		
		//Eventos
		btnRegistrarLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FRegistrarLibro();
			}
		});
		
		btnRegistrarComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FRegistrarComputadora();
			}
		});
		
		btnBajaLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FBajaLibro();
			}
		});
		
		btnBajaComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FBajaComputadora();
			}
		});
		
		btnListarLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FListarLibro();
			}
		});
		
		btnListarComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FListarComputadora();
			}
		});
		
		btnPrestamoLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FPrestamoLibro();
			}
		});
		
		btnPrestamoComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FPrestamoComputadora();
			}
		});
		
		btnConfiguracionTemas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FConfiguracionTemas();
			}
		});
		
		PanelPadre.add(herramientas, BorderLayout.NORTH);
		
	}
	
	
	
	public static void Negrita(JComponent componente, int tamano) {
		Font fuenteActual = componente.getFont();
		Font fuenteNegrita = new Font(fuenteActual.getName(), Font.BOLD, tamano);
		componente.setFont(fuenteNegrita);
	}
	
	
	
	public static void Tema() {
		
	}
	
	
	
	public static void systemInfo() {

		
		// Imports
		Runtime datos = Runtime.getRuntime();
		JPanel Panelv1 = new JPanel();
		JLabel label1 = new JLabel("SO: Windows 10 IOT LTSC");
		JLabel label2 = new JLabel("Version del SO: 22H2");
		JLabel label3 = new JLabel("Version del SoftWare: 0.1 Prototype 16/8/2025");
		JLabel label4 = new JLabel();

		
		// Variables
		long memoriaDisponible = (datos.totalMemory() - datos.freeMemory()) / (1024);

		
		// Setters
		Panelv1.setLayout(new BoxLayout(Panelv1, BoxLayout.Y_AXIS));
			
		label4.setText("Uso de la memoria: " + memoriaDisponible + "MB");

		
		// Adds
		Panelv1.add(label1);
		Panelv1.add(label2);
		Panelv1.add(label3);
		Panelv1.add(label4);

		// Aplicar al PanelPadre
		PanelPadre.add(Panelv1, BorderLayout.SOUTH);
	}
	
	
	
	public static void FRegistrarLibro() {
		
		
		//imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontal1 = new JPanel();
		JPanel panelVertical2 = new JPanel();
		JPanel panelVertical3 = new JPanel();
		
		JLabel LabelISBN = new JLabel("ISBN");
		JLabel LabelTitulo = new JLabel("Titulo");
		JLabel LabelAutor = new JLabel("Autor");
		JLabel LabelGenero = new JLabel("Genero");
		JLabel LabelMateria = new JLabel("Materia");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputTitulo = new JTextField(6);
		JTextField InputAutor = new JTextField(6);
		JTextField InputGenero = new JTextField(6);
		JTextField InputMateria = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical2.setLayout(new BoxLayout(panelVertical2, BoxLayout.Y_AXIS));
		panelVertical3.setLayout(new BoxLayout(panelVertical3, BoxLayout.Y_AXIS));
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		
		panelVertical2.add(LabelISBN);
		panelVertical2.add(LabelTitulo);
		panelVertical2.add(LabelAutor);
		panelVertical2.add(LabelGenero);
		panelVertical2.add(LabelMateria);
		
		panelVertical3.add(InputISBN);
		panelVertical3.add(InputTitulo);
		panelVertical3.add(InputAutor);
		panelVertical3.add(InputGenero);
		panelVertical3.add(InputMateria);
		
		panelHorizontal1.add(panelVertical2);
		panelHorizontal1.add(panelVertical3);
		
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputISBN.getText().isEmpty() && !InputTitulo.getText().isEmpty() && !InputAutor.getText().isEmpty() && !InputGenero.getText().isEmpty() && !InputMateria.getText().isEmpty()) {
					LabelResultado.setText("El libro se subio correctamente!");
				} else {
					LabelResultado.setText("El libro no se subio correctamente o faltan datos!");
				}
			}
		});
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FRegistrarComputadora() {
		
		
		//imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontal1 = new JPanel();
		JPanel panelVertical2 = new JPanel();
		JPanel panelVertical3 = new JPanel();
		
		JLabel LabelNroSerie = new JLabel("Numero de serie");
		JLabel LabelModelo = new JLabel("Modelo");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputNroSerie = new JTextField(6);
		JTextField InputModelo = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical2.setLayout(new BoxLayout(panelVertical2, BoxLayout.Y_AXIS));
		panelVertical3.setLayout(new BoxLayout(panelVertical3, BoxLayout.Y_AXIS));
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		
		panelVertical2.add(LabelNroSerie);
		panelVertical2.add(LabelModelo);
		
		panelVertical3.add(InputNroSerie);
		panelVertical3.add(InputModelo);
		
		panelHorizontal1.add(panelVertical2);
		panelHorizontal1.add(panelVertical3);
		
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputNroSerie.getText().isEmpty() && !InputModelo.getText().isEmpty()){
					LabelResultado.setText("La computadora se subio correctamente!");
				} else {
					LabelResultado.setText("La computadora no se subio correctamente o faltan datos!");
				}
			}
		});
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FBajaLibro() {
		
		
		//imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontal1 = new JPanel();
		JPanel panelVertical2 = new JPanel();
		JPanel panelVertical3 = new JPanel();
		
		JLabel LabelISBN = new JLabel("ISBN");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputISBN = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical2.setLayout(new BoxLayout(panelVertical2, BoxLayout.Y_AXIS));
		panelVertical3.setLayout(new BoxLayout(panelVertical3, BoxLayout.Y_AXIS));
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		
		panelVertical2.add(LabelISBN);
		
		panelVertical3.add(InputISBN);
		
		panelHorizontal1.add(panelVertical2);
		panelHorizontal1.add(panelVertical3);
		
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputISBN.getText().isEmpty()){
					LabelResultado.setText("El libro fue eliminado de la base de datos correctamente!");
				} else {
					LabelResultado.setText("El libro no se pudo eliminar correctamente o no existe!");
				}
			}
		});
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FBajaComputadora() {
		
		
		//imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontal1 = new JPanel();
		JPanel panelVertical2 = new JPanel();
		JPanel panelVertical3 = new JPanel();
		
		JLabel LabelNroSerie = new JLabel("Nro de serie");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputNroSerie = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical2.setLayout(new BoxLayout(panelVertical2, BoxLayout.Y_AXIS));
		panelVertical3.setLayout(new BoxLayout(panelVertical3, BoxLayout.Y_AXIS));
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		
		panelVertical2.add(LabelNroSerie);
		
		panelVertical3.add(InputNroSerie);
		
		panelHorizontal1.add(panelVertical2);
		panelHorizontal1.add(panelVertical3);
		
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputNroSerie.getText().isEmpty()){
					LabelResultado.setText("La computadora fue eliminada de la base de datos correctamente!");
				} else {
					LabelResultado.setText("La computadora no se pudo eliminar correctamente o no existe!");
				}
			}
		});
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FListarLibro() {
		
		
		//variables & arrays
		String[] columnas = {"ISBN", "Titulo", "Autor", "Genero", "Materia"};
		ArrayList<Libro> libros = new ArrayList();
		
		
		//Imports
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		
		
		//adds
		libros.add(new Libro(123, "1984", "George Orwell", "Distopía", "Literatura"));
        libros.add(new Libro(234, "To Kill a Mockingbird", "Harper Lee", "Drama", "Literatura"));
        libros.add(new Libro(345, "La Odisea", "Homero", "Épico", "Clásicos"));
        libros.add(new Libro(456, "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", "Literatura"));
        
        
        //Estructura - Listado
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            Object[] fila = {
                libro.ISBN,
                libro.titulo,
                libro.autor,
                libro.genero,
                libro.materia
            };
            modelo.addRow(fila);
        }
        
        //Se visualiza en la ventana
        PanelLocal.setVisible(false);
        PanelPadre.add(panelTabla);
        panelTabla.removeAll();
        panelTabla.add(tabla);
      	panelTabla.setVisible(true);
      	PanelPadre.revalidate();
      	PanelPadre.repaint();
        
	}
	
	
	
	public static void FListarComputadora() {
		
		
		//variables & arrays
		String[] columnas = {"Numero de serie", "Modelo"};
		ArrayList<Computadora> computadora = new ArrayList();
		
		
		//Imports
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		
		JTable tabla = new JTable(modelo);
		
		
		//adds
		computadora.add(new Computadora(1, "HP"));
		computadora.add(new Computadora(2, "Lenovo"));
		computadora.add(new Computadora(3, "Gigabyte"));
		computadora.add(new Computadora(4, "Ceibal-Zargas"));
		
		
		//Estructura - Listado
		for (int i = 0; i < computadora.size(); i++) {
			Computadora PC = computadora.get(i);
			Object[] fila = {
				PC.nroSerie,
				PC.modelo
	            };
			modelo.addRow(fila);
		}

		//Se visualiza en la ventana
		PanelLocal.setVisible(false);
		PanelPadre.add(panelTabla);
		panelTabla.removeAll();
		panelTabla.add(tabla);
		panelTabla.setVisible(true);
		PanelPadre.revalidate();
		PanelPadre.repaint();
	}
	
	
	
	public static void FPrestamoLibro() {
	
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelVertical2 = new JPanel();
		JPanel panelVertical3 = new JPanel();
		JPanel panelHorizontal1 = new JPanel();
		
		JLabel LabelResultado = new JLabel();
		JLabel LabelISBN = new JLabel("Ingrese el ISBN del libro");
		JLabel LabelInicio = new JLabel("Ingrese la fecha de inicio");
		JLabel LabelFinal = new JLabel("Ingrese la fecha final");
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputInicio = new JTextField(6);
		JTextField InputFinal = new JTextField(6);
		
		JButton Realizar = new JButton("Realizar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical2.setLayout(new BoxLayout(panelVertical2, BoxLayout.Y_AXIS));
		panelVertical3.setLayout(new BoxLayout(panelVertical3, BoxLayout.Y_AXIS));
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		
		
		//Adds
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(Realizar);
		panelVertical1.add(LabelResultado);
		
		panelHorizontal1.add(panelVertical2);
		panelHorizontal1.add(panelVertical3);
		
		panelVertical2.add(LabelISBN);
		panelVertical2.add(LabelInicio);
		panelVertical2.add(LabelFinal);
		
		panelVertical3.add(InputISBN);
		panelVertical3.add(InputInicio);
		panelVertical3.add(InputFinal);
		
		
		//eventos
		Realizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputISBN.getText().isEmpty() && !InputInicio.getText().isEmpty() && !InputFinal.getText().isEmpty()) {
					LabelResultado.setText("El Prestamo se subio correctamente!");
				} else {
					LabelResultado.setText("El Prestamo no se subio correctamente o faltan datos!");
				}
			}
		});
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FPrestamoComputadora() {
	
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelVertical2 = new JPanel();
		JPanel panelVertical3 = new JPanel();
		JPanel panelHorizontal1 = new JPanel();
		
		JLabel LabelResultado = new JLabel();
		JLabel LabelNroSerie = new JLabel("Ingrese el Nro de serie de la Computadora");
		JLabel LabelInicio = new JLabel("Ingrese la fecha de inicio");
		JLabel LabelFinal = new JLabel("Ingrese la fecha final");
		
		JTextField InputNroSerie = new JTextField(6);
		JTextField InputInicio = new JTextField(6);
		JTextField InputFinal = new JTextField(6);
		
		JButton Realizar = new JButton("Realizar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical2.setLayout(new BoxLayout(panelVertical2, BoxLayout.Y_AXIS));
		panelVertical3.setLayout(new BoxLayout(panelVertical3, BoxLayout.Y_AXIS));
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		
		
		//Adds
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(Realizar);
		panelVertical1.add(LabelResultado);
		
		panelHorizontal1.add(panelVertical2);
		panelHorizontal1.add(panelVertical3);
		
		panelVertical2.add(LabelNroSerie);
		panelVertical2.add(LabelInicio);
		panelVertical2.add(LabelFinal);
		
		panelVertical3.add(InputNroSerie);
		panelVertical3.add(InputInicio);
		panelVertical3.add(InputFinal);
		
		
		//eventos
		Realizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputNroSerie.getText().isEmpty() && !InputInicio.getText().isEmpty() && !InputFinal.getText().isEmpty()) {
					LabelResultado.setText("El Prestamo se subio correctamente!");
				} else {
					LabelResultado.setText("El Prestamo no se subio correctamente o faltan datos!");
				}
			}
		});
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FConfiguracionTemas() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		
		JLabel label1 = new JLabel("Selecciona tu tema de fondo");
		
		JButton Aplicar = new JButton("Aplicar cambios");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		
		
		//adds
		panelVertical1.add(label1);
		panelVertical1.add(temas);
		panelVertical1.add(Aplicar);
		
		Aplicar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var index = temas.getSelectedIndex();
				PanelPadre.setBackground(coloresDireccion[index]);
				PanelLocal.setBackground(coloresDireccion[index]);
				panelTabla.setBackground(coloresDireccion[index]);
			}
		});
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
	}
	
	
	
	public static void FManualUsuario() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		
		JLabel labelResultado = new JLabel("Manual no disponible...");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		
		
		//adds
		panelVertical1.add(labelResultado);
		
		
		//Se visualiza en la ventana
		panelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
}
