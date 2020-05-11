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

import com.liferay.amf.event.monitor.s.exception.NoSuchEventException;
import com.liferay.amf.event.monitor.s.model.AMFEvent;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amf event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventUtil
 * @generated
 */
@ProviderType
public interface AMFEventPersistence extends BasePersistence<AMFEvent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFEventUtil} to access the amf event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amf events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf events
	 */
	public java.util.List<AMFEvent> findByUuid(String uuid);

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
	public java.util.List<AMFEvent> findByUuid(String uuid, int start, int end);

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
	public java.util.List<AMFEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache);

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
	public java.util.List<AMFEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the first amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByUuid_First(
			String uuid, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the first amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByUuid_First(
		String uuid, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the last amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByUuid_Last(
			String uuid, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the last amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByUuid_Last(
		String uuid, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where uuid = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public AMFEvent[] findByUuid_PrevAndNext(
			long auditEventId, String uuid,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Removes all the amf events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of amf events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf events
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the amf events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf events
	 */
	public java.util.List<AMFEvent> findByUserId(long userId);

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
	public java.util.List<AMFEvent> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<AMFEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache);

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
	public java.util.List<AMFEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the first amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByUserId_First(
			long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the first amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByUserId_First(
		long userId, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the last amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByUserId_Last(
			long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the last amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByUserId_Last(
		long userId, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where userId = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public AMFEvent[] findByUserId_PrevAndNext(
			long auditEventId, long userId,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Removes all the amf events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of amf events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf events
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the amf events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching amf events
	 */
	public java.util.List<AMFEvent> findByEventType(String eventType);

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
	public java.util.List<AMFEvent> findByEventType(
		String eventType, int start, int end);

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
	public java.util.List<AMFEvent> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache);

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
	public java.util.List<AMFEvent> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the first amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByEventType_First(
			String eventType, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the first amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByEventType_First(
		String eventType, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the last amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByEventType_Last(
			String eventType, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the last amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByEventType_Last(
		String eventType, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the amf events before and after the current amf event in the ordered set where eventType = &#63;.
	 *
	 * @param auditEventId the primary key of the current amf event
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public AMFEvent[] findByEventType_PrevAndNext(
			long auditEventId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Removes all the amf events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public void removeByEventType(String eventType);

	/**
	 * Returns the number of amf events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching amf events
	 */
	public int countByEventType(String eventType);

	/**
	 * Returns all the amf events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching amf events
	 */
	public java.util.List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType);

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
	public java.util.List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end);

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
	public java.util.List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache);

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
	public java.util.List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the first amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByUserIdAndEventType_First(
			long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the first amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByUserIdAndEventType_First(
		long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Returns the last amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	public AMFEvent findByUserIdAndEventType_Last(
			long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Returns the last amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	public AMFEvent fetchByUserIdAndEventType_Last(
		long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator);

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
	public AMFEvent[] findByUserIdAndEventType_PrevAndNext(
			long auditEventId, long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException;

	/**
	 * Removes all the amf events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	public void removeByUserIdAndEventType(long userId, String eventType);

	/**
	 * Returns the number of amf events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching amf events
	 */
	public int countByUserIdAndEventType(long userId, String eventType);

	/**
	 * Caches the amf event in the entity cache if it is enabled.
	 *
	 * @param amfEvent the amf event
	 */
	public void cacheResult(AMFEvent amfEvent);

	/**
	 * Caches the amf events in the entity cache if it is enabled.
	 *
	 * @param amfEvents the amf events
	 */
	public void cacheResult(java.util.List<AMFEvent> amfEvents);

	/**
	 * Creates a new amf event with the primary key. Does not add the amf event to the database.
	 *
	 * @param auditEventId the primary key for the new amf event
	 * @return the new amf event
	 */
	public AMFEvent create(long auditEventId);

	/**
	 * Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public AMFEvent remove(long auditEventId) throws NoSuchEventException;

	public AMFEvent updateImpl(AMFEvent amfEvent);

	/**
	 * Returns the amf event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	public AMFEvent findByPrimaryKey(long auditEventId)
		throws NoSuchEventException;

	/**
	 * Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	 */
	public AMFEvent fetchByPrimaryKey(long auditEventId);

	/**
	 * Returns all the amf events.
	 *
	 * @return the amf events
	 */
	public java.util.List<AMFEvent> findAll();

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
	public java.util.List<AMFEvent> findAll(int start, int end);

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
	public java.util.List<AMFEvent> findAll(
		int start, int end, OrderByComparator<AMFEvent> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<AMFEvent> findAll(
		int start, int end, OrderByComparator<AMFEvent> orderByComparator);

	/**
	 * Removes all the amf events from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amf events.
	 *
	 * @return the number of amf events
	 */
	public int countAll();

}