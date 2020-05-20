<%-- 
    Document   : main
    Created on : 30/04/2020, 11:47:05 AM
    Author     : CristinaFidelino
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        
        <body style="background: ${user.favCol};">
        
        <% if (user != null) { %>
            <h1>Diary Keeper</h1>
            <p>You are logged in as ${user.email}</p>
            <a href="logout.jsp"> Logout </a>
            <a href="edit.jsp"> My Account </a>
        <% }  else { %>
            <h1>Diary Keeper</h1>
            <p>You are not logged in</p>
            <a href="register.jsp"> Register </a>
        <% } %>
    </body>
</html>
