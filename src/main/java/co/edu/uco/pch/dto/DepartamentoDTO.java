package co.edu.uco.pch.dto;

import java.util.UUID;

public final class DepartamentoDTO {
	private UUID id;
	private String nombre;
	private PaisDto pais;

	
	public DepartamentoDTO() {
		super();
	}
	
	public DepartamentoDTO(final UUID id, final String nombre, final PaisDto pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}
	
	public static final DepartamentoDTO buil() {
		return new DepartamentoDTO();
	}

	public final UUID getId() {
		return id;
	}
	public final DepartamentoDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public String getNombre() {
		return nombre;
	}
	public final  DepartamentoDTO setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	public final PaisDto getPais() {
		return getPais();
	}
	public final  void setPais(final PaisDto pais) {
		this.pais = pais;
	}
	
	
	
}
