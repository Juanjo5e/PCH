package co.edu.uco.pch.business.assembler.entity;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssamblerEntity<D, K > extends Assembler<D, K> {
	
	K toEntity(D domain);
}
