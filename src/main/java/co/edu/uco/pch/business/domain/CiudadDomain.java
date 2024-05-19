package co.edu.uco.pch.business.domain;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helper.TextHelper;
import co.edu.uco.pch.crosscutting.helper.UUIDHelper;

public class CiudadDomain {
	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;
	
	private CiudadDomain(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static CiudadDomain build(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}	
	public static CiudadDomain build(final UUID id) {
		return new CiudadDomain(id, TextHelper.EMPTY, DepartamentoDomain.build());	
	}
	public static CiudadDomain build() {
		return new CiudadDomain(UUIDHelper.getDefault(),
				TextHelper.EMPTY, DepartamentoDomain.build());
	}	
	
	
	private final void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	private final void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	private final void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = departamento;
	}
	public UUID getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public DepartamentoDomain getDepartamento() {
		return departamento;
	}
	
	
}