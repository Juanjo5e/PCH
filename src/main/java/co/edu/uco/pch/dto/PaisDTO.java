package co.edu.uco.pch.dto;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helper.TextHelper;

public final class PaisDto {
	private UUID id;
	private String nombre;
	
	public PaisDto() {
		super();
	}
	
	
	
	public PaisDto(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final PaisDto buil() {
		return new PaisDto();
	}

	public final UUID getId() {
		return id;
	}
	public final PaisDto setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final  String getNombre() {
		return nombre;
	}
	public final PaisDto setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	
}
