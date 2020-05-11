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

package com.liferay.amf.event.monitor.s.service.persistence;

import com.liferay.amf.event.monitor.s.model.AMFEvent;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the amf event service. This utility wraps <code>com.liferay.amf.event.monitor.s.service.persistence.impl.AMFEventPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventPersistence
 * @generated
 */
@ProviderType
public class AMFEventUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AMFEvent amfEvent) {
		getPersistence().clearCache(amfEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AMFEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFEvent update(AMFEvent amfEvent) {
		return getPersistence().update(amfEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFEvent update(
		AMFEvent amfEvent, ServiceContext serviceContext) {

		return getPersistence().update(amfEvent, serviceContext);
	}

	/**
	 * Returns all the amf events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf events
	 */
	public static List<AMFEvent> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the amf events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @return the range of matching amf events
	 */
	public static List<AMFEvent> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the amf events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf events
	 */
	@Deprecated
	public static List<AMFEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the amf events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf events
	 */
	public static List<AMFEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByUuid_First(
			String uuid, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByUuid_First(
		String uuid, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByUuid_Last(
			String uuid, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByUuid_Last(
		String uuid, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where uuid = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public static AMFEvent[] findByUuid_PrevAndNext(
			long auditEventId, String uuid,
			OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUuid_PrevAndNext(
			auditEventId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amf events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amf events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf events
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the amf events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf events
	 */
	public static List<AMFEvent> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the amf events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @return the range of matching amf events
	 */
	public static List<AMFEvent> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUserId(long, int, int, OrderByComparator)}
	 * @param userId the user ID
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf events
	 */
	@Deprecated
	public static List<AMFEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the amf events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf events
	 */
	public static List<AMFEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByUserId_First(
			long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByUserId_First(
		long userId, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByUserId_Last(
			long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByUserId_Last(
		long userId, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where userId = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public static AMFEvent[] findByUserId_PrevAndNext(
			long auditEventId, long userId,
			OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUserId_PrevAndNext(
			auditEventId, userId, orderByComparator);
	}

	/**
	 * Removes all the amf events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of amf events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf events
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the amf events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching amf events
	 */
	public static List<AMFEvent> findByEventType(String eventType) {
		return getPersistence().findByEventType(eventType);
	}

	/**
	 * Returns a range of all the amf events where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @return the range of matching amf events
	 */
	public static List<AMFEvent> findByEventType(
		String eventType, int start, int end) {

		return getPersistence().findByEventType(eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the amf events where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByEventType(String, int, int, OrderByComparator)}
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf events
	 */
	@Deprecated
	public static List<AMFEvent> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEventType(
			eventType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the amf events where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf events
	 */
	public static List<AMFEvent> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().findByEventType(
			eventType, start, end, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByEventType_First(
			String eventType, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByEventType_First(
			eventType, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByEventType_First(
		String eventType, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByEventType_First(
			eventType, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByEventType_Last(
			String eventType, OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByEventType_Last(
			eventType, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByEventType_Last(
		String eventType, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByEventType_Last(
			eventType, orderByComparator);
	}

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where eventType = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public static AMFEvent[] findByEventType_PrevAndNext(
			long auditEventId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByEventType_PrevAndNext(
			auditEventId, eventType, orderByComparator);
	}

	/**
	 * Removes all the amf events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public static void removeByEventType(String eventType) {
		getPersistence().removeByEventType(eventType);
	}

	/**
	 * Returns the number of amf events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching amf events
	 */
	public static int countByEventType(String eventType) {
		return getPersistence().countByEventType(eventType);
	}

	/**
	 * Returns all the amf events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching amf events
	 */
	public static List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType) {

		return getPersistence().findByUserIdAndEventType(userId, eventType);
	}

	/**
	 * Returns a range of all the amf events where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @return the range of matching amf events
	 */
	public static List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end) {

		return getPersistence().findByUserIdAndEventType(
			userId, eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the amf events where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUserIdAndEventType(long,String, int, int, OrderByComparator)}
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf events
	 */
	@Deprecated
	public static List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndEventType(
			userId, eventType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the amf events where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf events
	 */
	public static List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().findByUserIdAndEventType(
			userId, eventType, start, end, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByUserIdAndEventType_First(
			long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUserIdAndEventType_First(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByUserIdAndEventType_First(
		long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByUserIdAndEventType_First(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public static AMFEvent findByUserIdAndEventType_Last(
			long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUserIdAndEventType_Last(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public static AMFEvent fetchByUserIdAndEventType_Last(
		long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().fetchByUserIdAndEventType_Last(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public static AMFEvent[] findByUserIdAndEventType_PrevAndNext(
			long auditEventId, long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByUserIdAndEventType_PrevAndNext(
			auditEventId, userId, eventType, orderByComparator);
	}

	/**
	 * Removes all the amf events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	public static void removeByUserIdAndEventType(
		long userId, String eventType) {

		getPersistence().removeByUserIdAndEventType(userId, eventType);
	}

	/**
	 * Returns the number of amf events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching amf events
	 */
	public static int countByUserIdAndEventType(long userId, String eventType) {
		return getPersistence().countByUserIdAndEventType(userId, eventType);
	}

	/**
	 * Caches the amf event in the entity cache if it is enabled.
	 *
	 * @param amfEvent the amf event
	 */
	public static void cacheResult(AMFEvent amfEvent) {
		getPersistence().cacheResult(amfEvent);
	}

	/**
	 * Caches the amf events in the entity cache if it is enabled.
	 *
	 * @param amfEvents the amf events
	 */
	public static void cacheResult(List<AMFEvent> amfEvents) {
		getPersistence().cacheResult(amfEvents);
	}

	/**
	 * Creates a new amf event with the primary key. Does not add the amf event to the database.
	 *
	 * @param auditEventId the primary key for the new amf event
	 * @return the new amf event
	 */
	public static AMFEvent create(long auditEventId) {
		return getPersistence().create(auditEventId);
	}

	/**
	 * Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public static AMFEvent remove(long auditEventId)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().remove(auditEventId);
	}

	public static AMFEvent updateImpl(AMFEvent amfEvent) {
		return getPersistence().updateImpl(amfEvent);
	}

	/**
	 * Returns the amf event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public static AMFEvent findByPrimaryKey(long auditEventId)
		throws com.liferay.amf.event.monitor.s.exception.NoSuchEventException {

		return getPersistence().findByPrimaryKey(auditEventId);
	}

	/**
	 * Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	 */
	public static AMFEvent fetchByPrimaryKey(long auditEventId) {
		return getPersistence().fetchByPrimaryKey(auditEventId);
	}

	/**
	 * Returns all the amf events.
	 *
	 * @return the amf events
	 */
	public static List<AMFEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amf events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @return the range of amf events
	 */
	public static List<AMFEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amf events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf events
	 */
	@Deprecated
	public static List<AMFEvent> findAll(
		int start, int end, OrderByComparator<AMFEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the amf events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf events
	 * @param end the upper bound of the range of amf events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf events
	 */
	public static List<AMFEvent> findAll(
		int start, int end, OrderByComparator<AMFEvent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the amf events from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf events.
	 *
	 * @return the number of amf events
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AMFEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFEventPersistence, AMFEventPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFEventPersistence.class);

		ServiceTracker<AMFEventPersistence, AMFEventPersistence>
			serviceTracker =
				new ServiceTracker<AMFEventPersistence, AMFEventPersistence>(
					bundle.getBundleContext(), AMFEventPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}