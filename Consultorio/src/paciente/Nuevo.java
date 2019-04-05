package paciente;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import paciente.Clave;
import paciente.Nuevo;
import paciente.Paciente;
import secretaria.Menu;

public class Nuevo extends JFrame implements ActionListener{
	//ArrayList<Object> formato = new ArrayList<>();
	//Menu menu = new Menu();
	
	private Paciente p;
	//private ArrayList<Paciente> consultorio;
	
	//ValidarCalendario f;
	
	Clave clave = new Clave();
	
	private String cve;
	
	// Frame
	private JFrame frame = new JFrame("Nuevo Paciente");
	// JPanel
	private JPanel registro;
	// Botón
	private JButton registrar;
	// Cajas de texto
	private JTextField aps, noms, corr, tel;
	// Calendario
	protected JDateChooser calendario;
	
	
	JLabel edad;
	
	public static void main(String[] args) {
		Nuevo nvo_pac = new Nuevo();
		nvo_pac.GUI_nuevoPaciente();
	}
	
	public void GUI_nuevoPaciente() {
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
								// REGISTRO //
		// Panel
		registro = new JPanel();
		this.getContentPane().add(registro);
		registro.setBorder(BorderFactory.createTitledBorder("Registrar Paciente"));
		registro.setLayout(null);
		// Componentes
		// Nombre
		JLabel etiqueta_1 = new JLabel("Nombre(s):");
		etiqueta_1.setBounds(20, 15, 100, 30);
		etiqueta_1.setFont(new Font("verdana", Font.PLAIN, 15));
		registro.add(etiqueta_1);
		noms = new JTextField(20);
		noms.setBounds(115, 18, 160, 25);
		registro.add(noms);
		
		// Apellido
		JLabel etiqueta_2 = new JLabel("Apellido(s):");
		etiqueta_2.setBounds(20, 40, 100, 30);
		etiqueta_2.setFont(new Font("verdana", Font.PLAIN, 15));
		registro.add(etiqueta_2);
		aps = new JTextField(20);
		aps.setBounds(115, 44, 160, 25);
		registro.add(aps);

		// Fecha de Nacimiento
		JLabel etiqueta_3 = new JLabel("Fecha de Nacimiento:");
		etiqueta_3.setBounds(20, 65, 200, 30);
		etiqueta_3.setFont(new Font("verdana", Font.PLAIN, 15));
		registro.add(etiqueta_3);
		calendario = new JDateChooser();
		calendario.setBounds(18, 90, 200, 30);
		registro.add(calendario);

		JLabel formato_fecha = new JLabel("dd/mm/yyyy");
		formato_fecha.setBounds(225, 90, 250, 30);
		formato_fecha.setFont(new Font("Arial", Font.ITALIC, 12));
		registro.add(formato_fecha);
		
		// Correo Electrónico
		JLabel etiqueta_4 = new JLabel("Correo Electrónico:");
		etiqueta_4.setBounds(20, 115, 250, 30);
		etiqueta_4.setFont(new Font("verdana", Font.PLAIN, 15));
		registro.add(etiqueta_4);
		corr = new JTextField(35);
		corr.setBounds(167, 119, 255, 25);
		registro.add(corr);
		
		// Teléfono
		JLabel etiqueta_5 = new JLabel("Teléfono:");
		etiqueta_5.setBounds(20, 140, 150, 30);
		etiqueta_5.setFont(new Font("verdana", Font.PLAIN, 15));
		registro.add(etiqueta_5);
		tel = new JTextField(35);
		tel.setBounds(95, 144, 150, 25);
		registro.add(tel);
		
		// Botón de registrar
		registrar = new JButton("Registrar");
		registrar.setBounds(310, 170, 95, 30);
		registro.add(registrar);
		registrar.addActionListener(this);
		
		

		edad = new JLabel("Edad:");
		registro.add(edad);
		edad.setBounds(200, 190, 300, 30);
		
		
		frame.setVisible(true);
		frame.setSize(435, 235);
		frame.add(registro);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(435, 235));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == registrar) {
			validacion();
		}
		
		
		
		// Método para calcular la edad
		SimpleDateFormat sf =  new SimpleDateFormat("yyyy-MMMMMM-dd");
		String s = sf.format(calendario.getDate());
		LocalDate today = LocalDate.now();
			String arr[] = s.split("-");
			int year = Integer.parseInt(arr[0]);
			
			Month month = (Month.valueOf(arr[1].toUpperCase()));
			int day = Integer.parseInt(arr[2]);
			
			LocalDate birthday = LocalDate.of(year, month, day);
			
			Period p = Period.between(birthday, today);
			
			int edad = (p.getYears());
			
			System.out.println(edad);
		
	}
	
	
	private void validacion() {
		boolean vct = false;
		boolean vc = false;
		// Método para validar los campos vacíos
		if(noms.getText().isEmpty() || aps.getText().isEmpty() || noms.getText().isEmpty() || corr.getText().isEmpty() || tel.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Faltan datos por llenar", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			vct = true;
		}
				 
		// Método para validar calendario
		try{
			boolean caso = verificarFecha();
			if(caso == true){
				//Date d = calendario.getDate();//Obtiene la fecha del calendario
		        vc = true;
				// Le da formato a la fecha
				//f = new ValidarCalendario(d);
		        //formato.add(f);///Añade un nuevo objeto
		        //String titulos[]={"Date","dd/mm/aaaa"};
		            /*
		                DefaultTableModel m=new DefaultTableModel(null,titulos);
		                m.setRowCount(formato.size());///Aumenta una nueva fila a la tabla
		                tblFormatos.setModel(m);
		                ///Llena la tabla llamando a cada objeto de la Lista
		                for(int i = 0; i < formato.size(); i++){
		                    Formatos forma=(Formatos) formato.get(i);
		                    tblFormatos.setValueAt(forma.getDate(),i,0);
		                    tblFormatos.setValueAt(forma.getFecha(),i,1);
		                    tblFormatos.setValueAt(forma.getHora(),i,2);
		                }*/
		                     
			}else{
				getToolkit().beep();
		        JOptionPane.showMessageDialog(rootPane,"La fecha seleccionada es mayor a la actual","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e1){
			getToolkit().beep();
			JOptionPane.showMessageDialog(rootPane,"Elija una fecha","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		// Se guardan los datos
		if((vct && vc) == true) {
			//capturar();
			Arreglo();
		}
	}

	private boolean verificarFecha(){
        Date dat = new Date();// Instancia la fecha para obtener la del sistema
        
        if(calendario.getDate().getTime() <= dat.getTime()){ //Compara si la fecha seleccionada es mayor o igual a la fecha actual
            return true;
        }
        return false;
    }
	
	private void Arreglo(){
		ArrayList<Paciente> consultorio = p.getClientes();
		JOptionPane.showMessageDialog(null, "pt.1 ¿SE GUARDARON?");
		capturar(consultorio);
		//return consultorio;
	}
	
	private void capturar(ArrayList<Paciente> consultorio) {
		cve = clave.generarClave();
		String apellidos = aps.getText();
		String nombres = noms.getText();
		Date nacimiento = calendario.getDate();
		String correo = corr.getText();
		String telefono = tel.getText();
		Paciente pacientes = new Paciente(cve, apellidos, nombres, nacimiento, correo, telefono);
		consultorio.add(pacientes);
		//p.setClientes(consultorio);
		JOptionPane.showMessageDialog(null, "Paciente: " + nombres + apellidos + "\nClave: " + cve);
		//Arreglo_Imp(consultorio);
		Arreglo_Imp(consultorio);
		//info(clientes);
		
		//Arreglo(consultorio);
		
	}
	
	private void imprimir(ArrayList<Paciente> consultorio) {
		System.out.println("Matrícula\tApellido Paterno\tApellido Materno\tNombre(s)\t\tCarrera\t\tGénero");
		for(Paciente A: consultorio) { // For mejorado.
			System.out.print(A.getCve_pac() + "\t\t" + A.getAps_pac() + "\t\t" + A.getNom_pac() + "\t\t\t" + A.getFnac_pac() + "\t\t" + A.getTel_pac() + "\t\t" + A.getCorr_pac() + "\n");
		}
	}
	
	
	private void Arreglo_Imp(ArrayList<Paciente> consultorio){
		JOptionPane.showMessageDialog(null, "pt.2 ¿SE IMPRIMIERON?");
		//ArrayList<Paciente> lista = p.getClientes();
		imprimir(consultorio);
		
	}

}
