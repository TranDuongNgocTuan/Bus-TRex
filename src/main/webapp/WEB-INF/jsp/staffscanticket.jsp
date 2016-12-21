<%@ page import="com.iviettech.bus.entity.TaiXeEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    TaiXeEntity taiXeEntity = (TaiXeEntity) session.getAttribute("taixe");
    if (taiXeEntity==null) {
        response.sendRedirect("/loginstaff");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Advanced form elements</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="resource/adminstaff/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="resource/adminstaff/plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="resource/adminstaff/plugins/datepicker/datepicker3.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="resource/adminstaff/plugins/iCheck/all.css">
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet" href="resource/adminstaff/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet" href="resource/adminstaff/plugins/timepicker/bootstrap-timepicker.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="resource/adminstaff/plugins/select2/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resource/adminstaff/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="resource/adminstaff/dist/css/skins/_all-skins.min.css">

    <link rel="stylesheet" href="/resource/css/staffscanticket.css">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="/resource/js/staffscanticket.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b></b>VX</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>VEXE</b></span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                    </li>
                    <!-- /.messages-menu -->

                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="resource/adminstaff/dist/img/taxi-driver.png" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">Tran Van A</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="resource/adminstaff/dist/img/taxi-driver.png" class="img-circle"
                                     alt="User Image">

                                <p>
                                    Tran Van A - Nhan Vien Thu Tien
                                    <small><!-- Member since Nov. 2012 --></small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/signout" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="resource/adminstaff/dist/img/taxi-driver.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Tran Van A</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->
            <!-- <form action="#" method="get" class="sidebar-form">
              <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                      <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                      </button>
                    </span>
              </div>
            </form> -->
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">CHỨC NĂNG</li>
                <!-- Optionally, you can add icons to the links -->
                <li><a href="<c:url value="/adminstaff"/>"><i
                        class="fa fa-dashboard"></i><span>Bảng Điều Khiển</span></a></li>
                <li><a href="<c:url value="/showticketstaff"/>"><i class="fa fa-table"></i><span>Vé Xe</span></a></li>
                <li class="active"><a href="<c:url value="/adminscanstaff"/> "><i class="fa fa-money"
                                                                                  aria-hidden="true"></i><span>Thanh Toán</span></a>
                </li>

                <!-- <li class="treeview">
                  <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>
                    <span class="pull-right-container">
                      <i class="fa fa-angle-lèt pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                    <li><a href="#">Link in level 2</a></li>
                    <li><a href="#">Link in level 2</a></li>
                  </ul>
                </li> -->
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Thanh Toán
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Chức năng</a></li>
                <li class="active">Thanh Toán</li>
            </ol>
        </section>

        <%-- notify --%>
        <div class="notify-waring-success">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="notify">
                    </div>
                </div>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="input-group custom-search-form">
                            <input type="hidden" value="<%= taiXeEntity.getBusEntity().getBusServicesEntity().getId() %>" name="busService" class="taiXeOfBuseService">
                            <input type="text" class="form-control textcode" placeholder="Mã Vé">
                              <span class="input-group-btn">
                              <button class="btn btn-primary" type="button" id="search">
                                  <span class="glyphicon glyphicon-search"></span>
                              </button>
                             </span>
                        </div>
                        <!-- /input-group -->
                    </div>
                </div>
            </div>

            <!-- SELECT2 EXAMPLE -->
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">Thông tin vé</h3>

                    <!--           <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                              </div>
                     -->        </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="row span-infoticket">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Mã vé</label>
                                <span class="codeticket"></span>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Họ Tên</label>
                                <span class="fullname"></span>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Số điện thoại</label>
                                <span class="numberphone"></span>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Gmail</label>
                                <span class="gmail"></span>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Nơi xuất phát</label>
                                <span class="departure"></span>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Nơi đến</label>
                                <span class="arrival"></span>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Giời đi</label>
                                <span class="departuretime"></span>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Giờ đến</label>
                                <span class="arrivaltime"></span>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Hãng xe</label>
                                <span class="buservices"></span>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Biển số xe</label>
                                <span class="plant"></span>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Số ghê</label>
                                <span class="seat"></span>
                            </div>
                            <!-- /.form-group -->
                            <div class="form-group">
                                <label>Tổng tiền</label>
                                <span class="totalprice"></span>
                            </div>
                            <!-- /.form-group -->
                        </div>
                        <!-- /.col -->
                        <form action="/payticketstaff">
                            <input type="hidden" name="codeticket" class="codeticketform">
                            <div class="col-xs-6 col-lg-3">
                                <button type="submit" class="btn btn-block btn-primary btnpayment">Thanh Toán</button>
                            </div>
                        </form>
                        <form action="/deleteticketstaff">
                            <input type="hidden" name="codeticket" class="codeticketform">
                            <div class="col-xs-6 col-lg-3">
                            <button type="submit" class="btn btn-block btn-danger btndelete">Hủy Vé</button>
                        </form>
                    </div>
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    Visit <a href="https://select2.github.io/">Select2 documentation</a> for more examples and
                    information about
                    the plugin.
                </div>
            </div>
            <!-- /.box -->

            <!-- /.row -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.6
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="resource/adminstaff/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="resource/adminstaff/bootstrap/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="resource/adminstaff/plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="resource/adminstaff/plugins/input-mask/jquery.inputmask.js"></script>
<script src="resource/adminstaff/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="resource/adminstaff/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="resource/adminstaff/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="resource/adminstaff/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- bootstrap color picker -->
<script src="resource/adminstaff/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="resource/adminstaff/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="resource/adminstaff/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="resource/adminstaff/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="resource/adminstaff/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="resource/adminstaff/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resource/adminstaff/dist/js/demo.js"></script>
<!-- Page script -->
<script>
    $(function () {
        //Initialize Select2 Elements
        $(".select2").select2();

        //Datemask dd/mm/yyyy
        $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
        //Datemask2 mm/dd/yyyy
        $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
        //Money Euro
        $("[data-mask]").inputmask();

        //Date range picker
        // $('#reservation').daterangepicker();
        //Date range picker with time picker
        // $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
        // //Date range as a button
        // $('#daterange-btn').daterangepicker(
        //     {
        //       ranges: {
        //         'Today': [moment(), moment()],
        //         'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
        //         'Last 7 Days': [moment().subtract(6, 'days'), moment()],
        //         'Last 30 Days': [moment().subtract(29, 'days'), moment()],
        //         'This Month': [moment().startOf('month'), moment().endOf('month')],
        //         'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        //       },
        //       startDate: moment().subtract(29, 'days'),
        //       endDate: moment()
        //     },
        //     function (start, end) {
        //       $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        //     }
        // );

        // //Date picker
        // $('#datepicker').datepicker({
        //   autoclose: true
        // });

        // //iCheck for checkbox and radio inputs
        // $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
        //   checkboxClass: 'icheckbox_minimal-blue',
        //   radioClass: 'iradio_minimal-blue'
        // });
        // //Red color scheme for iCheck
        // $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
        //   checkboxClass: 'icheckbox_minimal-red',
        //   radioClass: 'iradio_minimal-red'
        // });
        // //Flat red color scheme for iCheck
        // $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
        //   checkboxClass: 'icheckbox_flat-green',
        //   radioClass: 'iradio_flat-green'
        // });

        // //Colorpicker
        // $(".my-colorpicker1").colorpicker();
        // //color picker with addon
        // $(".my-colorpicker2").colorpicker();

        // //Timepicker
        // $(".timepicker").timepicker({
        //   showInputs: false
        // });
    });
</script>
</body>
</html>
