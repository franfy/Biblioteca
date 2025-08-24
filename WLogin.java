package Biblioteca;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WLogin extends JFrame{
	
	protected static JPanel panelp = new JPanel(new GridBagLayout());
	protected static LGestor logica = new LGestor();
	protected static boolean res = true;
	
	public WLogin() {
		this.setTitle("Inicio de sesion - Biblioteca Prototipo");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		Cuerpo(this);
		
		this.add(panelp);
		
	}
	
	public static void Cuerpo(JFrame ventana) {
		
		
		//Variables
		String Nombre = "Franco";
		String Pass = "Arrayanes";
		
		
		//Imports
		JLabel LabelNombre = new JLabel("Nombre:");
		JLabel LabelPass = new JLabel("Contraseña:");
		JLabel LabelError = new JLabel();
		JTextField InputNombre = new JTextField(6);
		JPasswordField InputPass = new JPasswordField(6);
		JButton BotonConfirmar = new JButton("Iniciar Sesion");
		JPanel panelv1 = new JPanel();
		JPanel panelh1 = new JPanel();
		JPanel panelh2 = new JPanel();
		
		
		//Setters
		panelv1.setLayout(new BoxLayout(panelv1, BoxLayout.Y_AXIS));
		panelh1.setLayout(new BoxLayout(panelh1, BoxLayout.X_AXIS));
		panelh2.setLayout(new BoxLayout(panelh2, BoxLayout.X_AXIS));
		
		
		//Adds
		panelv1.add(panelh1);
		panelv1.add(panelh2);
		panelv1.add(BotonConfirmar);
		panelv1.add(LabelError);
		
		panelh1.add(LabelNombre);
		panelh1.add(InputNombre);
		
		panelh2.add(LabelPass);
		panelh2.add(InputPass);
		
		
		//Eventos
		BotonConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (InputNombre.getText().equals(Nombre) && InputPass.getText().equals(Pass)) {
					ventana.setVisible(false);
					logica.MostrarVentana();
				} else {
					LabelError.setText("Nombre o contraseña incorrecta...");
				}
			}
		});
		
		
		//Vista final
		panelp.add(panelv1);
		
	}

}