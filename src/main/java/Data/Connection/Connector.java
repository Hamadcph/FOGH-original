package Data.Connection;

import java.sql.Connection;
import java.sql.DriverManager;



public class Connector {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/fogdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String id = "root";
    private static String pw = "Hamad2660";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);  // The connection will be released upon program 
            
        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your  ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
}
    
    public static void main(String[] args) {
        
        
    }
    
}