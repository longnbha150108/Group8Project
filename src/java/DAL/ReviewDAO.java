/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author trana
 */
public class ReviewDAO {

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public boolean reviewExist(String username, String tId, String subId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Review where username = ? and tId=? and subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, tId);
            stm.setString(3, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }

    public void updateRate(String username, String tId, String subId, int rate) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "update Review set Rate= ? where username = ? and tId=? and subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, rate);
            stm.setString(2, username);
            stm.setString(3, tId);
            stm.setString(4, subId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void addNewRate(String username, String tId, String subId, int rate) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "insert into Review values (?,?,?,0,?)";
            stm = cnn.prepareStatement(sql);
            stm.setInt(4, rate);
            stm.setString(1, username);
            stm.setString(2, tId);
            stm.setString(3, subId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public int getRate(String username, String tId, String subId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Review where username = ? and tId=? and subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, tId);
            stm.setString(3, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("rate");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return 0;

    }

    public void updateFavor(String username, String tId, String subId) {
        boolean favor = getFavor(username, tId, subId);
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "update Review set Favor= ? where username = ? and tId=? and subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setBoolean(1, !favor);
            stm.setString(2, username);
            stm.setString(3, tId);
            stm.setString(4, subId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void addNewFavor(String username, String tId, String subId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "insert into Review values (?,?,?,1,0)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, tId);
            stm.setString(3, subId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public boolean getFavor(String username, String tId, String subId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Review where username = ? and tId=? and subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, tId);
            stm.setString(3, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getBoolean("favor");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }
}
