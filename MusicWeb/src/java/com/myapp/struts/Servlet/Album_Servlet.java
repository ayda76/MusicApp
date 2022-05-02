
package com.myapp.struts.Servlet;

import com.myapp.struts.Controller.co_Album;
import com.myapp.struts.Dao.do_Album;
import com.myapp.struts.Dao.do_Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.JDBCType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Album_Servlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Album_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Album_Servlet at " + request.getContextPath() + "</h1>");
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
            String AlbumID = request.getParameter("album_id");
            co_Album album = new co_Album();
            if (Action.equals("edit")) {
                do_Album FindByID = album.FindByID(AlbumID);
                request.setAttribute("Album", FindByID);
                request.getRequestDispatcher("ControlPanel/Album/EditAlbum.jsp").forward(request, response);

            } else if (Action.equals("delete")) {
                album.Album_Delete(AlbumID);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Album/index.jsp");

            } else if (Action.equals("setedit")) {

                do_Album a = new do_Album();
                a.setAbum_id(Integer.valueOf(request.getParameter("code")));
                a.setAlbumname(request.getParameter("c_name"));
                a.setStatus("1");
                a.setSinger_id(request.getParameter("c_singerid"));

                album.Album_Update(a);

                response.sendRedirect(request.getContextPath() + "/ControlPanel/Album/index.jsp");

            }
        } else {
            response.sendRedirect("../Login/index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType() == 1) {
                request.setCharacterEncoding("UTF-8");
                do_Album a = new do_Album();
                a.setAlbumname(request.getParameter("u_name"));
                a.setStatus("1");
                a.setSinger_id(request.getParameter("u_singerid"));
                co_Album album = new co_Album();
                album.Album_Insert(a);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Album/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath()+"/Login/index.jsp");
                //  response.sendRedirect("../404.html");
            }
        } else {
response.sendRedirect(request.getContextPath()+"/Login/index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
