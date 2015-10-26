<%@ page import="model.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: DuongTQ
  Date: 8/5/2014
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    Product p = new Product("ABC", 0);
    session.setAttribute("product", p);
%>

<jsp:useBean id="product" class="model.Product" scope="page">
    <jsp:setProperty name="product" property="price" value="15"/>
</jsp:useBean>

<%= product.getName() %>
<%= product.getPrice() %>

</body>
</html>
