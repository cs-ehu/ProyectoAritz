package pack;

import java.util.Observable;

public abstract class Jugador extends Observable{

	private Color color;
	protected Mano mano;
	protected Mazo mazo;

	public Jugador(Color pColor) {
		color = pColor;
		mazo= new Mazo(color);
		mano= new Mano();
		for (int i = 1; i < 5; i++) {
			robarCarta();
		}
	
	}

	/**
	 * Juega la Carta especificada, añadiendola al final de la Cola de Entrada.
	 * @param pCarta
	 */
	public void jugarCarta(int pCarta) {
		ColaEntrada.getColaEntrada().addCarta(mano.jugarCarta(pCarta));
	}
	/**
	 * Añade a la mano del jugador la primera Carta del Mazo.
	 */
	public void robarCarta() {
		if(mazo.hayCartas()==true) {
			mano.addCarta(mazo.robarCarta());
		}
	}
	/**
	 * @return True si aún quedan Cartas en la mano del Jugador, False en caso contrario.
	 */
	public boolean tienesCartas() {
		return mano.hayCartas();
	}
	/**
	 * Ejecuta el turno completo del Jugador (juega la carta especificada y roba Carta del Mazo).
	 * @param pCarta
	 */
	public void jugarTurno(int pCarta) {
		jugarCarta(pCarta);
		setChanged();
		notifyObservers("ManoJugador");
		robarCarta();
		if(!mazo.hayCartas()) {
			setChanged();
			notifyObservers("MazoJugador");
		}
	}
	/**
	 * @return la Mano del jugador.
	 */
	public Mano getMano() {
		return mano;
	}
	/**
	 * @return el Mazo del jugador.
	 */
	public Mazo getMazo() {
		return mazo;
	}
}