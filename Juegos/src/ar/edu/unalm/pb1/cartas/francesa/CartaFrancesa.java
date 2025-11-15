package ar.edu.unalm.pb1.cartas.francesa;

/****
 * @author jmonteagudo@gmail.com
 */
public class CartaFrancesa {

	private PalosBarajaFrancesa palo;
	private ValorCartaFrancesa valor;
	private boolean dadaVuelta;
	
	/*****
	 * Constructor de la clase
	 * @param palo
	 * @param valor
	 */
	public CartaFrancesa(PalosBarajaFrancesa palo, ValorCartaFrancesa valor) {
		this.palo = palo;
		this.valor = valor;
		this.dadaVuelta = false;
	}
	
	// Getter & Setter
	public PalosBarajaFrancesa getPalo() {
		return palo;
	}

	public void setPalo(PalosBarajaFrancesa palo) {
		this.palo = palo;
	}

	public ValorCartaFrancesa getValor() {
		return valor;
	}

	public void setValor(ValorCartaFrancesa valor) {
		this.valor = valor;
	}

	public boolean isDadaVuelta() {
		return dadaVuelta;
	}

	public void setDadaVuelta(boolean dadaVuelta) {
		this.dadaVuelta = dadaVuelta;
	}

	/****
	 * Devuelve en formato String el estado del objeto
	 * @return el estado del objeto
	 */
	public String toString() {
		String resultado = "";
		
		if(this.dadaVuelta) {
			resultado = " " + valor + " " + this.palo; 
		}
		else {
			resultado = "Oculta";
		}
		return resultado;
	}	
}
