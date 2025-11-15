package ar.edu.unlam.pb1.klondike;

import ar.edu.unalm.pb1.francesa.CartaFrancesa;
import ar.edu.unalm.pb1.francesa.Mazo;
import ar.edu.unalm.pb1.francesa.PalosBarajaFrancesa;
import ar.edu.unalm.pb1.francesa.ValorCartaFrancesa;

public class Juego {

	// Atributos
	Mazo mazo;
	private Auxiliar auxiliar;
	private Pila pilas[];
	private final int CANTIDAD_DE_CARTAS_QUE_TIRAN;
	private Destino destinos[];
	private final int CANTIDAD_DE_PILAS;
	private final int CANTIDAD_DE_PILAS_DESTINO;

	// Constructores
	/****
	 * Constructor sin parámetros. Se toma por DEFAULT el nivel 3.
	 * Se recomienda reutilizar el método reiniciar
	 */
	public Juego() {
		this.CANTIDAD_DE_PILAS = 7;
		this.CANTIDAD_DE_CARTAS_QUE_TIRAN = 3;
		this.CANTIDAD_DE_PILAS_DESTINO = 4;
			
		this.reiniciar();
	}
	
	/***
	 * Cpmstrictpr con parámetros
	 * @param nivel del juego. 1 reparte de a una carta, 2 reparte de a 2 cartas y 3 reparte de a 3 cartas.
	 * Se recomienda reutilizar el método reiniciar
	 */
	public Juego(int nivel) {
		this.CANTIDAD_DE_PILAS = 7;
		this.CANTIDAD_DE_CARTAS_QUE_TIRAN = nivel;
		this.CANTIDAD_DE_PILAS_DESTINO = 4;
			
		this.reiniciar();
	}
	
	/****
	 * Lleva el estado del juego a las condiciones iniciales (mazo mezclado, inicializadas, destinos inicializados.
	 */
	public void reiniciar() {
		this.mazo = new Mazo();
		this.auxiliar = new Auxiliar();
		this.pilas = new Pila[CANTIDAD_DE_PILAS];
		this.destinos = new Destino[PalosBarajaFrancesa.values().length];
		
		mazo.mezclar();
		inicializarPilas();
		inicializarDestinos();
	}
	
	/****
	 * Reparte cartas a una pila
	 * @param numeroDePila en donde se deben repartir las cartas
	 * @param cantidadDeCartasARepartir 
	 */
	private void repartirEnPila(int numeroDePila, int cantidadDeCartasARepartir) {
		for(int i=0; i<cantidadDeCartasARepartir; i++) {
			pilas[numeroDePila].repartirCarta(this.mazo.sacarCartaDelMazo());
		}
	}
	
	/****
	 * Genera el estado inicial de las pilas. La pila 1 debe recibir una carta y sucesivamente hasta llegar a la pila 7 que recibe 7 cartas.
	 * Se ssugiere reutilizar el método repartirEnPila
	 */
	private void inicializarPilas() {
		for(int i=0; i<CANTIDAD_DE_PILAS; i++) {
			pilas[i] = new Pila();
			repartirEnPila(i, i+1);
		}
	}
	
	/*****
	 * Inicializa los destinos. Por defult un destino se inica vacío.
	 */
	private void inicializarDestinos() {
		for(int i=0; i<CANTIDAD_DE_PILAS_DESTINO; i++) {
			destinos[i] = new Destino();
		}
	}
	
	
	/****
	 * Reparte una carta al auxiliar
	 */
	public void repartirEnAuxiliar() {
		for(int i=0; i<CANTIDAD_DE_CARTAS_QUE_TIRAN; i++) {
			this.auxiliar.ponerCarta(this.mazo.sacarCartaDelMazo());
		}
	}
	
	/****
	 * Busca una carta en una pila. Llamar al método buscar de la pila
	 * @param pila en donde se debe buscar la carta
	 * @param palo de la pila a buscar
	 * @param valor de la pila a buscar
	 * @return lo que devuelva el método buscar(PalosBarajaFrancesa, ValorCartaFrancesa) de la clase Pila
	 */
	public CartaFrancesa buscar(int pila, PalosBarajaFrancesa palo, ValorCartaFrancesa valor) {
		return pilas[pila].buscar(palo, valor);
	}
	
