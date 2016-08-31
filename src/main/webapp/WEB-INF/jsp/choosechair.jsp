<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"><head>
<title> Example </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,700italic,900italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resource/vendor/bootstrap.css">
<link rel="stylesheet" href="/resource/css/findticket.css">
<link rel="stylesheet" href="/resource/css/choosechair.css">
<link rel="stylesheet" type="text/css" href="/resource/css/chair.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="/resource/vendor/bootstrap.js"></script>
<script type="text/javascript" src="/resource/js/chair.js"></script>

<body >
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
			</div><!-- /.navbar-collapse -->
		</div>
	</nav> <!-- end bar -->

	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<img src="/resource/img/Banner_Trang_Chu_(PC)_-_With_Clock.png" class="img-reponsive">
			</div>
		</div>
	</div> <!-- end poster -->

	<%-- Seats choosed--%>
	<c:forEach var="seat" items="${seatChoosed}" >
		<input type="hidden" value="${seat}" name="seats"/>
	</c:forEach>
	<%-- Price Ticket --%>

	<div class="map-chair">
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<div class="choose-chair">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="categorize-chair">
									<ul id="seatDescription">
										<%--<li><div class="available-seat"></div><p>Có thể chọn</p></li>--%>
										<%--<li><div class="booked-seat"></div><p>Đã có người</p></li>--%>
										<%--<li><div class="selected-seat"></div><p>Đang chọn</p></li>--%>
                                            <li class="available-seat">Available Seat</li>
                                            <li class="booked-seat">Booked Seat</li>
                                            <li class="selected-seat">Selected Seat</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div id="holder">
									<ul id="place">
									</ul>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
								<h3>Sơ đồ ghế:</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<div class="info-buses">
						<h3 class="text-center">Thông tin chuyến</h3>
						<div class="row">
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="from">
										<p><i class="fa fa-bus"></i>Xuất phát</p>
										<p><fmt:formatDate value="${buses.date}" type="date"/> <br> <fmt:formatDate value="${buses.timeTableScheduleEntity.departureTime}" type="time"/> </p>
									</div>
									<div class="time"></div>
									<div class="to">
										<p><i class="fa fa-bus"></i>Đến lúc</p>
                                        <jsp:useBean id="ourDate" class="java.util.Date"/>
                                        <jsp:setProperty name="ourDate" property="time" value="${dayStartMove.time - schedule.timeTableScheduleEntity.duration.time}"/>
										<p><fmt:formatDate value="${ourDate}" pattern="yyyy-MM-dd"/><br><fmt:formatDate value="${buses.timeTableScheduleEntity.arriveTime}" type="time"/></p>
									</div>
								</div>


							</div>
							<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
								<div class="row">
									<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
										<div class="row">
											<div class="line"></div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
												<div class="point1"></div>
											</div>

											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<div class="point2"></div>
											</div>
										</div>
									</div>
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
										<div class="row">
											<div class="from">
												<p>${ticket.busesEntity.timeTableScheduleEntity.scheduleEntity.departure.city}</p>
											</div>
											<div class="time"></div>
											<div class="to">
												<p>${ticket.busesEntity.timeTableScheduleEntity.scheduleEntity.arrival.city}</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<%--<p class="text-chair">Số ghế:</p><p id="number-chair"></p>
								<p class="total-money">Tổng tiền:</p><p id="totalMoney"></p>--%>
								<table class="tableMoney">
									<tr>
										<td class="text-chair">Số ghế:</td>
										<td id="number-chair"></td>
									</tr>
									<tr>
										<td class="total-money">Tổng tiền:</td>
										<td id="totalMoney"></td>
									</tr>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
									<form:form modelAttribute="ticket" action="/transfer" method="POST">
										<input type="hidden" value="" path="seat" id="seat"/>
										<input type="hidden" value="" path="numberSeats" id="numberSeats"/>
										<input type="hidden" value="${ticket.busesEntity.timeTableScheduleEntity.scheduleEntity.priceTicket}" path="totalprice"  name="priceTicket"/>
										<button type="submit"
												class="btn btn-primary container-ticket text-center">
											<i
													class="fa fa-bus"></i><span>Tiếp tục</span></button>
									</form:form>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<img src="/resource/img/icon-vxr.svg" class="pull-left" width="55px" height="55px">
					<p>Bản quyền © 2016 thuộc về VeXeRe.Com <br>
						Tên công ty: CÔNG TY CỔ PHẦN VEXERE <br>
						Địa chỉ đăng ký kinh doanh: 8C Chữ Đồng Tử, Phường 7, Quận Tân Bình, Thành Phố Hồ Chí Minh, Việt Nam <br>
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
	</footer> <!-- end footer -->
</body>
</html>