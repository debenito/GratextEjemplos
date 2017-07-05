package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Abrir;
import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Activar;
import gratext.server.dispositivos.acciones.Apagar;
import gratext.server.dispositivos.acciones.Cerrar;
import gratext.server.dispositivos.acciones.Desactivar;
import gratext.server.dispositivos.acciones.Encender;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;
import java.util.Random;

/**
 * Clase encargada del sensor de las neveras
 * 
 * @author joseantonio
 *
 */
public class Neveras extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructor que devuelve el nombre del sensor y el numero
	 * 
	 * @param numero
	 */
	public Neveras(int numero) {
		super("NEVERAS", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "N" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(new Abrir());
		acciones.add(new Cerrar());

		Estado e = new Estado("10 grados", 10);
		acciones.add(new Encender());
		acciones.add(new Apagar());
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
		Estado e = new Estado(" " + nuevo + "grados", nuevo);
		addServicio(e);

	}

}
