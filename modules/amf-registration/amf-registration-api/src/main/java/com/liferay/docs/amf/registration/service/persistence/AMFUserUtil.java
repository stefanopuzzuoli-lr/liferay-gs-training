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

package com.liferay.docs.amf.registration.service.persistence;

import com.liferay.docs.amf.registration.model.AMFUser;
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
 * The persistence utility for the amf user service. This utility wraps <code>com.liferay.docs.amf.registration.service.persistence.impl.AMFUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see AMFUserPersistence
 * @generated
 */
@ProviderType
public class AMFUserUtil {

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
	public static void clearCache(AMFUser amfUser) {
		getPersistence().clearCache(amfUser);
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
	public static Map<Serializable, AMFUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFUser update(AMFUser amfUser) {
		return getPersistence().update(amfUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFUser update(
		AMFUser amfUser, ServiceContext serviceContext) {

		return getPersistence().update(amfUser, serviceContext);
	}

	/**
	 * Returns all the amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf users
	 */
	public static List<AMFUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<AMFUser> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<AMFUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
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
	public static List<AMFUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUuid_First(
			String uuid, OrderByComparator<AMFUser> orderByComparator)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUuid_First(
		String uuid, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUuid_Last(
			String uuid, OrderByComparator<AMFUser> orderByComparator)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUuid_Last(
		String uuid, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static AMFUser[] findByUuid_PrevAndNext(
			long userId, String uuid,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByUuid_PrevAndNext(
			userId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amf users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the amf users where zip = &#63;.
	 *
	 * @param zip the zip
	 * @return the matching amf users
	 */
	public static List<AMFUser> findByZip(String zip) {
		return getPersistence().findByZip(zip);
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
	public static List<AMFUser> findByZip(String zip, int start, int end) {
		return getPersistence().findByZip(zip, start, end);
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
	public static List<AMFUser> findByZip(
		String zip, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByZip(
			zip, start, end, orderByComparator, useFinderCache);
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
	public static List<AMFUser> findByZip(
		String zip, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findByZip(zip, start, end, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByZip_First(
			String zip, OrderByComparator<AMFUser> orderByComparator)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByZip_First(zip, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByZip_First(
		String zip, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByZip_First(zip, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByZip_Last(
			String zip, OrderByComparator<AMFUser> orderByComparator)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByZip_Last(zip, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where zip = &#63;.
	 *
	 * @param zip the zip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByZip_Last(
		String zip, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByZip_Last(zip, orderByComparator);
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
	public static AMFUser[] findByZip_PrevAndNext(
			long userId, String zip,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByZip_PrevAndNext(
			userId, zip, orderByComparator);
	}

	/**
	 * Removes all the amf users where zip = &#63; from the database.
	 *
	 * @param zip the zip
	 */
	public static void removeByZip(String zip) {
		getPersistence().removeByZip(zip);
	}

	/**
	 * Returns the number of amf users where zip = &#63;.
	 *
	 * @param zip the zip
	 * @return the number of matching amf users
	 */
	public static int countByZip(String zip) {
		return getPersistence().countByZip(zip);
	}

	/**
	 * Caches the amf user in the entity cache if it is enabled.
	 *
	 * @param amfUser the amf user
	 */
	public static void cacheResult(AMFUser amfUser) {
		getPersistence().cacheResult(amfUser);
	}

	/**
	 * Caches the amf users in the entity cache if it is enabled.
	 *
	 * @param amfUsers the amf users
	 */
	public static void cacheResult(List<AMFUser> amfUsers) {
		getPersistence().cacheResult(amfUsers);
	}

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param userId the primary key for the new amf user
	 * @return the new amf user
	 */
	public static AMFUser create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	 * Removes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser remove(long userId)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().remove(userId);
	}

	public static AMFUser updateImpl(AMFUser amfUser) {
		return getPersistence().updateImpl(amfUser);
	}

	/**
	 * Returns the amf user with the primary key or throws a <code>NoSuchAMFUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser findByPrimaryKey(long userId)
		throws com.liferay.docs.amf.registration.exception.
			NoSuchAMFUserException {

		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	 * Returns the amf user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user, or <code>null</code> if a amf user with the primary key could not be found
	 */
	public static AMFUser fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	 * Returns all the amf users.
	 *
	 * @return the amf users
	 */
	public static List<AMFUser> findAll() {
		return getPersistence().findAll();
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
	public static List<AMFUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AMFUser> findAll(
		int start, int end, OrderByComparator<AMFUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<AMFUser> findAll(
		int start, int end, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the amf users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AMFUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFUserPersistence, AMFUserPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFUserPersistence.class);

		ServiceTracker<AMFUserPersistence, AMFUserPersistence> serviceTracker =
			new ServiceTracker<AMFUserPersistence, AMFUserPersistence>(
				bundle.getBundleContext(), AMFUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}