<%-- input.jsp --%>
<jsp:useBean id="book" class="model.Book" scope="session">
  <jsp:setProperty name="book" property="title" value="Head First Servlets and JSP" />
</jsp:useBean>
<html>
  <body>
    <a href="output.jsp">click here</a>
  ${book}
  </body>
</html>