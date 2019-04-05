package paciente;

import java.util.Random;

//Método para generar una clave única a los pacientes al momento de registrarse
public class Clave {
	private String letras = "abcdefghijklmnoprstuvwxyz";
	private char[] alfanumerico = (letras + letras.toUpperCase() + "0123456789").toCharArray();
	
	protected String generarClave() {
		StringBuilder resultado = new StringBuilder();
		for(int i = 0; i < 5; i++) {
			resultado.append(alfanumerico[new Random().nextInt(alfanumerico.length)]);
		}
		return resultado.toString();
	}

}
