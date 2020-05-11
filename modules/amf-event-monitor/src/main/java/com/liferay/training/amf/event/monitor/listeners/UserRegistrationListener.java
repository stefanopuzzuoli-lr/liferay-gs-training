package com.liferay.training.amf.event.monitor.listeners;

import com.liferay.amf.event.monitor.s.service.AMFEventLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class UserRegistrationListener extends BaseModelListener<User> {

	@Override

	public void onAfterCreate(User user) throws ModelListenerException {

		// get registration event information

		final String EVENT_TYPE = "REGISTRATION";
		final String clientIp = "0.0.0.0";

		try {

			ServiceContext serviceContext = new ServiceContext();
			long auditEventId = CounterLocalServiceUtil.increment();
			long userId = user.getUserId();
			String username = user.getScreenName();
			Date createDate = user.getCreateDate();

			// add registration event to DB table
			_AMFEventLocalService.addAMFEvent(auditEventId, userId, username, createDate, EVENT_TYPE, clientIp,
					serviceContext);
		} catch (PortalException pe) {
			pe.printStackTrace();
		}

		super.onAfterCreate(user);

	}

	@Reference
	private AMFEventLocalService _AMFEventLocalService;
}
