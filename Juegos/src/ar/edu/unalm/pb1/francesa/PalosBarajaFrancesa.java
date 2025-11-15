package ar.edu.unalm.pb1.francesa;

/*****
 * @author jmonteagudo@gmail.com
 */
public enum PalosBarajaFrancesa {
	CORAZON('\u2665'), DIAMANTE('\u2666'), PICA('\u2660'), TREBOL('\u2663');

	private char unicode;
	
	/****
	 * Constructor
	 * @param unicode código unicode asociado al símbolo de cada palo
	 */
	private PalosBarajaFrancesa(char unicode) {
		this.unicode = unicode;
	}
	
	/****
	 * Devuelve en formato String el estado del objeto. En este caso el símbolo unicode asociado al palo
	 * @return el unicode asociado al palo
	 */
	public String toString() {
		return Character.toString(unicode);
	}
	
}
