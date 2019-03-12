package pack;

import java.util.Collections;

public class Foca6 implements Animalada{
	public Foca6() {
		
	}
	/**
	 * La foca invierte completamente el sentido de la Cola de Entrada.
	 */
	@Override
	public void realizarAnimalada() {
		Collections.reverse(ColaEntrada.getColaEntrada().getListaCartas());
	}
}
