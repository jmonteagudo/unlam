
package ar.edu.unlam.pb1.cartas.blackjack;

import ar.edu.unalm.pb1.cartas.francesa.CartaFrancesa;
import ar.edu.unalm.pb1.cartas.francesa.PalosBarajaFrancesa;
import ar.edu.unalm.pb1.cartas.francesa.ValorCartaFrancesa;

public class Juego {
	
	private static PalosBarajaFrancesa palosPosibles[] = PalosBarajaFrancesa.values();
	private static ValorCartaFrancesa figurasPosibles[] = ValorCartaFrancesa.values();
	private static final int CANTIDAD_MAXIMA_CARTAS = 52;
	private static CartaFrancesa cartasDisponibles[] = new CartaFrancesa[CANTIDAD_MAXIMA_CARTAS];
	
	private CartaFrancesa mazo[];
	private CartaFrancesa cartasJugador[];
	private CartaFrancesa cartasCrupier[];

	public static void inicializarCartasDisponibles() {
		/*
		 * Se debe completar el array cartasDisponibles con cada una de las cartas que se puede tener.
		 * Para esto se recomienda por cada palo (palosPosibles) ir generando las (figurasPosibles) que puede tener cada uno.
		 * Tener presente que luego, las cartas se van a tener que ordenar por alg�n criterio, para eso se puede utilizar el atributo codigo de los objetos de tipo Carta.
		 */
	}
	
	public Juego() {
		/*
		 * Debe generar las condiciones para el correcto funcionamiento del juego.
		 *  
		 */	
	}
	
	public void ordenar() {
		/*
		 *  Se debe ordenar el mazo de cartas de manera ascendente.
		 */		
		
	}
	
	public void mezclar() {
		/*
		 *  Se debe alterar el orden natural del mazo de manera que NO sea posible saber de antemano qu� carta sigue a una carta determinada.
		 *  Si as� lo deseara, el programador puede regenerar los objetos del mazo nuevamente (Vaciar las cartas que pudiera tener el mazo y luego ir completando en cada posici�n cada carta de manera aleatoria).
		 */
		
	}
	
	public CartaFrancesa siguiente() {
		/*
		 *  Determina la siguiente carta que corresponde al jugador y la devuelve a t�tuo informativo
		 */
		return null;
		
	}
	
	
	
	public boolean gano() {
		/*
		 * Eval�a las cartas obtenidas por el jugador contra las cartas del crupier y devuelve true si el jugador result� ganador.
		 */
		return false;
	}
	
	public boolean perdio() {
		/*
		 * Devuelve true si el puntaje del jugador supera los 21 puntos.
		 */
		
		return false;
	}
	
	public void jugarGrupier() {
		/*
		 * El juego del grupier consiste en ir sacando y guardando sus cartas mientras su puntaje sea menor a 17. Cuando el puntaje del grupier es 17 o m�s finaliza su juego.
		 */
	}
	
	public String toString() {
		/*
		 * Devuelve un String con las cartas del jugador y las cartas del crupier
		 */
		
		return "";
	}

}
