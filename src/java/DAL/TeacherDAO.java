/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Teacher;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class TeacherDAO {

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public int numberFavorsOfTeacher(String tId) {
        int count = 0;
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select count(*) from Review where tId=? and favor =1";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, tId);
            rs = stm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return count;
    }

    public int numberCommentsOfTeacher(String tId) {
        int count = 0;
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select count(*) from Comment where tId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, tId);
            rs = stm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return count;
    }

    public float avgRateOfTeacher(String tId) {
        float rate = 0;
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "SELECT AVG(rate) FROM  Review where tId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, tId);
            rs = stm.executeQuery();
            while (rs.next()) {
                rate = rs.getFloat(1);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return rate;
    }

    private String newTeacherId(String subId) {
        int numId = (int) (Math.random() * (9999 - 0001 + 1) + 1);
        while (checkIdExist(subId + String.format("%04d", numId))) {
            numId = (int) (Math.random() * (9999 - 0001 + 1) + 1);
        }
        return subId + String.format("%04d", numId);
    }

    public void createNewTeacher(String name, String gender, String dob, String image, String intro, String subId) {
        String id = newTeacherId(subId);
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "insert into Teacher values (?,?,?,?,?,?,0,0,0,?)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, name);
            stm.setString(3, image);
            stm.setString(4, gender);
            stm.setDate(5, Date.valueOf(dob));
            stm.setString(6, intro);
            stm.setString(7, subId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    
    
    public void updateTeacherInfo(String id, String name, String gender, String dob, String image, String intro, String subId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "update Teacher set tName = ?,tImage=?,tGender=?,tDob=?,tIntro=?,subId=? where tId = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(7, id);
            stm.setString(1, name);
            stm.setString(2, image);
            stm.setString(3, gender);
            stm.setDate(4, Date.valueOf(dob));
            stm.setString(5, intro);
            stm.setString(6, subId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    
    public void deleteTeacherByTid(String tId) {
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "delete from Teacher where tId = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, tId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public List<Teacher> getAll() {
        List<Teacher> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Teacher t inner join Subject s on t.subId=s.subId";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<String> getAllIdOfTeacher() {
        List<String> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Teacher";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tId"));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateFavorsCommentsAndRates() {
        List<String> list = getAllIdOfTeacher();
        for (String id : list) {
            try {
                cnn = (new DBContext()).getConnection();
                String sql = "update Teacher set tFavors = ?, tRate=?, tComments=? where tId =?";
                stm = cnn.prepareStatement(sql);
                stm.setInt(1, numberFavorsOfTeacher(id));
                stm.setDouble(2, avgRateOfTeacher(id));
                stm.setInt(3, numberCommentsOfTeacher(id));
                stm.setString(4, id);
                stm.executeUpdate();
            } catch (Exception e) {
            }

        }
    }

    public void updateFavorsCommentsAndRates(String tId) {
        int favors = numberFavorsOfTeacher(tId);
        float rate = avgRateOfTeacher(tId);
        int comments = numberCommentsOfTeacher(tId);
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "update Teacher set tFavors = ?, tRate=?, tComments=? where tId =?";
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, favors);
            stm.setFloat(2, rate);
            stm.setInt(3, comments);
            stm.setString(4, tId);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public List<Teacher> getAllTeacherBySid(String sId) {
        List<Teacher> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Teacher t inner join Subject s on t.subId=s.subId where s.sId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, sId);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;

    }

    public List<Teacher> getAllTeacherBySubid(String subId) {
        List<Teacher> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Teacher t inner join Subject s on t.subId=s.subId where t.subId=?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;

    }

    public List<Teacher> getAllTeacherFavorByAccount(String username) {
        List<Teacher> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Teacher t \n"
                    + "left join Subject s on t.subId=s.subId\n"
                    + "left join Review r on t.tId=r.tId and t.subId = r.subId\n"
                    + "where r.username =? and r.favor = 1";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName")));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;

    }

    public Teacher bestRateTeacherOfAll() {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select top 1 * from Teacher t inner join Subject s on t.subId=s.subId order by tRate desc, tFavors desc";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public Teacher getTeacherById(String tId) {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select * from Teacher t inner join Subject s on t.subId=s.subId where tId = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, tId);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public Teacher bestRateTeacherOfsubID(String subId) {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select top 1 * from Teacher t inner join Subject s on t.subId=s.subId where s.subId=? order by tRate desc, tFavors desc";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public Teacher bestRateTeacherOfsID(String sId) {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select top 1 * from Teacher t inner join Subject s on t.subId=s.subId where s.sId=? order by tRate desc, tFavors desc";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, sId);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public Teacher bestFavorTeacherOfAll() {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select top 1 * from Teacher t inner join Subject s on t.subId=s.subId order by tFavors desc, tRate desc ";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public Teacher bestFavorTeacherOfsubID(String subId) {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select top 1 * from Teacher t inner join Subject s on t.subId=s.subId where s.subId=? order by tFavors desc, tRate desc";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public Teacher bestFavorTeacherOfsID(String sId) {
        Teacher t = new Teacher();
        try {
            cnn = (new DBContext()).getConnection();
            String sql = "select top 1 * from Teacher t inner join Subject s on t.subId=s.subId where s.sId=? order by tFavors desc, tRate desc";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, sId);
            rs = stm.executeQuery();
            while (rs.next()) {
                t = new Teacher(rs.getString("tId"),
                        rs.getString("tName"),
                        rs.getString("tGender"),
                        rs.getString("tImage"),
                        rs.getString("tDob"),
                        rs.getString("tIntro"),
                        rs.getInt("tFavors"),
                        rs.getInt("tComments"),
                        rs.getDouble("tRate"),
                        rs.getString("subId"),
                        rs.getString("subName"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return t;
    }

    public List<Teacher> getTeacherContainSearch(String search) {
        List<Teacher> listT = new ArrayList<>();
        for (Teacher t : getAll()) {
            if (t.getName().toLowerCase().contains(search.toLowerCase())) {
                listT.add(t);
            }
        }
        return listT;
    }

    private boolean checkIdExist(String string) {
        for (String s : getAllIdOfTeacher()) {
            if (string.equals(s)) {
                return true;
            }
        }
        return false;
    }


}
