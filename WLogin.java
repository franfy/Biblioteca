package Biblioteca;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class WLogin extends JFrame {

	protected static LGestor logica = new LGestor();
	protected static boolean res = true;

	public WLogin() {
		this.setTitle("Inicio de sesion - Biblioteca Prototipo");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Cuerpo(this);
		
	}

	public void Cuerpo(JFrame ventana) {
		
		
		//arrays & variables
		String[] turnos = {"Mañana", "Tarde", "Nocturno"};
		var contra = "123";
		
		
		//imports
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		JLabel fondo = new JLabel(new ImageIcon("/home/franco/Pictures/Wallpapers/1756054601307.jpg"));
		JLabel error = new JLabel();
		JPasswordField pass = new JPasswordField(2);
		JComboBox turnosBox = new JComboBox(turnos);
		JSeparator separadorv1 = new JSeparator(JSeparator.VERTICAL);
		JSeparator separadorh1 = new JSeparator(JSeparator.HORIZONTAL);
		
		
		//setters
		fondo.setLayout(new GridBagLayout());
		
		turnosBox.setToolTipText("Elige el turno al que perteneces");
		turnosBox.setBackground(Color.LIGHT_GRAY);
		
		pass.setToolTipText("Ingresa la contraseña, luego presiona la tecla Enter para iniciar sesion");
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setPreferredSize(new Dimension(0, 30));
		
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelv1.setBackground(Color.LIGHT_GRAY);
		
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh1.setBackground(Color.LIGHT_GRAY);
		
		separadorv1.setPreferredSize(new Dimension(300, 40));
		
		separadorh1.setPreferredSize(new Dimension(200, 0));
		
		
		//adds
		panelh1.add(turnosBox);
		panelh1.add(separadorh1);
		
		panelv1.add(panelh1);
		panelv1.add(separadorv1);
		panelv1.add(error);
		panelv1.add(pass);
		
		
		//eventos
		pass.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        // No se usa
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // No se usa
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            if (pass.getText().equals(contra)) {
		                ventana.setVisible(false);
		                logica.MostrarVentana();
		            } else {
		                error.setText("Contraseña incorrecta");
		            }
		        }
		    }
		});
		
		//aplica a la ventana principal
		fondo.add(panelv1);
		ventana.setContentPane(fondo);
	}

}