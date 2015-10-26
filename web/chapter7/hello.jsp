<%-- hello.jsp --%>
<html>
<body>
<jsp:useBean id="person" class="value.Person" scope="request">
    <jsp:setProperty name="person" property="name" value="Niko"/>
</jsp:useBean>
Hello ${person.name}!!
Hello abc
</body>
</html>