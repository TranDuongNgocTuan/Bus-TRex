$(function(){
	$(".barsearch i.bar").click(function(){
		$(this).toggleClass('fa-sort-desc');
		$(this).toggleClass('fa-sort-asc');
		return false;
	})

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
})  