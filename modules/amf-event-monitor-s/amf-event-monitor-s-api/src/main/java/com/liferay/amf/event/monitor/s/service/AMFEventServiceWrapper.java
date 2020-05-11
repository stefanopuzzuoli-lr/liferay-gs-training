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

package com.liferay.amf.event.monitor.s.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link AMFEventService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventService
 * @generated
 */
@ProviderType
public class AMFEventServiceWrapper
	implements AMFEventService, ServiceWrapper<AMFEventService> {

	public AMFEventServiceWrapper(AMFEventService amfEventService) {
		_amfEventService = amfEventService;
	}

	@Override
	public com.liferay.amf.event.monitor.s.model.AMFEvent addAMFEvent(
			long auditEventId, long userId, String username,
			java.util.Date createDate, String eventType, String clientIp,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventService.addAMFEvent(
			auditEventId, userId, username, createDate, eventType, clientIp,
			serviceContext);
	}

	@Override
	public com.liferay.amf.event.monitor.s.model.AMFEvent getAMFEvent(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventService.getAMFEvent(userId);
	}

	@Override
	public java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByEventType(String eventType) {

		return _amfEventService.getAMFEventByEventType(eventType);
	}

	@Override
	public java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByUserId(long userId) {

		return _amfEventService.getAMFEventByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByUserIdAndEventType(long userId, String eventType) {

		return _amfEventService.getAMFEventByUserIdAndEventType(
			userId, eventType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfEventService.getOSGiServiceIdentifier();
	}

	@Override
	public AMFEventService getWrappedService() {
		return _amfEventService;
	}

	@Override
	public void setWrappedService(AMFEventService amfEventService) {
		_amfEventService = amfEventService;
	}

	private AMFEventService _amfEventService;

}