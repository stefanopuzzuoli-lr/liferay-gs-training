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
import com.liferay.amf.event.monitor.s.service.base.AMFEventServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the amf event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.event.monitor.sb.service.AMFEventService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=aem",
		"json.web.service.context.path=AMFEvent"
	},
	service = AopService.class
)
public class AMFEventServiceImpl extends AMFEventServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.amf.event.monitor.sb.service.AMFEventServiceUtil</code> to access the amf event remote service.
	 */
	public AMFEvent addAMFEvent(long auditEventId, long userId, String username, Date createDate, String eventType, String clientIp, ServiceContext serviceContext)
			throws PortalException {
		return amfEventLocalService.addAMFEvent( auditEventId,  userId,  username,  createDate,  eventType,  clientIp,  serviceContext);
			}
	
	public AMFEvent getAMFEvent(long userId)
			throws PortalException {
		AMFEvent assignment =amfEventLocalService.getAMFEvent(userId);
			return assignment;
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
	
}