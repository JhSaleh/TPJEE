<%--
  Created by IntelliJ IDEA.
  User: jeanhanna
  Date: 05/02/2021
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date"%>
<%
String myParameter = request.getParameter("param");
Date now = new Date();
%>

<html>
<head>
    <title>Title</title>
</head>
    <body>
        Hello World
        <p>Valeur du parametre : <%=myParameter%></p>
        <p>Date de la requête : <%=now.toString()%></p>
    </body>
</html>
