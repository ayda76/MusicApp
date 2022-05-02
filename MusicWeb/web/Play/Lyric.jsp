<%-- 
    Document   : index
    Created on : Jul 2, 2021, 3:08:02 AM
    Author     : Aida
--%>

<%@page import="com.myapp.struts.Controller.co_Song"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
          <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>
    </head>
<body>

      
      

    <div class="large-toggle-btn">
      <i class="large-play-btn"><span class="screen-reader-text">Large toggle button</span></i>
    </div>
    <!-- /.play-box -->

    <div class="info-box">
      <div class="track-info-box">
        <div class="track-title-text"></div>
        <div class="audio-time">
         
        </div>
      </div>
      <!-- /.info-box -->

      <div class="progress-box">
        <div class="progress-cell">
          <div class="progress">
            <div class="progress-buffer"></div>
            <div class="progress-indicator"></div>
          </div>
        </div>
      </div>

    </div>
    <!-- /.progress-box -->
    <div style="direction: rtl;margin: 20px;
    text-align: justify;
    font-family: myFirstFont;
    font-size: 20px;">
        <div style="direction: rtl;margin: 20px;
    text-align: justify;
    font-family: myFirstFont;
    font-size: 20px;">
        <a href="<%=application.getContextPath()%>/Play/index.jsp">بازگشت </a>
        </div>
    <%!co_Song u = new co_Song();%>
    <%=u.LoadLyric(request.getParameter("ID"))%>
   
  
   </div>
    <!-- /.controls-box -->

  </div>
  <!-- /.player -->

  

</div>
<!-- partial -->
  <script  src="./script.js"></script>

</body>
</html>
