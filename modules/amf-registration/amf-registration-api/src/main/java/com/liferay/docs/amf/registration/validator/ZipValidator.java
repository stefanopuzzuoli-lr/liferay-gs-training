package com.liferay.docs.amf.registration.validator;


import com.liferay.docs.amf.registration.exception.ZipValidationException;

public interface ZipValidator {

	public void validate(String zip) throws ZipValidationException;
}
