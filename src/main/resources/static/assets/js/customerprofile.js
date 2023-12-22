$(document).ready(function() {
	$("#account-info-form").submit(function(e) {
		e.preventDefault();
		let formData = {
			firstName: $('#firstName').val(),
			lastName: $('#lastName').val(),
			phoneNumber: $('#phoneNumber').val(),
			address: JSON.stringify(
				{
					city : $('#city').val(), 
					district : $('#district').val(), 
					ward : $('#ward').val(), 
					detail : $('#address-detail').val()
				}),
			birthDate: $('#dob').val()
		}

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "/customer/Profile/update-info",
			data: JSON.stringify(formData),
			cache: false,
			success: function() {
				$.notify("Cập nhật thông tin thành công", "success", 9999);
			},
			error: function() {
				$.notify("Cập nhật thông tin thất bại!", "danger", 9999);
			}
		});
	});
	function loadFile(event) {
		var reader = new FileReader();
		reader.onload = function() {
			$.ajax({
				type: "PUT",
				url: "/customer/Profile/update-avatar",
				data: { avatar: reader.result },
				cache: false,
				success: function() {
					$('#profilePic, header img').attr('src', reader.result);
				},
				error: function() {
					$.notify("Cập nhật Avatar thất bại!", "danger", 9999);
				}
			});
		};
		reader.readAsDataURL(event.target.files[0]);
	}
	$('#update-avatar').on('click', function() {
		$('#fileInput').click();
	});
	$('#fileInput').on('change', loadFile);

	$("#change-password-form").validate({
		rules: {
			"oldPassword": {
				required: true,
				remote: {
					url: "/customer/Profile/check-password",
					type: "get",
					data: {
						"oldPassword": function() {
							return $("#oldPassword").val();
						}
					}
				}
			},

			"newPassword": {
				required: true,
				rangelength: [8, 20]
			},

			"confirmPassword": {
				required: true,
				equalTo: "#newPassword",
			}
		},
		messages: {
			"oldPassword": {
				remote: "Input password is not correctly."
			},
			"newPassword": {
				rangelength: "Your password should be at 8-20 characters."
			}
		},
		errorClass: "text-danger",
		errorElement: "p",

		errorPlacement: function(error, element) {
			error.insertAfter(element);
		}
	});

	$("#change-password-form").submit(function(e) {
		if ($(this).valid()) {
			e.preventDefault();
			let formData = {
				newPassword: $("#newPassword").val()
			}
			$.ajax({
				type: "PUT",
				url: "/customer/Profile/update-password",
				data: formData,
				cache: false,
				success: function() {
					$("#changePasswordModal .btn-close").click();
					document.getElementById('change-password-form').reset();
					$.notify("Đổi mật khẩu thành công", "success", 9999);
				},
				error: function() {
					$.notify("Đổi mật khẩu thất bại!", "danger", 9999);
				}
			});
		}
	});
	$("#linkWalletForm").submit(function(e) {
		e.preventDefault();
		let formData = {
			walletId: $("#walletID").val(),
			verificationCodes: $("#verificationCodes").val()
		}
		$.ajax({
			type: "PUT",
			url: "/customer/Profile/link-wallet",
			data: formData,
			cache: false,
			success: function() {
				location.reload();
			},
			error: function() {
				$.notify("Mã ví hoặc mã xác thực không đúng !!!", "danger", 9999);
			}
		});
	});
	$("#unlink-btn").click(function() {
		$.ajax({
			type: "PUT",
			url: "/customer/Profile/unlink-wallet",
			success: function() {
				location.reload();
			},
			error: function() {
				$.notify("Hủy liên kết thất bại!!!", "danger", 9999);
			}
		});
	})
});