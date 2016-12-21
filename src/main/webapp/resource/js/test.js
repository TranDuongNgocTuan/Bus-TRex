$(document).ready(function(){
    $('#nhan').click(function(){
        $.ajax({
            url : 'test/?a=1',
            success : function() {
                alert("Hello");
            }
        });
    })
});