<%-- 
    Document   : login
    Created on : 30/04/2020, 12:29:08 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="welcome.jsp">
        <table>
             <tr><td>Email</td><td><input type="text" name="email" required = "true"></td></tr>
             <tr><td>Password</td><td><input type="password" name="password" required> </td></tr>
             <tr><td>Agree to TOS</td><td><input type="checkbox" name="tos">
        </table>
        <div>
            <input type="submit" value="Login"
        </div>
        </form>
    </body>
</html>
