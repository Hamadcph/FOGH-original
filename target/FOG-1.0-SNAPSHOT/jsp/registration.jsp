
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/FOG/css/logincss.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"  crossorigin="anonymous">
    </head>
    <body>
        <div class="login-box">
            <form name = "registration" action="/FOG/Frontcontroller" method="POST">
                <h1> Register </h1>
                <div class="textbox">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="email" placeholder="email" name="email" id ="eid" value="">
                </div>
                <div class="textbox">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="password" placeholder="password" name="pass" id = "psw" value="">
                </div>
                <div class="textbox">
                    <i class="fas fa-info" aria-hidden="true"></i>
                    <input type="text" placeholder="name" name="name" id = "name" value="">
                </div>
                <div class="textbox">
                    <i class="fas fa-info" aria-hidden="true"></i>
                    <input type="text" placeholder="lastname" name="lastname" id = "lname" value="">
                </div>
                <div class="textbox">
                    <i class="fas fa-info" aria-hidden="true"></i>
                    <input type="text" placeholder="adress" name="adr" id = "adress" value="">
                </div>
                  <div class="textbox">
                    <i class="fas fa-info" aria-hidden="true"></i>
                     <input type="tel" placeholder="phonenumber" name="tlf" id = "tlf" value="">
                </div>
                
               
                <input class="btn" type="submit" name="" value="Register">

                <input type="hidden" name="command" value="register">
            </form>

        </div>
    </body>
</html>