	/****
	 * Busca una carta en una pila determinada. 
	 * @param pila en donde se debe buscar
	 * @param buscada la carta
	 * @return lo que devuelva el método buscar(CartaFrancesa) de la clase Pila
	 */
	public int buscar(int pila, CartaFrancesa buscada) {
		return pilas[pila].buscar(buscada);
	}
	
	/*****
	 * Mueve la última carta de la pila origen a la última posición de la pila destino.
	 * Se deben considerar los métodos getCarta, sePuedePonerUnaCarta, sacarCarta y ponerCarta de la clase Pila.
	 * @param origen pila
	 * @param destino pila
	 * @return true si la carta se pudo mover o false en caso que no se pueda mover
	 */
	public boolean mover(int origen, int destino) {
		boolean resultado = false;
		
		if(origen>= CANTIDAD_DE_PILAS || destino>=CANTIDAD_DE_PILAS) {
			return false;
		}
		
		Pila pilaOrigen = pilas[origen];
		Pila pilaDestino = pilas[destino];
		CartaFrancesa utlimaCartaEnOrigen = pilas[origen].getCarta();
		
		if(pilaDestino.sePuedePonerUnaCarta(utlimaCartaEnOrigen)) {
			resultado = pilaDestino.ponerCarta(pilaOrigen.sacarCarta());
			resultado = true;
		}
		return resultado;
	}
	
	/****
	 * Busca la carta recibida por parámetro en la pila origen. Si la encuentra, intenta mover a partir de dicha carta la escalera que le sigue a la pila destino
	 * Se recomienda usar los métodos buscar, sePuedeMover, sacarEscalera y ponerEscalera de la clase Pila
	 * @param origen pila
	 * @param destino pila 
	 * @param carta buscada
	 * @return true si se puede mover la escalera que está a continuación de la carta buscada o false en caso que no se pueda
	 */
	public boolean mover(int origen, int destino, CartaFrancesa carta) {
		int posicion = pilas[origen].buscar(carta);
		boolean resultado = false;
		
		if(pilas[origen].sePuedeMover(posicion)) {
			pilas[destino].ponerEscalera(pilas[origen].sacarEscalera(posicion));
			resultado = true;
		}
		return resultado;
	}
	
	/****
	 * Determina si el jugador ha completado el juego. Para que esto suceda, ningún desino debe devolver flase ante la invocación del método estaCompleto()
	 * @return
	 */
	public boolean competoElJuego() {
		for(int i=0; i<destinos.length; i++) {
			if(!destinos[i].estaComplet0()) {
				return false;
			}
		}
		return true;
	}
	
	/****
	 * Devuelve el estado del juego.
	 * Se debe contemplar el mazo, el auxiliar los destinos y las pilas
	 */
	public String toString() {
		String resultado = "";
		
		resultado += this.mazo.toString();
		resultado += "\n" + this.auxiliar.toString();
		resultado += "\nDestinos: " + imprimirDestinos();
		resultado += "\nPilas: \n" + imprimirPilas(); 
		
		return resultado;
	}
	
	/***
	 * getter del atributo auxiliar
	 * @return
	 */
	public Auxiliar getAuxiliar() {
		return auxiliar;
	}
	
	/****
	 * Intenta mover la última carta del auxiliar a la úlima posición de la pila
	 * Se recomienda utilizar los métodos ponerCarta de puila y sacarCarta de Auxiliar 
	 * @param pila destino
	 * @return true si se pudo mover o false en caso contrario (por ejemplo la pila está vacía pero la carta a mover no es un REY o la carta no es la inmediata anterior al valor de la última posición de la pila
	 */
	public boolean moverDeAuxiliarAPila(int pila) {
		if(pilas[pila].ponerCarta(auxiliar.getUltimaCarta())) {
			auxiliar.sacarCarta();
			return true;
		}
		return false;
	}
	
