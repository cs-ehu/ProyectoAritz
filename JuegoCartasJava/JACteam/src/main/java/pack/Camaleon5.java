package pack;

import java.util.Random;

public class Camaleon5 implements Animalada{
	private Random random;
	private Carta carta;
	public Camaleon5(Carta pCarta) {
		random = new Random();
		carta=pCarta;
	}
	/**
	 * El camale�n realiza la animalada de una de las especies que haya en la
cola (aleatoriamente). Para efectuar dicha animalada (y solo en ese caso), el camale�n adopta
tambi�n la fuerza de la especie imitada. Pero en cuanto se llevan a cabo las
animaladas recurrentes (incluso en el mismo turno), el camale�n vuelve a ser un
camale�n con una fuerza de 5.
	 */
	@Override
	public void realizarAnimalada() {
		int i;
		Animalada anim = null;
		int nuevaFuerza = 0;
		if(ColaEntrada.getColaEntrada().getListaCartas().size()-2>=0){
			i = random.nextInt(ColaEntrada.getColaEntrada().getListaCartas().size()-1);
			nuevaFuerza = ColaEntrada.getColaEntrada().getListaCartas().get(i).getNum();
		}
		switch(nuevaFuerza) {
		case 1:
			anim = new Mofeta1();
			break;
		case 2:
			anim = new Loro2();
			break;
		case 3:
			anim = new Canguro3();
			break;
		case 4:
			anim = new Mono4();
			break;
		case 5:
			break;
		case 6:
			anim = new Foca6();
			break;
		case 7:
			break;
		case 8:
			anim = new Jirafa8(carta);
			break;
		case 9:
			anim = new Serpiente9();
			break;
		case 10:
			anim = new Cocodrilo10(carta);
			break;
		case 11:
			anim = new Hipopotamo11(carta);
			break;
		case 12:
			anim = new Leon12();
			break;
		}
		if(anim!=null) {
			anim.realizarAnimalada();
		}
	}
}
