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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.event.monitor.s.service.http.AMFEventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AMFEventSoap implements Serializable {

	public static AMFEventSoap toSoapModel(AMFEvent model) {
		AMFEventSoap soapModel = new AMFEventSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAuditEventId(model.getAuditEventId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUsername(model.getUsername());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setEventType(model.getEventType());
		soapModel.setClientIp(model.getClientIp());

		return soapModel;
	}

	public static AMFEventSoap[] toSoapModels(AMFEvent[] models) {
		AMFEventSoap[] soapModels = new AMFEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFEventSoap[][] toSoapModels(AMFEvent[][] models) {
		AMFEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFEventSoap[] toSoapModels(List<AMFEvent> models) {
		List<AMFEventSoap> soapModels = new ArrayList<AMFEventSoap>(
			models.size());

		for (AMFEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFEventSoap[soapModels.size()]);
	}

	public AMFEventSoap() {
	}

	public long getPrimaryKey() {
		return _auditEventId;
	}

	public void setPrimaryKey(long pk) {
		setAuditEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAuditEventId() {
		return _auditEventId;
	}

	public void setAuditEventId(long auditEventId) {
		_auditEventId = auditEventId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getClientIp() {
		return _clientIp;
	}

	public void setClientIp(String clientIp) {
		_clientIp = clientIp;
	}

	private String _uuid;
	private long _auditEventId;
	private long _userId;
	private String _username;
	private Date _createDate;
	private String _eventType;
	private String _clientIp;

}