package pack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observable;

public class ColaEntrada extends Observable{

	private static ColaEntrada mCola;
	private LinkedList<Carta> listaCartas;

	private ColaEntrada() {
		listaCartas = new LinkedList<Carta>();
	}
	/**
	 * @return la única instancia creada de la Cola de entrada, en caso de no existir la crea.
	 */
	public static ColaEntrada getColaEntrada() {
		if(mCola==null) {
			mCola= new ColaEntrada();
		}
		return mCola;
	}

	/**
	 * Añade una carta al final de la Cola de entrada y efectua las Animaladas y Animaladas recurrentes correspondientes.
	 * @param pCarta, la carta que añade al final.
	 */
	public void addCarta(Carta pCarta) {
		listaCartas.add(pCarta);
		setChanged();
		notifyObservers("ColaEntrada");
		realizarAnimaladas();
		setChanged();
		notifyObservers("ColaEntrada");
		realizarAnimaladasRecurrentes();
		notifyObservers("ColaEntrada");
		listaCartas.stream().forEach(Carta::noUltimaJugada);
		revisarCola();
	}
	/**
	 * Efectúa la animalada de la última carta de la Cola de Entrada.
	 */
	public void realizarAnimaladas() {
		listaCartas.getLast().realizarAnimalada();
	}
	/**
	 * Efectúa todas las Animaladas recurrentes que surgen tras la Animalada de la última carta jugada.
	 */
	public void realizarAnimaladasRecurrentes() {
		// TODO - implement ColaEntrada.realizarAnimaladasRecurrentes
		for (int i = listaCartas.size()-1; i >= 0; i--) {
			Carta esta = listaCartas.get(i);
			if(!esta.getUltimaJugada()) {
				if(esta.getNum() == 11 || esta.getNum() == 10 || esta.getNum() == 8) {
					esta.realizarAnimalada();
				}
			}
			
		}
	}
	/**
	 * Cuando la Cola de entrada está llena (tiene 5 cartas) las 2 primeras pasan al BarBestial y la última pasa a Es Lo Que Hay. 
	 */
	public void revisarCola() {
		// TODO - implement ColaEntrada.revisarCola
		if(listaCartas.size() == 5) {
			BarBestial.getBarBestial().addCarta(listaCartas.getFirst());
			listaCartas.removeFirst();
			setChanged();
			notifyObservers("ColaEntrada");
			BarBestial.getBarBestial().addCarta(listaCartas.getFirst());
			listaCartas.removeFirst();
			setChanged();
			notifyObservers("ColaEntrada");
			EsLoQueHay.getEsLoQueHay().addCarta(listaCartas.getLast());
			listaCartas.removeLast();
			setChanged();
			notifyObservers("ColaEntrada");
		}
	}
	/**
	 * @param fuerza, el número de fuerza de la carta que estamos buscando.
	 * @return la primera carta con la fuerza especificada.
	 */
	public Carta buscarCarta(int fuerza){
		boolean encontrado = false;
		Carta buscada = null;
		Iterator<Carta> itr = listaCartas.iterator();
		while(encontrado == false && itr.hasNext()){
			Carta siguiente = itr.next();
			if(siguiente.getNum() == fuerza){
				buscada = siguiente;
				encontrado = true;
			}
		}
		return buscada;
	}
	/**
	 * @return la LinkedList de Cartas que representa la Cola de Entrada.
	 */
	public LinkedList<Carta> getListaCartas(){
		return listaCartas;
	}
	/**
	 * @return el ListIterator de la Cola de Entrada.
	 */
	public ListIterator<Carta> getIterador(){
		return listaCartas.listIterator();
	}
}