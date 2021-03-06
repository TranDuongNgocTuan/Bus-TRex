<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="description" content="HTML5 QR code Reader : A cross platform HTML5 QR code reader.">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
          rel="stylesheet">
    <link rel="stylesheet" href="/resource/vendor/bootstrap.css">
    <link rel="stylesheet" href="/resource/css/findticket.css">
    <link rel="stylesheet" href="/resource/css/choosechair.css">
    <link rel="stylesheet" href="/resource/css/transfer.css">
    <link rel="stylesheet" href="/resource/css/scanticket.css">
    <link rel="stylesheet" type="text/css" href="/resource/css/chair.css">
    <script type="text/javascript" src="/resource/vendor/bootstrap.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="/resource/js/html5-qrcode.min.js"></script>
    <script src="/resource/js/html5-qrcode.js"></script>
    <script src="/resource/js/main.js"></script>
    <title>Nhân viên</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">DATVE</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/">Trang chủ</a>
                </li>
                <li>
                    <a href="/scanticket">Kiểm tra vé</a>
                </li>
                <li>
                    <a href="<c:url value="/loginstaff"/>">Nhân viên xe</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
</nav>
<!-- end bar -->

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <img src="../../resource/img/Banner_Trang_Chu_(PC)_-_With_Clock.png" class="img-reponsive">
        </div>
    </div>
</div>
<!-- end poster -->

<div class="notify-waring-success">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="notify">
            </div>
        </div>
    </div>
</div>



<!-- MAIN CONTENT -->
<div class="payment">
    <div class="container">
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 text-center">
                <h3 class="scantitle">Quyét vé hoặc tìm kiếm mã vé</h3>
                <div class="row">
                    <div class="col-lg-7">
                        <div class="input-group custom-search-form">
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
                <div id="reader" style="height:320px;">
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 button-camera">
                        <input type="button" class="btn btn-success" value="Scan" id="btn_scan"/>
                        <input type="button" class="btn btn-danger " value="Stop" id="btn_stop"/>
                    </div>
                </div>
            </div>
            <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 bill">
                <div class="row">
                    <div class="col-md-12" id="scanTicketInfo">
                        <table class="table table-borderless">
                            <tbody>
                            <tr>
                                <td colspan="4" class="text-bill">VÉ XE</td>
                            </tr>
                            <tr>
                                <td class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Tuyến:</td>
                                <td class="col-xs-3 col-sm-3 col-md-3 col-lg-3"
                                    colspan="1">${ticket.busstationEntityDeparture.city}
                                    đến ${ticket.busstationEntityArrival.city}</td>
                                <td class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Hãng Xe</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Ngày đi:</td>
                                <td>
                                    <span>${timeTableTicket.departureTime}</span>
                                    <span>${dayStartMove}</span>
                                </td>
                                <td>Ghế/giường:</td>
                                <td><span>${ticket.seat}</span></td>
                            </tr>
                            <tr>
                                <td>Điểm lên xe:</td>
                                <td colspan="3">${timeTableTicket.scheduleEntity.departure.name}
                                </td>
                            </tr>
                            <tr>
                                <td>Điểm lên kết thúc:</td>
                                <td colspan="3">${timeTableTicket.scheduleEntity.arrival.name}
                                </td>
                            </tr>
                            <tr class="sperator">
                                <td>Họ tên:</td>
                                <td>${ticket.fullName}</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${ticket.gmail}</td>
                                <td>SĐT:</td>
                                <td><span>${ticket.numberphone}</span></td>
                            </tr>
                            <tr>
                                <td>Tổng tiền:</td>
                                <td>
                                    <strong class="text-primary">${ticket.totalprice}<sup>₫</sup></strong>
                                </td>
                                <td>Thanh Toán:</td>
                                <td>Chưa thanh toán</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="footer-scanticket">
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <img src="/resource/img/icon-vxr.svg" class="pull-left" width="55px" height="55px">

                <p>Bản quyền © 2016 thuộc về VeXeRe.Com <br>
                    Tên công ty: CÔNG TY CỔ PHẦN VEXERE <br>
                    Địa chỉ đăng ký kinh doanh: 8C Chữ Đồng Tử, Phường 7, Quận Tân Bình, Thành Phố Hồ Chí Minh, Việt Nam
                    <br>
                    Địa chỉ: 79/i8 Âu Cơ, P.14, Q.11, TP. Hồ Chí Minh, Việt Nam <br>
                    Giấy chứng nhận ĐKKD số 0312387105 do Sở KH& ĐT TP. Hồ Chí Minh cấp lần đầu ngày 25/7/2013
                </p>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <div class="row">
                    <!-- <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="img/certificate1.png">
                    </div> -->
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- end footer -->

</body>
</html>