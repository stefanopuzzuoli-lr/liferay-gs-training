<%@ include file="/init.jsp"%>

<%
	PortletContext portletContext = portletConfig.getPortletContext();
    String zip = (String) portletContext.getAttribute("zipSearched");
    List<User> users = (List<User>) portletContext.getAttribute("searchResults");
%>

<%
	if (users == null) {
%>

<h3 class="headings">
	<liferay-ui:message key="amfsearchresults.no-search-heading" />
</h3>

<%
	} else {
%>

<h3 class="headings">
	<liferay-ui:message arguments="<%=zip%>"
		key="amfsearchresults.results-heading" />
</h3>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="no-entries-were-found" total="<%=users.size()%>">
	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(users, searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.User" modelVar="user"
		escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text>
			<%
				out.println(user.getFirstName() + " " + user.getLastName().charAt(0) + ". ("
										+ user.getScreenName() + ") - " + user.getEmailAddress());
			%>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	}
%>