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
 * Provides the local service utility for AMFEvent. This utility wraps
 * <code>com.liferay.amf.event.monitor.s.service.impl.AMFEventLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLocalService
 * @generated
 */
@ProviderType
public class AMFEventLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.event.monitor.s.service.impl.AMFEventLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the amf event to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfEvent the amf event
	 * @return the amf event that was added
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent addAMFEvent(
		com.liferay.amf.event.monitor.s.model.AMFEvent amfEvent) {

		return getService().addAMFEvent(amfEvent);
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEvent addAMFEvent(
			long auditEventId, long userId, String username,
			java.util.Date createDate, String eventType, String clientIp,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAMFEvent(
			auditEventId, userId, username, createDate, eventType, clientIp,
			serviceContext);
	}

	/**
	 * Creates a new amf event with the primary key. Does not add the amf event to the database.
	 *
	 * @param auditEventId the primary key for the new amf event
	 * @return the new amf event
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent createAMFEvent(
		long auditEventId) {

		return getService().createAMFEvent(auditEventId);
	}

	/**
	 * Deletes the amf event from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfEvent the amf event
	 * @return the amf event that was removed
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent deleteAMFEvent(
		com.liferay.amf.event.monitor.s.model.AMFEvent amfEvent) {

		return getService().deleteAMFEvent(amfEvent);
	}

	/**
	 * Deletes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws PortalException if a amf event with the primary key could not be found
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent deleteAMFEvent(
			long auditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMFEvent(auditEventId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.amf.event.monitor.s.model.impl.AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.amf.event.monitor.s.model.impl.AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.amf.event.monitor.s.model.AMFEvent fetchAMFEvent(
		long auditEventId) {

		return getService().fetchAMFEvent(auditEventId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the amf event with the primary key.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event
	 * @throws PortalException if a amf event with the primary key could not be found
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent getAMFEvent(
			long auditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFEvent(auditEventId);
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
	 * Returns a range of all the amf events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.amf.event.monitor.s.model.impl.AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @return the range of amf events
	 */
	public static java.util.List<com.liferay.amf.event.monitor.s.model.AMFEvent>
		getAMFEvents(int start, int end) {

		return getService().getAMFEvents(start, end);
	}

	/**
	 * Returns the number of amf events.
	 *
	 * @return the number of amf events
	 */
	public static int getAMFEventsCount() {
		return getService().getAMFEventsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the amf event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfEvent the amf event
	 * @return the amf event that was updated
	 */
	public static com.liferay.amf.event.monitor.s.model.AMFEvent updateAMFEvent(
		com.liferay.amf.event.monitor.s.model.AMFEvent amfEvent) {

		return getService().updateAMFEvent(amfEvent);
	}

	public static AMFEventLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFEventLocalService, AMFEventLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFEventLocalService.class);

		ServiceTracker<AMFEventLocalService, AMFEventLocalService>
			serviceTracker =
				new ServiceTracker<AMFEventLocalService, AMFEventLocalService>(
					bundle.getBundleContext(), AMFEventLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}