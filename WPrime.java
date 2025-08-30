package Biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class WPrime extends JFrame {

	protected static JPanel PanelP = new JPanel(new BorderLayout());
	protected static LGestor logica = new LGestor();

	public WPrime() {

		// Configuracion de la Ventana
		this.setTitle("Biblioteca Prototipo");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);

		// Llamado a las funciones
		tab();
		systemInfo();

		// Se muestra la ventana
		this.add(PanelP);

	}

	/*
	 * FUNCION: tab INPUT: OUTPUT: PanelP
	 * 
	 * Esta funcion anade la barra de herramientas presente en este layout...
	 * 
	 * Para ello utiliza Panelv1 (Panel en sentido vertical numero 1), TabContainer
	 * (Encargado de aplicar los botones en la barra de herramientas), boton1
	 * (Encargado de abrir el menu para registrar objetos) y boton2 (Encargado de
	 * abrir el menu para dar de baja un objeto).
	 */
	public static void tab() {

		// Imports - Paneles
		JPanel Panelv1 = new JPanel();
		JPanel Panelh1 = new JPanel();
		JPanel TabContainer = new JPanel();

		// Separators
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();
		JSeparator separator5 = new JSeparator();

		// Botones
		JButton Registrar = new JButton("Registrar");
		JButton DarDeBaja = new JButton("Dar de Baja");
		JButton Listar = new JButton("Listar");
		JButton Prestamo = new JButton("Prestamo");
		JButton Configuracion = new JButton("Configuracion");
		JButton Otros = new JButton("Otros");

		// PopupMenu
		JPopupMenu MenuRegistrar = new JPopupMenu();
		JPopupMenu MenuDarDeBaja = new JPopupMenu();
		JPopupMenu MenuListar = new JPopupMenu();
		JPopupMenu MenuPrestamo = new JPopupMenu();
		JPopupMenu MenuOtros = new JPopupMenu();

		// MenuItem
		JMenuItem RegistrarLibro = new JMenuItem("Libro");
		JMenuItem RegistrarComputadora = new JMenuItem("Computadora");
		JMenuItem DarDeBajaLibro = new JMenuItem("Libro");
		JMenuItem DarDeBajaComputadora = new JMenuItem("Computadora");
		JMenuItem ListarLibro = new JMenuItem("Libro");
		JMenuItem ListarComputadora = new JMenuItem("Computadora");
		JMenuItem PrestamoLibro = new JMenuItem("Libro");
		JMenuItem PrestamoComputadora = new JMenuItem("Computadora");
		JMenuItem OtrosAyuda = new JMenuItem("Ayuda");
		JMenuItem OtrosManualDeUsuario = new JMenuItem("Manual de usuario");

		// Setters
		Panelv1.setLayout(new BoxLayout(Panelv1, BoxLayout.Y_AXIS));
		Panelv1.setBackground(Color.LIGHT_GRAY);

		TabContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		TabContainer.setBackground(Color.LIGHT_GRAY);

		Panelh1.setBackground(Color.LIGHT_GRAY);

		Registrar.setBackground(Color.LIGHT_GRAY);
		DarDeBaja.setBackground(Color.LIGHT_GRAY);
		Listar.setBackground(Color.LIGHT_GRAY);
		Prestamo.setBackground(Color.LIGHT_GRAY);
		Configuracion.setBackground(Color.LIGHT_GRAY);
		Otros.setBackground(Color.LIGHT_GRAY);

		Registrar.setBorder(null);
		DarDeBaja.setBorder(null);
		Listar.setBorder(null);
		Prestamo.setBorder(null);
		Configuracion.setBorder(null);
		Otros.setBorder(null);

		Negrita(Registrar, 16);
		Negrita(DarDeBaja, 16);
		Negrita(Listar, 16);
		Negrita(Prestamo, 16);
		Negrita(Configuracion, 16);
		Negrita(Otros, 16);

		// Adds
		Panelv1.add(Panelh1);
		Panelv1.add(TabContainer);

		TabContainer.add(Registrar);
		TabContainer.add(separator1);
		TabContainer.add(DarDeBaja);
		TabContainer.add(separator2);
		TabContainer.add(Listar);
		TabContainer.add(separator3);
		TabContainer.add(Prestamo);
		TabContainer.add(separator4);
		TabContainer.add(Configuracion);
		TabContainer.add(separator5);
		TabContainer.add(Otros);

		MenuRegistrar.add(RegistrarLibro);
		MenuRegistrar.add(RegistrarComputadora);

		MenuDarDeBaja.add(DarDeBajaLibro);
		MenuDarDeBaja.add(DarDeBajaComputadora);

		MenuListar.add(ListarLibro);
		MenuListar.add(ListarComputadora);
		
		MenuPrestamo.add(PrestamoLibro);
		MenuPrestamo.add(PrestamoComputadora);

		//MenuOtros.add(OtrosAyuda);
		MenuOtros.add(OtrosManualDeUsuario);

		// Eventos - Botones
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Registrar");
				MenuRegistrar.show(Registrar, 0, Registrar.getHeight());
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		DarDeBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DarDeBaja");
				MenuDarDeBaja.show(DarDeBaja, 0, DarDeBaja.getHeight());
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		Listar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Listar");
				MenuListar.show(Listar, 0, Listar.getHeight());
				PanelP.revalidate();
				PanelP.repaint();

			}
		});
		
		Prestamo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Prestamo");
				MenuPrestamo.show(Prestamo, 0, Prestamo.getHeight());
				PanelP.revalidate();
				PanelP.repaint();
			}
		});

		Configuracion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Configuracion");
				Configurar();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		Otros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Otros");
				MenuOtros.show(Otros, 0, Otros.getHeight());
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		// Menu Items
		RegistrarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("RegistrarLibro");
				SubirLibro();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		RegistrarComputadora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("RegistrarCompu");
				SubirComputadora();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		DarDeBajaLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DarDeBajaLibro");
				BajarLibro();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		DarDeBajaComputadora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DarDeBajaComputadora");
				BajarComputadora();
				PanelP.revalidate();
				PanelP.repaint();

				
			}
		});

		ListarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ListarLibro");
				ListarLibro();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		ListarComputadora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ListarComputadora");
				ListarComputadora();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});
		
		PrestamoLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("PrestamoLibro");
				PrestamoLibro();
				PanelP.revalidate();
				PanelP.repaint();
			}
		});
		
		PrestamoComputadora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("PrestamoComputadora");
				PrestamoComputadora();
				PanelP.revalidate();
				PanelP.repaint();
			}
		});

		OtrosAyuda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OtrosAyuda");
				OtrosAyuda();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		OtrosManualDeUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OtrosManualDeUsuario");
				OtrosManualUsuario();
				PanelP.revalidate();
				PanelP.repaint();

			}
		});

		// Aplica al PanelP
		PanelP.add(Panelv1, BorderLayout.NORTH);

	}

	/*
	 * FUNCION: systemInfo INPUT: OUTPUT: Uso de la memoria RAM
	 * 
	 * Esta funcion unicamente tiene el proposito de ser algo experimental sin
	 * cumplir un proposito real
	 */
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

		// Aplicar al PanelP
		PanelP.add(Panelv1, BorderLayout.SOUTH);
	}
	
	
	
	public static void Negrita(JComponent componente, int tamano) {
		Font fuenteActual = componente.getFont();
		Font fuenteNegrita = new Font(fuenteActual.getName(), Font.BOLD, tamano);
		componente.setFont(fuenteNegrita);
	}

	/*
	 * FUNCION: stateMachine INPUT: OUTPUT:
	 */
	public static void stateMachine() {
		
	}

	public static void SubirLibro() {

		// imports
		JPanel panelLocal = new JPanel(new GridBagLayout());
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		JPanel panelh2 = new JPanel();
		JPanel panelh3 = new JPanel();
		JPanel panelh4 = new JPanel();
		JPanel panelh5 = new JPanel();
		JLabel LabelISBN = new JLabel("ISBN");
		JLabel LabelTitulo = new JLabel("Titulo");
		JLabel LabelAutor = new JLabel("Autor");
		JLabel LabelGenero = new JLabel("Genero");
		JLabel LabelMateria = new JLabel("Materia");
		
		JTextField InputISBN = new JTextField(6);
		JTextField InputTitulo = new JTextField(6);
		JTextField InputAutor = new JTextField(6);
		JTextField InputGenero = new JTextField(6);
		JTextField InputMateria = new JTextField(6);
		JButton Registrar = new JButton("Registrar");

		
		// setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh2.setLayout(new BoxLayout(panelh2, BoxLayout.X_AXIS));
		panelh3.setLayout(new BoxLayout(panelh3, BoxLayout.X_AXIS));
		panelh4.setLayout(new BoxLayout(panelh4, BoxLayout.X_AXIS));
		panelh5.setLayout(new BoxLayout(panelh5, BoxLayout.X_AXIS));
		panelv1.setVisible(true);


		// adds
		panelv1.add(panelh1);
		panelv1.add(panelh2);
		panelv1.add(panelh3);
		panelv1.add(panelh4);
		panelv1.add(panelh5);
		panelv1.add(Registrar);

		panelh1.add(LabelISBN);
		panelh1.add(InputISBN);

		panelh2.add(LabelTitulo);
		panelh2.add(InputTitulo);
		
		panelh3.add(LabelAutor);
		panelh3.add(InputAutor);
		
		panelh4.add(LabelGenero);
		panelh4.add(InputGenero);
		
		panelh5.add(LabelMateria);
		panelh5.add(InputMateria);

		panelLocal.add(panelv1);

		// eventos
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!InputISBN.getText().isEmpty() && !InputTitulo.getText().isEmpty() && !InputAutor.getText().isEmpty() && !InputGenero.getText().isEmpty() && !InputMateria.getText().isEmpty()) {
				    System.out.println("Se subió correctamente");
				    panelLocal.setVisible(false);
				} else {
				    System.out.println("Matanga");
				}

			}
		});

		PanelP.add(panelLocal, BorderLayout.CENTER);

	}

	public static void SubirComputadora() {
		
		
		// imports
		JPanel panelLocal = new JPanel(new GridBagLayout());
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		JPanel panelh2 = new JPanel();
		JLabel LabelNro = new JLabel("Nro de serie");
		JLabel LabelModelo = new JLabel("Modelo");
		JTextField InputNro = new JTextField(6);
		JTextField InputModelo = new JTextField(6);
		JButton Registrar = new JButton("Registrar");

		
		// setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh2.setLayout(new BoxLayout(panelh2, BoxLayout.X_AXIS));
		panelv1.setVisible(true);

		
		// adds
		panelv1.add(panelh1);
		panelv1.add(panelh2);
		panelv1.add(Registrar);

		panelh1.add(LabelNro);
		panelh1.add(InputNro);

		panelh2.add(LabelModelo);
		panelh2.add(InputModelo);
		
		panelLocal.add(panelv1);

		// eventos
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!InputNro.getText().isEmpty() && !InputModelo.getText().isEmpty()) {
				    System.out.println("Se subió correctamente");
				    panelLocal.setVisible(false);
				} else {
				    System.out.println("Matanga");
				}

			}
		});

		PanelP.add(panelLocal, BorderLayout.CENTER);
	}

	public static void BajarLibro() {

		
		// imports
		JPanel panelLocal = new JPanel(new GridBagLayout());
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		
		JLabel LabelISBN = new JLabel("ISBN");
		
		JTextField InputISBN = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");

		
		// setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelv1.setVisible(true);


		// adds
		panelv1.add(panelh1);
		panelv1.add(Registrar);

		panelh1.add(LabelISBN);
		panelh1.add(InputISBN);
		
		panelLocal.add(panelv1);

		// eventos
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!InputISBN.getText().isEmpty()){
					System.out.println("Se bajo correctamente");
				    panelLocal.setVisible(false);
				} else {
				    System.out.println("Matanga");
				}

			}
		});
		
		PanelP.add(panelLocal, BorderLayout.CENTER);
	}

	public static void BajarComputadora() {

		
		// imports
		JPanel panelLocal = new JPanel(new GridBagLayout());
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		
		JLabel LabelNro = new JLabel("Nro de serie");
		
		JTextField InputNro = new JTextField(6);
		
		JButton Registrar = new JButton("Registrar");

		
		// setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelv1.setVisible(true);


		// adds
		panelv1.add(panelh1);
		panelv1.add(Registrar);

		panelh1.add(LabelNro);
		panelh1.add(InputNro);
		
		panelLocal.add(panelv1);

		// eventos
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!InputNro.getText().isEmpty()){
					System.out.println("Se bajo correctamente");
				    panelLocal.setVisible(false);
				} else {
					System.out.println("Matanga");
				}

			}
		});
		
		PanelP.add(panelLocal, BorderLayout.CENTER);
	}

	public static void ListarLibro() {
		
		
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
        
        PanelP.add(tabla, BorderLayout.CENTER);
        
	}

	public static void ListarComputadora() {
		
		
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

		PanelP.add(tabla, BorderLayout.CENTER);
	}
	
	public static void PrestamoLibro() {
		
		// imports
		JPanel panelLocal = new JPanel(new GridBagLayout());
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		JPanel panelh2 = new JPanel();
		JPanel panelh3 = new JPanel();
		JLabel LabelNro = new JLabel("ISBN del Libro");
		JLabel LabelInicio = new JLabel("Inicio del prestamo");
		JLabel LabelFinal = new JLabel("Final del prestamo");
		JTextField InputNro = new JTextField(6);
		JTextField InputInicio = new JTextField(6);
		JTextField InputFinal = new JTextField(6);
		JButton Registrar = new JButton("Registrar");

				
		// setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh2.setLayout(new BoxLayout(panelh2, BoxLayout.X_AXIS));
		panelh3.setLayout(new BoxLayout(panelh3, BoxLayout.X_AXIS));
		panelv1.setVisible(true);

				
		// adds
		panelv1.add(panelh1);
		panelv1.add(panelh2);
		panelv1.add(panelh3);
		panelv1.add(Registrar);

		panelh1.add(LabelNro);
		panelh1.add(InputNro);

		panelh2.add(LabelInicio);
		panelh2.add(InputInicio);
		
		panelh3.add(LabelFinal);
		panelh3.add(InputFinal);
		
		panelLocal.add(panelv1);

		
		// Llamados
		ListarLibro();
				

		// eventos
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!InputNro.getText().isEmpty() && !InputInicio.getText().isEmpty() && !InputFinal.getText().isEmpty()) {
				    System.out.println("Se subió correctamente");
				    panelLocal.setVisible(false);
				} else {
				    System.out.println("Matanga");
				}

			}
		});

		PanelP.add(panelLocal, BorderLayout.EAST);
		
	}
	
	public static void PrestamoComputadora() {
		
		// imports
		JPanel panelLocal = new JPanel(new GridBagLayout());
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		JPanel panelh2 = new JPanel();
		JPanel panelh3 = new JPanel();
		JLabel LabelNro = new JLabel("Nro de serie");
		JLabel LabelInicio = new JLabel("Inicio del prestamo");
		JLabel LabelFinal = new JLabel("Final del prestamo");
		JTextField InputNro = new JTextField(6);
		JTextField InputInicio = new JTextField(6);
		JTextField InputFinal = new JTextField(6);
		JButton Registrar = new JButton("Registrar");

				
		// setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh2.setLayout(new BoxLayout(panelh2, BoxLayout.X_AXIS));
		panelh3.setLayout(new BoxLayout(panelh3, BoxLayout.X_AXIS));
		panelv1.setVisible(true);

				
		// adds
		panelv1.add(panelh1);
		panelv1.add(panelh2);
		panelv1.add(panelh3);
		panelv1.add(Registrar);

		panelh1.add(LabelNro);
		panelh1.add(InputNro);

		panelh2.add(LabelInicio);
		panelh2.add(InputInicio);
		
		panelh3.add(LabelFinal);
		panelh3.add(InputFinal);
		
		panelLocal.add(panelv1);

		
		// Llamados
		ListarComputadora();
				

		// eventos
		Registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!InputNro.getText().isEmpty() && !InputInicio.getText().isEmpty() && !InputFinal.getText().isEmpty()) {
				    System.out.println("Se subió correctamente");
				    panelLocal.setVisible(false);
				    
				} else {
				    System.out.println("Matanga");
				}

			}
		});

		PanelP.add(panelLocal, BorderLayout.EAST);
		
	}

	public static void Configurar() {
		
		
		//Imports
		JPanel panelLocal = new JPanel();
		JPanel panelv1 = new JPanel();
		JLabel Espera = new JLabel("Configuracion....");
		JButton Salir = new JButton("Salir");
		
		
		//Setters
		panelLocal.setLayout(new GridBagLayout());
		
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		
		
		//Adds
		panelv1.add(Espera);
		panelv1.add(Salir);
		
		panelLocal.add(panelv1);
		
		
		//Eventos
		Salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelLocal.setVisible(false);
			}
		});
		
		PanelP.add(panelLocal, BorderLayout.CENTER);
		
	}

	public static void OtrosAyuda() {

	}

	public static void OtrosManualUsuario() {

	}
}
