package Biblioteca;

import java.awt.*;
import java.awt.event.*;
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
		var contra = "franco";
		
		
		//imports
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		
		JLabel fondo = new JLabel(new ImageIcon("/home/franco/eclipse-workspace/BibliotecaPanDeAzucar/src/Imagenes/Windows-7-Logon-windows-7-26859769-1920-1200.jpg"));
		JLabel error = new JLabel();
		JLabel label1 = new JLabel("Ingresa la contraseña");
		
		JPasswordField pass = new JPasswordField(2);
		
		JSeparator separadorv1 = new JSeparator(JSeparator.VERTICAL);
		JSeparator separadorh1 = new JSeparator(JSeparator.HORIZONTAL);
		
		
		//setters
		fondo.setLayout(new GridBagLayout());
		
		pass.setToolTipText("Ingresa la contraseña, luego presiona la tecla Enter para iniciar sesion");
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setPreferredSize(new Dimension(0, 30));
		pass.setEchoChar((char) 0);
		pass.setText("Ingresa la Contraseña");
		
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelv1.setBackground(Color.LIGHT_GRAY);
		//panelv1.setOpaque(false);
		
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh1.setBackground(Color.LIGHT_GRAY);
		//panelh1.setOpaque(false);
		
		separadorv1.setPreferredSize(new Dimension(300, 40));
		
		separadorh1.setPreferredSize(new Dimension(200, 0));
		
		
		//adds
		panelh1.add(label1);
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
		
		pass.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				System.out.println("sale");
                pass.setEchoChar((char) 0); // Sin ocultar
                pass.setText("Contraseña");
                pass.setForeground(Color.GRAY);
                
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				System.out.println("entra");
                pass.setText("");
                pass.setEchoChar('•'); // Activa el ocultamiento
                pass.setForeground(Color.BLACK);
                
			}
		});
		
		
		
		//aplica a la ventana principal
		fondo.add(panelv1);
		ventana.setContentPane(fondo);
	}

}