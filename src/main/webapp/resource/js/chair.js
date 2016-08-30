//case I: Show from starting
//init();

//Case II: If already booked
var bookedSeats = [];
$(window).ready(function () {
    $('input[name=seats]').each(function () {
        bookedSeats.push($(this).val());
        //alert($(this).val());
    });

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
        $('input[name=numberSeat]').val(total);
        $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
            if (index == total - 1) {
                str.push($(this).attr('title'));
            }
            else
                str.push($(this).attr('title') + ',');
        });
        $('#number-chair').html(str.join(''));
        $('input[name=selectSeat]').val(str.join(''));
    });

    $('#btnNext').click(function () {
        var str = [], item;
        $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
            item = $(this).attr('title');
            str.push(item);
        });
        alert(str.join(','));
    });

});