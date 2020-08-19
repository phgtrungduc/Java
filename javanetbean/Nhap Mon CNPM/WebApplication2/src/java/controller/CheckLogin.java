/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import module.Connect;
import module.userpass;

/**
 *
 * @author duc.pt173030
 */
public class CheckLogin extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("thanh cong");
        Connect connect = new Connect();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userpass up = new userpass();
        up.setUsername(username);
        up.setPassword(password);
        boolean check = false;
        try {
            ResultSet rs = connect.selectData("select * from Login");
            while (rs.next()) {
                String uname = rs.getString("UserName");
                String pword = rs.getString("PassWord");
                if (up.validate(uname, pword)) {
                    check = true;
                    break;
                }
                check = false;
            }
        } catch (Exception ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (check == true) {
            HttpSession session = request.getSession();
            session.setAttribute("name", up.getUsername());
            RequestDispatcher rq = request.getRequestDispatcher("loginsuccess.jsp");
            rq.forward(request, response);
        } else {
            RequestDispatcher rq = request.getRequestDispatcher("loginfail.jsp");
            rq.forward(request, response);
        }
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
