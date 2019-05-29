package unit.tests;

import Data.Carport;
import Data.Customer;
import Data.MaterialList;
import Data.Request;
import Data.ShippingAddress;
import Logic.DBFacade;
import Logic.Exception.CarportException;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DBFacadeTest {
    static DBFacade db;
    
    public DBFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        db = new DBFacade(); 
        
    }
    @Test
    public void testCreateGetCustomer() throws SQLException, UserNotExistingException {
        Customer c = new Customer("test@junit.dk", "junitpsw", "jUnit", "Test", "Mainframe", 12345678);
        db.createCustomer(c);
        Customer result = db.getCustomer("test@junit.dk");
        assertNotNull(result);
        assertEquals(c.getEmail(), result.getEmail());
        assertEquals(c.getPassword(), result.getPassword());
        assertEquals(c.getFirstname(), result.getFirstname());
        assertEquals(c.getLastname(), result.getLastname());
        assertEquals(c.getPhone(), result.getPhone());
        assertEquals(c.getAddress(), result.getAddress());  
    }
    @Test
    public void testVerifyCustomer() throws SQLException, PasswordFailException {
        boolean login = db.verifyCustomer("test@junit.dk", "junitpsw");
        assertTrue(login);
    }
    
    @Test 
    public void testCreateGetRequest() throws CarportException, UserNotExistingException {
        Customer c = db.getCustomer("test@junit.dk");
        Carport ca = new Carport(5, 3, 35, "FlatRoof");
        MaterialList ml = new MaterialList(2, 2, 4);
        ShippingAddress sa = new ShippingAddress("Mainframe", 1234, "Mainframe", "jUnit", "Test");
        Request r = new Request(ca, c, sa, ml);
        int id = db.insertGetRequest(r);
        Request result = db.getRequest(id);
        assertNotNull(result);
        assertEquals(r.getCustomer().getEmail(), result.getCustomer().getEmail());
        assertEquals(r.getCustomer().getFirstname(), result.getCustomer().getFirstname());
        assertEquals(r.getCustomer().getLastname(), result.getCustomer().getLastname());
        assertEquals(r.getCustomer().getPassword(), result.getCustomer().getPassword());
        assertEquals(r.getCustomer().getPhone(), result.getCustomer().getPhone());
        assertEquals(r.getCustomer().getAddress(), result.getCustomer().getAddress());
        
    }
}
