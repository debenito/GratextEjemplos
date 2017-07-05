package gratext.server.lector.xml;

import gratext.server.Configurador;
import gratext.server.dispositivos.acciones.Acciones;
import gratext.server.dispositivos.sensores.Camara;
import gratext.server.dispositivos.sensores.Luminosidad;
import gratext.server.dispositivos.sensores.Sensores;
import gratext.server.dispositivos.sensores.Temperatura;
/**
 * Clase encargada de realizar una accion de un sensor al que se le puede
 * enviar un numero
 * @author joseantonio
 *
 */
public class RealizarAccionConNumero {
	
	/**
	 * Metodo encargado de realizar una accion si a este se le envia un numero
	 * @param dispositivo
	 * @param action
	 * @param sensor
	 * @param numero
	 * @param config
	 */
	
	public void realizarAccionConNumero(String dispositivo, Acciones action,
			Sensores sensor, String numero, Configurador config) {
				if(dispositivo.equals("TERMOSTATO") ){
					sensor.removeAcciones(action);
					Temperatura temp = (Temperatura) config.buscar(dispositivo,"interna");
					action =temp.modificar(action,Integer.parseInt(numero),"grados");
				}else if(dispositivo.equals("LUMINOSIDAD")){
					sensor.removeAcciones(action);
					Luminosidad luz = (Luminosidad) config.buscar(dispositivo,"interna");
					action =luz.modificar(action,Integer.parseInt(numero),"voltios");
				}else if(dispositivo.equals("CAMARA")){
					sensor.removeAcciones(action);
					Camara temp = (Camara) config.buscar(dispositivo,"");
					action =temp.modificar(action,Integer.parseInt(numero),"fotos");
				}
	}
}
