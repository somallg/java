<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="java.util.Iterator,
        com.day.text.Text,
        com.day.cq.wcm.api.PageFilter, com.day.cq.wcm.api.Page" %><%
    /* get starting point of navigation */
    Page navRootPage = currentPage.getAbsoluteParent(2);
    if (navRootPage == null && currentPage != null) {
    navRootPage = currentPage;
    }
    if (navRootPage != null) {
        Iterator<Page> children = navRootPage.listChildren(new PageFilter(request));

        pageContext.setAttribute("children", children);
    }
%>

<ul>
	<c:forEach var="child" items="${children}">
    	<li><a href="${child.path}.html">${child.title}</a></li> 
	</c:forEach>
</ul>