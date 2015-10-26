<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="com.day.cq.commons.Doctype,
                    com.day.cq.wcm.foundation.Image,
                    com.day.cq.wcm.api.components.DropTarget,
                    com.day.cq.wcm.api.components.EditConfig,
                    com.day.cq.wcm.commons.WCMUtils" %><%
 /* global.jsp provides access to the current resource through the resource object */
        Image img = new Image(resource);
        img.setItemName(Image.NN_FILE, "image");
        img.setItemName(Image.PN_REFERENCE, "imageReference");
        img.setSelector("img");
        img.setDoctype(Doctype.fromRequest(request));
        img.setAlt("Home");
        img.draw(out); %>