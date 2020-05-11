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

import java.text.SimpleDateFormat;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the AMFEvent service. Represents a row in the &quot;AMF_AMFEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.event.monitor.s.model.AMFEvent</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AMFEventImpl extends AMFEventBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a amf event model instance should use the {@link com.liferay.amf.event.monitor.s.model.AMFEvent} interface instead.
	 */
	public AMFEventImpl() {
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return  formatter.format(this.getCreateDate()) + " " + this.getUsername() + " (" + this.getUserId() + ") " +  this.getClientIp() + " " + this.getEventType();
	}
	
	

}