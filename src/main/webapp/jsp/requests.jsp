<%@page import="java.util.List"%>
<%@page import="Data.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Request> requests = (List) request.getAttribute("requests");%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/requests.css" rel="stylesheet" type="text/css">
        <title> requests </title>
    </head>

    <body>
        <%for (Request r : requests) {%>
        <div>
            <h1> requests: </h1>
            <table>
                <tr>
                    <th>Label</th>
                    <th>Value</th>
                </tr>
                <tr>
                    <td>Ordrenummer:</td> 
                    <td><%= r.getId()%></td>
                </tr>
                <tr>
                    <td> Kunde: </td>
                    <td><%= r.getAddress().getFirstname() + " " + r.getAddress().getLastname()%> </td>
                </tr>
                <tr>
                    <td>Leveringsoplysninger:</td>
                    <td><%= r.getAddress().getStreet()%>
                        <%= r.getAddress().getZip()%>, <%= r.getAddress().getCity()%></td>
                </tr>



                <tr> 
                    <td> Carport oplysinger:</td>
                    <td>Bredde: <%= r.getCarport().getWidth()%></td>
                    <td>Længde: <%= r.getCarport().getLength()%></td>
                    <td>Tagtype: <%= r.getCarport().getRooftype()%></td>
                    <td>Hældning: <%= r.getCarport().getInclination()%></td>
                </tr>



                <tr><td>Materialer: </td>
                    <td>Skruer: <%= r.getList().getScrewAmount()%></td>
                    <td>Træ: <%= r.getList().getWoodAmount()%></td>
                    <td>Sten: <%= r.getList().getBracketAmount()%></td>
                </tr>

    </table>
</div>


<%}%>
</body>
</html>
