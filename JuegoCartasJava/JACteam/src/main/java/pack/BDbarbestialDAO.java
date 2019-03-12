package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BDbarbestialDAO {
	private static BDbarbestialDAO mbarbestialDAO = new BDbarbestialDAO();
	private Connection con;

	private BDbarbestialDAO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return La instancia del objeto de acceso a datos .
	 */
	public static BDbarbestialDAO getbarbestialDAO() {
		return mbarbestialDAO;
	}
	/**
	 * Comprueba que está establecida la conexión, y si no es así la crea.
	 * @throws BDErrorConexion Excepción de que no ha podido realizarse la conexión.
	 */
	private void ensureConnected() throws BDErrorConexion {
		if (con == null) {
			synchronized (this) {
				if (con == null) {
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
					}
					;
					try {
						String url = "jdbc:sqlite:./barbestial.db";
						con = DriverManager.getConnection(url);
					} catch (SQLException e) {
						con = null;
						throw new BDErrorConexion(e);
					}
				}
			}
		}
	}
	/**
	 * 
	 * @return Devuelve el número de tuplas que tiene la tabla con los usuarios en la base de datos.
	 */
	public int getNumFilas() {
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(*) as numUsuarios from registro");
			return rs.getInt("numUsuarios");

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 
	 * @return Devuelve la List con la información de los usuarios registrada en la base de datos.
	 */
	public List<BDInfoUsuario> getInfoUsuarios() {
		List<BDInfoUsuario> result = new ArrayList<>();
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT usuario,puntuacion from registro");
			ResultSetMetaData metadata = rs.getMetaData();
			// Procesar el resultset y aÃ±adir los datos
			while (rs.next()) {
				BDInfoUsuario infousu = new BDInfoUsuario();
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
					if (rs.getObject(i) != null) {
						infousu.addDato(rs.getObject(i).toString());
					}
					else {
						infousu.addDato("");
					}
				}
				// AÃ±adir la informaciÃ³n a la lista
				result.add(infousu);

			}

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Registra en la base de datos un nuevo jugador.
	 * @param pUsu, nombre del usuario.
	 * @param pContra, la contraseña del usuario.
	 */
	public void resgistrar(String pUsu, String pContra) {
		try {
			ensureConnected();
			Statement st = con.createStatement();
			int rs = st.executeUpdate("Insert into registro values('" + pUsu + "','" + pContra + "', 0)");

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Registra la nueva puntuación del usuario.
	 * @param pUsu, el usuario al que se le registra la puntuación.
	 * @param pPunt, la puntuación lograda en el juego.
	 */
	public void registrarPuntuacion(String pUsu, int pPunt) {
		try {
			ensureConnected();
			Statement st = con.createStatement();
			int rs = st.executeUpdate("Update registro set puntuacion = '" + pPunt + "' where usuario = '" + pUsu + "'");
			System.out.println("Puntuación actualizada correctamente");
		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param pUsu, el usuario a comprobar.
	 * @param pContra, la contraseña a corroborar con la que está registrada en la base de datos.
	 * @return True si es la contraseña registrada en la base de datos para este usuario, False en caso contrario.
	 */
	public boolean contraseñaCorrecta(String pUsu, String pContra) {
		boolean result = false;
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from registro where usuario = '" + pUsu +"'");
			if(pContra.equals(rs.getString("contraseña"))){
				result = true;
			}
			return result;

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param pUsu, nombre de usuario a comprobar si ya estaba registrado previamente.
	 * @return True si ya existe dicho usuario, False en caso contrario.
	 */
	public boolean existeUsuario(String pUsu) {
		boolean result = false;
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from registro");
			while(rs.next()) {
				if(pUsu.equals(rs.getString("usuario"))) {
					result = true;
				}
			}
			return result;
		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @return la List con la información de las columnas de la base de datos
	 */
	public List<BDInfoColumna> getMetaDatosUsuarios() {
		List<BDInfoColumna> result = new ArrayList<>();
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT usuario,puntuacion from registro");
			ResultSetMetaData metadata = rs.getMetaData();
			// Processar el resultset y aÃ±adir los datos
			int columns = metadata.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				BDInfoColumna infoColumna = new BDInfoColumna(metadata.getColumnName(i), metadata.getColumnTypeName(i));
				result.add(infoColumna);

			}
			return result;

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
