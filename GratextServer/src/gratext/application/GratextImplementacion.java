package gratext.application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GratextImplementacion implements GratextInterface {

private GratextParser gra = new GratextParser();
private String[] cadena;

	@SuppressWarnings("deprecation")
	public GratextImplementacion() {


		try {
			UnicastRemoteObject.exportObject(this,0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}


	@Override
	public String[] recibirDatos() throws RemoteException {
		
		return gra.nuevoFichero();
	}

	

}
