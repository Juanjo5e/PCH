package co.edu.uco.pch.business.domain;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helper.TextHelper;
import co.edu.uco.pch.crosscutting.helper.UUIDHelper;

public class DepartamentoDomain {
	private UUID id;
	private String nombre;
	private PaisDomain pais;
	
	private DepartamentoDomain(final UUID id, final String nombre, final PaisDomain pais) {
		setId(id);
		setNombre(getNombre());
		setPais(pais);
	}
	public static DepartamentoDomain build(final UUID id, final String nombre, final PaisDomain pais) {
		return new DepartamentoDomain(id, nombre, pais);
	}
	public static DepartamentoDomain build(final UUID id) {
		return new DepartamentoDomain(id, TextHelper.EMPTY, PaisDomain.build());
	}
	public static DepartamentoDomain build() {
		return new DepartamentoDomain(UUIDHelper.generarUUIDDefecto(),
				TextHelper.EMPTY, PaisDomain.build());
	}
	
	
	private final void setId(UUID id) {
		this.id = id;
	}
	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private final void setPais(PaisDomain pais) {
		this.pais = pais;
	}
	public UUID getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public PaisDomain getPais() {
		return pais;
	}
	

}