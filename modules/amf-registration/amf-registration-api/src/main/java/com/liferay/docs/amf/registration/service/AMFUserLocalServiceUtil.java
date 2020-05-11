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

package com.liferay.docs.amf.registration.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AMFUser. This utility wraps
 * <code>com.liferay.docs.amf.registration.service.impl.AMFUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author liferay
 * @see AMFUserLocalService
 * @generated
 */
@ProviderType
public class AMFUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.amf.registration.service.impl.AMFUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the amf user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was added
	 */
	public static com.liferay.docs.amf.registration.model.AMFUser addAMFUser(
		com.liferay.docs.amf.registration.model.AMFUser amfUser) {

		return getService().addAMFUser(amfUser);
	}

	public static com.liferay.docs.amf.registration.model.AMFUser addAMFUser(
			String username, String firstName, String lastName, String email,
			Boolean male, java.util.Date dob, String homePhone,
			String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion,
			String securityAnswer, Boolean accepted_tou, String password1,
			String password2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAMFUser(
			username, firstName, lastName, email, male, dob, homePhone,
			mobilePhone, address, address2, city, state, zip, securityQuestion,
			securityAnswer, accepted_tou, password1, password2, serviceContext);
	}

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param userId the primary key for the new amf user
	 * @return the new amf user
	 */
	public static com.liferay.docs.amf.registration.model.AMFUser createAMFUser(
		long userId) {

		return getService().createAMFUser(userId);
	}

	/**
	 * Deletes the amf user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was removed
	 */
	public static com.liferay.docs.amf.registration.model.AMFUser deleteAMFUser(
		com.liferay.docs.amf.registration.model.AMFUser amfUser) {

		return getService().deleteAMFUser(amfUser);
	}

	/**
	 * Deletes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	public static com.liferay.docs.amf.registration.model.AMFUser deleteAMFUser(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMFUser(userId);
	}

	public static com.liferay.docs.amf.registration.model.AMFUser deleteAMFUser(
			String username)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMFUser(username);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.docs.amf.registration.model.impl.AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.docs.amf.registration.model.impl.AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.docs.amf.registration.model.AMFUser fetchAMFUser(
		long userId) {

		return getService().fetchAMFUser(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the amf user with the primary key.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	public static com.liferay.docs.amf.registration.model.AMFUser getAMFUser(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFUser(userId);
	}

	public static java.util.List
		<com.liferay.docs.amf.registration.model.AMFUser> getAMFUserByZip(
			String zip) {

		return getService().getAMFUserByZip(zip);
	}

	/**
	 * Returns a range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.docs.amf.registration.model.impl.AMFUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of amf users
	 */
	public static java.util.List
		<com.liferay.docs.amf.registration.model.AMFUser> getAMFUsers(
			int start, int end) {

		return getService().getAMFUsers(start, end);
	}

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	public static int getAMFUsersCount() {
		return getService().getAMFUsersCount();
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
	 * Updates the amf user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was updated
	 */
	public static com.liferay.docs.amf.registration.model.AMFUser updateAMFUser(
		com.liferay.docs.amf.registration.model.AMFUser amfUser) {

		return getService().updateAMFUser(amfUser);
	}

	public static com.liferay.docs.amf.registration.model.AMFUser updateAMFUser(
			long userId, String username, String firstName, String lastName,
			String email, Boolean male, java.util.Date dob, String homePhone,
			String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion,
			String securityAnswer, Boolean accepted_tou, String password1,
			String password2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateAMFUser(
			userId, username, firstName, lastName, email, male, dob, homePhone,
			mobilePhone, address, address2, city, state, zip, securityQuestion,
			securityAnswer, accepted_tou, password1, password2, serviceContext);
	}

	public static AMFUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFUserLocalService, AMFUserLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFUserLocalService.class);

		ServiceTracker<AMFUserLocalService, AMFUserLocalService>
			serviceTracker =
				new ServiceTracker<AMFUserLocalService, AMFUserLocalService>(
					bundle.getBundleContext(), AMFUserLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}