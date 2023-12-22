$(document).ready(function() {
	$("#register-admin").validate({
		rules: {
			"firstName": "required",
			"lastName": "required",
			"username": {
				required: true,
				remote: {
					url: "/admin/check-user-name-exists",
					type: "get",
					data: {
						"username": function() {
							return $("#username").val();
						}
					}
				}
			},
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
						"phoneNumber": function() {
							return $("#phoneNumber").val();
						}
					}
				}
			},
			"cccd": {
				required: true,
				rangelength: [12, 12],
				remote: {
					url: "/admin/check-cccd-exists",
					type: "get",
					data: {
						"cccd": function() {
							return $("#cccd").val();
						}
					}
				}
			},
			"password": {
				required:true,
				strong_password: true,
			},
			"repeat_password": {
				required: true,
				equalTo: "#password"
			}
		},
		messages: {
			"email": {
				remote: "Email already in use."
			},
			"phoneNumber": {
				phonenumber_valid: "Please specify a valid phone number",
				remote: "Phone number already in use."
			},
			"cccd": {
				rangelength: "CCCD must have 12 characters",
				remote: "CCCD already in use."
			},
			"username": {
				remote: "Username already in use."
			},
		},
		errorClass: "text-danger",
		errorElement: "p",

		errorPlacement: function(error, element) {
			error.insertAfter(element);
		}
	});

	$("#register-admin").submit(function(e) {
		if ($(this).valid()) {
			e.preventDefault();
			let formData = {
				username : $("#username").val(),
				password : $("#password").val(),
				firstName : $("#firstName").val(),
				lastName : $("#lastName").val(),
				phoneNumber: $("#phoneNumber").val(),
				email : $("#email").val(),
				cccd : $("#cccd").val()
			};
			
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "/admin/creator/Register",
				data: JSON.stringify(formData),
				cache: false,
				success: function() {
					$.notify("Thêm tài khoản Admin thành công!", "success", 9999);
					document.getElementById('register-admin').reset();
				},
				error: function() {
					$.notify("Thêm tài khoản Admin thất bại!", "danger", 9999);
				}
			});
		}
	});
});