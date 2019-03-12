package pack;

public class JugadorReal extends Jugador{
	private static JugadorReal mJugador;
	private JugadorReal() {
		super(Color.AZUL);
		setChanged();
		notifyObservers("ManoJugador");
	}
	/**
	 * Juega el turno del Jugador Real jugando la Carta especificada.
	 * @param pCarta, la Carta que quiere jugar el Jugador Real.
	 */
	public void jugarTurno(int pCarta) {
		super.jugarTurno(pCarta);
		IA.getIA().ejecutarTurno();
	}
	/**
	 * @return la única instancia del Jugador Real, si no existe la crea.
	 */
	public static JugadorReal getJugadorReal() {
		if(mJugador==null) {
			mJugador= new JugadorReal();
		}
		return mJugador;
	}
}
