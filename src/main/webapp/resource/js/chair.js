//case I: Show from starting
//init();

//Case II: If already booked
var bookedSeats = [];
var money;
$(window).ready(function () {
    $('input[name=seats]').each(function () {
        bookedSeats.push($(this).val());
        //alert($(this).val());
    });
    money = $('input[name=priceTicket]').val();
});


$(window).load(function () {
    var settings = {
        rows: 4,
        cols: 8,
        rowCssPrefix: 'row-',
        colCssPrefix: 'col-',
        seatWidth: 70,
        seatHeight: 50,
        seatCss: 'seat',
        selectedSeatCss: 'selectedSeat',
        selectingSeatCss: 'selectingSeat'
    };

    var init = function (reservedSeat) {
        var str = [], seatNo, className;
        for (i = 0; i < settings.rows; i++) {
            for (j = 0; j < settings.cols; j++) {
                seatNo = (i + j * settings.rows + 1);
                className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + ' ' + settings.colCssPrefix + j.toString();
                if ($.isArray(reservedSeat) && $.inArray(seatNo.toString(), reservedSeat) != -1) {
                    className += ' ' + settings.selectedSeatCss;
                }
                str.push('<li class="' + className + '"' +
                    'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
                    '<a title="' + seatNo + '">' + seatNo + '</a>' +
                    '</li>');
            }
        }
        $('#place').html(str.join(''));
    };


    init(bookedSeats);

    $('.' + settings.seatCss).click(function () {
        if ($(this).hasClass(settings.selectedSeatCss)) {
            alert('This seat is already reserved');
        }
        else {
            var total = $('#place li.' + settings.selectingSeatCss + ' a').length;
            if(total < 4 || $(this).hasClass(settings.selectingSeatCss))
                $(this).toggleClass(settings.selectingSeatCss);
            else
                alert("Bạn không thể chọn quá 4 ghế");
        }
    });

    $('.' + settings.seatCss).click(function () {
        var str = [];
        var total = $('#place li.' + settings.selectingSeatCss + ' a').length;
        $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
            if (index == total - 1) {
                str.push($(this).attr('title'));
            }
            else
                str.push($(this).attr('title') + ',');
        });
        /*set day money*/
        $('input#numberSeats').val(total);
        $('#totalPrice').val(total*money);
        $('#number-chair').html(str.join(''));
        $('#totalMoney').html(total*money+"<sup>đ<sup>");
        $('input#seat').val(str.join(''));
    });

    $('#btnNextTransfer').click(function () {
        var total = $('#place li.' + settings.selectingSeatCss + ' a').length;
        if (total == 0){
            alert("Bạn cần chọn ghế");
            event.preventDefault();
        }
    });

});