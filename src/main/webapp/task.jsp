<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Task</title>
</head>
<body>
<section>
    <h3>Task info</h3>
    <jsp:useBean id="task" scope="request" class="com/prodius/module4/lesson29hw/model/Task.java"/>
    <tr>
        <td> Name: ${task.name} </td>
        <td><a href="task?action=update">Update</a></td>
    </tr>
</section>
</html>