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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AMFEvent. This utility wraps
 * <code>com.liferay.amf.event.monitor.s.service.impl.AMFEventServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventService
 * @generated
 */
@ProviderType
public class AMFEventServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.event.monitor.s.service.impl.AMFEventServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent addAMFEvent(
			long auditEventId, long userId, String username,
			java.util.Date createDate, String eventType, String clientIp,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAMFEvent(
			auditEventId, userId, username, createDate, eventType, clientIp,
			serviceContext);
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEvent getAMFEvent(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFEvent(userId);
	}

	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByEventType(String eventType) {

		return getService().getAMFEventByEventType(eventType);
	}

	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByUserId(long userId) {

		return getService().getAMFEventByUserId(userId);
	}

	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByUserIdAndEventType(long userId, String eventType) {

		return getService().getAMFEventByUserIdAndEventType(userId, eventType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AMFEventService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFEventService, AMFEventService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFEventService.class);

		ServiceTracker<AMFEventService, AMFEventService> serviceTracker =
			new ServiceTracker<AMFEventService, AMFEventService>(
				bundle.getBundleContext(), AMFEventService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}