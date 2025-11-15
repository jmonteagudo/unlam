package ar.edu.unalm.pb1.cartas.francesa;

/*****
 * @author jmonteagudo@gmail.com
 */
public class Mazo {

	private CartaFrancesa frances[];
	private int cantidadDeCartasEnElMazo;

	/*****
	 * Constructor de la clase
	 */
	public Mazo() {
		inicializar();
		cantidadDeCartasEnElMazo=BarajaFrancesa.baraja.length;
	}
	
	/***
	 * Método encargado de inicializar las cartas del mazo. Se obtienen de la baraja.
	 */
	public void inicializar() {
		this.frances = new CartaFrancesa[BarajaFrancesa.baraja.length];
		for(int i=0; i< BarajaFrancesa.baraja.length; i++) {
			frances[i] = new CartaFrancesa(BarajaFrancesa.baraja[i].getPalo(), BarajaFrancesa.baraja[i].getValor());
		}
		cantidadDeCartasEnElMazo = frances.length-1;
	}
	
	/***
	 * Método encargado de calcular una posición aleatoria dentro de las cartas que forman parte del mazo. Se puede utilizar en el método mezclar
	 * @return la posición aleatoria calculada
	 */
	private int calcularPosicionAleatoria() {
		int posicion = (int)(Math.random()*frances.length);
		return posicion;
	}
	
	/***
	 * Método encargado de mezclar las cartas del mazo
	 */
	public void mezclar() {
		int posicion = 0;
		CartaFrancesa auxiliar = null;
		for(int i=0; i<frances.length; i++) {
			posicion = calcularPosicionAleatoria();
			auxiliar = frances[posicion];
			frances[posicion] = frances[i];
			frances[i] = auxiliar;
		}
	}
	
	/****
	 * Método get para el atributo cantidadDeCartasEnElMazo
	 */
	public int getCantidadDeCartasEnElMazo() {
		return cantidadDeCartasEnElMazo;
	}

	/****
	 * Devuelve la posición de la última carta del mazo 
	 * @return la posición de la última carta del mazo
	 */
	private int getPosicionUltimaCarta() {
		return this.cantidadDeCartasEnElMazo-1;
	}
	
	/****
	 * Saca una carta del mazo. Se debe contemplar el hecho que al sacar una carga, esa carta ya no está presente en el mazo.
	 * @return la carta retirada del mazo
	 */
	public CartaFrancesa sacarCartaDelMazo() {
		CartaFrancesa actual = null;
		if(cantidadDeCartasEnElMazo>0) {
			actual = frances[getPosicionUltimaCarta()];
			frances[getPosicionUltimaCarta()] = null;
			cantidadDeCartasEnElMazo--;			
		}
		return actual;
	}
	
	/****
	 * Saca una determinada cantidad de cartas del mazo. Se sugiere reutilizar el código de sacarCartaDelMazo()
	 * @param cantidadDeCartas
	 * @return
	 */
	public CartaFrancesa[] sacarCartaDelMazo(int cantidadDeCartas) {
		CartaFrancesa resultado[] = new CartaFrancesa[cantidadDeCartas];
		
		for(int i=0; i<cantidadDeCartas; i++) {
			resultado[i] = frances[getPosicionUltimaCarta()];
			frances[getPosicionUltimaCarta()] = null;
			cantidadDeCartasEnElMazo--;
		}
		return resultado;
	}

	/****
	 * Devuelve en formato String el estado del mazo. Dependiendo de las características del juego, suele ser una buena idea sólo devolver la cantidad de cartas que contiene el mazo.
	 */
	public String toString() {
		return "Mazo: " + getCantidadDeCartasEnElMazo() + " cartas ";
	}
}
