<%
    java.util.Map names = new java.util.HashMap();
    names.put("0", "Rihanna");
    names.put("1", "Lopez");
    names.put("2", "Kylie");

    request.setAttribute("names", names);
    request.setAttribute("0", "10");
    request.setAttribute("a", "0");
    request.setAttribute("12", "12-");

    request.setAttribute("1007", Integer.valueOf(10));
%>

<html>
<body>
Result of names["0"] is ${names["0"]}!! <br>
Result of "0" is ${"0"}!! <br>
Result of 0 is ${0}!! <br>
Result of names[0] is ${names[0]}!! <br>
Result of "1007" is ${"1007" } <br>
Result of requestScope["1007"] is ${requestScope["1007"] } <br>
</body>
</html>