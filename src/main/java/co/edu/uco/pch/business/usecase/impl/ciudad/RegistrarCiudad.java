package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.UUID;
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

    public RegistrarCiudad(final DAOFactory factory){
        if(ObjectHelper.getObjectHelper().isNULL(factory)){
            var mensajeUsuario = "Se ha presentado un porblema tratando de llevar a cabo el registro de una ciudad";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llego nulo...";
            throw new BussinesPCHException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }
    @Override
    public void execute(final CiudadDomain data) {
		// 1. validar que los datos requeridos par el caso de uso sean correctos a nivel de tipo de dato, rango, formato
		// 2. Validar que no exista una misma ciudad para un mismo departamento
		validarCiudadMismoNombreMismoDepartamento(data.getNombre(),
				data.getDepartamento().getId());
		
		// 3. validar que no exista otra ciudad con el mismo identificador

		var ciudadEntity = CiudadEntity.build().setId(generarIdentificadorCiudad())
				.setNombre(data.getNombre())
				.setDepartamento(DepartamentoAssemblerEntity.getInstance()
						.toEntity(data.getDepartamento()));
						factory.getCiudadDAO().crear(ciudadEntity);
	}

    private final UUID generarIdentificadorCiudad(){
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while(existeId){
            id = UUIDHelper.generate();
            var ciudadEntity = CiudadEntity.build().setId(id);
            var resultados = factory.getCiudadDAO().consultar(ciudadEntity);

            existeId = !resultados.isEmpty();
        }
        return id;
    }
    
    private final void validarCiudadMismoNombreMismoDepartamento(
			final String nombreCiudad, final UUID idDepartamento) {
		var ciudadEntity = CiudadEntity.build()
				.setNombre(nombreCiudad)
				.setDepartamento(DepartamentoEntity.build().setId(idDepartamento));
		
		var resultado = factory.getCiudadDAO().consultar(ciudadEntity);
		
		if(!resultado.isEmpty()) {
			var mensajeUsuario = "Ya existe una ciudad con el nombre \"${1}\" asociada al departamento";
			throw new BussinesPCHException(mensajeUsuario);
		}
	}

    
	
}