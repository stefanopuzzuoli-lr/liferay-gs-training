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
import com.liferay.docs.amf.registration.service.base.AMFUserServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the amf user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.docs.amf.registration.service.AMFUserService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author liferay
 * @see AMFUserServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amfur",
		"json.web.service.context.path=AMFUser"
	},
	service = AopService.class
)
public class AMFUserServiceImpl extends AMFUserServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.docs.amf.registration.service.AMFUserServiceUtil</code> to access the amf user remote service.
	 */
	public List<AMFUser> getAMFUserByZip(String zip)  {
		return amfUserPersistence.findByZip(zip);
	}
}