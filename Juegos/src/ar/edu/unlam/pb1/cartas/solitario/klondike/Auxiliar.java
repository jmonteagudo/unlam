package ar.edu.unlam.pb1.cartas.solitario.klondike;

import ar.edu.unalm.pb1.cartas.francesa.BarajaFrancesa;
import ar.edu.unalm.pb1.cartas.francesa.CartaFrancesa;

/*****
 * @author jmonteagudo@gmail.com
 */
public class Auxiliar {

	private CartaFrancesa cartas[];
	private int cantidadDeCartas;
	
	/****
	 * Constructor de la clase
	 */
	public Auxiliar() {
		this.cartas = new CartaFrancesa[BarajaFrancesa.baraja.length];
		this.cantidadDeCartas = 0;
	}
	
	/*****
	 * Devuelve la la última carta (que es la carta que se puede usar) del auxiliar
	 * @return la última carta del auxiliar
	 */
	public CartaFrancesa getUltimaCarta() {
		return cartas[cantidadDeCartas-1];
	}
	
	/*****
	 * Agrega una nueva carta en el auxiliar
	 * @param nueva carta a agregar
	 * @return true si la pudo agregar o false en caso contrario (por ejemplo el auxiliar está lleno)
	 */
	public boolean ponerCarta(CartaFrancesa nueva) {
		boolean sePudoPoner = false;
		if(nueva!= null && cantidadDeCartas<cartas.length) {
			cartas[cantidadDeCartas++] = nueva;
			nueva.setDadaVuelta(true);
			sePudoPoner = true;
		}
		
		return sePudoPoner;
	}
	
	/****
	 * Saca la úlitma carta del auxiliar. Notar la diferencia con getUltimaCarta, dado que en este caso, al sacar la carta, ya no estará presente en el auxiliar
	 * @return la última carta del auxiliar 
	 */
	public CartaFrancesa sacarCarta() {
		CartaFrancesa sacada = null;
		if(cantidadDeCartas>0) {
			sacada = cartas[cantidadDeCartas-1];
			cartas[cantidadDeCartas-1] = null; 
			cantidadDeCartas--;
		}
		
		return sacada;
	}	
	
	/****
	 * Devuelve el estado del auxiliar. Se recomiendo mostrar las cartas con algún sepadador
	 */
	public String toString() {
		String resultado = "Auxiliar: ";
		
		if(cantidadDeCartas == 0) {
			resultado += "vacio";
		}

		for(int i = 0; i<cantidadDeCartas; i++) {
			resultado += " " + cartas[i] + " | ";	
		}
		
		return resultado;
	}
}
