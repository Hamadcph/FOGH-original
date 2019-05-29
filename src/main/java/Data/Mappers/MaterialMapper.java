package Data.Mappers;

import Data.Material;
import Data.Connection.Connector;
import Data.MaterialList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MaterialMapper {
    
    Connection conn;
    CarportMapper cm = new CarportMapper();

    public MaterialMapper() {
        this.conn = new Connector().getConnection();
    }
    
    
    
    public boolean createCarportMaterial(Material M) throws SQLException{
        
        try{
            String sql = "INSERT INTO material_lists(wood_amount, screw_amount, bracket_amount) VALUES(?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, M.getWood_qty());
            pst.setInt(2, M.getScrew_qty());
            pst.setInt(3, M.getBracket());
            //pst.setInt(5, cm.getCarportID(M.getCarport().getLength(), M.getCarport().getWidth(), M.getCarport().getRoof(), M.getCarport().getIncline()));
            pst.executeUpdate();
            return true;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public MaterialList getCarportMaterial(int id) throws SQLException{
        
        try{
            String sql = "SELECT * FROM material_lists WHERE request_id=?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int wood_amount = rs.getInt("wood_amount");
                int screw_amount = rs.getInt("screw_amount");
                int bracket_amount = rs.getInt("bracket_amount");
                return new MaterialList(wood_amount, screw_amount, bracket_amount);
            }
            return null;
        
        } catch(SQLException ex){
            System.out.println(ex);
        }
        return null;
    }
    
}
