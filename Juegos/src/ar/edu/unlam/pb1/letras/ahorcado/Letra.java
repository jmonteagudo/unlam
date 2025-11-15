package ar.edu.unlam.pb1.letras.ahorcado;

public class Letra {

	private char letra;
	private boolean descubierta;
	
	public String visualizar() {
		if(descubierta) {
			return Character.toString(letra);
		}
		else {
			return " _ ";
		}
	}
}
