<%
    request.setAttribute("email", null);
    session.setAttribute("email", null);
    pageContext.setAttribute("email", null);
    application.setAttribute("email", "application@info");
%>
<html>
<body>Contact an administrator at ${email}.
</body>
</html>
