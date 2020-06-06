<%--
  Created by IntelliJ IDEA.
  User: Alizaman
  Date: 24.03.2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Who are you here?</title>
</head>
<body>
<%
    String msg= request.getParameter("msg");
%>
<%=msg%>
</body>
</html>
