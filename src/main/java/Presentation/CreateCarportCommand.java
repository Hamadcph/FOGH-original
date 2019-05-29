package Presentation;

import Logic.Calculator.MaterialCalc;
import Data.Carport;
import Data.Customer;
import Data.Material;
import Data.MaterialList;
import Data.ShippingAddress;
import Logic.DBFacade;
import Logic.MapperFacade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCarportCommand extends Command{
      private MaterialCalc mc = new MaterialCalc();



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
          MapperFacade MF = new DBFacade();

        //carport
        int length = Integer.parseInt(request.getParameter("Length"));
        int width = Integer.parseInt(request.getParameter("Width"));
        String roof = request.getParameter("Roofstyle");
        int inclination = Integer.parseInt(request.getParameter("Inclined"));
        Carport carport = new Carport(length, width, inclination, roof);

        //customer
        Customer customer = (Customer) request.getSession().getAttribute("customer");

        //address
        String street = request.getParameter("street");
        int zip = Integer.parseInt(request.getParameter("zip"));
        String city = request.getParameter("city");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        ShippingAddress address = new ShippingAddress(street, zip, city, firstname, lastname);

        //material list
        Material m = mc.calculator(carport.getLength(), carport.getWidth(), carport.getInclination(), carport.getRooftype());
        MaterialList ml = new MaterialList(m.getWood_qty(), m.getScrew_qty(), m.getBracket());

        
        
        
//TODO: Create an order using the detail and order created above and link that to costumer
        // then add the variables of the order to session variables 
        Data.Request req = new Data.Request(carport, customer, address, ml);
        MF.insertRequest(req);

        return "orderhasbeenpurchase";
    }
    
}
