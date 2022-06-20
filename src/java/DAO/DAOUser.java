/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import context.DBContext;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/**
 *
 * @author notur
 */
public class DAOUser extends DBContext{
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public int AddUser(User user) throws Exception{
        int n=0;
        String sql="INSERT INTO [dbo].[tblUser]\n" +
"           ([account]\n" +
"           ,[pass]\n" +
"           )\n" +
"     VALUES\n" +
"           (? ,?  )";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        
        try {

            ps.setString(1, user.getAccount());
            ps.setString(2, user.getPass());
         

            // run
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return n;
    } 
    
    
    
//    public static void main(String[] args) throws Exception {
//        DAOUser user=new DAOUser();
//        int add=user.AddUser(new User("dang", "523"));
//                if (add > 0) {
//            System.out.println("inserted");
//        }
//    }
    
}
