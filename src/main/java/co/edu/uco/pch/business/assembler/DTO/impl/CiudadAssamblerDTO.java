package co.edu.uco.pch.business.assembler.DTO.impl;

import static co.edu.uco.pch.crosscutting.helper.ObjectHelper.getObjectHelper;

import co.edu.uco.pch.business.assembler.DTO.AssamblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.dto.CiudadDTO;

public class CiudadAssamblerDTO implements AssamblerDTO<CiudadDomain, CiudadDTO> {

	private static final AssamblerDTO<CiudadDomain, CiudadDTO>  instance = new CiudadAssamblerDTO();
	
	
	private CiudadAssamblerDTO() {
		super();
	}
	
	public static final AssamblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}
	@Override
	public final CiudadDomain toDomain(final CiudadDTO date) {
		var ciudadDtoTmp =getObjectHelper().getDefaulValue(date , CiudadDTO.buil());
	
		return CiudadDomain.build(ciudadDtoTmp.getId(),ciudadDtoTmp.getNombre(), null);
	}

	@Override
	public final CiudadDTO toDTO(final CiudadDomain domain) {
		
	var ciudadDomainTmp = getObjectHelper().getDefaulValue(domain , CiudadDomain.build());
	
		return CiudadDTO.buil().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre());
	}





}
