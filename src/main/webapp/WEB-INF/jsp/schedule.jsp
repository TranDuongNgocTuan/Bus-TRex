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

<jsp:include page="header.jsp"></jsp:include>

  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">TUYẾN XE</h1>
      </div>
      <!-- /.col-lg-12 -->
    </div>

    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            Danh sách các tuyến xe
          </div>
          <!-- /.panel-heading -->
          <%--<div class="panel-body">--%>

            <%--<div class="row">--%>
              <%--<div class="col-xs-12 col-sm-8 col-md-6">--%>
                <%--<form:form action="schedule/search" method="get">--%>
                  <%--<div class="input-group">--%>
                    <%--<input name="searchInput" type="text" class="form-control" placeholder="Search for price,arrival,departure..."/>--%>
                          <%--<span class="input-group-btn">--%>
                              <%--<button class="btn btn-outline btn-primary" type="submit">Search</button>--%>
                          <%--</span>--%>
                  <%--</div>--%>
                <%--</form:form>--%>
              <%--</div>--%>
              <%--<div class="col-sm-3">--%>
                <%--<a href="schedule/create" role="button" class="btn btn-outline btn-primary">Add</a>--%>
              <%--</div>--%>
            <%--</div>--%>
          <div class="panel-body">
            <div class="row">
              <div class="col-sm-3">
                <a href="schedule/create" role="button" class="btn btn-outline btn-primary">Add</a>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-md-12">
                <div class="dataTables_wrapper">
                  <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                    <tr>
                      <th>Id</th>
                      <th>BusService</th>
                      <th>Departure</th>
                      <th>Arrival</th>
                      <th>Distance</th>
                      <th>Number day</th>
                      <th>Number trip</th>
                      <th>Date start</th>
                      <th>Price ticket</th>
                      <th>&nbsp</th>
                      <th>&nbsp</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bus" items="${busList}">
                      <tr>
                        <td>${bus.id}</td>
                        <td>${bus.busServicesEntity.name}</td>
                        <td>${bus.departure.name}</td>
                        <td>${bus.arrival.name}</td>
                        <td>${bus.distance}</td>
                        <td>${bus.numberDay}</td>
                        <td>${bus.numberTrip}</td>
                        <td>${bus.dateStart}</td>
                        <td>${bus.priceTicket}</td>
                        <td><button class="btn btn-sm btn-outline btn-primary" onclick="location.href='schedule/edit/${bus.id}'">Edit</button></td>
                        <td><button class="btn btn-sm btn-outline btn-danger" onclick="location.href='schedule/delete/${bus.id}'">Delete</button></td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
                <i class="text-success">${message}</i><br/>
              </div>
              <!-- /.table-responsive -->

            </div>
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

<script src="../../resource/admin/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../resource/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../resource/admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../../resource/admin/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="../../resource/admin/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script src="../../resource/admin/bower_components/datatables-responsive/js/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../../resource/admin/dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
  $(document).ready(function() {
    $('#dataTables-example').DataTable({
      responsive: true
    });
  });
</script>
</body>

</html>
