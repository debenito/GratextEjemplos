package gratext.server.lector.xml;

import gratext.server.Configurador;

/**
 * Interface encarda de comprobar el tipo de la centralita, el usuario y la
 * contrase�a para tener acceso a los sensores
 * 
 * @author joseantonio
 *
 */
public interface Comprobador {
	/**
	 * Metodo encargado de comprobar el tipo de la centralita, el usuario y la
	 * contrase�a para tener acceso a los sensores
	 * 
	 * @param comprobar
	 * @param config
	 * @return boolean
	 */
	public boolean comprobador(String comprobar, Configurador config);
}
