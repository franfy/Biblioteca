package Biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;


import javax.swing.plaf.basic.BasicButtonUI;

public class WMenuPrincipal extends JFrame{

	/*
	 * Esta parte del código, desde la línea 24 hasta la 62 son parte de las funcionalidades que SIEMPRE están disponibles
	 * a todo minuto del programa, ya sea para la personalización o acceder a algún dato o método.
	 * 
	 * -Franco
	 */
	
	//Imports para el funcionamiento de la GUI
	protected static JPanel PanelPadre = new JPanel(new BorderLayout());
	protected static JPanel PanelLocal = new JPanel(new GridBagLayout());
	protected static JPanel PanelTabla = new JPanel(new BorderLayout());
	protected static LGestor logica = new LGestor();
	
	//Imports de la ventana principal
	protected static JTabbedPane herramientas = new JTabbedPane(JTabbedPane.TOP);
	
	protected static JPanel menuRegistrar = new JPanel();
	protected static JPanel menuListar = new JPanel();
	protected static JPanel menuPrestamo = new JPanel();
	protected static JPanel menuConfiguracion = new JPanel();
	protected static JPanel menuOtros = new JPanel();
	
	protected static JButton btnRegistrarLibro = new JButton("Registrar Libro");
	protected static JButton btnRegistrarComputadora = new JButton("Registrar Computadora");
	protected static JButton btnRegistrarImpresion = new JButton("Registrar Impresion");
	protected static JButton btnRegistrarPrestamoLibro = new JButton("Hacer prestamo de Libro");
	protected static JButton btnRegistrarPrestamoComputadora = new JButton("Hacer prestamo de Computadora");
	protected static JButton btnListarLibro = new JButton("Listar Libros");
	protected static JButton btnListarComputadora = new JButton("Listar Computadora");
	protected static JButton btnListarImpresion = new JButton("Listar Impresiones");
	protected static JButton btnListarPrestamoLibro = new JButton("Listar Prestamos de Libros");
	protected static JButton btnListarPrestamoComputadora = new JButton("Listar Prestamos de Computadoras");
	protected static JButton btnConfiguracionTemas = new JButton("Temas");
	protected static JButton btnOtrosManual = new JButton("Acceder al manual de usuario");
	
	
	//Objetos para la personalizacion del programa
	protected static Tema[] Temas = { /* Fondo, Botones, Letras, Seleccionado*/
		    new Tema(Color.WHITE, new Color(180,180,180), Color.BLACK, new Color(130,130,130)),// Claro
		    new Tema(new Color(32,32,32), new Color(64,64,64), new Color(224,244,244), new Color(120,120,120)),// Oscuro
		    new Tema(new Color(51,153,255), new Color(45,125,200), new Color(32,32,32), new Color(20,90,155)),// Celeste
		    new Tema(new Color(15,138,76),new Color(10, 100, 10), Color.BLACK, new Color(30,130,0)),// Verde
		    new Tema(new Color(3,187,133),new Color(5,210,150), Color.BLACK, new Color(30,150,120)),// Verde Aqua
		};
	protected static String[] coloresNombres = {"Claro", "Oscuro", "Celeste", "Verde", "Verde Aqua"};
	protected static int colorIndex;
	protected static int colorIndexBotones;
	protected static JComboBox temasEleccion = new JComboBox(coloresNombres);
	protected static JComboBox temasEleccionBotones = new JComboBox(coloresNombres);
	
	
	
