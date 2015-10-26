<%-- output.jsp --%>
<jsp:useBean id="book" class="model.Book" scope="session"/>
<html>
  <body>
    I like <%= book.getTitle() %>
    ${book.title}
  </body>
</html>