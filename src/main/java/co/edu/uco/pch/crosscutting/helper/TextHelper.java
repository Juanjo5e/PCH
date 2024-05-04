package co.edu.uco.pch.crosscutting.helper;

public class TextHelper {
	
	public static final String EMPTY ="";
	public static final String UNDERLINE = "_";
	private TextHelper() {
		super();
	}

	public static final boolean isNull(final String string) {
		return string == null;
	}
	public static final boolean isNullOrEmpty (final String string) {
		return isNull(string) || EMPTY.equals(string.trim());
	}
	public static final String getDefaultValue(final String string, final String defaultValue) {
		return isNullOrEmpty(string) ? defaultValue : string; }
	
	public static final String getDefaultValue(final String string) {
		return getDefaultValue(string, EMPTY);
	}
	public static final String applyTrim(final String string) {
		return getDefaultValue(string).trim();
	}
	public static final String concatenate(String... strings ) {
		final var sb = new StringBuilder(EMPTY);
		 
		if (!ObjectHelper.getObjectHelper().isNULL(strings)) {
			for (final var string : strings ) {
				sb.append(applyTrim(string));
			}
		}
		return sb.toString();
	}
	}