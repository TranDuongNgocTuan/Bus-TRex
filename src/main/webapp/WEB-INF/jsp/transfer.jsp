<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title> Example </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,700italic,900italic' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="webjars/vendor/bootstrap.css">
  <link rel="stylesheet" href="webjars/css/findticket.css">
  <link rel="stylesheet" href="webjars/css/choosechair.css">
  <link rel="stylesheet" href="webjars/css/transfer.css">
  <link rel="stylesheet" type="text/css" href="webjars/css/chair.css">
  <script type="text/javascript" src="webjars/vendor/bootstrap.js"></script>
  <script type="text/javascript" src="webjars/js/findticket.js"></script>
  <script type="text/javascript" src="webjars/js/chair.js"></script>
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
          <li><a href="#">Trang chủ</a></li>
          <li><a href="#">Kiểm tra vé</a></li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div>
  </nav> <!-- end bar -->

  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <img src="webjars/img/Banner_Trang_Chu_(PC)_-_With_Clock.png" class="img-reponsive">
      </div>
    </div>
  </div> <!-- end poster -->
  
  <div class="payment">
    <div class="container">
      <div class="row">
        <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 transfer">
          <div class="panel-group" id="accordion">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"><i class="fa fa-credit-card" aria-hidden="true"></i>Thanh Toán Ngân Lưọng</a>
                </h4>
              </div>
              <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">
                  <p> Thanh toán bằng thẻ quốc tế Visa, Master, JCB <br>
                    Trên thẻ của bạn phải có các ký hiệu Visa, Master hay JCB để thanh toán được bằng hình thức này

                    1. Bạn sẽ được chuyển hướng về cổng thanh toán 123Pay để hoàn tất thanh toán. 123Pay hiện đã hỗ trợ thanh toán qua 25 ngân hàng tại Việt Nam.

                    2. Nhập thông tin trên thẻ

                    3. Sau khi thanh toán, bạn sẽ nhận được vé điện tử qua tin nhắn và Email thay cho vé giấy để lên xe</p>
                    <img src="webjars/img/nganluong-logo.jpg" class="pull-left" width="100%">
                    <div class="container-ticket text-center" >
                      <span>Trả Sau</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse"><i class="fa fa-credit-card" aria-hidden="true"></i>Thanh Toán Ngân Lưọng</a>
                </h4>
              </div>
              <div id="collapse" class="panel-collapse collapse">
                <div class="panel-body">
                  <p> Thanh toán bằng thẻ quốc tế Visa, Master, JCB <br>
                    Trên thẻ của bạn phải có các ký hiệu Visa, Master hay JCB để thanh toán được bằng hình thức này

                    1. Bạn sẽ được chuyển hướng về cổng thanh toán 123Pay để hoàn tất thanh toán. 123Pay hiện đã hỗ trợ thanh toán qua 25 ngân hàng tại Việt Nam.

                    2. Nhập thông tin trên thẻ

                    3. Sau khi thanh toán, bạn sẽ nhận được vé điện tử qua tin nhắn và Email thay cho vé giấy để lên xe</p>
                    <img src="webjars/img/nganluong-logo.jpg" class="img-reponsive" width="100%">
                    <div class="container-ticket text-center" >
                      <a target="_blank" href="https://www.nganluong.vn/button_payment.php?receiver=(Email chính tài khoản nhận tiền)"
                         &product_name=(Mã đơn đặt hàng)
                         &price=(Tổng giá trị)
                         &return_url=(URL thanh toán thành công)
                         &comments=(Ghi chú về đơn hàng)">
                        <img src="https://www.nganluong.vn//css/newhome/img/button/safe-buy-2.png"border="0" />
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>  
          </div>
          <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 bill">
            <div class="row">
              <div class="form-group">
              <div class="col-md-12">
                <table class="table table-borderless">
                  <tbody><tr>
                    <td class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Tuyến:</td>
                    <td class="col-xs-9 col-sm-9 col-md-9 col-lg-9" colspan="3">Chau Doc ⇒ Can Tho</td>
                  </tr>
                  <tr>
                    <td>Ngày đi:</td>
                    <td>
                      <span ng-bind-html="step3Info.departureTime.Time">05:00</span>
                      <span ng-bind-html="step1Info.departureDate|svcDate">14-08-2016</span>
                    </td>
                    <td>Ghế/giường:</td>
                    <td><span ng-repeat="s in step3Info.selectSeats">12</span></td>
                  </tr>
                  <tr></tr>
                  <tr>
                    <td>Điểm lên xe:</td>
                    <td colspan="3" ng-bind-html="step3Info.pickUpPoint.Address">VP Long Xuyên, 99 Hàm Nghi , P.Bình Khánh , TP.Long Xuyên - An Giang</td>
                  </tr>
                  <tr class="sperator">
                    <td>Họ tên:</td>
                    <td ng-bind-html="step2Info.CustName">Tran Van Leo</td>
                    <td>Ngày sinh:</td>
                    <td ng-bind-html="step2Info.CustBirthDay|svcDate">11-08-2016</td>
                  </tr>
                  <tr>
                    <td>Email:</td>
                    <td ng-bind-html="step2Info.CustEmail">tuanrint@yahoo.com</td>
                    <td>SĐT:</td>
                    <td>
                      <span ng-bind-html="step2Info.CustMobile">0123456789</span>
                      <span ng-bind-html="step2Info.CustMobile2">0123456789</span>
                    </td>
                  </tr>
                  <tr>
                    <td>Tổng tiền:</td>
                    <td colspan="3">
                      <strong class="text-primary" ng-bind-html="step3Info.total|svcMoney">100.000<sup>₫</sup></strong>
                    </td>
                  </tr>
                  <tr ng-if="!step3Info.goldHourSelected">
                    <td>Tổng cộng</td>
                    <td colspan="3"><strong class="text-primary" ng-bind-html="info.totalMoney|svcMoney">100.000<sup>₫</sup></strong></td>
                  </tr><!-- end ngIf: !step3Info.goldHourSelected -->
                </tbody></table>
              </div>
              <div class="container-ticket text-center" >
                <span>Quay Lai</span>
              </div>
            </div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </body>
  </html>