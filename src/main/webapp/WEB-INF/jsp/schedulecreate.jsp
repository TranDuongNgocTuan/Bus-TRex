<%@ page import="com.iviettech.bus.entity.AdminEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
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
            Thêm tuyến xe
          </div>
          <!-- /.panel-heading -->
          <div class="panel-body">
            <div class="row">
              <div class="col-md-12">
                <form:form method="POST" commandName="schedule" action="${pageContext.request.contextPath}/schedule/create">
                  <div class="form-group">

                    <label class="control-label">BusService (*)</label>
                    <tr class="dropdown-menu">
                      <td>
                        <select name="busservice123" class="form-control">
                          <c:forEach var="bus" items="${busservice123}">
                            <option value="${bus.id}">${bus.name}</option>
                          </c:forEach>
                        </select>
                      </td>
                    </tr>

                    <label class="control-label">Departure (*)</label>
                    <tr class="dropdown-menu">
                      <td>
                        <select name="departure" class="form-control">
                          <c:forEach var="bus" items="${busservice}">
                            <option value="${bus.id}">${bus.name}</option>
                          </c:forEach>
                        </select>
                      </td>
                    </tr>
                    <label class="control-label">Arrival (*)</label>
                    <tr class="dropdown-menu">
                      <td>
                        <select name="arrival" class="form-control">
                          <c:forEach var="bus" items="${busservice}">
                            <option value="${bus.id}">${bus.name}</option>
                          </c:forEach>
                        </select>
                      </td>
                    </tr>
                    <label class="control-label">Distance (*)</label>
                    <form:input path="distance" type="text" class="form-control"  required="true"/>
                    <form:errors path="distance" cssStyle="color: red;"/>
                    <label class="control-label">Number day (*)</label>
                    <form:input path="numberDay" type="text" class="form-control"  required="false"/>
                    <form:errors path="numberDay" cssStyle="color: red;"/>
                    <label class="control-label">Number trip (*)</label>
                    <form:input path="numberTrip" type="text" class="form-control"  required="true"/>
                    <form:errors path="numberTrip" cssStyle="color: red;"/>
                    <label class="control-label">Date start (*)</label>
                    <form:input path="dateStart" type="date" class="form-control"  required="true"/>
                    <form:errors path="dateStart" cssStyle="color: red;"/>
                    <label class="control-label">Price ticket (*)</label>
                    <form:input path="priceTicket" type="text" class="form-control"  required="true"/>
                    <form:errors path="priceTicket" cssStyle="color: red;"/>
                  </div>
                  <br>
                  <button type="submit" class="btn btn-info">Tạo</button>
                </form:form>

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

</body>

</html>
