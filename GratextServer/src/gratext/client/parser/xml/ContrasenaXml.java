package gratext.client.parser.xml;

/**
 * Clase encargada de a�adir la contrase�a a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public class ContrasenaXml implements CommandCadenaXml {
	/**
	 * Metodo encargado de a�adir la contrase�a a la cadenaXML
	 */
	@Override
	public String insertar(String cadenaxml, String valor) {

		return ("<reporte>" + valor + "</reporte> ");
	}

}
