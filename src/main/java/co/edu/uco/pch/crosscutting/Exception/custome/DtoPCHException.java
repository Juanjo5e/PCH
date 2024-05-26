package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

public final class DtoPCHException extends PCHException {

	private static final long serialVersionUID = 1L;
	
	public DtoPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DTO);
		
	}
	
	public DtoPCHException(final String mensajeTecnico, final String mensajeUsuiario,final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuiario, Lugar.DTO, excepcionRaiz);
	
	}

	

}
