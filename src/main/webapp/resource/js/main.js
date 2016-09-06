$(document).ready(function(){
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
		$('#reader').html5_qrcode_stop();
	});

	$("#btn_start").click(function(){
		$('#reader').html5_qrcode(function(data){
				$('#read').html(data);
			},
			function(error){
				$('#read_error').html(error);
			}, function(videoError){
				$('#vid_error').html(videoError);
			}
		);
	});


});
