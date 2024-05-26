package co.edu.uco.pch.crosscutting.Exception.messagecatalog;

import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.CodigoMensaje;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.Mensaje;

public interface MessageCatalog {

	void inicializar();
	String obtenerContendidoMensaje(final CodigoMensaje codigo , String...parametros);
	
	Mensaje obtenerMensaje(final CodigoMensaje codigo, String...parametros);
	
}
 