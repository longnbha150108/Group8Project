/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.SpecializationDAO;
import DAL.SubjectDAO;
import DAL.TeacherDAO;
import Model.Account;
import Model.Subject;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class ListTeacherServlet extends HttpServlet {

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
            TeacherDAO tDAO = new TeacherDAO();
            List<Teacher> listT = tDAO.getAll();
            Teacher bestT = null;
            if (request.getParameter("search") != null) {
                String search = request.getParameter("search");
                SubjectDAO subDAO = new SubjectDAO();
                listT = tDAO.getTeacherContainSearch(search);
                List<Subject> listSub = subDAO.getSubjectContainSearch(search);
                request.setAttribute("ListSub", listSub);
                request.setAttribute("tittle", "Danh sách giáo viên tìm kiếm");
                request.setAttribute("subtittle", "Danh sách môn học tìm kiếm");
                request.setAttribute("mess", "Không tìm thấy giáo viên");
                request.setAttribute("link", "search=" + search + "&");
            } else if (request.getParameter("favor") != null) {
                Account acc = (Account) request.getSession().getAttribute("acc");
                listT = tDAO.getAllTeacherFavorByAccount(acc.getUsername());
                request.setAttribute("mess", "Danh sách yêu thích trống");
                request.setAttribute("tittle", "Danh sách giáo viên yêu thích");
                request.setAttribute("link", "favor=on&");
            } else {
                bestT = tDAO.bestRateTeacherOfAll();
                String sId = request.getParameter("sId");
                SubjectDAO sDAO = new SubjectDAO();
                if (request.getParameter("sId") != null) {
                    request.getSession().setAttribute("sId", sId);
                }
                List<Subject> ListSub = sDAO.getAllSubjectBySid((String) request.getSession().getAttribute("sId"));
                request.setAttribute("ListSub", ListSub);
                if (request.getParameter("subId") != null) {
                    String subId = request.getParameter("subId");
                    request.setAttribute("subId", subId);
                    listT = tDAO.getAllTeacherBySubid(subId);
                    bestT = tDAO.bestRateTeacherOfsubID(subId);
                    request.setAttribute("link", "sId=" + sId + "&subId=" + subId + "&");
                    request.setAttribute("mess", "Hiện môn chưa có giáo viên ");
                    request.setAttribute("tittle", sDAO.getSubjectById(subId).getName());
                    request.setAttribute("subtittle", (new SpecializationDAO()).getSpeById(sId).getName());
                } else if (request.getParameter("sId") != null) {
                    listT = tDAO.getAllTeacherBySid(sId);
                    bestT = tDAO.bestRateTeacherOfsID(sId);
                    request.setAttribute("tittle", (new SpecializationDAO()).getSpeById(sId).getName());
                    request.setAttribute("link", "sId=" + sId + "&");
                    request.setAttribute("mess", "Hiện ngành chưa có giáo viên ");
                    request.setAttribute("subtittle", (new SpecializationDAO()).getSpeById(sId).getName());
                } else {
                    request.setAttribute("subtittle", "Danh sách chuyên ngành");
                    request.setAttribute("tittle", "Danh sách tất cả giáo viên");
                    request.setAttribute("ListSpe", request.getSession().getAttribute("ListS"));
                    request.setAttribute("link", "");
                }
            }

            List<Teacher> listTeacherInPage = new ArrayList<>();
            int size = listT.size();
            int page;
            int numpage = 8;
            String xpage = request.getParameter("page");
            if (xpage == null) {
                page = 1;
            } else {
                page = Integer.parseInt(xpage);
            }
            int start, end;
            start = (page - 1) * numpage;
            end = Math.min(page * numpage, size);
            for (int i = start; i < end; i++) {
                listTeacherInPage.add(listT.get(i));
            }
            request.setAttribute("size", size / numpage + 1);
            request.setAttribute("page", page);
            request.setAttribute("bestT", bestT);
            request.setAttribute("listT", listTeacherInPage);
            request.getRequestDispatcher("ListTeacher.jsp").forward(request, response);
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
