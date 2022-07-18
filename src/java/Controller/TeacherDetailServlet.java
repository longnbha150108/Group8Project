/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.CommentDAO;
import DAL.ReviewDAO;
import DAL.TeacherDAO;
import Model.Account;
import Model.Comment;
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
public class TeacherDetailServlet extends HttpServlet {

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
            CommentDAO cDAO = new CommentDAO();
            ReviewDAO rDAO = new ReviewDAO();
            TeacherDAO tDAO = new TeacherDAO();
            Teacher t;
            String tId;
            String subId;
            if (request.getParameter("best") != null) {
                t = tDAO.bestRateTeacherOfAll();
                tId = t.getId();
                subId = t.getSubId();
            } else {
                tId = request.getParameter("tId");
                subId = request.getParameter("subId");   
                tDAO.updateFavorsCommentsAndRates(tId);
                t = tDAO.getTeacherById(tId);
            }
            List<Comment> listC = cDAO.getAllCommentOfTeacher(tId, subId);
            request.getSession().setAttribute("tId", tId);
            request.getSession().setAttribute("subId", subId);
            if (request.getSession().getAttribute("acc") != null) {
                Account acc = (Account) request.getSession().getAttribute("acc");
                request.setAttribute("rate", rDAO.getRate(acc.getUsername(), tId, subId));
                request.setAttribute("favor", rDAO.getFavor(acc.getUsername(), tId, subId));
            }
            request.setAttribute("t", t);
            request.setAttribute("listC", listC);

            request.getRequestDispatcher("TeacherDetail.jsp").forward(request, response);
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
