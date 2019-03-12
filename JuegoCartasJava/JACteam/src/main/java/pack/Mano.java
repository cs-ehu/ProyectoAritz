package pack;

import java.util.LinkedList;
import java.util.ListIterator;

public class Mano{

	private LinkedList<Carta> cartasMano;

	public Mano() {
		cartasMano = new LinkedList<>();
	}

	/**
	 * Añade la carta especificada a la mano.
	 * @param pCarta, la carta a añadir a la mano.
	 */
	public void addCarta(Carta pCarta) {
		cartasMano.add(pCarta);
	}

	/**
	 * Elimina de la Mano la Carta que se juega.
	 * @param pCarta, la carta jugada a eliminar.
	 */
	public Carta jugarCarta(int pCarta) {
		Carta carta = cartasMano.get(pCarta);
		cartasMano.remove(pCarta);
		return carta;
	}
	/**
	 * @return True si quedan cartas en la Mano, False en caso contrario.
	 */
	public boolean hayCartas() {
		if(cartasMano.isEmpty()) {
			return false;
		}
		return true;
	}
	/**
	 * @return el número de Cartas en la Mano.
	 */
	public int getSize() {
		return cartasMano.size();
	}
	/**
	 * @return el ListIterator de las Cartas que están en la Mano.
	 */
	public ListIterator<Carta> getIterador(){
		return cartasMano.listIterator();
	}
}