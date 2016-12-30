<%@ page import="com.iviettech.bus.entity.TicketEntity" %>
<%@ page import="com.iviettech.bus.service.TicketInfomationService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iviettech.bus.entity.AdminEntity" %>
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
                  <th>STT</th>
                  <th>TÊN</th>
                  <th>THỜI GIAN ĐẶT</th>
                  <th>SĐT</th>

                  <th>CHI TIẾT</th>
                  <th>Gmail</th>

                  <th>TỔNG TIỀN</th>
                  <th>TÌNH TRẠNG</th>
                </tr>
                <tbody>
                <c:forEach var="ticket" items="${tho}">
                  <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.fullName}</td>
                    <td>${ticket.bookTime}</td>
                    <td>${ticket.numberphone}</td>

                    <td>${ticket.gmail}</td>
                    <td>${ticket.totalprice}</td>
                    <td>${ticket.status == 1 ? "Đã thanh toán":"Chưa thanh toán"}</td>

                    <td class="btncenter">
                      <a class="btn btn-default" data-toggle="modal" href="#modal-id-${ticket.id}"><i class="fa fa-eye" aria-hidden="true"></i> Xem Chi tiết</a>
                      <div class="modal fade" id="modal-id-${ticket.id}">
                        <div class="modal-dialog" style="min-width: 400px; width: 60%;">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <div class="modal-title text-center">Thông tin chi tiết </div>
                            </div>
                            <div class="modal-body">
                              <div class="toppad">
                                <div class="panel panel-info">
                                  <div class="panel-heading" style="background-color: #BD4419;">
                                    <h3 class="panel-title" style="font-weight: 500;">${ticket.id}</h3>
                                  </div>
                                  <div class="panel-body">
                                    <div class="row">
                                      <div class="col-md-9 col-lg-9">
                                        <table class="table table-user-information table-hover">
                                          <tbody>
                                          <tr>
                                            <td>Nơi đến:</td>
                                            <td>${ticket.busstationEntityDeparture.name}</td>
                                          </tr>
                                          <tr>
                                            <td>Nơi đi:</td>
                                            <td>
                                                ${ticket.busstationEntityArrival.name}
                                            </td>
                                          </tr>
                                          <tr>
                                            <td>Hãng xe:</td>
                                            <td>
                                                ${ticket.busesEntity.timeTableScheduleEntity.busEntity.busServicesEntity.name}
                                            </td>
                                          </tr>
                                          <tr>
                                            <td>Ký hiệu xe:</td>
                                            <td>
                                                ${ticket.busesEntity.timeTableScheduleEntity.busEntity.licensePlate}
                                            </td>
                                          </tr>
                                          <tr>
                                            <td>Chỗ:</td>
                                            <td>${ticket.seat}</td>
                                          </tr>
                                          </tbody>
                                        </table>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-close" aria-hidden="true"></i> Đóng</button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </td>





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
