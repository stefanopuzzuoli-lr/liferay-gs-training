package com.liferay.docs.amf.registration.portlet.portlet;

import com.liferay.docs.amf.registration.exception.AMFUserValidationException;
import com.liferay.docs.amf.registration.model.AMFUser;
import com.liferay.docs.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.liferay.docs.amf.registration.service.AMFUserLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.tools",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AMFRegistration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AMFRegistrationPortletKeys.AMFREGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class AMFRegistrationPortlet extends MVCPortlet {

	public void addUser(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, ParseException{
		

		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
	            AMFUser.class.getName(), actionRequest);
		
		// Get parameters from the request
		String firstName = ParamUtil.getString(actionRequest, "first_name");
		String lastName = ParamUtil.getString(actionRequest, "last_name");
		String email = ParamUtil.getString(actionRequest, "email_address");
		String username = ParamUtil.getString(actionRequest, "username");
		Boolean isMale = Boolean.valueOf(ParamUtil.getString(actionRequest, "male"));
		String rawDob = ParamUtil.getString(actionRequest, "dob");			
		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");
		String homePhone = ParamUtil.getString(actionRequest, "home_phone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone");
		String address = ParamUtil.getString(actionRequest, "address");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");
		String securityQuestion = ParamUtil.getString(actionRequest, "security_question");
		String securityAnswer = ParamUtil.getString(actionRequest, "security_answer");
		String rawAcceptedTOU = ParamUtil.getString(actionRequest, "accepted_tou");
		Boolean acceptedTOU = false;
		Date dob = new Date();
		if (!rawDob.equals(""))
		{
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(rawDob);
		}
		
		if (rawAcceptedTOU.equals("accept"))
		{
			acceptedTOU = true;
		}
		
		try {
			// add new user
			_AMFUserLocalService.addAMFUser(username, firstName, lastName, email, isMale, dob, homePhone, mobilePhone, address, address2, city, state, zip, securityQuestion, securityAnswer, acceptedTOU, password1, password2, serviceContext);
			SessionMessages.add(actionRequest, "userAdded");
			Map<String, String> userMap = new HashMap<>();
			userMap.put("first_name", firstName);
			actionRequest.setAttribute("userMap", userMap);
			actionResponse.setRenderParameter("mvcPath", "/META-INF/resources/registrationSuccess.jsp");
		}
        catch (AMFUserValidationException use) {
        	use.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
        }
        catch	(PortalException pe) {
        	System.out.println(pe.getMessage());
        	// Set error messages
			SessionErrors.add(actionRequest, "serviceErrorDetails" , pe);
        }
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			// Set username already exists error messages 
			SessionErrors.add(actionRequest, "usernameTakenError");
		}
        			
		
	}
	
	@Reference
	private AMFUserLocalService _AMFUserLocalService;
}