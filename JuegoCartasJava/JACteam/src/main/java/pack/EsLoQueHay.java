package pack;

import java.util.LinkedList;
import java.util.Observable;

public class EsLoQueHay extends Observable{

	private static EsLoQueHay mEsLoQueHay;
	private LinkedList<Carta> listaCartas;

	private EsLoQueHay() {
		// TODO - implement EsLoQueHay.EsLoQueHay
		listaCartas = new LinkedList<Carta>();
	}
	/**
	 * @return la única instancia de Es Lo Que Hay, si no existe la crea.
	 */
	public static EsLoQueHay getEsLoQueHay() {
		// TODO - implement EsLoQueHay.getEsLoQueHay
		if(mEsLoQueHay == null) {
			mEsLoQueHay = new EsLoQueHay();
		}
		return mEsLoQueHay;
	}

	/**
	 * Añade la carta especificada a Es Lo Que Hay.
	 * @param pCarta, la carta que queremos dar la patada a Es Lo Que Hay.
	 */
	public void addCarta(Carta pCarta) {
		// TODO - implement EsLoQueHay.addCarta
		listaCartas.add(pCarta);
		setChanged();
		notifyObservers("EsLoQueHay");
	}
	/**
	 * @return la última carta que ha entrado a Es Lo Que Hay.
	 */
	public String ultimaCarta() {
		return listaCartas.getLast().getNombre();
	}

}