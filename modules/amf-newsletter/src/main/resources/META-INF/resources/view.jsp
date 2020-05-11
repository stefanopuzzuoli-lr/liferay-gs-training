<%@ include file="/init.jsp"%>

<%
	List<Integer> years = (List<Integer>) request.getAttribute("years");
	String commaSeparatedYears = (String) request.getAttribute("commaSeparatedYears");
%>

<liferay-ui:tabs names="<%=commaSeparatedYears%>" refresh="<%=false%>">

	<%
		for (Integer year : years) {
	%>
	<!-- Output issue number and create date -->
	<!-- Have a list of months and for each years iterate through it, check if 
	an articale was released in that year and if yes output -->

	<liferay-ui:section>
		Hello world <% out.println(year);%>
		
		<liferay-journal:journal-article articleId="43429" groupId="<%= 20124 %>" languageId="en" showTitle="true"/>
		
	</liferay-ui:section>

	<%
		}
	%>


</liferay-ui:tabs>