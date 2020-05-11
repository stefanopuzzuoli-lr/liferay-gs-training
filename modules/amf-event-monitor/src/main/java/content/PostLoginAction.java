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
package content;

import com.liferay.amf.event.monitor.s.service.AMFEventLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class PostLoginAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		// get login event information

		final String EVENT_TYPE = "LOGIN";
		try {

			ServiceContext serviceContext = new ServiceContext();
			long auditEventId = CounterLocalServiceUtil.increment();
			long userId = Long.parseLong(PrincipalThreadLocal.getName());
			String username = "N/A";
			username = UserLocalServiceUtil.getUser(userId).getScreenName();
			Date createDate = new Date();

			String clientIp = "0.0.0.0";
			clientIp = UserLocalServiceUtil.getUser(userId).getLoginIP();

			// add login event to DB table
			_AMFEventLocalService.addAMFEvent(auditEventId, userId, username, createDate, EVENT_TYPE, clientIp,
					serviceContext);
		} catch (PortalException pe) {
			pe.printStackTrace();
		}
	}

	@Reference
	private AMFEventLocalService _AMFEventLocalService;

}