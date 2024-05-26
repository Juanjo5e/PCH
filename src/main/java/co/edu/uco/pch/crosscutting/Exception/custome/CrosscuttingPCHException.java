package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public class CrosscuttingPCHException extends PCHException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

	public CrosscuttingPCHException(final String mensajeUsuiario) {
		super(mensajeUsuiario, lugar);
	}

	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}
	public CrosscuttingPCHException(final String mensajeTecnico, final Throwable excepcionRaiz, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, lugar, excepcionRaiz);
	}


	


	
}