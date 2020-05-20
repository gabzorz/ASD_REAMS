<%-- 
    Document   : welcome
    Created on : 06/04/2020, 1:10:53 PM
    Author     : CristinaFidelino
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String favcol = request.getParameter("favcol");
            String tos = request.getParameter("tos");
            
        %>
        
         <body style="background: <%= favcol %>;">


        <% if (tos == null) { %>
            <p>Sorry, you must agree to the Terms of Service</p>
            <p>Click <a href = "register.jsp">here</a> to go back </p>
        <% } else { %>
            <h1>Welcome, <%= name %> </h1>
            <p>Your email is <%= email %> </p>
            <p>Your password is <%= password %> </p>
            <p>Your gender is <%= gender %> </p>
            <p>Your favourite colour is <%= favcol %> </p>
            <p>Click <a href = "main.jsp">here</a> to proceed to main page </p>
        <% } %>
        
        <% 
            User user = new  User(email, name, password, gender, favcol);
            session.setAttribute("user",user);
        %>
    </body>
</html>
