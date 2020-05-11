<%@ include file="/init.jsp" %>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.assignment-service-error"  arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>'/>
</liferay-ui:error>

<liferay-ui:error key="usernameTakenError" message="error.username-taken-error"/>
<liferay-ui:error key="usernameInvalid" message="error.username-invalid-error"/>
<liferay-ui:error key="firstNameInvalid" message="error.first-name-invalid-error" />
<liferay-ui:error key="lastNameInvalid" message="error.last-name-invalid-error" />
<liferay-ui:error key="emailInvalid" message="error.email-invalid-error" />
<liferay-ui:error key="isMaleInvalid" message="error.isMale-invalid-error" />
<liferay-ui:error key="dobInvalid" message="error.dob-invalid-error" />
<liferay-ui:error key="dobTooYoung" message="error.dob-too-young-error" />
<liferay-ui:error key="homePhoneInvalid" message="error.home-phone-invalid-error" />
<liferay-ui:error key="mobilePhoneInvalid" message="error.mobile-phone-invalid-error" />
<liferay-ui:error key="addressInvalid" message="error.address-invalid-error" />
<liferay-ui:error key="address2Invalid" message="error.address2-invalid-error" />
<liferay-ui:error key="cityInvalid" message="error.city-invalid-error" />
<liferay-ui:error key="stateInvalid" message="error.state-invalid-error" />
<liferay-ui:error key="zipInvalid" message="error.zip-invalid-error" />
<liferay-ui:error key="securityQuestionInvalid" message="error.security-question-invalid-error" />
<liferay-ui:error key="securityAnswerInvalid" message="error.security-answer-invalid-error" />
<liferay-ui:error key="acceptedTouInvalid" message="error.accepted-tou-invalid-error" />
<liferay-ui:error key="password1Invalid" message="error.password1-invalid-error" />
<liferay-ui:error key="password1NoMatchRequirements" message="error.password1-no-match-requirements-error" />
<liferay-ui:error key="password2Invalid" message="error.password2-invalid-error" />
<liferay-ui:error key="passwordsNoMatch" message="error.passwords-no-match-error" />


<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="amfregistration.you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>

		<h2>
			<liferay-ui:message key="amfregistration.header" />
		</h2>
		
		<portlet:actionURL var="addUserURL" name="addUser">
		</portlet:actionURL>
		
		<aui:form action="<%=addUserURL%>" autocomplete='off' method="post"
			name="registrationForm">
		
			<aui:fieldset label="Basic Info">
				<aui:input label="first-name" name="first_name"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
					<aui:validator name="alphanum" />
					<aui:validator name="maxLength">50</aui:validator>
				</aui:input>
				
			<aui:input label="last-name" name="last_name"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
					<aui:validator name="alphanum" />
					<aui:validator name="maxLength">50</aui:validator>
				</aui:input>
				
				<aui:input label="email-address" name="email_address"
					showRequiredLabel="<%=true%>" type="email" value="">
					<aui:validator name="required" />
					<aui:validator name="maxLength">255</aui:validator>
				</aui:input>
				
				<aui:input label="Username" name="username"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
					<aui:validator name="alphanum" />
					<aui:validator name="minLength">4</aui:validator>
					<aui:validator name="maxLength">16</aui:validator>
				</aui:input>
				
				<p>
					<b><liferay-ui:message key="amfregistration.isMale"></liferay-ui:message></b>
				</p>
				<aui:input  cssClass="radio-btn" type="radio" name="male" value="true" label="Yes"></aui:input>
				<aui:input cssClass="radio-btn" type="radio" name="male" value="true" label="No"></aui:input>
		
				<aui:input label="Date of Birth" name="dob" showRequiredLabel="<%=true%>"
					type="Date" value="">
					<aui:validator name="required" />
				</aui:input>
			
				<aui:input id="password1" label="Password" name="password1" showRequiredLabel="<%=true%>"
					type="password" value="">
					<aui:validator name="required" />
					<aui:validator name="minLength">6</aui:validator>
					<aui:validator errorMessage="Password must have minimum 6 characters, must contain one uppercase, one number and one special character." 
        		name="custom">
                function(val, fieldNode, ruleValue) {

                        return val.match("^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$");
                }
        		</aui:validator>
				</aui:input>
				
				<aui:input label="Re-enter Password" name="password2" showRequiredLabel="<%=true%>"
					type="password" value="">
					<aui:validator name="required" />
					<aui:validator name="equalTo">'#<portlet:namespace />password1'</aui:validator>
				</aui:input>
			</aui:fieldset>
			
			<aui:fieldset label="Contact Info">
				<aui:input label="home-phone" name="home_phone"
					showRequiredLabel="<%=false%>" type="text" value="">
					<aui:validator name="minLength">10</aui:validator>
					<aui:validator name="maxLength">10</aui:validator>
					<aui:validator name="digits"/>
				</aui:input>
				
				<aui:input label="mobile-phone" name="mobile_phone"
					showRequiredLabel="<%=false%>" type="text" value="">
					<aui:validator name="minLength">10</aui:validator>
					<aui:validator name="maxLength">10</aui:validator>
					<aui:validator name="digits"/>
				</aui:input>
				
			</aui:fieldset>
			
			<aui:fieldset label="Address Info">
				<aui:input label="Address Line 1" name="address"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
					<aui:validator name="maxLength">255</aui:validator>
				</aui:input>
				
				<aui:input label="Address Line 2" name="address2"
					showRequiredLabel="<%=false%>" type="text" value="">
					<aui:validator name="maxLength">255</aui:validator>
				</aui:input>
				
				<aui:input label="city" name="city"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
					<aui:validator name="maxLength">255</aui:validator>
				</aui:input>
				
				<aui:input label="state" name="state"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input label="zip" name="zip"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
					<aui:validator name="minLength">5</aui:validator>
					<aui:validator name="maxLength">5</aui:validator>
					<aui:validator name="digits"/>
				</aui:input>
		
			</aui:fieldset>
			
			<aui:fieldset label="Other">
				<aui:select label="Security Question" name="security_question"
					showRequiredLabel="<%=true%>">
					<aui:option value="What is your mother's maiden name?">What is your mother's maiden name?</aui:option>
				    <aui:option value="What is the make of your first car?">What is the make of your first car?</aui:option>
				    <aui:option value="What is your high school mascot?">What is your high school mascot?</aui:option>
				    <aui:option value="Who is your favorite actor?">Who is your favorite actor?</aui:option>
					<aui:validator name="required" />
				</aui:select>
				
				<aui:input label="Security Question Answer" name="security_answer"
					showRequiredLabel="<%=true%>" type="text" value="">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input  type="checkbox" name="accepted_tou" value="accept" showRequiredLabel="<%=true%>" label="I have read, understand, and agree with the Terms of Use governing my access to and use of the Acme Movie Fanatics web site.">
					<aui:validator name="required" />
				</aui:input>
				
				
				
			</aui:fieldset>	
			
			<aui:button-row>
				<aui:button cssClass="btn-lg" type="submit" name="addUser" value="Register" />
			</aui:button-row>
		
		</aui:form>

	</c:otherwise>
</c:choose>