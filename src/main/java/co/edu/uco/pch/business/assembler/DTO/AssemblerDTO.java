package co.edu.uco.pch.business.assembler.DTO;

import java.util.List;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssemblerDTO<D, K> extends Assembler<D, K> {
	
	K toDTO(D domain);
	
	List<K> toDTOColletion (List<D> domain);

}
