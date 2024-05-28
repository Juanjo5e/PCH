package co.edu.uco.pch.business.assembler.DTO.impl;

import static co.edu.uco.pch.crosscutting.helper.ObjectHelper.getObjectHelper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.pch.business.assembler.DTO.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.dto.CiudadDTO;

public class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {

	private static final AssemblerDTO<CiudadDomain, CiudadDTO>  instance = new CiudadAssemblerDTO();
	
	
	private CiudadAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
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

	@Override
	public List<CiudadDomain> toDomainColletion(List<CiudadDTO> dtoColletion) {
		var dtoColletionTmp= ObjectHelper.getObjectHelper().getDefaulValue(dtoColletion, new ArrayList<CiudadDTO>());
		
		var resultadosDomain = new ArrayList<CiudadDomain>();
		
		for (CiudadDTO ciudadDto : dtoColletionTmp) {
			var ciudadDomainTmp = toDomain(ciudadDto);
			resultadosDomain.addAll(resultadosDomain);
		}
		return resultadosDomain;
	}

	@Override
	public List<CiudadDTO> toDTOColletion(final List<CiudadDomain> domainColletion) {
		var domainColletionTmp = ObjectHelper.getObjectHelper().getDefaulValue(domainColletion , new ArrayList<CiudadDomain>());
		return domainColletionTmp.stream().map(this:: toDTO).toList();
	}





}
