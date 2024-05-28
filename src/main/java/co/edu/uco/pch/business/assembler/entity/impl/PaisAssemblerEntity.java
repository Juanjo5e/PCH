package co.edu.uco.pch.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.pch.business.assembler.entity.AssamblerEntity;

import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.entity.PaisEntity;

public class PaisAssemblerEntity  implements AssamblerEntity<PaisDomain, PaisEntity>{

	private static final AssamblerEntity<PaisDomain, PaisEntity> instance = new PaisAssemblerEntity();
	
	private PaisAssemblerEntity () {
		super();
	}
	
	public static final AssamblerEntity<PaisDomain, PaisEntity> getInstance(){
		return instance;
	}
	
	@Override
	public PaisDomain toDomain(PaisEntity data) {
		var paisEntityTmp = ObjectHelper.getObjectHelper().getDefaulValue(data, PaisEntity.build());
		return PaisDomain.build(paisEntityTmp.getId(), paisEntityTmp.getNombre());
	}


	@Override
	public PaisEntity toEntity(PaisDomain domain) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefaulValue(domain, PaisDomain.build());
		return PaisEntity.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

	@Override
	public List<PaisDomain> toDomainColletion(List<PaisEntity> entityColletion) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
