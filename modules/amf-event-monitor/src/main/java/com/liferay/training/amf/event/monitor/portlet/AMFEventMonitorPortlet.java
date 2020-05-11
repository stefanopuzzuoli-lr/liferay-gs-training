package com.liferay.training.amf.event.monitor.portlet;

import com.liferay.amf.event.monitor.s.model.AMFEvent;
import com.liferay.amf.event.monitor.s.service.AMFEventLocalService;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.event.monitor.constants.AMFEventMonitorPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author stefano
 * @param <E>
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.tools",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AMFEventMonitor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AMFEventMonitorPortletKeys.AMFEVENTMONITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AMFEventMonitorPortlet<E> extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// check if user has VIEW_ALL permission
		boolean hasViewAllPermission = checkPermission("VIEW_ALL",renderRequest);
		
		// set attributes as empty lists in case users don't have needed permissions
		renderRequest.setAttribute("all-events", new ArrayList<>());
		renderRequest.setAttribute("all-registrations", new ArrayList<>());
		renderRequest.setAttribute("all-logins", new ArrayList<>());
				
		// if has permission view events of all users
		if (hasViewAllPermission)
		{
			// get all users' events from DB sorted by createDate in descending order
			int end = _AMFEventLocalService.getAMFEventsCount();
			List<AMFEvent> allUsersRegistrationsAndLogins = _AMFEventLocalService.getAMFEvents(0, end);
			List<AMFEvent> allUsersRegistrations = _AMFEventLocalService.getAMFEventByEventType("REGISTRATION");
			List<AMFEvent> allUsersLogins = _AMFEventLocalService.getAMFEventByEventType("LOGIN");
			
			
			// set request attribute to contain lists of events
			renderRequest.setAttribute("all-events", allUsersRegistrationsAndLogins);
			renderRequest.setAttribute("all-registrations", allUsersRegistrations);
			renderRequest.setAttribute("all-logins", allUsersLogins);
		}
		else
		{
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			
			// otherwise check if logged in and if yes view own user events
			if(permissionChecker.isSignedIn())
			{
				// get current user ID
				final long userId = Long.parseLong(renderRequest.getRemoteUser());
				
				// get only current user's events from DB sorted by createDate in descending order
				List<AMFEvent> ownUserRegistrationsAndLogins = _AMFEventLocalService.getAMFEventByUserId(userId);
				List<AMFEvent> ownUserRegistrations = _AMFEventLocalService.getAMFEventByUserIdAndEventType(userId, "REGISTRATION");
				List<AMFEvent> ownUserLogins = _AMFEventLocalService.getAMFEventByUserIdAndEventType(userId, "LOGIN");
				
				// set request attribute to contain lists of events
				renderRequest.setAttribute("all-events", ownUserRegistrationsAndLogins);
				renderRequest.setAttribute("all-registrations", ownUserRegistrations);
				renderRequest.setAttribute("all-logins", ownUserLogins);
			}
		}
		
		
		super.render(renderRequest, renderResponse);
	}
	
	
	public boolean checkPermission(String actionId, RenderRequest request)
	{
		// get portlet permission details
		
		final String name = "com_liferay_training_amf_event_monitor_AMFEventMonitorPortlet";
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		// check if current user has permission to view all
		boolean viewAll = permissionChecker.hasPermission(groupId, name, name, actionId);
		return viewAll;
	}
	

	
	@Reference
	private AMFEventLocalService _AMFEventLocalService;

}