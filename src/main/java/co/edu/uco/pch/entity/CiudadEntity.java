package co.edu.uco.pch.entity;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helper.ObjectHelper;
import co.edu.uco.pch.crosscutting.helper.TextHelper;

public final class CiudadEntity {
	private UUID id;
	private String nombre;
	private DepartamentoEntity departamento;
	
	
	public CiudadEntity(){
		super();
		
	}
	
	public CiudadEntity(UUID id, String nombre, DepartamentoEntity departamento) {
		super();
		setId (id);
		setNombre (nombre);
		setDepartamento(departamento);
	}



	public static final CiudadEntity build() {
		return new CiudadEntity();
	}

	public UUID getId() {
		return id;
	}
	public CiudadEntity setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final CiudadEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	public final DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public final CiudadEntity setDepartamento(final DepartamentoEntity departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaulValue(departamento, new DepartamentoEntity());
		return this;
	}
	
	

}
