package gratext.server.lector.xml;

import gratext.server.Configurador;

public class UsuarioXml implements Comprobador {

	@Override
	public boolean comprobador(String comprobar, Configurador config) {
		if(config.getNombre().equals(comprobar))
			return true;
	return false;
	}

}
