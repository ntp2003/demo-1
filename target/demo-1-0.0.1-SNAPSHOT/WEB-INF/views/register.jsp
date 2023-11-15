<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Untitled</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/Login-Form-Basic-icons.css">
<link rel="stylesheet"
	href="assets/css/Navbar-with-menu-and-login-km-Navbar.css">
	
	    <style>
	    .bg-opacity-10 {
	  --bs-bg-opacity: 0.75;
	}
    </style>
</head>

<body style="background-color:rgb(231, 238, 243);">
	<div class="container" style="margin-top: 150px;margin-bottom: 100px;">
		<div
			class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
			<div
				class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg"
				style="border-radius: 5px;">
				<div class="p-5">
					<div class="text-center">
						<h4 class="text-dark mb-4">Create an Account!</h4>
					</div>
					<form class="user" action="Register" method="post">
						<div class="mb-3"></div>
						<div class="row mb-3">
							<div class="col-sm-6 col-md-6 mb-3 mb-sm-0">
								<input class="form-control form-control form-control-user"
									type="text" placeholder="First Name" required="">
							</div>
							<div class="col-sm-6">
								<input class="form-control form-control form-control-user"
									type="text" placeholder="Last Name" required="">
							</div>
						</div>
						<div class="mb-3">
							<input class="form-control form-control form-control-user"
								type="email" id="email" placeholder="Email Address" required="">
						</div>
						<div class="row mb-3">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input class="form-control form-control form-control-user"
									type="password" id="password" placeholder="Password"
									required="">
							</div>
							<div class="col-sm-6">
								<input class="form-control form-control form-control-user"
									type="password" id="verifyPassword"
									placeholder="Repeat Password" required="">
							</div>
						</div>
						<div class="row mb-3">
							<p id="emailErrorMsg" class="text-danger" style="display: none;">Paragraph</p>
							<p id="passwordErrorMsg" class="text-danger"
								style="display: none;">Paragraph</p>
						</div>
						<button class="btn btn-primary d-block btn-user w-100"
							id="submitBtn" type="submit">Register Account</button>
						<hr>
					</form>
					<div class="text-center"></div>
					<div class="text-center">
						Already have an account? <a href="Login">Login</a>
					</div>
				</div>
			</div>
		</div>
		<script>
			let email = document.getElementById("email")
			let password = document.getElementById("password")
			let verifyPassword = document.getElementById("verifyPassword")
			let submitBtn = document.getElementById("submitBtn")
			let emailErrorMsg = document.getElementById('emailErrorMsg')
			let passwordErrorMsg = document.getElementById('passwordErrorMsg')

			function displayErrorMsg(type, msg) {
				if (type == "email") {
					emailErrorMsg.style.display = "block"
					emailErrorMsg.innerHTML = msg
					submitBtn.disabled = true
				} else {
					passwordErrorMsg.style.display = "block"
					passwordErrorMsg.innerHTML = msg
					submitBtn.disabled = true
				}
			}

			function hideErrorMsg(type) {
				if (type == "email") {
					emailErrorMsg.style.display = "none"
					emailErrorMsg.innerHTML = ""
					submitBtn.disabled = true
					if (passwordErrorMsg.innerHTML == "")
						submitBtn.disabled = false
				} else {
					passwordErrorMsg.style.display = "none"
					passwordErrorMsg.innerHTML = ""
					if (emailErrorMsg.innerHTML == "")
						submitBtn.disabled = false
				}
			}

			// Validate password upon change
			password.addEventListener("change", function() {

				// If password has no value, then it won't be changed and no error will be displayed
				if (password.value.length == 0
						&& verifyPassword.value.length == 0)
					hideErrorMsg("password")

					// If password has a value, then it will be checked. In this case the passwords don't match
				else if (password.value !== verifyPassword.value)
					displayErrorMsg("password", "Passwords do not match")

					// When the passwords match, we check the length
				else {
					// Check if the password has 8 characters or more
					if (password.value.length >= 8)
						hideErrorMsg("password")
					else
						displayErrorMsg("password",
								"Password must be at least 8 characters long")
				}
			})

			verifyPassword.addEventListener("change", function() {
				if (password.value !== verifyPassword.value)
					displayErrorMsg("password", "Passwords do not match")
				else {
					// Check if the password has 8 characters or more
					if (password.value.length >= 8)
						hideErrorMsg("password")
					else
						displayErrorMsg("password",
								"Password must be at least 8 characters long")
				}
			})

			// Validate email upon change
			email.addEventListener("change", function() {
				// Check if the email is valid using a regular expression (string@string.string)
				if (email.value.match(/^[^@]+@[^@]+\.[^@]+$/))
					hideErrorMsg("email")
				else
					displayErrorMsg("email", "Invalid email")
			});
		</script>
	</div>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>