	/*
	 * Desde la línea 72 hasta la línea 91 solo sirven para poder hacer funcionar el programa llamándolo desde la clase
	 * LGestor y establecer los valores de la ventana.
	 * 
	 * -Franco
	 */
	public WMenuPrincipal() {

		
		// Configuracion de la Ventana
		this.setTitle("Biblioteca Pan de Azúcar");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		
		// Se muestra la ventana
		PanelPadre.add(PanelLocal);
		this.add(PanelPadre);
		
		
		// Llamado a las funciones
		FTab();
		
	}
	
	
	/*
	 * FUNCION: FTab
	 * INPUT: 
	 * OUTPUT:
	 * 
	 * Esta función es encargada de hacer que la interfaz sea funcional, integrando un JTabbedPane llamado "herramientas"
	 * y sus elementos, que representan todas las funciones del programa, desde el "Registrar Libro" hasta el manual de 
	 * usuario.
	 * 
	 * Cada botón en el JTabbedPane tiene un evento (Action Listener) que llama a la funcion a la que el nombre del botón
	 * hace referencia: btnRegistrarLibro ---> llama ---> FRegistrarLibro()
	 * 
	 * -Franco
	 * 
	 */
	public static void FTab() {
		
		
		//Imports
		//Presentes antes del constructor. Línea 22 hasta 60
		
		
		//Setters
		menuRegistrar.setLayout(new BoxLayout(menuRegistrar, BoxLayout.X_AXIS));
		menuListar.setLayout(new BoxLayout(menuListar, BoxLayout.X_AXIS));
		menuPrestamo.setLayout(new BoxLayout(menuPrestamo, BoxLayout.X_AXIS));
		menuConfiguracion.setLayout(new BoxLayout(menuConfiguracion, BoxLayout.X_AXIS));
		menuOtros.setLayout(new BoxLayout(menuOtros, BoxLayout.X_AXIS));
		
		FhacerRedondeado(btnRegistrarLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnRegistrarComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnRegistrarImpresion, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnRegistrarPrestamoLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnRegistrarPrestamoComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarImpresion, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarPrestamoLibro, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnListarPrestamoComputadora, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnConfiguracionTemas, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(btnOtrosManual, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		FNegrita(btnRegistrarLibro, 16);
		FNegrita(btnRegistrarComputadora, 16);
		FNegrita(btnRegistrarImpresion, 16);
		FNegrita(btnListarLibro, 16);
		FNegrita(btnListarComputadora, 16);
		FNegrita(btnListarImpresion, 16);
		FNegrita(btnListarPrestamoLibro, 16);
		FNegrita(btnListarPrestamoComputadora, 16);
		FNegrita(btnConfiguracionTemas, 16);
		FNegrita(btnRegistrarPrestamoLibro, 16);
		FNegrita(btnRegistrarPrestamoComputadora, 16);
		FNegrita(btnOtrosManual, 16);
		
		
		//Adds
		menuRegistrar.add(btnRegistrarLibro);
		menuRegistrar.add(btnRegistrarComputadora);
		menuRegistrar.add(btnRegistrarImpresion);
		
		menuListar.add(btnListarLibro);
		menuListar.add(btnListarComputadora);
		menuListar.add(btnListarImpresion);
		menuListar.add(btnListarPrestamoLibro);
		menuListar.add(btnListarPrestamoComputadora);
		
		menuPrestamo.add(btnRegistrarPrestamoLibro);
		menuPrestamo.add(btnRegistrarPrestamoComputadora);
		
		menuConfiguracion.add(btnConfiguracionTemas);
		
		menuOtros.add(btnOtrosManual);
		
		herramientas.add("Registrar", menuRegistrar);
		herramientas.add("Listar", menuListar);
		herramientas.add("Prestamos", menuPrestamo);
		herramientas.add("Configuracion", menuConfiguracion);
		herramientas.add("Otros", menuOtros);
		
		
		//Eventos
		herramientas.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				FestablecePaneles(false, false);
			}
		});
		
		
		btnRegistrarLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnRegistrarLibro, Temas[colorIndexBotones].getSeleccionado());
				FRegistrarLibro();
			}
		});
		
		
		btnRegistrarComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnRegistrarComputadora, Temas[colorIndexBotones].getSeleccionado());
				FRegistrarComputadora();
			}
		});
		
		btnRegistrarImpresion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnRegistrarImpresion, Temas[colorIndexBotones].getSeleccionado());
				FRegistrarImpresion();
			}
		});
		
		btnListarLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnListarLibro, Temas[colorIndexBotones].getSeleccionado());
				FListarLibro();
			}
		});
		
		btnListarComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnListarComputadora, Temas[colorIndexBotones].getSeleccionado());
				FListarComputadora();
			}
		});
		
		btnListarImpresion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnListarImpresion, Temas[colorIndexBotones].getSeleccionado());
				FListarImpresion();
			}
		});
		
		btnListarPrestamoLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnListarPrestamoLibro, Temas[colorIndexBotones].getSeleccionado());
				FListarPrestamoLibro();
			}
		});
		
		btnListarPrestamoComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnListarPrestamoComputadora, Temas[colorIndexBotones].getSeleccionado());
				FListarPrestamoComputadora();
			}
		});
		
		btnRegistrarPrestamoLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnRegistrarPrestamoLibro, Temas[colorIndexBotones].getSeleccionado());
				FRegistrarPrestamoLibro();
			}
		});
		
		btnRegistrarPrestamoComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnRegistrarPrestamoComputadora, Temas[colorIndexBotones].getSeleccionado());
				FRegistrarPrestamoComputadora();
			}
		});
		
		btnConfiguracionTemas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnConfiguracionTemas, Temas[colorIndexBotones].getSeleccionado());
				FConfiguracionTemas();
				
			}
		});
		
		btnOtrosManual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FCambiarColorSeleccionado(btnOtrosManual, Temas[colorIndexBotones].getSeleccionado());
				FManualUsuario();
			}
		});
		
		PanelPadre.add(herramientas, BorderLayout.NORTH);
		
	}
	
	
	
	
	/*
	 * FUNCION: FRegistrarLibro
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Esta función se encarga de recopilar los datos para poder ingresar un libro y luego pasarlos a la capa lógica.
	 * 
	 * Desde esta función en adelante, siempre habrá un orden en el que la interfaz se manejará. Cada espacio para ingresar
	 * datos está conformado por un JPanel, un JLabel y un JTextField.
	 * 
	 * Al panel se le aplica un BoxLayout en horizontal para luego añadir el JLabel y el JTextField correspondiente.
	 * 
	 * También hay un panel extra (panelVertical1) que se encarga de agrupar todos los elementos en vertical con un 
	 * BoxLayout en vertical.
	 * 
	 * Como últimos pasos, hay un JButton y un JLabel encargados de enviar la información a la capa lógica mediante un 
	 * evento (ActionListener) y mostrar el resultado de si el proceso fue exitoso o no (respectivamente).
	 * 
	 * Como extra podemos agregar que el código lleva una estructura con casi total totalidad que consiste en: Variables y 
	 * arrays, Imports, Setters y Getters, Adds, Eventos y el momento en donde todos los elementos previamente establecidos
	 * son visualizados en la pantalla mediante el uso del PanelPadre y PanelLocal (El PanelTabla es usado para las tablas
	 * con las que más tarde se hace el listado de datos).
	 * 
	 * Esta misma estructura es utilizada en todas las demás funciones (con algunas excepciones concretas).
	 * 
	 * -Franco
	 */
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
		JPanel panelHorizontalObservacion = new JPanel();
		
		JLabel LabelISBN = new JLabel("ISBN");
		JLabel LabelTitulo = new JLabel("Titulo");
		JLabel LabelAutor = new JLabel("Autor");
		JLabel LabelGenero = new JLabel("Genero");
		JLabel LabelMateria = new JLabel("Materia");
		JLabel LabelPais = new JLabel("Pais");
		JLabel LabelCantidad = new JLabel("Cantidad");
		JLabel LabelObservacion = new JLabel("Observacion");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputTitulo = new JTextField(6);
		JTextField InputAutor = new JTextField(6);
		JTextField InputGenero = new JTextField(6);
		JTextField InputMateria = new JTextField(6);
		JTextField InputCantidad = new JTextField(6);
		JTextField InputPais = new JTextField(6);
		JTextField InputObservacion = new JTextField("Opcional",6);
		
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
		panelHorizontalObservacion.setLayout(new BoxLayout(panelHorizontalObservacion, BoxLayout.X_AXIS));
		
		LabelISBN.setForeground(Temas[colorIndex].getLetras());
		LabelTitulo.setForeground(Temas[colorIndex].getLetras());
		LabelAutor.setForeground(Temas[colorIndex].getLetras());
		LabelGenero.setForeground(Temas[colorIndex].getLetras());
		LabelMateria.setForeground(Temas[colorIndex].getLetras());
		LabelCantidad.setForeground(Temas[colorIndex].getLetras());
		LabelPais.setForeground(Temas[colorIndex].getLetras());
		LabelObservacion.setForeground(Temas[colorIndex].getLetras());
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
		
		panelHorizontalObservacion.add(LabelObservacion);
		panelHorizontalObservacion.add(InputObservacion);
		panelHorizontalObservacion.setOpaque(false);
		
		panelVertical1.add(panelHorizontalISBN);
		panelVertical1.add(panelHorizontalTitulo);
		panelVertical1.add(panelHorizontalAutor);
		panelVertical1.add(panelHorizontalGenero);
		panelVertical1.add(panelHorizontalMateria);
		panelVertical1.add(panelHorizontalCantidad);
		panelVertical1.add(panelHorizontalPais);
		panelVertical1.add(panelHorizontalObservacion);
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
					InputCantidad.getText(), 
					InputPais.getText(), 
					InputObservacion.getText());	
				if (res == true) {
					LabelResultado.setText("¡Todo salió bien!");
				} else {
					LabelResultado.setText("¡Hay campos vacíos o no válidos!");
				}
			}
		});
		
		InputObservacion.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputObservacion.getText().equals("")) {
					InputObservacion.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputObservacion.getText().equals("Opcional")) {
					InputObservacion.setText("");
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
	
	
	
	/*
	 * FUNCION: FRegistrarComputadora
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Esta función cumple la labor de recopilar los datos para las computadoras y mas tarde mandarla a la capa lógica
	 * 
	 * -Franco
	 */
	public static void FRegistrarComputadora() {
		
		
		//imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontalNro = new JPanel();
		JPanel panelHorizontalObservacion = new JPanel();
		
		JLabel LabelNro = new JLabel("Numero de computadora");
		JLabel LabelObservacion = new JLabel("Observacion");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputNro = new JTextField(6);
		JTextField InputObservacion = new JTextField("Opcional",6);
		
		JButton Registrar = new JButton("Registrar Computadora");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalNro.setLayout(new BoxLayout(panelHorizontalNro, BoxLayout.X_AXIS));
		panelHorizontalObservacion.setLayout(new BoxLayout(panelHorizontalObservacion, BoxLayout.X_AXIS));
		
		LabelNro.setForeground(Temas[colorIndex].getLetras());
		LabelObservacion.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Registrar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		panelHorizontalNro.add(LabelNro);
		panelHorizontalNro.add(InputNro);
		panelHorizontalNro.setOpaque(false);
		
		panelHorizontalObservacion.add(LabelObservacion);
		panelHorizontalObservacion.add(InputObservacion);
		panelHorizontalObservacion.setOpaque(false);
		
		panelVertical1.add(panelHorizontalNro);
		panelVertical1.add(panelHorizontalObservacion);
		panelVertical1.add(Registrar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var res = logica.SubirComputadora(InputNro.getText(), InputObservacion.getText());
				if (res == true) {
					LabelResultado.setText("¡Todo salió bien!");
				} else {
					LabelResultado.setText("¡Hay campos vacíos o no válidos!");
				}
			}
		});
		
		InputObservacion.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputObservacion.getText().equals("")) {
					InputObservacion.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputObservacion.getText().equals("Opcional")) {
					InputObservacion.setText("");
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
	
	
	
	/*
	 * FUNCION:
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Similar a las anteriores funciones, esta se encarga de recopilar los datos necesarios para las impresiones.
	 */
	public static void FRegistrarImpresion() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontalMonto = new JPanel();
		JPanel panelHorizontalCantidadImpresiones = new JPanel();
		
		JLabel LabelMonto = new JLabel("Monto de la impresion");
		JLabel LabelCantidadImpresiones = new JLabel("Cantidad de impresiones");
		JLabel LabelResultado = new JLabel();
		
		JTextField InputMonto = new JTextField(6);
		JTextField InputCantidadImpresiones = new JTextField(6);
		
		JButton boton = new JButton("Registrar");
		
		
		//Setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalMonto.setLayout(new BoxLayout(panelHorizontalMonto, BoxLayout.X_AXIS));
		panelHorizontalCantidadImpresiones.setLayout(new BoxLayout(panelHorizontalCantidadImpresiones, BoxLayout.X_AXIS));
		
		FhacerRedondeado(boton, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		LabelMonto.setForeground(Temas[colorIndex].getLetras());
		LabelCantidadImpresiones.setForeground(Temas[colorIndex].getLetras());
		
		
		//Adds
		panelHorizontalMonto.add(LabelMonto);
		panelHorizontalMonto.add(InputMonto);
		panelHorizontalMonto.setOpaque(false);
		
		panelHorizontalCantidadImpresiones.add(LabelCantidadImpresiones);
		panelHorizontalCantidadImpresiones.add(InputCantidadImpresiones);
		panelHorizontalCantidadImpresiones.setOpaque(false);
		
		panelVertical1.add(panelHorizontalMonto);
		panelVertical1.add(panelHorizontalCantidadImpresiones);
		panelVertical1.add(boton);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		//Eventos
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var res = logica.SubirImpresion(InputMonto.getText(), InputCantidadImpresiones.getText());
				if (res == true) {
					LabelResultado.setText("!Todo salió bien!");
				} else {
					LabelResultado.setText("¡Hay campos vacíos o no válidos!");
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
	
	
	
	/*
	 * FUNCION: FRegistrarPrestamoLibro
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Esta función se encarga de recopilar los datos extra necesarios para realizar los préstamos de los libros.
	 * 
	 */
	public static void FRegistrarPrestamoLibro() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontalISBN = new JPanel();
		JPanel panelHorizontalEstudiante = new JPanel();
		JPanel panelHorizontalApellido = new JPanel();
		JPanel panelHorizontalMail = new JPanel();
		JPanel panelHorizontalTelefono = new JPanel();
		JPanel panelHorizontalGrupo = new JPanel();
		JPanel panelHorizontalDevolucion = new JPanel();
		
		JLabel LabelResultado = new JLabel();
		JLabel LabelISBN = new JLabel("Ingrese el ISBN del libro");
		JLabel LabelEstudiante = new JLabel("Nombre del Estudiante");
		JLabel LabelApellido = new JLabel("Apellido del Estudiante");
		JLabel LabelMail = new JLabel("Correo electrónico del Estudiante");
		JLabel LabelTelefono = new JLabel("Número de Teléfono del Estudiante");
		JLabel LabelGrupo = new JLabel("Grupo del Estudiante");
		JLabel LabelDevolucion = new JLabel("Ingrese la fecha de devolución (dd/mm/yyyy)");
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputEstudiante = new JTextField(6);
		JTextField InputApellido = new JTextField("Opcional",6);
		JTextField InputMail = new JTextField("Opcional",6);
		JTextField InputTelefono = new JTextField("Opcional",6);
		JTextField InputGrupo = new JTextField(6);
		JTextField InputDevolucion = new JTextField(6);
		
		JButton Realizar = new JButton("Realizar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalISBN.setLayout(new BoxLayout(panelHorizontalISBN, BoxLayout.X_AXIS));
		panelHorizontalEstudiante.setLayout(new BoxLayout(panelHorizontalEstudiante, BoxLayout.X_AXIS));
		panelHorizontalApellido.setLayout(new BoxLayout(panelHorizontalApellido, BoxLayout.X_AXIS));
		panelHorizontalMail.setLayout(new BoxLayout(panelHorizontalMail, BoxLayout.X_AXIS));
		panelHorizontalTelefono.setLayout(new BoxLayout(panelHorizontalTelefono, BoxLayout.X_AXIS));
		panelHorizontalGrupo.setLayout(new BoxLayout(panelHorizontalGrupo, BoxLayout.X_AXIS));
		panelHorizontalDevolucion.setLayout(new BoxLayout(panelHorizontalDevolucion, BoxLayout.X_AXIS));
		
		LabelISBN.setForeground(Temas[colorIndex].getLetras());
		LabelEstudiante.setForeground(Temas[colorIndex].getLetras());
		LabelApellido.setForeground(Temas[colorIndex].getLetras());
		LabelMail.setForeground(Temas[colorIndex].getLetras());
		LabelTelefono.setForeground(Temas[colorIndex].getLetras());
		LabelGrupo.setForeground(Temas[colorIndex].getLetras());
		LabelDevolucion.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		FhacerRedondeado(Realizar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		panelHorizontalISBN.add(LabelISBN);
		panelHorizontalISBN.add(InputISBN);	
		panelHorizontalISBN.setOpaque(false);
		
		panelHorizontalEstudiante.add(LabelEstudiante);
		panelHorizontalEstudiante.add(InputEstudiante);
		panelHorizontalEstudiante.setOpaque(false);
		
		panelHorizontalApellido.add(LabelApellido);
		panelHorizontalApellido.add(InputApellido);
		panelHorizontalApellido.setOpaque(false);
		
		panelHorizontalMail.add(LabelMail);
		panelHorizontalMail.add(InputMail);
		panelHorizontalMail.setOpaque(false);
		
		panelHorizontalTelefono.add(LabelTelefono);
		panelHorizontalTelefono.add(InputTelefono);
		panelHorizontalTelefono.setOpaque(false);
		
		panelHorizontalGrupo.add(LabelGrupo);
		panelHorizontalGrupo.add(InputGrupo);
		panelHorizontalGrupo.setOpaque(false);
		
		panelHorizontalDevolucion.add(LabelDevolucion);
		panelHorizontalDevolucion.add(InputDevolucion);
		panelHorizontalDevolucion.setOpaque(false);
		
		panelVertical1.add(panelHorizontalISBN);
		panelVertical1.add(panelHorizontalEstudiante);
		panelVertical1.add(panelHorizontalApellido);
		panelVertical1.add(panelHorizontalMail);
		panelVertical1.add(panelHorizontalTelefono);
		panelVertical1.add(panelHorizontalGrupo);
		panelVertical1.add(panelHorizontalDevolucion);
		panelVertical1.add(Realizar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Realizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var res = logica.SubirPrestamoLibro(InputISBN.getText(), InputEstudiante.getText(), InputApellido.getText(), InputMail.getText(), InputTelefono.getText(), InputGrupo.getText(), InputDevolucion.getText());
				if (res == true) {
					LabelResultado.setText("¡Todo salió bien!");
				} else {
					LabelResultado.setText("¡Hay campos vacíos o no válidos!");
				}
			}
		});
		
		
		InputApellido.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputApellido.getText().equals("")) {
					InputApellido.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputApellido.getText().equals("Opcional")) {
					InputApellido.setText("");
				}
			}
		});
		
		
		InputMail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputMail.getText().equals("")) {
					InputMail.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputMail.getText().equals("Opcional")) {
					InputMail.setText("");
				}
			}
		});
		
		
		InputTelefono.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputTelefono.getText().equals("")) {
					InputTelefono.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputTelefono.getText().equals("Opcional")) {
					InputTelefono.setText("");
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
	
	
	
	/*
	 * FUNCION: FRegistrarPrestamoComputadora
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Esta función se encarga de recopilar los datos extra necesarios para realizar los préstamos de las computadoras.
	 * 
	 */
	public static void FRegistrarPrestamoComputadora() {
	
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		JPanel panelHorizontalNro = new JPanel();
		JPanel panelHorizontalEstudiante = new JPanel();
		JPanel panelHorizontalApellido = new JPanel();
		JPanel panelHorizontalMail = new JPanel();
		JPanel panelHorizontalTelefono = new JPanel();
		JPanel panelHorizontalGrupo = new JPanel();
		JPanel panelHorizontalDevolucion = new JPanel();
		
		JLabel LabelResultado = new JLabel();
		JLabel LabelNro = new JLabel("Ingrese el Nro de la Computadora");
		JLabel LabelEstudiante = new JLabel("Nombre del Estudiante");
		JLabel LabelApellido = new JLabel("Apellido del Estudiante");
		JLabel LabelMail = new JLabel("Correo electrónico del Estudiante");
		JLabel LabelTelefono = new JLabel("Número de Teléfono del Estudiante");
		JLabel LabelGrupo = new JLabel("Grupo del Estudiante");
		JLabel LabelDevolucion = new JLabel("Ingrese la fecha de devolución (dd/mm/yyyy)");
		
		JTextField InputNro = new JTextField(6);
		JTextField InputEstudiante = new JTextField(6);
		JTextField InputApellido = new JTextField("Opcional",6);
		JTextField InputMail = new JTextField("Opcional",6);
		JTextField InputTelefono = new JTextField("Opcional",6);
		JTextField InputGrupo = new JTextField(6);
		JTextField InputDevolucion = new JTextField(6);
		
		JButton Realizar = new JButton("Realizar");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelHorizontalNro.setLayout(new BoxLayout(panelHorizontalNro, BoxLayout.X_AXIS));
		panelHorizontalEstudiante.setLayout(new BoxLayout(panelHorizontalEstudiante, BoxLayout.X_AXIS));
		panelHorizontalApellido.setLayout(new BoxLayout(panelHorizontalApellido, BoxLayout.X_AXIS));
		panelHorizontalMail.setLayout(new BoxLayout(panelHorizontalMail, BoxLayout.X_AXIS));
		panelHorizontalTelefono.setLayout(new BoxLayout(panelHorizontalTelefono, BoxLayout.X_AXIS));
		panelHorizontalGrupo.setLayout(new BoxLayout(panelHorizontalGrupo, BoxLayout.X_AXIS));
		panelHorizontalDevolucion.setLayout(new BoxLayout(panelHorizontalDevolucion, BoxLayout.X_AXIS));
		
		FhacerRedondeado(Realizar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		LabelNro.setForeground(Temas[colorIndex].getLetras());
		LabelEstudiante.setForeground(Temas[colorIndex].getLetras());
		LabelApellido.setForeground(Temas[colorIndex].getLetras());
		LabelMail.setForeground(Temas[colorIndex].getLetras());
		LabelTelefono.setForeground(Temas[colorIndex].getLetras());
		LabelGrupo.setForeground(Temas[colorIndex].getLetras());
		LabelDevolucion.setForeground(Temas[colorIndex].getLetras());
		LabelResultado.setForeground(Temas[colorIndex].getLetras());
		
		panelHorizontalNro.add(LabelNro);
		panelHorizontalNro.add(InputNro);
		panelHorizontalNro.setOpaque(false);
		
		panelHorizontalEstudiante.add(LabelEstudiante);
		panelHorizontalEstudiante.add(InputEstudiante);
		panelHorizontalEstudiante.setOpaque(false);
		
		panelHorizontalApellido.add(LabelApellido);
		panelHorizontalApellido.add(InputApellido);
		panelHorizontalApellido.setOpaque(false);
		
		panelHorizontalMail.add(LabelMail);
		panelHorizontalMail.add(InputMail);
		panelHorizontalMail.setOpaque(false);
		
		panelHorizontalTelefono.add(LabelTelefono);
		panelHorizontalTelefono.add(InputTelefono);
		panelHorizontalTelefono.setOpaque(false);
		
		panelHorizontalGrupo.add(LabelGrupo);
		panelHorizontalGrupo.add(InputGrupo);
		panelHorizontalGrupo.setOpaque(false);
		
		panelHorizontalDevolucion.add(LabelDevolucion);
		panelHorizontalDevolucion.add(InputDevolucion);
		panelHorizontalDevolucion.setOpaque(false);
		
		//Adds
		panelVertical1.add(panelHorizontalNro);
		panelVertical1.add(panelHorizontalEstudiante);
		panelVertical1.add(panelHorizontalApellido);
		panelVertical1.add(panelHorizontalMail);
		panelVertical1.add(panelHorizontalTelefono);
		panelVertical1.add(panelHorizontalGrupo);
		panelVertical1.add(panelHorizontalDevolucion);
		panelVertical1.add(Realizar);
		panelVertical1.add(LabelResultado);
		panelVertical1.setOpaque(false);
		
		
		//eventos
		Realizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				var res = logica.SubirPrestamoComputadora(InputNro.getText(), InputEstudiante.getText(), InputApellido.getText(), InputMail.getText(), InputTelefono.getText(), InputGrupo.getText(), InputDevolucion.getText());
				if (res == true) {
					LabelResultado.setText("¡Todo salió bien!");
				} else {
					LabelResultado.setText("¡Hay campos vacíos o no válidos!");
				}
			}
		});
		
		InputApellido.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputApellido.getText().equals("")) {
					InputApellido.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputApellido.getText().equals("Opcional")) {
					InputApellido.setText("");
				}
			}
		});
		
		
		InputMail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputMail.getText().equals("")) {
					InputMail.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputMail.getText().equals("Opcional")) {
					InputMail.setText("");
				}
			}
		});
		
		
		InputTelefono.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (InputTelefono.getText().equals("")) {
					InputTelefono.setText("Opcional");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (InputTelefono.getText().equals("Opcional")) {
					InputTelefono.setText("");
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
	
	
	
	/*
	 * FUNCION: FListarLibro
	 * INPUT:
	 * OUTPUT:
	 * 
	 * Esta funcion sirve para poder listar los Libros registrados en la base de datos.
	 * 
	 * Se utiliza un array String[] columnas para definir las columnas y que datos van a mostrar en cada una 
	 * 
	 */
	public static void FListarLibro() {
		
		
		//variables & arrays
		String[] columnas = {"ISBN", "Título", "Autor", "Genero", "Materia", "Pais", "Cantidad", "Observaciones", "Hora de subida", "Fecha de subida"};
		ArrayList libros = new ArrayList();
		
		
		//Imports
		JPanel panelHorizontalBaja = new JPanel();
		JButton botonBaja = new JButton("Dar de baja Libro");
		
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//Setters
		panelHorizontalBaja.setLayout(new BoxLayout(panelHorizontalBaja, BoxLayout.X_AXIS));
		panelHorizontalBaja.setOpaque(false);
		FcambiarColorFondo(panelHorizontalBaja, Temas[colorIndex].getFondo());
		
		FhacerRedondeado(botonBaja, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		scroll.getViewport().setBackground(Temas[colorIndex].getFondo());
		tabla.setBackground(Temas[colorIndex].getFondo());
		tabla.setForeground(Temas[colorIndex].getLetras());
		
		//Adds
		panelHorizontalBaja.add(botonBaja);
		
		
		//Llamado
		logica.ListarLibro(modelo, libros);
		autoResizeColumns(tabla);
		
		
		//Eventos
		botonBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int sele = tabla.getSelectedRow();
					Object valorObj = tabla.getValueAt(sele, 0);
					String valor = String.valueOf(valorObj);
					logica.BajaLibro(valor);
					FListarLibro();
					
				} catch (Exception E) {
					
					JOptionPane.showMessageDialog(null, "Error, seleccione una fila antes de eliminar");
					
				}
				
			}
		});
        
        
        //Se visualiza en la ventana
        PanelPadre.add(PanelTabla, BorderLayout.CENTER);
        PanelTabla.removeAll();
        PanelTabla.add(panelHorizontalBaja, BorderLayout.SOUTH);
        PanelTabla.add(scroll);
        FestablecePaneles(false, true);
      	PanelPadre.revalidate();
      	PanelPadre.repaint();
        
	}
	
	
	
	public static void FListarComputadora() {
		
		
		//variables & arrays
		String[] columnas = {"Número de computadora", "Observaciones", "Hora de subida", "Fecha de subida"};
		ArrayList computadora = new ArrayList();
		
		
		//Imports
		JPanel panelHorizontalBaja = new JPanel();
		JButton botonBaja = new JButton("Dar de baja Computadora");
		
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		panelHorizontalBaja.setLayout(new BoxLayout(panelHorizontalBaja, BoxLayout.X_AXIS));
		panelHorizontalBaja.setOpaque(false);
		FcambiarColorFondo(panelHorizontalBaja, Temas[colorIndex].getFondo());
		
		FhacerRedondeado(botonBaja, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		scroll.getViewport().setBackground(Temas[colorIndex].getFondo());
		tabla.setBackground(Temas[colorIndex].getFondo());
		tabla.setForeground(Temas[colorIndex].getLetras());
		
		//adds
		panelHorizontalBaja.add(botonBaja);
		
		
		//Llamado
		logica.ListarComputadora(modelo, computadora);
		autoResizeColumns(tabla);
		

		//eventos
		botonBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int sele = tabla.getSelectedRow();
					Object valorObj = tabla.getValueAt(sele, 0);
					String valor = String.valueOf(valorObj);
					int neoNro = Integer.parseInt(valor);
					logica.BajaComputadora(neoNro);
					FListarComputadora();
					
				} catch (Exception E) {
					
					JOptionPane.showMessageDialog(null, "Error, seleccione una fila antes de eliminar");
					
				}
			}
		});
		
		
		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla, BorderLayout.CENTER);
        PanelTabla.removeAll();
        PanelTabla.add(panelHorizontalBaja, BorderLayout.SOUTH);
        PanelTabla.add(scroll);
        FestablecePaneles(false, true);
      	PanelPadre.revalidate();
      	PanelPadre.repaint();
	}
	
	
	
	public static void FListarImpresion() {
		
		
		//variables & arrays
		String[] columnas = {"Número de Impresión", "Precio", "Cantidad de hojas", "Hora de impresión", "Fecha de impresión"};
		ArrayList array = new ArrayList();
		
		
		//Imports
		JPanel panelHorizontalInferior = new JPanel();
		
		JButton botonBaja = new JButton("Dar de baja Impresiones");
		JButton botonMonto = new JButton("Sumar todos los montos");
		
		JLabel LabelMonto = new JLabel();
		
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		panelHorizontalInferior.setLayout(new BoxLayout(panelHorizontalInferior, BoxLayout.X_AXIS));
		FcambiarColorFondo(panelHorizontalInferior, Temas[colorIndex].getFondo());
		panelHorizontalInferior.setOpaque(false);
		
		FhacerRedondeado(botonBaja, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		FhacerRedondeado(botonMonto, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		scroll.getViewport().setBackground(Temas[colorIndex].getFondo());
		tabla.setBackground(Temas[colorIndex].getFondo());
		tabla.setForeground(Temas[colorIndex].getLetras());
		
		LabelMonto.setForeground(Temas[colorIndex].getLetras());
		
		
		//adds
		panelHorizontalInferior.add(botonBaja);
		panelHorizontalInferior.add(botonMonto);
		
		panelHorizontalInferior.add(Box.createHorizontalGlue());
		
		panelHorizontalInferior.add(LabelMonto);
		
		
		//Llamado
		logica.ListarImpresion(modelo, array);
		autoResizeColumns(tabla);
		

		//eventos
		botonBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int sele = tabla.getSelectedRow();
					System.out.println(sele);
					Object valorObj = tabla.getValueAt(sele, 0);
					String valor = String.valueOf(valorObj);
					int neoID = Integer.parseInt(valor);
					System.out.println(neoID);
					logica.BajaImpresion(neoID);
					FListarImpresion();
					
				} catch (Exception E) {
					
					JOptionPane.showMessageDialog(null, "Error, seleccione una fila antes de eliminar");
					
				}
				
			}
		});
		
		
		botonMonto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LabelMonto.setText("El resultado de la suma de todos los montos es: " + String.valueOf(logica.SumaMontoImpresion(tabla, tabla.getRowCount())) + "$");
				
			}
		});
		
		
		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla, BorderLayout.CENTER);
        PanelTabla.removeAll();
        PanelTabla.add(panelHorizontalInferior, BorderLayout.SOUTH);
        PanelTabla.add(scroll);
        FestablecePaneles(false, true);
      	PanelPadre.revalidate();
      	PanelPadre.repaint();
	}
	
	
	
	public static void FListarPrestamoLibro() {
		
		
		//variables & arrays
		String[] columnas = {"Número de Prestamo", "ISBN", "Nombre de la persona", "Apellido de la persona", "Grupo", "Mail", "Teléfono", "Observación", "Hora de subida", "Entrega", "Devolución"};
		ArrayList libros = new ArrayList();
		
		
		//Imports
		JPanel panelHorizontalBaja = new JPanel();
		JButton botonBaja = new JButton("Dar de baja Prestamo");
		
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		panelHorizontalBaja.setLayout(new BoxLayout(panelHorizontalBaja, BoxLayout.X_AXIS));
		FcambiarColorFondo(panelHorizontalBaja, Temas[colorIndex].getFondo());
		panelHorizontalBaja.setOpaque(false);
		
		FhacerRedondeado(botonBaja, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		scroll.getViewport().setBackground(Temas[colorIndex].getFondo());
		tabla.setBackground(Temas[colorIndex].getFondo());
		tabla.setForeground(Temas[colorIndex].getLetras());
		
		//adds
		panelHorizontalBaja.add(botonBaja);
		
		
		//Llamadas
		logica.ListarPrestamoLibro(modelo, libros);
		autoResizeColumns(tabla);
		
		
		//eventos
		botonBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int sele = tabla.getSelectedRow();
					System.out.println(sele);
					Object valorObj = tabla.getValueAt(sele, 0);
					String valor = String.valueOf(valorObj);
					int neoID = Integer.parseInt(valor);
					System.out.println(neoID);
					logica.BajaPrestamoLibro(neoID);
					FListarPrestamoLibro();
					
				} catch (Exception E) {
					
					JOptionPane.showMessageDialog(null, "Error, seleccione una fila antes de eliminar");
					
				}
				
			}
		});
		
		
		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla, BorderLayout.CENTER);
        PanelTabla.removeAll();
		PanelTabla.add(panelHorizontalBaja, BorderLayout.SOUTH);
		PanelTabla.add(scroll);
		FestablecePaneles(false, true);
		PanelPadre.revalidate();
		PanelPadre.repaint();
	}
	
	
	
	public static void FListarPrestamoComputadora() {
		
		
		//variables & arrays
		String[] columnas = {"Número de Prestamo", "Número de computadora", "Nombre de la persona", "Apellido de la persona", "Grupo", "Mail", "Teléfono", "Observacion", "Hora de subida", "Entrega", "Devolución"};
		ArrayList computadora = new ArrayList();
		
		
		//Imports
		JPanel panelHorizontalBaja = new JPanel();
		
		JButton botonBaja = new JButton("Dar de baja Prestamo");
		
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//setters
		panelHorizontalBaja.setLayout(new BoxLayout(panelHorizontalBaja, BoxLayout.X_AXIS));
		FcambiarColorFondo(panelHorizontalBaja, Temas[colorIndex].getFondo());
		
		panelHorizontalBaja.setOpaque(false);
		
		FhacerRedondeado(botonBaja, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		scroll.getViewport().setBackground(Temas[colorIndex].getFondo());
		tabla.setBackground(Temas[colorIndex].getFondo());
		tabla.setForeground(Temas[colorIndex].getLetras());
		
		
		//adds
		panelHorizontalBaja.add(botonBaja);
		
		
		//Llamadas
		logica.ListarPrestamoComputadora(modelo, computadora);
		autoResizeColumns(tabla);
		
		
		//eventos
		botonBaja.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			try {
				
				int sele = tabla.getSelectedRow();
				System.out.println(sele);
				Object valorObj = tabla.getValueAt(sele, 0);
				String valor = String.valueOf(valorObj);
				int neoID = Integer.parseInt(valor);
				System.out.println(neoID);
				logica.BajaPrestamoComputadora(neoID);
				FListarPrestamoComputadora();
				
			} catch (Exception E) {
				
				JOptionPane.showMessageDialog(null, "Error, seleccione una fila antes de eliminar");
				
			}
			
		}
	});
		
		
		//Se visualiza en la ventana
		PanelPadre.add(PanelTabla, BorderLayout.CENTER);
        PanelTabla.removeAll();
		PanelTabla.add(panelHorizontalBaja, BorderLayout.SOUTH);
		PanelTabla.add(scroll);
		FestablecePaneles(false, true);
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
		FcambiarColorTexto(AplicarFondoBarraHerramienta, Temas[colorIndexBotones].getLetras());
		
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
				FcambiarColorTexto(AplicarFondoBarraHerramienta, Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(Aplicar, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
				FhacerRedondeado(Revertir, Temas[colorIndex].getBotones(), Temas[colorIndex].getLetras());
				
				//Aplica el cambio de los temas a todo lo demas
				FhacerRedondeado(btnRegistrarLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnRegistrarComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnRegistrarImpresion, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnRegistrarPrestamoLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnRegistrarPrestamoComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarImpresion, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarPrestamoLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnListarPrestamoComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnConfiguracionTemas, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				FhacerRedondeado(btnOtrosManual, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
				
				//Si esta precionado entonces cambia de color la barra que esta detras de los botones
				if (AplicarFondoBarraHerramienta.isSelected()) {
					FcambiarColorFondo(menuRegistrar, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuListar, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuPrestamo, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuConfiguracion, Temas[colorIndex].getFondo());
					FcambiarColorFondo(menuOtros, Temas[colorIndex].getFondo());
					
				}
				
				FCambiarColorSeleccionado(btnRegistrarLibro, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarComputadora, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarImpresion, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarPrestamoLibro, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarPrestamoComputadora, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnListarLibro, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnListarComputadora, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnListarImpresion, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnListarPrestamoLibro, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnListarPrestamoComputadora, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnConfiguracionTemas, Temas[colorIndexBotones].getSeleccionado());
				FCambiarColorSeleccionado(btnOtrosManual, Temas[colorIndexBotones].getSeleccionado());
				
			}
		});
		
		Revertir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colorIndex = 0;
				colorIndexBotones = 0;
				
				
				//Tema para PanelPadre y Panel Local
				PanelPadre.setBackground(Temas[0].getFondo());
				PanelLocal.setBackground(Temas[0].getFondo());

				//Cambia botones y label del menu de configuracion
				FcambiarColorTexto(label1, Temas[0].getLetras());
				FcambiarColorTexto(label2, Temas[0].getLetras());
				FcambiarColorTexto(AplicarFondoBarraHerramienta, Temas[0].getLetras());
				FhacerRedondeado(Aplicar, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(Revertir, Temas[0].getBotones(), Temas[0].getLetras());

				//Aplica el cambio de los temas a todo lo demas
				FhacerRedondeado(btnRegistrarLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnRegistrarComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnRegistrarImpresion, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnRegistrarPrestamoLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnRegistrarPrestamoComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarImpresion, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarPrestamoLibro, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnListarPrestamoComputadora, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnConfiguracionTemas, Temas[0].getBotones(), Temas[0].getLetras());
				FhacerRedondeado(btnOtrosManual, Temas[0].getBotones(), Temas[0].getLetras());

				//Si esta presionado entonces cambia de color la barra que esta detras de los botones
				FcambiarColorFondo(menuRegistrar, Temas[0].getFondo());
				FcambiarColorFondo(menuListar, Temas[0].getFondo());
				FcambiarColorFondo(menuPrestamo, Temas[0].getFondo());
				FcambiarColorFondo(menuConfiguracion, Temas[0].getFondo());
				FcambiarColorFondo(menuOtros, Temas[0].getFondo());
				
				if (AplicarFondoBarraHerramienta.isSelected()) {
					FcambiarColorFondo(menuRegistrar, Temas[0].getFondo());
					FcambiarColorFondo(menuListar, Temas[0].getFondo());
					FcambiarColorFondo(menuPrestamo, Temas[0].getFondo());
					FcambiarColorFondo(menuConfiguracion, Temas[0].getFondo());
					FcambiarColorFondo(menuOtros, Temas[0].getFondo());
					
				}
				
				//
				FCambiarColorSeleccionado(btnRegistrarLibro, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarComputadora, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarImpresion, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarPrestamoLibro, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnRegistrarPrestamoComputadora, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnListarLibro, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnListarComputadora, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnListarImpresion, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnListarPrestamoLibro, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnListarPrestamoComputadora, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnConfiguracionTemas, Temas[0].getSeleccionado());
				FCambiarColorSeleccionado(btnOtrosManual, Temas[0].getSeleccionado());
				
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
	
	
	
	public static void FManualUsuario() {
		
		
		//Imports
		JPanel panelVertical1 = new JPanel();
		
		JLabel labelResultado = new JLabel("Manual abierto en otra ventana...");
		
		
		//setters
		panelVertical1.setLayout(new BoxLayout(panelVertical1, BoxLayout.Y_AXIS));
		panelVertical1.setOpaque(false);
		
		FcambiarColorTexto(labelResultado, Temas[colorIndex].getLetras());
		
		
		//adds
		panelVertical1.add(labelResultado);
		
		
		//llamados
		logica.ManualPDF();
		
		
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
	
	
	
	private static void FCambiarColorSeleccionado(JButton boton, Color color) {
		
		FhacerRedondeado(btnRegistrarLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnRegistrarComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnRegistrarImpresion, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnRegistrarPrestamoLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnRegistrarPrestamoComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnListarLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnListarComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnListarImpresion, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnListarPrestamoLibro, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnListarPrestamoComputadora, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnConfiguracionTemas, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		FhacerRedondeado(btnOtrosManual, Temas[colorIndexBotones].getBotones(), Temas[colorIndexBotones].getLetras());
		
		int radioEsquinas = 20; // Ajusta este valor para el redondeo

        // Calcular automáticamente colores derivados
        Color fondoHover = Faclarar(color, 0.15f);
        Color fondoPresionado = Foscurecer(color, 0.2f);

        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setBorder(null);

        boton.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = c.getWidth();
                int h = c.getHeight();

                // Detectar estado del botón
                ButtonModel model = ((AbstractButton) c).getModel();
                Color colorFondo = color;

                if (model.isPressed()) {
                    colorFondo = fondoPresionado;
                } else if (model.isRollover()) {
                    colorFondo = fondoHover;
                }

                // Dibujar fondo redondeado
                g2.setColor(colorFondo);
                g2.fillRoundRect(0, 0, w, h, radioEsquinas, radioEsquinas);

                g2.dispose();

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
	 * FUNCION: FajustarContraste
	 * INPUT: Color c
	 * OUTPUT:
	 * 
	 * elige blanco o negro según la luminosidad del color, con el objetivo de mantener buen contraste y que el texto o 
	 * elemento sea fácil de leer sobre ese fondo.
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
    
    
    /* FUNCION: autoResizeColumns
    INPUT: JTable table → La tabla cuyas columnas se ajustarán automáticamente.
    OUTPUT: void → No retorna ningún valor; modifica directamente las columnas de la tabla.

    Recorre todas las columnas de la JTable y calcula el ancho necesario para mostrar
    completamente el contenido de cada celda, incluyendo el encabezado. Ajusta el
    ancho de cada columna según el tamaño preferido de los componentes renderizados.
    Es útil para asegurar que el texto o los componentes dentro de las celdas no se corten.
    
    Documentado y realizado directamente por -ChatGPT.
    */
    public static void autoResizeColumns(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // ancho mínimo
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 10, width);
            }

            // también considera el encabezado
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component headerComp = headerRenderer.getTableCellRendererComponent(
                    table, table.getColumnName(column), false, false, 0, column);
            width = Math.max(width, headerComp.getPreferredSize().width + 10);

            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    
    
}