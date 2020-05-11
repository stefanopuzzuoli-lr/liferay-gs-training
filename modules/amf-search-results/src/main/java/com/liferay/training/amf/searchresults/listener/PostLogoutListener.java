/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.training.amf.searchresults.listener;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.training.amf.searchresults.constants.AmfSearchResultsPortletKeys;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "key=logout.events.post" }, service = LifecycleAction.class)
public class PostLogoutListener implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		PortletBag portletBag = PortletBagPool.get(AmfSearchResultsPortletKeys.AMFSEARCHRESULTS);
		GenericPortlet portletInstance = (GenericPortlet)portletBag.getPortletInstance();
		PortletContext portletContext = portletInstance.getPortletContext();
		portletContext.removeAttribute("zipSearched");
		portletContext.removeAttribute("searchResults");
		
	}

}