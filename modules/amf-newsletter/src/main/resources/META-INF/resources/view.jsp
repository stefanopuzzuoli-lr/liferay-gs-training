<%@ include file="/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" 
    value="/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="${searchURL}"  method="post" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="row">
        <div class="col-md-4">
            <aui:input inlineLabel="left" label="" name="keywords" placeholder="" size="30" />
        </div>

        <div class="col-md-4">
            <aui:button type="submit" value="search" />
        </div>
    </div>

</aui:form>

<liferay-ui:tabs names="${commaSeparatedYears}" refresh="<%=false%>" >

	<c:forEach items = "${years}" var = "year"> 
	
		<liferay-ui:section>
			
			<c:set value="${yearToMonthToFolders.get(year)}" var="monthsToFolders"/>
			
			<!-- Sort months in descending order -->
			<%
				Map<Integer, List<JournalFolder>> monthsToFolders = (Map<Integer, List<JournalFolder>>) pageContext.getAttribute("monthsToFolders");
				List<Integer> keys = new ArrayList(monthsToFolders.keySet());
				Collections.reverse(keys);
				pageContext.setAttribute("keys", keys); 
			%>

			<c:forEach items = "${keys}" var = "monthInInt">
				<!-- Convert month integer to month literal name -->
				<%	
					Integer monthInInt = (Integer) pageContext.getAttribute("monthInInt");
					String monthName= Month.of(monthInInt + 1).name();
					monthName = monthName.substring(0,1) + monthName.substring(1).toLowerCase();
			    	pageContext.setAttribute("monthName", monthName); 
			    %>
				
				<div class="month-div">
				<h3 class="month-name-header"> ${monthName} </h3>
				<c:choose>
    				<c:when test="${!monthsToFolders.get(monthInInt).isEmpty()}">
					
					<c:forEach items = "${monthsToFolders.get(monthInInt)}" var = "journalFolder">
						<c:set value="${journalFolder.getExpandoBridge().getAttribute('Issue number')}"  var="issueNumber"/>
						<c:set value="${journalFolder.getCreateDate()}"  var="createDate"/>
							
						<!-- Convert date to needed format -->
						<%
							Date date = (Date) pageContext.getAttribute("createDate");
						    String formattedCreateDate= NewsletterHelper.formatCreateDate(date);
						    pageContext.setAttribute("formattedCreateDate", formattedCreateDate);
						%>
						
						<portlet:renderURL var="viewIssueURL">

				   	   		<portlet:param name="mvcPath" value="/view_issue.jsp" />
				   	   		<portlet:param name="folderId" value="${journalFolder.getFolderId()}" />
				   	   		<portlet:param name="issueNumber" value="${journalFolder.getExpandoBridge().getAttribute('Issue number')}" />
				   	   						
						</portlet:renderURL>

						<c:set value="${formattedCreateDate}"  var="formattedCreateDate"/>
						<div class="issue-section">
							<a href="<%= viewIssueURL %>">  
								<h5 class="folder-meta-header non-bold-headers"> <liferay-ui:message key="issue-number-label" /> #${issueNumber}, ${formattedCreateDate} </h5>
								<h3 class="folder-name-header headers"> ${journalFolder.getName()}</h3>
								<ul class="articles-list">
								<c:forEach items = "${foldersToLatestApprovedArticles.get(journalFolder)}" var = "journalArticle">
									<li class="article-list-item"><h4 class="article-item-title headers non-bold-headers ">${journalArticle.getTitle()} </h4></li>
								</c:forEach>
								</ul>
							</a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
        			<liferay-ui:message key="no-issues-found" />
   			 	</c:otherwise>
			</c:choose>
			</div>
			</c:forEach>
		</liferay-ui:section>
	</c:forEach>

</liferay-ui:tabs>