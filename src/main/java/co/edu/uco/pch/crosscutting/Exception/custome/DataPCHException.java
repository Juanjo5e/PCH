package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class DataPCHException extends PCHException{

	private static final long serialVersionUID = 1L;
	
	public DataPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);
	}

	public DataPCHException(final String mensajeTecnico,final String mensajeUsuiario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuiario, Lugar.DATA, excepcionRaiz);
		
	}

}
