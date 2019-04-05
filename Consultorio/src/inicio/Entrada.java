package inicio;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import secretaria.Menu;

public class Entrada extends JFrame implements ActionListener{

	Menu menu = new Menu();
	private JFrame frame = new JFrame("Inicio");
	// JPanel
	private JPanel users;
	JButton continuar;
	// Se crea un String para las opciones del JComboBox
	private String[] usuarios = {"Opciones", "Secretaria", "Doctor", "Administrador"};
	// Se instancía el JComboBox junto con el String para poder utilizar sus opciones posteriormente
	private JComboBox<String> tipo_user = new JComboBox<String>(usuarios);
	
	// Main
	public static void main(String[] args) {
		Entrada entrada = new Entrada();
		entrada.inicio();

	}
	
	// GUI
	public void inicio() {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Creando Panel
		users = new JPanel();
		this.getContentPane().add(users);	
		users.setLayout(null);
		users.setBorder(BorderFactory.createTitledBorder("Usuario"));
		
		// Etiquetas
		JLabel etiqueta = new JLabel("Seleccionar tipo de usuario:");
		etiqueta.setBounds(20, 15, 300, 30);
		etiqueta.setFont(new Font("verdana", Font.PLAIN, 15));
		users.add(etiqueta);
		
		// ComboBox
		tipo_user.setBounds(60, 50, 140, 30);
		users.add(tipo_user);
		
		// Botón
		continuar = new JButton("Continuar");
		continuar.setBounds(200, 50, 105, 30);
		users.add(continuar);
		continuar.addActionListener(this);
		
		frame.setSize(365, 120);
		frame.setMinimumSize(new Dimension(360, 120));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(users);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == continuar){
			if(tipo_user.getSelectedItem().equals("Secretaria")) {
				this.dispose();
				menu.GUI_sec();
			} else if(tipo_user.getSelectedItem().equals("Doctor")) {
				this.dispose();
			} else if(tipo_user.getSelectedItem().equals("Administrador")) {
				this.dispose();
			}
		}
	}
}
