package co.edu.uco.pch.business.facade.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.DTO.impl.CiudadAssamblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.custome.BussinesPCHException;


public class ConsultarCiudadFacade implements FacadeWithReturn<T, K>{
	

	public List<CiudadDTO> execute (final CiudadDTO dto){
		try {
			var useCase= new RegistrarCiudad(daoFactory);
			var ciudadDomain = CiudadAssamblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = useCase.excute(ciudadDomain);
			
			retur
			
		}catch (final PCHException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
			
		}catch (final Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario ="";
			var mensajeTecnico="";
			
			throw new BussinesPCHException(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		// TODO Auto-generated method stub
		
		
	}
	

	@Override
	public K execute(T dto) {
		// TODO Auto-generated method stub
		return null;
	}}