<%-- 
    Document   : one
    Created on : 20/04/2020, 1:01:58 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>One</title>
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
        <%
            String submitted = request.getParameter("submitted");
            
            if (submitted != null && submitted.equals("yes")) { %>
                <% if (tos == null) { %>
                    <p>Sorry, you must agree to the Terms of Service</p>
                    <p>Click <a href = "one.jsp">here</a> to go back </p>
                <% } else { %>
                    <h1>Welcome, <%= name %> </h1>
                    <p>Your email is <%= email %> </p>
                    <p>Your password is <%= password %> </p>
                    <p>Your gender is <%= gender %> </p>
                    <p>Your favourite colour is <%= favcol %> </p>
                <% } %>
            <% } else { %>
                <h1>Register</h1>
                
                <form method="post" action="one.jsp">
                 <table>
                    <tr><td>Email</td><td><input type="text" name="email" required = "true"></td></tr>
                    <tr><td>Full Name</td><td><input type="text" name="name" required></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" required> </td></tr>
                    <tr><td>Gender</td><td><input type="radio" id="male" name="gender" value="male">
                        <label for="male">Male</label><br>
                        <input type="radio" id="female" name="gender" value="female">
                        <label for="female">Female</label><br>
                
                    <tr><td>Favourite colour</td><td> 
                        <select id="colours" name="favcol">
                            <option value="Red">Red</option>
                            <option value="Green">Green</option>
                            <option value="Blue">Blue</option>
                            <option value="Yellow">Yellow</option>
                            <option value="orange">orange</option>
                            <option value="pink">pink</option>
                        </select>
                    <tr><td>Agree to TOS</td><td><input type="checkbox" name="tos">
                    <input type="hidden" id="submitted" name="submitted" value="yes">
                </table>
                <div>
                    <a href="index.jsp">Cancel </a>
                    <input type="submit" value="Register"
                </div>            
                </form>
            <% } %>
            
            
    </body>
</html>
