package gratext.server.lector.xml;

import gratext.server.Configurador;

/**
 * Clase encargada de comprobarsi la contrase�a de la centralita es la misma que
 * la enviada por el usuario
 * 
 * @author joseantonio
 *
 */
public class ReporteXml implements Comprobador {
	/**
	 * Metodo encargado de comprobar si la contrase�a de la centralita es la
	 * misma que la enviada por el usuario
	 */
	@Override
	public boolean comprobador(String comprobar, Configurador config) {
		if (config.getContrase�a().equals(comprobar))
			return true;
		return false;
	}

}
