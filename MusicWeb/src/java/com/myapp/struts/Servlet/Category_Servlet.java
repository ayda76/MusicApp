
package com.myapp.struts.Servlet;

import com.myapp.struts.Controller.co_Category;
import com.myapp.struts.Dao.do_Category;
import com.myapp.struts.Dao.do_Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Category_Servlet", urlPatterns = {"/Category_Servlet"})
public class Category_Servlet extends HttpServlet {

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
            out.println("<title>Servlet Category_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Category_Servlet at " + request.getContextPath() + "</h1>");
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
            if (sec_data.getUserType() == 1) {
                String Action = request.getParameter("action");
                String CategoryID = request.getParameter("CategoryID");
                co_Category c = new co_Category();
                if (Action.equals("edit")) {
                    do_Category FindByID = c.FindByID(CategoryID);
                    request.setAttribute("Category", FindByID);
                    request.getRequestDispatcher("ControlPanel/Category/EditCategory.jsp").forward(request, response);

                } else if (Action.equals("delete")) {
                    c.Category_Delete(CategoryID);
                    response.sendRedirect(request.getContextPath() + "/ControlPanel/Category/index.jsp");

                } else if (Action.equals("setedit")) {
                    do_Category category = new do_Category();
                    category.setCategory_id(request.getParameter("code"));
                    category.setCategoryname(request.getParameter("c_name"));
                    category.setParent(request.getParameter("c_parent"));
                    c.Category_Update(category);
                    response.sendRedirect(request.getContextPath() + "/ControlPanel/Category/index.jsp");
                }
            }
        } else {

            response.sendRedirect(request.getContextPath() + "/Login/index.jsp");
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
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType() == 1) {
                request.setCharacterEncoding("UTF-8");
                do_Category c = new do_Category();
                c.setCategoryname(request.getParameter("u_name"));
                c.setParent(request.getParameter("u_parent"));
                co_Category category = new co_Category();
                category.Category_Insert(c);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Category/index.jsp");
            } else {
                response.sendRedirect("../Login/index.jsp");
                //response.sendRedirect("../404.html");
            }
        } else {

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
