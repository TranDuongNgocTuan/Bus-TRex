//jQuery(document).ready(function ($) {
//    $(".submitCommentForm").submit(function (event) {
//        // Prevent the form from submitting via the browser.
//        event.preventDefault();
//        submitComment();
//    });
//});

$(function() {
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
    var comment = $(".fullNameModal").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/findticket/comment",
        data: comment,
        timeout: 100000,
        success: function (data) {
            console.log(data);
            display(data);
        }
    });
}

function display(data) {
    //var comment = data.split('||');
    //var newComment = "<div class='form-group'>"
    //    + "<label>" + comment[0] + "</label>"
    //    + "<input type='text' class='form-control' placeholder='" + comment[1] + "' readonly>"
    //    + "</div>";
    //$('#commentList').append(newComment);
    alert("Hello");
}