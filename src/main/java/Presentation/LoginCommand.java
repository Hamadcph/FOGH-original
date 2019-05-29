package Presentation;

import Data.Customer;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import Logic.DBFacade;
import Logic.MapperFacade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, UserNotExistingException, PasswordFailException {
        System.out.println("LOGINCOMMAND///////////////////////////////7");
        MapperFacade mf = new DBFacade();
        String email = request.getParameter("email");
        System.out.println(email);
        String password = request.getParameter("pass");
        System.out.println(password);

        if (mf.verifyCustomer(email, password)) {
            Customer customer = mf.getCustomer(email);         
            request.getSession().setAttribute("customer", customer);
            return "loginscreencustomer";
        } else if (email.equals("admin") && password.equals("admin")) {
            return "loginscreenemployee";
        }
        return "index";
    }

}
