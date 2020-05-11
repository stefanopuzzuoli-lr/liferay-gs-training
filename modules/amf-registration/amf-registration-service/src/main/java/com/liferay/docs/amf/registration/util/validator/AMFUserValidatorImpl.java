package com.liferay.docs.amf.registration.util.validator;

import com.liferay.docs.amf.registration.exception.AMFUserValidationException;
import com.liferay.docs.amf.registration.validator.AMFUserValidator;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = AMFUserValidator.class)

public class AMFUserValidatorImpl implements AMFUserValidator {

	public void validate(String username, String firstName, String lastName, String email, Boolean male, Date dob,
			String homePhone, String mobilePhone, String address, String address2, String city, String state,
			String zip, String securityQuestion, String securityAnswer, Boolean accepted_tou, String password1,
			String password2)
			throws AMFUserValidationException {
		List<String> errors = new ArrayList<>();
		if (!isAMFUserValid(username,  firstName,  lastName,  email,  male,  dob,
				 homePhone,  mobilePhone,  address,  address2,  city,  state,
				 zip,  securityQuestion,  securityAnswer,  accepted_tou,  password1,
				 password2, errors)) {
			throw new AMFUserValidationException(errors);
		}
	}

	private boolean isAMFUserValid(String username, String firstName, String lastName, String email, Boolean male, Date dob,
			String homePhone, String mobilePhone, String address, String address2, String city, String state,
			String zip, String securityQuestion, String securityAnswer, Boolean accepted_tou, String password1,
			String password2, final List<String> errors) {
		boolean result = true;
		result &= isUsernameValid(username, errors);
		result &= isFirstNameValid(firstName, errors);
		result &= isLastNameValid(lastName, errors);
		result &= isEmailValid(email, errors);
		result &= isMaleValid(male, errors);
		result &= isDateValid(dob, errors);
		result &= isHomePhoneValid(homePhone, errors);
		result &= isMobilePhoneValid(mobilePhone, errors);
		result &= isAddressValid(address, errors);
		result &= isAddress2Valid(address2, errors);
		result &= isCityValid(city, errors);
		result &= isStateValid(state, errors);
		result &= isZipValid(zip, errors);
		result &= isSecurityQuestionValid(securityQuestion, errors);
		result &= isSecurityAnswerValid(securityAnswer, errors);
		result &= isAccepteTou(accepted_tou, errors);
		result &= isPassword1Valid(password1, errors);
		result &= isPassword2Valid(password1, password2, errors);
		return result;
	}

	
	private boolean isUsernameValid(final String username, final List<String> errors) {
		boolean result = true;
		// Verify username
		if (username.equals("") || !username.matches("^[a-zA-Z0-9_]*$") || username.length() < 4 || username.length() > 16 ) {
			errors.add("usernameInvalid");
			result = false;
		}
		return result;
	}
	
	private boolean isFirstNameValid(final String firstName, final List<String> errors) {
		boolean result = true;
		// Verify first name
		if (firstName.equals("") || !firstName.matches("^[a-zA-Z0-9_]*$") || firstName.length() > 50 ) {
			errors.add("firstNameInvalid");
			result = false;
		}
		return result;
	}

