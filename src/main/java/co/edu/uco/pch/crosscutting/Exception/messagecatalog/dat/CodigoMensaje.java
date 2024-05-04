package co.edu.uco.pch.crosscutting.Exception.messagecatalog.dat;

import static co.edu.uco.pch.crosscutting.helper.TextHelper.concatenate;
import static co.edu.uco.pch.crosscutting.helper.TextHelper.UNDERLINE;

public enum CodigoMensaje {
	
	M0001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"00001", true),
	M0002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"00002", true),
	M0003(TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"00003", true),
	M0004(TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"00004", true);
	
	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String codigo;
	private boolean base;
	
	
	private CodigoMensaje(final TipoMensaje tipo,final CategoriaMensaje categoria, final String codigo, final boolean base) {
		setTipo (tipo);
		setCategoria (categoria);
		setCodigo (codigo);
		setBase(base);
	}


	public boolean isBase() {
		return base;
	}


	private void setBase(final boolean base) {
		this.base = base;
	}


	private void setTipo(final TipoMensaje tipo) {
		this.tipo = tipo;
	}


	private void setCategoria(final CategoriaMensaje categoria) {
		this.categoria = categoria;
	}


	private void setCodigo(final String codigo) {
		this.codigo = codigo;
	}


	public TipoMensaje getTipo() {
		return tipo;
	}


	public CategoriaMensaje getCategoria() {
		return categoria;
	}


	public String getCodigo() {
		return codigo;
	}
	
	public String getIdentificador() {
		return concatenate(getTipo().name(),UNDERLINE, getCategoria().name(),
				UNDERLINE, 
				getCodigo());
				
	}

	


}
