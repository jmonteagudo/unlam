package ar.edu.unlam.pb1.klondike;

import java.util.Arrays;
import java.util.Scanner;

import ar.edu.unalm.pb1.francesa.CartaFrancesa;
import ar.edu.unalm.pb1.francesa.PalosBarajaFrancesa;
import ar.edu.unalm.pb1.francesa.ValorCartaFrancesa;

/******
 * @author jmonteagudo@gmail.com
 * 
 */
public class InterfazSolictario {
	
	private static Scanner teclado = new Scanner (System.in);
	private static Juego juego;
	private static MenumSolitarioKlondike opcionesDelJuego[] = MenumSolitarioKlondike.values();

	/*****
	 * Método principal del proyecto, donde se desarrolla la interfaz con el usuario.
	 * @param args argumentos que se envían en la llamada al programa desde la línea de comandos
	 */
	public static void main(String[] args) {
		
		MenumSolitarioKlondike opcionSeleccionada = null;
		int nivel = 0;
	
		mostrarPorPantalla("Bienvenido al Solitario");
		
		nivel = ingresarEntero("Ingrese el nivel 1 (Facil), 2 (Medio) o 3 (Dificil)");
		juego = new Juego(nivel);
				
		do {
			mostrarPorPantalla(juego.toString());
			opcionSeleccionada = gestionarMenu();
			ejecutarAccion(opcionSeleccionada);
		} while(opcionSeleccionada!=MenumSolitarioKlondike.SALIR && !juego.competoElJuego());
	}
	
	/*****
	 * Imprime un mensaje de tipo String por la salida estándar.
	 * 
	 * @param mensaje mensaje que se desea imprimir
	 * 
	 */
	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
	
	/****
	 * Método encargado de gestionar la opción elegida por el usuario.
	 * @return la opción seleccionada por el usuario.
	 */
	private static MenumSolitarioKlondike gestionarMenu() {
		MenumSolitarioKlondike opcionSeleccionada = null;
		
		for(int i=0; i<opcionesDelJuego.length; i++) {
			mostrarPorPantalla(opcionesDelJuego[i].toString());
		}
		
		opcionSeleccionada = opcionesDelJuego[teclado.nextInt()-1];
		
		return opcionSeleccionada;
	}
	
	/****
	 * Método encargado de ejecutar la acción deseada.
	 * @param accion que se desea realizar.
	 */
	private static void ejecutarAccion(MenumSolitarioKlondike accion) {
		switch(accion) {
		case REPARTIR:
			repartir();
			break;
		case USAR_CARTA:
			usarCarta();
			break;
		case MOVER_UNA_CARTA:
			moverUnaCarta();
			break;
		case MOVER_ENTRE_PILAS:
			mover();
			break;
		case LLEVAR_A_DESTINO:
			llevarCartaADestino();
			break;
		case REINICIAR:
			reiniciar();
			break;
		case SALIR:
			mostrarPorPantalla("Saliendo");
		}
	}
	
	/***
	 * Gestiona la interacción con el usuario para reiniciar el juego.
	 * 
	 */
	private static void reiniciar() {
		juego.reiniciar();
	}

	/****
	 * Gestiona la interacción con el usuario para el movimiento de una carta de una pila a otra.
	 */
	private static void moverUnaCarta() {
		int pilaOrigen = 0;
		int pilaDestino = 0;
		boolean resultado = false;
				
		pilaOrigen = ingresarEntero("Ingrese el n�mero de pila origen");
		pilaDestino = ingresarEntero("Ingrese el n�mero de pila destino");

		resultado = juego.mover(pilaOrigen, pilaDestino);
		
		if(!resultado) {
			imprimirMovimientoNoPermitido();
		}
	}

	/****
	 * Gestiona la interacción con el usuario para llevar una carta a destino.
	 */
	private static void llevarCartaADestino() {
		int pilaOrigen = 0;
		
		pilaOrigen = ingresarEntero("Ingrese el n�mero de pila origen");
		
		if(!juego.llevarADestino(pilaOrigen)) {
			imprimirMovimientoNoPermitido();
		}
	}
	
	/****
	 * Gestiona la interacción con el usuario para llevar a cabo la acción de repartir
	 */
	private static void repartir() {
		mostrarPorPantalla("Repartiendo... ");
		juego.repartirEnAuxiliar();
	}
	
	private static void usarCarta() {
		int pila = 0;
		if(!juego.moverDeAuxiliarADestino()) {
			pila = ingresarEntero("Ingrese a qué pila desea moverl el " + juego.getAuxiliar().getUltimaCarta());
			if(!juego.moverDeAuxiliarAPila(pila)) {
				imprimirMovimientoNoPermitido();
			}			
		}
	}
	
	/****
	 * Imprime por pantalla un mensaje de error por movimiento no permitido.
	 */
	private static void imprimirMovimientoNoPermitido() {
		System.err.println("Movimiento no permitido");
	}
	
	/****
	 * Gestiona la interacción con el usuario para realizar el movimiento de una escalera de una pila a otra.
	 */
	private static void mover() {
		int pilaOrigen = 0;
		int pilaDestino = 0;
		PalosBarajaFrancesa palo = null;
		ValorCartaFrancesa valor = null;
		CartaFrancesa buscada = null;
		
		pilaOrigen = ingresarEntero("Ingrese el n�mero de pila origen");
		pilaDestino = ingresarEntero("Ingrese el n�mero de pila destino");
		palo = ingresarPalosBarajaFrancesa("Ingrese el palo");
		valor = ingresarValorCartaFrancesa("Ingrese el valor");
		buscada = juego.buscar(pilaOrigen, palo, valor);
		if(buscada==null) {
			mostrarPorPantalla("Esa carta no se encuentra en la pila buscada");
			return;
		}
		juego.mover(pilaOrigen, pilaDestino, buscada);
	}
	
	/****
	 * Gestiona la interacción con el usuario para el ingreso de un número entero por teclado
	 * @param mensaje que se mostrará al usuario 
	 * @return el número entero ingresado
	 */
	private static int ingresarEntero(String mensaje) {
		int enteroIngresado = 0;
		mostrarPorPantalla(mensaje);
		enteroIngresado = teclado.nextInt();
		return enteroIngresado;
	}
	
	/*****
	 * Gestiona la interacción con el usuario para seleccionar un palo de la baraja francesa
	 * @param mensaje el mensaje que se mostrará al usuario
	 * @return el palo seleccionado
	 */
	private static PalosBarajaFrancesa ingresarPalosBarajaFrancesa(String mensaje) {
		int valorIngresado = 0;
		PalosBarajaFrancesa valores[] = PalosBarajaFrancesa.values(); 
		mostrarPorPantalla(mensaje);
		mostrarPorPantalla(Arrays.toString(valores));
		valorIngresado = teclado.nextInt();
		return valores[valorIngresado];
	}
	
	/****
	 * Gestiona la interacción con el usuario para ingresar la carta (o mejor dicho el valor de la carta) deseada.
	 * @param mensaje que se mostrará al usuario
	 * @return el valor de la carta seleccionada
	 */
	private static ValorCartaFrancesa ingresarValorCartaFrancesa(String mensaje) {
		int valorIngresado = 0;
		ValorCartaFrancesa valores[] = ValorCartaFrancesa.values(); 
		mostrarPorPantalla(mensaje);
		mostrarPorPantalla(Arrays.toString(valores));
		valorIngresado = teclado.nextInt();
		return valores[valorIngresado];
	}
}
