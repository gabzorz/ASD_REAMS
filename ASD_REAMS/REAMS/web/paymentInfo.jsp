<%-- 
    Document   : paymentInfo
    Created on : 27/08/2020, 6:26:37 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Payment Information</title>
    </head>
    <body>
        
       
        
        <div class="topnav">
            <ul>
                <li><a href="index.jsp"><img class="logo" src="css/reams_logo.png"/></a></li>
            </ul>
            
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">Find a Property</a>
            <a style="float: left;">News and Reports</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
            <a href="login.jsp"style="float: right;">Login</a>
        </div>
        
        <main class="main-content">
        <h1>Account Information</h1><br>
        
        <div class="sidenav">
            <a href="homepage.jsp">Account Summary</a>
            <a href="paymentInfo.jsp">Payment Information</a>

        </div>
        
        <table border="1" cellpadding="5">
            
            <caption><h2>Linked Accounts</h2></caption>
            <tr>
                <th>Payment ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Account Number</th>
                <th>BSB</th>
                <th></th>
            </tr>
            <c:forEach var="payment" items="${payments}">
                <tr>
                    <td><c:out value="${payment.paymentID}" /></td>
                    <td><c:out value="${payment.firstName}" /></td>
                    <td><c:out value="${payment.lastName}" /></td>
                    <td><c:out value="${payment.accountNumber}" /></td>
                    <td><c:out value="${payment.bsb}" /></td>
<!--                    <td>    
                         <a href="PaymentEditServlet?id=<c:out value ="${payment.paymentID}"/>">Edit Payment</a>
                         <a href="PaymentRemoveServlet?id=<c:out value ="${payment.paymentID}"/>">Delete</a>      
                    </td>-->
                </tr>
            </c:forEach>
        </table>
        </main>
                    
    </body>
</html>
