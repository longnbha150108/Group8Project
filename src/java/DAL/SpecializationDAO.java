/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Specialization;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class SpecializationDAO {

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public List<Specialization> getAll() {
        List<Specialization> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Specialization";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Specialization(
                        rs.getString("sId"),
                        rs.getString("sName")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;

    }

    public boolean checkIdExist(String speId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Specialization where sId = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, speId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }

    public void addNewSpecialization(String speId, String speName) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "insert into Specialization values(?,?)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, speId);
            stm.setString(2, speName);
            stm.executeQuery();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public Specialization getSpeById(String sId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Specialization where sId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, sId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return (new Specialization(
                        rs.getString("sId"),
                        rs.getString("sName")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }
}
