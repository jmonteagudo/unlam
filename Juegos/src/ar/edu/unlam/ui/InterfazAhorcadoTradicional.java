package ar.edu.unlam.ui;

import java.util.Scanner;

public class InterfazAhorcadoTradicional {

	public static void main(String[] args) {
	
		String nombreJugador1, nombreJugador2, palabraAAdivinar;
		int opcionSeleccionada = 0;
		boolean adivino=false, perdio=false;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingres� el nombre de quien registra la palabra: ");
		nombreJugador1 = teclado.next().toUpperCase();
		
		System.out.println("Ingres� el nombre de quien adivina: ");
		nombreJugador2 = teclado.next().toUpperCase();
		
		System.out.println(nombreJugador1 + ": decile a " + nombreJugador2 + " que mire para otro lado e ingres� la palabra a adivinar...");
		palabraAAdivinar = teclado.next().toUpperCase();
		
		limpiarPantalla();		
		
		do {			
			resumenDelJuego(nombreJugador2);
			do{
				mostrarMenu();
				opcionSeleccionada = teclado.nextInt();
			}while(opcionSeleccionada!=1 && opcionSeleccionada!=2);
			
			if(opcionSeleccionada == 1) {
				char letraArriesgada;
				
				System.out.println("Ingres� la letra a arriesgar: ");
				letraArriesgada = teclado.next().toUpperCase().charAt(0);
			}
			else {
				String palabraArriesgada;
				
				System.out.println("Ingres� la palabra a arriesgar: ");
				palabraArriesgada = teclado.next().toUpperCase();
			}
		}while(/*vidas>0 &&*/ !adivino  && !perdio);
		
		if(adivino) {
			System.out.println("El ganador es: " + nombreJugador2);
		}
		else {
			System.out.println("El ganador es: " + nombreJugador1);
		}
		
	}

	private static void resumenDelJuego(String nombreJugador2) {
		System.out.println(nombreJugador2 + ": hasta ahora arriesgaste las siguientes letras: a, e, s");
		System.out.println("La palabra a adivinar por ahora est� as�: \n_ _ _ E _");
	}
	
	public static void limpiarPantalla() {
		for(int i=0; i<1000; i++) {
			System.out.println();
		}
	}

	public static void mostrarMenu() {		
		System.out.println("Seleccion� la opcion deseada: ");
		System.out.println("1 - Ingresar letra: ");
		System.out.println("2 - Arriesgar: ");
	}
}
