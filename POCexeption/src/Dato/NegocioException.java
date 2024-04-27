package Dato;

public class NegocioException extends CalculadoraException {
	private static final long serialVersionUID = -7637251951264905114L;

	public NegocioException(String mensaje) {
		super(mensaje, "Negocio");
}
	public NegocioException (String mensaje, Throwable exceptionRaiz) {
		super(mensaje,exceptionRaiz,"Datos");
		
	}

}
