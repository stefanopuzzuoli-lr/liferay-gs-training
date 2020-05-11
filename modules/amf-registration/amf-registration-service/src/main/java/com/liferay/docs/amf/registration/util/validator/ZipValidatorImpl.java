package com.liferay.docs.amf.registration.util.validator;

import com.liferay.docs.amf.registration.exception.ZipValidationException;
import com.liferay.docs.amf.registration.validator.ZipValidator;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ZipValidator.class)
public class ZipValidatorImpl implements ZipValidator {

	public void validate(String zip) throws ZipValidationException {
		if (!isZipValid(zip)) {
			throw new ZipValidationException("Invalid ZIP");
		}
	}

	private boolean isZipValid(String zip) {
		// Verify zip
		return !(zip.equals("") || zip.length() != 5 || !zip.matches("^\\d+$"));
	}
}
