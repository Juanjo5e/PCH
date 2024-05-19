package co.edu.uco.pch.business.assembler.DTO.impl;

import co.edu.uco.pch.business.assembler.DTO.AssamblerDTO;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.PaisDto;

import static co.edu.uco.pch.crosscutting.helper.ObjectHelper.getObjectHelper;;

public final class PaisAssemblerDTO  implements AssamblerDTO<PaisDomain, PaisDto>{

	private static final AssamblerDTO<PaisDomain, PaisDto> instance = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {
		super();
	}
	
	public static final AssamblerDTO<PaisDomain, PaisDto> getInstance(){
		return instance;
	}
	
	@Override
	public final PaisDomain toDomain(final PaisDto date) {
		var paisDtoTmp =getObjectHelper().getDefaulValue(date , PaisDto.buil());
	
		return PaisDomain.build(paisDtoTmp.getId(), paisDtoTmp.getNombre());
	}

	@Override
	public final PaisDto toDTO(final PaisDomain domain) {
		
	var paisDomainTmp = getObjectHelper().getDefaulValue(domain , PaisDomain.build());
	
		return PaisDto.buil().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}


}
