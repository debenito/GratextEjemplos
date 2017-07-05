package gratext.client.gr�ficos;

import org.jfree.chart.JFreeChart;

/**
 * Interface para la introducci�n de datos en las gr�ficas
 * 
 * @author joseantonio
 *
 */
public interface Datos {
	/**
	 * Metodo que modifica las cadenas e introduce los datos en la grafica
	 * 
	 * @param datos
	 */
	public void modificarDatos(String[] datos);

	/**
	 * Metodo para crear el tipo de gr�fico
	 * 
	 * @return JfreeChar
	 */
	public JFreeChart crearGrafico();

}
