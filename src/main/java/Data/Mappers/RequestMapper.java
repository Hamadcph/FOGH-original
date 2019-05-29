package Data.Mappers;

import Data.Carport;
import Data.Connection.Connector;
import Data.Customer;
import Data.MaterialList;
import Data.Request;
import Data.ShippingAddress;
import Logic.Exception.UserNotExistingException;
import Logic.Exception.CarportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestMapper {

    Connection conn;
    CustomerMapper cm = new CustomerMapper();
    CarportMapper carm = new CarportMapper();
    MaterialMapper mm = new MaterialMapper();

    public RequestMapper() {
        this.conn = new Connector().getConnection();
    }

    public ArrayList<Request> getAllRequest() throws SQLException, UserNotExistingException {

        ArrayList<Request> requests = new ArrayList<>();
        Request request = null;
        Customer customer = null;
        String sql = "SELECT * from requests";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {

            int length = rs.getInt("length");
            int width = rs.getInt("width");
            String rooftype = rs.getString("rooftype");
            int inclination = rs.getInt("inclination");
            int woodAmount = rs.getInt("wood_amount");
            int screwAmount = rs.getInt("screw_amount");
            int bracketAmount = rs.getInt("bracket_amount");
            int customerId = rs.getInt("customer_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            int phone = rs.getInt("phone");
            String address = rs.getString("address");
            String email = rs.getString("email");
            String password = rs.getString("password");
            customer = new Customer(customerId, email, password, firstname, lastname, address, phone);
            requests.add(request);

        }
        return requests;
    }

    public Request getRequest(int id)  {

        Request request = null;
        Customer customer = null;
        PreparedStatement pst =null;
        ResultSet rs = null;
        Carport carport = null;
        ShippingAddress sAddress=null;
        MaterialList list = null;
       
        try {

            String sql = "SELECT * FROM requests INNER JOIN customers USING(customer_id) WHERE request_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int phone = rs.getInt("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                customer = new Customer(id, email, password, firstname, lastname, address, phone);
            }
            sql = "SELECT * FROM carports WHERE request_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()) {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String rooftype = rs.getString("rooftype");
                int inclination = rs.getInt("inclination");
                int carportId = rs.getInt("carportId");
                carport = new Carport(carportId, length, width, inclination, rooftype);
            }
            sql = "SELECT * FROM shipping_addresses WHERE request_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()) {
                String street = rs.getString("street");
                int zip =rs.getInt("zip");
                String city = rs.getString("city");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                sAddress=new ShippingAddress(street,zip,city,firstname,lastname);
            }
            sql = "SELECT * FROM material_lists WHERE request_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()) {
                int woodAmount = rs.getInt("wood_amount");
                int screwAmount = rs.getInt("screw_amount");
                int bracketAmount = rs.getInt("bracket_amount");
                list = new MaterialList(woodAmount,screwAmount,bracketAmount);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        request = new Request(id, customer, carport,sAddress,list);
        return request;
    }
    
    public void insertRequest(Request request) {
        Carport carport = request.getCarport();
        ShippingAddress address = request.getAddress();
        Customer customer = request.getCustomer();
        MaterialList ml = request.getList();
        int req_id = 0;
        String sql = "";
        PreparedStatement pst = null;
        
        try{
       
            sql = "INSERT INTO requests (customer_id) VALUES(?)";
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, customer.getId());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()) {
                req_id = rs.getInt(1);
                System.out.println("REQUEST ID IS " + req_id);
            }
        } catch(SQLException e) {
            System.out.println("ex 1 " + e.getMessage());
        }
        try{
            sql = "INSERT INTO carports(request_id, length, width, rooftype, inclination) VALUES(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, req_id);
            pst.setInt(2, carport.getLength());
            pst.setInt(3, carport.getWidth());
            pst.setString(4, carport.getRooftype());
            pst.setInt(5, carport.getInclination());
            pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println("ex 2" + e.getMessage());
        }
        try {
            sql = "INSERT INTO shipping_addresses VALUES(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, req_id);
            pst.setString(2,address.getStreet());
            pst.setInt(3, address.getZip());
            pst.setString(4, address.getCity());
            pst.setString(5, address.getFirstname());
            pst.setString(6, address.getLastname());
            pst.executeUpdate();
        } catch(SQLException ex){
            System.out.println( "ex 3" + ex.getMessage());
        }
        try {
        sql = "INSERT INTO material_lists VALUES(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, req_id);
        pst.setInt(2, ml.getWoodAmount());
        pst.setInt(3, ml.getScrewAmount());
        pst.setInt(4, ml.getBracketAmount());
        pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public int insertRequestGetId(Request request) {
        Carport carport = request.getCarport();
        ShippingAddress address = request.getAddress();
        Customer customer = request.getCustomer();
        MaterialList ml = request.getList();
        int req_id = 0;
        String sql = "";
        PreparedStatement pst = null;
        
        try{
       
            sql = "INSERT INTO requests (customer_id) VALUES(?)";
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, customer.getId());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()) {
                req_id = rs.getInt(1);
                System.out.println("REQUEST ID IS " + req_id);
            }
        } catch(SQLException e) {
            System.out.println("ex 1 " + e.getMessage());
        }
        try{
            sql = "INSERT INTO carports(request_id, length, width, rooftype, inclination) VALUES(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, req_id);
            pst.setInt(2, carport.getLength());
            pst.setInt(3, carport.getWidth());
            pst.setString(4, carport.getRooftype());
            pst.setInt(5, carport.getInclination());
            pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println("ex 2" + e.getMessage());
        }
        try {
            sql = "INSERT INTO shipping_addresses VALUES(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, req_id);
            pst.setString(2,address.getStreet());
            pst.setInt(3, address.getZip());
            pst.setString(4, address.getCity());
            pst.setString(5, address.getFirstname());
            pst.setString(6, address.getLastname());
            pst.executeUpdate();
        } catch(SQLException ex){
            System.out.println( "ex 3" + ex.getMessage());
        }
        try {
        sql = "INSERT INTO material_lists VALUES(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, req_id);
        pst.setInt(2, ml.getWoodAmount());
        pst.setInt(3, ml.getScrewAmount());
        pst.setInt(4, ml.getBracketAmount());
        pst.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return req_id;
    }
    
    
    
    public ShippingAddress getShippingAddress(int requestId){
        ShippingAddress s = null;
        
        try{
            String sql = "SELECT * FROM shipping_addresses WHERE request_id=?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, requestId);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String street = rs.getString("street");
                int zip = rs.getInt("zip");
                String city = rs.getString("city");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                s = new ShippingAddress(street, zip, city, firstname, lastname);
            }
        
        } catch(SQLException ex){
            System.out.println(ex);
        }
        
        return s;
    }
    
     public List<Request> getRequests() throws CarportException, UserNotExistingException {
      
        List<Request> requests = new ArrayList();
      
        Customer customer = null;
        int requestId = 0;
        int customerId = 0;
        int carportId = 0;
        

        try {
            String query = "SELECT requests.request_id, requests.customer_id, carports.carport_id "
                    + "FROM requests join carports using(request_id)";
            Statement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                requestId = rs.getInt("request_id");
                customerId = rs.getInt("customer_id");
                carportId = rs.getInt("carport_id");
                requests.add(new Request(requestId, cm.getCustomer(customerId), carm.getCarport(carportId), getShippingAddress(requestId), mm.getCarportMaterial(requestId)));
            }
        } catch (SQLException e) {
            System.out.println("REQUESTEX: " + e.getMessage());
        }

        return requests;
    }
     
   

}
