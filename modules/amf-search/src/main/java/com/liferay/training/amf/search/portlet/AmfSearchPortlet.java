package com.liferay.training.amf.search.portlet;

import com.liferay.docs.amf.registration.exception.ZipValidationException;
import com.liferay.docs.amf.registration.model.AMFUser;
import com.liferay.docs.amf.registration.service.AMFUserLocalService;
import com.liferay.docs.amf.registration.validator.ZipValidator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
import com.liferay.training.amf.search.permission.checker.SearchPermissionChecker;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author stefano
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.tools",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfSearch", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + AmfSearchPortletKeys.AMFSEARCH,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=message;http://www.liferay.com" }, service = Portlet.class)
public class AmfSearchPortlet extends MVCPortlet {

	public void searchUsersByZip(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, ParseException {

		try {
			if (SearchPermissionChecker.checkPermission("SEARCH", actionRequest)) {

				// get searched zip value
				String searchedZip = ParamUtil.getString(actionRequest, "searched-zip");

				// check if zip is valid
				_zipValidator.validate(searchedZip);

				// get all AMFUsers from amfur_amfuser with searched zip
				List<AMFUser> usersWithSearchedZip = _AMFUserLocalService.getAMFUserByZip(searchedZip);

				// get all users from user_ table in order to access name, screename and email
				// of found users
				List<User> usersWithFullDetails = new ArrayList<>();
				for (AMFUser u : usersWithSearchedZip) {
					// get users from user_ table from their userIds
					usersWithFullDetails.add(UserLocalServiceUtil.getUser(u.getUserId()));
				}

				// use Map to pass both zip searched and list of users founds
				Map<String, List<User>> zipToUsers = new HashMap<>();
				zipToUsers.put(searchedZip, usersWithFullDetails);

				QName qName = new QName("http://www.liferay.com", "message");
				actionResponse.setEvent(qName, (Serializable) zipToUsers);
				SessionMessages.add(actionRequest, "searchSuccess");
			} else {
				SessionErrors.add(actionRequest, "noSearchPermissionError");
			}
		} catch (ZipValidationException zve) {
			SessionErrors.add(actionRequest, "invalidZip");
			// send empty map to event handler in order to clear previous search results
			// displaying
			QName qName = new QName("http://www.liferay.com", "message");
			actionResponse.setEvent(qName, (Serializable) new HashMap<>());

		}
	}

	@Reference
	private AMFUserLocalService _AMFUserLocalService;

	@Reference
	private ZipValidator _zipValidator;
}