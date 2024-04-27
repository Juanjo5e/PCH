package Dato;

public class Datos {
	private int numeroUno;
	private int numeroDos;
	
	public final int getNumeroUno() {
		return numeroUno;
	}

	public final void setNumeroUno(int numeroUno) {
		if(numeroUno < 0) {
			throw new DatosException("el numero uno no puede ser menor que cero");
		}
		this.numeroUno = numeroUno;
	}
	
	public int getNumeroDos() {
		return numeroDos;
	}

	public void setNumeroDos(int numeroDos) {
		
		if(numeroUno < 0) {
			throw new DatosException("el numero dos no puede ser menor que cero");
		}
		this.numeroDos = numeroDos;
	}




}
