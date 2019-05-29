
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/FOG/css/login.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"  crossorigin="anonymous">
        
    </head>
    <body>
        <div class="login-box">
            
            <form name ="login" action="/FOG/FrontController" method="get">
                <h1> Login </h1>
                <div class="textbox">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Email" name="email" value="">
                </div>
                <div class="textbox">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="Password" name="pass" value="">
                </div>
                <input class="btn" type="submit" name="" value="login">
                <input type="hidden" name="command" value="login">
            </form>  
            
        </div>
    </body>
</html>

