$(function(){
    $("#exampleInputName3").datepicker({
        startDate: "-"
    });

    $('#exampleInputName3').datepicker()
        .on('changeDate', function(ev){
            // $('#exampleInputName3').datepicker('hide');
            // alert(ev.date.valueOf());
            console.log($(this));
            var date = $('#exampleInputName3').datepicker("getDate");
            var month = date.getMonth()+1;
            var day = date.getDate();
            var output =
                (month<10 ? '0' : '') + month + '/' +
                (day<10 ? '0' : '') + day + '/' + date.getFullYear() ;

            $('input[name=departDate]').val(output);
            $(this).parent().parent('form').submit();
        });
});

$(document).ready(function() {
    $('#media').carousel({
        pause: true,
        interval: false,
    });
});