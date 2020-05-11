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

package com.liferay.amf.event.monitor.s.service.http;

import com.liferay.amf.event.monitor.s.service.AMFEventServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>AMFEventServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.amf.event.monitor.s.model.AMFEventSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.amf.event.monitor.s.model.AMFEvent</code>, that is translated to a
 * <code>com.liferay.amf.event.monitor.s.model.AMFEventSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventServiceHttp
 * @generated
 */
@ProviderType
public class AMFEventServiceSoap {

	public static com.liferay.amf.event.monitor.s.model.AMFEventSoap
			addAMFEvent(
				long auditEventId, long userId, String username,
				java.util.Date createDate, String eventType, String clientIp,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.amf.event.monitor.s.model.AMFEvent returnValue =
				AMFEventServiceUtil.addAMFEvent(
					auditEventId, userId, username, createDate, eventType,
					clientIp, serviceContext);

			return com.liferay.amf.event.monitor.s.model.AMFEventSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEventSoap
			getAMFEvent(long userId)
		throws RemoteException {

		try {
			com.liferay.amf.event.monitor.s.model.AMFEvent returnValue =
				AMFEventServiceUtil.getAMFEvent(userId);

			return com.liferay.amf.event.monitor.s.model.AMFEventSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEventSoap[]
			getAMFEventByUserId(long userId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
				returnValue = AMFEventServiceUtil.getAMFEventByUserId(userId);

			return com.liferay.amf.event.monitor.s.model.AMFEventSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEventSoap[]
			getAMFEventByEventType(String eventType)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
				returnValue = AMFEventServiceUtil.getAMFEventByEventType(
					eventType);

			return com.liferay.amf.event.monitor.s.model.AMFEventSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEventSoap[]
			getAMFEventByUserIdAndEventType(long userId, String eventType)
		throws RemoteException {

		try {
			java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
				returnValue =
					AMFEventServiceUtil.getAMFEventByUserIdAndEventType(
						userId, eventType);

			return com.liferay.amf.event.monitor.s.model.AMFEventSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AMFEventServiceSoap.class);

}