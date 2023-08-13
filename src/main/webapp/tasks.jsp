<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <title>Tasks</title>
</head>
<body>
   <form method="post" action="${pageContext.request.contextPath}/show">
    <h1>Tasks</h1>
    <ul>
      <% List<String> names = (List<String>) request.getAttribute("names"); %>
      <% for (String name : names) { %>
      <% if (!name.isEmpty())  { %>
        <li><%= name %></li>
      <% } %>
      <% } %>
    </ul>
    <button type="submit">Main page</button>
     </form>
</body>
</html>