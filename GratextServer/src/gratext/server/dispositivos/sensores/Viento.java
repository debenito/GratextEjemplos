package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Detectar;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;
import java.util.Random;

/**
 * Clase se encarga del sensor de viento
 * 
 * @author joseantonio
 *
 */
public class Viento extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Viento(int numero) {
		super("VIENTO", numero);

	}

	/**
	 * Clase que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "V" + numero;
	}

	/**
	 * Metodo que devuelve las acciones que puede realizar un sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("NO_HAY", 0);
		Detectar de = new Detectar("NO_HAY", 0);
		acciones.add(e);

		acciones.add(de);
		servicios.add(e);

		servicios.add(de);
		return acciones;
	}

	/**
	 * Metodo que devuelve el dato
	 */
	@Override
	public String Dato() {

		return "int";
	}

	/**
	 * Metodo que cambia el estado del sensor
	 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(1);
		removeServicio();
		Estado e;
		Detectar de;
		if (nuevo == 0) {
			e = new Estado("HAY VIENTO", 1);
			de = new Detectar("HAY VIENTO", 1);
		} else {
			e = new Estado("NO HAY VIENTO", 0);
			de = new Detectar("NO HAY VIENTO", 0);
		}
		addServicio(e);
		addServicio(de);

	}

}
