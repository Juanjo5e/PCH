package co.edu.uco.pch.business.assembler.DTO;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssamblerDTO<D, K> extends Assembler<D, K> {
	
	K toDTO(D domain);

}