	/*****
	 * Intenta mover del auxiliar al destino
	 * Se recomienda utilizar los métodos getUltimaCarta, this.buscarDestino, ponerCarta de la clase Destino y sacarCarta de la clase Auxiliar
	 * @return true si se pudo mover o false en caso contrario
	 */
	public boolean moverDeAuxiliarADestino() {
		CartaFrancesa delAuxiliar = auxiliar.getUltimaCarta(); 
		Destino porPalo = buscarDestino(delAuxiliar.getPalo());
		if(porPalo.ponerCarta(delAuxiliar)) {
			auxiliar.sacarCarta();
			return true;
		}
		return false;
	}
	
	/*****
	 * Devuelve una String con el estado de los destinos. Se utilza invoca desde el método toString.
	 * @return la concatenación del estado de cada destino con algún separado
	 */
	private String imprimirDestinos() {
		String destinosImpresos = "";
		for(int i=0; i<destinos.length; i++) {
			destinosImpresos += " | " + destinos[i].toString();
		}
		
		return destinosImpresos;
	}
	
	/****
	 * Determina la cantidad de cartas que posee la pila mas larga. Sirve para poder imprimir las pilas de una forma más estética 
	 * @return el tamaño de la pila más larga
	 */
	private int tamanioDeLaPilaMasLarga() {
		int mayorTamanio = 0;
		for(int i=0; i<CANTIDAD_DE_PILAS; i++) {
			if(pilas[i]!=null && pilas[i].getCantidadDeCartasEnLaPila()>mayorTamanio) {
				mayorTamanio = pilas[i].getCantidadDeCartasEnLaPila();
			}
		}
		return mayorTamanio;
	}
	
	/*****
	 * Devuelve una String con el estado de las pilas. Se utilza invoca desde el método toString.
	 * @return la concatenación del estado de cada pila con algún separado
	 */
	private String imprimirPilas() {
		String pilasImpresas = "\n==================================================";
		for(int i=0; i<tamanioDeLaPilaMasLarga(); i++) {
			pilasImpresas += " \n ";
			for(int j=0; j<CANTIDAD_DE_PILAS; j++) {
				if(pilas[j]!=null && pilas[j].getCarta(i)!=null) {
					pilasImpresas += pilas[j].getCarta(i) + " |" ;	
				}
				else {
					pilasImpresas += "      |" ;
				}	
			}
		}
		pilasImpresas += "\n==================================================";
		
		return pilasImpresas;
	}
	

	/*****
	 * Intenta llevar a destino la úlitma carta de una pila determianda
	 * Se recomienda considerar los métodos getCarta de la clase Pila, this.buscarDestino ponerCarta de Destino y sacarCarta de Pila
	 * @param pilaOrigen
	 * @return true si la carta se pudo llevar a destino, o false en caso contraro
	 */
	public boolean llevarADestino(int pilaOrigen) {
		
		Pila origen = pilas[pilaOrigen];
		CartaFrancesa cartaQueSeDeseaMover = origen.getCarta(origen.getPosicionUltimaCarta());
		Destino destino = buscarDestino(cartaQueSeDeseaMover.getPalo());
		
		if(origen == null || cartaQueSeDeseaMover == null || destino == null) {
			return false;
		}
		
		if(destino.ponerCarta(cartaQueSeDeseaMover)) {
			origen.sacarCarta();
			return true;
		}
		
		return false;
	}
	
	/****
	 * Busca entre todos los destinos si ya hay alguno con el palo buscado
	 * @param buscado el palo que se está buscando
	 * @return el Destino que contiene a ese palo o null en caso que aún no se haya iniciado ningún destino con ese palo
	 */
	private Destino buscarDestino(PalosBarajaFrancesa buscado) {
		int destinoNulo = -1;
		Destino porPalo = null;
		
		for(int i=0; i<destinos.length; i++) {
			if(destinos[i].getPalo() == null && destinoNulo == -1) {
				destinoNulo = i;
			}
			if(destinos[i].getPalo()==buscado) {
				porPalo = destinos[i];
			}
		}
		if(porPalo==null) {
			return destinos[destinoNulo];
		}
		else {
			return porPalo;
		}
	}
}
