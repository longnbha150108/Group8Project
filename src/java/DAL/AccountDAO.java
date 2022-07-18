/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author trana
 */
public class AccountDAO {
 Statement stmm;
    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public boolean checkLoginSuccess(String username, String password) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Account where username = ? and password = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }

    public boolean checkAccountExist(String username) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Account where username = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }

    public boolean checkInfoTrue(String username, String name) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Account where username = ? and aName = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }

    public void updatePass(String username, String password) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "update Account set password= ? where username= ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, username);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public Account getAccount(String username) {
        Account a = new Account();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Account where username = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setImage(rs.getString("aImage"));
                a.setName(rs.getString("aName"));
                a.setIsStaff(rs.getBoolean("isStaff"));
                a.setIsStudent(rs.getBoolean("isStudent"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return a;
    }
    
    
//    public Account getAccount(String username) {
//        Account a = new Account();
//        try {
//            cnn = (new DBContext()).getConnection();
//            String sql = "select * from Account where username = ?";
//            stm = cnn.prepareStatement(sql);
//            stm.setString(1, username);
//            rs = stm.executeQuery();
//            while (rs.next()) {
//                a.setUsername(rs.getString("username"));
//                a.setPassword(rs.getString("password"));
//                a.setImage(rs.getString("aImage"));
//                a.setName(rs.getString("aName"));
//                a.setIsStaff(rs.getBoolean("isStaff"));
//                a.setIsStudent(rs.getBoolean("isStudent"));
//            }
//        } catch (Exception e) {
//            System.out.println("Error" + e);
//        }
//        return a;
//    }

    public void updateInfo(String username, String name, String image) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "update Account set aName= ? , aImage=? where username= ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, image);
            stm.setString(3, username);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void insertNewAccount(String username, String password, String image, String name) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "insert into Account values (?,?,?,?,1,0)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, image);
            stm.setString(4, name);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public ArrayList<Account> getAll() {
        ArrayList<Account> list = new ArrayList<Account>();

        try {

            cnn = (new DBContext()).getConnection();
            String sql = "select * from Account";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String image = rs.getString(3);
                String AccountName = rs.getString(4);
                boolean isStudent = rs.getBoolean(5);
                boolean isStaff = rs.getBoolean(6);

                list.add(new Account(username, password,   image,AccountName, isStudent, isStaff));
            }
        } catch (Exception e) {
            System.out.println("List error:" + e.getMessage());
        }

        return list;
    }

    public ArrayList<Account> getAccountByName(String name) {
        ArrayList<Account> list = new ArrayList<Account>();

        try {

            cnn = (new DBContext()).getConnection();
            String sql = "select * from Account where username='" + name + "'";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String image = rs.getString(3);
                String AccountName = rs.getString(4);
                boolean isStudent = rs.getBoolean(5);
                boolean isStaff = rs.getBoolean(6);

                list.add(new Account(username, password, image, AccountName, isStudent, isStaff));
            }
        } catch (Exception e) {
            System.out.println("List error:" + e.getMessage());
        }

        return list;
    }

    public void updateAccount(String username, String password, String  image , String   fullname , boolean isStaff, boolean isStudent) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "UPDATE [Account]\n"
                    + "   SET  [password] = ?\n"
                    + "      ,[aImage] =?\n"
                    + "      ,[aName] = ?\n"
                    + "      ,[isStudent] = ?\n"
                    + "      ,[isStaff] = ?\n"
                    + " WHERE username=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(6, username);

            stm.setString(1, password);
            stm.setString(2, image);
            stm.setString(3, fullname);
            stm.setBoolean(4, isStaff);
            stm.setBoolean(5, isStudent);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

   public void deletebyId(String id) {
        try {
             cnn = (new DBContext()).getConnection();
             String strDelete = "DELETE FROM [Account]  WHERE  username='"+id+"'";
           stmm =  cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             
            stmm.execute(strDelete);
            
        } catch (Exception e) {
            System.out.println("Delete error:" + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        AccountDAO d= new AccountDAO();
 
       
    }
}
