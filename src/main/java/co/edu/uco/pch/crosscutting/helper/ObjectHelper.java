package co.edu.uco.pch.crosscutting.helper;

public class ObjectHelper {
private static final ObjectHelper INSTANCE = new ObjectHelper();
	
	private ObjectHelper() {
		super();
	}
	
	public static final ObjectHelper getObjectHelper() {
		return INSTANCE;
	}
	
	public <O>boolean isNULL(O objeto) {
		return objeto == null;
	}
	
	public <O> 	O getDefaulValue(O objeto, O valorDefecto) {
		return isNULL(objeto) ? valorDefecto : objeto ;
	}




}
