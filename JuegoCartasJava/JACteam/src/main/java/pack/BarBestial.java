package pack;

import java.util.LinkedList;
import java.util.Observable;

public class BarBestial extends Observable {

	private static BarBestial mBar;
	private LinkedList<Carta> listaCartas;

	private  BarBestial() {
		// TODO - implement BarBestial.BarBestial
		listaCartas = new LinkedList<>();
	}
	/**
	 * 
	 * @return Devuelve la LinkedList de las cartas en el tablero de juego.
	 */
	public LinkedList<Carta> getListaCartas(){
		return listaCartas;
	}
	/**
	 * 
	 * @return Devuelve la única instancia del BarBestial, y si no existe, la crea.
	 */
	public static BarBestial getBarBestial() {
		// TODO - implement BarBestial.getBarBestial
		if(mBar ==null) {
			mBar = new BarBestial();
		}
		return mBar;
	}

	/**
	 * Añade la carta al final de la lista de Cartas de BarBestial, notificando a los Observers.
	 * @param pCarta La carta a añadir a la lista.
	 */
	public void addCarta(Carta pCarta) {
		// TODO - implement BarBestial.addCarta
		listaCartas.add(pCarta);
		setChanged();
		notifyObservers("BarBestial");
	}
	/**
	 * 
	 * @return Devuelve el nombre de la última Carta de la lista del BarBestial.
	 */
	public String ultimaCarta() {
		return listaCartas.getLast().getNombre();
	}
}