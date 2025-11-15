package ar.edu.unlam.ui;

import java.util.Scanner;

import ar.edu.unlam.pb1.logica.sudoku.Sudoku;
import ar.edu.unlam.pb1.utils.Dificultad;

public class InterfazSudoku {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Sudoku juego = null;
		System.out.println("SUDOKU!");
		
		juego = seleccinarModoJuego(teclado);
				
		System.out.println(juego);
	
		int fila, columna, numero;
		do {
			System.out.println("Fila: ");
			fila = teclado.nextInt();
			System.out.println("Columna: ");
			columna = teclado.nextInt();
			System.out.println("Numero: ");
			numero = teclado.nextInt();
			if(juego.validar(fila, columna, numero)){
				juego.setValor(fila, columna, numero);
				System.out.println(juego);
			}
			else {
				juego.setValor(fila, columna, numero);
				System.err.println(juego);
			}
		} while(juego.algunaCeldaVacia()||!juego.validar());
		
		System.out.println("Felicitaciones!!!");
	}

	private static Sudoku seleccinarModoJuego(Scanner teclado) {
		Sudoku nuevo;
		int modo;
		System.out.println("Seleccinoe el modo");
		System.out.println("1 - Facil");
		System.out.println("2 - Intermedio");
		System.out.println("3 - Dificil");
		System.out.println("4 - Prueba");
		
		modo = teclado.nextInt();
		
		switch(modo) {
		case 1:
			nuevo = new Sudoku(Dificultad.FACIL);
			break;
		case 2:
			nuevo = new Sudoku(Dificultad.INTERMEDIO);
			break;
		case 4:
			nuevo = new Sudoku(Dificultad.DIFICIL);
			break;
		default:
			nuevo = new Sudoku();
			break;
		}
		return nuevo;
	}

}
