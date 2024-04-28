package co.edu.uco.pch.crosscutting.Exception;

import co.edu.uco.pch.crosscutting.Exception.enums.Lugar;

import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.crosscutting.helper.TextHelper;

public class PCHException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	protected String mensajeUsuario;
	protected Lugar lugar;
		
	public PCHException(final String mensajeTecnico, String mensajeUsuiario, Lugar lugar , Throwable excepcionRaiz){
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuiario);
		setLugar(lugar);
	
		}
	
	public PCHException(final String mensajeUsuario, final Lugar lugar){
		super(mensajeUsuario, new Exception());
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	
		}

	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}

	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaulValue( lugar, Lugar.DEFAULT);
		}


	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final Lugar getLugar() {
		return lugar;
	}
	
	
	

	
}
