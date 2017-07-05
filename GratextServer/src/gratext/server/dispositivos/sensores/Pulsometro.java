package gratext.server.dispositivos.sensores;

/**
 * Clase encargada del sensor del pulsometro de los animales
 */
import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;
import java.util.Random;

public class Pulsometro extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Pulsometro(int numero) {
		super("PULSOMETRO_GANADO", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 3)
			cambiarEstado();
		return "H" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Estado e = new Estado("PULSACIONES_CORRECTAS", 70);
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

	/**
	 * Metodo que cambia el estado del sensor
	 */
	@Override
	public void cambiarEstado() {
		contador = 0;
		Random r = new Random();
		int nuevo = r.nextInt(100);
		removeServicio();
		Estado e = new Estado(nuevo + "pulsaciones/min", nuevo);
		addServicio(e);

	}
}
