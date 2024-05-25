package co.edu.uco.pch.business.assembler.DTO.impl;

import static co.edu.uco.pch.crosscutting.helper.ObjectHelper.getObjectHelper;

import java.util.List;

import co.edu.uco.pch.business.assembler.DTO.AssemblerDTO;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDto;


public class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO> {
	
	private static final AssemblerDTO<PaisDomain,PaisDto> paisAssembler= PaisAssemblerDTO.getInstance();
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> instance=new DepartamentoAssemblerDTO();
	
	@Override
	public final DepartamentoDomain toDomain(final DepartamentoDTO data) {
		var departamentoDtoTmp=getObjectHelper().getDefaulValue(data, DepartamentoDTO.build());
		var paisDomain=paisAssembler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(departamentoDtoTmp.getId(),departamentoDtoTmp.getNombre(),paisDomain);
	}

	@Override
	public final DepartamentoDTO toDTO(final DepartamentoDomain domain) {
		var departamentoDomainTmp=getObjectHelper().getDefaulValue(domain, DepartamentoDomain.build());
		var paisDto=paisAssembler.toDTO(departamentoDomainTmp.getPais());
		return DepartamentoDTO.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre());
	}

	@Override
	public List<DepartamentoDomain> toDomainColletion(List<DepartamentoDTO> entityColletion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDTO> toDTOColletion(List<DepartamentoDomain> domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
