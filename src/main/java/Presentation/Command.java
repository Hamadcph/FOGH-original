package Presentation;

import Logic.Exception.CarportException;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {
    
    private static HashMap<String,Command> commands;
    
    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("login", new LoginCommand());
        commands.put("register", new CreateCustomerCommand());
        commands.put("order", new CreateCarportCommand());
        commands.put("requests", new RequestCommand());
        commands.put("logout", new LogOutCommand());
        
    }
    
    static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter( "command" );
        if(commands == null)
        {
            initCommands();
        }
        return commands.getOrDefault(commandName, new DefaultCommand());
    }
    abstract String execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, UserNotExistingException, CarportException, PasswordFailException;

   

 
        
    
}
