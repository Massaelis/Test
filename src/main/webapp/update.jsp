<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<section>
    <jsp:useBean id="task" scope="request" type="model/Task"/>
    <form method="post" action="task?action=submit">
        <dl>
            <dt>Name: </dt>
            <dd><input type="text" name="name" value="${task.name}" placeholder="${task.name}" /></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>