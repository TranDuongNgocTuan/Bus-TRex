<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/21/2016
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head lang="vi" prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# product: http://ogp.me/ns/product#">
    <meta name="viewport" content="width=device-width"/>
    <title>Đặt vé xe online</title>

    <link rel="canonical" href="https://vexere.com">
    <meta name="robots" content="index, follow"/>
    <meta charset="utf-8">
    <link href="resource/Content/vxr/images/vexere-ico.ico?v=4484" rel="shortcut icon" type="image/x-icon"/>
    <meta property="og:site_name" content="VeXeRe"/>
    <meta property="og:type" content="product.group"/>
    <meta property="og:url" content="https://vexere.com"/>
    <meta property="og:image" content="/Content/vxr/images/fb-thumbnail.jpg"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="google-site-verification" content="niV9ShHdCWcZFAoPyWjqPL74Aldmk_jHfbvYkIt6uX0"/>
    <!-- Stylesheet -->
    <link href="resource/bundles/home-styles.css?v=4484" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="resource/font-awesome-4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resource/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="/resource/css/jquery-ui.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
    <script src="/resource/js/jquery-ui.min.js"></script>
    <script src="/resource/js/bootstrap-datepicker.min.js"/>
    <script type="text/javascript" src="resource/bundles/home-scripts.js"></script>


    <!-- END GA -->
