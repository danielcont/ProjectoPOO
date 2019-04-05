package secretaria;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import paciente.Informacion;
import paciente.Nuevo;
import paciente.Paciente;

public class Menu  extends JFrame implements ActionListener{
	// Instanciamos otras clases
	Nuevo paciente_nuevo = new Nuevo();
	Informacion paciente_informacion = new Informacion();

	ArrayList<Paciente> clientes;
	
	// Frame
	private JFrame frame = new JFrame("Secretaria");
	// JPanels
	private JPanel nvo_pac, info_pac, asig_cita;
	// Botones
	private JButton salir, continuar_cita, aceptar, continuar_info;
	// Se crea un String para las opciones del JComboBox
	private String[] especialidades = {"Opciones", "Doctor General", "Pediatra", "Cardiólogo", "Neurólogo", "Oftalmólogo"};
	// Se instancia el JComboBox junto con el String para poder utilizar sus opciones posteriormente
	private JComboBox<String> tipo_consulta = new JComboBox<String>(especialidades);
	// Cajas de texto
	JTextField cve_info, cve_cita;

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.GUI_sec();
		
	}
	
	public void GUI_sec() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        					// NUEVO PACIENTE //
        // Este método se encontró en StackOverflow para poder designar tamaño a cualquier JPanel
        nvo_pac = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(420, 100);
            };
        };
        nvo_pac.setBorder(BorderFactory.createTitledBorder("Nuevo Paciente")); // Se pone borde al panel
        // Etiquetas
     	JLabel etiqueta = new JLabel("¿Desea registrar un nuevo paciente?");
     	etiqueta.setFont(new Font("verdana", Font.PLAIN, 14));
     	nvo_pac.add(etiqueta);
     	JLabel etiqueta2 = new JLabel("Si el paciente nunca se ha registrado, presione el botón");
     	etiqueta2.setFont(new Font("verdana", Font.PLAIN, 14));
     	nvo_pac.add(etiqueta2);
     	// Botón
     	aceptar = new JButton("Aceptar");
     	nvo_pac.add(aceptar);
     	aceptar.addActionListener(this);
     	
     						// INFORMACION PACIENTE //
     	// Este método se encontró en StackOverflow para poder designar tamaño al JPanel
     	info_pac = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(420, 130);
            };
        };
        info_pac.setBorder(BorderFactory.createTitledBorder("Información del Paciente"));
        // Etiquetas
        JLabel etiqueta_3 = new JLabel("Aquí se muestra la información del paciente.");
        etiqueta_3.setFont(new Font("verdana", Font.PLAIN, 14));
        info_pac.add(etiqueta_3);
        JLabel etiqueta_4 = new JLabel("También se pueden modificar datos");
        etiqueta_4.setFont(new Font("verdana", Font.PLAIN, 14));
        info_pac.add(etiqueta_4);
        JLabel etiqueta_5 = new JLabel("Clave del Paciente: ");
        etiqueta_5.setFont(new Font("verdana", Font.PLAIN, 14));
        info_pac.add(etiqueta_5);
        // Caja de Texto
        cve_info = new JTextField(5);
        info_pac.add(cve_info);
        // Botón
        continuar_info = new JButton("Continuar");
     	info_pac.add(continuar_info);
     	continuar_info.addActionListener(this);
        
     						// ASIGNAR CITA //
        // Este método se encontró en StackOverflow para poder designar tamaño al JPanel
        asig_cita = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 100);
            };
        };
        asig_cita.setBorder(BorderFactory.createTitledBorder("Asignar Cita"));
        // Etiqueta
        JLabel etiqueta_6 = new JLabel("Clave del Paciente: ");
        etiqueta_6.setFont(new Font("verdana", Font.PLAIN, 14));
        asig_cita.add(etiqueta_6);
        // Caja de Texto
        cve_cita = new JTextField(5);
        asig_cita.add(cve_cita);
        // Etiqueta
        JLabel etiqueta_7 = new JLabel("Tipo de cita: ");
        etiqueta_7.setFont(new Font("verdana", Font.PLAIN, 14));
        asig_cita.add(etiqueta_7);
        // ComboBox
        //asig_cita.setBounds(60, 50, 140, 30);
		asig_cita.add(tipo_consulta);
        // Botón
        continuar_cita = new JButton("Continuar");
     	asig_cita.add(continuar_cita);
     	continuar_cita.addActionListener(this);
        
        // Se agregan los JPanels al frame y se les asigna una posición
     	frame.setVisible(true);
        frame.setSize(775, 300);
        frame.add(nvo_pac, BorderLayout.LINE_START);
        frame.add(info_pac, BorderLayout.CENTER);
        frame.add(asig_cita, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(775, 300));
        //frame.pack();// ¿PARA QUE SIRVE?
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aceptar) {
			paciente_nuevo.GUI_nuevoPaciente();
		} else if(e.getSource() == continuar_info) {
			info(clientes);
			paciente_informacion.info_paciente();
		} else if(e.getSource() == continuar_cita){/*
			if(tipo_consulta.getSelectedItem().equals("Doctor General")) {
				
			} else if(tipo_consulta.getSelectedItem().equals("Pediatra")) {
			
			} else if(tipo_consulta.getSelectedItem().equals("Cardiólogo")) {
			
			} else if(tipo_consulta.getSelectedItem().equals("Neurólogo")) {
				
			} else if(tipo_consulta.getSelectedItem().equals("Oftalmólogo")) {
				
			}*/
		} 
		
	}
	
	public void info(ArrayList<Paciente> d) {
		if(cve_info.getText().isEmpty() || (cve_info.getText().length() != 5)){
			JOptionPane.showMessageDialog(rootPane,"Clave Inválida","ERROR",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Si Obtiene el valor del texto");
			String clave = cve_info.getText();
			for(Paciente A : d) {
				if(clave == A.getCve_pac()) {
					paciente_informacion.info_paciente();
				} else {
					JOptionPane.showMessageDialog(rootPane,"La clave no existe","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
