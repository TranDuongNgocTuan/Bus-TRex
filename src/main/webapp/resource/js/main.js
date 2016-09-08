$(document).ready(function(){

	function requestCode(code){
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "/scanticket/codeticket",
			data: {
				code: code
			},
			dataType : 'json',
			timeout: 100000,
			success: function (data) {
				console.log(data);
				display(data);
			}
		});
	}

	function display(data){
		var ticket = '  <table class="table table-borderless">' +
			'			<tbody>' +
			'			<tr>' +
			'				<td colspan="4" class="text-bill"> VÉ XE</td>' +
			'			</tr>' +
			'			<tr>' +
			'			<td class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Tuyến:</td>' +
			'			<td class="col-xs-9 col-sm-9 col-md-9 col-lg-9" colspan="3">' + data.from +' đến ' + data.to +'</td>' +
			'			</tr>' +
			'				<tr>' +
			'					<td>Ngày đi:</td>' +
			'					<td>' +
			'						<span>'+ data.fromTime +'</span>' +
			'						<span>'+ data.dayMove +'</span>' +
			'					</td>' +
			'					<td>Ghế/giường:</td>' +
			'					<td><span>'+data.seat+'</span></td>' +
			'				</tr>' +
			'				<tr>' +
			'					<td>Điểm lên xe:</td>' +
			'					<td colspan="3">'+ data.departure +
			'					</td>' +
			'				</tr>' +
			'				<tr>' +
			'					<td>Điểm lên kết thúc:</td>' +
			'					<td colspan="3">'+data.arrival +
			'					</td>' +
			'				</tr>' +
			'				<tr class="sperator">' +
			'					<td>Họ tên:</td>' +
			'					<td>'+ data.fullName +'</td>' +
			'					<td></td>' +
			'					<td></td>' +
			'				</tr>' +
			'				<tr>' +
			'					<td>Email:</td>' +
			'					<td>'+data.gmail+'</td>' +
			'					<td>SĐT:</td>' +
			'					<td><span>'+data.numberphone+'</span></td>' +
			'				</tr>' +
			'				<tr>' +
			'					<td>Tổng tiền:</td>' +
			'					<td>' +
			'						<strong class="text-primary">'+data.totalPrice+'<sup>₫</sup></strong>' +
			'					</td>' +
			'					<td>Thanh Toán:</td>' +
			'					<td>'+data.status+'</td>' +
			'				</tr>' +
			'			</tbody>' +
			'			</table>';
		$("#scanTicketInfo").html(ticket);
	}

	// scanAndStop = 1 clicked scan
	// scanAndStop = 0 clicked stop
	var scanAndStop = 1;
	$('#reader').html5_qrcode(function(data){
			requestCode(data);
		},
		function(error){
			$('#read_error').html(error);
		}, function(videoError){
			$('#vid_error').html(videoError);
		}
	);

	$('#btn_stop').click(function(){
		if (scanAndStop == 1){
			$('#reader').html5_qrcode_stop();
			$('#reader').empty();
			scanAndStop = 0;
		}
	});

	$("#btn_scan").click(function(){
		if (scanAndStop ==0){
			$('#reader').html5_qrcode(function(data){
					requestCode(data);
				},
				function(error){
					$('#read_error').html(error);
				}, function(videoError){
					$('#vid_error').html(videoError);
				}
			);
			scanAndStop = 1;
		}

	});


});
