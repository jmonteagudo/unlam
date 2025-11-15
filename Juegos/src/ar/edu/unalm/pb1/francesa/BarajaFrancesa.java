package ar.edu.unalm.pb1.francesa;


/*****
 * @author jmonteagudo@gmail.com
 */
public class BarajaFrancesa {

	public static CartaFrancesa baraja[] = new CartaFrancesa[52];
	
	/****
	 * Este es el método que se ejecuta previo a poder utilizar una clase en Java. Es una especie de "Constructo" de la clase
	 */
	static {
		inicializarBaraja();
	}
	
	/****
	 * Este método se encarga de inicializar la baraja, de forma tal que al momento de usuarla se dispongan de todas las cartas necesarias.
	 */
	public static void inicializarBaraja() {
		PalosBarajaFrancesa palosDisponibles[] = PalosBarajaFrancesa.values();
		ValorCartaFrancesa valoresDisponibles[] = ValorCartaFrancesa.values();
		int contadorDeCartas = 0;
		
		for(int i=0; i<palosDisponibles.length; i++) {
			for(int j=0; j<valoresDisponibles.length; j++) {
				baraja[contadorDeCartas] = new CartaFrancesa(palosDisponibles[i], valoresDisponibles[j]);
				contadorDeCartas++;
			}
		}
	}
}
