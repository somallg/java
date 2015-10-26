<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
    <title>The out and catch JSTL tags</title>
</head>
<body>
<c:catch var="e">
    <%
        out.print(10/0);
    %>
</c:catch>

<c:out value="${e.message}"/>

</body>
</html>