package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class CrosscuttinPCHException extends PCHException {

	private static final long serialVersionUID = 1L;

	public CrosscuttinPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CROSSCUTTING);
	
	}

	public CrosscuttinPCHException(final String mensajeTecnico, final String mensajeUsuiario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuiario, Lugar.CROSSCUTTING, excepcionRaiz);
		
	}

	
}
