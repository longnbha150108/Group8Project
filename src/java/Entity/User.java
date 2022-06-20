/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import context.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dthie
 */
public class User {

    String account, pass;

    public User() {
    }

    public User(String account, String pass) {
        this.account = account;
        this.pass = pass;
        connectDB();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean checkLoginAccount() {
        //  return ("admin".equals(account) && "123".equals(pass));
        // kiểm tra xem acc và pas có tồn tại trong tbUser không ?

//        try {
//            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            String strSelect = "select *from tblUser where account= '" + account + "' and pass='" + pass + "'";
//            rs = stm.executeQuery(strSelect);
//            while(rs.next()){
//                return true;
//            }
//
//        } catch (Exception e) {
//            System.out.println("Login Error" + e.getMessage());
//        }return false;

        
try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select *from tblUser where account= '" + account + "' ";
            //strSelect = "select *from tblUser where pass='" + pass + "'";
            rs = stm.executeQuery(strSelect);
            while(rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Login Error" + e.getMessage());
        }return false;
        
        
    } 
    
    public boolean checkLoginPass() {
        //  return ("admin".equals(account) && "123".equals(pass));
        // kiểm tra xem acc và pas có tồn tại trong tbUser không ?

//        try {
//            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            String strSelect = "select *from tblUser where account= '" + account + "' and pass='" + pass + "'";
//            rs = stm.executeQuery(strSelect);
//            while(rs.next()){
//                return true;
//            }
//
//        } catch (Exception e) {
//            System.out.println("Login Error" + e.getMessage());
//        }return false;

        
try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select *from tblUser where pass='"+pass+"' ";
            //strSelect = "select *from tblUser where pass='" + pass + "'";
            rs = stm.executeQuery(strSelect);
            while(rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Login Error" + e.getMessage());
        }return false;
        
        
    }

    //Khai bao cac thanh` phan` xu ly co so du lieu
    Connection cnn; //kết nối cơ sở dữ liệu
    Statement stm; //Thực thi câu lệnh SQL
    ResultSet rs; //Lưu trữ và xử lý dữ liệu

    private void connectDB() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("Connect Successfully.");

        } catch (Exception e) {
            System.out.println("Connect Error:" + e.getMessage());
        }
    }

    public String getNamebyAccount() {
   try {
     
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select *from tblUser where account= '" + account + "'" ;
            rs = stm.executeQuery(strSelect);
            while(rs.next()){
                return rs.getString(3);
            }

        } catch (Exception e) {
            System.out.println("Login Error" + e.getMessage());
        }
   return "";
    }

}

//BTVN
// nhập đúng acc sai pass thì đi đến ForgotPassword.jsp