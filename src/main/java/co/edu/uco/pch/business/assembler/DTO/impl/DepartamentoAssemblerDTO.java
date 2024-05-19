package co.edu.uco.pch.business.assembler.DTO.impl;

import static co.edu.uco.pch.crosscutting.helper.ObjectHelper.getObjectHelper;

import co.edu.uco.pch.business.assembler.Assembler;
import co.edu.uco.pch.business.assembler.DTO.AssamblerDTO;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDto;

public class DepartamentoAssemblerDTO implements Assembler<DepartamentoDomain, DepartamentoDTO>{
	
	private static final AssamblerDTO<PaisDomain, PaisDto> paisAssembler = PaisAssemblerDTO.getInstance();
	private static final AssamblerDTO<DepartamentoDomain, DepartamentoDTO> instance = new DepartamentoAssemblerDTO();
	
	private DepartamentoAssemblerDTO() {
		super();
	}
	
	public static final AssamblerDTO<DepartamentoDomain, DepartamentoDTO>
		getIntance(){
		return instance;
	}
	@Override
	public final DepartamentoDomain toDomain(final DepartamentoDTO date) {
		var departamentoDtoTmp =getObjectHelper().getDefaulValue(date , DepartamentoDTO.build());
		var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(departamentoDtoTmp.getId(),departamentoDtoTmp.getNombre(), paisDomain );
	}

	@Override
	public final DepartamentoDTO toDTO(final DepartamentoDomain domain) {
	var departamentoDomainTmp = getObjectHelper().getDefaulValue(domain , DepartamentoDomain.build());
	var paisDto = paisAssembler.toDTO(departamentoDomainTmp.getPais());
		return DepartamentoDTO.build()
				.setId(departamentoDomainTmp.getId())
				.setNombre(departamentoDomainTmp
				.getNombre()).setPais(paisDto);

	}
	
	
}
