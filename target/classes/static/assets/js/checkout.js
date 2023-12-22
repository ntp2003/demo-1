$(document).ready(function() {
	// Validate phone number format
	$('#phonenumber').on('input', function() {
		var phoneNumber = $(this).val().replace(/\D/g, ''); // Lấy chỉ số điện thoại mà không bao gồm ký tự không phải số
		if (phoneNumber.length === 10 && !isNaN(phoneNumber)) {
			$(this).removeClass('is-invalid');
		} else {
			$(this).addClass('is-invalid');
		}
	});

	$('#firstName').on('input', function() {
		var firstName = $('#firstName').val();
		if (firstName.trim() !== '') {
			$(this).removeClass('is-invalid');
		} else {
			$(this).addClass('is-invalid');
		}
	});


	$('#lastName').on('input', function() {
		var lastName = $('#lastName').val();
		if (lastName.trim() === '') {
			$(this).addClass('is-invalid');
		} else {
			$(this).removeClass('is-invalid');
		}
	});

	$('#city').on('input', function() {
		var city = $('#city').val();
		if (city.trim() === 'Chọn tỉnh thành') {
			$(this).addClass('is-invalid');
		} else {
			$(this).removeClass('is-invalid');
		}
	});

	$('#district').on('input', function() {
		var city = $('#district').val();
		if (city.trim() === 'Chọn quận huyện') {
			$(this).addClass('is-invalid');
		} else {
			$(this).removeClass('is-invalid');
		}
	});

	$('#ward').on('input', function() {
		var city = $('#ward').val();
		if (city.trim() === 'Chọn phường xã') {
			$(this).addClass('is-invalid');
		} else {
			$(this).removeClass('is-invalid');
		}
	});


	$('#submit').on('click', function(event) {
		// Kiểm tra lỗi cho số điện thoại
		var phoneNumber = $('#phonenumber').val().replace(/\D/g, '');
		if (phoneNumber.length !== 10 || isNaN(phoneNumber)) {
			$('#phonenumber').addClass('is-invalid');
			event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		} else {
			$('#phonenumber').removeClass('is-invalid');
		}

		// Kiểm tra lỗi cho first name và last name
		var firstName = $('#firstName').val();
		var lastName = $('#lastName').val();
		if (firstName.trim() === '' || lastName.trim() === '') {
			$('#firstName, #lastName').addClass('is-invalid');
			event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		} else {
			$('#firstName, #lastName').removeClass('is-invalid');
		}
		var city = $('#city').val();
		if (city === '') {
			$('#city').addClass('is-invalid');
			event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		} else {
			$('#city').removeClass('is-invalid');
		}

		// Kiểm tra lỗi cho quận huyện
		var district = $('#district').val();
		if (district === '') {
			$('#district').addClass('is-invalid');
			event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		} else {
			$('#district').removeClass('is-invalid');
		}

		// Kiểm tra lỗi cho phường xã
		var ward = $('#ward').val();
		if (ward === '') {
			$('#ward').addClass('is-invalid');
			event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		} else {
			$('#ward').removeClass('is-invalid');
		}
	});
	
});