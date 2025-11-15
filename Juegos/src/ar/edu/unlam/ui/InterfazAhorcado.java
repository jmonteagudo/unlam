package ar.edu.unlam.ui;

import java.util.Scanner;

import ar.edu.unlam.pb1.letras.ahorcado.Partida;

public class InterfazAhorcado {

	public static void main(String[] args) {
	
		String nombreJugador1, nombreJugador2, palabraAAdivinarJugador1, palabraAAdivinarJugador2;
		int opcionSeleccionada = 0;
		boolean elActualAdivino=false, elActualPerdio=false;
		Partida juegoDeEjemplo;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese nombre jugador 1: ");
		nombreJugador1 = teclado.next().toUpperCase();
		
		System.out.println("Ingrese nombre jugador 2: ");
		nombreJugador2 = teclado.next().toUpperCase();
		
		juegoDeEjemplo = new Partida(nombreJugador1, nombreJugador2);
		
		System.out.println("Ingrese la palabra del jugador 1: ");
		palabraAAdivinarJugador1 = teclado.next().toUpperCase();
		juegoDeEjemplo.setPalabraAAdivinarJugador1(palabraAAdivinarJugador1);
		
		limpiarPantalla();		
		
		System.out.println("Ingrese la palabra del jugador 2: ");
		palabraAAdivinarJugador2 = teclado.next().toUpperCase();
		juegoDeEjemplo.setPalabraAAdivinarJugador2(palabraAAdivinarJugador2);
		
		limpiarPantalla();
		
		juegoDeEjemplo.elegirIniciador();
		
		do {
			
			juegoDeEjemplo.cambiarTurno();
			
			System.out.println("Turno de: " + juegoDeEjemplo.getTurnoActual().getNombre());
			System.out.println("Letras arriestadas " + juegoDeEjemplo.getTurnoActual().letrasInvalidasToString());
			System.out.println("Palabra a buscar: " + juegoDeEjemplo.getTurnoActual().mostrarPalabraAAdivinar());
			
			do{
				mostrarMenu();
				opcionSeleccionada = teclado.nextInt();
			}while(opcionSeleccionada!=1 && opcionSeleccionada!=2);
			
			if(opcionSeleccionada == 1) {
				char letraArriesgada;
				
				System.out.println("Ingrese la letra a arriesgar: ");
				letraArriesgada = teclado.next().toUpperCase().charAt(0);
				if(juegoDeEjemplo.arriegarLetra(letraArriesgada) == true) {
					System.out.println("Correcto!");
					System.out.println("Palabra a buscar: " + juegoDeEjemplo.getTurnoActual().mostrarPalabraAAdivinar());
				}else {
					System.out.println("Incorrecto");
					juegoDeEjemplo.getTurnoActual().perderVida();
					juegoDeEjemplo.getTurnoActual().agregarLetraInvalida(letraArriesgada);
				}	
			}
			else {
				String palabraArriesgada;
				
				System.out.println("Ingrese la palabra a arriesgar: ");
				palabraArriesgada = teclado.next().toUpperCase();
				if(juegoDeEjemplo.arriesgarPalabra(palabraArriesgada) == true) {
					elActualAdivino=true;				
				}
				else {
					elActualPerdio=true;
				}
			}
		}while(juegoDeEjemplo.getTurnoActual().getVidas()>0 && elActualAdivino==false && elActualPerdio == false);
		
		if(elActualAdivino == true) {
			System.out.println("El ganador es: " + juegoDeEjemplo.getTurnoActual().getNombre());
		}
		else {
			juegoDeEjemplo.cambiarTurno();
			System.out.println("El ganador es: " + juegoDeEjemplo.getTurnoActual().getNombre());
		}
		
	}
	
	public static void limpiarPantalla() {
		for(int i=0; i<1000; i++) {
			System.out.println();
		}
	}

	public static void mostrarMenu() {		
		System.out.println("Seleccione la opcion deseada: ");
		System.out.println("1 - Ingresar letra: ");
		System.out.println("2 - Arriesgar: ");
	}
	

}
