package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Abrir;
import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Cerrar;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;

/**
 * Clase encargada del sensor de la barrera
 * 
 * @author joseantonio
 *
 */
public class Barrera_Seguridad extends Sensores {
	/**
	 * Constructor que devuelve el nombre del sensor y el codigo
	 * 
	 * @param numero
	 */
	public Barrera_Seguridad(int numero) {
		super("BARRERA_SEGURIDAD", numero);

	}

	/**
	 * Metodo que devuelve el codigo
	 */
	@Override
	protected String codigoSensores() {

		return "B" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones a realizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("CERRADO", 0);
		acciones.add(new Abrir());
		acciones.add(new Cerrar());
		acciones.add(e);
		servicios.add(e);
		return acciones;
	}

	/**
	 * Metodo que devuelve el dato
	 */
	@Override
	public String Dato() {

		return "int";
	}

}
