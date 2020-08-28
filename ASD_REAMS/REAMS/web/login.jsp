<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Login Page</title>
    </head>
    <body>
        
        <div class="topnav">
            <a href="index.jsp" style="float: left"><img class="logo" src="css/reams_logo 2.png"/>
        </div>
        
        <div class="topnav">
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">Find a Property</a>
            <a style="float: left;">News and Reports</a>
            
            <a href="login.jsp"style="float: right;">Login</a>
            <a href="register.jsp"style="float: right;">Register</a>
            <a href="homepage.jsp"style="float: right;">Continue As Guest</a>
        </div>
        
        <h1>Sign in to REAMS</h1>
        <main>
            <form style="text-align: center;" method="post">
            <label for="email">Email address</label>
            <input id="email" name="email" type="text" placeholder="Email Address"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password"/>
            <a class="button" href="index.jsp"> Cancel </a>
            <input class="button" type="submit" value="Login"/><br>
            <p class="instructions">New User? <a href= "register.jsp"> Sign Up Here</p>
        </form>
        </main>   
    </body>
</html>
