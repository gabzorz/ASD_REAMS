<%-- 
    Document   : logout
    Created on : 30/04/2020, 11:48:53 AM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <p>You have been logged out. Click <a href = "index.jsp">here</a> to return to main page </p>
        <% session.invalidate(); %>
        <%-- <%response.sendRedirect("index.jsp"); %> --%>
    </body>
</html>
