package Dato;

public class CalculadoraException extends  RuntimeException{

	private static final long serialVersionUID = 6311495471940796444L;
	

	private String lugar;
	
	
	public CalculadoraException(String mensaje,String lugar) {
		super(mensaje);
		this.lugar = lugar;
	}
	
	public CalculadoraException(String mensaje,Throwable exceptionRaiz, String lugar) {
		super(mensaje,exceptionRaiz);
		this.lugar = lugar;
	}
	
	public String getLugar() {
		return lugar;
	}

}
