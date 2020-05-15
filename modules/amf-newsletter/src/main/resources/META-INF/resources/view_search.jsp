<%@ include file="/init.jsp"%>

<%
  String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" 
        value="/view_search.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param 
        name="mvcPath" 
        value="/view.jsp" 
    />
</portlet:renderURL>


<aui:form action="${searchURL}"  method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

<liferay-ui:header
    backURL="<%= viewURL.toString() %>"
    title="search"
/>

    <div class="row">
        <div class="col-md-4">
            <aui:input inlineLabel="left" label="" name="keywords" placeholder="" size="30" />
        </div>

        <div class="col-md-4">
            <aui:button type="submit" value="search" />
        </div>
    </div>

</aui:form>

<%
    SearchContext searchContext = SearchContextFactory.getInstance(request);

    searchContext.setKeywords(keywords);
    searchContext.setAttribute("paginationType", "more");
    searchContext.setStart(0);
    searchContext.setEnd(100);
    Indexer indexer = IndexerRegistryUtil.getIndexer(JournalFolder.class);
    
    Hits hits = indexer.search(searchContext);

    List<JournalFolder> journalFolders = new ArrayList<JournalFolder>();

        for (int i = 0; i < hits.getDocs().length; i++) {
                Document doc = hits.doc(i);

                long folderId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
                JournalFolder entry = null;

                try {
                        entry = JournalFolderLocalServiceUtil.getFolder(folderId);
                } catch (PortalException pe) {
                        _log.error(pe.getLocalizedMessage());
                } catch (SystemException se) {
                        _log.error(se.getLocalizedMessage()); 
                }

                journalFolders.add(entry);
        }
        

        Comparator<JournalFolder> compareByCreateDateDesc = (JournalFolder journalFolder1, JournalFolder journalFolder2) -> 
        journalFolder2.getCreateDate().compareTo( journalFolder1.getCreateDate() );
        Collections.sort(journalFolders, compareByCreateDateDesc);
                
%>

<h3> <liferay-ui:message key="search-results-header" /> <span class="headers search-keywords"> <%= keywords %> </span></h3>

<liferay-ui:search-container delta="5" 
    emptyResultsMessage="no-journalFolders-were-found" 
    total="<%= journalFolders.size() %>"
    iteratorURL="<%= searchURL %>">
        <liferay-ui:search-container-results
                results="<%= ListUtil.subList(journalFolders, searchContainer.getStart(), searchContainer.getEnd())%>"/>
                
	<div class="search-results-div">
	<liferay-ui:search-container-row
	        className="com.liferay.journal.model.JournalFolder"
	        modelVar="journalFolder" escapedModel="<%=true%>">
	        
		<c:set value="<%=journalFolder.getExpandoBridge().getAttribute("Issue number")%>"  var="issueNumber"/>
		<c:set value="<%=NewsletterHelper.formatCreateDate(journalFolder.getCreateDate())%>"  var="formattedCreateDate"/>
		
		<portlet:renderURL var="viewIssueURL">

			<portlet:param name="mvcPath" value="/view_issue.jsp" />
			<portlet:param name="folderId" value="${journalFolder.getFolderId()}" />
			<portlet:param name="issueNumber" value="${journalFolder.getExpandoBridge().getAttribute('Issue number')}" />
				   	   						
		</portlet:renderURL>
				
		<div class="issue-without-article-section">
			<a href="<%= viewIssueURL %>">  
			<h5 class="folder-meta-header non-bold-headers"> Issue: #${issueNumber}, ${formattedCreateDate} </h5>
			<h3 class="folder-name-header headers"> ${journalFolder.getName()}</h3>
			</a>
		</div>
		
	</liferay-ui:search-container-row>
	</div>
        <liferay-ui:search-iterator />
</liferay-ui:search-container>


<%!
        private static Log _log = LogFactoryUtil.getLog("com_liferay_training_amf_newsletter_AmfNewsletterPortlet.view_search_jsp");
%>