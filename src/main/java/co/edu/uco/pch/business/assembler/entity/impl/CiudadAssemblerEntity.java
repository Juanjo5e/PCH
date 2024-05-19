package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssamblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;


public class CiudadAssemblerEntity implements AssamblerEntity<CiudadDomain, CiudadEntity>{

	private static final AssamblerEntity<CiudadDomain, CiudadEntity> instance = new CiudadAssemblerEntity();
	private static final AssamblerEntity<DepartamentoDomain,DepartamentoEntity> departamentoAssembler =  DepartamentoAssemblerEntity.getInstance();
	
	private CiudadAssemblerEntity () {
		super();
	}
	
	public static final AssamblerEntity<CiudadDomain, CiudadEntity> getInstance(){
		return instance;
	}

	@Override
	public final CiudadDomain toDomain(final CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final CiudadEntity toEntity(final CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
}
