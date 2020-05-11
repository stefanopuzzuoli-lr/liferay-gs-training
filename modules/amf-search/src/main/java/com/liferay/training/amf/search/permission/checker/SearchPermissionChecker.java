package com.liferay.training.amf.search.permission.checker;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;

public class SearchPermissionChecker {

	public static boolean checkPermission(String actionId, ActionRequest request) {

		// get portlet permission details
		final String name = "com_liferay_training_amf_search_AmfSearchPortlet";
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		// check if current user has permission to view all
		boolean viewAll = permissionChecker.hasPermission(groupId, name, name, actionId);
		return viewAll;
	}

}
