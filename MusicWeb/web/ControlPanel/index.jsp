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
                        <link href="<%=application.getContextPath()%>/ControlPanel/plugins/file-upload/file-upload-with-preview.min.css" rel="stylesheet" type="text/css" />


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
                                                                <li class="breadcrumb-item active" aria-current="page"><span>بارگذاری موزیک</span></li>
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

                                        <jsp:include page="SideBar.jsp" />
                                        <!--  END SIDEBAR  -->

                                        <!--  BEGIN CONTENT AREA  -->
                                        <div id="content" class="main-content">
                                            <div class="container">
                                                <div class="container">                   
                                                    <div class="row layout-top-spacing">

                                                        <div id="fuSingleFile" class="col-lg-12 layout-spacing">
                                                            <div class="statbox widget box box-shadow">

                                                                <div class="widget-header">
                                                                    <div class="row">
                                                                        <div class="col-xl-12 col-md-12 col-sm-12 col-12">
                                                                            <h4> نام موزیک</h4>
                                                                        </div>      
                                                                    </div>
                                                                    <div class="widget-content widget-content-area">
                                                                        <input type="text" class="form-control"/>


                                                                    </div>
                                                                </div>
                                                                <div class="widget-header">

                                                                    <div class="widget-content widget-content-area">
                                                                        <button type="button" class="btn btn-primary mb-2 mr-2" data-toggle="modal" data-target="#exampleModal">
                                                                            انتخاب خواننده
                                                                        </button>
                                                                        <button type="button" class="btn btn-success mb-2 mr-2" data-toggle="modal" data-target="#exampleModalAlum">
                                                                            انتخاب آلبوم
                                                                        </button>
                                                                        <button type="button" class="btn btn-warning mb-2 mr-2" data-toggle="modal" data-target="#exampleModalCategory">
                                                                            انتخاب دسته بندی
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                                <div class="widget-header">
                                                                    <div class="row">
                                                                        <div class="col-xl-12 col-md-12 col-sm-12 col-12">
                                                                            <h4>متن موزیک</h4>
                                                                        </div>      
                                                                    </div>
                                                                    <div class="widget-content widget-content-area">

                                                                        <textArea class="form-control"></textArea>

                                                                        
                                                                    </div>
                                                                </div>
                                                                <div class="widget-header">
                                                                    <div class="row">
                                                                        <div class="col-xl-12 col-md-12 col-sm-12 col-12">
                                                                            <h4> بارگذاری فایل موزیک</h4>
                                                                        </div>      
                                                                    </div>
                                                                </div>
                                                                <div class="widget-content widget-content-area">
                                                                    <input type="file" id="myfile" name="myfile" accept=".mp3" class="btn btn-success mb-2 mr-2"><br><br>
                                                                                
                                                                    <div>

                                                                    </div>


                                                                </div>
                                                                <div class="widget-header">
                                                                    <div class="row">
                                                                        <div class="col-xl-12 col-md-12 col-sm-12 col-12">
                                                                            <h4> بارگذاری عکس موزیک</h4>
                                                                        </div>      
                                                                    </div>
                                                                </div>
                                                                <div class="widget-content widget-content-area">
                                                                    <div class="custom-file-container" data-upload-id="myFirstImage">
                                                                        <label>بارگذاری  <a href="javascript:void(0)" class="custom-file-container__image-clear" title="Clear Image">x</a></label>
                                                                        <label class="custom-file-container__custom-file" >
                                                                            <input type="file" class="custom-file-container__custom-file__custom-file-input" accept="image/*">
                                                                                <input type="hidden" name="MAX_FILE_SIZE" value="10485760" />
                                                                                <span class="custom-file-container__custom-file__custom-file-control"></span>
                                                                        </label>
                                                                        <div class="custom-file-container__image-preview"></div>
                                                                    </div>

                                                                    <div>

                                                                    </div>

                                                                    <button class="btn btn-success mb-3 mr-3">دخیره</button>
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
                                    <script src="<%=application.getContextPath()%>/ControlPanel/plugins/file-upload/file-upload-with-preview.min.js"></script>

                                    <script>
                                        //First upload
                                        var firstUpload = new FileUploadWithPreview('myFirstImage');
                                        //Second upload
                                        var secondUpload = new FileUploadWithPreview('mySecondImage');
                                                                                                                                                                        </script>
                                    <!-- END PAGE LEVEL PLUGINS -->    


                                    <!-- Modal ADD SINGER -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">انتخاب خواننده</h5>

                                                </div>
                                                <div class="modal-body">
                                                    <div class="table-responsive mb-4 mt-4">
                                                        <table id="zero-config" class="table table-hover" style="width:100%">
                                                            <thead>
                                                                <tr>
                                                                    <th>نام  </th>
                                                                    <th> نام خانوادگی </th>
                                                                    <th> تاریخ تولد </th>

                                                                    <th class="no-content"></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>جواد</td>
                                                                    <td>1399/01/01</td>
                                                                    <td>تهران</td>
                                                                    
                                                                    <td><button class="btn" data-dismiss="modal"><i class="flaticon-cancel-12"></i> انتخاب</button></td>
                                                                </tr>
                                                            </tbody>
                                                            
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    </div>
                                    <!-- Modal ADD SINGER -->
                                    
                                    
                                      <!-- Modal ADD Album -->
                                    <div class="modal fade" id="exampleModalAlum" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">انتخاب آلبوم</h5>

                                                </div>
                                                <div class="modal-body">
                                                    <div class="table-responsive mb-4 mt-4">
                                                        <table id="Album-config" class="table table-hover" style="width:100%">
                                                            <thead>
                                                                <tr>
                                                                    <th>نام آلبوم  </th>
                                                                    <th> خواننده </th>
                                                                    <th> تاریخ تولید </th>

                                                                    <th class="no-content"></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>جواد</td>
                                                                    <td>1399/01/01</td>
                                                                    <td>تهران</td>
                                                                    
                                                                    <td><button class="btn" data-dismiss="modal"><i class="flaticon-cancel-12"></i> انتخاب</button></td>
                                                                </tr>
                                                            </tbody>
                                                            
                                                        </table>
                                                    </div>
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
                                                    <h5 class="modal-title" id="exampleModalLabel">انتخاب دسته بندی موزیک</h5>

                                                </div>
                                                <div class="modal-body">
                                                    <div class="table-responsive mb-4 mt-4">
                                                        <table id="Category-config" class="table table-hover" style="width:100%">
                                                            <thead>
                                                                <tr>
                                                                    <th>نام دسته  </th>
                                                                    <th> نام زیر محموعه </th>
                                                                    

                                                                    <th class="no-content"></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>جواد</td>
                                                                    <td>1399/01/01</td>
                                                                    
                                                                    
                                                                    <td><button class="btn" data-dismiss="modal"><i class="flaticon-cancel-12"></i> انتخاب</button></td>
                                                                </tr>
                                                            </tbody>
                                                            
                                                        </table>
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
