<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="java.util.Iterator,
         com.day.cq.wcm.api.PageFilter"%><%
     /* Create a new Page object using the path of the current page */   
      String listroot = properties.get("listroot", currentPage.getPath());
     Page rootPage = pageManager.getPage(listroot);
     /* iterate through the child pages and gather properties */
     if (rootPage != null) {
         Iterator<Page> children = rootPage.listChildren(new PageFilter(request));
         while (children.hasNext()) {
             Page child = children.next();
             String title = child.getTitle() == null ? child.getName() : child.getTitle();
             String date = child.getProperties().get("date","");
             %><div class="item">
             <a href="<%= child.getPath() %>.html"><b><%= title %></b></a>
             <span><%= date %></span><br>
             <%= child.getProperties().get("jcr:description","") %><br>
             </div><%
         }
     }
 %>