<%@ page import="com.iviettech.bus.entity.AdminEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>

  <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>ADMIN</title>

  <!-- Bootstrap Core CSS -->
  <link href="../../resource/admin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="../../resource/admin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

  <!-- Timeline CSS -->
    <link href="../../resource/admin/dist/css/timeline.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="../../resource/admin/dist/css/sb-admin-2.css" rel="stylesheet">

  <!-- Morris Charts CSS -->
  <link href="../../resource/admin/bower_components/morrisjs/morris.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="../../resource/admin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- DataTables CSS -->
  <link href="../../resource/admin/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

  <!-- DataTables Responsive CSS -->
  <link href="../../resource/admin/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body>

<div id="wrapper">
  <%
    AdminEntity adminEntity = (AdminEntity) session.getAttribute("adminEntity");
    if (adminEntity==null || adminEntity.getRoleEntity().getLevel()!=1) {
      response.sendRedirect("/login");
    }
  %>
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="admin.jsp">QUẢN LÝ</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="profile"><i class="fa fa-user fa-fw"></i> Hồ sơ Admin</a>
          </li>
          <li class="divider"></li>
          <li><a href="login"><i class="fa fa-sign-out fa-fw"></i>Đăng xuất</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
          <li class="sidebar-search">
            <div class="input-group custom-search-form">
              <input type="text" class="form-control" placeholder="Tìm kiếm...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                  <i class="fa fa-search"></i>
                                </button>
                            </span>
            </div>
            <!-- /input-group -->
          </li>
          <li>
            <a href="/admin"><i class="fa fa-home fa-fw"></i> Trang chủ</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Quản lý<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="/ticketinformation"><i class="fa fa-info fa-fw"></i> Thông tin vé</a>
              </li>
              <li>
                <a href="/schedule"><i class="fa fa-bars fa-fw"></i> Tuyến xe</a>
              </li>
              <li>
                <a href="/buscompany"><i class="fa fa-bus fa-fw"></i> Hãng xe</a>
              </li>
              <li>
                <a href="/taixe"><i class="fa fa-male fa-fw"></i> Tài xế</a>
              </li>
              <li>
                <a href="/promotion"><i class="fa fa-usd fa-fw" ></i> Khuyến mãi</a>
              </li>
              <li>
                <a href="/busstation"><i class="fa fa-home fa-fw" ></i> Bến xe</a>
              </li>
            </ul>
            <!-- /.nav-second-level -->
          </li>
          <li>
            <a href="#"><i class="fa fa-area-chart fa-fw"></i> Tổng kết doanh thu</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-image fa-fw"></i> Hình ảnh</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-users fa-fw"></i> Nói về chúng tôi</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-thumbs-o-up fa-fw"></i> Giới thiệu</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-phone fa-fw"></i> Liên hệ</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-shopping-cart fa-fw"></i> Hướng dẫn thanh toán</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-exclamation-circle fa-fw"></i> Quy chế</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-question fa-fw"></i> Câu hỏi thường gặp</a>
          </li>
        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <script src="../../resource/admin/bower_components/morrisjs/morris.min.js"></script>
    <script src="../../resource/js/morris-data.js"></script>
    <!-- /.navbar-static-side -->
  </nav>

  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">HÌNH ẢNH</h1>
      </div>
      <!-- /.col-lg-12 -->
    </div>

    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            Danh sách các hình
          </div>
          <!-- /.panel-heading -->
          <div class="panel-body">

            <div class="row">
              <div class="col-sm-3">
                <a href="/image/create" role="button" class="btn btn-outline btn-primary">Add</a>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="table-responsive">
                  <table class="table table-condensed table-hover">
                    <thead>
                    <tr>
                      <th>Id</th>
                      <th>Image</th>
                      <th></th>
                      <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bus" items="${busList}">
                      <tr>
                        <td>${bus.id}</td>
                        <td>${bus.address}</td>
                        <td><button class="btn btn-sm btn-outline btn-primary" onclick="location.href='buscompany/edit/${bus.id}'">Edit</button></td>
                        <td>  <button class="btn btn-sm btn-outline btn-danger" onclick="location.href='buscompany/delete/${bus.id}'">Delete</button></td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
              <!-- /.table-responsive -->

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../../resource/admin/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../resource/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../resource/admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="../../resource/admin/bower_components/raphael/raphael-min.js"></script>


<!-- Custom Theme JavaScript -->
<script src="../../resource/admin/dist/js/sb-admin-2.js"></script>

</body>

</html>