</head>
<body>
<nav class="header-blue">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="/" class="logo-image"><img height="50" src="resource/Content/vxr/images/Home/bus-vxr.png"/></a>
                <ul class="header-action-bar visible-sm visible-xs">
                    <li>
                        <a class="header-blue-language en-change" href="javascript:"
                           data-href="/vi-VN/Language/ChangeLanguage?curlang=en&url=/"><img width="24"
                                                                                            src="resource/Content/vxr/images/english_icon.png"/></a>
                    </li>
                    <li>
                        <a class="header-blue-tel" href="tel: 19006484">
                            <i class="fa fa-phone"></i>
                        </a>
                    </li>
                    <li>
                        <a href="#" onclick="$('.header-blue-right-menu').toggle()">
                            <i class="fa fa-bars"></i>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="col-md-9 header-blue-right-menu">
                <ul class="header-blue-menu-list">
                    <li>
                        <a href="/WEB-INF/jsp/HTML5%20QR%20code%20Reader.jsp">Kiểm tra vé</a>
                    </li>
                    <li>
                        <a href="home.jsp">Trang chủ</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<div id="main" class="home-page">
    <div class="container home-search-ticket-panel">
        <div class="row">
            <div class="col-md-8">
                <div>
                    <h2>Đặt vé trực tuyến tiện lợi, không cần chờ đợi</h2>

                    <form id="searchForm" action="/findticket">
                        <fieldset class="row">
                            <div class="location-select-row form-inline col-xs-10 col-sm-11 col-md-12">
                                <div class="form-group searchLeft col-md-6">
                                    <span class="ui-helper-hidden-accessible" role="status" aria-live="polite">10 results are available, use up and down arrow keys to navigate.</span>
                                    <input id="tags" class="input-txt place ui-autocomplete-input" type="text"
                                           autocomplete="off" tabindex="1" accesskey="1" placeholder="Gõ vào tỉnh đi"
                                           onmouseup="return false;" name="departPlace" required>
                                </div>
                                <div class="form-group switchButton-container hidden-xs hidden-sm">
                                    <a class="switchButton bold" href="#">
                                        <i class="fa fa-exchange"></i>
                                    </a>
                                </div>
                                <div class="form-group searchRight col-md-6">
                                    <input id="tags1" class="input-txt place ui-autocomplete-input" type="text"
                                           autocomplete="off" tabindex="2" accesskey="2" placeholder="Gõ vào tỉnh đến"
                                           onmouseup="return false;" name="destination" required>
                                </div>
                            </div>
                            <div class="date-select-row col-md-12 col-xs-12 form-inline">
                                <div class="form-group col-md-6 pl0 select-date-container">
                                    <div class="panel-input-date">
                                        <input class="form-control" type="text" autocomplete="off" tabindex="3"
                                               accesskey="3" placeholder="Chọn ngày đi" class="input-txt date"
                                               name="departDate" id="datepicker" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-inline col-md-6 col-md-offset-6 col-xs-12 clearfix search-submit-container">
                                <button id="searchSubmit" class="submit-btn search-btn fr uppercase" tabindex="6"
                                        type="submit" name="searchSubmit">Tìm Vé
                                </button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
            <div class="col-md-4">
                <div class="flexslider slider-304-title">
                    <div class="flex-viewport" style="overflow: hidden; position: relative;">
                        <ul id="slider" class="slides"
                            style="width: 1000%; transition-duration: 0s; transform: translate3d(-352px, 0px, 0px);">
                            <li class="clone" aria-hidden="true"
                                style="width: 352px; margin-right: 0px; float: left; display: block;">
                                <a href="#" target="_blank">
                                    <img src="resource/Content/vxr/images/promotion/Silder_2-9_(_ty_le_360x214_).jpg"
                                         draggable="false">
                                </a>
                            </li>
                            <li class="flex-active-slide"
                                style="width: 352px; margin-right: 0px; float: left; display: block;" data-thumb-alt="">
                                <a href="#">
                                    <img src="resource/Content/vxr/images/promotion/cyberpay_slider.png"
                                         draggable="false">
                                </a>
                            </li>
                            <li class="" data-thumb-alt=""
                                style="width: 352px; margin-right: 0px; float: left; display: block;">
                                <a href="#" target="_blank">
                                    <img src="resource/Content/vxr/images/promotion/cyberpay_slider.png"
                                         draggable="false">
                                </a>
                            </li>
                            <li class="" data-thumb-alt=""
                                style="width: 352px; margin-right: 0px; float: left; display: block;">
                                <a href="#" target="_blank">
                                    <img src="resource/Content/vxr/images/promotion/cyberpay_slider.png"
                                         draggable="false">
                                </a>
                            </li>
                            <li class="clone" style="width: 352px; margin-right: 0px; float: left; display: block;"
                                aria-hidden="true">
                                <a href="#">
                                    <img src="resource/Content/vxr/images/promotion/cyberpay_slider.jpg"
                                         draggable="false">
                                </a>
                            </li>
                        </ul>
                    </div>
                    <ul class="flex-direction-nav">
                        <li class="flex-nav-prev">
                            <a class="flex-prev" href="#">Previous</a>
                        </li>
                        <li class="flex-nav-next">
                            <a class="flex-next" href="#">Next</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row home-promotion">
            <div class="col-sm-12" style="margin-bottom: 40px;">
                <div class="col-sm-12 pr0 pl0">
                    <div class="banner-29">
                        <img class="visible-xs visible-sm img-responsive"
                             src="resource/Content/vxr/images/General/Banner_Trang_Chu_(Mobile)_-_With_Clock.png"/>

                        <div class="ticket-amount"><label></label></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="number-panel">
    <div class="container">
        <div class="row">
            <div class="col col-md-3 col-sm-3 col-xs-6">
                <p class="num">5.000+</p>

                <p>Tuyến đường</p>
            </div>
            <div class="col col-md-3 col-sm-3 col-xs-6">
                <p class="num">2.000+</p>

                <p>Nhà xe</p>
            </div>
            <div class="col col-md-3 col-sm-3 col-xs-6">
                <p class="num">100.000+</p>

                <p>Vé đã bán</p>
            </div>
            <div class="col col-md-3 col-sm-3 col-xs-6">
                <p class="num">1.000+</p>

                <p>Đại lý bán vé</p>
            </div>
        </div>
    </div>
</div>

