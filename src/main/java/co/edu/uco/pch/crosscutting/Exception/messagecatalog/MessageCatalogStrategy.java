package co.edu.uco.pch.crosscutting.Exception.messagecatalog;

import co.edu.uco.pch.crosscutting.Exception.custome.CrosscuttingPCHException;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.CodigoMensaje;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.Mensaje;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.impl.MessageCatalogBase;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.impl.MessageCatalogExternalService;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;

public final class MessageCatalogStrategy {
	private static final  MessageCatalog base= new MessageCatalogBase();
	private static final  MessageCatalog externalService = new MessageCatalogExternalService();
	
	
	private MessageCatalogStrategy() {
		super();
	}
	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();

	}
	
	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base : externalService;
	}
	
	public static final Mensaje getMensaje(final CodigoMensaje codigo, final String... parametros) {
	    if (ObjectHelper.getObjectHelper().isNULL(codigo)) {
	        throw new CrosscuttingPCHException(null, null);
	    }
	    return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);
	}
	public static Object getContenidoMensaje(CodigoMensaje m00002) {
		// TODO Auto-generated method stub
		return null;
	}

}

