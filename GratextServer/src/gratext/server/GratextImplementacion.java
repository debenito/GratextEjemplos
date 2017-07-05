package gratext.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Clase que implementa la interface GratextInterface encargada de recibir y
 * enviar las diversas cadena entre el cliente y la centralita
 * 
 * @author joseantonio
 *
 */
public class GratextImplementacion implements GratextInterface {
	@SuppressWarnings("unused")
	private String file;
	private GratextLectorServer lector;

	/**
	 * Constructor que exporta este objeto para poder realizar la comunicacion
	 */
	public GratextImplementacion() {

		try {
			UnicastRemoteObject.exportObject(this, 0);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo encargado de recibir los datos del cliente
	 */
	@Override
	public void recibirDatos(String file) throws RemoteException {
		this.file = file;
		lector = new GratextLectorServer(file);
	}

	/**
	 * Metodo encargado de enviar los codigos al cliente
	 */

	@Override
	public String enviarDatos() throws RemoteException {

		return lector.getCodigo();
	}

	/**
	 * Metodo encargado de enviar las acciones al cliente
	 */
	@Override
	public String enviarAcciones() throws RemoteException {

		return lector.getAcciones();
	}

	/**
	 * Metodo encargado de enviar los numeros segun las acciones al cliente
	 */
	@Override
	public String enviarNumeros() throws RemoteException {

		return lector.getValores();
	}

}
