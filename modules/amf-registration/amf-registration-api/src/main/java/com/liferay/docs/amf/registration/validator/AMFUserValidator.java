package com.liferay.docs.amf.registration.validator;

import com.liferay.docs.amf.registration.exception.AMFUserValidationException;

import java.util.Date;

public interface AMFUserValidator {

	public void validate(String username, String firstName, String lastName, String email, Boolean male, Date dob,
			String homePhone, String mobilePhone, String address, String address2, String city, String state,
			String zip, String securityQuestion, String securityAnswer, Boolean accepted_tou, String password1,
			String password2) throws AMFUserValidationException;
}
