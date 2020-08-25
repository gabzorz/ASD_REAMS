<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        
        <%
            session.invalidate();
        %>
        <h1>You've successfully logged out from REAMS</h1>
        <p><a href="index.jsp">Click here</a> to return to REAMS</p>
    </body>
</html>
