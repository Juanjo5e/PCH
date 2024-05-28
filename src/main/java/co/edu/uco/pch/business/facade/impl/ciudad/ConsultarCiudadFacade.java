package co.edu.uco.pch.business.facade.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.DTO.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.ConsultarCiudades;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.Exception.PCHException;
import co.edu.uco.pch.crosscutting.Exception.custome.BussinesPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;


public class ConsultarCiudadFacade implements FacadeWithReturn<CiudadDTO, List<CiudadDTO>> {

	private DAOFactory daoFactory;

	public ConsultarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<CiudadDTO> execute(final CiudadDTO dto) {

		try {
			var usecase = new ConsultarCiudades(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = usecase.execute(ciudadDomain);
			return CiudadAssemblerDTO.getInstance().toDTOColletion(resultadosDomain);

		} catch (final PCHException exception) {
			throw exception;
		} catch (final Exception exception) {

			var mensajeUsuario = "Se ha presentado un problema consultar la informacion de las ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la ciudad";

			throw new BussinesPCHException(mensajeTecnico, mensajeUsuario, exception);

		} finally {
			daoFactory.cerrarConexion();
		}
	}

}