<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: DuongTQ
  Date: 8/5/2014
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<% java.util.Map map = new HashMap();
    map.put("a", "b");
    map.put("b", "c");
    map.put("c", "d");
    request.setAttribute("map", map);
%>

01: map.c ${map.c} <br/>
02: map["c"] ${map["c"]} <br/>
03: map[map.b] ${map[map.b]} <br/>
04: map[c] ${map[c]} <br/>
05: map.map.b ${map.map.b} <br/>

</body>
</html>
