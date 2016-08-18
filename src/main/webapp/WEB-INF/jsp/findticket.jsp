<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> Example </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="webjars/tooltipster/dist/css/tooltipster.bundle.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="webjars/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-noir-customized.css"/>
    <link rel="stylesheet" href="webjars/vendor/bootstrap.css">
    <link rel="stylesheet" href="webjars/css/findticket.css">
    <link rel="stylesheet" href="webjars/css/intlTelInput.css">
    <link rel="stylesheet" href="webjars/css/demo.css">
    <script type="text/javascript" src="webjars/vendor/bootstrap.js"></script>
    <script type="text/javascript" src="webjars/js/findticket.js"></script>
    <script type="text/javascript" src="webjars/js/chair.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="webjars/js/intlTelInput.js"></script>
    <script type="text/javascript" src="webjars/tooltipster/dist/js/tooltipster.bundle.min.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/css/bootstrap-datepicker.standalone.min.css">
    <script type="text/javascript" src="webjars/js/bootstrap-datepicker.min.js"></script>
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
            <a class="navbar-brand" href="#">DATVE</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Trang chủ</a></li>
                <li><a href="#">Kiểm tra vé</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
</nav>
<!-- end bar -->

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <img src="webjars/img/Banner_Trang_Chu_(PC)_-_With_Clock.png" class="img-reponsive">
        </div>
    </div>
</div>
<!-- end poster -->

<div class="localtion">
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <p>Vé xe từ</p>
                <h4>Đà Nẵng đi Hải Phòng</h4>

                <div class="date-picker">
                    <div class="pull-left date-wapper">
                        <button id="btPrevDate" style="" type="button" class="btn btn-default"><i
                                class="fa fa-caret-left fa-lg"></i></button>
                        <!-- <input type="button" id="span-current-date" value="10-08-2016" tabindex="1" class="btn btn-vxr current-date hasDatepicker"> -->
                        <div class="input-group date" data-provide="datepicker">
                            <input type="text" class="form-control">

                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                        <button id="btNextDate" type="button" class="btn btn-default"><i
                                class="fa fa-caret-right fa-lg"></i></button>
                    </div>
                    <div class="pull-left ml10 modify-container">
                        <a id="btModify" class="text-blue" href="#"><b>Sửa nơi đi, nơi đến, ngày đi</b></a>
                    </div>
                </div>
            </div>
            <div class="logo col-md-4 col-sm-4 hidden-xs mt10">
                <div class="pull-right col-md-12">
                    <div class="col-md-5 pr0 text-right">
                        <img height="42" src="webjars/img/lock-sercurity.png" type="image/svg+xml">
                    </div>
                    <div class="col-md-7 secure-col pull-right">
                        <span>Thanh toán online</span><br>
                        <span>An toàn &amp; Bảo mật</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end choose location -->
</div>

<div class="barsearch">
    <div class="container">
        <table class="table">
            <tbody>
            <tr>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-bus"></i><span>Hãng xe</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort1 fa fa-sort-asc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i
                                class="fa fa-clock-o"></i><span>Giờ đi</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort2 fa fa-sort-asc "></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-map-marker"></i><span>Nơi đi</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort3 fa fa-sort-asc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-map-marker"></i><span>Nơi đến</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort4 fa fa-sort-asc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i
                                class="fa fa-puzzle-piece"></i><span>Sơ đồ ghế</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort5 fa fa-sort-asc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-star"></i><span>Đánh giá</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort6 fa fa-sort-asc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i
                                class="fa fa-ticket"></i><span>Vé xe</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="fa fa-sort-asc"></i></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- end search -->

