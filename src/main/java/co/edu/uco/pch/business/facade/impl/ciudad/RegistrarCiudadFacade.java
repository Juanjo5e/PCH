package co.edu.uco.pch.business.facade.impl.ciudad;

import co.edu.uco.pch.business.assembler.DTO.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithoutReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.custome.BussinesPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

public class RegistrarCiudadFacade implements FacadeWithoutReturn<CiudadDTO>{
	
	private DAOFactory daoFactory;
	public RegistrarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
		
	}
	
	

	@Override
	public void excute(final CiudadDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase= new RegistrarCiudad(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			
			useCase.execute(ciudadDomain);
			
		}catch (final PCHException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
			
		}catch (final Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la informacion de la Ciudad";
			
			throw new BussinesPCHException(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		// TODO Auto-generated method stub
		
	}

	
}