<div class="skyline hidden-xs hidden-sm">

    <div class="skyline-city"></div>
    <div class="bus-img">
        <img style="opacity: 0.3;filter: alpha(opacity=30);" src="resource/Content/vxr/images/newlayout/banh-xe.gif">
    </div>
</div>
<div class="hidden-sm hidden-xs">
    <div class="route-search-panel">
        <div id="routeSearch"></div>
    </div>
    <div id="busNetwork"></div>
    <div id="stations"></div>
</div>
<div id="news-panel" class="hidden-sm hidden-xs">
    <div class="container">
        <div class="row">

            <div class="col-md-12">
                <h3 class="h3-tt">Khách hàng nói về chúng tôi</h3>
                <hr style="margin-top: 15px; margin-bottom: 10px;"/>
                <div class="row">
                    <div class="col-md-12">
                        <p>Dịch vụ đặt mua vé xe trực tuyến thật tuyệt vời, tôi thấy thậm chí đặt chỗ mua vé máy bay còn
                            không được chọn chỗ ngồi như vậy. Bây giờ tôi không còn phải đi lại xếp hàng mua vé tại bến
                            xe nữa, chỉ cần cầm mã vé qua SMS và email là đã có thể lên xe rồi. Cảm ơn CTy T-Rex.</p>

                        <div class="text-center" style="position: relative">
                            <hr class="customer-divider"/>
                            <img class="img-circle customer-avatar" width="50"
                                 src="resource/Content/vxr/images/Vancakova.jpg"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ News/Social/Apps-->
</div>


<div id="footer">
    <div class="container">
        <div class="row hidden-sm hidden-xs">
            <div class="col-md-4 col-sm-3 col-xs-12">
                <h2>Về chúng tôi</h2>
                <ul class="footer-links">

                    <li><a rel="nofollow" href="#">Giới Thiệu</a></li>
                    <li><a rel="nofollow" href="#">Liên hệ</a></li>
                    <li><a class="footer-hotline" href="tel: 19006484">Hotline: 0906446275</a></li>
                </ul>
            </div>
            <div class="col-md-5 col-sm-5 col-xs-12">
                <h2>Hỗ trợ</h2>
                <ul class="footer-links">
                    <li><a rel="nofollow" href="#">Hướng dẫn thanh to&aacute;n</a></li>
                    <li><a rel="nofollow" href="#">Quy chế v&eacute; xe rẻ</a></li>
                    <li><a rel="nofollow" href="#">Những câu hỏi thường gặp</a></li>


                </ul>
            </div>
            <div class="col-md-3 hidden-xs">
                <h2>Kết nối</h2>

                <div class="social col-08 clearfix">
                    <a class="social-icon fb" rel="nofollow" title="Facebook" href="#" target="_blank">Facebook</a>
                    <a class="social-icon google-plus" rel="nofollow" title="Google+" href="#"
                       target="_blank">Google+</a>
                    <a class="social-icon tw" rel="nofollow" title="Twitter" href="#" target="_blank">Twitter</a>
                    <a class="social-icon yt" rel="nofollow" title="Youtube" href="#" target="_blank">Youtube</a>
                </div>

                <h2>Đối t&aacute;c</h2>

                <div class="col-08 clearfix">
                    <a target="_blank" href="http://csip.vn/" rel="nofollow"><img
                            src="resource/Content/tp/images/logo_csip_final.png" style="width: 45px;"></a>
                </div>
            </div>
        </div>

        <!-- Copyright -->
        <div class="copyright-panel" itemscope itemtype="http://schema.org/Organization">
            <div class="col col-md-8 footer-info-panel hidden-sm hidden-xs">
                <a itemprop="url" class="footer-logo" href="/" title="Cổng thông tin vé xe khách lớn nhất Việt Nam">
                    <img itemprop="logo" src="resource/Content/vxr/images/Home/icon-vxr.jpg" alt=""
                         style="width: 55px; height: 55px;"/>
                </a>

                <p>Bản quyền &copy; 2016 thuộc về <span itemprop="name">Cty T&T</span></p>

                <p>
                    T&ecirc;n c&ocirc;ng ty: C&Ocirc;NG TY CỔ PHẦN T&T<br/>
                    Địa chỉ đăng k&yacute; kinh doanh: 92 Quang Trung, Đà Nẵng, Việt Nam
                </p>

                <p>
                    Địa chỉ: <a href="https://goo.gl/maps/SzfDTaj3wLP2" title="Xem bản đồ" target="_blank"><span
                        itemprop="address" itemscope="" itemtype="http://schema.org/PostalAddress"><span
                        itemprop="streetAddress">92 Quang Trung</span>, <span
                        itemprop="addressLocality">Q.Hải Châu</span>, <span itemprop="addressRegion">TP. Đà Nẵng</span>, <span
                        itemprop="addressCountry">Việt Nam</span></span></a>
                    <br>
                    Giấy chứng nhận ĐKKD số 0312387105 do Sở KH& ĐT TP. Đà Nẵng cấp lần đầu ngày 25/7/2016
                </p>

                <!-- Start Mixpanel Partner -->

                <!-- End Mixpanel Partner -->
            </div>

            <div class="col-md-4 certificate-panel">

                <div class="col col-md-6 col-sm-3 col-xs-4">
                    <img src="resource/Content/vxr/images/Home/certificate0.png"/>
                </div>
                <div class="col col-md-6  col-sm-3 col-xs-4">
                    <img src="resource/Content/vxr/images/Home/certificate1.png"/>
                </div>
                <div class="col col-md-6 col-sm-3 hidden-xs">
                    <a href="http://online.gov.vn/HomePage/WebsiteDisplay.aspx?DocId=773">
                        <img src="resource/Content/vxr/images/Home/certificate2.png"/>
                    </a>
                </div>
                <div class="col col-md-6 col-sm-3 col-xs-4">
                    <a href="http://online.gov.vn/HomePage/WebsiteDisplay.aspx?DocId=773">
                        <img src="resource/Content/vxr/images/Home/certificate3.png"/>
                    </a>
                </div>
            </div>
            <!-- End Copyright -->
        </div>
    </div>
