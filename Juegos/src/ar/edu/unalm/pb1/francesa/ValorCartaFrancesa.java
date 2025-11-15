package ar.edu.unalm.pb1.francesa;

/*****
 * @author jmonteagud@gmail.com
 */
public enum ValorCartaFrancesa {

	AS(1, "AS"), DOS(2, " 2"), TRES(3, " 3"), CUATRO(4, " 4"), CINCO(5, " 5"), SEIS(6, " 6"), SIETE(7, " 7"), OCHO(8, " 8"), NUEVE(9, " 9"), DIEZ(10, "10"), SOTA(11, " J"), CABALLO(12, " Q"), REY(13, " K");
	
	int valorNumerico;
	String valorImpreso;
	
	/*****
	 * Constructor de la clase
	 * @param valorNumerico asociado a la carta. Sirve para cáculos numéricos y armados por ejemplo de escaleras.
	 * @param valorImpreso que se debe mostrar al imprimir la carta
	 */
	ValorCartaFrancesa(int valorNumerico, String valorImpreso){
		this.valorNumerico = valorNumerico;
		this.valorImpreso = valorImpreso;
	}
	
	/****
	 * get del atributo valorNumerico
	 * @return valorNumerico
	 */
	public int getValorNumerico() {
		return this.valorNumerico;
	}
	
	/*****
	 * Método que refleja el estado de un objeto
	 */
	public String toString() {
		return this.valorImpreso;
	}
}
