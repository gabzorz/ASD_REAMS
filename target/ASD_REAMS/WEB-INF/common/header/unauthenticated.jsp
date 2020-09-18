<%@ page import="uts.asd.Constants" %><%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 27/08/2020
  Time: 12:48 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final String greeting = "Welcome, Guest";
%>

<strong>
    <%= greeting %>
</strong>
&nbsp;
<a href="<%= Constants.path(true, "login") %>">Login</a>
&nbsp;
<a href="<%= Constants.path(true, "register") %>">Register</a>
