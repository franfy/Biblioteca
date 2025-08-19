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
		
		
		//Imports
		JPanel Panelv1 = new JPanel();
		JPanel TabContainer = new JPanel();
		JLabel label1 = new JLabel("Barra de Herramientas");
		JButton boton1 = new JButton("Registrar");
		JButton boton2 = new JButton("Dar de Baja");
		JButton boton3 = new JButton("Listar");
		JButton boton4 = new JButton("Configuracion");
		JButton boton5 = new JButton("Otros");
		
		
		//Setters
		Panelv1.setLayout(new BoxLayout(Panelv1, BoxLayout.Y_AXIS));
		Panelv1.setBackground(Color.GRAY);
		
		TabContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		TabContainer.setBackground(Color.GRAY);
		
		
		//Adds
		Panelv1.add(label1);
		Panelv1.add(TabContainer);
		
		TabContainer.add(boton1);
		TabContainer.add(boton2);
		TabContainer.add(boton3);
		TabContainer.add(boton4);
		TabContainer.add(boton5);
		
		
		//Aplica al PanelP
		PanelP.add(Panelv1, BorderLayout.NORTH);
		
	}
	
	
	
	/*
	 * FUNCION: sistemInfo
	 * INPUT:
	 * OUTPUT: Uso de la memoria RAM
	 * 
	 * Esta funcion unicamente tiene el proposito de ser algo experimental sin cumplir un proposito real, todo el calculo
	 * de la memoria RAM y la linea 92 fueron obtuvidos mediante Gemini a manera de experimentacion
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
	
	
	
}
