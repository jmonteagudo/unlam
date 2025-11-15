package ar.edu.unlam.pb1.arcade.buscaminas;

import ar.edu.unlam.pb1.utils.Dificultad;

public class Juego {

	private Casillero tablero[][];
	private Dificultad nivel;
	
	public Juego(Dificultad nivel) {
		this.nivel = nivel;
		inicializarElJuego();
		actualizarCasillerosLimitrofes();
	}
	
	private void inicializarElJuego() {
		final int CANTIDAD_DE_FILAS_FACIL = 8, CANTIDAD_DE_FILAS_INTERMEDIO = 16, CANTIDAD_DE_FILAS_EXPERTO = 16, CANTIDAD_DE_COLUMNAS_FACIL = 8, CANTIDAD_DE_COLUMNAS_INTERMEDIO = 16, CANTIDAD_DE_COLUMNAS_EXPERTO = 30, CANTIDAD_DE_MINAS_FACIL = 10, CANTIDAD_DE_MINAS_INTERMEDIO = 40, CANTIDAD_DE_MINAS_EXPERTO = 99;
		
		switch(nivel) {
		case FACIL:
			inicializarTablero(CANTIDAD_DE_FILAS_FACIL, CANTIDAD_DE_COLUMNAS_FACIL, CANTIDAD_DE_MINAS_FACIL);
			break;
		case INTERMEDIO:
			inicializarTablero(CANTIDAD_DE_FILAS_INTERMEDIO, CANTIDAD_DE_COLUMNAS_INTERMEDIO, CANTIDAD_DE_MINAS_INTERMEDIO);
			break;
		case EXPERTO:
			inicializarTablero(CANTIDAD_DE_FILAS_EXPERTO, CANTIDAD_DE_COLUMNAS_EXPERTO, CANTIDAD_DE_MINAS_EXPERTO);
			break;
		}
	}
	
	private void inicializarTablero(int cantidadDeFilas, int cantidadDeColumnas, int cantidadDeMinas) {
		this.tablero = new Casillero[cantidadDeFilas][cantidadDeColumnas];
		
		for(int i=0; i<cantidadDeFilas; i++) {
			for(int j=0; j<cantidadDeColumnas; j++) {
				tablero[i][j] = new Casillero();
			}
		}
		distribuirLasMinas(cantidadDeFilas, cantidadDeColumnas, cantidadDeMinas);
	}
	
	private void distribuirLasMinas(int cantidadDeFilas, int cantidadDeColumnas, int cantidadDeMinas) {
		int coordenadaI = 0, coordenadaJ = 0;
		
		for(int i=0; i<cantidadDeMinas; i++) {
			do {
				coordenadaI = ((int)(Math.random()*(cantidadDeFilas-1)));
				coordenadaJ = ((int)(Math.random()*(cantidadDeColumnas-1)));
			}while(tablero[coordenadaI][coordenadaJ].isMina());
			tablero[coordenadaI][coordenadaJ].setMina(true);;
		}
	}
	
	public String toString() {
		String resultado = "_";
		resultado = " " + resultado.repeat(tablero[0].length);
		for(int i=0; i<tablero.length; i++) {
			resultado+="\n|";
			for(int j=0; j<tablero[i].length; j++) {
				resultado+=tablero[i][j].toString();
			}
			resultado+="|";
		}
		resultado += "\n " + "�".repeat(tablero[0].length) + " ";
		return resultado;
	}
	
	public void descubir(int fila, int columna) {
		tablero[fila][columna].setDescubierto(true);
	}
	
	public boolean perdio() {
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++) {
				if(tablero[i][j] .isMina() && tablero[i][j].isDescubierto()) {
					descubrirTodasLasMinas();
					return true;
				}
			}
		}
		return false;
	}
	
	private void descubrirTodasLasMinas() {
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++) {
				if(tablero[i][j].isMina()) {
					this.descubir(i, j);
				}
			}
		}
	}
	public boolean gano() {

		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++) {
				if(!tablero[i][j].isMina() && !tablero[i][j].isDescubierto()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void abandonar() {
		this.descubrirTodasLasMinas();
	}
	
	public void actualizarCasillerosLimitrofes() {
		int cantidadDeMinasLimitrofes = 0;
		
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++) {
				for(int k = (i-1); k<=(i+1); k++) {
					for(int l = (j-1); l<=(j+1); l++) {
						try {
							if(tablero[k][l].isMina()) {
								cantidadDeMinasLimitrofes++;
							}	
						}catch(IndexOutOfBoundsException E) {
							
						}
					}
				}
				tablero[i][j].setCantidadDeMinasLimitrofes(cantidadDeMinasLimitrofes);
				cantidadDeMinasLimitrofes = 0;
			}
		}
	}
	
	public Casillero[][] getTablero() {
		return this.tablero;
	}
}