	private boolean isLastNameValid(final String lastName, final List<String> errors) {
		boolean result = true;
		// Verify last name
		if (lastName.equals("") || !lastName.matches("^[a-zA-Z0-9_]*$") || lastName.length() > 50 ) {
			errors.add("lastNameInvalid");
			result = false;
		}
		return result;
	}
	private boolean isEmailValid(final String email, final List<String> errors) {
		boolean result = true;
		// Verify email
		if (email.equals("") || !email.matches("^[a-zA-Z0-9_.@]*$") || email.length() > 255 ) {
			errors.add("emailInvalid");
			result = false;
		}
		return result;
	}
	private boolean isMaleValid(final Boolean male, final List<String> errors) {
		boolean result = true;
		// Verify gender
		if (!male) {
			errors.add("isMaleInvalid");
			result = false;
		}
		return result;
	}
	private boolean isDateValid(final Date dob, final List<String> errors) {
		boolean result = true;
		// Verify date of birth
		if (dob == null) {
			errors.add("dobInvalid");
			result = false;
		}
		else
		{
			//Getting the default zone id
			ZoneId defaultZoneId = ZoneId.systemDefault();
				
			//Converting the date to Instant
			Instant instant = dob.toInstant();
				
			//Converting the Date to LocalDate
			LocalDate birthdate = instant.atZone(defaultZoneId).toLocalDate();
			
			LocalDate now = LocalDate.now();
			
			Period period = Period.between(birthdate, now);
			
			// Get age of user
			Integer age = period.getYears();
			if (age < 13)
			{
				errors.add("dobTooYoung");
				result = false;
			}
			
		}
		return result;
	}
	private boolean isHomePhoneValid(final String homePhone, final List<String> errors) {
		boolean result = true;
		// Verify home phone
		if (homePhone == null || (homePhone.length() > 0 && homePhone.length() != 10)) {
			errors.add("homePhoneInvalid");
			result = false;
		}
		return result;
	}
	private boolean isMobilePhoneValid(final String mobilePhone, final List<String> errors) {
		boolean result = true;
		// Verify mobile phone
		if (mobilePhone == null || (mobilePhone.length() > 0 && mobilePhone.length() != 10)) {
			errors.add("mobilePhoneInvalid");
			result = false;
		}
		return result;
	}
	private boolean isAddressValid(final String address, final List<String> errors) {
		boolean result = true;
		// Verify address
		if (address.equals("") || !address.matches("^[a-zA-Z0-9_\\s]*$") || address.length() > 255 ) {
			errors.add("addressInvalid");
			result = false;
		}
		return result;
	}
	private boolean isAddress2Valid(final String address2, final List<String> errors) {
		boolean result = true;
		// Verify address 2
		if (address2 == null || !address2.matches("^[a-zA-Z0-9_\\s]*$") || (address2.length() > 0 && address2.length() > 255)) {
			errors.add("address2Invalid");
			result = false;
		}
		return result;
	}
	private boolean isCityValid(final String city, final List<String> errors) {
		boolean result = true;
		// Verify city
		if (city.equals("") || !city.matches("^[a-zA-Z0-9_\\s]*$") || city.length() > 255 ) {
			errors.add("cityInvalid");
			result = false;
		}
		return result;
	}
	private boolean isStateValid(final String state, final List<String> errors) {
		boolean result = true;
		// Verify state
		if (state.equals("")) {
			errors.add("stateInvalid");
			result = false;
		}
		return result;
	}
	private boolean isZipValid(final String zip, final List<String> errors) {
		boolean result = true;
		// Verify zip
		if (zip.equals("") || zip.length() != 5) {
			errors.add("zipInvalid");
			result = false;
		}
		return result;
	}
	private boolean isSecurityQuestionValid(final String securityQuestion, final List<String> errors) {
		boolean result = true;
		// Verify security question
		if (securityQuestion == null) {
			errors.add("securityQuestionInvalid");
			result = false;
		}
		return result;
	}
	private boolean isSecurityAnswerValid(final String securityAnswer, final List<String> errors) {
		boolean result = true;
		// Verify security answer
		if (securityAnswer.equals("") || !securityAnswer.matches("^[a-zA-Z0-9_\\s]*$") || securityAnswer.length() > 255 ) {
			errors.add("securityAnswerInvalid");
			result = false;
		}
		return result;
	}
	private boolean isAccepteTou(final Boolean acceptedTou, final List<String> errors) {
		boolean result = true;
		// Verify accepted terms of use
		if (acceptedTou == false) {
			errors.add("acceptedTouInvalid");
			result = false;
		}
		return result;
	}
	private boolean isPassword1Valid(final String password1, final List<String> errors) {
		boolean result = true;
		// Verify password
		if (password1.equals("") || password1.length() < 6) {
			errors.add("password1NoMatchRequirements");
			result = false;
		}
		else
		{
			Boolean matchesRequirements  = password1.matches("^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$");
			if (!matchesRequirements) {
				errors.add("password1NoMatchRequirements");
				result = false;
			}
		}
		return result;
	}
	private boolean isPassword2Valid(final String password1, final String password2, final List<String> errors) {
		boolean result = true;
		// Verify password 2
		if (!password1.equals(password2))
		{
			errors.add("passwordsNoMatch");
			result = false;
		}
		return result;
	}
}
