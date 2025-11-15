package ar.edu.unlam.pb1.arcade.buscaminas;

public class Casillero {

	private boolean mina;
	private boolean descubierto;
	private int cantidadDeMinasLimitrofes;
	
	public Casillero() {
		this.mina = false;
		this.descubierto = false;
		this.cantidadDeMinasLimitrofes = 0;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public boolean isDescubierto() {
		return descubierto;
	}

	public void setDescubierto(boolean seleccionado) {
		this.descubierto = seleccionado;
	}

	public int getCantidadDeMinasLimitrofes() {
		return cantidadDeMinasLimitrofes;
	}

	public void setCantidadDeMinasLimitrofes(int cantidadDeMinasLimitrofes) {
		this.cantidadDeMinasLimitrofes = cantidadDeMinasLimitrofes;
	}

	public String toString() {
		final char CARACTER_CASILLERO_SIN_DESCUBIR = 'X', CARACTER_MINA = '*';
		if(descubierto) {
			if(mina) {
				return Character.toString(CARACTER_MINA);
			}
			else {
				return Integer.toString(this.cantidadDeMinasLimitrofes);
				
			}
		}
		else {
			return Character.toString(CARACTER_CASILLERO_SIN_DESCUBIR);
		}
	}
	
}
