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

package com.liferay.docs.amf.registration.model.impl;

import com.liferay.docs.amf.registration.model.AMFUser;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing AMFUser in entity cache.
 *
 * @author liferay
 * @generated
 */
@ProviderType
public class AMFUserCacheModel
	implements CacheModel<AMFUser>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFUserCacheModel)) {
			return false;
		}

		AMFUserCacheModel amfUserCacheModel = (AMFUserCacheModel)obj;

		if ((userId == amfUserCacheModel.userId) &&
			(mvccVersion == amfUserCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, userId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", male=");
		sb.append(male);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", address=");
		sb.append(address);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFUser toEntityModel() {
		AMFUserImpl amfUserImpl = new AMFUserImpl();

		amfUserImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			amfUserImpl.setUuid("");
		}
		else {
			amfUserImpl.setUuid(uuid);
		}

		amfUserImpl.setUserId(userId);
		amfUserImpl.setMale(male);

		if (dob == Long.MIN_VALUE) {
			amfUserImpl.setDob(null);
		}
		else {
			amfUserImpl.setDob(new Date(dob));
		}

		if (homePhone == null) {
			amfUserImpl.setHomePhone("");
		}
		else {
			amfUserImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			amfUserImpl.setMobilePhone("");
		}
		else {
			amfUserImpl.setMobilePhone(mobilePhone);
		}

		if (address == null) {
			amfUserImpl.setAddress("");
		}
		else {
			amfUserImpl.setAddress(address);
		}

		if (address2 == null) {
			amfUserImpl.setAddress2("");
		}
		else {
			amfUserImpl.setAddress2(address2);
		}

		if (city == null) {
			amfUserImpl.setCity("");
		}
		else {
			amfUserImpl.setCity(city);
		}

		if (state == null) {
			amfUserImpl.setState("");
		}
		else {
			amfUserImpl.setState(state);
		}

		if (zip == null) {
			amfUserImpl.setZip("");
		}
		else {
			amfUserImpl.setZip(zip);
		}

		if (createDate == Long.MIN_VALUE) {
			amfUserImpl.setCreateDate(null);
		}
		else {
			amfUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amfUserImpl.setModifiedDate(null);
		}
		else {
			amfUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		amfUserImpl.resetOriginalValues();

		return amfUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		userId = objectInput.readLong();

		male = objectInput.readBoolean();
		dob = objectInput.readLong();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		address = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zip = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeBoolean(male);
		objectOutput.writeLong(dob);

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zip);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long mvccVersion;
	public String uuid;
	public long userId;
	public boolean male;
	public long dob;
	public String homePhone;
	public String mobilePhone;
	public String address;
	public String address2;
	public String city;
	public String state;
	public String zip;
	public long createDate;
	public long modifiedDate;

}