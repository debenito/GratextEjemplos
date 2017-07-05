package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Activar;
import gratext.server.dispositivos.acciones.Comprobar;
import gratext.server.dispositivos.acciones.Desactivar;
import gratext.server.dispositivos.acciones.Detectar;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;
import java.util.Random;

/**
 * Clase encargada del sensor de identificacion
 * 
 * @author joseantonio
 *
 */
public class SistemaIdentificacion extends Sensores implements
		SensoresAutomaticos {
	/**
	 * Contructor que devuelve el nombre y el numero del sensor
	 * 
	 * @param numero
	 */
	public SistemaIdentificacion(int numero) {
		super("SISTEMA_IDENTIFICACION", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "W" + super.numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		Detectar de = new Detectar("NO_HAY", 0);
		Comprobar c = new Comprobar("NO_HAY", 0);
		Estado e = new Estado("NO_HAY", 0);
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(e);
		acciones.add(c);
		acciones.add(de);
		servicios.add(e);
		servicios.add(c);
		servicios.add(de);
		return acciones;
	}

	/**
	 * Metodo que devuelve el dato
	 */
	@Override
	public String Dato() {

		return "boolean";
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
		Comprobar c;
		Detectar de;
		if (nuevo == 0) {
			e = new Estado("HAY ALGUIEN", 1);
			c = new Comprobar("HAY ALGUIEN", 1);
			de = new Detectar("HAY ALGUIEN", 1);
		} else {
			e = new Estado("NO HAY NADIE", 0);
			c = new Comprobar("NO HAY NADIE", 0);
			de = new Detectar("NO HAY NADIE", 0);
		}
		addServicio(e);
		addServicio(c);
		addServicio(de);

	}
}
