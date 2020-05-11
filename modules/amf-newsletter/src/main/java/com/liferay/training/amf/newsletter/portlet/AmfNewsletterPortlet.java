package com.liferay.training.amf.newsletter.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.newsletter.constants.AmfNewsletterPortletKeys;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author stefa
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.news",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfNewsletter", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AmfNewsletterPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
		List<JournalFolder> journalFolders = JournalFolderLocalServiceUtil.getFolders(groupId);
		Map<JournalFolder, List<JournalArticle>> foldersToArticles = new HashMap<>();

		// get list of all years in which issues are released
		Set<Integer> yearsSet = new HashSet<>();

		// map each folder to the articles contained in it and get years of releases
		for (JournalFolder journalFolder : journalFolders) {
			foldersToArticles.put(journalFolder,
					JournalArticleLocalServiceUtil.getArticles(groupId, journalFolder.getFolderId()));
			Date createdate = journalFolder.getCreateDate();
			LocalDate localCreateDate = createdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			yearsSet.add(localCreateDate.getYear());
		}
		
		List<Integer> years = new ArrayList<Integer>(yearsSet);

		// sort the list of years in descending order
		Collections.sort(years, Collections.reverseOrder());

		StringBuffer commaSeparatedYears = new StringBuffer("");
		for (Integer year : years) {
			commaSeparatedYears.append(year);
			commaSeparatedYears.append(",");
		}

		// set years attribute for iterating through each year
		renderRequest.setAttribute("years", years);
		// set commaSeparatedYears attribute for tabs creation
		renderRequest.setAttribute("commaSeparatedYears", commaSeparatedYears.toString());

		// set all custom fields attributes of folders and articles (such as Parent
		// Issue, Order, etc.)
		for (JournalFolder journalFolder : foldersToArticles.keySet()) {
			long FolderIssueNumber = (long) journalFolder.getExpandoBridge().getAttribute("Issue number");
			List<JournalArticle> articles = foldersToArticles.get(journalFolder);
			Set<String> authors = new HashSet<>();
			int numArticlesInIssue = articles.size();
			int orderInIssue = numArticlesInIssue;
			for (JournalArticle article : articles) {
				article.getExpandoBridge().setAttribute("Parent Issue", FolderIssueNumber);
				article.getExpandoBridge().setAttribute("Order", orderInIssue);
				orderInIssue--;
				authors.add((String) article.getExpandoBridge().getAttribute("Author"));
			}
			journalFolder.getExpandoBridge().setAttribute("Byline", String.join(", ", authors).substring(2));
		}

		if (_log.isDebugEnabled()) {
			_log.debug("All custom field expando attributes of folders and articles set.");
		}

		// have all months in list and get index of current month

		super.render(renderRequest, renderResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(AmfNewsletterPortlet.class);

}