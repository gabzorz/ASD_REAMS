<%-- 
    Document   : edit
    Created on : 30/04/2020, 12:16:43 PM
    Author     : CristinaFidelino
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            String saved = request.getParameter("save");
        %>
        <h1>My Account</h1>
        <p> <%= (saved != null) ? "Account Information Saved":"" %> </p>
        <form method="post" action="edit.jsp">
            <table>
              
                <tr><td>Email</td><td><input type="text" name="email" value = "${user.email}"></td></tr>
                <tr><td>Full Name</td><td><input type="text" name="name" value = "${user.name}"></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value = "${user.password}"> </td></tr>
                <tr><td>Gender</td><td><input type="radio" id="male" name="gender" value = "${user.gender}">
                        <label for="male">Male</label><br>
                        <input type="radio" id="female" name="gender" value = "${user.gender}">
                        <label for="female">Female</label><br>
                
                <tr><td>Favourite colour</td><td>
                        <select id="colours" name="favcol" value = "${user.favCol}">
                            <option value="Red">Red</option>
                            <option value="Green">Green</option>
                            <option value="Blue">Blue</option>
                            <option value="Yellow">Yellow</option>
                            <option value="orange">orange</option>
                            <option value="pink">pink</option>
                        </select>
            </table>
            <div>
                <input type="submit" value="Save"
                <p>Return to the <a href = "main.jsp">main page</a> </p>
                <input type ="hidden" name="save" value="Saved">
            </div>
        </form>
                        <%
                            String email = request.getParameter("email");
                            String name = request.getParameter("name");
                            String password = request.getParameter("password");
                            String gender = request.getParameter("gender");
                            String favcol = request.getParameter("favcol");
                            
                            user = new User(email, name, password, gender, favcol);
                            session.setAttribute("user",user);
                        %>
    </body>
</html>
