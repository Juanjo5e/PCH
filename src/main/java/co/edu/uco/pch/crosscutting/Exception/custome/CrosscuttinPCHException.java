package co.edu.uco.pch.crosscutting.Exception.custome;

import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;
import co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat.Mensaje;

public final class CrosscuttinPCHException extends PCHException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

	public CrosscuttinPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	
	}

	public CrosscuttinPCHException(final Mensaje mensajeTecnico, final Mensaje mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
		
	}
	public CrosscuttinPCHException(final Mensaje mensajeTecnico, final Mensaje mensajeUsuario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
		}

	
}
