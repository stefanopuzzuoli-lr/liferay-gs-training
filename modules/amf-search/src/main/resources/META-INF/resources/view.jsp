<%@ include file="/init.jsp"%>

<liferay-ui:error key="noSearchPermissionError"
	message="error.no-search-permission-error" />
<liferay-ui:error key="invalidZip"
	message="error.invalid-zip-error" />
<liferay-ui:success key="searchSuccess"
	message="success.search-performed-successfully" />

<h2 class="headings">
	<liferay-ui:message key="amfsearch.caption" />
</h2>

<portlet:actionURL name="searchUsersByZip" var="searchUsersURL">
</portlet:actionURL>

<aui:form action="<%=searchUsersURL%>" autocomplete='off' method="post"
	name="searchUsersByZipFrom">

	<div class="search-form">
		<span class="aui-search-bar"> <aui:input
				inlineField="<%=true%>" label="" name="searched-zip" size="30"
				title="search-entries" type="text">
				<aui:validator name="required" />
				<aui:validator errorMessage="Please enter 5 digits."
					name="minLength">5</aui:validator>
				<aui:validator errorMessage="Please enter 5 digits."
					name="maxLength">5</aui:validator>
				<aui:validator name="digits" />
			</aui:input> <aui:button-row>
				<aui:button cssClass="btn-lg" name="searchUsersByZip" type="submit"
					value="Search" />
			</aui:button-row>
</aui:form>