package ar.edu.unlam.pb1.espaniola;

public class CartaEspaniola {

	private PalosBarajaEspaniola palo;
	private ValorCartaEspaniola valor;
	private boolean dadaVuelta;
	
	public CartaEspaniola(PalosBarajaEspaniola palo, ValorCartaEspaniola valor) {
		this.palo = palo;
		this.valor = valor;
		this.dadaVuelta = false;
	}
	
	public PalosBarajaEspaniola getPalo() {
		return palo;
	}

	public void setPalo(PalosBarajaEspaniola palo) {
		this.palo = palo;
	}

	public ValorCartaEspaniola getValor() {
		return valor;
	}

	public void setValor(ValorCartaEspaniola valor) {
		this.valor = valor;
	}

	public boolean isDadaVuelta() {
		return dadaVuelta;
	}

	public void setDadaVuelta(boolean dadaVuelta) {
		this.dadaVuelta = dadaVuelta;
	}

	public String toString() {
		return "Carta [palo=" + palo + ", valor=" + valor + ", dadaVuelta=" + dadaVuelta + "]";
	}	
}
