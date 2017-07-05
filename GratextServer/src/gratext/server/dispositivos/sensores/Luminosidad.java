package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Activar;
import gratext.server.dispositivos.acciones.Apagar;
import gratext.server.dispositivos.acciones.Aumentar;
import gratext.server.dispositivos.acciones.Desactivar;
import gratext.server.dispositivos.acciones.Disminuir;
import gratext.server.dispositivos.acciones.Encender;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;

/**
 * Clase encargada del sensor de luminosidad
 * 
 * @author joseantonio
 *
 */
public class Luminosidad extends Sensores {
	/**
	 * Constructor que devuelve el nombre y el numero del sensor
	 * 
	 * @param numero
	 */
	public Luminosidad(int numero) {
		super("LUMINOSIDAD", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {

		return "L" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que relizar por el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("0 voltios", 0);
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(new Apagar());
		acciones.add(new Encender());
		acciones.add(e);

		servicios.add(e);

		return acciones;
	}

	/**
	 * Metodo que devuelve el dato
	 */
	@Override
	public String Dato() {

		return "float";
	}

	/**
	 * Metodo encargado de modificar las acciones segun el numero y el dato
	 * 
	 * @param action
	 * @param numero
	 * @param dato
	 * @return
	 */
	public Acciones modificar(Acciones action, int numero, String dato) {
		removeServicio();
		if (action.Nombre().equals("AUMENTAR"))
			action = new Aumentar(100, dato, 0, numero);
		else
			action = new Disminuir(100, dato, 0, numero);
		Estado e = new Estado(action.accion() + "grados",
				(int) action.realizarAccion());
		addServicio(e);
		return e;
	}
}
