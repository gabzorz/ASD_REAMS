<%@ page import="uts.asd.model.user.User" %>
<%@ page import="uts.asd.util.AuthenticationUtil" %>
<%@ page import="uts.asd.Constants" %><%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 27/08/2020
  Time: 12:48 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final User user = AuthenticationUtil.user(session);
%>
<strong>
    Welcome, <a href="<%= Constants.path(true, "profile") %>"><%= user.getUsername() %></a>
</strong>
<a href="<%= Constants.path(true, "logout") %>">Logout</a>
