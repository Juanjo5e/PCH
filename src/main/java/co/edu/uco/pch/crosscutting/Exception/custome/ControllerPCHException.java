package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class ControllerPCHException extends PCHException {
	
	private static final long serialVersionUID = 1L;
	
	public ControllerPCHException(String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CONTROLLER);
	}

	public ControllerPCHException(final String mensajeTecnico, final String mensajeUsuiario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuiario, Lugar.CONTROLLER , excepcionRaiz);
	
	}

}
