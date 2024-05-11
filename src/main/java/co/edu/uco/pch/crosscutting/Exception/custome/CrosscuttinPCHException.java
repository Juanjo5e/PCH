package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class CrosscuttinPCHException extends PCHException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar=Lugar.CROSSCUTTING;

	public CrosscuttinPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public CrosscuttinPCHException(final String mensajeTecnico,final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario,lugar);
	}
	
	public CrosscuttinPCHException(final Object mensajeTecnico,final Object mensajeUsuario,
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, lugar, exceptionRaiz);
	}
	
}
