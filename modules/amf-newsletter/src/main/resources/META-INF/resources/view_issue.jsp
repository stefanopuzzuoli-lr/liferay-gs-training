<%@ include file="/init.jsp"%>

<link href="/css/main.scss" rel="stylesheet" type="text/css"  />

<%  
	long folderId = Long.parseLong(request.getParameter("folderId")); 
	JournalFolder journalFolder = JournalFolderLocalServiceUtil.getFolder(folderId);
	pageContext.setAttribute("journalFolder", journalFolder);
	String formattedCreateDate = request.getParameter("createDate");
	pageContext.setAttribute("formattedCreateDate", formattedCreateDate);
%>

<c:set value="${journalFolder.getExpandoBridge().getAttribute('Issue number')}"  var="issueNumber"/>
<c:set value="${journalFolder.getExpandoBridge().getAttribute('Byline')}"  var="byline"/>

<div class="issue">
	<h5 class="folder-meta-header headers non-bold-headers"> Issue: #${issueNumber}, ${formattedCreateDate} </h5>
	<h3 class="folder-name-header headers"> ${journalFolder.getName()}</h3>
	<h5 class="folder-meta-header headers non-bold-headers"> ${byline}</h5>
	<p class="issue-description">${journalFolder.getDescription()} </p>
	<ul class="articles-list">
	<c:forEach items = "${foldersToLatestApprovedArticles.get(journalFolder)}" var = "journalArticle">
		<li class="article-list-item"><h4 class="article-item-title headers"> ${journalArticle.getTitle()} </h4><p class="article-paragraphs"> ${journalArticle.getContent().replaceAll("]]>", "")}</p></li>
		
	</c:forEach>
</div>