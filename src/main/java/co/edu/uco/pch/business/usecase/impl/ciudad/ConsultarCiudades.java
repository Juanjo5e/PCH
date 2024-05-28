package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseWithReturn;
import co.edu.uco.pch.crosscutting.Exception.custome.BussinesPCHException;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public class ConsultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>> {

	
	private DAOFactory factory;

    public ConsultarCiudades(final DAOFactory factory){
        if(ObjectHelper.getObjectHelper().isNULL(factory)){
            var mensajeUsuario = "Se ha presentado un porblema tratando de llevar a cabo el registro de una ciudad";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llego nulo...";
            throw new BussinesPCHException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
	
    }
        @Override
	public List<CiudadDomain> execute(CiudadDomain data) {
        	var ciudadEntityFilter = CiudadAssemblerEntity.getInstance().toEntity(data);
        	var resultadosEntity = factory.getCiudadDAO().consultar(ciudadEntityFilter);
		// TODO Auto-generated method stub
        	
		return CiudadAssemblerEntity.getInstance().toDomainColletion(resultadosEntity);
	}

}
