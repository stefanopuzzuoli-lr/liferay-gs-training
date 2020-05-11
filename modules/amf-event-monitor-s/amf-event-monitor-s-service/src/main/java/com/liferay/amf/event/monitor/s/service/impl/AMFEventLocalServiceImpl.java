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

package com.liferay.amf.event.monitor.s.service.impl;

import com.liferay.amf.event.monitor.s.model.AMFEvent;
import com.liferay.amf.event.monitor.s.service.base.AMFEventLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the amf event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.event.monitor.sb.service.AMFEventLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.event.monitor.sb.model.AMFEvent",
	service = AopService.class
)
public class AMFEventLocalServiceImpl extends AMFEventLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.event.monitor.sb.service.AMFEventLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.event.monitor.sb.service.AMFEventLocalServiceUtil</code>.
	 */


	public AMFEvent addAMFEvent(long auditEventId, long userId, String username, Date createDate, String eventType, String clientIp, ServiceContext serviceContext) throws PortalException {


		AMFEvent entry = amfEventPersistence.create(auditEventId);

		entry.setAuditEventId(auditEventId);
		entry.setUserId(userId);
		entry.setUsername(username);
		entry.setCreateDate(createDate);
		entry.setEventType(eventType);
		entry.setClientIp(clientIp);
		
		return super.addAMFEvent(entry);
	}
	
	public List<AMFEvent> getAMFEventByUserId(long userId)
	{
		return amfEventPersistence.findByUserId(userId);
	}
	
	public List<AMFEvent> getAMFEventByEventType(String eventType)
	{
		return amfEventPersistence.findByEventType(eventType);
	}
	
	public List<AMFEvent> getAMFEventByUserIdAndEventType(long userId, String eventType)
	{
		return amfEventPersistence.findByUserIdAndEventType(userId, eventType);
	}
	

	@Override
	public AMFEvent addAMFEvent(AMFEvent assignment) {
		throw new UnsupportedOperationException("Not supported.");
	}
}