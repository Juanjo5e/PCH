package co.edu.uco.pch.crosscutting.Exception.messagecatalog.impl;

import co.edu.uco.pch.crosscutting.Exception.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.CodigoMensaje;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.Mensaje;

public final class MessageCatalogExternalService implements MessageCatalog {

	@Override
	public final void inicializar() {		
	}

	@Override
	public final String obtenerContendidoMensaje(final CodigoMensaje codigo, String... parametros) {
		return null;
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros) {
		return null;
	}
}
