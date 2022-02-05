package com.veris.pruebakevinmarin.util.enums;

public enum RegionEnum {
	
	/**
	 * {@enum COS}.
	 * 
	 */
	COS("COSTA"), 
	
	
	/**
	 * {@enum SIE}.
	 * 
	 */
	SIE("SIERRA"),
	
	/**
	 * {@enum ORI}.
	 * 
	 */
	ORI("ORIENTE"),
	
	/**
	 * {@enum ORI}.
	 * 
	 */
	INS("INSULAR");
	
	private final String value;
	
	private RegionEnum (String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
