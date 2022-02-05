package com.veris.pruebakevinmarin.util.enums;

public enum TipoIdentificacionEnum {
	
	/**
	 * {@enum c}.
	 * 
	 */
	ced("c"), 
	
	
	/**
	 * {@enum r}.
	 * 
	 */
	ruc("r"),
	
	/**
	 * {@enum p}.
	 * 
	 */
	pas("p");
	
	private final String value;
	
	private TipoIdentificacionEnum(String value) {
		this.value = value;
	}
	
	/**
	 * Return the string value of this enum token.
	 */
	public String value() {
		return this.value;
	}
}
