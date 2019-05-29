
<%@page import="Data.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getSession().getAttribute("customer") == null) {
        System.out.println("test");
        response.sendRedirect("/FOG/jsp/index.jsp");
    }
    Customer customer = (Customer) request.getSession().getAttribute("customer");
    String email = customer.getEmail();
    System.out.println("CUSTOMER: " + customer);
%>
<html>
    <head>
        <title>Johannes fog lækre carporte</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/FOG/css/fogcss.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"  crossorigin="anonymous">
    </head>
    <body>
        Logged in as: <%= email %>
        <header>
            <div class="main">
                <div class="logo">
                    <img src="https://www.johannesfog.dk/globalassets/header/logo.png"> 
                </div>
                <ul>
                    <li class="active"><a href="#"><i class="fas fa-home"></i> Hjem </a></li>
                    <li><a href="#"><i class="fas fa-address-book"></i> Kontaker </a></li>
                    <li><a> <i class="fas fa-car"></i> Carporte </a>
                        <ul>
                            <li><a href="jsp/carportforcustomer.jsp"> Vores carporte</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fas fa-briefcase"></i>Jobs </a></li>
                    <li><a href="FrontController?command=logout"><i class="fas fa-sign-out-alt"></i> log ud</a></li>
                    

                </ul>
            </div>
            <div class="title">
                <h1> FOG CARPORTE</h1>
            </div>

        </header>
    </body>
</html>
