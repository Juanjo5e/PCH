package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.UUID;

import javax.xml.crypto.Data;

import co.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.edu.uco.pch.business.assembler.entity.impl.DepartamentoAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.pch.crosscutting.Exception.custome.BussinesPCHException;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.crosscutting.helper.UUIDHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;

public final class RegistrarCiudad implements UseCaseWithoutReturn<CiudadDomain> {

	private DAOFactory factory;
	
	
	public RegistrarCiudad(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNULL(null)) {
			var mensajeUsuario ="Se ha presentado un problema tratndo de llevar a cabo el registro de una ciudad";
			var mensajeTecnico ="El dao factory llego nulo ";
			throw new BussinesPCHException(mensajeUsuario, mensajeTecnico); 
			
		}
		
	}
	
	@Override
	public void execute(final CiudadDomain data) {

		validarCiudadMismoNombreMismoDepartamento(data.getNombre(),data.getId());
		var ciudadEntity = CiudadEntity.buil().setId(generarIdentificadorCiudad()).setNombre(data.getNombre())
				.setDepartamento(DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));
	
		factory.getCiudadDAO().crear(ciudadEntity);
		// TODO Auto-generated method stub
		
	}
	private final UUID generarIdentificadorCiudad() {
		UUID id =  UUIDHelper.generate();
		boolean existeId = false;
		
		while (!existeId) {
			id = UUIDHelper.generate();
			var ciudadEmtity = CiudadEntity.buil().setId(id);
			var resultados =factory.getCiudadDAO().consultar(ciudadEmtity);
			existeId = !resultados.isEmpty();
		}
		return id;
	}
	
	private final void validarCiudadMismoNombreMismoDepartamento(final String nombreCiudad, final UUID idDepartamento) {
		var ciudadEntity= CiudadEntity.buil().setNombre(nombreCiudad).setDepartamento(DepartamentoEntity.buil().setId(idDepartamento));
		var resultados = factory.getCiudadDAO().consultar(ciudadEntity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya exite una ciudad con el nombre \"${1}\" asociada al departamento";
			throw new BussinesPCHException(mensajeUsuario);
			
		}
	}
}
