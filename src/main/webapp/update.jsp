<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Update</title>
</head>
<body>
<section>
    <jsp:useBean id="task" scope="request" type="com.prodius.module4.lesson29hw.model.Task"/>
    <h1>Write task</h1>
    <form method="post" action="${pageContext.request.contextPath}/create">
        <dl>
            <dt>Name: </dt>
            <dd><input type="text" name="name" value="${task.name}" placeholder="${task.name}" /></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>