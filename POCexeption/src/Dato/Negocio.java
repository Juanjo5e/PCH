package Dato;

public class Negocio {
	public int sumar(int numeroUno, int numeroDos) {
		try {
		Datos datos = new Datos();
		datos.setNumeroUno(numeroUno);
		datos.setNumeroDos(numeroDos);
		

		
		if ((datos.getNumeroUno()+ datos.getNumeroDos())% 2==0) {
			
			throw new NegocioException("El resultado de la suma no puede ser 0 ");
		}
		}catch (CalculadoraException exception) {
			System.out.println("que lastima que fallo ");
			throw exception;
		
		}catch (Exception exception ) {
			System.out.println("quiere decir que es un error conocido");
			throw exception;
		
		}

		return 0;
		
	}
	
}
