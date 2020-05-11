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

package com.liferay.docs.amf.registration.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link AMFUser}.
 * </p>
 *
 * @author liferay
 * @see AMFUser
 * @generated
 */
@ProviderType
public class AMFUserWrapper
	extends BaseModelWrapper<AMFUser>
	implements AMFUser, ModelWrapper<AMFUser> {

	public AMFUserWrapper(AMFUser amfUser) {
		super(amfUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("male", getMale());
		attributes.put("dob", getDob());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("address", getAddress());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zip", getZip());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the address of this amf user.
	 *
	 * @return the address of this amf user
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this amf user.
	 *
	 * @return the address2 of this amf user
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the city of this amf user.
	 *
	 * @return the city of this amf user
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the create date of this amf user.
	 *
	 * @return the create date of this amf user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dob of this amf user.
	 *
	 * @return the dob of this amf user
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the home phone of this amf user.
	 *
	 * @return the home phone of this amf user
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	/**
	 * Returns the male of this amf user.
	 *
	 * @return the male of this amf user
	 */
	@Override
	public Boolean getMale() {
		return model.getMale();
	}

	/**
	 * Returns the mobile phone of this amf user.
	 *
	 * @return the mobile phone of this amf user
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this amf user.
	 *
	 * @return the modified date of this amf user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this amf user.
	 *
	 * @return the mvcc version of this amf user
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this amf user.
	 *
	 * @return the primary key of this amf user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this amf user.
	 *
	 * @return the state of this amf user
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this amf user.
	 *
	 * @return the user ID of this amf user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this amf user.
	 *
	 * @return the user uuid of this amf user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this amf user.
	 *
	 * @return the uuid of this amf user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the zip of this amf user.
	 *
	 * @return the zip of this amf user
	 */
	@Override
	public String getZip() {
		return model.getZip();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this amf user.
	 *
	 * @param address the address of this amf user
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address2 of this amf user.
	 *
	 * @param address2 the address2 of this amf user
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the city of this amf user.
	 *
	 * @param city the city of this amf user
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the create date of this amf user.
	 *
	 * @param createDate the create date of this amf user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dob of this amf user.
	 *
	 * @param dob the dob of this amf user
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the home phone of this amf user.
	 *
	 * @param homePhone the home phone of this amf user
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets the male of this amf user.
	 *
	 * @param male the male of this amf user
	 */
	@Override
	public void setMale(Boolean male) {
		model.setMale(male);
	}

	/**
	 * Sets the mobile phone of this amf user.
	 *
	 * @param mobilePhone the mobile phone of this amf user
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this amf user.
	 *
	 * @param modifiedDate the modified date of this amf user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this amf user.
	 *
	 * @param mvccVersion the mvcc version of this amf user
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this amf user.
	 *
	 * @param primaryKey the primary key of this amf user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this amf user.
	 *
	 * @param state the state of this amf user
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this amf user.
	 *
	 * @param userId the user ID of this amf user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this amf user.
	 *
	 * @param userUuid the user uuid of this amf user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this amf user.
	 *
	 * @param uuid the uuid of this amf user
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the zip of this amf user.
	 *
	 * @param zip the zip of this amf user
	 */
	@Override
	public void setZip(String zip) {
		model.setZip(zip);
	}

	@Override
	protected AMFUserWrapper wrap(AMFUser amfUser) {
		return new AMFUserWrapper(amfUser);
	}

}