<%@page session="false"%><%--
  Copyright 1997-2008 Day Management AG
  Barfuesserplatz 6, 4001 Basel, Switzerland
  All Rights Reserved.

  This software is the confidential and proprietary information of
  Day Management AG, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with Day.

  ==============================================================================

  Toolbar component

  Draws a toolbar of links

--%><%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="java.util.Iterator,
                   com.day.cq.wcm.api.PageFilter" %><%

    // get starting point of toolbar
    Page toolbarParentPage = currentPage.getAbsoluteParent(currentStyle.get("absParent", 2));
    String toolbarParent = toolbarParentPage != null ? toolbarParentPage.getPath() : "";
	boolean listStyle = currentStyle.get("list", false);

    ToolbarFilter filter = new ToolbarFilter(request, currentStyle.get("toolbar", ""));

    // if not deep enough or no "/toolbar" skip
    if (!toolbarParent.equals("")) {
        String toolbarPath = toolbarParent + "/toolbar";
        Resource rootRes = slingRequest.getResourceResolver().getResource(toolbarPath);
        Page rootPage = rootRes == null ? null : rootRes.adaptTo(Page.class);
        if (rootPage != null) {
            if (listStyle) {
                %><ul><%
            }
            Iterator<Page> iter = rootPage.listChildren(filter);
            boolean first = true;
            while (iter.hasNext()) {
                Page child = iter.next();
                boolean last = !iter.hasNext();
                String title = child.getNavigationTitle();
                if (title == null) {
                    title = child.getTitle();
                }
                if (title == null) {
                    title = child.getName();
                }
                if (listStyle) {
                    %><li class="<%= first ? "first " : "" %><%= last ? "last" : ""%>">
                        <a href="<%= xssAPI.getValidHref(child.getPath()) %>.html"><%= xssAPI.encodeForHTML(title) %></a>
                    </li><%
                } else {
                    %><%= first ? "&nbsp;&nbsp;" : "" %><a href="<%= xssAPI.getValidHref(child.getPath()) %>.html" <%= first ? "class=\"first\"":"" %>><%= xssAPI.encodeForHTML(title) %></a><%
                }
                first = false;
            }
            if (listStyle) {
                %></ul><%
            }
        }
	}
%><%!
    private static class ToolbarFilter extends PageFilter {

        private final String toolbar;

        private ToolbarFilter(ServletRequest req, String toolbar) {
            super(req);
            this.toolbar = toolbar;
        }

        @Override
        public boolean includes(Page page) {
            if (!super.includes(page)) {
                return false;
            }
            if (toolbar.length() == 0) {
                return true;
            }
            String[] tbs = page.getProperties().get("cq:toolbars", String[].class);
            if (tbs == null || tbs.length == 0) {
                return true;
            }
            for (String tb: tbs) {
                if (tb.equals(toolbar)) {
                    return true;
                }
            }
            return false;
        }
    }
%>
