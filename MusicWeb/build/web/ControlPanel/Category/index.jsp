<%@page import="com.myapp.struts.Controller.co_Category"%>
<%@page import="com.myapp.struts.Controller.co_Users"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

 
 
 

<html:html lang="true">
    <head>
        <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
                    <title>پتل مدیریت</title>
                    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico"/>
                    <!-- BEGIN GLOBAL MANDATORY STYLES -->
                    <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700" rel="stylesheet">
                        <link href="<%=application.getContextPath()%>/ControlPanel/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
                        <link href="<%=application.getContextPath()%>/ControlPanel/assets/css/plugins.css" rel="stylesheet" type="text/css" />
                        <!-- END GLOBAL MANDATORY STYLES -->

                        <!-- BEGIN PAGE LEVEL STYLES -->
                        <link href="<%=application.getContextPath()%>/ControlPanel/assets/css/scrollspyNav.css" rel="stylesheet" type="text/css" />
                        


                        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/ControlPanel/plugins/table/datatable/datatables.css">
                            <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/ControlPanel/plugins/table/datatable/dt-global_style.css">


                                <!-- END PAGE LEVEL STYLES -->

                                </head>
                                <body data-spy="scroll" data-target="#navSection" data-offset="100">

                                    <!--  BEGIN NAVBAR  -->
                                    <div class="header-container fixed-top">
                                        <header class="header navbar navbar-expand-sm">

                                            <ul class="navbar-item theme-brand flex-row  text-center">

                                                <li class="nav-item theme-text">
                                                    <a href="index.jsp" class="nav-link"> Music Player  </a>
                                                </li>
                                            </ul>

                                            <ul class="navbar-item flex-row ml-md-0 ml-auto" style="margin-top: 10px">
                                                <li class="nav-item align-self-center search-animated">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search toggle-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>
                                                    <form class="form-inline search-full form-inline search" role="search">
                                                        <div class="search-bar">
                                                            <input type="text" class="form-control search-form-control  ml-lg-auto" placeholder="جستجو کنید...">
                                                        </div>
                                                    </form>
                                                </li>
                                            </ul>


                                        </header>
                                    </div>
                                    <!--  END NAVBAR  -->

                                    <!--  BEGIN NAVBAR  -->
                                    <div class="sub-header-container">
                                        <header class="header navbar navbar-expand-sm">
                                            <a href="javascript:void(0);" class="sidebarCollapse" data-placement="bottom"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu"><line x1="3" y1="12" x2="21" y2="12"></line><line x1="3" y1="6" x2="21" y2="6"></line><line x1="3" y1="18" x2="21" y2="18"></line></svg></a>

                                            <ul class="navbar-nav flex-row">
                                                <li>
                                                    <div class="page-header">

                                                        <nav class="breadcrumb-one" aria-label="breadcrumb">
                                                            <ol class="breadcrumb">
                                                                <li class="breadcrumb-item"><a href="javascript:void(0);">فرم ها</a></li>
                                                                <li class="breadcrumb-item active" aria-current="page"><span>مدیریت دسته ها </span></li>
                                                            </ol>
                                                        </nav>

                                                    </div>
                                                </li>
                                            </ul>
                                        </header>
                                    </div>
                                    <!--  END NAVBAR  -->

                                    <!--  BEGIN MAIN CONTAINER  -->
                                    <div class="main-container" id="container">

                                        <div class="overlay"></div>
                                        <div class="search-overlay"></div>

                                        <!--  BEGIN SIDEBAR  -->

                                        <jsp:include page="../SideBar.jsp" />
                                        <!--  END SIDEBAR  -->

                                        <!--  BEGIN CONTENT AREA  -->
                                        <div id="content" class="main-content">
                                            <div class="layout-px-spacing">
                                                <div class="container">                   
                                                    <div class="row layout-top-spacing">

                                                        <div id="fuSingleFile" class="col-xl-12  col-md-12">
                                                            <div class="statbox widget box box-shadow">

                                                                <div class="modal-body">
                                                                    <button type="button" class="btn btn-success mb-2 mr-2" data-toggle="modal" data-target="#exampleModalAlum">
                                                                        ایجاد دسته جدید    
                                                                    </button>
                                                                    <div class="table-responsive mb-4 mt-4">

                                                                        <table id="zero-config" class="table table-hover" style="width:100%">
                                                                            <thead>
                                                                                <%!co_Category u = new co_Category();%>
                                                                                <%=u.Header()%>
                                                                            </thead>
                                                                            <tbody>

                                                                                <%=u.LoadTables()%>

                                                                            </tbody>

                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>



                                                </div>

                                            </div>
                                        </div>
                                        <div class="footer-wrapper">
                                            <div class="footer-section f-section-1">
                                                <p class=""> © کپی رایت</p>
                                            </div>

                                        </div>
                                    </div>
                                    <!--  END CONTENT AREA  -->
                                    </div>
                                    <!-- END MAIN CONTAINER -->



                                    <!-- BEGIN GLOBAL MANDATORY SCRIPTS -->
                                    <script src="<%=application.getContextPath()%>/ControlPanel/assets/js/libs/jquery-3.1.1.min.js"></script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/bootstrap/js/popper.min.js"></script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/bootstrap/js/bootstrap.min.js"></script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/plugins/blockui/jquery.blockUI.min.js"></script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/assets/js/app.js"></script>

                                    <script>
                                        $(document).ready(function () {
                                            App.init();
                                        });
                                    </script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/plugins/highlight/highlight.pack.js"></script>
                                    <script src="<%=application.getContextPath()%>/ControlPanel/assets/js/custom.js"></script>
                                    <!-- END GLOBAL MANDATORY SCRIPTS -->

                                    <!-- BEGIN PAGE LEVEL PLUGINS -->
                                    <script src="<%=application.getContextPath()%>/ControlPanel/assets/js/scrollspyNav.js"></script>
                                    


                                    <!-- END PAGE LEVEL PLUGINS -->    





                                    <!-- Modal ADD Album -->
                                    <div class="modal fade" id="exampleModalAlum" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">ایجاد دسته جدید</h5>

                                                </div>
                                                <form name="Customer" method="post" action="<%=request.getContextPath()%>/Category_Servlet" >
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label for="profession">نام دسته</label>
                                                            <input type="text" class="form-control mb-4" name ="u_name" id="u_name" placeholder="نام دسته" >
                                                        </div>
                                                        <input type="hidden" class="form-control mb-4" name ="u_parent" id="u_parent" placeholder="کد پدر " >
                                                        
                                                        
                                                    <input type="submit"  class="btn btn-outline-success mb-2" value="ذخیره ">
                                                </form>
                                            </div>
                                        </div>

                                    </div>
                                    </div>
                                    </div>
                                    <!-- Modal ADD Album -->

                                    <!-- Modal ADD Category -->
                                    <div class="modal fade" id="exampleModalCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">ویرایش اطلاعات</h5>

                                                </div>
                                                <div class="modal-body">
                                                    <div class="table-responsive mb-4 mt-4">
                                                        <form name="Customer" method="post" action="<%=request.getContextPath()%>/Animal" >
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label for="profession">نام </label>
                                                            <input type="text" class="form-control mb-4" id="profession" placeholder="طراح" value="طراح سایت">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="profession">نام خانوادگی </label>
                                                            <input type="text" class="form-control mb-4" id="profession" placeholder="طراح" value="طراح سایت">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="profession">نام کاربری</label>
                                                            <input type="text" class="form-control mb-4" id="profession" placeholder="طراح" value="طراح سایت">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="profession">کلمه عبور </label>
                                                            <input type="text" class="form-control mb-4" id="profession" placeholder="طراح" value="طراح سایت">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="profession">ایمیل </label>
                                                            <input type="text" class="form-control mb-4" id="profession" placeholder="طراح" value="طراح سایت">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="profession">موبایل </label>
                                                            <input type="text" class="form-control mb-4" id="profession" placeholder="طراح" value="طراح سایت">
                                                        </div>
                                                    <input type="submit"  class="btn btn-outline-success mb-2" value="ذخیره ">
                                                </form>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    </div>
                                    <!-- Modal ADD Category -->
                                    <script src="<%=application.getContextPath()%>/ControlPanel/plugins/table/datatable/datatables.js"></script>
                                    <script>
                                        $('#zero-config').DataTable({
                                            "oLanguage": {
                                                "oPaginate": {"sPrevious": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>', "sNext": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>'},
                                                "sInfo": "صفحه _PAGE_ از _PAGES_",
                                                "sSearch": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>',
                                                "sSearchPlaceholder": "جستجو کنید...",
                                                "sLengthMenu": "نتایج :  _MENU_",
                                            },
                                            "stripeClasses": [],
                                            "lengthMenu": [7, 10, 20, 50],
                                            "pageLength": 7
                                        });
                                    </script>
                                    <script>
                                        $('#Album-config').DataTable({
                                            "oLanguage": {
                                                "oPaginate": {"sPrevious": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>', "sNext": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>'},
                                                "sInfo": "صفحه _PAGE_ از _PAGES_",
                                                "sSearch": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>',
                                                "sSearchPlaceholder": "جستجو کنید...",
                                                "sLengthMenu": "نتایج :  _MENU_",
                                            },
                                            "stripeClasses": [],
                                            "lengthMenu": [7, 10, 20, 50],
                                            "pageLength": 7
                                        });
                                    </script>


                                    <script>
                                        $('#Category-config').DataTable({
                                            "oLanguage": {
                                                "oPaginate": {"sPrevious": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>', "sNext": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>'},
                                                "sInfo": "صفحه _PAGE_ از _PAGES_",
                                                "sSearch": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>',
                                                "sSearchPlaceholder": "جستجو کنید...",
                                                "sLengthMenu": "نتایج :  _MENU_",
                                            },
                                            "stripeClasses": [],
                                            "lengthMenu": [7, 10, 20, 50],
                                            "pageLength": 7
                                        });
                                    </script>

                                </body>
                            </html:html>
