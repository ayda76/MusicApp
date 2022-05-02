package com.myapp.struts.Servlet;

import Utils.ConnectionString;
import com.myapp.struts.Dao.do_Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Like_Servlet", urlPatterns = {"/Like_Servlet"})
public class Like_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Like_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Like_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            try {
                String parameter = request.getParameter("ID");
                ConnectionString cs = new ConnectionString();

                System.out.println("Settion Print: " + sec_data.toString());
                cs.InsertToDB(" if not exists(select * from [like] where song_id ="+parameter+" and user_id="+sec_data.getUser_id()+") insert into [like] (song_id, user_id) values ('" + parameter + "','" + sec_data.getUser_id() + "') else delete from [like] where song_id ="+parameter+" and user_id="+sec_data.getUser_id()+"");
                cs.DisconnectSqlServer();
                response.sendRedirect(request.getContextPath() + "../../MusicWeb/Play/index.jsp");
            } catch (Exception e) {
                response.sendRedirect(request.getContextPath() + "../../MusicWeb/Login/index.jsp");

            }

        } else {
            response.sendRedirect(request.getContextPath()+"/Login/index.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType() == 1) {

            } else {
                response.sendRedirect("../Login/index.jsp");
                // response.sendRedirect("../404.html");
            }
        } else {
            processRequest(request, response);
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
