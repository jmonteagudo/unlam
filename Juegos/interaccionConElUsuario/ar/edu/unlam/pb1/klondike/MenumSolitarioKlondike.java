package ar.edu.unlam.pb1.klondike;

/******
 * @author jmonteagudo@gmail.com
 */
public enum MenumSolitarioKlondike {

	REPARTIR(1, "Repartir"), USAR_CARTA(2, "Mover del auxiliar a la pila"), MOVER_UNA_CARTA(3, "Mover una carta de una pila a otra"), MOVER_ENTRE_PILAS(4, "Mover una escalera entre pilas"), LLEVAR_A_DESTINO(5, "Llevar una carta a destino"), REINICIAR(6, "Reiniciar"), SALIR(7, "Salir");
	
	private int opcion;
	private String desccipcion;
	
	/******
	 * Constructor
	 * 
	 * @param opcion Se utiliza para identificar numericamente una opcion del menu
	 * @param descripcion Descripcion de la opcion del menu
	 * 
	 * @author jmonteagudo@gmail.com
	 */
	MenumSolitarioKlondike(int opcion, String descripcion) {
		this.opcion = opcion;
		this.desccipcion = descripcion;
	}
	
	/*****
	 * Devuelve el estado del objeto
	 * 
	 * @return El estado del objeto
	 */
	public String toString() {
		return this.opcion + " - " + this.desccipcion;
	}
}
