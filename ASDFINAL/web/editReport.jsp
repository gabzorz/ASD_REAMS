<%-- 
    Document   : editReport
    Created on : 25/10/2020, 6:44:03 PM
    Author     : CristinaFidelino
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>Edit Report</title>
        
        <%
            Post post = (Post) session.getAttribute("post");
            User user = (User) session.getAttribute("user");
        %>
    </head>
    <body>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">Find a Property</a>
            <a style="float: left;">Find Agents</a>
            <a style="float: left;">For Owners</a>
            <a href="newsReport.jsp"style="float: left;">Real Estate News</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <form method="post" action="PostEditServlet" style="text-align: center;">
            <h1>Edit Report</h1>
            <label for="title">Post Title</label>
            <input id="title" name="title" type="text" required="true" placeholder="Post Title"/>
            <label for="category">Category</label>
            <input id="category" name="category" type="text" required="true" placeholder="Category"/>
            <label for="content">Post Content</label>
            <input id="content" name="content" type="text" style="height:300px; width: 500px" required="true" placeholder="Content"/>
            
            <br>
            
            <div>
                <a class="button" href="newsReport.jsp"> Cancel </a>
                <input class="button" type="submit" value="Save Report"/><br>
            </div>
        </form>
    </body>
</html>
