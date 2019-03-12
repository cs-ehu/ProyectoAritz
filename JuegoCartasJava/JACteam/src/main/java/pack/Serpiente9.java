package pack;

import java.util.Collections;
import java.util.Comparator;

public class Serpiente9 implements Animalada{
	public Serpiente9() {
	}
	/**
	 * El efecto de la serpiente consiste en que todos los animales que se encuentran en la cola
se ordenan de inmediato seg�n su fuerza: el animal m�s fuerte se coloca el primero de la
cola frente a la Puerta del Cielo, y los dem�s animales se ordenan detr�s de �l seg�n su
fuerza. Los miembros de la misma especie no intercambian sus posiciones.
	 */
	@Override
	public void realizarAnimalada() {
		Comparator<Carta> comparador =  new Comparator<Carta>(){
			@Override
			public int compare(Carta c1, Carta c2) {
				return c2.getNum() - c1.getNum();
			}
		};
		Collections.sort(ColaEntrada.getColaEntrada().getListaCartas(), comparador);;
	}
}
