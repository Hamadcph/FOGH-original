
<%@page import="Data.Customer"%>
<%@page import="Data.Carport"%>
<%@page import="Data.Mappers.CarportMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <%
            if(request.getSession().getAttribute("customer")==null)
            {
              response.sendRedirect("/FOG/index.jsp");
            }           
    Customer customer = (Customer) request.getSession().getAttribute("customer");
    String email = customer.getEmail();
                 
  %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/FOG/css/order.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"  crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
         Logged in as: <%= email %>
        <h1>Order a carport!</h1>
        <div class="master">
        <form name="order" action ="/FOG/FrontController" method="POST">
                            <div class="box">
                    <label> Vælge længden: <i class="fas fa-arrow-down"></i><br></label>
                    <select name="Length" required >                        
                        <option  value="3">3 m  </option>
                        <option  value="4">4 m</option>
                        <option value="5">5 m</option>
                        <option value="6">6 m</option>
                        <option value="7">7 m</option>
                    </select>
                    <br>
                    <label>Vælge Bredden: <i class="fas fa-arrow-down"></i><br></label>
                    <select name="Width" required>                        
                        <option value="2">2 m</option>
                        <option  value="3">3 m</option>
                        <option value="4">4 m</option>
                        <option value="5">5 m</option>

                    </select>
                    <br>
                    <label >Vælge Roof:<i class="fas fa-arrow-down"></i> <br></label>
                    <select name="Roofstyle" required>                        
                        <option value="Roofstyle">roof</option>
                    </select>
                    <br>
                    <label>Vælge Inclined: <i class="fas fa-arrow-down"></i><br></label>
                    <select name="Inclined" required>                        
                        <option value="25">45 grader</option>
                        <option value="35">35 grader</option>
                        
                    </select>
                    <br>
                    <br>
                    <input type="text" name="firstname" placeholder="Fornavn">
                    <input type="text" name="lastname" placeholder="Efternavn">
                    <input type="text" name="street" placeholder="Gade">
                    <input type="number" name="zip" placeholder="Postnummer">
                    <input type="text" name="city" placeholder="By">
                    <input type="hidden" name="command" value="order">

                    <div>        
                        <div>
                            <button type="submit">Send order</button>
                        </div>
                    </div>
        
                    


                </div>
            </form>
        </div>
            
    </body>
</html>
