package co.edu.uco.pch.business.assembler;

import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.dto.DepartamentoDTO;

public interface Assembler <D, K>{
	
	D toDomain (K data);


	
	
}
