
package com.myapp.struts.Servlet;

import com.myapp.struts.Controller.co_Users;
import com.myapp.struts.Dao.do_Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aida
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
           

        
                do_Users u = new do_Users();
                co_Users u1 = new co_Users();
                u = u1.Login(request.getParameter("UserName"), request.getParameter("Password"));
                if(u.getUsername().equals(request.getParameter("UserName"))){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("sec_data", u);
                    session.setAttribute("UserName",request.getParameter("username"));
                    if(u.getUserType()==1){
                     response.sendRedirect(request.getContextPath() + "/ControlPanel/Song/index.jsp");
                    }
                    else{
                     response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
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
           
//        processRequest(request, response);
do_Users ud = new do_Users();
co_Users u = new  co_Users();
ud.setUsername(request.getParameter("UserName"));
ud.setPassword(request.getParameter("Password"));
u.Users_InsertTo(ud);
 response.sendRedirect(request.getContextPath() + "/Login/index.jsp");


            
    
//
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
