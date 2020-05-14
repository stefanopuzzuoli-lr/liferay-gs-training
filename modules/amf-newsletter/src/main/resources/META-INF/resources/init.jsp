<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import ="com.liferay.journal.model.JournalArticle"%>
<%@ page import ="com.liferay.journal.model.JournalFolder"%>
<%@ page import ="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@ page import ="com.liferay.journal.service.JournalFolderLocalServiceUtil"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@ page import ="java.time.Month"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.Collections"%>
<%@ page import ="java.util.Date"%>
<%@ page import ="java.util.HashMap"%>
<%@ page import ="java.util.Map"%>
<%@ page import ="java.util.List"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />