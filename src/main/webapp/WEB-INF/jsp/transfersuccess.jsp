<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"><head>
<title> Example </title>
<meta charset="utf-8">
<meta http-equiv="refresh" content="60; URL='http://localhost:8080" />
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,700italic,900italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/resource/vendor/bootstrap.css">
<link href="/resource/css/transfersuccess.css" rel="stylesheet">
<link rel="stylesheet" href="/resource/css/findticket.css">
<script type="text/javascript" src="/resource/vendor/bootstrap.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
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

	<div class="finish">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
					<h3 class="titleFinish">Giao dịch thanh toán thành công</h3>
					<h5 class="contentFinish">Cảm ơn Quý Khách sử dụng dịch vụ mua vé xe trực tuyến. Quý khách hãy tải vé xe của mình. Hoặc kiểm tra trên gmail.</h5>
					<a href="/downloadPDFPay" target="blank_" class="btn btn-primary"><i class="fa fa-download icon-download" aria-hidden="true"></i>Tải vé xe</a>
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