<div class="ticket">
    <div class="container">
        <c:forEach var="schedule" items="${ticketList}">
            <b:forEach var="buses" items="${schedule.busesEntityList}">
                <div class="row">
                    <table class="table table-borderless">
                        <tr>
                            <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2 fix-border">
                                <div class="container-bus">
                                    <h4 class="">${buses.busEntity.busServicesEntity.name}</h4>
                                    <i class="glyphicon glyphicon-align-left"></i>
                                    <i class="glyphicon glyphicon-picture"></i>
                                    <i class="glyphicon glyphicon-plus-sign"></i>
                                </div>
                                <div class="pull-left">
                                    <i class="fa fa-bus"></i>
                                </div>
                            </td>
                            <!-- end ìnformation bus -->
                            <td class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                <div class="pull-left">
                                    <i class="glyphicon glyphicon-time"></i>
                                </div>
                                <div class="container-time">
                                    <h4 class=""><fmt:formatDate value="${schedule.departureTime}" type="time"/>→
                                        <fmt:formatDate value="${schedule.arriveTime}" type="time"/></h4>
                                    <c:set var="periodHours">
                                        <fmt:formatNumber
                                                value="${(schedule.arriveTime.time - schedule.departureTime.time)/3600000}"
                                                minFractionDigits="0" maxFractionDigits="0"/>
                                    </c:set>

                                    <c:set var="periodMinute">
                                        <fmt:formatNumber
                                                value="${(schedule.arriveTime.time - schedule.departureTime.time)/3600000 - periodHours}"
                                                minFractionDigits="0" maxFractionDigits="0"/>
                                    </c:set>

                                        <%--<c:set value="${Interger(periodHours)}" var="periodMinute"/>--%>
                                        <%--<fmt:parseDate value="${periodTime}" var="dateObject"--%>
                                        <%--pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                                        <%--<fmt:formatDate value="${periodDay}" pattern="time" />--%>
                                    <p>Thời gian: ${periodHours}h${periodMinute}'</p>
                            <span class="tooltiphover" data-tooltip-content="#tooltip_${buses.id}_from">${from.name}<i
                                    class="fa fa-sort-desc"></i></span>
                            <span class="tooltiphover" data-tooltip-content="#tooltip_${buses.id}_to">→${to.name}<i
                                    class="fa fa-sort-desc"></i></span>
                                </div>
                            </td>
                            <!-- end time from to -->
                            <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                <div class="container-chair text-center">
                                    <p class="">Giường nằm 40 chỗ</p>

                                    <p class="space">Còn
                                        trống:${buses.busEntity.seats-buses.ticketEntityList.size()}</p>
                                </div>
                            </td>
                            <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                <div class="container-start text-center">

                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                            </td>
                            <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                <div class="">
                                    <h4 class="money">300000<sup>đ</sup></h4>

                                    <div class="container-ticket text-center" data-toggle="collapse"
                                         data-target="#${buses.id}">
                                        <i class="fa fa-bus"></i><span>Đặt vé</span>
                                    </div>
                                </div>
                            </td>
                            <!-- end time from to -->
                        </tr>
                        <tr>
                            <td class="col-xs-12 col-sm-12 col-md-12 col-lg-12 info" colspan="5">
                                <div id="${buses.id}" class="collapse info-wapper">
                                    <div class="info-tilte">
                                        <div class="row">

                                            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 text-center">
                                                <h4>Điện đặt vé</h4>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 text-center">
                                                <h4>Thông tin vé xe</h4>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 text-center">
                                                <h4>Phản hồi <br> của khách hàng</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end row title -->
                                    <div class="info-chair">
                                        <div class="row">
                                            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                                <form action="" method="POST" role="form" class="info-form">
                                                    <legend>Form title</legend>
                                                    <div class="row">
                                                        <div class="form-group form-inline">
                                                            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                                                <label class="info-label">Họ Tên:</label>
                                                            </div>
                                                            <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                                                <input type="text" required class="form-control"
                                                                       placeholder="Tran Van A">
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group form-inline">
                                                            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                                                <label class="info-label">Phone:</label>
                                                            </div>
                                                            <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                                                <input type="tel" id="phone" required
                                                                       class="form-control"
                                                                       placeholder="VD: 0912345678">
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group form-inline">
                                                            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                                                <label class="info-label">Email:</label>
                                                            </div>
                                                            <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                                                <input type="email" required class="form-control"
                                                                       placeholder="vexe@gmail.com">
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <button type="submit"
                                                            class="btn btn-primary pull-right container-ticket text-center">
                                                        <i
                                                                class="fa fa-bus"></i><span>Tiếp tục</span></button>
                                                </form>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                                <table class="table">
                                                    <tr>
                                                        <td>Tuyến đường</td>
                                                        <td class="info-table-ticket">Bến xe khách Đà Nẵng - VP Buôn Ma
                                                            Thuộc
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Xuất phát</td>
                                                        <td class="info-table-ticket">Bến Xe Khách Đà Nãng</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Đích đến</td>
                                                        <td class="info-table-ticket">VP Buôn Ma Thuột</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Giờ xuất bến</td>
                                                        <td class="info-table-ticket">17:30 12-09-2016</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Giờ đến</td>
                                                        <td class="info-table-ticket">05:30</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Giá vé</td>
                                                        <td class="info-table-ticket">280.000/người</td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                                <div class="row">
                                                    <h3 class="text-center">Bạn có thích dịch vụ không ?</h3>

                                                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 col-md-push-2">
                                                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                            <div class="like text-center">
                                                                <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>

                                                                <p class="like-text">Thích</p>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                            <div class="dislike text-center">
                                                                <i class="fa fa-thumbs-o-down" aria-hidden="true"></i>

                                                                <p class="dislike-text">Không Thích</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="contact">
                                                        <h4 class="name-car">Xe HAV</h4>
                                                        <h4 class="name-from">VP</h4>

                                                        <h2 class="number-mobile"><i
                                                                class="glyphicon glyphicon-phone-alt"></i>05116
                                                            505 050</h2>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end information ticket -->
                                    <div class="info-end"></div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </b:forEach>
        </c:forEach>
    </div>
    <!-- end show ticket -->
