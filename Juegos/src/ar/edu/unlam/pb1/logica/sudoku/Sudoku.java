package ar.edu.unlam.pb1.logica.sudoku;

import ar.edu.unlam.pb1.utils.Dificultad;

public class Sudoku {
	
	private final int DIMENSION = 9;
	private int tablero[][];
	
	public Sudoku(int tablero[][]) {
		this.tablero = tablero;
	}
	
	public Sudoku() {
		tablero = new int[DIMENSION][DIMENSION];
	}
	
	public Sudoku(Dificultad nivel) {
		switch(nivel) {
		case FACIL:
			this.tablero = sencillo();
			break;
		case INTERMEDIO:
			this.tablero = intermedio();
			break;
		case DIFICIL:
			this.tablero = dificil();
			break;
		/*case EXTREMO:
			this.tablero = sencillo();*/
		default:
			this.tablero = new int[DIMENSION][DIMENSION];
		}
	}
	
	public boolean validar(int fila, int columna, int valor) {

		if(validarFila(fila, valor) && validarColumna(columna, valor) && validarCuadrante(fila, columna, valor)) {
			return true;
		}
		
		return false;
	}
	
	private boolean validarFila(int fila, int valor) {
		for(int j = 0; j<tablero[fila].length; j++) {
			if(tablero[fila][j] == valor) {
				return false;
			}
		}
		return true;
	}
	
	private boolean validarColumna(int columna, int valor) {
		for(int i = 0; i<tablero.length; i++) {
			if(tablero[i][columna] == valor) {
				return false;
			}
		}
		return true;
	}
	
	private boolean validarCuadrante(int fila, int columna, int valor) {
		int cuadranteI, cuadranteJ;
		int inicioCuadranteSegunI, finCuadranteSegunI;
		int inicioCuadranteSgunJ, finCuadranteSegunJ;
		
		cuadranteI = ((int) fila /3);
		inicioCuadranteSegunI = (cuadranteI*3);
		finCuadranteSegunI = ((cuadranteI*3)+3);
		
		cuadranteJ = ((int) columna /3);
		inicioCuadranteSgunJ = (cuadranteJ*3);
		finCuadranteSegunJ = ((cuadranteJ*3)+3);
		
		for(int i=inicioCuadranteSegunI; i<finCuadranteSegunI; i++) {
			for(int j=inicioCuadranteSgunJ; j<finCuadranteSegunJ; j++) {
				if(tablero[i][j] == valor) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int[][] getTablero() {
		return tablero;
	}
	
	public boolean validar() {
		int auxiliar = 0;
		
		if(algunaCeldaVacia()) {
			return false;
		}
		
		for(int i=0; i<tablero.length; i++) {
			for(int j= 0; j<tablero[i].length; j++) {
				auxiliar = tablero[i][j];
				tablero[i][j] = 0;
				if(!(validarFila(i, auxiliar)) || !(validarColumna(j, auxiliar)) || !(validarCuadrante(i, j, auxiliar))) {
					tablero[i][j] = auxiliar;
					return false;
				}
				tablero[i][j] = auxiliar;
			}
		}
		return true;
		
	}
	
	public boolean algunaCeldaVacia() {
		for(int i=0; i<tablero.length; i++) {
			for(int j= 0; j<tablero[i].length; j++) {
				if(tablero[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void resetear() {
		for(int i=0; i<tablero.length; i++) {
			for(int j= 0; j<tablero[i].length; j++) {
				tablero[i][j] = 0;
			}
		}
	}
	
	public void setValor(int fila, int columna, int valor) {
		if(valor>=0 && valor<=DIMENSION) {
			tablero[fila][columna] = valor;
		}
	}
	
	public String toString() {
		String salida = "";
		
		salida+=" \t   ";
		for(int i=0; i<tablero.length; i++) {
			salida+= i + "   ";
		}		
		salida+="\n \t";
		
		for(int i=0; i<tablero.length; i++) {
			salida+="____";
		}
		salida += " \n";
		for(int i=0; i<tablero.length; i++) {
			salida+=i+"\t| ";
			for(int j= 0; j<tablero[i].length; j++) {
				if(tablero[i][j] !=  0) {
					salida += tablero[i][j] + " | ";
				}
				else {
					salida += "  | ";
				}
			}
			salida += " \n";
		}
		
		salida+="  \t";
		for(int i=0; i<tablero.length; i++) {
			salida+="����";
		}
		return salida;
	}
	
	private int[][] sencillo(){
		int[][] sencillo = {
				{0, 0, 0, 0, 9, 0, 1, 0, 5},
				{0, 0, 8, 0, 5, 4, 3, 2, 7},
				{0, 0, 5, 0, 1, 0, 0, 8, 6},
				{0, 8, 3, 7, 0, 6, 0, 0, 9},
				{5, 0, 6, 0, 3, 1, 0, 0, 0},
				{1, 2, 0, 0, 8, 0, 4, 0, 0},
				{6, 3, 1, 0, 0, 9, 0, 5, 2},
				{2, 7, 0, 5, 0, 0, 0, 0, 0},
				{8, 0, 0, 0, 7, 0, 0, 0, 0}
		};
		
		return sencillo;
	}
	
	private int[][] intermedio(){
		int[][] intermedio = {
				{5, 3, 0, 0, 7, 0, 0, 0, 0},
				{6, 0, 0, 1, 9, 5, 0, 0, 0},
				{0, 9, 8, 0, 0, 0, 0, 6, 0},
				{8, 0, 0, 0, 6, 0, 0, 0, 3},
				{4, 0, 0, 8, 0, 3, 0, 0, 1},
				{7, 0, 0, 0, 2, 0, 0, 0, 6},
				{0, 6, 0, 0, 0, 0, 2, 8, 0},
				{0, 0, 0, 4, 1, 9, 0, 0, 5},
				{0, 0, 0, 0, 8, 0, 0, 7, 9}
		};
		
		return intermedio;
	}
	
	private int[][] dificil(){
		int[][] dificil = {
				{0, 0, 6, 8, 0, 0, 0, 9, 4},
				{0, 2, 0, 0, 6, 0, 7, 0, 0},
				{7, 0, 0, 4, 0, 2, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0},
				{6, 4, 0, 0, 2, 8, 3, 5, 0},
				{0, 9, 0, 5, 0, 1, 0, 0, 2},
				{4, 0, 2, 6, 0, 3, 0, 0, 5},
				{0, 0, 0, 0, 1, 0, 0, 0, 3},
				{8, 0, 9, 0, 0, 0, 1, 2, 0}
		};
		
		return dificil;
	}
			
}
