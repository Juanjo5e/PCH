package co.edu.uco.pch.data.dao.entity;

import java.util.UUID;

import co.edu.uco.pch.entity.DepartamentoEntity;

public interface DepartamentoDAO extends RetriveDAO<DepartamentoEntity>{
	DepartamentoEntity obtenerPorId(UUID id);

}
