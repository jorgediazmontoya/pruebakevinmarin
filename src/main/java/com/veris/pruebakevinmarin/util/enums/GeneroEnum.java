package com.veris.pruebakevinmarin.util.enums;

public enum GeneroEnum {
	
	/**
	 * {@enum masculino}.
	 * 
	 */
	MASCULINO("M"), 
	
	
	/**
	 * {@enum femenino}.
	 * 
	 */
	FEMENINO("F");
		
	private final String value;
	
	private GeneroEnum(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
