package Presentation;

import Logic.Exception.CarportException;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import Logic.DBFacade;
import Logic.MapperFacade;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestCommand extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, UserNotExistingException, CarportException, PasswordFailException {
        MapperFacade mf = new DBFacade();
        request.setAttribute("requests", mf.getRequests());
       return "requests";
    }

    
    
}
