$(document).ready(function() {
	$("#update-info-form").validate({
		rules: {
			"firstName": "required",
			"lastName": "required",
			"email": {
				required: true,
				email: true,
				remote: {
					url: "/admin/check-email-exists",
					type: "get",
					data: {
						"email": function() {
							return $("#email").val();
						}
					}
				}
			},
			"phoneNumber": {
				required: true,
				phonenumber_valid: true,
				remote: {
					url: "/admin/check-phone-number-exists",
					type: "get",
					data: {
						"email": function() {
							return $("#phoneNumber").val();
						}
					}
				}
			}
		},
		messages: {
			"email": {
				remote: "Email already in use."
			},
			"phoneNumber": {
				phonenumber_valid: "Please specify a valid phone number",
				remote: "Phone number already in use."
			}
		},
		errorClass: "text-danger",
		errorElement: "p",

		errorPlacement: function(error, element) {
			error.insertAfter(element);
		}
	});

	$("#change-password-form").validate({
		rules: {
			"oldPassword": {
				required: true,
				remote: {
					url: "/admin/Profile/check-password",
					type: "get",
					data: {
						"oldPassword": function() {
							return $("#oldPassword").val();
						}
					}
				}
			},

			"newPassword": {
				strong_password: true,
			},

			"confirmPassword": {
				required: true,
				equalTo: "#newPassword",
			}
		},
		messages: {
			"oldPassword": {
				remote: "Input password is not correctly."
			}
		},
		errorClass: "text-danger",
		errorElement: "p",

		errorPlacement: function(error, element) {
			error.insertAfter(element);
		}
	});

	$("#update-info-form").submit(function(e) {
		if ($(this).valid()) {
			e.preventDefault();
			let formData = {
				firstName: $('#firstName').val(),
				lastName: $('#lastName').val(),
				phoneNumber: $('#phoneNumber').val(),
				email: $('#email').val()
			}

			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "/admin/Profile/update-info",
				data: JSON.stringify(formData),
				cache: false,
				success: function() {
					$.notify("Cập nhật thông tin thành công", "success", 9999);
				},
				error: function() {
					$.notify("Cập nhật thông tin thất bại!", "danger", 9999);
				}
			});
		}
	});

	$("#change-password-form").submit(function(e) {
		if ($(this).valid()) {
			e.preventDefault();
			let formData = {
				newPassword: $("#newPassword").val()
			}
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "/admin/Profile/update-pasword",
				data: JSON.stringify(formData),
				cache: false,
				success: function() {
					$("#changePasswordModal").modal("hide");
					document.getElementById('change-password-form').reset();
					$.notify("Đổi mật khẩu thành công", "success", 9999);
				},
				error: function() {
					$.notify("Đổi mật khẩu thất bại!", "danger", 9999);
				}
			});
		}
	});
});