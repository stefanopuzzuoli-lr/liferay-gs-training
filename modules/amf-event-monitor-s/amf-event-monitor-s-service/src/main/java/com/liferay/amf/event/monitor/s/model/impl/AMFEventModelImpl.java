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
import com.liferay.amf.event.monitor.s.model.AMFEventModel;
import com.liferay.amf.event.monitor.s.model.AMFEventSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the AMFEvent service. Represents a row in the &quot;AMF_AMFEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AMFEventModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AMFEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AMFEventModelImpl
	extends BaseModelImpl<AMFEvent> implements AMFEventModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a amf event model instance should use the <code>AMFEvent</code> interface instead.
	 */
	public static final String TABLE_NAME = "AMF_AMFEvent";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"auditEventId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"username", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"eventType", Types.VARCHAR},
		{"clientIp", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("auditEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("username", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("clientIp", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AMF_AMFEvent (uuid_ VARCHAR(75) null,auditEventId LONG not null primary key,userId LONG,username VARCHAR(75) null,createDate DATE null,eventType VARCHAR(75) null,clientIp VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table AMF_AMFEvent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY amfEvent.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AMF_AMFEvent.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long EVENTTYPE_COLUMN_BITMASK = 1L;

	public static final long USERID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AMFEvent toModel(AMFEventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AMFEvent model = new AMFEventImpl();

		model.setUuid(soapModel.getUuid());
		model.setAuditEventId(soapModel.getAuditEventId());
		model.setUserId(soapModel.getUserId());
		model.setUsername(soapModel.getUsername());
		model.setCreateDate(soapModel.getCreateDate());
		model.setEventType(soapModel.getEventType());
		model.setClientIp(soapModel.getClientIp());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AMFEvent> toModels(AMFEventSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AMFEvent> models = new ArrayList<AMFEvent>(soapModels.length);

		for (AMFEventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public AMFEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _auditEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAuditEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _auditEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AMFEvent.class;
	}

	@Override
	public String getModelClassName() {
		return AMFEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AMFEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AMFEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFEvent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((AMFEvent)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AMFEvent, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AMFEvent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AMFEvent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AMFEvent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AMFEvent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AMFEvent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AMFEvent.class.getClassLoader(), AMFEvent.class,
			ModelWrapper.class);

		try {
			Constructor<AMFEvent> constructor =
				(Constructor<AMFEvent>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<AMFEvent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AMFEvent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AMFEvent, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AMFEvent, Object>>();
		Map<String, BiConsumer<AMFEvent, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AMFEvent, ?>>();

		attributeGetterFunctions.put("uuid", AMFEvent::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<AMFEvent, String>)AMFEvent::setUuid);
		attributeGetterFunctions.put("auditEventId", AMFEvent::getAuditEventId);
		attributeSetterBiConsumers.put(
			"auditEventId",
			(BiConsumer<AMFEvent, Long>)AMFEvent::setAuditEventId);
		attributeGetterFunctions.put("userId", AMFEvent::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<AMFEvent, Long>)AMFEvent::setUserId);
		attributeGetterFunctions.put("username", AMFEvent::getUsername);
		attributeSetterBiConsumers.put(
			"username", (BiConsumer<AMFEvent, String>)AMFEvent::setUsername);
		attributeGetterFunctions.put("createDate", AMFEvent::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<AMFEvent, Date>)AMFEvent::setCreateDate);
		attributeGetterFunctions.put("eventType", AMFEvent::getEventType);
		attributeSetterBiConsumers.put(
			"eventType", (BiConsumer<AMFEvent, String>)AMFEvent::setEventType);
		attributeGetterFunctions.put("clientIp", AMFEvent::getClientIp);
		attributeSetterBiConsumers.put(
			"clientIp", (BiConsumer<AMFEvent, String>)AMFEvent::setClientIp);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getAuditEventId() {
		return _auditEventId;
	}

	@Override
	public void setAuditEventId(long auditEventId) {
		_auditEventId = auditEventId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUsername() {
		if (_username == null) {
			return "";
		}
		else {
			return _username;
		}
	}

	@Override
	public void setUsername(String username) {
		_username = username;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return "";
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_columnBitmask |= EVENTTYPE_COLUMN_BITMASK;

		if (_originalEventType == null) {
			_originalEventType = _eventType;
		}

		_eventType = eventType;
	}

	public String getOriginalEventType() {
		return GetterUtil.getString(_originalEventType);
	}

	@JSON
	@Override
	public String getClientIp() {
		if (_clientIp == null) {
			return "";
		}
		else {
			return _clientIp;
		}
	}

	@Override
	public void setClientIp(String clientIp) {
		_clientIp = clientIp;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, AMFEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AMFEvent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AMFEvent>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AMFEventImpl amfEventImpl = new AMFEventImpl();

		amfEventImpl.setUuid(getUuid());
		amfEventImpl.setAuditEventId(getAuditEventId());
		amfEventImpl.setUserId(getUserId());
		amfEventImpl.setUsername(getUsername());
		amfEventImpl.setCreateDate(getCreateDate());
		amfEventImpl.setEventType(getEventType());
		amfEventImpl.setClientIp(getClientIp());

		amfEventImpl.resetOriginalValues();

		return amfEventImpl;
	}

	@Override
	public int compareTo(AMFEvent amfEvent) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), amfEvent.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFEvent)) {
			return false;
		}

		AMFEvent amfEvent = (AMFEvent)obj;

		long primaryKey = amfEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		AMFEventModelImpl amfEventModelImpl = this;

		amfEventModelImpl._originalUuid = amfEventModelImpl._uuid;

		amfEventModelImpl._originalUserId = amfEventModelImpl._userId;

		amfEventModelImpl._setOriginalUserId = false;

		amfEventModelImpl._originalEventType = amfEventModelImpl._eventType;

		amfEventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AMFEvent> toCacheModel() {
		AMFEventCacheModel amfEventCacheModel = new AMFEventCacheModel();

		amfEventCacheModel.uuid = getUuid();

		String uuid = amfEventCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			amfEventCacheModel.uuid = null;
		}

		amfEventCacheModel.auditEventId = getAuditEventId();

		amfEventCacheModel.userId = getUserId();

		amfEventCacheModel.username = getUsername();

		String username = amfEventCacheModel.username;

		if ((username != null) && (username.length() == 0)) {
			amfEventCacheModel.username = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			amfEventCacheModel.createDate = createDate.getTime();
		}
		else {
			amfEventCacheModel.createDate = Long.MIN_VALUE;
		}

		amfEventCacheModel.eventType = getEventType();

		String eventType = amfEventCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			amfEventCacheModel.eventType = null;
		}

		amfEventCacheModel.clientIp = getClientIp();

		String clientIp = amfEventCacheModel.clientIp;

		if ((clientIp != null) && (clientIp.length() == 0)) {
			amfEventCacheModel.clientIp = null;
		}

		return amfEventCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AMFEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AMFEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AMFEvent)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<AMFEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AMFEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AMFEvent)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AMFEvent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _auditEventId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _username;
	private Date _createDate;
	private String _eventType;
	private String _originalEventType;
	private String _clientIp;
	private long _columnBitmask;
	private AMFEvent _escapedModel;

}