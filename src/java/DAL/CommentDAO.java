/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class CommentDAO {

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public List<Comment> getAllCommentOfTeacher(String tId, String subId) {
        List<Comment> list = new ArrayList<>();
        String sql = "select c.cId,c.username,a.aName,c.content,t.tName,t.subId "
                + "from Comment c inner join Teacher t on c.tId = t.tId\n"
                + "inner join Account a on c.username = a.username "
                + "and t.tId = ? and t.subId = ?";
        try {
            cnn = (new DBContext()).getConnection();
            stm = cnn.prepareStatement(sql);
            stm.setString(1, tId);
            stm.setString(2, subId);
            rs = stm.executeQuery();
            while (rs.next()) {
                Comment cmt = new Comment();
                cmt.setId(rs.getInt("cId"));
                cmt.setUsername(rs.getString("username"));
                cmt.setAuthor(rs.getString("aName"));
                cmt.setContent(rs.getString("content"));
                cmt.setTeacher(rs.getString("tName"));
                cmt.setSubId(rs.getString("subId"));
                list.add(0,cmt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void addNewComment(String username, String tId, String subId, String content) {
        String sql = "insert into Comment values(?,?,?,?)";
        try {
            cnn = (new DBContext()).getConnection();
            stm = cnn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, tId);
            stm.setString(3, subId);
            stm.setString(4, content);
            stm.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getContentById(int cId) {
        String sql = "select * from Comment where cId = ?";
        try {
            cnn = (new DBContext()).getConnection();
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, cId);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString("content");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteCommentById(int cId) {
        String sql = "delete from Comment where cId = ?";
        try {
            cnn = (new DBContext()).getConnection();
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, cId);
            stm.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
