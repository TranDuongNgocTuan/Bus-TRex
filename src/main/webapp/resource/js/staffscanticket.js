$(document).ready(function () {

    function requestCode(code, service) {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/scanticket/codetickettaixe",
            data: {
                code: code,
                service: service
            },
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log(data);
                display(data);
            }
        });
    }

    function show(data) {
        $(".codeticket").html(data.codeTicket);
        $(".fullname").html(data.fullName);
        $(".numberphone").html(data.numberphone);
        $(".gmail").html(data.gmail);
        $(".departure").html(data.from);
        $(".arrival").html(data.to);
        $(".departuretime").html(data.fromTime);
        $(".arrivaltime").html(data.toTime);
        $(".buservices").html(data.busService);
        $(".seat").html(data.seat);
        $(".totalprice").html(data.totalPrice);
        $(".plant").html(data.plan);
    }

    function display(data) {
        var waring = "  <div class='alert alert-danger'>" +
            "		<strong>Không tìm tháy vé xe</strong>" +
            "		</div>";
        var success = "<div class='alert alert-success'>" +
            "			<strong>Vé xe tồn tại</strong>" +
            "   </div>";
        if (data.exist == 1) {
            show(data);
            $(".codeticketform").val(data.codeTicket);
            $("#notify").show("slow").html(success);
        }
        else {
            $("#notify").html(waring);
        }

        if (data.status == "Chưa thanh toán") {
            $(".btnpayment").removeClass("disabled");
            $(".btndelete").addClass("disabled");
        }
        else {
            $(".btnpayment").addClass("disabled");
            $(".btndelete").removeClass("disabled");
        }

        setTimeout(function () {
            $(".alert").fadeTo(500, 0, function () {
                $(this).remove()
            })
        }, 5000);

    }

// scanAndStop = 1 clicked scan
// scanAndStop = 0 clicked stop

    $("#search").click(function () {
        var textcode = $(".textcode").val();
        var busService = $(".taiXeOfBuseService").val();
        requestCode(textcode, busService);
    });
})
;
