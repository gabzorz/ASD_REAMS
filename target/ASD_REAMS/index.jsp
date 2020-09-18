
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <jsp:include page="/WEB-INF/common/banner.jsp"/>
        <table>
            <tr>
                <td><a href="login/index.jsp"><button>Login</button></a></td>
                <td><a href="register/index.jsp"><button>Register</button></a></td>
                <td><a href="homepage.jsp"><button>Continue as guest</button></a></td>
            </tr>
        </table>
    </jsp:body>
</t:layout>

