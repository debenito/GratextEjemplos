package gratext.server;

import gratext.server.lector.EscribirFichero;
import gratext.server.lector.LectorCadena;

/**
 * Clase encarga de leer una cadena y de escribir el fichero que sera leido por
 * el servidor
 * 
 * @author joseantonio
 *
 */
public class GratextLectorServer {
	EscribirFichero escribir;
	Configurador config = Configurador.getInstace();
	LectorCadena lector = new LectorCadena(config);

	/**
	 * Construcctor que crea un objeto encargado de la generacion del fichero y
	 * llama al metodo escribir. Ademas llama al metodo leerCadena enviada por
	 * el cliente.
	 * 
	 * @param cadena
	 */
	public GratextLectorServer(String cadena) {
		escribir = new EscribirFichero(cadena);
		escribir.escribirFichero();
		lector.leerCadena();

	}

	/**
	 * Metodo que devuelve los valores realizados por los sensores
	 * 
	 * @return
	 */
	public String getValores() {
		return lector.getValores();
	}

	/**
	 * Metodo que devuelve las diveras acciones realizadas por los sensores
	 * 
	 * @return
	 */
	public String getAcciones() {
		return lector.getAcciones();
	}

	/**
	 * Metodo que devuelve una cadena con los datos escritos en el fichero
	 * 
	 * @return
	 */
	public String getCadena() {
		return escribir.getCadena();
	}

	/**
	 * Metodo que devuelve los codigos creados por la centralita
	 * 
	 * @return
	 */
	public String getCodigo() {
		return lector.getCodigo();
	}

}
