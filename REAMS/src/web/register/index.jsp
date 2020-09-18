<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <h1>Register</h1>
        <form action="?action=register" method="post">
            <table style="align-content: center">
                <tr><td>First Name:</td><td><input type="text" placeholder="Enter first name" name="fname" required="true"></td></tr>
                <tr><td>Last Name:</td><td><input type="text" placeholder="Enter last name" name="lname" required="true"></td></tr>
                <tr><td>Email:</td><td><input type="text" placeholder="Enter email" name="username" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="Enter password" name="password" required="true"></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" required="true"></td></tr>
                <tr><td>Address:</td><td><input type="text" placeholder="Enter Address" name="address" required="true"></td></tr>
                <tr><td>Contact number:</td><td><input type="text" placeholder="Enter contact number" name="number" required="true"></td></tr>

            </table>
       
        <table>
            <tr>
                <td><a href="../"><button>Cancel</button></a></td>
                <td><input type="submit" value="Register"></td>
            </tr>
            <tr>
                <td><a href="../login/">Already a member?</a></td>
            </tr>
        </table>
 </form>
    </jsp:body>
</t:layout>