</div>

<div class="distance">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <a href="" class="btn btn-default">THÔNG TIN TUYẾN ĐƯỜNG ĐÀ NẴNG HẢI PHÒNG</a>

                <p>Giá vé trung bình : 402.500 VNĐ Giá vé trên chưa bao gồm phụ thu các ngày Lễ Tết.</p>
            </div>
        </div>
    </div>
</div>

<div class="about">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <h3>Hãng xe</h3>
            </div>
            <div class="col-lg-2 col-md-2">
                <ul>
                    <li><a href="">Xe Sao Việt </a></li>
                    <li><a href="">Xe Sapa Express </a></li>
                    <li><a href="">Xe Thành Công </a></li>
                    <li><a href="">Xe Thanh Vân </a></li>
                    <li><a href="">Xe Thuận Thảo </a></li>
                    <li><a href="">Xe Thuận Tiến </a></li>
                    <li><a href="">Xe Năm Rùm </a></li>
                    <li><a href="">Xe Việt Lào </a></li>
                </ul>
            </div>
            <div class="col-lg-2  col-md-2">
                <ul>
                    <li><a href="">Xe Sao Việt </a></li>
                    <li><a href="">Xe Sapa Express </a></li>
                    <li><a href="">Xe Thành Công </a></li>
                    <li><a href="">Xe Thanh Vân </a></li>
                    <li><a href="">Xe Thuận Thảo </a></li>
                    <li><a href="">Xe Thuận Tiến </a></li>
                    <li><a href="">Xe Năm Rùm </a></li>
                    <li><a href="">Xe Việt Lào </a></li>
                </ul>
            </div>
        </div>

    </div>
</div>

<div class="help">
    <div class="container">
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <h3>Về chúng tôi</h3>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <h3>Hỗ trợ</h3>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <h3>Kết nối</h3>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <hr>
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <img src="webjars/img/icon-vxr.png" class="pull-left" width="55px" height="55px">

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
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="webjars/img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="webjars/img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="webjars/img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="webjars/img/certificate1.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- end footer -->
<c:forEach var="schedule" items="${ticketList}">
    <b:forEach var="buses" items="${schedule.busesEntityList}">
        <div class="tooltip" style="display: none">
		<span id="tooltip_${buses.id}_from">
			<div class="title">Thông tin điểm xuất phát</div>
			<p class="localgo">${from.address}</p>
			<span></span>
		</span>
        </div>
        <div class="tooltip" style="display: none">
		<span id="tooltip_${buses.id}_to">
			<div class="title">Thông tin điểm đến</div>
			<p class="localgo">${to.address}</p>
			<span></span>
		</span>
        </div>
    </b:forEach>
</c:forEach>

<script>
    $(document).ready(function () {
        $('.tooltiphover').tooltipster({
            theme: ['tooltipster-noir', 'tooltipster-noir-customized'],
            contentCloning: true,
        });
    });
</script>
</body>
</html>