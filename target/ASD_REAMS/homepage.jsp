<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<%@ page import="uts.asd.model.user.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome to REAMS</h1>

        <%
            import uts.asd.IoTBayApplicationContext;
            import uts.asd.action.UnauthenticatedAction;
            import uts.asd.model.user.User;
            import uts.asd.util.AuthenticationUtil;

            import javax.servlet.ServletContext;
            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;
            import javax.servlet.http.HttpSession;
            import java.time.LocalDate;
            import java.util.ArrayList;

            @Override
            protected void invoke(ServletContext application, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
            super.invoke(application, session, request, response);

            String userId = request.getParameter("userId");
            String sysAdminId = request.getParameter("sysId");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address = request.getParameter("address");
            String dob = request.getParameter("dob");
            String username = request.getParameter("username");
            String number = request.getParameter("number");
            String password = request.getParameter("password");

            // creates a new user in the database
            final User user = ctx.getUsers().create(new User(userId, sysAdminId, fname, lname, address, dob, username, number, password);

            message = String.format("Registration successful. Welcome %s", user.getUsername());

            }

        %>
        <p>You're logged in as <%= user.getFname()%></p>
        <form method="post" action="logout/index.jsp">
            <input class="bttn" type="submit" value="Logout">
        </form>

        <%
        } else {
        %>
        <p>You're not signed in <a href='register/index.jsp'>register</a> or <a href="login/index.jsp"> login</a></p>
        <%}%>

    </body>
</html>
