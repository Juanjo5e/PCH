package Dato;

public class DatosException  extends CalculadoraException{

	private static final long serialVersionUID = -7302695295186459851L;

	public DatosException (String mensaje) {
		super(mensaje,"Datos");
		
	}
	public DatosException (String mensaje, Throwable exceptionRaiz) {
		super(mensaje,exceptionRaiz,"Datos");
		
	}

}
