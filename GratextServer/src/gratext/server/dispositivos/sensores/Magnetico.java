package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Abrir;
import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Cerrar;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;

/**
 * Clase encargada del sensor magnetico
 * 
 * @author joseantonio
 *
 */
public class Magnetico extends Sensores {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Magnetico(int numero) {
		super("MAGNETICO", numero);

	}

	/**
	 * Metodo encargado de devolver el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {

		return "Z" + super.numero;
	}

	/**
	 * Metodo que devuelve las accciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Abrir());
		acciones.add(new Cerrar());
		Estado e = new Estado("0", 0);
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
