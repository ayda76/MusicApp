/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Servlet;

import com.myapp.struts.Controller.co_Users;
import com.myapp.struts.Dao.do_Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aida
 */
public class Users_Servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Users_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Users_Servlet at " + request.getContextPath() + "</h1>");
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
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            String Action = request.getParameter("action");
            String UserIDs = request.getParameter("UserID");
            co_Users u = new co_Users();

            if (Action.equals("edit")) {
                do_Users FindByIDs = u.FindByIDs(UserIDs);
                request.setAttribute("Users", FindByIDs);
                request.getRequestDispatcher("ControlPanel/Users/EditUsers.jsp").forward(request, response);

            } else if (Action.equals("delete")) {
                u.Users_Delete(UserIDs);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Users/index.jsp");

            } else if (Action.equals("setedit")) {
                do_Users users = new do_Users();
                users.setFname(request.getParameter("u_name"));
                users.setUser_id(Integer.valueOf(request.getParameter("u_id")));
                users.setLname(request.getParameter("u_family"));
                users.setUsername(request.getParameter("u_username"));
                users.setPassword(request.getParameter("u_password"));
                users.setEmail(request.getParameter("u_email"));
                users.setMobile(request.getParameter("u_mobile"));

                u.Users_Updte(users);

//            request.getRequestDispatcher("ControlPanel/Users/index.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Users/index.jsp");

            }
        } else {
            response.sendRedirect(request.getContextPath() + "/Login/index.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType() == 1) {
                request.setCharacterEncoding("UTF-8");
                System.out.println("Ana Post ");
                do_Users users = new do_Users();
                users.setFname(request.getParameter("u_name"));
                users.setLname(request.getParameter("u_family"));
                users.setUsername(request.getParameter("u_username"));
                users.setPassword(request.getParameter("u_password"));
                users.setEmail(request.getParameter("u_email"));
                users.setMobile(request.getParameter("u_mobile"));
                co_Users u = new co_Users();
                u.Users_InsertTo(users);

//        processRequest(request, response);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Users/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/Login/index.jsp");
                //  response.sendRedirect("../404.html");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/Login/index.jsp");
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
