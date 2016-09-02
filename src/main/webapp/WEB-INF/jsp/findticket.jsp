<%@ page import="com.iviettech.bus.repository.ScheduleRepository" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> Example </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="resource/css/star-rating.css" media="all" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="resource/tooltipster/dist/css/tooltipster.bundle.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="resource/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-noir-customized.css"/>
    <link rel="stylesheet" href="resource/vendor/bootstrap.css">
    <link rel="stylesheet" href="resource/css/findticket.css">
    <link rel="stylesheet" href="resource/css/intlTelInput.css">
    <link rel="stylesheet" href="resource/css/demo.css">
    <link rel="stylesheet" href="/resource/css/jquery-ui.css">
    <link rel="stylesheet" href="/resource/css/bootstrap-datepicker.min.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
    <script type="text/javascript" src="resource/js/findticket.js"></script>
    <script src="/resource/js/bootstrap-datepicker.min.js"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="resource/vendor/bootstrap.js"></script>
    <script type="text/javascript" src="resource/js/chair.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="resource/js/intlTelInput.js"></script>
    <script src="/resource/js/star-rating.js" type="text/javascript"></script>
    <script type="text/javascript" src="resource/tooltipster/dist/js/tooltipster.bundle.min.js"></script>
    <script type="text/javascript" src="/resource/js/validator.js"></script>
    <script src="/resource/js/ajax.js"></script>
    <script type="text/javascript" src="/resource/js/jquery-ui.js"></script>
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
            <img src="resource/img/Banner_Trang_Chu_(PC)_-_With_Clock.png" class="img-reponsive">
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
                    <%--<div class="pull-left date-wapper">--%>
                    <%--<button id="btPrevDate" style="" type="button" class="btn btn-default"><i--%>
                    <%--class="fa fa-caret-left fa-lg"></i></button>--%>
                    <%--<!-- <input type="button" id="span-current-date" value="10-08-2016" tabindex="1" class="btn btn-vxr current-date hasDatepicker"> -->--%>
                    <%--<div class="input-group date" data-provide="datepicker">--%>
                    <%--<input type="text" class="form-control">--%>

                    <%--<div class="input-group-addon">--%>
                    <%--<span class="glyphicon glyphicon-th"></span>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--<button id="btNextDate" type="button" class="btn btn-default"><i--%>
                    <%--class="fa fa-caret-right fa-lg"></i></button>--%>
                    <%--</div>--%>
                    <div class="pull-left ml10 modify-container">
                        <a id="btModify" class="text-blue" href="#"><b>Sửa nơi đi, nơi đến, ngày đi</b></a>
                    </div>
                </div>
            </div>
            <div class="logo col-md-4 col-sm-4 hidden-xs mt10">
                <div class="pull-right col-md-12">
                    <div class="col-md-5 pr0 text-right">
                        <img height="42" src="resource/img/lock-sercurity.png" type="image/svg+xml">
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

