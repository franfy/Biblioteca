package Biblioteca;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WPrime extends JFrame{
	
	protected static JPanel PanelP = new JPanel(new BorderLayout());
	protected static LGestor logica = new LGestor();
	
	public WPrime() {
		
		//Configuracion de la Ventana
		this.setTitle("Biblioteca Prototipo");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		
		//Setters
		PanelP.setBackground(Color.lightGray);
		
		
		//Llamado a las funciones
		tab();
		systemInfo();
		
		
		//Se muestra la ventana
		this.add(PanelP);
		
		
	}
	
	
	
	/*
	 * FUNCION: tab
	 * INPUT:
	 * OUTPUT: PanelP
	 * 
	 * Esta funcion anade la barra de herramientas presente en este layout...
	 * 
	 * Para ello utiliza Panelv1 (Panel en sentido vertical numero 1), TabContainer (Encargado de aplicar los botones en la
	 * barra de herramientas), boton1 (Encargado de abrir el menu para registrar objetos) y boton2 (Encargado de abrir el
	 * menu para dar de baja un objeto).
	 */
	public static void tab() {
		
		
		//Imports - Paneles
		JPanel Panelv1 = new JPanel();
		JPanel Panelh1 = new JPanel();
		JPanel TabContainer = new JPanel();
		
		//Labels
		JLabel label1 = new JLabel("Barra de Herramientas");
		
		//Separators
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();
		
		//Botones
		JButton Registrar = new JButton("Registrar");
		JButton DarDeBaja = new JButton("Dar de Baja");
		JButton Listar = new JButton("Listar");
		JButton Configuracion = new JButton("Configuracion");
		JButton Otros = new JButton("Otros");
		
		//PopupMenu
		JPopupMenu MenuRegistrar = new JPopupMenu();
		JPopupMenu MenuDarDeBaja = new JPopupMenu();
		JPopupMenu MenuListar = new JPopupMenu();
		JPopupMenu MenuOtros = new JPopupMenu();
		
		//MenuItem
		JMenuItem RegistrarLibro = new JMenuItem("Libro");
		JMenuItem RegistrarComputadora = new JMenuItem("Computadora");
		JMenuItem DarDeBajaLibro = new JMenuItem("Libro");
		JMenuItem DarDeBajaComputadora = new JMenuItem("Computadora");
		JMenuItem ListarLibro = new JMenuItem("Libro");
		JMenuItem ListarComputadora = new JMenuItem("Computadora");
		JMenuItem OtrosAyuda = new JMenuItem("Ayuda");
		JMenuItem OtrosManualDeUsuario = new JMenuItem("Manual de usuario");
		
		
		//Setters
		Panelv1.setLayout(new BoxLayout(Panelv1, BoxLayout.Y_AXIS));
		Panelv1.setBackground(Color.GRAY);
		
		TabContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		TabContainer.setBackground(Color.GRAY);
		
		Panelh1.setBackground(Color.GRAY);
		
		Registrar.setBackground(Color.GRAY);
		DarDeBaja.setBackground(Color.GRAY);
		Listar.setBackground(Color.GRAY);
		Configuracion.setBackground(Color.GRAY);
		Otros.setBackground(Color.GRAY);
		
		Registrar.setBorder(null);
		DarDeBaja.setBorder(null);
		Listar.setBorder(null);
		Configuracion.setBorder(null);
		Otros.setBorder(null);
		
		Negrita(label1, 20);
		Negrita(Registrar, 16);
		Negrita(DarDeBaja, 16);
		Negrita(Listar, 16);
		Negrita(Configuracion, 16);
		Negrita(Otros, 16);
		
		
		//Eventos
		Registrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuRegistrar.show(Registrar, 0, Registrar.getHeight());
			}
		});
		
		DarDeBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuDarDeBaja.show(DarDeBaja, 0, DarDeBaja.getHeight());
			}
		});
		
		Listar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuListar.show(Listar, 0, Listar.getHeight());
			}
		});
		
		Otros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuOtros.show(Otros, 0, Otros.getHeight());
			}
		});
		
		
		//Adds
		Panelh1.add(label1);
		
		Panelv1.add(Panelh1);
		Panelv1.add(TabContainer);
		
		TabContainer.add(Registrar);
		TabContainer.add(separator1);
		TabContainer.add(DarDeBaja);
		TabContainer.add(separator2);
		TabContainer.add(Listar);
		TabContainer.add(separator3);
		TabContainer.add(Configuracion);
		TabContainer.add(separator4);
		TabContainer.add(Otros);
		
		MenuRegistrar.add(RegistrarLibro);
		MenuRegistrar.add(RegistrarComputadora);
		
		MenuDarDeBaja.add(DarDeBajaLibro);
		MenuDarDeBaja.add(DarDeBajaComputadora);
		
		MenuListar.add(ListarLibro);
		MenuListar.add(ListarComputadora);
		
		MenuOtros.add(OtrosAyuda);
		MenuOtros.add(OtrosManualDeUsuario);
		
		
		//Aplica al PanelP
		PanelP.add(Panelv1, BorderLayout.NORTH);
		
	}
	
	
	
	/*
	 * FUNCION: systemInfo
	 * INPUT:
	 * OUTPUT: Uso de la memoria RAM
	 * 
	 * Esta funcion unicamente tiene el proposito de ser algo experimental sin cumplir un proposito real
	 */
	public static void systemInfo() {
		
		
		//Imports
		Runtime datos = Runtime.getRuntime();
		JPanel Panelv1 = new JPanel();
		JLabel label1 = new JLabel("SO: Windows 10 IOT LTSC");
		JLabel label2 = new JLabel("Version del SO: 22H2");
		JLabel label3 = new JLabel("Version del SoftWare: 0.1 Prototype 16/8/2025");
		JLabel label4 = new JLabel();
		
		
		//Variables
		long memoriaDisponible = (datos.totalMemory() - datos.freeMemory()) / (1024);
		
		
		//Setters
		Panelv1.setLayout(new BoxLayout(Panelv1, BoxLayout.Y_AXIS));
		Panelv1.setBackground(Color.LIGHT_GRAY);
		
		label4.setText("Uso de la memoria: " + memoriaDisponible + "MB");
		
		
		//Adds
		Panelv1.add(label1);
		Panelv1.add(label2);
		Panelv1.add(label3);
		Panelv1.add(label4);
		
		
		//Aplicar al PanelP
		PanelP.add(Panelv1, BorderLayout.SOUTH);
	}
	
	
	
	public static void sidetab() {
		
	}
	
	
	
	/*
	 * FUNCION: stateMachine
	 * INPUT:
	 * OUTPUT:
	 */
	public static void stateMachine() {
		
	}
	
	
	
	public static void Negrita(JComponent componente, int tamano) {
		Font fuenteActual = componente.getFont();
        Font fuenteNegrita = new Font(fuenteActual.getName(), Font.BOLD, tamano);
        componente.setFont(fuenteNegrita);
	}
	
	
	
	public static void SubirLibro() {
		
	}
	
	
	
	public static void SubirComputadora() {
		
	}
	
	
	
	public static void BajarLibro() {
		
	}
	
	
	
	public static void BajarComputadora() {
		
	}
	
	
	
	public static void ListarLibro() {
		
	}
	
	
	
	public static void ListarComputadora() {
		
	}
	
	
	
	public static void Configurar() {
		
	}
	
	
	
	public static void OtrosAyuda() {
		
	}
	
	
	
	public static void OtrosManualUsuario() {
		
	}
}





































