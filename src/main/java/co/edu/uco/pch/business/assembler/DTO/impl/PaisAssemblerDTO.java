package co.edu.uco.pch.business.assembler.DTO.impl;

import co.edu.uco.pch.business.assembler.DTO.AssamblerDTO;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.PaisDto;

import static co.edu.uco.pch.crosscutting.helper.ObjectHelper.getObjectHelper;;

public class PaisAssemblerDTO  implements AssamblerDTO<PaisDomain, PaisDTO>{

	@Override
	public PaisDomain toDomain(final PaisDTO date) {
		var PaisDTOTmp =getObjectHelper().getDefaulValue(date , Pai);
	
		return PaisDomain.build(PaisDTOTmp.getId(), PaisDTOTmp.getNombre());
	}

	@Override
	public PaisAssemblerDTO toDTO(PaisDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDomain toDomain() {
		// TODO Auto-generated method stub
		return null;
	}

}
