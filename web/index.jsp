<%--
  Created by IntelliJ IDEA.
  User: tcrame
  Date: 05/11/18
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Test</title>
</head>
<body>

<%
  String contextPath = getServletConfig().getServletContext().getContextPath();
%>
<ul>
  <li>
    <a href="<%=contextPath%>/train-stations" >Stations</a>
    <a href="<%=contextPath%>/trips" >Trips</a>
    <a href="<%=contextPath%>/admin/train-stations/add" >Add Train Station</a>
  </li>
</ul>
</body>
</html>
