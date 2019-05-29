package Logic;

import Logic.MapperFacade;
import Data.Carport;
import Data.Customer;
import Data.Mappers.CarportMapper;
import Data.Mappers.CustomerMapper;
import Data.Mappers.MaterialMapper;
import Data.Mappers.RequestMapper;
import Data.Material;
import Data.Request;
import Logic.Exception.CarportException;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import java.sql.SQLException;
import java.util.List;


public class DBFacade implements MapperFacade {
    
    CarportMapper cpm = new CarportMapper();
    CustomerMapper cm = new CustomerMapper();
    MaterialMapper mm = new MaterialMapper();
    RequestMapper rm = new RequestMapper();

    @Override
    public void createCustomer(Customer c) throws SQLException {
         cm.createCustomer(c);
    }


    @Override
    public boolean verifyCustomer(String name, String password) throws SQLException, PasswordFailException {
       return cm.verifyCustomer(name, password);
    }


    @Override
    public Carport getCarport(int id) throws SQLException, CarportException {
        return cpm.getCarport(id);
    }


    @Override
    public boolean createCarportMaterial(Material MM) throws SQLException {
       return mm.createCarportMaterial(MM);
    }


    @Override
    public Customer getCustomer(int id) throws SQLException, UserNotExistingException {
        return cm.getCustomer(id);
    }
    @Override
    public Customer getCustomer(String email) throws UserNotExistingException {
        return cm.getCustomer(email);
    }

    @Override
    public void insertRequest(Request request) {
        rm.insertRequest(request);
    }

    @Override
    public boolean createcarport(Carport c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Request getRequest(int id) {
        return rm.getRequest(id);
    }
        
    public int insertGetRequest(Request request) {
        return rm.insertRequestGetId(request);
    }

    @Override
    public List<Request> getRequests() throws CarportException, UserNotExistingException {
        return rm.getRequests();
    }

   

   

    

   
    

}
