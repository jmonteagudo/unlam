package ar.edu.unlam.pb1.espaniola;

public class Mazo {

	private CartaEspaniola espaniol[];
	private int cantidadDeCartasEnElMazo;
	
	public Mazo() {
		inicializar();
		cantidadDeCartasEnElMazo=0;
	}
	
	private void inicializar() {
		this.espaniol = new CartaEspaniola[BarajaEspaniola.espaniola.length];
		for(int i=0; i< BarajaEspaniola.espaniola.length; i++) {
			espaniol[i] = BarajaEspaniola.espaniola[i];
		}
		cantidadDeCartasEnElMazo = espaniol.length-1;
	}
	
	public void mezclar() {
		int posicion = 0;
		CartaEspaniola auxiliar = null;
		for(int i=0; i<espaniol.length; i++) {
			posicion = calcularPosicionAleatoria();
			auxiliar = espaniol[posicion];
			espaniol[posicion] = espaniol[i];
			espaniol[i] = auxiliar;
		}
	}
	
	private int calcularPosicionAleatoria() {
		int posicion = (int)(Math.random()*espaniol.length);
		return posicion;
	}
	
	private CartaEspaniola sacarCartaDelMazo() {
		CartaEspaniola actual = espaniol[cantidadDeCartasEnElMazo];
		espaniol[cantidadDeCartasEnElMazo] = null;
		cantidadDeCartasEnElMazo--;
		return actual;
	}
}
