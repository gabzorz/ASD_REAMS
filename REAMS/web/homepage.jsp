<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("fname");        
        %>
        
        
        <h1>Welcome to REAMS</h1>
        <p>Welcome <%= name%></p>
        <a href="index.jsp"><button>Logout</button></a>
    </body>
</html>
