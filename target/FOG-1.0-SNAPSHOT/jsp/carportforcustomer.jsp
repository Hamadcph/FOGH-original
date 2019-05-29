
<%@page import="Data.Customer"%>
<% System.out.println("krishna + " + request.getSession().getAttribute("customer"));
if (request.getSession().getAttribute("customer") == null) {
        System.out.println("test");
        response.sendRedirect("/FOG/jsp/index.jsp");
    }
    Customer customer = (Customer) request.getSession().getAttribute("customer");
    String email = customer.getEmail();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/FOG/css/carporte.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        Logged in as: <%= email %>
        <table align="center">
            <tr>
                <th colspan="3"> vores carporte </th>
            </tr>
            
            <tr>
                <td colspan="3"> klik på carport for at bestille</td>
            </tr>
            
            <tr>
                <td><a href="order.jsp" target="_blank"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc1PNvYEzetHCaBgUR-KgkuORoBga_KCXtyudhxDIwGW4gDFeeVw"></a>single carport</td>
                <td><a href="order.jsp" target="_blank"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIzNjA1BU_aFzbVW70wbNrSV4U__dRAW3jCbU_H_P3U5Ww7xNDfg" height="160"></a>single carport</td>
                <td><a href="order.jsp" target="_blank"><img src="https://www.lyngsoe.dk/media/1296/una4.png?height=1000&mode=min"></a> moderne carport</td>
                
            </tr>
            
        </table>
    </body>
</html>
