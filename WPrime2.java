package Biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class WPrime2 extends JFrame{

	//Imports para el funcionamiento de la GUI
	protected static JPanel PanelPadre = new JPanel(new BorderLayout());
	protected static JPanel PanelLocal = new JPanel(new GridBagLayout());
	protected static JPanel PanelTabla = new JPanel(new BorderLayout());
	protected static LGestor logica = new LGestor();
	
	//Imports de la ventana principal
	protected static JTabbedPane herramientas = new JTabbedPane(JTabbedPane.TOP);
	
	protected static JPanel menuRegistrar = new JPanel();
	protected static JPanel menuBaja = new JPanel();
	protected static JPanel menuListar = new JPanel();
	protected static JPanel menuPrestamo = new JPanel();
	protected static JPanel menuConfiguracion = new JPanel();
	protected static JPanel menuOtros = new JPanel();
	
	protected static JButton btnRegistrarLibro = new JButton("Registrar Libro");
	protected static JButton btnRegistrarComputadora = new JButton("Registrar Computadora");
	protected static JButton btnBajaLibro = new JButton("Dar de baja Libro");
	protected static JButton btnBajaComputadora = new JButton("Dar de baja Computadora");
	protected static JButton btnListarLibro = new JButton("Listar Libros");
	protected static JButton btnListarComputadora = new JButton("Listar Computadora");
	protected static JButton btnConfiguracionTemas = new JButton("Temas");
	protected static JButton btnConfiguracionBarraLateral = new JButton("Barra Lateral");
	protected static JButton btnPrestamoLibro = new JButton("Hacer prestamo de Libro");
	protected static JButton btnPrestamoComputadora = new JButton("Hacer prestamo de Computadora");
	protected static JButton btnOtrosManual = new JButton("Acceder al manual de usuario");
	
	
	//Objetos para la personalizacion del programa
	protected static Tema[] Temas = { /* Fondo, Botones, Letras*/
		    new Tema(Color.WHITE, new Color(224,244,244), Color.BLACK),// Claro
		    new Tema(new Color(32,32,32), new Color(64,64,64), new Color(224,224,224)),// Oscuro
		    new Tema(new Color(15,138,76), new Color(0,153,76), Color.WHITE)// Verde Aqua
		};
	protected static String[] coloresNombres = {"Claro", "Oscuro", "Verde Aqua"};
	protected static int colorIndex;
	protected static JComboBox temasEleccion = new JComboBox(coloresNombres);
	

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
		Ftab();

	}
		
	public static void Ftab() {
		
		
		//Imports
		//Presentes antes del constructor
		
		
		//Setters
		menuRegistrar.setLayout(new BoxLayout(menuRegistrar, BoxLayout.X_AXIS));
		menuBaja.setLayout(new BoxLayout(menuBaja, BoxLayout.X_AXIS));
		menuListar.setLayout(new BoxLayout(menuListar, BoxLayout.X_AXIS));
		menuPrestamo.setLayout(new BoxLayout(menuPrestamo, BoxLayout.X_AXIS));
		menuConfiguracion.setLayout(new BoxLayout(menuConfiguracion, BoxLayout.X_AXIS));
		menuOtros.setLayout(new BoxLayout(menuOtros, BoxLayout.X_AXIS));
		
		FNegrita(btnRegistrarLibro, 16);
		FNegrita(btnRegistrarComputadora, 16);
		FNegrita(btnBajaLibro, 16);
		FNegrita(btnBajaComputadora, 16);
		FNegrita(btnListarLibro, 16);
		FNegrita(btnListarComputadora, 16);
		FNegrita(btnConfiguracionTemas, 16);
		FNegrita(btnConfiguracionBarraLateral, 16);
		FNegrita(btnPrestamoLibro, 16);
		FNegrita(btnPrestamoComputadora, 16);
		FNegrita(btnOtrosManual, 16);
		
		
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
		menuConfiguracion.add(btnConfiguracionBarraLateral);
		
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
		
		btnConfiguracionBarraLateral.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FConfiguracionBarraLateral();
			}
		});
		
		PanelPadre.add(herramientas, BorderLayout.NORTH);
		
	}
	
	
	
	public static void FNegrita(JComponent componente, int tamano) {
		Font fuenteActual = componente.getFont();
		Font fuenteNegrita = new Font(fuenteActual.getName(), Font.BOLD, tamano);
		componente.setFont(fuenteNegrita);
	}
	
	
	/*
	 * FUNCION FsystemInfo
	 * INPUT:
	 * OUTPUT:
	 * ESTADO: descartada
	 * Esta funcion fue descartada al no proporcionar informacion realmente valiosa para el usuario final, ademas de ser una molestia visualmente hablando
	 */
	/*public static void FsystemInfo() {

		
		// Imports
		Runtime datos = Runtime.getRuntime();
		JLabel label1 = new JLabel("SO: Windows 10 IOT LTSC");
		JLabel label2 = new JLabel("Version del SO: 22H2");
		JLabel label3 = new JLabel("Version del SoftWare: 0.1 Prototype 16/8/2025");
		JLabel label4 = new JLabel();

		
		// Variables
		long memoriaDisponible = (datos.totalMemory() - datos.freeMemory()) / (1024);

		
		// Setters
		PanelSystemInfo.setLayout(new BoxLayout(PanelSystemInfo, BoxLayout.Y_AXIS));
		
		label4.setText("Uso de la memoria: " + memoriaDisponible + "MB");
		
		
		// Adds
		PanelSystemInfo.removeAll();
		PanelSystemInfo.add(label1);
		PanelSystemInfo.add(label2);
		PanelSystemInfo.add(label3);
		PanelSystemInfo.add(label4);

		// Aplicar al PanelPadre
		PanelPadre.add(PanelSystemInfo, BorderLayout.SOUTH);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}*/
	
	
	
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
		FestablecePaneles(true, false);
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
		FestablecePaneles(true, false);
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
		FestablecePaneles(true, false);
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
		FestablecePaneles(true, false);
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
		FestablecePaneles(false, false);
        PanelPadre.add(PanelTabla);
        PanelTabla.removeAll();
        PanelTabla.add(tabla);
      	PanelTabla.setVisible(true);
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
		FestablecePaneles(false, false);
		PanelPadre.add(PanelTabla);
		PanelTabla.removeAll();
		PanelTabla.add(tabla);
		PanelTabla.setVisible(true);
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
		FestablecePaneles(true, false);
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
		FestablecePaneles(true, false);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FConfiguracionTemas() {
		
		
		//imports
		JPanel panelVertical1 = new JPanel();
		
		JLabel label1 = new JLabel("Selecciona tu tema de fondo");
		
		JButton Aplicar = new JButton("Aplicar cambios");
		
		JCheckBox AplicarABarraHerramita = new JCheckBox("Aplicar a la barra de herramientas");
		JCheckBox AplicarABotonesBarraHerramienta = new JCheckBox("Aplicar a los botones de la barra de herramientas");
		JCheckBox AplicarAFondoBarraHerramienta = new JCheckBox("Aplicar al fondo de los botones de la barra de herramientas");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical1.add(label1);
		panelVertical1.add(temasEleccion);
		panelVertical1.add(AplicarABarraHerramita);
		panelVertical1.add(AplicarABotonesBarraHerramienta);
		panelVertical1.add(AplicarAFondoBarraHerramienta);
		panelVertical1.add(Aplicar);
		
		
		//adds
		
		
		//Eventos
		Aplicar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorIndex = temasEleccion.getSelectedIndex();
				
				//Tema para PanelPadre
				PanelPadre.setBackground(Temas[colorIndex].getFondo());
				PanelLocal.setBackground(Temas[colorIndex].getFondo());
				
				//Tema para la barra de herramientas
				if (AplicarABarraHerramita.isSelected()) {
					herramientas.setBackground(Temas[colorIndex].getFondo());
					
				} else {
					herramientas.setBackground(Temas[0].getFondo());
					
				}
				
				//Tema para los botones de la barra de herramientas
				if (AplicarAFondoBarraHerramienta.isSelected()) {
					//Aplicar fondo
					menuRegistrar.setBackground(Temas[colorIndex].getFondo());
					menuBaja.setBackground(Temas[colorIndex].getFondo());
					menuListar.setBackground(Temas[colorIndex].getFondo());
					menuPrestamo.setBackground(Temas[colorIndex].getFondo());
					menuConfiguracion.setBackground(Temas[colorIndex].getFondo());
					menuOtros.setBackground(Temas[colorIndex].getFondo());
					
				} else {
					//Aplicar fondo predefinido
					menuRegistrar.setBackground(Temas[0].getFondo());
					menuBaja.setBackground(Temas[0].getFondo());
					menuListar.setBackground(Temas[0].getFondo());
					menuPrestamo.setBackground(Temas[0].getFondo());
					menuConfiguracion.setBackground(Temas[0].getFondo());
					menuOtros.setBackground(Temas[0].getFondo());
					
				}
				
				//Tema para los botones de la barra de herramientas
				if (AplicarABotonesBarraHerramienta.isSelected()) {
					//set fondo
					btnRegistrarLibro.setBackground(Temas[colorIndex].getFondo());
					btnRegistrarComputadora.setBackground(Temas[colorIndex].getFondo());
					btnBajaLibro.setBackground(Temas[colorIndex].getFondo());
					btnBajaComputadora.setBackground(Temas[colorIndex].getFondo());
					btnListarLibro.setBackground(Temas[colorIndex].getFondo());
					btnListarComputadora.setBackground(Temas[colorIndex].getFondo());
					btnPrestamoLibro.setBackground(Temas[colorIndex].getFondo());
					btnPrestamoComputadora.setBackground(Temas[colorIndex].getFondo());
					btnConfiguracionTemas.setBackground(Temas[colorIndex].getFondo());
					btnConfiguracionBarraLateral.setBackground(Temas[colorIndex].getFondo());
					btnOtrosManual.setBackground(Temas[colorIndex].getFondo());
					
					//set botones
					btnRegistrarLibro.setForeground(Temas[colorIndex].getLetras());
					btnRegistrarComputadora.setForeground(Temas[colorIndex].getLetras());
					btnBajaLibro.setForeground(Temas[colorIndex].getLetras());
					btnBajaComputadora.setForeground(Temas[colorIndex].getLetras());
					btnListarLibro.setForeground(Temas[colorIndex].getLetras());
					btnListarComputadora.setForeground(Temas[colorIndex].getLetras());
					btnPrestamoLibro.setForeground(Temas[colorIndex].getLetras());
					btnPrestamoComputadora.setForeground(Temas[colorIndex].getLetras());
					btnConfiguracionTemas.setForeground(Temas[colorIndex].getLetras());
					btnConfiguracionBarraLateral.setForeground(Temas[colorIndex].getLetras());
					btnOtrosManual.setForeground(Temas[colorIndex].getLetras());
					
					
				} else {
					//fondo a los botones predefinidos
					btnRegistrarLibro.setBackground(Temas[0].getFondo());
					btnRegistrarComputadora.setBackground(Temas[0].getFondo());
					btnRegistrarLibro.setForeground(Temas[0].getLetras());
					btnRegistrarComputadora.setForeground(Temas[0].getLetras());
					btnBajaLibro.setBackground(Temas[0].getFondo());
					btnBajaComputadora.setBackground(Temas[0].getFondo());
					btnListarLibro.setBackground(Temas[0].getFondo());
					btnListarComputadora.setBackground(Temas[0].getFondo());
					btnPrestamoLibro.setBackground(Temas[0].getFondo());
					btnPrestamoComputadora.setBackground(Temas[0].getFondo());
					btnConfiguracionTemas.setBackground(Temas[0].getFondo());
					btnConfiguracionBarraLateral.setBackground(Temas[0].getFondo());
					btnOtrosManual.setBackground(Temas[0].getFondo());
					
					//color de letras de los botones
					btnRegistrarLibro.setForeground(Temas[0].getLetras());
					btnRegistrarComputadora.setForeground(Temas[0].getLetras());
					btnBajaLibro.setForeground(Temas[0].getLetras());
					btnBajaComputadora.setForeground(Temas[0].getLetras());
					btnListarLibro.setForeground(Temas[0].getLetras());
					btnListarComputadora.setForeground(Temas[0].getLetras());
					btnPrestamoLibro.setForeground(Temas[0].getLetras());
					btnPrestamoComputadora.setForeground(Temas[0].getLetras());
					btnConfiguracionTemas.setForeground(Temas[0].getLetras());
					btnConfiguracionBarraLateral.setForeground(Temas[0].getLetras());
					btnOtrosManual.setForeground(Temas[0].getLetras());
					
				}
				
				
			}
		});
		
		
		//Se visualiza en la ventana
		FestablecePaneles(true, false);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelLocal.revalidate();
		PanelLocal.repaint();
		PanelPadre.revalidate();
		PanelPadre.repaint();
	}
	
	
	
	public static void FConfiguracionBarraLateral() {
		
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
		PanelTabla.setVisible(false);
		PanelLocal.setVisible(true);
		PanelLocal.removeAll();
		PanelLocal.add(panelVertical1);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		
	}
	
	
	
	public static void FcambiarColorTexto(JComponent componente, Color colorTexto) {
	    if (componente != null) {
	        componente.setForeground(colorTexto);
	    }
	}
	
	
	
	public static void FcambiarColorFondo(JComponent componente, Color colorFondo) {
	    if (componente != null) {
	        componente.setBackground(colorFondo);
	        componente.setOpaque(true); // Asegura que el fondo sea visible
	    }
	}
	
	
	
	public static void FestablecePaneles(boolean panel1, boolean panel2) {
		PanelLocal.setVisible(panel1);
		PanelTabla.setVisible(panel2);
	}

}