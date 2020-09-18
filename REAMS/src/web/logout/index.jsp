<%@ page import="uts.asd.Constants" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            final String action = String.format("%s?action=logout", Constants.path(false));
            response.sendRedirect(action);
        %>

