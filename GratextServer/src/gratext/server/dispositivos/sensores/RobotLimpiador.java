package gratext.server.dispositivos.sensores;

import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.acciones.Activar;
import gratext.server.dispositivos.acciones.Apagar;
import gratext.server.dispositivos.acciones.Desactivar;
import gratext.server.dispositivos.acciones.Encender;
import gratext.server.dispositivos.acciones.Estado;

import java.util.List;

/**
 * Clase que se encarga del sensor que tiene el robot de limpieza
 * 
 * @author joseantonio
 *
 */
public class RobotLimpiador extends Sensores implements SensoresAutomaticos {
	/**
	 * Constructo que devuelve el nombre y el numero del sensor
	 * 
	 * @param numero
	 */
	public RobotLimpiador(int numero) {
		super("ROBOT_LIMPIADOR", numero);

	}

	/**
	 * Metodo que devuelve el codigo del sensor
	 */
	@Override
	protected String codigoSensores() {
		if (contador == 2)
			cambiarEstado();
		return "Y" + numero;
	}

	/**
	 * Metodo que devuelve la lista de acciones que puede realizar el sensor
	 */
	@Override
	protected List<Acciones> inicializarAcciones(List<Acciones> acciones) {
		acciones.add(new Activar());
		acciones.add(new Desactivar());
		acciones.add(new Encender());
		acciones.add(new Apagar());
		Estado e = new Estado("ACTIVADO", 1);
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
		Estado e = new Estado("LIMPIANDO", 2);
		addServicio(e);
	}

}
