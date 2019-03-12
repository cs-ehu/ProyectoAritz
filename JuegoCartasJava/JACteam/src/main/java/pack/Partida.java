package pack;

import java.util.Iterator;
import java.util.Observable;

public class Partida extends Observable{

	private static Partida mPartida;
	private Jugador jugador;
	private  String nombre;

	private Partida() {
		// TODO - implement Partida.Partida
		inicializar();
	}
	/**
	 * @return la única instancia de la Partida creada, si no la crea.
	 */
	public static Partida getPartida() {
		// TODO - implement Partida.getPartida
		if(mPartida == null) {
			mPartida = new Partida();
		}
		return mPartida;
	}
	/**
	 * Inicializa (crea las instancias de todos los elementos necesarios) la partida.
	 */
	public void inicializar() {
		// TODO - implement Partida.inicializar
		ColaEntrada.getColaEntrada();
		BarBestial.getBarBestial();
		EsLoQueHay.getEsLoQueHay();
		jugador = JugadorReal.getJugadorReal();
		IA.getIA();
	}
	/**
	 * Ejecuta el siguiente turno de la partida.
	 * @param pCarta, la carta que se juega en este turno.
	 */
	public void siguienteTurno(int pCarta) {
		// TODO - implement Partida.siguienteTurno
		jugador.jugarTurno(pCarta);
		terminarPartida();	
	}
	/**
	 * @return la puntuación lograda pro el JugadorReal en esta Partida.
	 */
	private int calcularPuntuacion() {
		int punt = 0;
		Iterator<Carta> itr = BarBestial.getBarBestial().getListaCartas().iterator();
		while(itr.hasNext()) {
			Carta esta = itr.next();
			if(esta.getColor() == Color.AZUL) {
				punt  = punt + esta.getNum();
			}
		}
		return punt;
	}
	/**
	 * Si ninguno de los Jugadores tienen Cartas calcula la puntuación del Real y termina la Partida actual.
	 */
	public void terminarPartida() {
		// TODO - implement Partida.terminarPartida
		if(!jugador.tienesCartas() && !IA.getIA().tienesCartas()) {
			BDbarbestialDAO.getbarbestialDAO().registrarPuntuacion(nombre, calcularPuntuacion());
			VentanaDatosRanking.main(null);
			Interfaz1.getFrame().setVisible(false);
		}
	}
	/**
	 * Cambia el nombre de la Partida
	 * @param pNom, el nuevo nombre de la Partida.
	 */
	public void setNombre(String pNom) {
		nombre = pNom;
	}

}