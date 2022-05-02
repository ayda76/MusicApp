<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1> Login Form</h1>
</div>

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Login</h1>
    <form method="get" action="<%=request.getContextPath()%>/LoginServlet">
      <div class="input-container">
        <input type="text" id="LBL1" name = "UserName"required="required"/>
        <label for="LBL1">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" id="LBL2" name = "Password" required="required"/>
        <label for="LBL2">Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
          <button type="submit"><span>Go</span></button>
      </div>
      
    </form>
  </div>
  <div class="card alt">
    <div class="toggle"></div>
    <h1 class="title">Register
      <div class="close"></div>
    </h1>
    <form method="post" action="<%=request.getContextPath()%>/LoginServlet">
      <div class="input-container">
        <input type="text" id="LBL3"name="UserName" required="required"/>
        <label for="LBL3">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" id="LBL4" name ="Password" required="required"/>
        <label for="LBL4">Password</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" id="LBL5"name ="repPassword" required="required"/>
        <label for="LBL5">Repeat Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button><span>Register</span></button>
      </div>
    </form>
  </div>
</div>

<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>
