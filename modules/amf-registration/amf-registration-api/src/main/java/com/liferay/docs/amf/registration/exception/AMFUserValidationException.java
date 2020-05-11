/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.docs.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author liferay
 */
@ProviderType
public class AMFUserValidationException extends PortalException {
	
	/**
	* Custom constructor taking a list as a parameter.
	*
	* @param errors
	*/
	public AMFUserValidationException(List<String> errors) {
		super(String.join(",", errors));
		_errors = errors;
	}
	public List<String> getErrors() {
		return _errors;
	}
	private List<String> _errors;

	public AMFUserValidationException() {
	}

	public AMFUserValidationException(String msg) {
		super(msg);
	}

	public AMFUserValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AMFUserValidationException(Throwable cause) {
		super(cause);
	}

}