</div>

<script>

    function zeroPad(num, places) {
        var zero = places - num.toString().length + 1;
        return Array(+(zero > 0 && zero)).join("0") + num;
    }

    randomIntervalNumber = Math.floor(Math.random() * 60) + 45;

    $.ajax({
        cache: false,
        type: "GET",
        url: "/vi-vn/Support/GetCountDownTicket",
        contentType: 'application/json',
        dataType: "json",
        success: function (totalTickets) {
            totalTicketText = zeroPad(totalTickets, 5)
            $(".ticket-amount").text(totalTicketText);
        }
    });

    setInterval(function () {
        $.ajax({
            cache: false,
            type: "GET",
            url: "/vi-vn/Support/GetCountDownTicket",
            contentType: 'application/json',
            dataType: "json",
            success: function (totalTickets) {
                totalTicketText = zeroPad(totalTickets, 5)
                $(".ticket-amount").text(totalTicketText);
            }
        });
    }, randomIntervalNumber * 1000);
</script>


<style>
    .bus-kh-km {
        position: fixed;
        z-index: 999;
        left: 50px;
        bottom: 0;
        width: 390px;
        height: 260px;
    }

    .bus-km {
        background: url(/resource/Content/vxr/images/pop-up/xe-lien-hung.png) no-repeat;
        position: absolute;
        bottom: 0;
        left: 0;
        width: 275px;
        height: 86px;
        z-index: 999;
    }

    .bus-km img {
        width: 274px;
        opacity: 0.2;
    }

    .banner-km {
        width: 274px;
        opacity: 0.2;
    }

    .bus-caolam {
        background: url(/resource/Content/vxr/images/pop-up/sliderOperator/xe-cao-lam/khuyenmai.png) no-repeat;
        position: absolute;
        bottom: 0;
        left: 0;
        width: 275px;
        height: 86px;
        z-index: 999;
    }

    .bus-halinh {
        background: url(/resource/Content/vxr/images/pop-up/sliderOperator/xe-ha-linh/khuyenmai.png) no-repeat;
        position: absolute;
        bottom: 0;
        left: 0;
        width: 275px;
        height: 86px;
        z-index: 999;
    }

    .bus-hoangkhai {
        background: url(/resource/Content/vxr/images/pop-up/sliderOperator/xe-hoang-khai/khuyenmai.png) no-repeat;
        position: absolute;
        bottom: 0;
        left: 0;
        width: 275px;
        height: 86px;
        z-index: 999;
    }

    .bus-thesinh {
        background: url(/resource/Content/vxr/images/pop-up/sliderOperator/xe-the-sinh/khuyenmai.png) no-repeat;
        position: absolute;
        bottom: 0;
        left: 0;
        width: 275px;
        height: 86px;
        z-index: 999;
    }

    .banner-kh-km {
        position: absolute;
        z-index: 99;
        top: 0;
    }

    .banner-vbms {
        position: fixed;
        z-index: 99;
        bottom: 0;
    }

    .close-banner-vbms {
        position: absolute;
        top: -13px;
        right: 0;
        cursor: pointer;
    }

    .popup-29 {
        position: fixed;
        z-index: 999;
        left: 500px;
        bottom: 0;
        width: 390px;
        height: 260px;
    }

    .close-button {
        position: absolute;
        right: 168px;
        top: 9px;
        cursor: pointer;
        z-index: 3;
        opacity: 0;
    }

    .pd-0 {
        padding: 0 !important;
        border-radius: 0;
    }

    .custom-model-content {
        background-color: transparent;
        box-shadow: none;
        border: none;
        top: 50px;
    }

    @media (max-width: 768px) {
        .custom-model-content {
            top: 130px;
        }

        #muine {
            top: 124px !important;
        }

        .img-popup-tet {
            width: 100%;
            margin: auto;
        }

        .close-button {
            right: -1px !important;
            top: 0 !important;
        }

        .popup-container {
            position: relative;
            margin-top: 15%;
        }
    }

    @media (min-width: 992px) {
        .modal-lg {
            width: 1024px !important;
        }

        .img-popup-tet {
            margin: auto;
        }
    }
