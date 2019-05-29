package Logic;

import Data.Carport;
import Data.Customer;
import Data.Material;
import Data.Request;
import Logic.Exception.CarportException;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import java.sql.SQLException;
import java.util.List;

public interface MapperFacade {
     // CustomerMapper
     public void createCustomer(Customer c) throws SQLException;
     public Customer getCustomer(String email) throws UserNotExistingException ;
     public Customer getCustomer(int id) throws SQLException, UserNotExistingException;
     public boolean verifyCustomer(String name, String password) throws SQLException, PasswordFailException;
  
     //request mapper
     public void insertRequest(Request request);
     public Request getRequest(int id);
     // CarportMapper
     public boolean createcarport(Carport c) throws SQLException;
     public Carport getCarport(int id) throws SQLException, CarportException;
    
     // OrderlineMapper
     public boolean createCarportMaterial(Material MM) throws SQLException;
     
     // OrdersMapper
//     public void createOrders(Orders od) throws SQLException;
//     public Orders getCustomerOrderByCustomer(Customer c);
    
    public List<Request> getRequests() throws CarportException, UserNotExistingException;

    }
