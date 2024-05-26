package co.edu.uco.pch.business.facade.impl.ciudad;

import co.edu.uco.pch.business.assembler.DTO.impl.CiudadAssamblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithoutReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.custome.BussinesPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public class RegistrarCiudadFacade implements FacadeWithoutReturn<CiudadDTO dto>{
	
	private DAOFactory daoFactory;
	public RegistrarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
		
	}
	
	

	@Override
	public void excute(final CiudadDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase= new RegistrarCiudad(daoFactory);
			var ciudadDomain = CiudadAssamblerDTO.getInstance().toDomain(dto);
			
			useCase.execute(ciudadDomain);
			
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

	
}
