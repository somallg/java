<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="com.day.text.Text,
                   com.day.cq.wcm.foundation.Image,
                   com.day.cq.commons.Doctype" %><%
    /* obtain the path for home */
    long absParent = currentStyle.get("absParent", 2L);
    String home = Text.getAbsoluteParent(currentPage.getPath(), (int) absParent);
    /* obtain the image */
    Resource res = currentStyle.getDefiningResource("imageReference");
    if (res == null) {
        res = currentStyle.getDefiningResource("image");
    }
    /* if no image use text link, otherwise draw the image */
    %>
<a href="<%= home %>.html"><%
    if (res == null) {
        %>Home<%
    } else {
        Image img = new Image(res);
        img.setItemName(Image.NN_FILE, "image");
        img.setItemName(Image.PN_REFERENCE, "imageReference");
        img.setSelector("img");
        img.setDoctype(Doctype.fromRequest(request));
        img.setAlt("Home");
        img.draw(out);
    }
    %></a>