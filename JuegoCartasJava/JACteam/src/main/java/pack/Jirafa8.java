package pack;

public class Jirafa8 implements Animalada{
	private Carta carta;
	public Jirafa8(Carta pCarta) {
		carta= pCarta;
	}
	/**
	 * Una jirafa se cuela delante de un animal más
débil si lo tiene directamente delante de ella.
De no ser así, la jirafa se queda donde está.
	 */
	@Override
	public void realizarAnimalada() {
		int pos =ColaEntrada.getColaEntrada().getListaCartas().indexOf(carta)-1;
		if(pos >= 0 &&ColaEntrada.getColaEntrada().getListaCartas().get(pos).getNum() < 8 && pos>=0) {
			ColaEntrada.getColaEntrada().getListaCartas().remove(carta);
			ColaEntrada.getColaEntrada().getListaCartas().add(pos, carta);//a
			
		}
	
	}
}
