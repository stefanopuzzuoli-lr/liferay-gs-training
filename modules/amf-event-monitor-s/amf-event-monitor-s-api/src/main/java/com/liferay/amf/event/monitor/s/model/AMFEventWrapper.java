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

package com.liferay.amf.event.monitor.s.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link AMFEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEvent
 * @generated
 */
@ProviderType
public class AMFEventWrapper
	extends BaseModelWrapper<AMFEvent>
	implements AMFEvent, ModelWrapper<AMFEvent> {

	public AMFEventWrapper(AMFEvent amfEvent) {
		super(amfEvent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("auditEventId", getAuditEventId());
		attributes.put("userId", getUserId());
		attributes.put("username", getUsername());
		attributes.put("createDate", getCreateDate());
		attributes.put("eventType", getEventType());
		attributes.put("clientIp", getClientIp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long auditEventId = (Long)attributes.get("auditEventId");

		if (auditEventId != null) {
			setAuditEventId(auditEventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String clientIp = (String)attributes.get("clientIp");

		if (clientIp != null) {
			setClientIp(clientIp);
		}
	}

	/**
	 * Returns the audit event ID of this amf event.
	 *
	 * @return the audit event ID of this amf event
	 */
	@Override
	public long getAuditEventId() {
		return model.getAuditEventId();
	}

	/**
	 * Returns the client ip of this amf event.
	 *
	 * @return the client ip of this amf event
	 */
	@Override
	public String getClientIp() {
		return model.getClientIp();
	}

	/**
	 * Returns the create date of this amf event.
	 *
	 * @return the create date of this amf event
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event type of this amf event.
	 *
	 * @return the event type of this amf event
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the primary key of this amf event.
	 *
	 * @return the primary key of this amf event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this amf event.
	 *
	 * @return the user ID of this amf event
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the username of this amf event.
	 *
	 * @return the username of this amf event
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	/**
	 * Returns the user uuid of this amf event.
	 *
	 * @return the user uuid of this amf event
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this amf event.
	 *
	 * @return the uuid of this amf event
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the audit event ID of this amf event.
	 *
	 * @param auditEventId the audit event ID of this amf event
	 */
	@Override
	public void setAuditEventId(long auditEventId) {
		model.setAuditEventId(auditEventId);
	}

	/**
	 * Sets the client ip of this amf event.
	 *
	 * @param clientIp the client ip of this amf event
	 */
	@Override
	public void setClientIp(String clientIp) {
		model.setClientIp(clientIp);
	}

	/**
	 * Sets the create date of this amf event.
	 *
	 * @param createDate the create date of this amf event
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event type of this amf event.
	 *
	 * @param eventType the event type of this amf event
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the primary key of this amf event.
	 *
	 * @param primaryKey the primary key of this amf event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this amf event.
	 *
	 * @param userId the user ID of this amf event
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the username of this amf event.
	 *
	 * @param username the username of this amf event
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	/**
	 * Sets the user uuid of this amf event.
	 *
	 * @param userUuid the user uuid of this amf event
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this amf event.
	 *
	 * @param uuid the uuid of this amf event
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected AMFEventWrapper wrap(AMFEvent amfEvent) {
		return new AMFEventWrapper(amfEvent);
	}

}