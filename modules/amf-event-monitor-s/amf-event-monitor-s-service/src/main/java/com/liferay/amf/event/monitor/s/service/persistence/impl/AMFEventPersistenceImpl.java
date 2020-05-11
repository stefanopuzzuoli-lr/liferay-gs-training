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

package com.liferay.amf.event.monitor.s.service.persistence.impl;

import com.liferay.amf.event.monitor.s.exception.NoSuchEventException;
import com.liferay.amf.event.monitor.s.model.AMFEvent;
import com.liferay.amf.event.monitor.s.model.impl.AMFEventImpl;
import com.liferay.amf.event.monitor.s.model.impl.AMFEventModelImpl;
import com.liferay.amf.event.monitor.s.service.persistence.AMFEventPersistence;
import com.liferay.amf.event.monitor.s.service.persistence.impl.constants.AMFPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the amf event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AMFEventPersistence.class)
@ProviderType
public class AMFEventPersistenceImpl
	extends BasePersistenceImpl<AMFEvent> implements AMFEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMFEventUtil</code> to access the amf event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMFEventImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the amf events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf events
	 */
	@Override
	public List<AMFEvent> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AMFEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
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
	@Override
	public List<AMFEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<AMFEvent> list = (List<AMFEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AMFEvent amfEvent : list) {
				if (!uuid.equals(amfEvent.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AMFEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByUuid_First(
			String uuid, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByUuid_First(uuid, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByUuid_First(
		String uuid, OrderByComparator<AMFEvent> orderByComparator) {

		List<AMFEvent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByUuid_Last(
			String uuid, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByUuid_Last(uuid, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last amf event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByUuid_Last(
		String uuid, OrderByComparator<AMFEvent> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AMFEvent> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEvent[] findByUuid_PrevAndNext(
			long auditEventId, String uuid,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		uuid = Objects.toString(uuid, "");

		AMFEvent amfEvent = findByPrimaryKey(auditEventId);

		Session session = null;

		try {
			session = openSession();

			AMFEvent[] array = new AMFEventImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, amfEvent, uuid, orderByComparator, true);

			array[1] = amfEvent;

			array[2] = getByUuid_PrevAndNext(
				session, amfEvent, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEvent getByUuid_PrevAndNext(
		Session session, AMFEvent amfEvent, String uuid,
		OrderByComparator<AMFEvent> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFEVENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amfEvent)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AMFEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AMFEvent amfEvent :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf events
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"amfEvent.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(amfEvent.uuid IS NULL OR amfEvent.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the amf events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf events
	 */
	@Override
	public List<AMFEvent> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<AMFEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return findByUserId(userId, start, end, orderByComparator);
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
	@Override
	public List<AMFEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<AMFEvent> list = (List<AMFEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AMFEvent amfEvent : list) {
				if ((userId != amfEvent.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFEVENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AMFEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByUserId_First(
			long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByUserId_First(userId, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByUserId_First(
		long userId, OrderByComparator<AMFEvent> orderByComparator) {

		List<AMFEvent> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByUserId_Last(
			long userId, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByUserId_Last(userId, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByUserId_Last(
		long userId, OrderByComparator<AMFEvent> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<AMFEvent> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEvent[] findByUserId_PrevAndNext(
			long auditEventId, long userId,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = findByPrimaryKey(auditEventId);

		Session session = null;

		try {
			session = openSession();

			AMFEvent[] array = new AMFEventImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, amfEvent, userId, orderByComparator, true);

			array[1] = amfEvent;

			array[2] = getByUserId_PrevAndNext(
				session, amfEvent, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEvent getByUserId_PrevAndNext(
		Session session, AMFEvent amfEvent, long userId,
		OrderByComparator<AMFEvent> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFEVENT_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amfEvent)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AMFEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (AMFEvent amfEvent :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf events
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFEVENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"amfEvent.userId = ?";

	private FinderPath _finderPathWithPaginationFindByEventType;
	private FinderPath _finderPathWithoutPaginationFindByEventType;
	private FinderPath _finderPathCountByEventType;

	/**
	 * Returns all the amf events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching amf events
	 */
	@Override
	public List<AMFEvent> findByEventType(String eventType) {
		return findByEventType(
			eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findByEventType(
		String eventType, int start, int end) {

		return findByEventType(eventType, start, end, null);
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
	@Override
	public List<AMFEvent> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return findByEventType(eventType, start, end, orderByComparator);
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
	@Override
	public List<AMFEvent> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		eventType = Objects.toString(eventType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByEventType;
			finderArgs = new Object[] {eventType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByEventType;
			finderArgs = new Object[] {
				eventType, start, end, orderByComparator
			};
		}

		List<AMFEvent> list = (List<AMFEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AMFEvent amfEvent : list) {
				if (!eventType.equals(amfEvent.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFEVENT_WHERE);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AMFEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByEventType_First(
			String eventType, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByEventType_First(
			eventType, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByEventType_First(
		String eventType, OrderByComparator<AMFEvent> orderByComparator) {

		List<AMFEvent> list = findByEventType(
			eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event
	 * @throws NoSuchEventException if a matching amf event could not be found
	 */
	@Override
	public AMFEvent findByEventType_Last(
			String eventType, OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByEventType_Last(eventType, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last amf event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByEventType_Last(
		String eventType, OrderByComparator<AMFEvent> orderByComparator) {

		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<AMFEvent> list = findByEventType(
			eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEvent[] findByEventType_PrevAndNext(
			long auditEventId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		eventType = Objects.toString(eventType, "");

		AMFEvent amfEvent = findByPrimaryKey(auditEventId);

		Session session = null;

		try {
			session = openSession();

			AMFEvent[] array = new AMFEventImpl[3];

			array[0] = getByEventType_PrevAndNext(
				session, amfEvent, eventType, orderByComparator, true);

			array[1] = amfEvent;

			array[2] = getByEventType_PrevAndNext(
				session, amfEvent, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEvent getByEventType_PrevAndNext(
		Session session, AMFEvent amfEvent, String eventType,
		OrderByComparator<AMFEvent> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFEVENT_WHERE);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amfEvent)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AMFEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void removeByEventType(String eventType) {
		for (AMFEvent amfEvent :
				findByEventType(
					eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching amf events
	 */
	@Override
	public int countByEventType(String eventType) {
		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = _finderPathCountByEventType;

		Object[] finderArgs = new Object[] {eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFEVENT_WHERE);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 =
		"amfEvent.eventType = ?";

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 =
		"(amfEvent.eventType IS NULL OR amfEvent.eventType = '')";

	private FinderPath _finderPathWithPaginationFindByUserIdAndEventType;
	private FinderPath _finderPathWithoutPaginationFindByUserIdAndEventType;
	private FinderPath _finderPathCountByUserIdAndEventType;

	/**
	 * Returns all the amf events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching amf events
	 */
	@Override
	public List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType) {

		return findByUserIdAndEventType(
			userId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end) {

		return findByUserIdAndEventType(userId, eventType, start, end, null);
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
	@Override
	public List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator, boolean useFinderCache) {

		return findByUserIdAndEventType(
			userId, eventType, start, end, orderByComparator);
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
	@Override
	public List<AMFEvent> findByUserIdAndEventType(
		long userId, String eventType, int start, int end,
		OrderByComparator<AMFEvent> orderByComparator) {

		eventType = Objects.toString(eventType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserIdAndEventType;
			finderArgs = new Object[] {userId, eventType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserIdAndEventType;
			finderArgs = new Object[] {
				userId, eventType, start, end, orderByComparator
			};
		}

		List<AMFEvent> list = (List<AMFEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AMFEvent amfEvent : list) {
				if ((userId != amfEvent.getUserId()) ||
					!eventType.equals(amfEvent.getEventType())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_AMFEVENT_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_USERID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AMFEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AMFEvent findByUserIdAndEventType_First(
			long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByUserIdAndEventType_First(
			userId, eventType, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByUserIdAndEventType_First(
		long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator) {

		List<AMFEvent> list = findByUserIdAndEventType(
			userId, eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEvent findByUserIdAndEventType_Last(
			long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByUserIdAndEventType_Last(
			userId, eventType, orderByComparator);

		if (amfEvent != null) {
			return amfEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append("}");

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last amf event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event, or <code>null</code> if a matching amf event could not be found
	 */
	@Override
	public AMFEvent fetchByUserIdAndEventType_Last(
		long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator) {

		int count = countByUserIdAndEventType(userId, eventType);

		if (count == 0) {
			return null;
		}

		List<AMFEvent> list = findByUserIdAndEventType(
			userId, eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEvent[] findByUserIdAndEventType_PrevAndNext(
			long auditEventId, long userId, String eventType,
			OrderByComparator<AMFEvent> orderByComparator)
		throws NoSuchEventException {

		eventType = Objects.toString(eventType, "");

		AMFEvent amfEvent = findByPrimaryKey(auditEventId);

		Session session = null;

		try {
			session = openSession();

			AMFEvent[] array = new AMFEventImpl[3];

			array[0] = getByUserIdAndEventType_PrevAndNext(
				session, amfEvent, userId, eventType, orderByComparator, true);

			array[1] = amfEvent;

			array[2] = getByUserIdAndEventType_PrevAndNext(
				session, amfEvent, userId, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEvent getByUserIdAndEventType_PrevAndNext(
		Session session, AMFEvent amfEvent, long userId, String eventType,
		OrderByComparator<AMFEvent> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AMFEVENT_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_USERID_2);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amfEvent)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AMFEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	@Override
	public void removeByUserIdAndEventType(long userId, String eventType) {
		for (AMFEvent amfEvent :
				findByUserIdAndEventType(
					userId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching amf events
	 */
	@Override
	public int countByUserIdAndEventType(long userId, String eventType) {
		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = _finderPathCountByUserIdAndEventType;

		Object[] finderArgs = new Object[] {userId, eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AMFEVENT_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_USERID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindEventType) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDANDEVENTTYPE_USERID_2 =
		"amfEvent.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_2 =
		"amfEvent.eventType = ?";

	private static final String _FINDER_COLUMN_USERIDANDEVENTTYPE_EVENTTYPE_3 =
		"(amfEvent.eventType IS NULL OR amfEvent.eventType = '')";

	public AMFEventPersistenceImpl() {
		setModelClass(AMFEvent.class);

		setModelImplClass(AMFEventImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the amf event in the entity cache if it is enabled.
	 *
	 * @param amfEvent the amf event
	 */
	@Override
	public void cacheResult(AMFEvent amfEvent) {
		entityCache.putResult(
			entityCacheEnabled, AMFEventImpl.class, amfEvent.getPrimaryKey(),
			amfEvent);

		amfEvent.resetOriginalValues();
	}

	/**
	 * Caches the amf events in the entity cache if it is enabled.
	 *
	 * @param amfEvents the amf events
	 */
	@Override
	public void cacheResult(List<AMFEvent> amfEvents) {
		for (AMFEvent amfEvent : amfEvents) {
			if (entityCache.getResult(
					entityCacheEnabled, AMFEventImpl.class,
					amfEvent.getPrimaryKey()) == null) {

				cacheResult(amfEvent);
			}
			else {
				amfEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amf events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMFEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFEvent amfEvent) {
		entityCache.removeResult(
			entityCacheEnabled, AMFEventImpl.class, amfEvent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMFEvent> amfEvents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMFEvent amfEvent : amfEvents) {
			entityCache.removeResult(
				entityCacheEnabled, AMFEventImpl.class,
				amfEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amf event with the primary key. Does not add the amf event to the database.
	 *
	 * @param auditEventId the primary key for the new amf event
	 * @return the new amf event
	 */
	@Override
	public AMFEvent create(long auditEventId) {
		AMFEvent amfEvent = new AMFEventImpl();

		amfEvent.setNew(true);
		amfEvent.setPrimaryKey(auditEventId);

		String uuid = PortalUUIDUtil.generate();

		amfEvent.setUuid(uuid);

		return amfEvent;
	}

	/**
	 * Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent remove(long auditEventId) throws NoSuchEventException {
		return remove((Serializable)auditEventId);
	}

	/**
	 * Removes the amf event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf event
	 * @return the amf event that was removed
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent remove(Serializable primaryKey)
		throws NoSuchEventException {

		Session session = null;

		try {
			session = openSession();

			AMFEvent amfEvent = (AMFEvent)session.get(
				AMFEventImpl.class, primaryKey);

			if (amfEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amfEvent);
		}
		catch (NoSuchEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AMFEvent removeImpl(AMFEvent amfEvent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfEvent)) {
				amfEvent = (AMFEvent)session.get(
					AMFEventImpl.class, amfEvent.getPrimaryKeyObj());
			}

			if (amfEvent != null) {
				session.delete(amfEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amfEvent != null) {
			clearCache(amfEvent);
		}

		return amfEvent;
	}

	@Override
	public AMFEvent updateImpl(AMFEvent amfEvent) {
		boolean isNew = amfEvent.isNew();

		if (!(amfEvent instanceof AMFEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amfEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(amfEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amfEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMFEvent implementation " +
					amfEvent.getClass());
		}

		AMFEventModelImpl amfEventModelImpl = (AMFEventModelImpl)amfEvent;

		if (Validator.isNull(amfEvent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			amfEvent.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (amfEvent.isNew()) {
				session.save(amfEvent);

				amfEvent.setNew(false);
			}
			else {
				amfEvent = (AMFEvent)session.merge(amfEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {amfEventModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {amfEventModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {amfEventModelImpl.getEventType()};

			finderCache.removeResult(_finderPathCountByEventType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEventType, args);

			args = new Object[] {
				amfEventModelImpl.getUserId(), amfEventModelImpl.getEventType()
			};

			finderCache.removeResult(
				_finderPathCountByUserIdAndEventType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserIdAndEventType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((amfEventModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					amfEventModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {amfEventModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((amfEventModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					amfEventModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {amfEventModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((amfEventModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEventType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					amfEventModelImpl.getOriginalEventType()
				};

				finderCache.removeResult(_finderPathCountByEventType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEventType, args);

				args = new Object[] {amfEventModelImpl.getEventType()};

				finderCache.removeResult(_finderPathCountByEventType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEventType, args);
			}

			if ((amfEventModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserIdAndEventType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					amfEventModelImpl.getOriginalUserId(),
					amfEventModelImpl.getOriginalEventType()
				};

				finderCache.removeResult(
					_finderPathCountByUserIdAndEventType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserIdAndEventType, args);

				args = new Object[] {
					amfEventModelImpl.getUserId(),
					amfEventModelImpl.getEventType()
				};

				finderCache.removeResult(
					_finderPathCountByUserIdAndEventType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserIdAndEventType, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AMFEventImpl.class, amfEvent.getPrimaryKey(),
			amfEvent, false);

		amfEvent.resetOriginalValues();

		return amfEvent;
	}

	/**
	 * Returns the amf event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf event
	 * @return the amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventException {

		AMFEvent amfEvent = fetchByPrimaryKey(primaryKey);

		if (amfEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amfEvent;
	}

	/**
	 * Returns the amf event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event
	 * @throws NoSuchEventException if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent findByPrimaryKey(long auditEventId)
		throws NoSuchEventException {

		return findByPrimaryKey((Serializable)auditEventId);
	}

	/**
	 * Returns the amf event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEventId the primary key of the amf event
	 * @return the amf event, or <code>null</code> if a amf event with the primary key could not be found
	 */
	@Override
	public AMFEvent fetchByPrimaryKey(long auditEventId) {
		return fetchByPrimaryKey((Serializable)auditEventId);
	}

	/**
	 * Returns all the amf events.
	 *
	 * @return the amf events
	 */
	@Override
	public List<AMFEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEvent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AMFEvent> findAll(
		int start, int end, OrderByComparator<AMFEvent> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<AMFEvent> findAll(
		int start, int end, OrderByComparator<AMFEvent> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AMFEvent> list = (List<AMFEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMFEVENT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFEVENT;

				if (pagination) {
					sql = sql.concat(AMFEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMFEvent amfEvent : findAll()) {
			remove(amfEvent);
		}
	}

	/**
	 * Returns the number of amf events.
	 *
	 * @return the number of amf events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFEVENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "auditEventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMFEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMFEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf event persistence.
	 */
	@Activate
	public void activate() {
		AMFEventModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AMFEventModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			AMFEventModelImpl.UUID_COLUMN_BITMASK |
			AMFEventModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			AMFEventModelImpl.USERID_COLUMN_BITMASK |
			AMFEventModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] {String.class.getName()},
			AMFEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			AMFEventModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUserIdAndEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndEventType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserIdAndEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndEventType",
			new String[] {Long.class.getName(), String.class.getName()},
			AMFEventModelImpl.USERID_COLUMN_BITMASK |
			AMFEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			AMFEventModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUserIdAndEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndEventType",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMFEventImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = AMFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.amf.event.monitor.s.model.AMFEvent"),
			true);
	}

	@Override
	@Reference(
		target = AMFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AMFEVENT =
		"SELECT amfEvent FROM AMFEvent amfEvent";

	private static final String _SQL_SELECT_AMFEVENT_WHERE =
		"SELECT amfEvent FROM AMFEvent amfEvent WHERE ";

	private static final String _SQL_COUNT_AMFEVENT =
		"SELECT COUNT(amfEvent) FROM AMFEvent amfEvent";

	private static final String _SQL_COUNT_AMFEVENT_WHERE =
		"SELECT COUNT(amfEvent) FROM AMFEvent amfEvent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amfEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMFEvent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AMFEvent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AMFEventPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(AMFPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}