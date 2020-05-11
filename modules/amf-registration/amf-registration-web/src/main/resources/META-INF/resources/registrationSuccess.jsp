<%@ include file="/init.jsp" %>

<liferay-ui:success key="userAdded" message="User Registered Successfully." />

<portlet:defineObjects />

<%
	Map<String, String> userMap = (Map<String, String>) renderRequest.getAttribute("userMap");
	if (userMap != null) {
%>
<p>
	<b><liferay-ui:message key="amfregistration.success" arguments="<%=userMap.get("first_name")%>"/></b>
</p>

<%
	}
%>