package com.liferay.training.amf.newsletter.portlet;

import com.liferay.journal.exception.NoSuchArticleException;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import java.util.Comparator;
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
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
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
		Map<Integer, List<JournalFolder>> yearsToFolders = new HashMap<>();

		// map each folder to the articles contained in it and get years of releases
		for (JournalFolder journalFolder : journalFolders) {
			foldersToArticles.put(journalFolder,
					JournalArticleLocalServiceUtil.getArticles(groupId, journalFolder.getFolderId(), 0,   QueryUtil.ALL_POS,  QueryUtil.ALL_POS));
			Date createdate = journalFolder.getCreateDate();
			LocalDate localCreateDate = createdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int year = localCreateDate.getYear();
			if (yearsToFolders.containsKey(year))
			{
				yearsToFolders.get(year).add(journalFolder);
			}
			else
			{
				yearsToFolders.put(year, new ArrayList<>());
				yearsToFolders.get(year).add(journalFolder);
			}
		}
				
		List<Integer> years = new ArrayList<Integer>(yearsToFolders.keySet());

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

		// Comparator to sort folders by createDate (DESC)
        Comparator<JournalFolder> compareByCreateDateDesc = (JournalFolder journalFolder1, JournalFolder journalFolder2) -> 
        journalFolder2.getCreateDate().compareTo( journalFolder1.getCreateDate() );
        
        // sort journalFolders of each year in DESC order
        for (Integer key : yearsToFolders.keySet())
        {
        	Collections.sort(yearsToFolders.get(key), compareByCreateDateDesc);
        }

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
			if  (authors.size() == 1) {
				// get individual author from set (string includes brackets) 
				String author = authors.toString();
				// remove brackets from author string
				journalFolder.getExpandoBridge().setAttribute("Byline", author.substring(1, author.length() - 1));
			}
			else if (!authors.isEmpty())
			{
				// get authors and remove trailing ', ' (comma and space)
				journalFolder.getExpandoBridge().setAttribute("Byline", String.join(", ", authors).substring(2));
			}
		}
		
		if (_log.isDebugEnabled()) {
			_log.debug("All custom field expando attributes of folders and articles set.");
		}
		
		// create mapping of folder to latest version of only approved articles
		Map<JournalFolder, Set<JournalArticle>> foldersToLatestApprovedArticles = new HashMap<>();
		for (JournalFolder journalFolder : foldersToArticles.keySet()) {
			foldersToLatestApprovedArticles.put(journalFolder, new HashSet<>());
			List<JournalArticle> articles = foldersToArticles.get(journalFolder);
			for (JournalArticle article : articles) {
				try {
					foldersToLatestApprovedArticles.get(journalFolder).add(JournalArticleLocalServiceUtil.getLatestArticle(groupId, article.getArticleId(), 0));
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}
		renderRequest.setAttribute("foldersToLatestApprovedArticles", foldersToLatestApprovedArticles);

		Map<Integer, Map<Integer, List<JournalFolder>>> yearToMonthToFolders = new HashMap<>();
		for (Integer year : years)
		{
			yearToMonthToFolders.put(year, new HashMap<>());
			yearToMonthToFolders.get(year).put(0, new ArrayList<>());
			yearToMonthToFolders.get(year).put(1, new ArrayList<>());
			yearToMonthToFolders.get(year).put(2, new ArrayList<>());
			yearToMonthToFolders.get(year).put(3, new ArrayList<>());
			yearToMonthToFolders.get(year).put(4, new ArrayList<>());
			yearToMonthToFolders.get(year).put(5, new ArrayList<>());
			yearToMonthToFolders.get(year).put(6, new ArrayList<>());
			yearToMonthToFolders.get(year).put(7, new ArrayList<>());
			yearToMonthToFolders.get(year).put(8, new ArrayList<>());
			yearToMonthToFolders.get(year).put(9, new ArrayList<>());
			yearToMonthToFolders.get(year).put(10, new ArrayList<>());
			yearToMonthToFolders.get(year).put(11, new ArrayList<>());

			if (yearsToFolders.get(year) != null)
			{
				List<JournalFolder> journalFoldersOfYear = yearsToFolders.get(year);
				for (JournalFolder journalFolderOfYear : journalFoldersOfYear)
				{
					int monthNum = journalFolderOfYear.getCreateDate().getMonth();
					yearToMonthToFolders.get(year).get(monthNum).add(journalFolderOfYear);
				}
			}
		}
		
		if (_log.isDebugEnabled()) {
			_log.debug("Mapping of Years to Months to JournalFolders complete.");
		}
		
		renderRequest.setAttribute("yearToMonthToFolders", yearToMonthToFolders);
		
		renderRequest.setAttribute("foldersToArticles", foldersToArticles);
		
		super.render(renderRequest, renderResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(AmfNewsletterPortlet.class);

}