$(function(){

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

	$("#phone").intlTelInput({
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
		utilsScript: "build/js/utils.js"
	});
});