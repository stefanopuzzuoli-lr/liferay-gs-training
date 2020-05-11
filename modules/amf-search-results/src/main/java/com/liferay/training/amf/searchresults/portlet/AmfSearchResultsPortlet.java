package com.liferay.training.amf.searchresults.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.amf.searchresults.constants.AmfSearchResultsPortletKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletContext;
import javax.portlet.ProcessEvent;

import org.osgi.service.component.annotations.Component;

/**
 * @author stefa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.tools",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Amf-Search-Results", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfSearchResultsPortletKeys.AMFSEARCHRESULTS,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=message;http://www.liferay.com",

}, service = Portlet.class)
public class AmfSearchResultsPortlet extends MVCPortlet {

	@ProcessEvent(qname = "{http://www.liferay.com}message")
	public void handleSearchUsersByZipEvent(EventRequest request, EventResponse response)
			throws javax.portlet.PortletException, java.io.IOException {
		Event event = request.getEvent();

		Map<String, List<User>> zipToUsers = (Map<String, List<User>>) event.getValue();

		// use for-each loop to iterate hashmap but we know it will only contain one
		// single entry with the zip searched as key and the value being the users
		String zip = "";
		List<User> users;
		for (String key : zipToUsers.keySet())
			zip = key;
		users = zipToUsers.get(zip);

		// set portlet context attributes to assure attributes aren't lost when
		// iterating through pages
		PortletContext portletContext = getPortletContext();
		portletContext.setAttribute("zipSearched", zip);
		portletContext.setAttribute("searchResults", users);
	}

}