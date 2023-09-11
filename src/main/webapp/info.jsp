<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Info</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/info">
    <h1>Info user</h1>
    <ul>
        <h3>user-agent</h3>
        <p><%=request.getHeader("user-agent")%><br/></p>
        <h3>browser</h3>
        <%
            String userAgent = request.getHeader("user-agent");
            if (userAgent.contains("Safari")) {
                out.println("Your browser is Safari<br/>");
            } else if (userAgent.contains("Firefox")) {
                out.println("Your browser is Firefox<br/>");
            } else if (userAgent.contains("Chrome")) {
                out.println("Your browser is Chrome<br/>");
            } else {
                out.println("I don`t now this browser<br/>");
            }
        %>
        <h3>IP address</h3>
        <p><%=request.getRemoteAddr()%><br/></p>
    </ul>
    <button type="submit">Main page</button>
</form>
</body>
</html>