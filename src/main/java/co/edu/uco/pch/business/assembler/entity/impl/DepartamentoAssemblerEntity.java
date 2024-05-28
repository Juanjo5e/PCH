package co.edu.uco.pch.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.pch.business.assembler.entity.AssamblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

public class DepartamentoAssemblerEntity implements AssamblerEntity<DepartamentoDomain, DepartamentoEntity>{

	private static final AssamblerEntity<DepartamentoDomain, DepartamentoEntity> instance = new DepartamentoAssemblerEntity();
	private static final AssamblerEntity<PaisDomain, PaisEntity> paisAssembler =  PaisAssemblerEntity.getInstance();
	
	private DepartamentoAssemblerEntity () {
		super();
	}
	
	public static final AssamblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}

	@Override
	public final DepartamentoDomain toDomain(final DepartamentoEntity data) {
		var departamentoEntityTmp = ObjectHelper.getObjectHelper().getDefaulValue(data, DepartamentoEntity.build());
		var paisDomain = paisAssembler.toDomain(departamentoEntityTmp.getPais());
		return DepartamentoDomain.build(departamentoEntityTmp.getId(), departamentoEntityTmp.getNombre(), paisDomain);
	}

	@Override
	public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaulValue(domain, DepartamentoDomain.build());
		var paisEntity = paisAssembler.toEntity(departamentoDomainTmp.getPais());
		return DepartamentoEntity.build().setId(departamentoDomainTmp.getId())
				.setNombre(departamentoDomainTmp.getNombre()).setPais(paisEntity);
	}

	@Override
	public List<DepartamentoDomain> toDomainColletion(List<DepartamentoEntity> entityColletion) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
