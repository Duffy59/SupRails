<%--
  Created by IntelliJ IDEA.
  User: tcrame
  Date: 05/11/18
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Test</title>
</head>
<body>


<c:url value="/train-stations" var="trainStationsUrl">
</c:url>
<c:url value="/trips" var="tripsUrl"></c:url>
<c:url value="/login" var="loginUrl">
</c:url>
<c:url value="/logout" var="logoutUrl">
</c:url>

<div>
  <ul style="list-style: none">
    <li>
      <a href="${trainStationsUrl}" >Stations</a>
      <a href="${tripsUrl}" >Trips</a>
      <a href="${loginUrl}" >login</a>
      <a href="${logoutUrl}" >logout</a>
    </li>
  </ul>
</div>
</body>
</html>
