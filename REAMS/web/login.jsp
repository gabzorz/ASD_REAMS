<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Sign in to REAMS</h1>
        <form>
            <table>
                <tr>
                    <td><input type="text" placeholder="Enter email address" name="email"></td>
                </tr>
                <tr>
                    <td><input type="password" placeholder="Enter password" name="password"></td>
                </tr>
            </table>
        </form>
        <table>
            <tr>
                <td><a href="index.jsp"><button>Cancel</button></a></td>
                <td><a href="homepage.jsp"><button>Sign in</button></a></td>
            </tr>
            <tr>
                <td><a href="register.jsp">Not a member?</a></td>
            </tr>
        </table>
        
    </body>
</html>
