package co.edu.uco.pch.crosscutting.Exception.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.pch.crosscutting.Exception.custome.CrosscuttinPCHException;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.CodigoMensaje;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.Mensaje;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {

	private final Map<String , Mensaje> mensaje = new HashMap<>();

	public final void inicializar() {
		mensaje.clear();
		mensaje.put(CodigoMensaje.M0001.getIdentificador(),
				new Mensaje(CodigoMensaje.M0001, "El codigo que se quiere obtener del catalogo de mensajes llego nulo..."));
		mensaje.put(CodigoMensaje.M0002.getIdentificador(),
				new Mensaje(CodigoMensaje.M0002, "Se ha presentado un problema tratando de llevar a cabo de la operacion deseada."));
		mensaje.put(CodigoMensaje.M0003.getIdentificador(), 
				new Mensaje(CodigoMensaje.M0003, "El codigo del mensaje \"${1}\" que se intento obtener  no esta en el catalogo base "));
		mensaje.put(CodigoMensaje.M0004.getIdentificador(), 
				new Mensaje(CodigoMensaje.M0004, "El mensaje del mensaje \"${1}\" que se intento obtener  no esta configurado para resicibir en el catalogo base  "));
	
	}


	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {
		if (ObjectHelper.getObjectHelper().isNULL(codigo)) {
			var mensajeUsuario = obtenerMensaje(CodigoMensaje.M0002);
			var mensajeTecnico = obtenerMensaje(CodigoMensaje.M0001);
			throw new CrosscuttinPCHException(mensajeTecnico, mensajeUsuario);		
		}
		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerMensaje(CodigoMensaje.M0002);
			var mensajeTecnico = obtenerMensaje(CodigoMensaje.M0004);
			throw new CrosscuttinPCHException(mensajeTecnico, mensajeUsuario);	
		}
		
		if (!mensaje.containsKey(codigo.getIdentificador())){
			var mensajeUsuario = obtenerMensaje(CodigoMensaje.M0002);
			var mensajeTecnico = obtenerMensaje(CodigoMensaje.M0003, codigo.getIdentificador());
			throw new CrosscuttinPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		return mensaje.get(codigo.getIdentificador());
		}
	
		
		
		
	}

	
}
//Tarea Asegure que si tiene parametros , el contenido del mensaje  se retorna con los parametros remplazados 
		// String  format  carpeta java 
		