package pack;

import java.util.LinkedList;
import java.util.ListIterator;

public class Hipopotamo11 implements Animalada {
	private Carta mCarta;
	public Hipopotamo11(Carta pCarta) {
		mCarta=pCarta;
	}
	/**
	 * Un hipopótamo embiste hacia la puerta. Sin embargo, no puede colarse delante de un
miembro de su propia especie, de animales más fuertes (leones) o de las cebras.
	 */
	@Override
	public void realizarAnimalada() {
		// TODO Auto-generated method stub
		LinkedList<Carta> lista=ColaEntrada.getColaEntrada().getListaCartas();
		ListIterator<Carta> it= lista.listIterator(lista.indexOf(mCarta));
		boolean encontrado= false;
		while(it.hasPrevious() && !encontrado){
			Carta carta= it.previous();
			if(carta.getNum()==7 || carta.getNum()==11 || carta.getNum()==12){
				ColaEntrada.getColaEntrada().getListaCartas().remove(mCarta);
				ColaEntrada.getColaEntrada().getListaCartas().add(ColaEntrada.getColaEntrada().getListaCartas().indexOf(carta)+1, mCarta);
				encontrado=true;
			}
		}
		if(!encontrado) {
			ColaEntrada.getColaEntrada().getListaCartas().remove(mCarta);
			ColaEntrada.getColaEntrada().getListaCartas().addFirst(mCarta);
		}
	}
}
