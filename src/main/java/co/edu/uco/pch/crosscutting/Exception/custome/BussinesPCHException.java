package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class BussinesPCHException extends PCHException {

	private static final long serialVersionUID = 1L;

	public BussinesPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.BUSINESS);
	}
	
	public BussinesPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, Lugar.BUSINESS);
	}
	
	
	public BussinesPCHException(final String mensajeTecnico, final String mensajeUsuiario,final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuiario, Lugar.BUSINESS, excepcionRaiz);
	}

	

}
