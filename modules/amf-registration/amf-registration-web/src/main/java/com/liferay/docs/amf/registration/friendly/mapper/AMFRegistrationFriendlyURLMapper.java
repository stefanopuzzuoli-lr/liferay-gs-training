package com.liferay.docs.amf.registration.friendly.mapper;

import com.liferay.docs.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=" + AMFRegistrationPortletKeys.AMFREGISTRATION
	    },
	    service = FriendlyURLMapper.class
	)

public class AMFRegistrationFriendlyURLMapper extends DefaultFriendlyURLMapper {

	
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "registration";
}
