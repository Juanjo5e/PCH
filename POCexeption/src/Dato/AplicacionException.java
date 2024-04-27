package Dato;

public class AplicacionException extends CalculadoraException {

	private static final long serialVersionUID = 3308214250109634678L;

	public AplicacionException(String mensaje) {
		super(mensaje, "Aplicacion");
	}
	
	public AplicacionException (String mensaje, Throwable exceptionRaiz) {
		super(mensaje,exceptionRaiz,"Datos");
		
	}


}
