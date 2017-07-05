package gratext.test;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.Test;

import gratext.client.gráficos.Ventana;
import gratext.client.parser.GratextParser;
import gratext.server.GratextImplementacion;
import gratext.server.GratextLectorServer;

public class ComprobarCadenas {
	GratextParser parse ;
	GratextLectorServer lector;
	GratextImplementacion impl;
	Ventana ventana ;
	@Test
	public void test() throws IOException {
		//fail("Not yet implemented");
		parse =new GratextParser();
		ventana= new Ventana();
		impl = new GratextImplementacion();
		impl.recibirDatos(parse.getCadenaxml());
		lector = new GratextLectorServer(parse.getCadenaxml());
		comprobarCadenaEditores();
		comprobarCadenaCodigos();
		comprobarCadenaValores();
		comprobarCadenaAcciones();

	}

	private void comprobarCadenaAcciones() {
		
		assertNotEquals(parse.getCadenaxml(),lector.getCadena() );
		ventana.mandarDatos(parse.getNuevaCadena());
		assertNotEquals(lector.getCadena(), ventana.getCad());
		
	}

	private void comprobarCadenaValores() throws RemoteException {
		ventana.nuevosDatos(impl.enviarDatos());
		assertNotEquals(lector.getValores(),ventana.getCad());
		
	}

	private void comprobarCadenaCodigos() throws RemoteException {
		ventana.DatosValores(impl.enviarNumeros());
		assertNotEquals(lector.getCodigo(),ventana.getCad());
	}
	
	private void comprobarCadenaEditores() throws RemoteException {
		ventana.datosAcciones(impl.enviarAcciones());
		assertNotEquals(impl.enviarAcciones(),ventana.getCad());
	}

}
