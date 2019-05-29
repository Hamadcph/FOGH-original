package Data.Mappers;

import Data.Connection.Connector;
import Data.Customer;
import Logic.Exception.PasswordFailException;
import Logic.Exception.UserNotExistingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMapper {

    Connection conn;

    public CustomerMapper() {
        this.conn = new Connector().getConnection();
    }

    public void createCustomer(Customer c) throws SQLException {

        try {
            String sql = "INSERT INTO customers(firstname, lastname, address, phone, password, email) VALUES(?,?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, c.getFirstname());
            pst.setString(2, c.getLastname());
            pst.setString(3, c.getAddress());
            pst.setInt(4, c.getPhone());
            pst.setString(5, c.getPassword());
            pst.setString(6, c.getEmail());

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("not working" + ex.getMessage());

        }

    }

    public Customer getCustomer(int id) throws UserNotExistingException {
        Customer c = null;
        try {
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                c = new Customer(id, email, password, firstname, lastname, address, phone);

            }
            else {
            throw new UserNotExistingException("User doest not exist!");
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }
    public Customer getCustomer(String email) throws UserNotExistingException {
        Customer c = null;
        try {
            String sql = "SELECT * FROM customers WHERE email =?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("customer_id");
                String password = rs.getString("password");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                c = new Customer(id, email, password, firstname, lastname, address, phone);

            }
            else {
            throw new UserNotExistingException("User doest not exist!");
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public boolean verifyCustomer(String email, String password) throws PasswordFailException {

        try {
            String sql = "SELECT email, password FROM customers WHERE email=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            
            ResultSet rs = pst.executeQuery();
            System.out.println("PASSWORD = " + password);
            if (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    return true;
                }
                else {
            throw new PasswordFailException("Password doest not match!");
        }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }


}
