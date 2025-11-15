package ar.edu.unlam.pb1.klondike;

import ar.edu.unalm.pb1.francesa.CartaFrancesa;
import ar.edu.unalm.pb1.francesa.PalosBarajaFrancesa;
import ar.edu.unalm.pb1.francesa.ValorCartaFrancesa;

/*****
 * Los objetos de esta clase se utilizan para ir guardando las escaleras de cada palo. El objetivo del juego es completar cada "Destino" con todas las cartas de cada palo.
 * @author jmonteagudo@gmail.com
 */
public class Destino {

	private PalosBarajaFrancesa palo;
	private CartaFrancesa cartas[];
	private int cantidadDeCartasEnElDestino;
	
	/****
	 * Constructor de la clase
	 */
	public Destino() {
		this.palo = null;
		this.cartas = new CartaFrancesa[ValorCartaFrancesa.values().length];
		this.cantidadDeCartasEnElDestino = 0;
	}
	
	/***
	 * Devuelve la posición de la última carta en el destino
	 * @return posición de la última carta
	 */
	private int getPosicionUltimaCarta() {
		return this.cantidadDeCartasEnElDestino-1;
	}
	
	
	public PalosBarajaFrancesa getPalo() {
		return palo;
	}

	/****
	 * Setter del atributo palo
	 * @param palo
	 */
	public void setPalo(PalosBarajaFrancesa palo) {
		this.palo = palo;
	}
	
	/****
	 * Agregaa una nueva carta al "Destino". Se debe validar:
	 * a. Que Destino esté vacío y que la carta sea un AS (En ese caso el destino va a serl del palo de la carta nueva. O,
	 * b,Que el palo de la carta sea igual al palo del destino y que la úlimta carta en el paro sea la inmediata anterior a la nueva carta
	 * @param nueva
	 * @return
	 */
	public boolean ponerCarta(CartaFrancesa nueva) {

		if(cantidadDeCartasEnElDestino==0) {
			if(nueva.getValor() == ValorCartaFrancesa.AS) {
				this.cartas[cantidadDeCartasEnElDestino++] = nueva;
				this.palo = nueva.getPalo();
				return true;
			}
		}
		else {
			CartaFrancesa ultimaCarta = this.cartas[getPosicionUltimaCarta()];
			int ultimoValor = ultimaCarta.getValor().getValorNumerico();
			
			if(ultimaCarta!=null && palo == nueva.getPalo() && ultimoValor == (nueva.getValor().getValorNumerico()-1)) {
				this.cartas[cantidadDeCartasEnElDestino++] = nueva;
				return true;
			}
		}
		
		return false;
	}
	
	/****
	 * Devuelve el estado del destino. Se recomienda simplemente mostrar la última carta que se envió o la leyenda "Vacío" si aún no se agregó ninguna carta.
	 */
	public String toString() {
		String resultado = "";
		
		if(cantidadDeCartasEnElDestino==0) {
			resultado += " Vacio ";
		}
		else {
			resultado += cartas[getPosicionUltimaCarta()];
		}
		
		return resultado;
	}
	
	/*****
	 * Determina si el destino está completo
	 * @return true si están todas las cartas del palo asociado al destino (la última carta debe ser el REY) o false en caso que falte alguna carga
	 */
	public boolean estaComplet0() {
		if(cantidadDeCartasEnElDestino>0) {
			CartaFrancesa ultimaCarta = cartas[getPosicionUltimaCarta()];
			if(ultimaCarta.getValor()==ValorCartaFrancesa.REY) {
				return true;
			}
		}
		return false;
	}
}
