package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class InitializerPCHException extends PCHException {

	private static final long serialVersionUID = 1L;

	public InitializerPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.INITIALIZER);
		
	}
	
	public InitializerPCHException(final String mensajeTecnico, final String mensajeUsuiario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuiario, Lugar.INITIALIZER, excepcionRaiz);
	
	}

	

}
