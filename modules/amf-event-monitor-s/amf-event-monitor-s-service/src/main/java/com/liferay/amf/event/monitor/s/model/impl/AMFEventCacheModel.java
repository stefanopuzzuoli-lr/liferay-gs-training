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

package com.liferay.amf.event.monitor.s.model.impl;

import com.liferay.amf.event.monitor.s.model.AMFEvent;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing AMFEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AMFEventCacheModel
	implements CacheModel<AMFEvent>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFEventCacheModel)) {
			return false;
		}

		AMFEventCacheModel amfEventCacheModel = (AMFEventCacheModel)obj;

		if (auditEventId == amfEventCacheModel.auditEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", auditEventId=");
		sb.append(auditEventId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", username=");
		sb.append(username);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", clientIp=");
		sb.append(clientIp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFEvent toEntityModel() {
		AMFEventImpl amfEventImpl = new AMFEventImpl();

		if (uuid == null) {
			amfEventImpl.setUuid("");
		}
		else {
			amfEventImpl.setUuid(uuid);
		}

		amfEventImpl.setAuditEventId(auditEventId);
		amfEventImpl.setUserId(userId);

		if (username == null) {
			amfEventImpl.setUsername("");
		}
		else {
			amfEventImpl.setUsername(username);
		}

		if (createDate == Long.MIN_VALUE) {
			amfEventImpl.setCreateDate(null);
		}
		else {
			amfEventImpl.setCreateDate(new Date(createDate));
		}

		if (eventType == null) {
			amfEventImpl.setEventType("");
		}
		else {
			amfEventImpl.setEventType(eventType);
		}

		if (clientIp == null) {
			amfEventImpl.setClientIp("");
		}
		else {
			amfEventImpl.setClientIp(clientIp);
		}

		amfEventImpl.resetOriginalValues();

		return amfEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		auditEventId = objectInput.readLong();

		userId = objectInput.readLong();
		username = objectInput.readUTF();
		createDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		clientIp = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(auditEventId);

		objectOutput.writeLong(userId);

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		objectOutput.writeLong(createDate);

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (clientIp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientIp);
		}
	}

	public String uuid;
	public long auditEventId;
	public long userId;
	public String username;
	public long createDate;
	public String eventType;
	public String clientIp;

}