package pack;

import java.util.LinkedList;

public class Leon12 implements Animalada {
	public Leon12() {
	}
	/**
	 * Si el león jugado no se encuentra en la cola con un miembro de su especie, espanta a
todos los monos hacia la carta «ES LO QUE HAY». Seguidamente, se cuela delante de
todos los demás animales. Si ya hay un león en la
cola, el león recién jugado
va directamente a la carta
«ES LO QUE HAY».
	 */
	@Override
	public void realizarAnimalada() {
		// TODO Auto-generated method stub
		LinkedList<Carta> lista = ColaEntrada.getColaEntrada().getListaCartas();
		if(ColaEntrada.getColaEntrada().buscarCarta(12) != null && !ColaEntrada.getColaEntrada().buscarCarta(12).getUltimaJugada()){
			EsLoQueHay.getEsLoQueHay().addCarta(lista.getLast());
			lista.removeLast();
		}
		else{
			while(ColaEntrada.getColaEntrada().buscarCarta(4) !=null){
				Carta carta = ColaEntrada.getColaEntrada().buscarCarta(4);
				EsLoQueHay.getEsLoQueHay().addCarta(carta);
				lista.remove(carta);
			}
			lista.addFirst(lista.getLast());
			lista.removeLast();
		}
	}

}
