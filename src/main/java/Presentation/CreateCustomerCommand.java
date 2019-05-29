package Presentation;

import Data.Customer;
import Logic.DBFacade;
import Logic.MapperFacade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCustomerCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        MapperFacade mf = new DBFacade();
        String pass = request.getParameter("pass");
        String fname = request.getParameter("name");
        String lname = request.getParameter("lastname");
        String adress = request.getParameter("adr");
        int cphone = Integer.parseInt(request.getParameter("tlf"));
        String mail = request.getParameter("email");
        System.out.println("///////////////////");
        System.out.println("KHARA : " + pass + fname + lname + adress + cphone + mail); 
        System.out.println("///////////////////");

        
        String command = request.getParameter("command");
        
        Customer c = new Customer(mail,pass,fname,lname,adress,cphone);
        
        if(command != null && command.equals("register") && pass != null)
        {
           mf.createCustomer(c); 
           return "index";
        }
        return "registration";
    }

   
    
    
}
