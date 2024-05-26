package co.edu.uco.pch.data.dao.entity;

import java.util.List;

import co.edu.uco.pch.entity.PaisEntity;

public interface PaisDAO extends RetriveDAO<PaisEntity>{

	void modificar(PaisEntity data);

	List<PaisEntity> consultar(PaisEntity data);

}
