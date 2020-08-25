<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome to REAMS</h1>

        <%
            User user = new User();

            String userId = request.getParameter("userId");
            String sysAdminId = request.getParameter("sysId");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address = request.getParameter("address");
            String dob = request.getParameter("dob");
            String emailAddress = request.getParameter("email");
            String number = request.getParameter("number");
            String password = request.getParameter("password");

            session.setAttribute("name", user);

            user.setUserId(userId);
            user.setSysAdminId(sysAdminId);
            user.setFname(fname);
            user.setLname(lname);
            user.setAddress(address);
            user.setDob(dob);
            user.setEmailAddress(emailAddress);
            user.setNumber(number);
            user.setPassword(password);

            if (user.getFname() != null) {

        %>
        <p>You're logged in as <%= user.getFname()%></p>
        <form method="post" action="logout.jsp">
            <input class="bttn" type="submit" value="Logout">
        </form>

        <%
        } else {
        %>
        <p>You're not signed in <a href='register.jsp'>register</a> or <a href="login.jsp"> login</a></p>
        <%}%>

    </body>
</html>
