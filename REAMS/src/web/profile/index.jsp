<%@ page import="uts.asd.util.AuthenticationUtil" %>
<%@ page import="uts.asd.model.user.User" %>
<%@ page import="static uts.asd.util.Validator.isNullOrEmpty" %>
<%@ page import="uts.asd.ReamsApplicationContext" %>
<%--
  Created by IntelliJ IDEA.
  User: Corey
  Date: 27/08/2020
  Time: 4:15 pm
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%
    User user = AuthenticationUtil.user(session);
    request.setAttribute("user", user);
    final ReamsApplicationContext context = ReamsApplicationContext.getInstance(application);

%>
    <t:layout>
        <jsp:body>

       <%-- <a class="btn btn-outline-secondary" href="passwordUpdate/">Update Password.</a>--%>
            <form action="?action=user&type=update" method="post">
                <div class="form-group">
                    <label for="fname">First Name:</label>
                    <input type="text" class="form-control" id="fname" value="${user.fname}" required="true">
                </div>
                <div class="form-group">
                    <label for="lname">Last Name</label>
                    <input type="text" class="form-control" id="lname" value="${user.lname}" required="true">
                </div>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="email" class="form-control" id="username" type="text" name="username" value="${user.username}">
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth:</label>
                    <input type="date" class="form-control" id="dob" value="${user.dob}" required="true">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" value="${user.address}" required="true">
                </div>
                <div class="form-group">
                    <label for="number">Mobile Number:</label>
                    <input type="text" class="form-control" id="number" value="${user.number}" required="true">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </jsp:body>
    </t:layout>
