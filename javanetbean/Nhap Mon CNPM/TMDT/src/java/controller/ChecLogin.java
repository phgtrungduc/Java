/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.userpass;

/**
 *
 * @author duc.pt173030
 */
public class ChecLogin extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChecLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChecLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        DAO connect = new DAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userpass up = new userpass();
        up.setUsername(username);
        up.setPassword(password);
        boolean check = false;
        ResultSet rs;
        try {
            rs = connect.selectData("select * from Login");
            while (rs.next()) {
                String uname = rs.getString("UserName");
                String pword = rs.getString("PassWord");
                if (up.validate(uname, pword)) {
                    check = true;
                    break;
                }
            }
            check = false;
        } catch (Exception ex) {
            Logger.getLogger(ChecLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (check == true) {
            HttpSession session = request.getSession();
            session.setAttribute("name", up.getUsername());
            RequestDispatcher rq = request.getRequestDispatcher("success.jsp");
            rq.forward(request, response);
        } else {
            RequestDispatcher rq = request.getRequestDispatcher("fail.jsp");
            rq.forward(request, response);
        }
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