</style>

<div id="vexetet-modal" class="modal modal-vexetet" data-backdrop="static" data-keyboard="false" tabindex="-1"
     role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg" style="text-align: center;">
        <div class="modal-content custom-model-content">

            <div class="modal-body pd-0">
                <div class="popup-container">
                    <a class="dalat-link" href="#">
                        <img class="img-responsive img-popup-tet"
                             src="resource/Content/vxr/images/pop-up/Popup_New_PC_and_Mobile.png"/>

                    </a>
                    <img class="close-button" src="resource/Content/vxr/images/newlayout/close_red.png" width="32"/>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
//    setTimeout(function () {
//      var isValidRoute = false;
//      if (sessionStorage["PopupShown"] != 'yes') {
//        $("#vexetet-modal").modal("show");
//        sessionStorage["PopupShown"] = 'yes';
//      }
//
//    }, 1000);

        $(".close-button").click(function () {
            $("#vexetet-modal").modal("hide");
        });

        //if ($(window).width() < 768) {
        //    $(".dalat-link").attr("href", "tel:1900545541");
        //}
    });

    $(document).on('keydown', function (e) {
        if (e.keyCode == 27) { //esc key code
            $("#vexetet-modal").modal("hide");
        }
    })
</script>

<script type="text/javascript">
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
        a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
    ga('create', 'UA-42076441-1', 'auto');  // Replace with your property ID.
    ga('require', 'displayfeatures');
    ga('require', 'ecommerce');
    ga('send', 'pageview');
</script>

