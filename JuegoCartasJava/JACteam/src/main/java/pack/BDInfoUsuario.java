package pack;
import java.util.ArrayList;
import java.util.List;

public class BDInfoUsuario {
	private List<String> info;
	
	public BDInfoUsuario() {
		info = new ArrayList<>();
	}
	/**
	 * A�ade el dato a la informaci�n del usuario.
	 * @param pDato, el dato a a�adir.
	 */
	public void addDato(String pDato) {
		info.add(pDato);
	}
	/**
	 * 
	 * @param pPos, la posici�n del dato que queremos obtener.
	 * @return el dato en la posici�n indicada.
	 */
	public String getDato(int pPos) {
		return info.get(pPos);
	}

}
