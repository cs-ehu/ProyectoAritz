package pack;

import java.util.LinkedList;
import java.util.ListIterator;

public class Mono4 implements Animalada{
	public Mono4() {
		
	}
	/**
	 * Un �nico mono en la cola, no causa ning�n efecto.
	 * Si un mono adicional (adem�s del primero) llega a la cola, la pandilla de
monos espanta a todos los hipop�tamos y los cocodrilos que haya en la
cola, envi�ndolos a la carta �ES LO QUE HAY�. Seguidamente, el mono reci�n
jugado se cuela delante de todos los animales y se pone el primero de la cola,
delante de la Puerta del Cielo, convocando a sus colegas monos directamente
detr�s de �l, pero en orden inverso al que se encontraban.
	 */
	@Override
	public void realizarAnimalada() {
		LinkedList<Carta> listaMonos = new LinkedList<Carta>();
		ListIterator<Carta> itr= ColaEntrada.getColaEntrada().getIterador();
		while(itr.hasNext()) {
			Carta carta=itr.next();
			if(carta.getNum()==4) {
				listaMonos.add(carta);
			}
		}
		Carta ultima=ColaEntrada.getColaEntrada().getListaCartas().getLast();
		ListIterator<Carta> itr1=listaMonos.listIterator();
		boolean encontrado= false;
		while(itr1.hasNext() && !encontrado) {
			if(itr1.next().equals(ultima)) {
				encontrado=true;
			}
		}
		if(!encontrado) {
			listaMonos.add(ultima);
		}
		itr1=listaMonos.listIterator();
		if(listaMonos.size()>=2) {
			itr= ColaEntrada.getColaEntrada().getIterador();
			while(itr.hasNext()) {
				Carta carta=itr.next();
				if(carta.getNum()==10||carta.getNum()==11) {
					itr.remove();
				}
			}
			while(itr1.hasNext()) {
				ColaEntrada.getColaEntrada().getListaCartas().remove(itr1.next());
			}
			itr1=listaMonos.listIterator();
			while(itr1.hasNext()) {
				ColaEntrada.getColaEntrada().getListaCartas().addFirst(itr1.next());
			}
		}
	}
	
}
