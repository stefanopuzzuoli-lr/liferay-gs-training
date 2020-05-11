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

package com.liferay.docs.amf.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link AMFUserService}.
 *
 * @author liferay
 * @see AMFUserService
 * @generated
 */
@ProviderType
public class AMFUserServiceWrapper
	implements AMFUserService, ServiceWrapper<AMFUserService> {

	public AMFUserServiceWrapper(AMFUserService amfUserService) {
		_amfUserService = amfUserService;
	}

	@Override
	public java.util.List<com.liferay.docs.amf.registration.model.AMFUser>
		getAMFUserByZip(String zip) {

		return _amfUserService.getAMFUserByZip(zip);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfUserService.getOSGiServiceIdentifier();
	}

	@Override
	public AMFUserService getWrappedService() {
		return _amfUserService;
	}

	@Override
	public void setWrappedService(AMFUserService amfUserService) {
		_amfUserService = amfUserService;
	}

	private AMFUserService _amfUserService;

}