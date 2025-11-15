package ar.edu.unlam.pb1.letras.ahorcado;

public class Jugador {
	
	private final int CANTIDAD_VIDAS = 6;
	
	private String nombre;
	private String palabraAAdivinarPorAdversario;
	private char palabraAAdivinarPorMi[];
	private char letrasInvalidas[];
	private int vidasDisponibles;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		vidasDisponibles = CANTIDAD_VIDAS;
		letrasInvalidas = new char[CANTIDAD_VIDAS];
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setPalabraAAdivinarPorAdversario(String palabraAAdivinarPorAdversario) {
		this.palabraAAdivinarPorAdversario = palabraAAdivinarPorAdversario;
	}
	
	public String getPalabraAAdivinarPorAdversario() {
		return palabraAAdivinarPorAdversario;
	}
	
	public void inicializarPalabraAAdivinarPorMi(int dimensionPalabra) {
		palabraAAdivinarPorMi = new char[dimensionPalabra];
		for(int i=0; i<palabraAAdivinarPorMi.length; i++) {
			palabraAAdivinarPorMi[i] = '\0';
		
		}
	}
	
	public void ingresarLetra(char letraAdivinada, int posicion) {
		palabraAAdivinarPorMi[posicion] = letraAdivinada;
	}
	
	public void perderVida() {
		vidasDisponibles--;
	}
	
	public char[] getPalabraAAdivinarPorMi() {
		return palabraAAdivinarPorMi;
	}
	
	public String mostrarPalabraAAdivinar() {
		String textoAMostrar = "";
				
		for(int i=0; i<palabraAAdivinarPorMi.length; i++) {
			if(palabraAAdivinarPorMi[i] == '\0') {
				textoAMostrar += " _ ";
			}
			else {
				textoAMostrar += palabraAAdivinarPorMi[i];
			}
		}
		return textoAMostrar;
	}
	
	public int getVidas() {
		return vidasDisponibles;
	}
	
	public void agregarLetraInvalida(char letraInvalida) {
		letrasInvalidas[CANTIDAD_VIDAS - vidasDisponibles] = letraInvalida;
	}
	
	public char[] getletrasInvalidas() {
		return letrasInvalidas;
	}
	
	public String letrasInvalidasToString() {
		String resultado = "";
		for(int i=0; i < letrasInvalidas.length; i++) {
			resultado += letrasInvalidas[i] ;
			if(i<letrasInvalidas.length-1) {
				resultado+=" - ";
			}
		}
		return resultado;
	}
}
