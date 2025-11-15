package ar.edu.unlam.pb1.cartas.solitario.klondike;

import ar.edu.unalm.pb1.cartas.francesa.BarajaFrancesa;
import ar.edu.unalm.pb1.cartas.francesa.CartaFrancesa;
import ar.edu.unalm.pb1.cartas.francesa.PalosBarajaFrancesa;
import ar.edu.unalm.pb1.cartas.francesa.ValorCartaFrancesa;

public class Pila {

	private CartaFrancesa cartas[];
	private int cantidadDeCartasEnLaPila;
	
	/****
	 * Constructor de la clase
	 */
	public Pila() {
		this.cartas = new CartaFrancesa[BarajaFrancesa.baraja.length];
		this.cantidadDeCartasEnLaPila = 0;
	}
	
	/****
	 * Agrega una nueva carta en la pila
	 * @param nueva carta a agregar
	 * @return true si se pudo agregar o false en caso que no se pueda
	 */
	public boolean repartirCarta(CartaFrancesa nueva) {
		boolean sePudoPoner = false;
		if(cantidadDeCartasEnLaPila<cartas.length ) {
			cartas[cantidadDeCartasEnLaPila++] = nueva;
			nueva.setDadaVuelta(true);
			sePudoPoner = true;
		}
		
		return sePudoPoner;
	}
	
	/****
	 * Pone una nueva carta en la pila.
	 * Tener en cuenta que si la pila está vacía, sólo se puede agregar un REY. Sino solo se puede formar una escalera (sin importar el palo)
	 * @param nueva carta
	 * @return true si se pudo poner la carta en la pila o false en caso contrario
	 */
	public boolean ponerCarta(CartaFrancesa nueva) {
		boolean sePudoPoner = false;
		
		if(cantidadDeCartasEnLaPila==0) {
			if(nueva.getValor() == ValorCartaFrancesa.REY) {
				cartas[cantidadDeCartasEnLaPila++] = nueva;
				nueva.setDadaVuelta(true);
				sePudoPoner = true;
			}
			else {
				return false;
			}
		}
		
		int valorUltimaCarta = cartas[getPosicionUltimaCarta()].getValor().getValorNumerico();
		
		if(cantidadDeCartasEnLaPila<cartas.length && (cantidadDeCartasEnLaPila==0 || (valorUltimaCarta == nueva.getValor().getValorNumerico()+1))) {
			cartas[cantidadDeCartasEnLaPila++] = nueva;
			nueva.setDadaVuelta(true);
			sePudoPoner = true;
		}
		
		return sePudoPoner;
	}
	
	private CartaFrancesa sacarCarta(int posicion) {
		CartaFrancesa aSacar = null;
		if(posicion<cartas.length) {
			aSacar = cartas[posicion];
			cartas[posicion] = null;
			cantidadDeCartasEnLaPila--;
		}
		return aSacar;
	}
	
	public CartaFrancesa sacarCarta() {
		return this.sacarCarta(getPosicionUltimaCarta());
	}
	
	public CartaFrancesa buscar(PalosBarajaFrancesa palo, ValorCartaFrancesa valor) {
		for(int i=0; i<cartas.length; i++) {
			if(cartas[i]!=null && cartas[i].getPalo() == palo && cartas[i].getValor() == valor) {
				return cartas[i];
			}
		}
		return null;
	}
	
	public int buscar(CartaFrancesa buscada) {
		for(int i=0; i<=cartas.length; i++) {
			if(cartas[i]!=null && cartas[i].getPalo() == buscada.getPalo() && cartas[i].getValor() == buscada.getValor()) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean sePuedeMover(int posicion) {
		boolean hayEscalera = true;
		int i = posicion;
		
		while(hayEscalera && cartas[i] != null && cartas[i+1] != null) {
			if(agregarALaEscalera(i)==null) {
				hayEscalera = false;
			}
			i++;
		} 
		return hayEscalera;
	}
	
	public boolean sePuedePonerUnaCarta(CartaFrancesa nueva) {
		ValorCartaFrancesa valorNuevaCarta = nueva.getValor();
		CartaFrancesa ultima = null;
		int valorNumericoUltimaCarta = 0;
		int valorNumericoNuevaCarta = nueva.getValor().getValorNumerico();
		if(cantidadDeCartasEnLaPila>0) {
			ultima = getCarta();
			valorNumericoUltimaCarta = ultima.getValor().getValorNumerico();
		}
		
		if((ultima == null && valorNuevaCarta == ValorCartaFrancesa.REY) || (ultima!=null && valorNumericoUltimaCarta == (valorNumericoNuevaCarta+1)) ) {
			return true;
		}
		return false;
	}
	
	public CartaFrancesa[] sacarEscalera(int posicion) {
		int cantidadDeCartasEnEscalera = 0;
		if(!sePuedeMover(posicion)) {
			return null;
		}
		CartaFrancesa escalera[] = new CartaFrancesa[ValorCartaFrancesa.values().length];
		int i = posicion;
		while(cartas[i]!=null){
			escalera[cantidadDeCartasEnEscalera] = sacarCarta(i);
			i++;
			cantidadDeCartasEnEscalera++;
		}
		return escalera;
	}
	
	public void ponerEscalera(CartaFrancesa escalera[]) {
		int i=0;
		while(i<escalera.length && escalera[i]!=null) {
			ponerCarta(escalera[i]);
			i++;
		}
	}
	
	public int getCantidadDeCartasEnLaPila() {
		return this.cantidadDeCartasEnLaPila;
	}
	
	public CartaFrancesa getCarta(int posicion) {
		return cartas[posicion];
	}
	
	public CartaFrancesa getCarta() {
		return cartas[getPosicionUltimaCarta()];
	}
	
	public PalosBarajaFrancesa completarPalo() {
		PalosBarajaFrancesa resultado = null;
		CartaFrancesa auxiliar[] = new CartaFrancesa[ValorCartaFrancesa.values().length];
		int cantidadDeCartasEscalonadas = 1;
		auxiliar[cantidadDeCartasEscalonadas] = cartas[0];
		int inicioEscalera = 0;
		
		for(int i=0; i<this.cantidadDeCartasEnLaPila; i++) {
			CartaFrancesa proxima = agregarALaEscalera(i);
			
			if(proxima!=null) {
				auxiliar[cantidadDeCartasEscalonadas++] = cartas[i++];	
			}
			else {
				cantidadDeCartasEscalonadas = 0;
				inicioEscalera=i+1;
			}
		}
		
		if(cantidadDeCartasEscalonadas==ValorCartaFrancesa.values().length) {
			resultado = auxiliar[0].getPalo();
			sacarEscalera(inicioEscalera);
		}
		return resultado;
	}
	
	private CartaFrancesa agregarALaEscalera(int i) {
		PalosBarajaFrancesa paloActual = cartas[i].getPalo();
		PalosBarajaFrancesa paloSiguiente = cartas[i+1].getPalo();
		int valorActual = cartas[i].getValor().getValorNumerico();
		int valorSiguiente = cartas[i+1].getValor().getValorNumerico();
		
		if(paloActual == paloSiguiente && valorActual == (valorSiguiente+1)) {
			return cartas[i+1];
		}
		
		return null;
	}
	
	public String toString() {
		String pilaImpresa = "";
		
		for(int i=0; i<cartas.length; i++) {
			if(cartas[i]!=null)
				pilaImpresa += cartas[i] + " | ";
		}
		
		return pilaImpresa;
	}
	
	public int getPosicionUltimaCarta() {
		return this.cantidadDeCartasEnLaPila-1;
	}
}
