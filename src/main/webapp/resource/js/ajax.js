//jQuery(document).ready(function ($) {
//    $(".submitCommentForm").submit(function (event) {
//        // Prevent the form from submitting via the browser.
//        event.preventDefault();
//        submitComment();
//    });
//});

$(function () {
    // Handler for .ready() called.
    //$(".submitCommentForm").click(function (event) {
    //    // Prevent the form from submitting via the browser.
    //    event.preventDefault();
    //    submitComment();
    //});
    $(".commentForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        submitComment();
    });
});

function submitComment() {
    var name = $(".fullNameModal").val();
    var gmail = $(".gmailModal").val();
    var comment = $(".commentModal").val();
    var busServiceId = $(".busServiceModal").val();
    var rankOverall = $(".rankOverall").val();
    var rankBus = $(".rankBus").val();
    var rankPunctuality = $('.rankPunctuality').val();
    var rankBehavior = $(".rankBehavior").val();

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/findticket/comment",
        data: {
            fullName: name, gmail: gmail,
            comment: comment, busServiceId: busServiceId,
            rankOverall: rankOverall, rankBus: rankBus,
            rankPunctuality: rankPunctuality, rankBehavior: rankBehavior
        },
        dataType : 'json',
        timeout: 100000,
        success: function (data) {
            console.log(data);
            display(data);
        }
    });

    $(".fullNameModal").val("");
    $(".gmailModal").val("");
    $(".commentModal").val("");
    $(".busServiceModal").val("");
    $(".rankOverall").val(0);
    $(".rankBus").val(0);
    $('.rankPunctuality').val(0);
    $(".rankBehavior").val(0);

}

function display(data) {
    //var comment = data.split('||');
    var newComment =
        "  <div class='row'> " +
        "     <div class= 'col-xs-3 col-sm-3 col-md-3 col-lg-3' >" +
        "       <table class='table table-hover'>" +
        "           <tbody>" +
        "            <tr>" +
        "                <th scope='row'>Tổng quan:</th>" +
        "                <td class='pull-right'>"+data.rankOverall+"</td>" +
        "            </tr>" +
        "            <tr>" +
        "                <th scope='row'>Chắt lượng</th>" +
        "                <td class='pull-right'>"+data.rankBus+"</td>" +
        "            </tr>" +
        "            <tr>" +
        "                <th scope='row'>Đúng giờ:</th>" +
        "                <td class='pull-right'>"+data.rankPunctuality+"</td>" +
        "            </tr>" +
        "            <tr>" +
        "                <th scope='row'>Hành sử</th>" +
        "                <td class='pull-right'>"+data.rankBehavior+"</td>" +
        "            </tr>" +
        "            </tbody>" +
        "        </table>" +
        "        </div>" +
        "        <div class='col-xs-9 col-sm-9 col-md-9 col-lg-9'>" +
        "            <div class='row'>" +
        "                <div class='col-xs-12 col-sm-12 col-md-12 col-lg-12'>" +
        "                    <h5 class='pull-left'>"+data.fullName+"</h5>" +
        "                    <h5 class='pull-right'>"+ data.dob+"</h5>" +
        "                </div>" +
        "            </div>" +
        "            <div class='row'>" +
        "        <div class='col-xs-12 col-sm-12 col-md-12 col-lg-12'>" +
        "            <p class='content-comment'>"+ data.content +"</p>" +
        "        </div>" +
        "    </div>" +
        "        </div>" +
        "        <div class= 'col-xs-12 col-sm-12 col-md-12 col-lg-12'>" +
        "            <hr>" +
        "        </div>" +
        "</div>";
    $('#comment-customer'+data.busServiceId).append(newComment);
}