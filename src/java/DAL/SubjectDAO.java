/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class SubjectDAO {

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public List<Subject> getAll() {
        List<Subject> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Subject";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(
                        rs.getString("subId"),
                        rs.getString("subName"),
                        rs.getString("sId")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;

    }

    public List<Subject> getAllSubjectBySid(String sId) {
        List<Subject> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Subject where sId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, sId);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(
                        rs.getString("subId"),
                        rs.getString("subName"),
                        rs.getString("sId")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;

    }

    public List<Subject> getSubjectContainSearch(String search) {
        List<Subject> listSub = new ArrayList<>();
        for (Subject sub : getAll()) {
            if (sub.getName().toLowerCase().contains(search.toLowerCase())) {
                listSub.add(sub);
            }
        }
        return listSub;
    }

    public Subject getSubjectById(String subId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Subject where subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return (new Subject(
                        rs.getString("subId"),
                        rs.getString("subName"),
                        rs.getString("sId")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public boolean checkIdExist(String subId) {
         try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Subject where subId = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return false;
    }

    public void addNewSubject(String subId, String subName, String sId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "insert into Subject values(?,?,?)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, subId);
            stm.setString(2, subName);
            stm.setString(3, sId);
            stm.executeQuery();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

}