<script>
    $(function () {
        var availableTags = [
            "An Giang",
            "Bà Rịa-Vũng Tàu",
            "Bắc Giang",
            "Bắc Cạn",
            "Bạc Liêu",
            "Bắc Ninh",
            "Bến Tre",
            "Bình Định",
            "Bình Dương",
            "Bình Phước",
            "Bình Thuận",
            "Cà Mau",
            "Cao Bằng",
            "Đắk Lắk",
            "Đắk Nông",
            "Điện Biên",
            "Đồng Nai",
            "Đồng Tháp",
            "Gia Lai",
            "Hà Giang",
            "Hà Nam",
            "Hà Tĩnh",
            "Hải Dương",
            "Hậu Giang",
            "Hòa Bình",
            "Hưng Yên",
            "Khánh Hòa",
            "Kiên Giang",
            "Kon Tum",
            "Lai Châu",
            "Lâm Đồng",
            "Lạng Sơn",
            "Lào Cai",
            "Long An",
            "Nam Định",
            "Nghệ An",
            "Ninh Bình",
            "Ninh Thuận",
            "Phú Thọ",
            "Quảng Bình",
            "Quảng Nam",
            "Quảng Ngãi",
            "Quảng Ninh",
            "Quảng Trị",
            "Sóc Trăng",
            "Sơn La",
            "Tây Ninh",
            "Thái Bình",
            "Thái Nguyên",
            "Thanh Hóa",
            "Thừa Thiên Huế",
            "Tiền Giang",
            "Trà Vinh",
            "Tuyên Quang",
            "Vĩnh Long",
            "Vĩnh Phúc",
            "Yên Bái",
            "Phú Yên",
            "Cần Thơ",
            "Đà Nẵng",
            "Hải Phòng",
            "Hà Nội",
            "TP HCM"
        ];
        $("#tags").autocomplete({
            source: availableTags
        });
    });
</script>

<script>
    $(function () {
        var availableTags = [
            "An Giang",
            "Bà Rịa-Vũng Tàu",
            "Bắc Giang",
            "Bắc Cạn",
            "Bạc Liêu",
            "Bắc Ninh",
            "Bến Tre",
            "Bình Định",
            "Bình Dương",
            "Bình Phước",
            "Bình Thuận",
            "Cà Mau",
            "Cao Bằng",
            "Đắk Lắk",
            "Đắk Nông",
            "Điện Biên",
            "Đồng Nai",
            "Đồng Tháp",
            "Gia Lai",
            "Hà Giang",
            "Hà Nam",
            "Hà Tĩnh",
            "Hải Dương",
            "Hậu Giang",
            "Hòa Bình",
            "Hưng Yên",
            "Khánh Hòa",
            "Kiên Giang",
            "Kon Tum",
            "Lai Châu",
            "Lâm Đồng",
            "Lạng Sơn",
            "Lào Cai",
            "Long An",
            "Nam Định",
            "Nghệ An",
            "Ninh Bình",
            "Ninh Thuận",
            "Phú Thọ",
            "Quảng Bình",
            "Quảng Nam",
            "Quảng Ngãi",
            "Quảng Ninh",
            "Quảng Trị",
            "Sóc Trăng",
            "Sơn La",
            "Tây Ninh",
            "Thái Bình",
            "Thái Nguyên",
            "Thanh Hóa",
            "Thừa Thiên Huế",
            "Tiền Giang",
            "Trà Vinh",
            "Tuyên Quang",
            "Vĩnh Long",
            "Vĩnh Phúc",
            "Yên Bái",
            "Phú Yên",
            "Cần Thơ",
            "Đà Nẵng",
            "Hải Phòng",
            "Hà Nội",
            "TP HCM"
        ];
        $("#tags1").autocomplete({
            source: availableTags
        });
    });
</script>

<script>
    $("#slider").slider();
</script>

<script>
    $(function () {
        $("#datepicker").datepicker(
        {
            startDate: "-"
        });

    });
</script>

</body>

</html>


