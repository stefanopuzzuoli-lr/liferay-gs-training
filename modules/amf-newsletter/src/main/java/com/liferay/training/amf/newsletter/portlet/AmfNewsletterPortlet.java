package com.liferay.training.amf.newsletter.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.newsletter.constants.AmfNewsletterPortletKeys;
import com.liferay.training.amf.newsletter.helpers.NewsletterHelper;

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
import org.osgi.service.component.annotations.Reference;

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
		// get all journalFolders
		List<JournalFolder> journalFolders = _journalFolderLocalService.getFolders(groupId);

		Map<JournalFolder, List<JournalArticle>> foldersToArticles = new HashMap<>();
		Map<Integer, List<JournalFolder>> yearsToFolders = new HashMap<>();

		// map years to folders and folders to articles
		for (JournalFolder journalFolder : journalFolders) {
			foldersToArticles.put(journalFolder, _journalArticleLocalService.getArticles(groupId,
					journalFolder.getFolderId(), 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS));
			Date createdate = journalFolder.getCreateDate();
			LocalDate localCreateDate = createdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int year = localCreateDate.getYear();
			if (yearsToFolders.containsKey(year)) {
				yearsToFolders.get(year).add(journalFolder);
			} else {
				yearsToFolders.put(year, new ArrayList<>());
				yearsToFolders.get(year).add(journalFolder);
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Mapping of years to folders and folders to articles complete.");
		}

		List<Integer> years = new ArrayList<Integer>(yearsToFolders.keySet());
		// sort list of years in descending order
		Collections.sort(years, Collections.reverseOrder());

		// get string of years separated by commas
		String commaSeparatedYears = NewsletterHelper.getCommaSeparatedInts(years);

		renderRequest.setAttribute("years", years);
		renderRequest.setAttribute("commaSeparatedYears", commaSeparatedYears);

		// Comparator to sort folders by createDate (DESC)
		Comparator<JournalFolder> compareByCreateDateDesc = (JournalFolder journalFolder1,
				JournalFolder journalFolder2) -> journalFolder2.getCreateDate()
						.compareTo(journalFolder1.getCreateDate());

		// sort journalFolders of each year in DESC order
		for (Integer year : yearsToFolders.keySet()) {
			Collections.sort(yearsToFolders.get(year), compareByCreateDateDesc);
		}

		// set all custom fields attributes of folders and articles
		NewsletterHelper.setFoldersAndArticlesCustomFields(foldersToArticles);

		if (_log.isDebugEnabled()) {
			_log.debug("All custom field Expando attributes of folders and articles set.");
		}

		// create mapping of folder to latest version of only approved articles
		Map<JournalFolder, Set<JournalArticle>> foldersToLatestApprovedArticles = new HashMap<>();
		for (JournalFolder journalFolder : foldersToArticles.keySet()) {
			foldersToLatestApprovedArticles.put(journalFolder, new HashSet<>());
			List<JournalArticle> articles = foldersToArticles.get(journalFolder);
			for (JournalArticle article : articles) {
				try {
					foldersToLatestApprovedArticles.get(journalFolder)
							.add(_journalArticleLocalService.getLatestArticle(groupId, article.getArticleId(), 0));
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}
		renderRequest.setAttribute("foldersToLatestApprovedArticles", foldersToLatestApprovedArticles);

		// get Map of Years to Months to JournalFolders (according to create Dates)
		Map<Integer, Map<Integer, List<JournalFolder>>> yearToMonthToFolders = NewsletterHelper
				.getYearToMonthToFolders(yearsToFolders);
		renderRequest.setAttribute("yearToMonthToFolders", yearToMonthToFolders);

		if (_log.isDebugEnabled()) {
			_log.debug("Mapping of Years to Months to JournalFolders complete.");
		}

		super.render(renderRequest, renderResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(AmfNewsletterPortlet.class);

	@Reference
	protected JournalFolderLocalService _journalFolderLocalService;

	@Reference
	protected JournalArticleLocalService _journalArticleLocalService;

}