package paciente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Informacion extends JFrame{
	// Frame
	public JFrame ventana = new JFrame();
	// JPanel
	private JPanel informacion, cita;
	
	
	// Botones
	JButton editar_info, guardar;
	
	public static void main(String[] args) {
		Informacion info = new Informacion();
		info.info_paciente();
	}

	public void info_paciente() {
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
							// INFORMACION DEL PACIENTE //
		// Método para designar tamaño a cualquier JPanel
		informacion = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(420, 100);
            };
        };
		
        this.getContentPane().add(informacion);
		informacion.setLayout(null);
		informacion.setBorder(BorderFactory.createTitledBorder("Información Paciente")); // Se pone borde al panel
		// Componentes
		// Etiquetas
		JLabel clave = new JLabel("Clave:");
		clave.setFont(new Font("verdana", Font.PLAIN, 14));
		clave.setBounds(20, 15, 100, 30);
		informacion.add(clave);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("verdana", Font.PLAIN, 14));
		nombre.setBounds(150, 15, 100, 30);
		informacion.add(nombre);
		
		JLabel fecha_nacimiento = new JLabel("Fecha de nacimiento:");
		fecha_nacimiento.setFont(new Font("verdana", Font.PLAIN, 14));
		fecha_nacimiento.setBounds(20, 39, 150, 30);
		informacion.add(fecha_nacimiento);
		
		JLabel correo = new JLabel("Correo electrónico:");
		correo.setFont(new Font("verdana", Font.PLAIN, 14));
		correo.setBounds(20, 63, 150, 30);
		informacion.add(correo);
		
		JLabel telefono = new JLabel("Teléfono:");
		telefono.setFont(new Font("verdana", Font.PLAIN, 14));
		telefono.setBounds(20, 87, 100, 30);
		informacion.add(telefono);
		
		
							// INFORMACION CITA //
		cita = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            };
        };

        this.getContentPane().add(cita);
		cita.setLayout(null);
		cita.setBorder(BorderFactory.createTitledBorder("Cita Paciente")); // Se pone borde al panel

		
		
		
		// Se agregan los JPanels al frame y se les asigna una posición
		ventana.setVisible(true);
		ventana.setSize(500, 500);
		ventana.add(informacion, BorderLayout.CENTER);
		ventana.add(cita, BorderLayout.EAST);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(435, 235));
	}

}
