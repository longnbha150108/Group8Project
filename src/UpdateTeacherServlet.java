/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.SubjectDAO;
import DAL.TeacherDAO;
import Model.Subject;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author trana
 */
public class UpdateTeacherServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String cud = request.getParameter("cud");
            SubjectDAO subDAO = new SubjectDAO();
            List<Subject> listSub = subDAO.getAll();
            request.setAttribute("listSub", listSub);
            if (cud.equals("create")) {
                request.setAttribute("title", "Create Teacher");
                request.getRequestDispatcher("UpdateTeacher.jsp").forward(request, response);
            }
            if (cud.equals("update")) {
                String tId = request.getParameter("tId");
                TeacherDAO tDAO = new TeacherDAO();
                Teacher t = tDAO.getTeacherById(tId);
                request.setAttribute("title", "Update Teacher Info");
                request.setAttribute("t", t);
                request.getRequestDispatcher("UpdateTeacher.jsp").forward(request, response);
            }
            if (cud.equals("delete")) {
                String tId = request.getParameter("tId");
                TeacherDAO tDAO = new TeacherDAO();
                Teacher t = tDAO.getTeacherById(tId);
                tDAO.deleteTeacherByTid(tId);
                request.getRequestDispatcher("listteacher?subId="+t.getSubId()+"").forward(request, response);
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
