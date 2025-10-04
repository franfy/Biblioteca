package Biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class WPrime extends JFrame{

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
	protected static JButton btnListarPrestamoLibro = new JButton("Listar Prestamos de Libros");
	protected static JButton btnListarPrestamoComputadora = new JButton("Listar Prestamos de Computadoras");
	protected static JButton btnConfiguracionTemas = new JButton("Temas");
	protected static JButton btnConfiguracionHistorial = new JButton("Historial");
	protected static JButton btnPrestamoLibro = new JButton("Hacer prestamo de Libro");
	protected static JButton btnPrestamoComputadora = new JButton("Hacer prestamo de Computadora");
	protected static JButton btnOtrosManual = new JButton("Acceder al manual de usuario");
	
	
	//Objetos para la personalizacion del programa
	protected static Tema[] Temas = { /* Fondo, Botones, Letras*/
		    new Tema(Color.WHITE, new Color(180,180,180), Color.BLACK),// Claro
		    new Tema(new Color(32,32,32), new Color(64,64,64), new Color(224,244,244)),// Oscuro
		    new Tema(new Color(15,138,76),new Color(10, 100, 10), Color.BLACK)// Verde Aqua
		};
	protected static String[] coloresNombres = {"Claro", "Oscuro", "Verde Aqua"};
	protected static int colorIndex;
	protected static int colorIndexBotones;
	protected static JComboBox temasEleccion = new JComboBox(coloresNombres);
	protected static JComboBox temasEleccionBotones = new JComboBox(coloresNombres);
	
	
	public WPrime() {

		
		// Configuracion de la Ventana
		this.setTitle("Biblioteca Prototipo");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		
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
		
		FhacerRedondeado(btnRegistrarLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnRegistrarComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnBajaLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnBajaComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarPrestamoLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarPrestamoComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnPrestamoLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnPrestamoComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnConfiguracionTemas, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnConfiguracionHistorial, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnOtrosManual, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		FNegrita(btnRegistrarLibro, 16);
		FNegrita(btnRegistrarComputadora, 16);
		FNegrita(btnBajaLibro, 16);
		FNegrita(btnBajaComputadora, 16);
		FNegrita(btnListarLibro, 16);
		FNegrita(btnListarComputadora, 16);
		FNegrita(btnListarPrestamoLibro, 16);
		FNegrita(btnListarPrestamoComputadora, 16);
		FNegrita(btnConfiguracionTemas, 16);
		FNegrita(btnConfiguracionHistorial, 16);
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
		menuListar.add(btnListarPrestamoLibro);
		menuListar.add(btnListarPrestamoComputadora);
		
		menuPrestamo.add(btnPrestamoLibro);
		menuPrestamo.add(btnPrestamoComputadora);
		
		menuConfiguracion.add(btnConfiguracionTemas);
		//menuConfiguracion.add(btnConfiguracionBarraLateral);
		
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
		
		btnListarPrestamoLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FListarPrestamoLibro();
			}
		});
		
		btnListarPrestamoComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FListarPrestamoComputadora();
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
		
		btnConfiguracionHistorial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FConfiguracionHistorial();
			}
		});
		
		btnOtrosManual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FManualUsuario();
			}
		});
		
		PanelPadre.add(herramientas, BorderLayout.NORTH);
		
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
		JPanel panelHorizontalISBN = new JPanel();
		JPanel panelHorizontalTitulo = new JPanel();
		JPanel panelHorizontalAutor = new JPanel();
		JPanel panelHorizontalGenero = new JPanel();
		JPanel panelHorizontalMateria = new JPanel();
		JPanel panelHorizontalCantidad = new JPanel();
		JPanel panelHorizontalPais = new JPanel();
		
		JLabel LabelISBN = new JLabel("ISBN");
		JLabel LabelTitulo = new JLabel("Titulo");
		JLabel LabelAutor = new JLabel("Autor");
		JLabel LabelGenero = new JLabel("Genero");
		JLabel LabelMateria = new JLabel("Materia");
		JLabel LabelPais = new JLabel("Pais");
		JLabel LabelCantidad = new JLabel("Cantidad");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputTitulo = new JTextField(6);
		JTextField InputAutor = new JTextField(6);
		JTextField InputGenero = new JTextField(6);
		JTextField InputMateria = new JTextField(6);
		JTextField InputCantidad = new JTextField(6);
		JTextField InputPais = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar Libro");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalISBN.setLayout(new BoxLayout(panelHorizontalISBN, BoxLayout.X_AXIS));
		panelHorizontalTitulo.setLayout(new BoxLayout(panelHorizontalTitulo, BoxLayout.X_AXIS));
		panelHorizontalAutor.setLayout(new BoxLayout(panelHorizontalAutor, BoxLayout.X_AXIS));
		panelHorizontalGenero.setLayout(new BoxLayout(panelHorizontalGenero, BoxLayout.X_AXIS));
		panelHorizontalMateria.setLayout(new BoxLayout(panelHorizontalMateria, BoxLayout.X_AXIS));
		panelHorizontalCantidad.setLayout(new BoxLayout(panelHorizontalCantidad, BoxLayout.X_AXIS));
		panelHorizontalPais.setLayout(new BoxLayout(panelHorizontalPais, BoxLayout.X_AXIS));
		
		LabelISBN.setForeground(Temas[colorIndex].getLetras());
		LabelTitulo.setForeground(Temas[colorIndex].getLetras());
		LabelAutor.setForeground(Temas[colorIndex].getLetras());
		LabelGenero.setForeground(Temas[colorIndex].getLetras());
		LabelMateria.setForeground(Temas[colorIndex].getLetras());
		LabelCantidad.setForeground(Temas[colorIndex].getLetras());
		LabelPais.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Registrar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		
		//Adds
		panelHorizontalISBN.add(LabelISBN);
		panelHorizontalISBN.add(InputISBN);
		panelHorizontalISBN.setOpaque(false);
		
		panelHorizontalTitulo.add(LabelTitulo);
		panelHorizontalTitulo.add(InputTitulo);
		panelHorizontalTitulo.setOpaque(false);
		
		panelHorizontalAutor.add(LabelAutor);
		panelHorizontalAutor.add(InputAutor);
		panelHorizontalAutor.setOpaque(false);
		
		panelHorizontalGenero.add(LabelGenero);
		panelHorizontalGenero.add(InputGenero);
		panelHorizontalGenero.setOpaque(false);
		
		panelHorizontalMateria.add(LabelMateria);
		panelHorizontalMateria.add(InputMateria);
		panelHorizontalMateria.setOpaque(false);
		
		panelHorizontalCantidad.add(LabelCantidad);
		panelHorizontalCantidad.add(InputCantidad);
		panelHorizontalCantidad.setOpaque(false);
		
		panelHorizontalPais.add(LabelPais);
		panelHorizontalPais.add(InputPais);
		panelHorizontalPais.setOpaque(false);
		
		panelVertical1.add(panelHorizontalISBN);
		panelVertical1.add(panelHorizontalTitulo);
		panelVertical1.add(panelHorizontalAutor);
		panelVertical1.add(panelHorizontalGenero);
		panelVertical1.add(panelHorizontalMateria);
		panelVertical1.add(panelHorizontalCantidad);
		panelVertical1.add(panelHorizontalPais);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var res = logica.SubirLibro(InputISBN.getText(),
						InputTitulo.getText(), 
						InputAutor.getText(), 
						InputGenero.getText(), 
						InputMateria.getText(), 
						Integer.parseInt(InputCantidad.getText()),
						InputPais.getText(),
						null,
						null);
				
				if (res == true) {
					LabelResultado.setText("Todo salio bien");
				} else {
					LabelResultado.setText("Todo salio mal");
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
		JPanel panelHorizontalNro = new JPanel();
		JPanel panelHorizontalEstado = new JPanel();
		
		JLabel LabelNro = new JLabel("Numero de computadora");
		JLabel LabelEstado = new JLabel("Estado");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputNro = new JTextField(6);
		JTextField InputEstado = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar Computadora");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalNro.setLayout(new BoxLayout(panelHorizontalNro, BoxLayout.X_AXIS));
		panelHorizontalEstado.setLayout(new BoxLayout(panelHorizontalEstado, BoxLayout.X_AXIS));
		
		LabelNro.setForeground(Temas[colorIndex].getLetras());
		LabelEstado.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Registrar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		panelHorizontalNro.add(LabelNro);
		panelHorizontalNro.add(InputNro);
		panelHorizontalNro.setOpaque(false);
		
		panelHorizontalEstado.add(LabelEstado);
		panelHorizontalEstado.add(InputEstado);
		panelHorizontalEstado.setOpaque(false);
		
		panelVertical1.add(panelHorizontalNro);
		panelVertical1.add(panelHorizontalEstado);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var res = logica.SubirComputadora(Integer.parseInt(InputNro.getText()),
						InputEstado.getText(),
						null);
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
		JPanel panelHorizontalISBN = new JPanel();
		JPanel panelHorizontalMotivo = new JPanel();
		
		JLabel LabelISBN = new JLabel("ISBN");
		JLabel LabelMotivo = new JLabel("Motivo");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputMotivo = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalISBN.setLayout(new BoxLayout(panelHorizontalISBN, BoxLayout.X_AXIS));
		panelHorizontalMotivo.setLayout(new BoxLayout(panelHorizontalMotivo, BoxLayout.X_AXIS));
		
		LabelISBN.setForeground(Temas[colorIndex].getLetras());
		LabelMotivo.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Registrar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		panelHorizontalISBN.add(LabelISBN);
		panelHorizontalISBN.add(InputISBN);
		panelHorizontalISBN.setOpaque(false);
		
		panelHorizontalMotivo.add(LabelMotivo);
		panelHorizontalMotivo.add(InputMotivo);
		panelHorizontalMotivo.setOpaque(false);
		
		panelVertical1.add(panelHorizontalISBN);
		panelVertical1.add(panelHorizontalMotivo);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
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
		JPanel panelHorizontalNro = new JPanel();
		JPanel panelHorizontalMotivo = new JPanel();
		
		JLabel LabelNro = new JLabel("Nro de computadora");
		JLabel LabelMotivo = new JLabel("Motivo");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputNro = new JTextField(6);
		JTextField InputMotivo = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalNro.setLayout(new BoxLayout(panelHorizontalNro, BoxLayout.X_AXIS));
		panelHorizontalMotivo.setLayout(new BoxLayout(panelHorizontalMotivo, BoxLayout.X_AXIS));
		
		LabelNro.setForeground(Temas[colorIndex].getLetras());
		LabelMotivo.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Registrar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		
		panelHorizontalNro.add(LabelNro);
		panelHorizontalNro.add(InputNro);
		panelHorizontalNro.setOpaque(false);
		
		panelHorizontalMotivo.add(LabelMotivo);
		panelHorizontalMotivo.add(InputMotivo);
		panelHorizontalMotivo.setOpaque(false);
		
		panelVertical1.add(panelHorizontalNro);
		panelVertical1.add(panelHorizontalMotivo);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputNro.getText().isEmpty() && !InputMotivo.getText().isEmpty()){
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
		String[] columnas = {"ISBN", "Titulo", "Autor", "Genero", "Materia", "Pais"};
		ArrayList<Libro> libros = new ArrayList();
		
		
		//Imports
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		
		
		//adds
		libros.add(new Libro(123, "1984", "George Orwell", "Distopía", "Literatura", "Uruguay"));
        libros.add(new Libro(234, "To Kill a Mockingbird", "Harper Lee", "Drama", "Literatura", "Uruguay"));
        libros.add(new Libro(345, "La Odisea", "Homero", "Épico", "Clásicos", "Uruguay"));
        libros.add(new Libro(456, "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", "Literatura", "Uruguay"));
        
        
        //Estructura - Listado
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            Object[] fila = {
                libro.ISBN,
                libro.titulo,
                libro.autor,
                libro.genero,
                libro.materia,
                libro.pais
            };
            modelo.addRow(fila);
        }
        
        //Se visualiza en la ventana
        PanelPadre.add(PanelTabla);
        PanelTabla.removeAll();
        PanelTabla.add(scroll);
        FestablecePaneles(false, true);
      	PanelPadre.revalidate();
      	PanelPadre.repaint();
        
	}
	
	
	
	public static void FListarComputadora() {
		
		
		//variables & arrays
		String[] columnas = {"Numero de computadora", "Estado"};
		ArrayList<Computadora> computadora = new ArrayList();
		
		
		//Imports
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		
		
		//adds
		computadora.add(new Computadora(1, "Saludable"));
		computadora.add(new Computadora(2, "Saludable"));
		computadora.add(new Computadora(3, "Bueno"));
		computadora.add(new Computadora(4, "Rota"));
		
		
		//Estructura - Listado
		for (int i = 0; i < computadora.size(); i++) {
			Computadora PC = computadora.get(i);
			Object[] fila = {
				PC.nro,
				PC.estado
	            };
			modelo.addRow(fila);
		}

		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla);
		PanelTabla.removeAll();
		PanelTabla.add(scroll);
		FestablecePaneles(false, true);
		PanelPadre.revalidate();
		PanelPadre.repaint();
	}
	
	
	
	public static void FListarPrestamoLibro() {
		//variables & arrays
		String[] columnas = {"ISBN", "Titulo", "Autor", "Genero", "Materia", "Pais", "Estudiante", "Grupo","Entrega", "Devolucion"};
		ArrayList<PrestamoLibro> libros = new ArrayList();
		
		
		//Imports
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		
		
		//adds
		libros.add(new PrestamoLibro(123, "1984", "George Orwell", "Distopía", "Literatura", "Uruguay", "Franco", "informatica", "1/1/24", "2/1/24"));
        libros.add(new PrestamoLibro(234, "To Kill a Mockingbird", "Harper Lee", "Drama", "Literatura", "Uruguay", "Franco", "informatica","1/1/24", "2/1/24"));
		libros.add(new PrestamoLibro(345, "La Odisea", "Homero", "Épico", "Clásicos", "Uruguay", "Franco", "informatica","1/1/24", "2/1/24"));
		libros.add(new PrestamoLibro(456, "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", "Literatura", "Uruguay", "Franco", "informatica", "1/1/24", "2/1/24"));
		
		
		//Estructura - Listado
		for (int i = 0; i < libros.size(); i++) {
			PrestamoLibro libro = libros.get(i);
			Object[] fila = {
				libro.ISBN,
				libro.titulo,
				libro.autor,
		        libro.genero,
		        libro.materia,
		        libro.pais,
		        libro.nombreEstudiante,
		        libro.grupo,
		        libro.entrega,
		        libro.devolucion
		        };
			modelo.addRow(fila);
		}
		
		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla);
		PanelTabla.removeAll();
		PanelTabla.add(scroll);
		FestablecePaneles(false, true);
		PanelPadre.revalidate();
		PanelPadre.repaint();
		        
			}
	
	
	
	public static void FListarPrestamoComputadora() {
		//variables & arrays
		String[] columnas = {"Numero de computadora", "Estado", "Estudiante", "Grupo","Entrega", "Devolucion"};
		ArrayList<PrestamoComputadora> computadora = new ArrayList();
		
		
		//Imports
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		
		
		//adds
		computadora.add(new PrestamoComputadora(1, "Saludable", "Franco", "informatica", "1/1/24", "2/1/24"));
		computadora.add(new PrestamoComputadora(2, "Saludabla", "Ramiro", "informatica","1/1/24", "2/1/24"));
		computadora.add(new PrestamoComputadora(3, "Bueno", "Elena", "Literatura", "1/1/24", "2/1/24"));
		computadora.add(new PrestamoComputadora(4, "Rota", "Felix", "Matematica","1/1/24", "2/1/24"));
		
		
		//Estructura - Listado
		for (int i = 0; i < computadora.size(); i++) {
			PrestamoComputadora PC = computadora.get(i);
			Object[] fila = {
				PC.nro,
				PC.estado,
				PC.nombreEstudiante,
				PC.grupo,
				PC.entrega,
				PC.devolucion
			};
			modelo.addRow(fila);
		}
		
		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla);
		PanelTabla.removeAll();
		PanelTabla.add(scroll);
		FestablecePaneles(false, true);
		PanelPadre.revalidate();
		PanelPadre.repaint();
	}
	
	
	
	public static void FPrestamoLibro() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontalISBN = new JPanel();
		JPanel panelHorizontalEstudiante = new JPanel();
		JPanel panelHorizontalGrupo = new JPanel();
		JPanel panelHorizontalInicio = new JPanel();
		JPanel panelHorizontalFinal = new JPanel();
		
		JLabel LabelResultado = new JLabel();
		JLabel LabelISBN = new JLabel("Ingrese el ISBN del libro");
		JLabel LabelEstudiante = new JLabel("Nombre del Estudiante");
		JLabel LabelGrupo = new JLabel("Grupo del Estudiante");
		JLabel LabelInicio = new JLabel("Ingrese la fecha de entrega (dd/mm/yyyy)");
		JLabel LabelFinal = new JLabel("Ingrese la fecha de devolucion (dd/mm/yyyy)");
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputEstudiante = new JTextField(6);
		JTextField InputGrupo = new JTextField(6);
		JTextField InputInicio = new JTextField(6);
		JTextField InputFinal = new JTextField(6);
		
		JButton Realizar = new JButton("Realizar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalISBN.setLayout(new BoxLayout(panelHorizontalISBN, BoxLayout.X_AXIS));
		panelHorizontalEstudiante.setLayout(new BoxLayout(panelHorizontalEstudiante, BoxLayout.X_AXIS));
		panelHorizontalGrupo.setLayout(new BoxLayout(panelHorizontalGrupo, BoxLayout.X_AXIS));
		panelHorizontalInicio.setLayout(new BoxLayout(panelHorizontalInicio, BoxLayout.X_AXIS));
		panelHorizontalFinal.setLayout(new BoxLayout(panelHorizontalFinal, BoxLayout.X_AXIS));
		
		LabelISBN.setForeground(Temas[colorIndex].getLetras());
		LabelInicio.setForeground(Temas[colorIndex].getLetras());
		LabelEstudiante.setForeground(Temas[colorIndex].getLetras());
		LabelGrupo.setForeground(Temas[colorIndex].getLetras());
		LabelFinal.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Realizar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		panelHorizontalISBN.add(LabelISBN);
		panelHorizontalISBN.add(InputISBN);	
		panelHorizontalISBN.setOpaque(false);
		
		panelHorizontalEstudiante.add(LabelEstudiante);
		panelHorizontalEstudiante.add(InputEstudiante);
		panelHorizontalEstudiante.setOpaque(false);
		
		panelHorizontalGrupo.add(LabelGrupo);
		panelHorizontalGrupo.add(InputGrupo);
		panelHorizontalGrupo.setOpaque(false);
		
		panelHorizontalInicio.add(LabelInicio);
		panelHorizontalInicio.add(InputInicio);
		panelHorizontalInicio.setOpaque(false);
		
		panelHorizontalFinal.add(LabelFinal);
		panelHorizontalFinal.add(InputFinal);
		panelHorizontalFinal.setOpaque(false);
		
		panelVertical1.add(panelHorizontalISBN);
		panelVertical1.add(panelHorizontalEstudiante);
		panelVertical1.add(panelHorizontalGrupo);
		panelVertical1.add(panelHorizontalInicio);
		panelVertical1.add(panelHorizontalFinal);
		panelVertical1.add(Realizar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Realizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputISBN.getText().isEmpty() && !InputEstudiante.getText().isEmpty() && !InputGrupo.getText().isEmpty() && !InputInicio.getText().isEmpty() && !InputFinal.getText().isEmpty()) {
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
		JPanel panelHorizontalNro = new JPanel();
		JPanel panelHorizontalEstudiante = new JPanel();
		JPanel panelHorizontalGrupo = new JPanel();
		JPanel panelHorizontalInicio = new JPanel();
		JPanel panelHorizontalFinal = new JPanel();
		
		JLabel LabelResultado = new JLabel();
		JLabel LabelNro = new JLabel("Ingrese el Nro de la Computadora");
		JLabel LabelEstudiante = new JLabel("Nombre del Estudiante");
		JLabel LabelGrupo = new JLabel("Grupo del Estudiante");
		JLabel LabelInicio = new JLabel("Ingrese la fecha de entrega (dd/mm/yyyy)");
		JLabel LabelFinal = new JLabel("Ingrese la fecha de devolucion (dd/mm/yyyy)");
		
		JTextField InputNro = new JTextField(6);
		JTextField InputEstudiante = new JTextField(6);
		JTextField InputGrupo = new JTextField(6);
		JTextField InputInicio = new JTextField(6);
		JTextField InputFinal = new JTextField(6);
		
		JButton Realizar = new JButton("Realizar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalNro.setLayout(new BoxLayout(panelHorizontalNro, BoxLayout.X_AXIS));
		panelHorizontalEstudiante.setLayout(new BoxLayout(panelHorizontalEstudiante, BoxLayout.X_AXIS));
		panelHorizontalGrupo.setLayout(new BoxLayout(panelHorizontalGrupo, BoxLayout.X_AXIS));
		panelHorizontalInicio.setLayout(new BoxLayout(panelHorizontalInicio, BoxLayout.X_AXIS));
		panelHorizontalFinal.setLayout(new BoxLayout(panelHorizontalFinal, BoxLayout.X_AXIS));
		
		FhacerRedondeado(Realizar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		LabelNro.setForeground(Temas[colorIndex].getLetras());
		LabelInicio.setForeground(Temas[colorIndex].getLetras());
		LabelEstudiante.setForeground(Temas[colorIndex].getLetras());
		LabelGrupo.setForeground(Temas[colorIndex].getLetras());
		LabelFinal.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		panelHorizontalNro.add(LabelNro);
		panelHorizontalNro.add(InputNro);
		panelHorizontalNro.setOpaque(false);
		
		panelHorizontalEstudiante.add(LabelEstudiante);
		panelHorizontalEstudiante.add(InputEstudiante);
		panelHorizontalEstudiante.setOpaque(false);
		
		panelHorizontalGrupo.add(LabelGrupo);
		panelHorizontalGrupo.add(InputGrupo);
		panelHorizontalGrupo.setOpaque(false);
		
		panelHorizontalInicio.add(LabelInicio);
		panelHorizontalInicio.add(InputInicio);
		panelHorizontalInicio.setOpaque(false);
		
		panelHorizontalFinal.add(LabelFinal);
		panelHorizontalFinal.add(InputFinal);
		panelHorizontalFinal.setOpaque(false);
		
		//Adds
		panelVertical1.add(panelHorizontalNro);
		panelVertical1.add(panelHorizontalEstudiante);
		panelVertical1.add(panelHorizontalGrupo);
		panelVertical1.add(panelHorizontalInicio);
		panelVertical1.add(panelHorizontalFinal);
		panelVertical1.add(Realizar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Realizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!InputNro.getText().isEmpty() && !InputEstudiante.getText().isEmpty() && !InputGrupo.getText().isEmpty() && !InputInicio.getText().isEmpty() && !InputFinal.getText().isEmpty()) {
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
		JPanel panelHorizontal1 = new JPanel();
		JPanel panelHorizontal2 = new JPanel();
		JPanel panelHorizontal3 = new JPanel();
		
		JLabel label1 = new JLabel("Selecciona tu tema de fondo");
		JLabel label2 = new JLabel("Selecciona tu tema para los botones");
		
		JButton Aplicar = new JButton("Aplicar cambios");
		JButton Revertir = new JButton("Revertir cambios");
		
		JCheckBox AplicarFondoBarraHerramienta = new JCheckBox("Aplicar a los botones de la barra de herramientas");
		
		
		//setters
		FcambiarColorTexto(label1, Temas[colorIndex].getLetras());
		FcambiarColorTexto(label2, Temas[colorIndex].getLetras());
		FcambiarColorTexto(AplicarFondoBarraHerramienta, Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Aplicar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Revertir, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical1.setOpaque(false);
		
		panelHorizontal1.setLayout(new BoxLayout(panelHorizontal1, BoxLayout.X_AXIS));
		panelHorizontal1.setOpaque(false);
		
		panelHorizontal2.setLayout(new BoxLayout(panelHorizontal2, BoxLayout.X_AXIS));
		panelHorizontal2.setOpaque(false);
		
		panelHorizontal3.setLayout(new BoxLayout(panelHorizontal3, BoxLayout.X_AXIS));
		panelHorizontal3.setOpaque(false);
		
		AplicarFondoBarraHerramienta.setToolTipText("Aplica el color que tengas seleccionado para el tema de fondo en la barra de herramientas");
		AplicarFondoBarraHerramienta.setOpaque(false);
		
		Aplicar.setToolTipText("Presiona para aplicar los cambios que hayas realizado");
		
		Revertir.setToolTipText("Presiona para revertir TODOS los cambios de los temas que hayas realizado");
		
		
		//adds
		panelVertical1.add(panelHorizontal1);
		panelVertical1.add(panelHorizontal2);
		panelVertical1.add(AplicarFondoBarraHerramienta);
		panelVertical1.add(panelHorizontal3);
		
		panelHorizontal1.add(label1);
		panelHorizontal1.add(temasEleccion);
		
		panelHorizontal2.add(label2);
		panelHorizontal2.add(temasEleccionBotones);
		
		panelHorizontal3.add(Aplicar);
		panelHorizontal3.add(Revertir);
		
		
		//Eventos
		Aplicar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorIndex = temasEleccion.getSelectedIndex();
				colorIndexBotones = temasEleccionBotones.getSelectedIndex();
				
				//Tema para PanelPadre y Panel Local
				PanelPadre.setBackground(Temas[colorIndex].getFondo());
				PanelLocal.setBackground(Temas[colorIndex].getFondo());
				
				//Cambia botones y label del menu de configuracion
				FcambiarColorTexto(label1, Temas[colorIndex].getLetras());
				FcambiarColorTexto(label2, Temas[colorIndex].getLetras());
				FcambiarColorTexto(AplicarFondoBarraHerramienta, Temas[colorIndex].getLetras());
				FhacerRedondeado(Aplicar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
				FhacerRedondeado(Revertir, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
				
				//Aplica el cambio de los temas a todo lo demas
				FhacerRedondeado(btnRegistrarLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnRegistrarComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnBajaLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnBajaComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarPrestamoLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarPrestamoComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnPrestamoLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnPrestamoComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnConfiguracionTemas, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnConfiguracionHistorial, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnOtrosManual, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				
				//Si esta precionado entonces cambia de color la barra que esta detras de los botones
				if (AplicarFondoBarraHerramienta.isSelected()) {
					FcambiarColorFondo(menuRegistrar, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuBaja, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuListar, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuPrestamo, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuConfiguracion, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuOtros, Temas[colorIndex].getFondo());
					
				}
				
			}
		});
		
		Revertir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Tema para PanelPadre y Panel Local
				PanelPadre.setBackground(Temas[0].getFondo());
				PanelLocal.setBackground(Temas[0].getFondo());

				//Cambia botones y label del menu de configuracion
				FcambiarColorTexto(label1, Temas[0].getLetras());
				FcambiarColorTexto(label2, Temas[0].getLetras());
				FcambiarColorTexto(AplicarFondoBarraHerramienta, Temas[0].getLetras());
				FhacerRedondeado(Aplicar, Temas[0].getBotones(), Temas[0].getLetras());

				//Aplica el cambio de los temas a todo lo demas
				FhacerRedondeado(btnRegistrarLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnRegistrarComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnBajaLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnBajaComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarPrestamoLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarPrestamoComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnPrestamoLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnPrestamoComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnConfiguracionTemas, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnConfiguracionHistorial, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnOtrosManual, Temas[0].getBotones(), Temas[0].getLetras());

				//Si esta presionado entonces cambia de color la barra que esta detras de los botones
				FcambiarColorFondo(menuRegistrar, Temas[0].getFondo());
				FcambiarColorFondo(menuBaja, Temas[0].getFondo());
				FcambiarColorFondo(menuListar, Temas[0].getFondo());
				FcambiarColorFondo(menuPrestamo, Temas[0].getFondo());
				FcambiarColorFondo(menuConfiguracion, Temas[0].getFondo());
				FcambiarColorFondo(menuOtros, Temas[0].getFondo());
				
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
	
	
	
	public static void FConfiguracionHistorial() {
		
	}
	
	
	
	public static void FManualUsuario() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		
		JLabel labelResultado = new JLabel("Manual no disponible...");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical1.setOpaque(false);
		
		FcambiarColorTexto(labelResultado, Temas[colorIndex].getLetras());
		
		
		//adds
		panelVertical1.add(labelResultado);
		
		
		//Se visualiza en la ventana
		FestablecePaneles(true, false);
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
	
	
	
	/*
	 * FUNCION: FestablecePaneles
	 * INPUT: boolean panel1, boolean panel2
	 * OUTPUT:
	 * 
	 * Esta funcion esta diseñada para que se establezca que paneles mostrar y que paneles no mostrar, estableciendo
	 * verdadera una u otra
	 * 
	 * -Franco
	 */
	public static void FestablecePaneles(boolean panel1, boolean panel2) {
		PanelLocal.setVisible(panel1);
		PanelTabla.setVisible(panel2);
	}
	
	
	
	/**
     * Aplica estilo redondeado a un JButton con un color base y efectos de hover y presionado.
     *
     * @param b          El JButton al que se le aplicará el estilo.
     * @param colorBase  El color base del botón.
     *
     * Nota:
     * - El radio de redondeo se ajusta en la variable local 'radioEsquinas'.
     * - El tamaño del botón se configura con setPreferredSize() fuera de esta función.
     * 
     * -ChatGPT
     */
	public static void FhacerRedondeado(JButton b, Color fondoNormal, Color textoNormal) {

        int radioEsquinas = 20; // Ajusta este valor para el redondeo

        // Calcular automáticamente colores derivados
        Color fondoHover = Faclarar(fondoNormal, 0.15f);
        Color fondoPresionado = Foscurecer(fondoNormal, 0.2f);

        b.setContentAreaFilled(false);
        b.setOpaque(false);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setBorder(null);

        b.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = c.getWidth();
                int h = c.getHeight();

                // Detectar estado del botón
                ButtonModel model = ((AbstractButton) c).getModel();
                Color colorFondo = fondoNormal;
                Color colorTexto = textoNormal;

                if (model.isPressed()) {
                    colorFondo = fondoPresionado;
                    colorTexto = FajustarContraste(colorFondo);
                } else if (model.isRollover()) {
                    colorFondo = fondoHover;
                    colorTexto = FajustarContraste(colorFondo);
                }

                // Dibujar fondo redondeado
                g2.setColor(colorFondo);
                g2.fillRoundRect(0, 0, w, h, radioEsquinas, radioEsquinas);

                g2.dispose();

                // Cambiar color del texto según contraste
                ((AbstractButton) c).setForeground(colorTexto);

                // Pintar texto
                super.paint(g, c);
            }
        });
    }
	
	
	
	/**
     * Aclara un color sumando un porcentaje hacia blanco.
     *
     * @param c      Color original.
     * @param factor Factor de aclarado (0.0f a 1.0f). Ej: 0.15f aclara un 15%.
     * @return Nuevo color aclarado.
     * 
     * -ChatGPT
     */
	private static Color Faclarar(Color c, float factor) {
        int r = (int) (c.getRed() + (255 - c.getRed()) * factor);
        int g = (int) (c.getGreen() + (255 - c.getGreen()) * factor);
        int b = (int) (c.getBlue() + (255 - c.getBlue()) * factor);
        return new Color(Fclamp(r), Fclamp(g), Fclamp(b), c.getAlpha());
    }
	
	
	
    /**
     * Oscurece un color multiplicando sus componentes por (1 - factor).
     *
     * @param c      Color original.
     * @param factor Factor de oscurecimiento (0.0f a 1.0f). Ej: 0.2f oscurece un 20%.
     * @return Nuevo color oscurecido.
     * 
     * -ChatGPT
     */
	private static Color Foscurecer(Color c, float factor) {
        int r = (int) (c.getRed() * (1 - factor));
        int g = (int) (c.getGreen() * (1 - factor));
        int b = (int) (c.getBlue() * (1 - factor));
        return new Color(Fclamp(r), Fclamp(g), Fclamp(b), c.getAlpha());
    }
	
	
	/*
	 * 
	 */
	private static Color FajustarContraste(Color c) {
        double lum = 0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue();
        return lum < 140 ? Color.WHITE : Color.BLACK;
    }
	
	
	
    /**
     * Limita un valor entre 0 y 255 para evitar desbordes en componentes RGB.
     *
     * @param v Valor a limitar.
     * @return Valor ajustado entre 0 y 255.
     * 
     * -ChatGPT
     */
    private static int Fclamp(int v) {
        return Math.max(0, Math.min(255, v));
    }
    
    
    
    public static void FNegrita(JComponent componente, int tamano) {
		Font fuenteActual = componente.getFont();
		Font fuenteNegrita = new Font(fuenteActual.getName(), Font.BOLD, tamano);
		componente.setFont(fuenteNegrita);
	}
    
    
    
}