package ar.edu.unlam.pb1.letras.ahorcado;

public class PartidaTradicional {

	private Letra palabraAAdivinar[];
	
	public String imprimirPalabraEnElEstado() {
		String resultado = "";
		for(int i=0; i<palabraAAdivinar.length; i++) {
			resultado += palabraAAdivinar[i].visualizar();
		}
		return resultado;
	}
}
