$(document).ready(function(){

	// scanAndStop = 1 clicked scan
	// scanAndStop = 0 clicked stop
	var scanAndStop = 1;
	$('#reader').html5_qrcode(function(data){
			$('#read').html(data);
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
					$('#read').html(data);
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
