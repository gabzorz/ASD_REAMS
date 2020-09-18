<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <div class="container">
            <form action="?action=login" method="POST">
                <h1 class="jumbotron-heading" style="text-align: center">Login to your Reams user account</h1>
                <div class="form-group">
                    <label for="username">
                        Username
                    </label>
                    <input type="email" class="form-control" id="username" name="username" placeholder="Enter your email address" value="${username}" required>
                </div>
                <div class="form-group">
                    <label for="password">
                        Password
                    </label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </jsp:body>
</t:layout>