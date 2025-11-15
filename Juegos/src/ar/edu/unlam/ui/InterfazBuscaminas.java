package ar.edu.unlam.ui;

import java.util.Scanner;

import ar.edu.unlam.pb1.arcade.buscaminas.Juego;
import ar.edu.unlam.pb1.utils.Dificultad;

public class InterfazBuscaminas {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ar.edu.unlam.pb1.utils.Dificultad nivel;
		String casilleroSeleccionado[];
		
		System.out.println("Bienvenido al Buscaminas");
		
		nivel = menuInicial(teclado);
		
		Juego juegoActual = new Juego(nivel);
		
		do {
			casilleroSeleccionado = mostrarElMenu(teclado, juegoActual);
			if(casilleroSeleccionado[0].equals("-1")) {
				juegoActual.abandonar();
			}
			else {
				juegoActual.descubir(Integer.parseInt(casilleroSeleccionado[0]), Integer.parseInt(casilleroSeleccionado[1]));
			}
		}while(!juegoActual.gano() && !juegoActual.perdio());
		
		System.out.println(juegoActual);
		if(juegoActual.gano()) {
			System.out.println("Felicitaciones!");
		}else {
			System.out.println("Otra vez ser�");
		}
	}
	
	private static ar.edu.unlam.pb1.utils.Dificultad menuInicial(Scanner teclado) {
		final int FACIL = 0, INTERMEDIO = 1;
		int dificultadSeleccionada = 0;
		
		do {
			System.out.println("Seleccione la dificultad (0 - Facil | 1 - Intermedio | 2 - Experto)");
			dificultadSeleccionada = teclado.nextInt();
		}while(dificultadSeleccionada!=0 && dificultadSeleccionada!=1 && dificultadSeleccionada!=2);
		
		switch(dificultadSeleccionada) {
		case FACIL:
			return Dificultad.FACIL;
		case INTERMEDIO:
			return Dificultad.INTERMEDIO;
		default:
			return Dificultad.EXPERTO;
		}
	}
	
	private static String[] mostrarElMenu(Scanner teclado, Juego juegoActual) {
		String casilleroSeleccionado[];
		System.out.println(juegoActual);
		System.out.println("Seleccione el casillero a descubrir (fila, columna). O -1 para abandonar.");
		casilleroSeleccionado = teclado.next().split(",");
		return casilleroSeleccionado;
	}
}
