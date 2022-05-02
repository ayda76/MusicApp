
package com.myapp.struts.Servlet;

import com.myapp.struts.Controller.co_Singer;
import com.myapp.struts.Dao.do_Singer;
import com.myapp.struts.Dao.do_Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Singer_Servlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Singer_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Singer_Servlet at " + request.getContextPath() + "</h1>");
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

           if(request.getSession()!=null && request.getSession().getAttribute("sec_data") !=null){
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
        String Action = request.getParameter("action");
        String singer_id = request.getParameter("singer_id");
        
        co_Singer s    = new co_Singer();

        if (Action.equals("edit")) {
            do_Singer FindByIS = s.FindByIS(singer_id); 
            request.setAttribute("Singer", FindByIS);
            request.getRequestDispatcher("ControlPanel/Singer/EditSinger.jsp").forward(request, response);

        } else if (Action.equals("delete")) {
            s.Singer_Delete(singer_id);
            response.sendRedirect(request.getContextPath() + "/ControlPanel/Singer/index.jsp");
        } else if (Action.equals("setedit")) {
            do_Singer singer = new do_Singer();
                singer.setSinger_id(request.getParameter("s_singID"));
                singer.setLname(request.getParameter("s_name"));
                singer.setFname(request.getParameter("s_family"));
                singer.setBirthday(request.getParameter("s_birthday"));
                singer.setCountry(request.getParameter("s_cuntry"));
                singer.setSex(request.getParameter("s_sex"));
                singer.setEmail(request.getParameter("s_email"));
                singer.setMobile(request.getParameter("s_mobile"));
                s.Singer_Update(singer);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Singer/index.jsp");
        }    
        }else{
               response.sendRedirect(request.getContextPath() + "/Login/index.jsp");
        
        }}

          
            @Override
            protected void doPost
            (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   if(request.getSession()!=null && request.getSession().getAttribute("sec_data") !=null){
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType()==1) {
                request.setCharacterEncoding("UTF-8");
                
                co_Singer s = new co_Singer();
                
                do_Singer singer = new do_Singer();
                singer.setLname(request.getParameter("s_name"));
                singer.setFname(request.getParameter("s_family"));
                singer.setBirthday(request.getParameter("s_birthday"));
                singer.setCountry(request.getParameter("s_cuntry"));
                singer.setSex(request.getParameter("s_sex"));
                singer.setEmail(request.getParameter("s_email"));
                singer.setMobile(request.getParameter("s_mobile"));
                s.Singer_InsertTo(singer);
                response.sendRedirect(request.getContextPath() + "/ControlPanel/Singer/index.jsp");
            }
            else
            {
                 response.sendRedirect(request.getContextPath()+"/Login/index.jsp");
               // response.sendRedirect("../404.html");
            }
        }else{
             response.sendRedirect(request.getContextPath()+"/Login/index.jsp");   
            }
            }
           
            @Override
            public String getServletInfo
            
                () {
        return "Short description";
            }// </editor-fold>

        }
