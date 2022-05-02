<%@page import="com.myapp.struts.Controller.co_Song"%>
<%@page import="com.myapp.struts.Controller.co_Singer"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

 
 
 

<html:html lang="true">
   <head>
  <meta charset="UTF-8">
  <title>Music Player</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
  <link rel="stylesheet" href="./style.css">
  <link rel="stylesheet" href="./Play/style.css">
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css'>
  <script  src="./Play/script.js"></script>
</head>
<body>
   
<!-- partial:index.partial.html -->
<div class="wrapper">
  <!-- Wave bg-->
  <div class="wave-container">
    <div class="wave -one"></div>
    <div class="wave -two"></div>
    <div class="wave -three"></div>
  </div>
  <div class="line"></div>
  
  <div class="header">
    <div class="burger-wrapper">
      <div class="burger"></div>
    </div>
    <div class="logo-text">Listeners Playlist</div>
    <div  >
          <a class="fa fa-user fa-10x" style="margin: 10px;padding: 10px" href="Login/"></a>
         
      </div>
  </div>
  
  <div class="mini-player">
    <div class="track_info_wrapper">
      <div class="track_info">
        <div class="info">
        </div>
      </div>
    </div>
    <div class="mini-player_btn_wrapper">
      <i class="btn-open-player fa fa-list" aria-hidden="true"></i>
    </div>
  </div>
  <div class="dim"></div>
  <div class="player" id="player">
      <div class="play-list">
          <div>
              <frame></frame>
              <iframe style="width: 100%;height: 100%" src="Play/index.jsp"></iframe>
     
      
          </div>          
          
      </div>
      <div class="list_wrapper">
      <ul class="list"> 
            
          
      </ul>
    </div>
  </div>
 <!-- <div class="page" id="curator">
    <div class="curator_title_wrapper"><span>LP</span>
      <div class="curator_line"></div>
      <div class="curator_title">Listeners</div>
      <div class="curator_line"></div><span>14</span>
    </div>
    <div class="curator_list">
      <div class="curator_list_content">
        <div class="connect_btn_wrapper item">
          <div class="connect_btn">
            <div class="connect_btn_text">Connect <br/>SoundCloud</div>
          </div>
        </div>
        <div class="curator_list_content_desc">Or Select <br/>a Listener of <br/>L.P.			</div>
        
        
       
      </div>
    </div>
  </div> -->
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.0/TweenMax.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.0/TimelineMax.min.js'></script><script  src="./script.js"></script>

</body>

</html:html>
