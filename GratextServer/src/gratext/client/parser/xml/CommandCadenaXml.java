package gratext.client.parser.xml;

/**
 * Interface encargada de a�adir cada una de las etiquetas a la cadenaXML
 * 
 * @author joseantonio
 *
 */
public interface CommandCadenaXml {
	/**
	 * Metodo encargado de a�adir a la cadenaXML las diversas etiquetas
	 * 
	 * @param cadenaxml
	 * @param valor
	 * @return cadenaXML
	 */
	public String insertar(String cadenaxml, String valor);
}
