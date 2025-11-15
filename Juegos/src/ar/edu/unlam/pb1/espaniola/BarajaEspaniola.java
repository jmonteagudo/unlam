package ar.edu.unlam.pb1.espaniola;

import ar.edu.unlam.pb1.espaniola.CartaEspaniola;
import ar.edu.unlam.pb1.espaniola.PalosBarajaEspaniola;
import ar.edu.unlam.pb1.espaniola.ValorCartaEspaniola;

public class BarajaEspaniola {

	public static CartaEspaniola espaniola[] = new CartaEspaniola[40];
	
	
	public static void inicializarBarajaEspaniola() {
		PalosBarajaEspaniola palosDisponibles[] = PalosBarajaEspaniola.values();
		ValorCartaEspaniola valoresDisponibles[] = ValorCartaEspaniola.values();
		int contadorDeCartas = 0;
		
		for(int i=0; i<palosDisponibles.length; i++) {
			for(int j=0; j<valoresDisponibles.length; j++) {
				espaniola[contadorDeCartas] = new CartaEspaniola(palosDisponibles[i], valoresDisponibles[j]);
				contadorDeCartas++;
			}
		}
	}
}
