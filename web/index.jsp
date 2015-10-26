<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: duongtq
  Date: 7/27/14
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    java.util.List books = new ArrayList();
    books = null;
    request.setAttribute("books", books);
    request.setAttribute("question", "<b>Question</b>");
%>

<html>
  <head>
    <title>Index.jsp Test</title>
  </head>
  <body>
    <h1>Hello World</h1>
    <form method="post" action="processor">
        <input type="submit" value="OK"/>
    </form>

  Cookie JSESSIONID ${cookie.JSESSIONID.value} <br/>

    <c:out value="${question}" />


  <c:choose>
      <c:when test="${not empty books}">
          <br/> My favorite books are:
          <c:forEach var="book" items="${books}">
              <br/> * ${book}
          </c:forEach>
      </c:when>

      <c:otherwise>
          I have nothing in books
      </c:otherwise>
  </c:choose>



  </body>
</html>
