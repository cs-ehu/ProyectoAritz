package pack;

import java.util.Iterator;

public class Mofeta1 implements Animalada{
	public Mofeta1() {
	}
	/**
	 * Una mofeta repele a todos los animales de las dos especies m�s fuertes que
haya en en la cola, pero nunca a otras mofetas. Los animales repelidos se
colocan en la carta �ES LO QUE HAY�.
	 */
	@Override
	public void realizarAnimalada() {
		int numMasAlto = 0;
		Iterator<Carta> itr = ColaEntrada.getColaEntrada().getListaCartas().iterator();
		while(itr.hasNext()){
			int num=itr.next().getNum();
			if(num > numMasAlto && num != 1){
				numMasAlto = num;
			}
		}
		int segundoNumMasAlto = 0;
		while(itr.hasNext()){
			int num = itr.next().getNum();
			if(num != 1 && num > segundoNumMasAlto || num != numMasAlto){
				segundoNumMasAlto = num;
			}
		}
		if(numMasAlto != 0){
		EsLoQueHay.getEsLoQueHay().addCarta(ColaEntrada.getColaEntrada().buscarCarta(numMasAlto));
		ColaEntrada.getColaEntrada().getListaCartas().remove(ColaEntrada.getColaEntrada().buscarCarta(numMasAlto));
		}
		if(segundoNumMasAlto != 0){
		EsLoQueHay.getEsLoQueHay().addCarta(ColaEntrada.getColaEntrada().buscarCarta(segundoNumMasAlto));
		ColaEntrada.getColaEntrada().getListaCartas().remove(ColaEntrada.getColaEntrada().buscarCarta(segundoNumMasAlto));
		}
	}
	
}
