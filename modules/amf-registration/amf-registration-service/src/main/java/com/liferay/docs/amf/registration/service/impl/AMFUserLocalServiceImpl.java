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

package com.liferay.docs.amf.registration.service.impl;

import com.liferay.docs.amf.registration.model.AMFUser;
import com.liferay.docs.amf.registration.service.base.AMFUserLocalServiceBaseImpl;
import com.liferay.docs.amf.registration.validator.AMFUserValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the amf user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.docs.amf.registration.service.AMFUserLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see AMFUserLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.docs.amf.registration.model.AMFUser", service = AopService.class)
public class AMFUserLocalServiceImpl extends AMFUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.liferay.docs.amf.registration.service.AMFUserLocalService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.liferay.docs.amf.registration.service.AMFUserLocalServiceUtil</code
	 * >.
	 */
	public AMFUser addAMFUser(String username, String firstName, String lastName, String email, Boolean male, Date dob,
			String homePhone, String mobilePhone, String address, String address2, String city, String state,
			String zip, String securityQuestion, String securityAnswer, Boolean accepted_tou, String password1,
			String password2, ServiceContext serviceContext) throws PortalException {

		_amfUserValidator.validate(username, firstName, lastName, email, male, dob, homePhone, mobilePhone, address,
				address2, city, state, zip, securityQuestion, securityAnswer, accepted_tou, password1, password2);

		// add user to deafult user_ table
		long companyId = PortalUtil.getDefaultCompanyId();
		LocalDate localDob = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		User user = UserLocalServiceUtil.addUser(0, companyId, false, password1, password2, false, username, email, 0,
				"", Locale.getDefault(), firstName, "", lastName, 1, 1, male, localDob.getMonthValue(),
				localDob.getDayOfMonth(), localDob.getYear(), "", null, null, null, null, false, serviceContext);
		long userId = user.getUserId();
		UserLocalServiceUtil.updateReminderQuery(userId, securityQuestion, securityAnswer);
		UserLocalServiceUtil.updateAgreedToTermsOfUse(userId, accepted_tou);
		UserLocalServiceUtil.updatePasswordReset(userId, false);

		// add extra information to amfur_amfuser table
		AMFUser entry = amfUserPersistence.create(userId);
		entry.setUuid(serviceContext.getUuid());
		Date now = new Date();
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setMale(male);
		entry.setDob(dob);
		entry.setHomePhone(homePhone);
		entry.setMobilePhone(mobilePhone);
		entry.setAddress(address);
		entry.setAddress2(address2);
		entry.setCity(city);
		entry.setState(state);
		entry.setZip(zip);

		amfUserPersistence.update(entry);

		return entry;
	}

	public AMFUser updateAMFUser(long userId, String username, String firstName, String lastName, String email,
			Boolean male, Date dob, String homePhone, String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion, String securityAnswer, Boolean accepted_tou,
			String password1, String password2, ServiceContext serviceContext) throws PortalException, SystemException {

		_amfUserValidator.validate(username, firstName, lastName, email, male, dob, homePhone, mobilePhone, address,
				address2, city, state, zip, securityQuestion, securityAnswer, accepted_tou, password1, password2);

		Date now = new Date();

		AMFUser entry = amfUserPersistence.findByPrimaryKey(userId);

		UserLocalServiceUtil.updateReminderQuery(userId, securityQuestion, securityAnswer);
		UserLocalServiceUtil.updateAgreedToTermsOfUse(userId, accepted_tou);
		UserLocalServiceUtil.updatePasswordReset(userId, false);
		
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setMale(male);
		entry.setDob(dob);
		entry.setHomePhone(homePhone);
		entry.setMobilePhone(mobilePhone);
		entry.setAddress(address);
		entry.setAddress2(address2);
		entry.setCity(city);
		entry.setState(state);
		entry.setZip(zip);
		entry.setExpandoBridgeAttributes(serviceContext);

		amfUserPersistence.update(entry);

		return entry;
	}

	public AMFUser deleteAMFUser(AMFUser entry) {

		try {
			UserLocalServiceUtil.deleteUser(entry.getUserId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		amfUserPersistence.remove(entry);

		return entry;
	}

	public AMFUser deleteAMFUser(String username) throws PortalException {

		AMFUser entry = amfUserPersistence.findByPrimaryKey(username);

		return deleteAMFUser(entry);
	}

	public AMFUser getAMFUser(long userId) throws PortalException {
		return amfUserPersistence.findByPrimaryKey(userId);
	}
	
	public List<AMFUser> getAMFUserByZip(String zip) {
		return amfUserPersistence.findByZip(zip);
	}

	@Reference
	AMFUserValidator _amfUserValidator;

}