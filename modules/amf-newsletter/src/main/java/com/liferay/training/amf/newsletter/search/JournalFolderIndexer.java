package com.liferay.training.amf.newsletter.search;

import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Reference;

public class JournalFolderIndexer extends  BaseIndexer<JournalFolder> {

	public static final String CLASS_NAME = JournalFolder.class.getName();
	
	@Override
	public String getClassName() {
	    return CLASS_NAME;
	}
	
	public JournalFolderIndexer() {
	    setDefaultSelectedFieldNames(
	        Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
	        Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
	        Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
	    setPermissionAware(true);
	    setFilterSearch(true);
	}
	
	@Override
	public boolean hasPermission(
	        PermissionChecker permissionChecker, String entryClassName, 
	        long entryClassPK, String actionId) 
	    throws Exception {

	    return true;
	}
	
	@Override
	public void postProcessContextBooleanFilter(
	        BooleanFilter contextBooleanFilter, SearchContext searchContext)
	throws Exception {
	    addStatus(contextBooleanFilter, searchContext);
	}
	
	@Override
	public void postProcessSearchQuery(
	    BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
	    SearchContext searchContext)
	    throws Exception {

	    addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
	}


	@Override
	protected void doDelete(JournalFolder journalFolder) throws Exception {
		deleteDocument(journalFolder.getCompanyId(), journalFolder.getFolderId());
		
	}

	@Override
	protected Document doGetDocument(JournalFolder journalFolder) throws Exception {
		 	Document document = getBaseModelDocument(CLASS_NAME, journalFolder);

		    document.addDate(Field.MODIFIED_DATE, journalFolder.getModifiedDate());

		    Locale defaultLocale =
		        PortalUtil.getSiteDefaultLocale(journalFolder.getGroupId());
		    String localizedField = LocalizationUtil.getLocalizedName(
		        Field.TITLE, defaultLocale.toString());

		    document.addText(localizedField, journalFolder.getName());
		    return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document);
	    summary.setMaxContentLength(200);
	    return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		JournalFolder journalFolder = JournalFolderLocalServiceUtil.getFolder(classPK);
	    doReindex(journalFolder);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		 long companyId = GetterUtil.getLong(ids[0]);
		 reindexJournalFolders(companyId);
		
	}

	@Override
	protected void doReindex(JournalFolder journalFolder) throws Exception {
		Document document = getDocument(journalFolder);
	    indexWriterHelper.updateDocument(
	        getSearchEngineId(), journalFolder.getCompanyId(), document,
	        isCommitImmediately());
		
	}
	
	protected void reindexJournalFolders(long companyId)
			  throws PortalException {

			  final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
					  JournalFolderLocalServiceUtil.getIndexableActionableDynamicQuery();

			  indexableActionableDynamicQuery.setCompanyId(companyId);

			  indexableActionableDynamicQuery.setPerformActionMethod(

			    new ActionableDynamicQuery.PerformActionMethod<JournalFolder>() {
			      @Override
			      public void performAction(JournalFolder journalFolder) {
			        try {
			          Document document = getDocument(journalFolder);
			          indexableActionableDynamicQuery.addDocuments(document);
			        }
			        catch (PortalException pe) {
			          if (_log.isWarnEnabled()) {
			            _log.warn(
			              "Unable to index guestbook " +
			            		  journalFolder.getFolderId(),
			              pe);
			          }
			        }
			      }
			    });
			  indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
			  indexableActionableDynamicQuery.performActions();
			}
	
	
	private static final Log _log =
			  LogFactoryUtil.getLog(JournalFolderIndexer.class);

			@Reference
			protected IndexWriterHelper indexWriterHelper;

	
}
