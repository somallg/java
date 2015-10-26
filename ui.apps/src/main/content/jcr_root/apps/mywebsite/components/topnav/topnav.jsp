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
        while (children.hasNext()) {
            Page child = children.next();
            %><a href="<%= child.getPath() %>.html"><img alt="<%= child.getTitle() %>" src="<%= child.getPath() %>.navimage.png"></a><%
        }
    }
%>