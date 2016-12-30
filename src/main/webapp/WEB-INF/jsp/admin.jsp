<%@ page import="com.iviettech.bus.entity.AdminEntity" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ADMIN</title>



</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <%
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.now();
                    %>
                <h1 class="page-header">Hôm nay <%=dtf.format(localDate)%></h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="panel-body">
                        <div class="dataTables_wrapper">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>HÃNG XE</th>
                                        <th>LOẠI XE</th>
                                        <th>NGÀY</th>
                                        <th>KHỞI HÀNH</th>
                                        <th>KẾT THÚC</th>
                                        <th>THÔNG TIN BÁN</th>
                                        <th>CÒN LẠI</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% int stt=0;
                                %>
                                <c:forEach var="tho" items="${tableschedule}">
                                    <tr>
                                        <% stt++;
                                            %>
                                        <td><%=stt%></td>
                                        <td>${tho.scheduleEntity.busServicesEntity.name}</td>
                                        <td>${tho.busEntity.licensePlate}</td>
                                        <td>${tho.scheduleEntity.dateStart}</td>
                                        <td>${tho.scheduleEntity.arrival.name}</td>
                                        <td>${tho.scheduleEntity.departure.name}</td>

                                        <td>
                                            <h5>Giữ chỗ: <strong style="color: red">6</strong></h5>
                                            <h5 style="display: inline-block">Đã bán: <strong style="color: red">2</strong></h5>
                                        </td>
                                        <td><h5 style="display: inline-block">Còn lại: <strong style="color: red">28</strong></h5></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->


<!-- /#wrapper -->

<!-- jQuery -->
<jsp:include page="footer.jsp"></jsp:include>

    <%--<script src="../../resource/admin/bower_components/jquery/dist/jquery.min.js"></script>--%>

    <!-- Bootstrap Core JavaScript -->
    <%--<script src="../../resource/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>--%>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../../resource/admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../../resource/admin/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="../../resource/admin/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <script src="../../resource/admin/bower_components/datatables-responsive/js/dataTables.responsive.js"></script>

    <%--<!-- Custom Theme JavaScript -->--%>
    <script src="../../resource/admin/dist/js/sb-admin-2.js"></script>

    <%--<!-- Page-Level Demo Scripts - Tables - Use for reference -->--%>
    <script>
        $(document).ready(function() {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>

</body>

</html>
