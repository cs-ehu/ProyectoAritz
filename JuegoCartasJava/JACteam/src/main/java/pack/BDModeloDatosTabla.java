package pack;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class BDModeloDatosTabla extends AbstractTableModel implements TableModel {
	
	private static final long serialVersionUID = -888159143785688949L;
	private BDbarbestialDAO daoSocios = BDbarbestialDAO.getbarbestialDAO();
	private int numFilas;
	private int numColumnas;
	private List<BDInfoUsuario> infousuarios;
	private List<BDInfoColumna> infoCabecera;
	
	/**
	 * @return el número de columnas de la tabla.
	 */
	@Override
	public int getColumnCount() {
		ensureDataLoaded();
		return numColumnas;
	}
	/**
	 * @return el número de filas de la tabla. 
	 */
	@Override
	public int getRowCount() {
		ensureDataLoaded();
		return numFilas;
	}
	/**
	 * @param arg0, dimensión vertical (nº de tupla) para la obtención del dato.
	 * @param arg1, dimensión horizontal (nº de columna) para la obtención del dato.
	 * @return el objeto posicionado en las dimensiones especificadas de la tabla.
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		ensureDataLoaded();
		if(arg0 < getRowCount() && arg1 < getColumnCount() && arg0 >= 0 && arg1 >= 0){
			return infousuarios.get(arg0).getDato(arg1);
		}else{
			return "--";
		}
		
	}
	/**
	 * @param column, el nº de columna que queremos saber el nombre.
	 * @return el nombre de la columna especificada.
	 */
	@Override
	public String getColumnName(int column){
		ensureDataLoaded();
		if(column >= 0 && column < getColumnCount()){
			return infoCabecera.get(column).getNombre();
		} else{
			return "UNKNOWN";
		}
		
	}
	/**
	 * @param columnIndex, el nº de columna que queremos saber el tipo de datos que guarda.
	 * @return el tipo de datos (Class) que guarda la columna especificada.
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex){
		if(columnIndex >= 0 && columnIndex < getColumnCount()){
			String tipo = infoCabecera.get(columnIndex).getTipo();
			if(tipo.equals("INT")){
				return Integer.class;
			}else{
				return String.class;
			}
		}else{
			return String.class;
		}
	}
	/**
	 * Se asegura que los datos se han cargado, y si no están cargados los carga.
	 */
	private void ensureDataLoaded(){
		if(infoCabecera == null){
			synchronized (this) {
				if(infoCabecera == null){
					infoCabecera = daoSocios.getMetaDatosUsuarios();
					infousuarios = daoSocios.getInfoUsuarios();
					numFilas = infousuarios.size();
					numColumnas = infoCabecera.size();
				}
			}
		}
	}
	/**
	 * Añade un usuario a la base de datos.
	 * @param pUsu, la BDInfoUsuario con la información del nuevo usuario a añadir a la base de datos.
	 */
	public void addUsuario(BDInfoUsuario pUsu){
		infousuarios.add(pUsu);
		numFilas++;
		fireTableRowsInserted(numFilas -1,numFilas );
	}
}



	