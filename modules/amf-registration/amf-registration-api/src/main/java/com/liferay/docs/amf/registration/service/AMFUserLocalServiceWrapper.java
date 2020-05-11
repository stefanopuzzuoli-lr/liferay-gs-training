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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link AMFUserLocalService}.
 *
 * @author liferay
 * @see AMFUserLocalService
 * @generated
 */
@ProviderType
public class AMFUserLocalServiceWrapper
	implements AMFUserLocalService, ServiceWrapper<AMFUserLocalService> {

	public AMFUserLocalServiceWrapper(AMFUserLocalService amfUserLocalService) {
		_amfUserLocalService = amfUserLocalService;
	}

	/**
	 * Adds the amf user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was added
	 */
	@Override
	public com.liferay.docs.amf.registration.model.AMFUser addAMFUser(
		com.liferay.docs.amf.registration.model.AMFUser amfUser) {

		return _amfUserLocalService.addAMFUser(amfUser);
	}

	@Override
	public com.liferay.docs.amf.registration.model.AMFUser addAMFUser(
			String username, String firstName, String lastName, String email,
			Boolean male, java.util.Date dob, String homePhone,
			String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion,
			String securityAnswer, Boolean accepted_tou, String password1,
			String password2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.addAMFUser(
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
	@Override
	public com.liferay.docs.amf.registration.model.AMFUser createAMFUser(
		long userId) {

		return _amfUserLocalService.createAMFUser(userId);
	}

	/**
	 * Deletes the amf user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was removed
	 */
	@Override
	public com.liferay.docs.amf.registration.model.AMFUser deleteAMFUser(
		com.liferay.docs.amf.registration.model.AMFUser amfUser) {

		return _amfUserLocalService.deleteAMFUser(amfUser);
	}

	/**
	 * Deletes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.amf.registration.model.AMFUser deleteAMFUser(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.deleteAMFUser(userId);
	}

	@Override
	public com.liferay.docs.amf.registration.model.AMFUser deleteAMFUser(
			String username)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.deleteAMFUser(username);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfUserLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amfUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _amfUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _amfUserLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amfUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _amfUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.amf.registration.model.AMFUser fetchAMFUser(
		long userId) {

		return _amfUserLocalService.fetchAMFUser(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amfUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amf user with the primary key.
	 *
	 * @param userId the primary key of the amf user
	 * @return the amf user
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.amf.registration.model.AMFUser getAMFUser(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.getAMFUser(userId);
	}

	@Override
	public java.util.List<com.liferay.docs.amf.registration.model.AMFUser>
		getAMFUserByZip(String zip) {

		return _amfUserLocalService.getAMFUserByZip(zip);
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
	@Override
	public java.util.List<com.liferay.docs.amf.registration.model.AMFUser>
		getAMFUsers(int start, int end) {

		return _amfUserLocalService.getAMFUsers(start, end);
	}

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	@Override
	public int getAMFUsersCount() {
		return _amfUserLocalService.getAMFUsersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amfUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfUserLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the amf user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was updated
	 */
	@Override
	public com.liferay.docs.amf.registration.model.AMFUser updateAMFUser(
		com.liferay.docs.amf.registration.model.AMFUser amfUser) {

		return _amfUserLocalService.updateAMFUser(amfUser);
	}

	@Override
	public com.liferay.docs.amf.registration.model.AMFUser updateAMFUser(
			long userId, String username, String firstName, String lastName,
			String email, Boolean male, java.util.Date dob, String homePhone,
			String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion,
			String securityAnswer, Boolean accepted_tou, String password1,
			String password2,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _amfUserLocalService.updateAMFUser(
			userId, username, firstName, lastName, email, male, dob, homePhone,
			mobilePhone, address, address2, city, state, zip, securityQuestion,
			securityAnswer, accepted_tou, password1, password2, serviceContext);
	}

	@Override
	public AMFUserLocalService getWrappedService() {
		return _amfUserLocalService;
	}

	@Override
	public void setWrappedService(AMFUserLocalService amfUserLocalService) {
		_amfUserLocalService = amfUserLocalService;
	}

	private AMFUserLocalService _amfUserLocalService;

}