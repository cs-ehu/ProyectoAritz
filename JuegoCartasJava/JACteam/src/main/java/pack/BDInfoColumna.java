package pack;

public class BDInfoColumna {
	private String nombre;
	private String tipo;
	
	public BDInfoColumna(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	/**
	 * 
	 * @return el nombre de la columna de la base de datos.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @return el tipo de datos de la columna en la base de datos.
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @return la información de la columna en la base de datos (nombre, tipo) en formato String.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%1$s<%2$s>", getNombre(), getTipo());
	}
}
