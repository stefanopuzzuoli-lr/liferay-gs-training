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

package com.liferay.docs.amf.registration.service.persistence.impl;

import com.liferay.docs.amf.registration.exception.NoSuchAMFUserException;
import com.liferay.docs.amf.registration.model.AMFUser;
import com.liferay.docs.amf.registration.model.impl.AMFUserImpl;
import com.liferay.docs.amf.registration.model.impl.AMFUserModelImpl;
import com.liferay.docs.amf.registration.service.persistence.AMFUserPersistence;
import com.liferay.docs.amf.registration.service.persistence.impl.constants.AMFURPersistenceConstants;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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
import java.util.Date;
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
 * The persistence implementation for the amf user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @generated
 */
@Component(service = AMFUserPersistence.class)
@ProviderType
public class AMFUserPersistenceImpl
	extends BasePersistenceImpl<AMFUser> implements AMFUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMFUserUtil</code> to access the amf user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMFUserImpl.class.getName();

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
	 * Returns all the amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf users
	 */
	@Override
	public List<AMFUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of matching amf users
	 */
	@Override
	public List<AMFUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf users
	 */
	@Deprecated
	@Override
	public List<AMFUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf users
	 */
	@Override
	public List<AMFUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

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

		List<AMFUser> list = (List<AMFUser>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AMFUser amfUser : list) {
				if (!uuid.equals(amfUser.getUuid())) {
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

			query.append(_SQL_SELECT_AMFUSER_WHERE);

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
				query.append(AMFUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<AMFUser>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFUser>)QueryUtil.list(
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
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	@Override
	public AMFUser findByUuid_First(
			String uuid, OrderByComparator<AMFUser> orderByComparator)
		throws NoSuchAMFUserException {

		AMFUser amfUser = fetchByUuid_First(uuid, orderByComparator);

		if (amfUser != null) {
			return amfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAMFUserException(msg.toString());
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	@Override
	public AMFUser fetchByUuid_First(
		String uuid, OrderByComparator<AMFUser> orderByComparator) {

		List<AMFUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	@Override
	public AMFUser findByUuid_Last(
			String uuid, OrderByComparator<AMFUser> orderByComparator)
		throws NoSuchAMFUserException {

		AMFUser amfUser = fetchByUuid_Last(uuid, orderByComparator);

		if (amfUser != null) {
			return amfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAMFUserException(msg.toString());
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	@Override
	public AMFUser fetchByUuid_Last(
		String uuid, OrderByComparator<AMFUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AMFUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where uuid = &#63;.
	 *
	 * @param userId the primary key of the current amf user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser[] findByUuid_PrevAndNext(
			long userId, String uuid,
			OrderByComparator<AMFUser> orderByComparator)
		throws NoSuchAMFUserException {

		uuid = Objects.toString(uuid, "");

		AMFUser amfUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			AMFUser[] array = new AMFUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, amfUser, uuid, orderByComparator, true);

			array[1] = amfUser;

			array[2] = getByUuid_PrevAndNext(
				session, amfUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFUser getByUuid_PrevAndNext(
		Session session, AMFUser amfUser, String uuid,
		OrderByComparator<AMFUser> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFUSER_WHERE);

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
			query.append(AMFUserModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(amfUser)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AMFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AMFUser amfUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfUser);
		}
	}

	/**
	 * Returns the number of amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "amfUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(amfUser.uuid IS NULL OR amfUser.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByZip;
	private FinderPath _finderPathWithoutPaginationFindByZip;
	private FinderPath _finderPathCountByZip;

	/**
	 * Returns all the amf users where zip = &#63;.
	 *
	 * @param zip the zip
	 * @return the matching amf users
	 */
	@Override
	public List<AMFUser> findByZip(String zip) {
		return findByZip(zip, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf users where zip = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zip the zip
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of matching amf users
	 */
	@Override
	public List<AMFUser> findByZip(String zip, int start, int end) {
		return findByZip(zip, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf users where zip = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByZip(String, int, int, OrderByComparator)}
	 * @param zip the zip
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf users
	 */
	@Deprecated
	@Override
	public List<AMFUser> findByZip(
		String zip, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return findByZip(zip, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users where zip = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zip the zip
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf users
	 */
	@Override
	public List<AMFUser> findByZip(
		String zip, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		zip = Objects.toString(zip, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByZip;
			finderArgs = new Object[] {zip};
		}
		else {
			finderPath = _finderPathWithPaginationFindByZip;
			finderArgs = new Object[] {zip, start, end, orderByComparator};
		}

		List<AMFUser> list = (List<AMFUser>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AMFUser amfUser : list) {
				if (!zip.equals(amfUser.getZip())) {
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

			query.append(_SQL_SELECT_AMFUSER_WHERE);

			boolean bindZip = false;

			if (zip.isEmpty()) {
				query.append(_FINDER_COLUMN_ZIP_ZIP_3);
			}
			else {
				bindZip = true;

				query.append(_FINDER_COLUMN_ZIP_ZIP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AMFUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindZip) {
					qPos.add(zip);
				}

				if (!pagination) {
					list = (List<AMFUser>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFUser>)QueryUtil.list(
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
	 * Returns the first amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	@Override
	public AMFUser findByZip_First(
			String zip, OrderByComparator<AMFUser> orderByComparator)
		throws NoSuchAMFUserException {

		AMFUser amfUser = fetchByZip_First(zip, orderByComparator);

		if (amfUser != null) {
			return amfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zip=");
		msg.append(zip);

		msg.append("}");

		throw new NoSuchAMFUserException(msg.toString());
	}

	/**
	 * Returns the first amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	@Override
	public AMFUser fetchByZip_First(
		String zip, OrderByComparator<AMFUser> orderByComparator) {

		List<AMFUser> list = findByZip(zip, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	@Override
	public AMFUser findByZip_Last(
			String zip, OrderByComparator<AMFUser> orderByComparator)
		throws NoSuchAMFUserException {

		AMFUser amfUser = fetchByZip_Last(zip, orderByComparator);

		if (amfUser != null) {
			return amfUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zip=");
		msg.append(zip);

		msg.append("}");

		throw new NoSuchAMFUserException(msg.toString());
	}

	/**
	 * Returns the last amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	@Override
	public AMFUser fetchByZip_Last(
		String zip, OrderByComparator<AMFUser> orderByComparator) {

		int count = countByZip(zip);

		if (count == 0) {
			return null;
		}

		List<AMFUser> list = findByZip(
			zip, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where zip = &#63;.
	 *
	 * @param userId the primary key of the current amf user
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser[] findByZip_PrevAndNext(
			long userId, String zip,
			OrderByComparator<AMFUser> orderByComparator)
		throws NoSuchAMFUserException {

		zip = Objects.toString(zip, "");

		AMFUser amfUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			AMFUser[] array = new AMFUserImpl[3];

			array[0] = getByZip_PrevAndNext(
				session, amfUser, zip, orderByComparator, true);

			array[1] = amfUser;

			array[2] = getByZip_PrevAndNext(
				session, amfUser, zip, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFUser getByZip_PrevAndNext(
		Session session, AMFUser amfUser, String zip,
		OrderByComparator<AMFUser> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFUSER_WHERE);

		boolean bindZip = false;

		if (zip.isEmpty()) {
			query.append(_FINDER_COLUMN_ZIP_ZIP_3);
		}
		else {
			bindZip = true;

			query.append(_FINDER_COLUMN_ZIP_ZIP_2);
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
			query.append(AMFUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindZip) {
			qPos.add(zip);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amfUser)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AMFUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf users where zip = &#63; from the database.
	 *
	 * @param zip the zip
	 */
	@Override
	public void removeByZip(String zip) {
		for (AMFUser amfUser :
				findByZip(zip, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfUser);
		}
	}

	/**
	 * Returns the number of amf users where zip = &#63;.
	 *
	 * @param zip the zip
	 * @return the number of matching amf users
	 */
	@Override
	public int countByZip(String zip) {
		zip = Objects.toString(zip, "");

		FinderPath finderPath = _finderPathCountByZip;

		Object[] finderArgs = new Object[] {zip};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFUSER_WHERE);

			boolean bindZip = false;

			if (zip.isEmpty()) {
				query.append(_FINDER_COLUMN_ZIP_ZIP_3);
			}
			else {
				bindZip = true;

				query.append(_FINDER_COLUMN_ZIP_ZIP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindZip) {
					qPos.add(zip);
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

	private static final String _FINDER_COLUMN_ZIP_ZIP_2 = "amfUser.zip = ?";

	private static final String _FINDER_COLUMN_ZIP_ZIP_3 =
		"(amfUser.zip IS NULL OR amfUser.zip = '')";

	public AMFUserPersistenceImpl() {
		setModelClass(AMFUser.class);

		setModelImplClass(AMFUserImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the amf user in the entity cache if it is enabled.
	 *
	 * @param amfUser the amf user
	 */
	@Override
	public void cacheResult(AMFUser amfUser) {
		entityCache.putResult(
			entityCacheEnabled, AMFUserImpl.class, amfUser.getPrimaryKey(),
			amfUser);

		amfUser.resetOriginalValues();
	}

	/**
	 * Caches the amf users in the entity cache if it is enabled.
	 *
	 * @param amfUsers the amf users
	 */
	@Override
	public void cacheResult(List<AMFUser> amfUsers) {
		for (AMFUser amfUser : amfUsers) {
			if (entityCache.getResult(
					entityCacheEnabled, AMFUserImpl.class,
					amfUser.getPrimaryKey()) == null) {

				cacheResult(amfUser);
			}
			else {
				amfUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amf users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMFUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFUser amfUser) {
		entityCache.removeResult(
			entityCacheEnabled, AMFUserImpl.class, amfUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMFUser> amfUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMFUser amfUser : amfUsers) {
			entityCache.removeResult(
				entityCacheEnabled, AMFUserImpl.class, amfUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param userId the primary key for the new amf user
	 * @return the new amf user
	 */
	@Override
	public AMFUser create(long userId) {
		AMFUser amfUser = new AMFUserImpl();

		amfUser.setNew(true);
		amfUser.setPrimaryKey(userId);

		String uuid = PortalUUIDUtil.generate();

		amfUser.setUuid(uuid);

		return amfUser;
	}

	/**
	 * Removes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser remove(long userId) throws NoSuchAMFUserException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser remove(Serializable primaryKey)
		throws NoSuchAMFUserException {

		Session session = null;

		try {
			session = openSession();

			AMFUser amfUser = (AMFUser)session.get(
				AMFUserImpl.class, primaryKey);

			if (amfUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMFUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amfUser);
		}
		catch (NoSuchAMFUserException nsee) {
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
	protected AMFUser removeImpl(AMFUser amfUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfUser)) {
				amfUser = (AMFUser)session.get(
					AMFUserImpl.class, amfUser.getPrimaryKeyObj());
			}

			if (amfUser != null) {
				session.delete(amfUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amfUser != null) {
			clearCache(amfUser);
		}

		return amfUser;
	}

	@Override
	public AMFUser updateImpl(AMFUser amfUser) {
		boolean isNew = amfUser.isNew();

		if (!(amfUser instanceof AMFUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amfUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(amfUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amfUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMFUser implementation " +
					amfUser.getClass());
		}

		AMFUserModelImpl amfUserModelImpl = (AMFUserModelImpl)amfUser;

		if (Validator.isNull(amfUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			amfUser.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amfUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				amfUser.setCreateDate(now);
			}
			else {
				amfUser.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!amfUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amfUser.setModifiedDate(now);
			}
			else {
				amfUser.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (amfUser.isNew()) {
				session.save(amfUser);

				amfUser.setNew(false);
			}
			else {
				amfUser = (AMFUser)session.merge(amfUser);
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
			Object[] args = new Object[] {amfUserModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {amfUserModelImpl.getZip()};

			finderCache.removeResult(_finderPathCountByZip, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByZip, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((amfUserModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					amfUserModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {amfUserModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((amfUserModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByZip.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					amfUserModelImpl.getOriginalZip()
				};

				finderCache.removeResult(_finderPathCountByZip, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByZip, args);

				args = new Object[] {amfUserModelImpl.getZip()};

				finderCache.removeResult(_finderPathCountByZip, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByZip, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, AMFUserImpl.class, amfUser.getPrimaryKey(),
			amfUser, false);

		amfUser.resetOriginalValues();

		return amfUser;
	}

	/**
	 * Returns the amf user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf user
	 * @return the amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAMFUserException {

		AMFUser amfUser = fetchByPrimaryKey(primaryKey);

		if (amfUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAMFUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amfUser;
	}

	/**
	 * Returns the amf user with the primary key or throws a <code>NoSuchAMFUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser findByPrimaryKey(long userId) throws NoSuchAMFUserException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the amf user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user, or <code>null</code> if a amf user with the primary key could not be found
	 */
	@Override
	public AMFUser fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the amf users.
	 *
	 * @return the amf users
	 */
	@Override
	public List<AMFUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of amf users
	 */
	@Override
	public List<AMFUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf users
	 */
	@Deprecated
	@Override
	public List<AMFUser> findAll(
		int start, int end, OrderByComparator<AMFUser> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf users
	 */
	@Override
	public List<AMFUser> findAll(
		int start, int end, OrderByComparator<AMFUser> orderByComparator) {

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

		List<AMFUser> list = (List<AMFUser>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMFUSER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFUSER;

				if (pagination) {
					sql = sql.concat(AMFUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AMFUser>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFUser>)QueryUtil.list(
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
	 * Removes all the amf users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMFUser amfUser : findAll()) {
			remove(amfUser);
		}
	}

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFUSER);

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
		return "userId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMFUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMFUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf user persistence.
	 */
	@Activate
	public void activate() {
		AMFUserModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AMFUserModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			AMFUserModelImpl.UUID_COLUMN_BITMASK |
			AMFUserModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByZip = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByZip",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByZip = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByZip",
			new String[] {String.class.getName()},
			AMFUserModelImpl.ZIP_COLUMN_BITMASK |
			AMFUserModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByZip = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByZip",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMFUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = AMFURPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.docs.amf.registration.model.AMFUser"),
			true);
	}

	@Override
	@Reference(
		target = AMFURPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMFURPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_AMFUSER =
		"SELECT amfUser FROM AMFUser amfUser";

	private static final String _SQL_SELECT_AMFUSER_WHERE =
		"SELECT amfUser FROM AMFUser amfUser WHERE ";

	private static final String _SQL_COUNT_AMFUSER =
		"SELECT COUNT(amfUser) FROM AMFUser amfUser";

	private static final String _SQL_COUNT_AMFUSER_WHERE =
		"SELECT COUNT(amfUser) FROM AMFUser amfUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amfUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMFUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AMFUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AMFUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "state"});

	static {
		try {
			Class.forName(AMFURPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}