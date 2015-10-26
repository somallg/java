<%@ page import="java.util.Enumeration" %>
<%-- chapter10/output.jsp --%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="test" uri="SimpleTagTest" %>
<%@ taglib prefix="do" uri="/web-app/mytaglib" %>
<%@ taglib prefix="yes" uri="MyClassicTag" %>

<% request.setAttribute("city", "Sparta"); %>
<% request.setAttribute("position", "Middle"); %>

<html>

<body>

<my:body >
    <%= request.getAttribute("position") %>
</my:body>

<test:simpleTag></test:simpleTag>

RollIt(): ${test:rollIt()} <br>

(Before) <br>
<%--<do:repeater surprise="${position} ">
${here}
</do:repeater>--%>
<%--<yes:classic>My Body</yes:classic>--%>

(After) <br>

<ol>

    <yes:classic><li>${movie}</li></yes:classic>

</ol>

</body>


</html>