<!-- simple JSP rendering test -->
<%@page session="false" import="org.apache.sling.api.resource.*, javax.jcr.*"%>
<%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling"%>
<sling:defineObjects />

<h1>Hello Lala</h1>
<h1><%=resource.adaptTo(ValueMap.class).get("jcr:title")%></h1>
<p><%=resource.adaptTo(ValueMap.class).get("jcr:description")%></p>
