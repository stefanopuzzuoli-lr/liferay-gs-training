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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.docs.amf.registration.service.http.AMFUserServiceSoap}.
 *
 * @author liferay
 * @generated
 */
@ProviderType
public class AMFUserSoap implements Serializable {

	public static AMFUserSoap toSoapModel(AMFUser model) {
		AMFUserSoap soapModel = new AMFUserSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setUserId(model.getUserId());
		soapModel.setMale(model.getMale());
		soapModel.setDob(model.getDob());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setAddress(model.getAddress());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZip(model.getZip());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AMFUserSoap[] toSoapModels(AMFUser[] models) {
		AMFUserSoap[] soapModels = new AMFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFUserSoap[][] toSoapModels(AMFUser[][] models) {
		AMFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFUserSoap[] toSoapModels(List<AMFUser> models) {
		List<AMFUserSoap> soapModels = new ArrayList<AMFUserSoap>(
			models.size());

		for (AMFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFUserSoap[soapModels.size()]);
	}

	public AMFUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Boolean getMale() {
		return _male;
	}

	public void setMale(Boolean male) {
		_male = male;
	}

	public Date getDob() {
		return _dob;
	}

	public void setDob(Date dob) {
		_dob = dob;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _userId;
	private Boolean _male;
	private Date _dob;
	private String _homePhone;
	private String _mobilePhone;
	private String _address;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private Date _createDate;
	private Date _modifiedDate;

}