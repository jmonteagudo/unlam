package ar.edu.unlam.ui;

import java.util.Scanner;

import ar.edu.unlam.pb1.cartas.blackjack.Juego;


public class InterfazBlackJack {
	
	private static final int CREAR_NUEVO_JUEGO = 1;
	private static final int ORDENAR_MAZO = 2;
	private static final int JUGAR = 3;
	private static final int SALIR = 9;
	
	public static void main(String[] args) {
		int opcionIngresada = 0;
		Scanner teclado = new Scanner(System.in);
		Juego actual = null;
		// TODO Auto-generated method stub
		do {
			mostrarMenu();
			opcionIngresada  = teclado .nextInt();
			actual = determinarAccionARealizar(actual, opcionIngresada, teclado);
		}while (opcionIngresada!=9);
	}

	private static void mostrarMenu() {
		// TODO Auto-generated method stub
		System.out.println("Bienvenidos al Casino");
		System.out.println("1. Crear nuevo juego");
		System.out.println("2. Ordenar y mostrar mazo de cargas");
		System.out.println("3. Jugar");
	}
	
	private static Juego determinarAccionARealizar(Juego actual, int opcionIngresada, Scanner teclado) {
		
		switch(opcionIngresada) {
			case CREAR_NUEVO_JUEGO:
				actual = new Juego();
				break;
			case ORDENAR_MAZO:
				actual.ordenar();
				break;
			case JUGAR:
				actual.mezclar();
				char respuesta = 'S';
				while(respuesta == 's' || respuesta == 'S' || actual.perdio()) {
					System.out.println(actual.toString());
					System.out.println("Su carta actual es: " + actual.siguiente());
					System.out.println("Desea sacar una nueva carta?");
					respuesta = teclado.next().charAt(0);
				}
				actual.jugarGrupier();
				if(actual.gano()) {
					System.out.println("Felicitaciones. Gan�");
				}
				else {
					System.out.println("Gan� la banca");
				}
				break;
			case SALIR:
				break;
			}
		return actual;
	}

}
