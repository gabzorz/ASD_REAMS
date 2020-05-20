<%-- 
    Document   : register
    Created on : 06/04/2020, 12:52:20 PM
    Author     : CristinaFidelino
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body bgcolor = "#add8e6">
        <h1>Register</h1>
        
        <form method="post" action="welcome.jsp">
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
                
            </table>
            <div>
                <a href="index.jsp"> Cancel </a>
                <input type="submit" value="Register"
            </div>
        </form>
    </body>
</html>
