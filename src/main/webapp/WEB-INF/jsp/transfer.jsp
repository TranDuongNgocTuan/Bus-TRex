<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> Example </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="resource/vendor/bootstrap.css">
    <link rel="stylesheet" href="resource/css/findticket.css">
    <link rel="stylesheet" href="resource/css/choosechair.css">
    <link rel="stylesheet" href="resource/css/transfer.css">
    <link rel="stylesheet" type="text/css" href="resource/css/chair.css">
    <script type="text/javascript" src="resource/vendor/bootstrap.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
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
            <a class="navbar-brand" href="#">DATVE</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/loginstaff"/> ">Nhân viên xe</a>
                </li>
                <li>
                    <a href="/scanticket">Kiểm tra vé</a>
                </li>
                <li>
                    <a href="/">Trang chủ</a>
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
            <img src="resource/img/Banner_Trang_Chu_(PC)_-_With_Clock.png" class="img-reponsive">
        </div>
    </div>
</div>
<!-- end poster -->

<div class="payment">
    <div class="container">
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 transfer">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"><i
                                        class="fa fa-credit-card" aria-hidden="true"></i>Thanh Toán PayPal</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p> Thanh toán bằng thẻ quốc tế Visa, Master, JCB <br>
                                    Trên thẻ của bạn phải có các ký hiệu Visa, Master hay JCB để thanh toán được bằng
                                    hình thức này

                                    1. Bạn sẽ được chuyển hướng về cổng thanh toán NganLuong để hoàn tất thanh toán.
                                    NganLuong hiện đã hỗ trợ thanh toán qua 25 ngân hàng tại Việt Nam.

                                    2. Nhập thông tin trên thẻ

                                    3. Sau khi thanh toán, bạn sẽ nhận được vé điện tử qua tin nhắn và Email thay cho vé
                                    giấy để lên xe</p>
                                <img src="resource/img/paypal.png" class="pull-left" width="100%">

                                <a href="/SetExpressCheckoutForParallelPayment"><button type="submit"
                                        class="btn btn-primary container-ticket text-center">
                                    <i class="fa fa-bus"></i><span>Thanh Toán</span></button></a>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse"><i
                                        class="fa fa-credit-card" aria-hidden="true"></i>Thanh Toán Hình Thức Trả
                                    Sau</a>
                            </h4>
                        </div>
                        <div id="collapse" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p>
                                    * Trong vòng 24h bạn phải thực hiện thanh toán online hoặc tới trạm thanh toán gần
                                    nhất để thực hiện giao dịch
                                </p>

                                <a href="/postpaid"><button type="submit"
                                                   class="btn btn-primary container-ticket text-center">
                                    <i class="fa fa-bus"></i><span>Trả Sau</span></button></a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 bill">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-borderless">
                            <tbody>
                            <tr>
                                <td colspan="4" class="text-bill"> HÓA ĐƠN</td>
                            </tr>
                            <tr>
                                <td class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Tuyến:</td>
                                <td class="col-xs-9 col-sm-9 col-md-9 col-lg-9"
                                    colspan="3">${ticket.busstationEntityDeparture.city}
                                    đến ${ticket.busstationEntityArrival.city}</td>
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
                                    <strong class="text-primary">${ticket.totalprice}<sup>đ</sup></strong>
                                </td>
                                <td>
                                    Ưu đải:
                                </td>
                                <td>
                                    ${promotion.promotionEntity.sale}%
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <%--<div class="container-ticket text-center">--%>
                    <%--<span>Quay Lai</span>--%>
                    <%--</div>--%>
                </div>
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
</body>
</html>