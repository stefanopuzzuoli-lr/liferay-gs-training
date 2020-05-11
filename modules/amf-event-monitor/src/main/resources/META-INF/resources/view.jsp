<%@ include file="/init.jsp"%>

<!-- Three tabs All - Registration - Login -->

<liferay-ui:tabs names="All,Registration,Login" refresh="<%=false%>">

	<!-- The first tab section displays registration and login events (if any) -->
	<liferay-ui:section>
		<% 
		 	List<AMFEvent> events = (List<AMFEvent>) request.getAttribute("all-events");
		%>
   <liferay-ui:search-container delta="20" 
    emptyResultsMessage="no-entries-were-found" 
    total="<%= events.size() %>">
        <liferay-ui:search-container-results
                results="<%= ListUtil.subList(events, searchContainer.getStart(), searchContainer.getEnd())%>"/>
      
       <liferay-ui:search-container-row
        className="com.liferay.amf.event.monitor.s.model.AMFEvent"
        keyProperty="auditEventId" modelVar="entry" escapedModel="<%=true%>">
        
       		<liferay-ui:search-container-column-text />
           
        </liferay-ui:search-container-row>
        
        <liferay-ui:search-iterator />
   </liferay-ui:search-container>
	</liferay-ui:section>

	<!-- The second tab section displays only registration events (if any) -->
	<liferay-ui:section>
			<% 
		 	List<AMFEvent> registrations = (List<AMFEvent>) request.getAttribute("all-registrations");
			%>
		   <liferay-ui:search-container delta="20" 
		    emptyResultsMessage="no-entries-were-found" 
		    total="<%= registrations.size() %>">
		        <liferay-ui:search-container-results
		                results="<%= ListUtil.subList(registrations, searchContainer.getStart(), searchContainer.getEnd())%>"/>
		      
		       <liferay-ui:search-container-row
		        className="com.liferay.amf.event.monitor.s.model.AMFEvent"
		        keyProperty="auditEventId" modelVar="registration" escapedModel="<%=true%>">
		        
		       		<liferay-ui:search-container-column-text />
		           
		        </liferay-ui:search-container-row>
		        
		        <liferay-ui:search-iterator />
		   </liferay-ui:search-container>
	</liferay-ui:section>

	<!-- The third tab section displays only login events (if any) -->
	<liferay-ui:section>
			<% 
		 	List<AMFEvent> logins = (List<AMFEvent>) request.getAttribute("all-logins");
			%>
		   <liferay-ui:search-container delta="20" 
		    emptyResultsMessage="no-entries-were-found" 
		    total="<%= logins.size() %>">
		        <liferay-ui:search-container-results
		                results="<%= ListUtil.subList(logins, searchContainer.getStart(), searchContainer.getEnd())%>"/>
		      
		       <liferay-ui:search-container-row
		        className="com.liferay.amf.event.monitor.s.model.AMFEvent"
		        keyProperty="auditEventId" modelVar="login" escapedModel="<%=true%>">
		        
		       		<liferay-ui:search-container-column-text />
		           
		        </liferay-ui:search-container-row>
		        
		        <liferay-ui:search-iterator />
		   </liferay-ui:search-container>
	</liferay-ui:section>
</liferay-ui:tabs>


