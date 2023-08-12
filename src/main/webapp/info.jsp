<head>
    <title>Info</title>
</head>
<body>
   <form method="post" action="${pageContext.request.contextPath}/info">
    <h1>Info user</h1>
    <ul>
        <h3>user-agent</h3>
            <p> <%=request.getHeader("user-agent")%><br/></p>
        <h3>browser</h3>
            <%
            String userAgent = request.getHeader("user-agent");
            if (userAgent.indexOf("Safari") > -1) {
                out.println("Your browser is Safari<br/>");
            }else if (userAgent.indexOf("Firefox") > -1){
                out.println("Your browser is Firefox<br/>");
            }else if(userAgent.indexOf("Chrome") > -1){
                out.println("Your browser is Chrome<br/>");
            }else{
                out.println("I don`t now this browser<br/>");
            }
            %>
        <h3>IP address</h3>
            <p> <%=request.getRemoteAddr()%><br/></p>
    </ul>
    <button type="submit">Main page</button>
     </form>
</body>
</html>