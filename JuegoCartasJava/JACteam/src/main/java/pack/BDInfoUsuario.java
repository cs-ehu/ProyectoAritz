package pack;
import java.util.ArrayList;
import java.util.List;

public class BDInfoUsuario {
	private List<String> info;
	
	public BDInfoUsuario() {
		info = new ArrayList<>();
	}
	/**
	 * Añade el dato a la información del usuario.
	 * @param pDato, el dato a añadir.
	 */
	public void addDato(String pDato) {
		info.add(pDato);
	}
	/**
	 * 
	 * @param pPos, la posición del dato que queremos obtener.
	 * @return el dato en la posición indicada.
	 */
	public String getDato(int pPos) {
		return info.get(pPos);
	}

}
