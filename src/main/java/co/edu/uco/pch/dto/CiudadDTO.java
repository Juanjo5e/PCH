package co.edu.uco.pch.dto;

import java.util.UUID;

public final class CiudadDTO {
	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;
	
	
	public CiudadDTO(){
		super();
		
	}
	
	
	
	public CiudadDTO(UUID id, String nombre, DepartamentoDTO departamento) {
		super();
		setId (id);
		setNombre (nombre);
		setDepartamento(departamento);
	}



	public static final CiudadDTO buil() {
		return new CiudadDTO();
	}

	public UUID getId() {
		return id;
	}
	public CiudadDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final CiudadDTO setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	public final DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public final void setDepartamento(final DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
	
	

}
