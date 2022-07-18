/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.AccountDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author notur
 */
public class SettingAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
String id=request.getParameter("id");
String student=request.getParameter("Istudent");
String staff=request.getParameter("Istaff");
            
           
             
            
            
            AccountDAO account = new AccountDAO();
           
             
            ArrayList<Account> list = account.getAccountByName(id);
            request.setAttribute("AccountList", list);
             if (id!=null) {
                 request.getRequestDispatcher("SettingAccount.jsp").forward(request, response);
             }
                 
            
            
            String save=request.getParameter(("submit"));
          String submitForStudent=request.getParameter(("submitForStudent"));
            
            String usName=request.getParameter("username");
            String pass=request.getParameter("password");
            String image=request.getParameter("image");
            String Fname=request.getParameter("fullname");
            
            String checkStudent=request.getParameter("thisStudent");
            String checkStaff=request.getParameter("thisStaff");
            boolean isStdn;
            boolean isStff;
            
            if (save!=null) {
                
                // Tao chuc nang Update
                
                
                if (checkStudent!=null) {
                    request.setAttribute("student", "true");
                     isStdn=true;
                }else{
                    request.setAttribute("student", "false");
                     isStdn=false;
                }
                   if (checkStaff!=null) {
                    request.setAttribute("staff", "true");
                    isStff=true;
                    
                }else{
                    request.setAttribute("staff", "false");
                    isStff=false;
                }
                   
                  
                   
                   account.updateAccount(usName, pass, Fname,image   ,isStdn,isStff);
              
                    AccountDAO aDAO = new AccountDAO();
                request.getSession().setAttribute("acc", aDAO.getAccount(usName));
                
                
                     request.getRequestDispatcher("home").forward(request, response);
                   
                 
                   
            }
            
             if (submitForStudent!=null) {
                  account.updateAccount(usName, pass, Fname,image  ,true ,false);
                  
                   AccountDAO aDAO = new AccountDAO();
                  request.getSession().setAttribute("acc", aDAO.getAccount(usName));
                  
                  
                  request.getRequestDispatcher("home").forward(request, response);
             }
             
            
             
                 
            
            
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
