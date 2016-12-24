<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/19/2016
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>

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
  <title>AMIN</title>
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
      <h1 class="page-header">THÔNG TIN VÉ XE</h1>
    </div>
    <!-- /.col-lg-12 -->
  </div>
  <section class="content">
    <div class="row">
      <div class="col-xs-12">
        <div class="box">
          <div class="box-header">
            <h3 class="box-title"><a href="/downloadPDF">Download PDF Document</a></h3>
          </div>
          <!-- /.box-header -->
          <div class="panel-body">
            <div class="dataTables_wrapper">
              <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">

                <thead>
                <tr>
                  <th>Id</th>
                  <th>Full name</th>
                  <th>Booked time</th>
                  <th>Number phone</th>
                  <th>Total price</th>
                  <th>Seat</th>
                  <th>Number seats</th>
                  <th>Gmail</th>
                  <th>Bus station arrival</th>
                  <th>Bus station departure</th>
                </tr>
                <tbody>
                <c:forEach var="ticket" items="${tho}">
                  <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.fullName}</td>
                    <td>${ticket.bookTime}</td>
                    <td>${ticket.numberphone}</td>
                    <td>${ticket.totalprice}</td>
                    <td>${ticket.seat}</td>
                    <td>${ticket.numberSeats}</td>
                    <td>${ticket.gmail}</td>
                    <td>${ticket.busstationEntityArrival.name}</td>
                    <td>${ticket.busstationEntityDeparture.name}</td>
                  </tr>
                </c:forEach>
                </tbody>
                </thead>
              </table>
            </div>
          </div>
          <!-- /.box-body -->
        </div>
        <!-- /.box -->
      </div>
      <!-- /.col -->
    </div>
  </section>

</div>
<jsp:include page="footer.jsp"></jsp:include>
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