<div class="barsearch bar1">
    <div class="container">
        <table class="table">
            <tbody>
            <tr>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-bus"></i><span>Hãng xe</span></i>
                        <ul class="dropdown-menu">
                            <c:forEach var="schedule" items="${scheduleListNormal}">
                                <li><a href="#">${schedule.busServicesEntity.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <i class="bar fa fa-sort-desc service"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i
                                class="fa fa-clock-o"></i><span>Giờ đi</span></i>
                        <ul class="dropdown-menu">
                            <c:forEach var="schedule" items="${scheduleList}">
                                <li><a href="#">${schedule.timeTableScheduleEntity.departureTime}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <i class="bar departure fa fa-sort-desc "></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-map-marker"></i><span>Nơi đi</span></i>
                        <ul class="dropdown-menu">
                            <c:forEach var="schedule" items="${scheduleListNormal}">
                                <li><a href="#">${schedule.departure.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <i class="bar from fa fa-sort-desc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-map-marker"></i><span>Nơi đến</span></i>
                        <ul class="dropdown-menu">
                            <c:forEach var="schedule" items="${scheduleListNormal}">
                                <li><a href="#">${schedule.arrival.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <i class="bar to fa fa-sort-desc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i
                                class="fa fa-puzzle-piece"></i><span>Sơ đồ ghế</span></i>
                        <ul class="dropdown-menu">
                            <c:forEach var="seat" items="${seatList}">
                                <li><a href="#">${seat}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <i class="bar chair fa fa-sort-desc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i class="fa fa-star"></i><span>Đánh giá</span></i>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>
                    </div>
                    <i class="bar sort6 fa fa-sort-desc"></i></td>
                <td>
                    <div class="dropdown pull-left">
                        <i class="dropdown-toggle" type="button" data-toggle="dropdown"><i
                                class="fa fa-ticket"></i><span>Vé xe</span></i>
                        <ul class="dropdown-menu">
                            <c:forEach var="schedule" items="${scheduleListNormal}">
                                <li><a href="#">${schedule.priceTicket}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <i class="bar money fa fa-sort-desc"></i>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- end search -->

<div class="barsearch bar2 barhidden">
    <div class="container">
        <div class="row">
            <form class="form-inline text-center" action="/findticket" method="get">
                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <div class="input-group form-group">
                        <div class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true"></i></div>
                        <input type="text" class="form-control" id="exampleInputName1" placeholder="Nơi đi"
                               name="departPlace">
                    </div>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <div class="input-group form-group">
                        <div class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true"></i></div>
                        <input type="text" class="form-control" id="exampleInputName2" placeholder="Nơi đến"
                               name="destination">
                    </div>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <div class="input-group date" data-provide="datepicker">
                        <div class='input-group'>
                            <div class="input-group-addon"><i class="fa fa-calendar fa-lg" aria-hidden="true"></i></div>
                            <input type="text" class="form-control ll-skin-nigran" id="exampleInputName3" placeholder=""
                                   name="departDate">
                        </div>
                    </div>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <button type="submit" class="container-ticket text-center buttonFind">
                        <i class="fa fa-bus"></i><span>TÌM VÉ</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- end search 2 -->


<div class="ticket">
    <div class="container">
        <div class="row">
            <table class="table table-borderless" id="mytable">
                <c:forEach var="schedule" items="${scheduleList}">
                    <tr id="getTrInfo">
                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2 fix-border">
                            <div class="container-bus">
                                <h4>${schedule.scheduleEntity.busServicesEntity.name}</h4>
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
                                    <%--time arrvial and departure`--%>
                                <h4 class="departureTime"><fmt:formatDate
                                        value="${schedule.timeTableScheduleEntity.departureTime}"
                                        type="time"
                                        pattern="HH:mm"/>→</h4>
                                <h4 class="arrvialTime"><fmt:formatDate
                                        value="${schedule.timeTableScheduleEntity.arriveTime}" type="time"
                                        pattern="HH:mm"/></h4>

                                <p>Thời
                                    gian: ${schedule.timeTableScheduleEntity.duration.hours}h${schedule.timeTableScheduleEntity.duration.minutes}'</p>
                            <span class="tooltiphover"
                                  data-tooltip-content="#tooltip_${schedule.scheduleEntity.departure.id}_from">
                            <p class="adress fromGo">${schedule.scheduleEntity.departure.name}</p><i
                                    class="fa fa-sort-desc"></i></span>
                            <span class="tooltiphover"
                                  data-tooltip-content="#tooltip_${schedule.scheduleEntity.arrival.id}_to">→
                                <p class="adress goTo">${schedule.scheduleEntity.arrival.name}</p><i
                                        class="fa fa-sort-desc"></i></span>
                            </div>
                        </td>
                        <!-- end time from to -->
                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                            <div class="container-chair text-center">
                                <p class="mapChair">Số ghế trên xe: ${schedule.numberSeat} chỗ</p>

                                <p class="space">Còn trống: ${schedule.numberSeat - schedule.sumNumberOfSeat}</p>
                            </div>
                        </td>
                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2 text-center">
                            <div class="container-start ">
                                    <%--<i class="fa fa-star"></i>--%>
                                    <%--<i class="fa fa-star"></i>--%>
                                    <%--<i class="fa fa-star"></i>--%>
                                    <%--<i class="fa fa-star"></i>--%>
                                    <%--<i class="fa fa-star"></i>--%>
                                <input id="input-1-xs" class="rating rating-loading rank-busService" value="3.5"
                                       data-min="0" data-max="5" data-show-clear="false" data-show-caption="false"
                                       data-step="0.5" data-size="xs" name="rankBus" data-readonly="true">
                            </div>
                            <a data-toggle="modal" href='#modal-id2'><p>15 rating <i class="fa fa-sort-desc"></i></p>
                            </a>
                            <a class="writereviews" data-toggle="modal"
                               href='#service'>Viết đánh giá <input type="hidden" value="${schedule.scheduleEntity.busServicesEntity.id}/%/${schedule.scheduleEntity.busServicesEntity.name}"></a>

                        </td>
                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                            <div class="">
                                <h4 class="moneyTicket">${schedule.scheduleEntity.priceTicket}<sup>đ</sup></h4>

                                <div class="container-ticket text-center" data-toggle="collapse"
                                     data-target="#${schedule.timeTableScheduleEntity.id}">
                                    <i class="fa fa-bus"></i><span>Đặt vé</span>
                                </div>
                            </div>
                        </td>
                        <!-- end time from to -->
                    </tr>
                    <tr id="getTrSubmit">
                        <td class="col-xs-12 col-sm-12 col-md-12 col-lg-12 info" colspan="5">
                            <div id="${schedule.timeTableScheduleEntity.id}" class="collapse info-wapper">
                                <div class="info-tilte">
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 text-center">
                                            <h4>Đặt vé</h4>
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
                                                <%--Form book a ticket--%>
                                            <form:form modelAttribute="ticket" action="/choosechair" method="post"
                                                       class="info-form">
                                                <div class="row">
                                                    <div class="form-group form-inline">
                                                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                                            <label class="info-label">Họ Tên:</label>
                                                        </div>
                                                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                                            <form:input type="text" required="true" class="form-control"
                                                                        placeholder="Tran Van A" path="fullName"/>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group form-inline">
                                                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                                            <label class="info-label">Phone:</label>
                                                        </div>
                                                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                                            <form:input type="tel" class="phone form-control"
                                                                        required="true"
                                                                        placeholder="VD: 0912345678"
                                                                        path="numberphone"/>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group form-inline">
                                                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                                            <label class="info-label">Email:</label>
                                                        </div>
                                                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                                            <form:input type="email" required="true"
                                                                        class="form-control"
                                                                        placeholder="vexe@gmail.com" path="gmail"/>
                                                        </div>

                                                    </div>
                                                </div>
                                                <input type="hidden" value="${schedule.busesId}" name="busesId"/>
                                                <input type="hidden" value="${schedule.timeTableScheduleEntity.id}"
                                                       name="timeTableId"/>
                                                <input type="hidden" value="${schedule.scheduleEntity.departure.id}"
                                                       name="busstationDeparture"/>
                                                <input type="hidden" value="${schedule.scheduleEntity.arrival.id}"
                                                       name="busstationArrival"/>
                                                <input type="hidden" value="${dayStartMove}" name="dayStartMove">
                                                <button type="submit"
                                                        class="btn btn-primary pull-right container-ticket text-center">
                                                    <i class="fa fa-bus"></i><span>Tiếp tục</span></button>
                                            </form:form>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                            <table class="table">
                                                <tr>
                                                    <td>Tuyến đường</td>
                                                    <td class="info-table-ticket">${schedule.scheduleEntity.departure.name}
                                                        - ${schedule.scheduleEntity.arrival.name}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Xuất phát</td>
                                                    <td class="info-table-ticket">${schedule.scheduleEntity.departure.name}</td>
                                                </tr>
                                                <tr>
                                                    <td>Đích đến</td>
                                                    <td class="info-table-ticket">${schedule.scheduleEntity.arrival.name}</td>
                                                </tr>
                                                <tr>
                                                    <td>Giờ xuất bến</td>
                                                    <td class="info-table-ticket">${schedule.timeTableScheduleEntity.departureTime} ${dayStartMove}</td>
                                                </tr>
                                                <tr>
                                                    <td>Giờ đến</td>
                                                    <jsp:useBean id="ourDate" class="java.util.Date"/>
                                                    <jsp:setProperty name="ourDate" property="time"
                                                                     value="${dayStartMove.time - schedule.timeTableScheduleEntity.duration.time}"/>
                                                    <td class="info-table-ticket">${schedule.timeTableScheduleEntity.arriveTime}
                                                        <fmt:formatDate value="${ourDate}" pattern="yyyy-MM-dd"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Giá vé</td>
                                                    <td class="info-table-ticket">${schedule.scheduleEntity.priceTicket}/người</td>
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
                                                    <h4 class="name-car">${schedule.scheduleEntity.busServicesEntity.name}</h4>
                                                    <h4 class="name-from">Telephone:</h4>

                                                    <h2 class="number-mobile"><i
                                                            class="glyphicon glyphicon-phone-alt"></i>${schedule.scheduleEntity.busServicesEntity.phone}
                                                    </h2>
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
                </c:forEach>
            </table>

        </div>
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
                <img src="resource/img/icon-vxr.png" class="pull-left" width="55px" height="55px">

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
                        <img src="resource/img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="resource/img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="resource/img/certificate1.png">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <img src="resource/img/certificate1.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- end footer -->
<c:forEach var="schedule" items="${scheduleList}">
    <div class="tooltip" style="display: none">
		<span id="tooltip_${schedule.scheduleEntity.departure.id}_from">
			<div class="title">Thông tin điểm xuất phát</div>
			<p class="localgo">${schedule.scheduleEntity.departure.name}</p>
			<span></span>
		</span>
    </div>
    <div class="tooltip" style="display: none">
		<span id="tooltip_${schedule.scheduleEntity.arrival.id}_to">
			<div class="title">Thông tin điểm đến</div>
			<p class="localgo">${schedule.scheduleEntity.arrival.name}</p>
			<span></span>
		</span>
    </div>
</c:forEach>

<div class="modal fade" id="modal-id2">
    <div class="modal-dialog comment">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Bình Luận</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 text-center">
                        <div class="point-avg">
                            <h4 class="namecomment">Đánh giá tổng thể nhà xe HV</h4>

                            <h3 class="pointSum">3.5</h3>
                            <input id="input-7-xs" class="rating rating-loading" value="3.5" data-min="0" data-max="5"
                                   data-show-clear="false" data-show-caption="false" data-step="0.5" data-size="xs"
                                   name="rankBus" data-readonly="true">
                        </div>
                    </div>
                    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 point-four">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 border-bottom">
                                        <div class="element-point">
                                            <p class="pull-left">Tổng quan:</p>

                                            <p class="pull-right">3.6</p>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 border-bottom">
                                        <div class="element-point">
                                            <p class="pull-left">Tổng quan:</p>

                                            <p class="pull-right">3.6</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 point-four">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 border-bottom">
                                        <div class="element-point">
                                            <p class="pull-left">Tổng quan:</p>

                                            <p class="pull-right">3.6</p>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 border-bottom">
                                        <div class="element-point">
                                            <p class="pull-left">Tổng quan:</p>

                                            <p class="pull-right">3.6</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <h5 class="coment-element">Đánh giá của từng khách hàng</h5>
                        <hr class="color-hr">
                        <div id="comment-customer">
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                    <table class="table table-hover">
                                        <tbody>
                                        <tr>
                                            <th scope="row">Tổng quan:</th>
                                            <td class="pull-right">3.5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Chắt lượng</th>
                                            <td class="pull-right">2.5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Đúng giờ:</th>
                                            <td class="pull-right">3.2</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Dịch vụ:</th>
                                            <td class="pull-right">3.5</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <h5 class="pull-left">Tran Van A</h5>
                                            <h5 class="pull-right">2015-25-16</h5>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <p class="content-comment"></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <hr>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                    <table class="table table-hover">
                                        <tbody>
                                        <tr>
                                            <th scope="row">Tổng quan:</th>
                                            <td class="pull-right">3.5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Chắt lượng</th>
                                            <td class="pull-right">2.5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Đúng giờ:</th>
                                            <td class="pull-right">3.2</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Dịch vụ:</th>
                                            <td class="pull-right">3.5</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <h5 class="pull-left">Tran Van A</h5>
                                            <h5 class="pull-right">2015-25-16</h5>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <p class="content-comment"></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                <a class="writereviews" data-toggle="modal" href='#modal-id'>
                    <button type="button" class="btn btn-primary wm-comment" data-dismiss="modal">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        Viết đánh giá
                    </button>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="service">
    <div class="modal-dialog">
        <form class="commentForm" data-toggle="validator" role="form">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><i class="fa fa-pencil fa-2x" aria-hidden="true"></i>Viết đánh giá</h4>
                </div>
                <div class="modal-body comment">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                            <legend class="nameService">Hãng xe: </legend>

                            <div class="form-group">
                                <input type="text" class="form-control fullNameModal" placeholder="Tran Van A"
                                       name="fullName" required="true">
                            </div>
                            <div class="form-group">
                                <input type="gmail" class="form-control gmailModal" placeholder="vexere@gmail.com"
                                       name="gmail">
                            </div>
                            <div class="form-group">
                                <label>Bình luận:</label>
                                    <textarea class="form-control commentModal" rows="5" id="commentInto" name="commnet"
                                            ></textarea>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="busService" value=""
                                       class="busServiceModal"/>
                            </div>
                        </div>
                        <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                            <legend>Đánh giá:</legend>
                            <div class="form-group form-inline">
                                <label for="input-7-xs" class="control-label">Tổng quan:</label>
                                <input id="input-7-xs" class="rating rating-loading rankOverall" value="" data-min="0"
                                       data-max="5" data-show-clear="false" data-show-caption="false" data-step="1"
                                       data-size="xs" name="rankOverall" required="true">
                            </div>
                            <div class="form-group form-inline">
                                <label for="input-7-xs" class="control-label">Chất lưọng xe buýt:</label>
                                <input id="input-7-xs" class="rating rating-loading rankBus" value="0" data-min="0"
                                       data-max="5" data-show-clear="false" data-show-caption="false" data-step="1"
                                       data-size="xs" name="rankBus">
                            </div>
                            <div class="form-group form-inline">
                                <label for="input-7-xs" class="control-label">Đúng giờ:</label>
                                <input id="input-7-xs" class="rating rating-loading rankPunctuality" value="0"
                                       data-min="0"
                                       data-max="5" data-show-clear="false" data-show-caption="false" data-step="1"
                                       data-size="xs" name="rankPunctuality">
                            </div>
                            <div class="form-group form-inline">
                                <label for="input-7-xs" class="control-label">Hành sử:</label>
                                <input id="input-7-xs" class="rating rating-loading rankBehavior" value="0" data-min="0"
                                       data-max="5" data-show-clear="false" data-show-caption="false" data-step="1"
                                       data-size="xs" name="rankBehavior">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary btncomment submitCommentForm" <%--data-dismiss="modal"--%>
                        value="Đăng bình luận">Đăng bình luận
                </button>
            </div>
        </form>
    </div>
</div>

</body>
</html>