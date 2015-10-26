<%@ page import="model.MyBean" %>
<%--
  Created by IntelliJ IDEA.
  User: DuongTQ
  Date: 8/7/2014
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    MyBean bean = new MyBean();
    bean.setRoasted(true);
    application.setAttribute("aBean", bean);
%>

<jsp:useBean id="aBean" class="model.MyBean" scope="page" />
<jsp:getProperty name="aBean" property="roasted" />

</body>
</html>
