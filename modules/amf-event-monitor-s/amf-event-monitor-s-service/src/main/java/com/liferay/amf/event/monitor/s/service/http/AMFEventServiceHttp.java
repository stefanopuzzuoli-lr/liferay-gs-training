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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>AMFEventServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventServiceSoap
 * @generated
 */
@ProviderType
public class AMFEventServiceHttp {

	public static com.liferay.amf.event.monitor.s.model.AMFEvent addAMFEvent(
			HttpPrincipal httpPrincipal, long auditEventId, long userId,
			String username, java.util.Date createDate, String eventType,
			String clientIp,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AMFEventServiceUtil.class, "addAMFEvent",
				_addAMFEventParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, auditEventId, userId, username, createDate,
				eventType, clientIp, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.amf.event.monitor.s.model.AMFEvent)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEvent getAMFEvent(
			HttpPrincipal httpPrincipal, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AMFEventServiceUtil.class, "getAMFEvent",
				_getAMFEventParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.amf.event.monitor.s.model.AMFEvent)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByUserId(HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				AMFEventServiceUtil.class, "getAMFEventByUserId",
				_getAMFEventByUserIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.amf.event.monitor.s.model.AMFEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByEventType(HttpPrincipal httpPrincipal, String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				AMFEventServiceUtil.class, "getAMFEventByEventType",
				_getAMFEventByEventTypeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.amf.event.monitor.s.model.AMFEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEventByUserIdAndEventType(
			HttpPrincipal httpPrincipal, long userId, String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				AMFEventServiceUtil.class, "getAMFEventByUserIdAndEventType",
				_getAMFEventByUserIdAndEventTypeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.amf.event.monitor.s.model.AMFEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AMFEventServiceHttp.class);

	private static final Class<?>[] _addAMFEventParameterTypes0 = new Class[] {
		long.class, long.class, String.class, java.util.Date.class,
		String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _getAMFEventParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getAMFEventByUserIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getAMFEventByEventTypeParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[]
		_getAMFEventByUserIdAndEventTypeParameterTypes4 = new Class[] {
			long.class, String.class
		};

}