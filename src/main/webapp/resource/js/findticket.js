$(function(){

	$(document).ready(function () {
		$('.tooltiphover').tooltipster({
			theme: ['tooltipster-noir', 'tooltipster-noir-customized'],
			contentCloning: true,
		});
	});

	$(document).on('ready', function () {
		$('#input-7-xs').rating({});
	});

	$('.commentForm').validator();

	$(".writereviews").click(function(){
		var idName = $(this).find('input').val();
		var idAndName = idName.split("/%/");
		$('.nameService').html("Hãng xe:   " + idAndName[1]);
		$('.busServiceModal').val(idAndName[0]);
	});

	function sortTable(f,n){
		var rowInfo = $('tr#getTrInfo').get();
		var rowSubmit = $('tr#getTrSubmit').get();

		var rows = [];
		for (var row in rowInfo){
			rows.push({'info': rowInfo[row], 'submit': rowSubmit[row]});
		}

		rows.sort(function(a, b) {

			var A = getVal(a.info);
			var B = getVal(b.info);

			if(A < B) {
				return -1*f;
			}
			if(A > B) {
				return 1*f;
			}
			return 0;
		});

		function getVal(elm){
			var findClass = '.'+n;
			var v = $(elm).find(findClass).text().toUpperCase();
			if($.isNumeric(v)){
				v = parseInt(v,10);
			}
			return v;
		}

		$.each(rows, function(index, row) {
			$('#mytable').children('tbody').append(row.info);
			$('#mytable').children('tbody').append(row.submit);
		});
	}
	var f_sl = 1;

	$(".barsearch i.bar").click(function(){
		$(this).toggleClass('fa-sort-desc');
		$(this).toggleClass('fa-sort-asc');
		//var chao = '${to.Id}';
		//alert(chao);
		f_sl *= -1;
		if($(this).hasClass('service')){
			sortTable(f_sl,'nameService');
		}

		if($(this).hasClass('departure')){
			sortTable(f_sl,'departureTime');
		}

		if($(this).hasClass('from')){
			sortTable(f_sl,'formGo');
		}

		if($(this).hasClass('to')){
			sortTable(f_sl,'goTo');
		}

		if($(this).hasClass('chair')){
			sortTable(f_sl,'mapChair');
		}

		if($(this).hasClass('money')){
			sortTable(f_sl,'moneyTicket');
		}

		return false;
	});

	$('#btModify b').click(function(){
		$('.barsearch.bar1').toggleClass('barhidden');
		$('.barsearch.bar2').toggleClass('barhidden');
		return false;
	});

	$(".phone").intlTelInput({
		allowDropdown: false,
		autoHideDialCode: false,
		autoPlaceholder: false,
		dropdownContainer: "body",
		excludeCountries: ["us"],
		geoIpLookup: function(callback) {
			$.get("http://ipinfo.io", function() {}, "jsonp").always(function(resp) {
				var countryCode = (resp && resp.country) ? resp.country : "";
				callback(countryCode);
			});
		},
		initialCountry: "auto",
		nationalMode: false,
		numberType: "MOBILE",
		// onlyCountries: ['us', 'gb', 'ch', 'ca', 'do'],
		// preferredCountries: ['cn', 'jp'],
		separateDialCode: true,
		utilsScript: "/resource/js/utils.js"
	});

	var availableTags = [
		"An Giang",
		"Bà Rịa-Vũng Tàu",
		"Bắc Giang",
		"Bắc Cạn",
		"Bạc Liêu",
		"Bắc Ninh",
		"Bến Tre",
		"Bình Định",
		"Bình Dương",
		"Bình Phước",
		"Bình Thuận",
		"Cà Mau",
		"Cao Bằng",
		"Đắk Lắk",
		"Đắk Nông",
		"Điện Biên",
		"Đồng Nai",
		"Đồng Tháp",
		"Gia Lai",
		"Hà Giang",
		"Hà Nam",
		"Hà Tĩnh",
		"Hải Dương",
		"Hậu Giang",
		"Hòa Bình",
		"Hưng Yên",
		"Khánh Hòa",
		"Kiên Giang",
		"Kon Tum",
		"Lai Châu",
		"Lâm Đồng",
		"Lạng Sơn",
		"Lào Cai",
		"Long An",
		"Nam Định",
		"Nghệ An",
		"Ninh Bình",
		"Ninh Thuận",
		"Phú Thọ",
		"Quảng Bình",
		"Quảng Nam",
		"Quảng Ngãi",
		"Quảng Ninh",
		"Quảng Trị",
		"Sóc Trăng",
		"Sơn La",
		"Tây Ninh",
		"Thái Bình",
		"Thái Nguyên",
		"Thanh Hóa",
		"Thừa Thiên Huế",
		"Tiền Giang",
		"Trà Vinh",
		"Tuyên Quang",
		"Vĩnh Long",
		"Vĩnh Phúc",
		"Yên Bái",
		"Phú Yên",
		"Cần Thơ",
		"Đà Nẵng",
		"Hải Phòng",
		"Hà Nội",
		"TP HCM"
	];
	$( "#exampleInputName2" ).autocomplete({
		source: availableTags
	});

	var availableTags = [
		"An Giang",
		"Bà Rịa-Vũng Tàu",
		"Bắc Giang",
		"Bắc Cạn",
		"Bạc Liêu",
		"Bắc Ninh",
		"Bến Tre",
		"Bình Định",
		"Bình Dương",
		"Bình Phước",
		"Bình Thuận",
		"Cà Mau",
		"Cao Bằng",
		"Đắk Lắk",
		"Đắk Nông",
		"Điện Biên",
		"Đồng Nai",
		"Đồng Tháp",
		"Gia Lai",
		"Hà Giang",
		"Hà Nam",
		"Hà Tĩnh",
		"Hải Dương",
		"Hậu Giang",
		"Hòa Bình",
		"Hưng Yên",
		"Khánh Hòa",
		"Kiên Giang",
		"Kon Tum",
		"Lai Châu",
		"Lâm Đồng",
		"Lạng Sơn",
		"Lào Cai",
		"Long An",
		"Nam Định",
		"Nghệ An",
		"Ninh Bình",
		"Ninh Thuận",
		"Phú Thọ",
		"Quảng Bình",
		"Quảng Nam",
		"Quảng Ngãi",
		"Quảng Ninh",
		"Quảng Trị",
		"Sóc Trăng",
		"Sơn La",
		"Tây Ninh",
		"Thái Bình",
		"Thái Nguyên",
		"Thanh Hóa",
		"Thừa Thiên Huế",
		"Tiền Giang",
		"Trà Vinh",
		"Tuyên Quang",
		"Vĩnh Long",
		"Vĩnh Phúc",
		"Yên Bái",
		"Phú Yên",
		"Cần Thơ",
		"Đà Nẵng",
		"Hải Phòng",
		"Hà Nội",
		"TP HCM"
	];
	$( "#exampleInputName1" ).autocomplete({
		source: availableTags
	});

	var datepicker = $.fn.datepicker.noConflict();
	$.fn.bootstrapDP = datepicker;

	$("#exampleInputName3").bootstrapDP();
});
