package com.ipl.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String errMesg) {
		super(errMesg);
	}
}