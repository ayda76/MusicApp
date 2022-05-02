
package com.myapp.struts.Servlet;

import com.myapp.struts.Controller.co_Song;
import com.myapp.struts.Dao.do_Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet(name = "Song_Servlet", urlPatterns = {"/Song_Servlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Song_Servlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Song_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Song_Servlet at " + request.getContextPath() + "</h1>");

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
//        processRequest(request, response);
        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType() == 1) {
                co_Song s = new co_Song();
                String Action = request.getParameter("action");
                String song_id = request.getParameter("songid");
                if (Action.equals("delete")) {
                    s.Song_Delete(song_id);
                    response.sendRedirect(request.getContextPath() + "/ControlPanel/Song/index.jsp");
                }
            } else {

                //response.sendRedirect("../404.html");
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
    private String FindFileExtention(String contentType) {
        String File_Extention = "";
        switch (contentType) {
            case "image/jpeg": {
                File_Extention = ".jpg";
                break;
            }
            case "image/gif": {
                File_Extention = ".gif";
                break;
            }
            case "image/png": {
                File_Extention = ".png";
                break;
            }
            case "image/vnd.wap.wbmp": {
                File_Extention = ".wbmp";
                break;
            }
        }
        return File_Extention;
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        if (request.getSession() != null && request.getSession().getAttribute("sec_data") != null) {
            do_Users sec_data = (do_Users) request.getSession().getAttribute("sec_data");
            if (sec_data.getUserType() == 1) {
System.out.println("Ana Post");

            request.setCharacterEncoding("UTF-8");
            String singerID = request.getParameter("singer");
            String AlbumID = request.getParameter("Album");
            String CategoryID = request.getParameter("Category");
            String Lyric = request.getParameter("Lyric");
            String MusicName = request.getParameter("MusicName");
            System.out.println(singerID + " - " + AlbumID + " - " + CategoryID + " - " + Lyric + " - " + MusicName);

            String filePath = request.getServletContext().getRealPath("") + File.separator + "Avatarimages\\";
            System.out.println("Save URL Patch : " + filePath);

            response.sendRedirect(request.getContextPath() + "/ControlPanel/Song/index.jsp");
            response.setContentType("text/html;charset=UTF-8");

            // Create path components to save the file
           
            final Part filePart = request.getPart("file");
            final Part filePartpic = request.getPart("filePic");
            final String fileName;
            fileName = getFileName(filePart);
            final String fileNamepic;
            fileNamepic = getFileName(filePartpic);

            OutputStream out;
            out = null;
            OutputStream outpic;
            outpic = null;
            InputStream filecontent = null;
            InputStream filecontentpic = null;
          //  final PrintWriter writer = response.getWriter();
           // final PrintWriter writerpic = response.getWriter();
            co_Song s = new co_Song();
            System.out.println(singerID + " - " + AlbumID + " - " + CategoryID + " - " + Lyric + " - " + MusicName);
            String Query = "EXEC	[dbo].[Song_Insert]\n"
                    + "		@songname = N'" + MusicName + "',\n"
                    + "		@singer_id = N'" + singerID + "',\n"
                    + "		@album_id = N'" + AlbumID + "',\n"
                    + "		@lyric = N'" + Lyric + "',		\n"
                    + "		@songfile = N'" + fileName + "',\n"
                    + "		@category_id = N'" + CategoryID + "',		\n"
                    + "		@creator_user_id = N'" + "1" + "',\n"
                    + "		@Pic = N'" + fileNamepic + "'";
            Boolean InsertToDB = s.InsertToDB(Query);

            try {
                out = new FileOutputStream(new File(filePath + File.separator
                        + fileName));

                outpic = new FileOutputStream(new File(filePath + File.separator
                        + fileNamepic));

                filecontent = filePart.getInputStream();
                filecontentpic = filePartpic.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                int readpic = 0;
                final byte[] bytespic = new byte[1024];

                while ((readpic = filecontentpic.read(bytespic)) != -1) {
                    outpic.write(bytespic, 0, readpic);
                }
//        writer.println("New file " + fileName + " created at " );
//        writerpic.println("New file " + fileName + " created at " );
//        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[]{fileName, path});
//        writer.println("New file " + fileNamepic + " created at " );
//        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
//                new Object[]{fileNamepic, path});
            } catch (FileNotFoundException fne) {
               /* writer.println("You either did not specify a file to upload or are "
                        + "trying to upload a file to a protected or nonexistent "
                        + "location.");
                writer.println("<br/> ERROR: " + fne.getMessage());*/

//        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
//                new Object[]{fne.getMessage()});
            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
               /* if (writer != null) {
                    writer.close();
                }*/

                if (outpic != null) {
                    outpic.close();
                }
                if (filecontentpic != null) {
                    filecontentpic.close();
                }
               
            }
            } else {
                response.sendRedirect(request.getContextPath()+"/Login/index.jsp");
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
