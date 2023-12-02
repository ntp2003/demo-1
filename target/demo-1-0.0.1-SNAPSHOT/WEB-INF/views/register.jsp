<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<body style="background-color: rgb(231, 238, 243);">
	<div class="container" style="margin-top: 150px; margin-bottom: 100px;">
		<div
			class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
			<div
				class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg"
				style="border-radius: 5px;">
				<div class="p-5">
					<div class="text-center">
						<h4 class="text-dark mb-4">Create an Account!</h4>
					</div>
					<form:form id="register-form" class="user" action="Register"
						method="post" modelAttribute="newCustomer">
						<div class="mb-3"></div>
						<div class="row mb-3">
							<div class="col-sm-6 col-md-6 mb-3 mb-sm-0">
								<form:input class="form-control form-control form-control-user"
									type="text" name="firstName" path="firstName"
									placeholder="First Name" />
							</div>
							<div class="col-sm-6">
								<form:input class="form-control form-control form-control-user"
									type="text" name="lastName" path="lastName"
									placeholder="Last Name" />
							</div>
						</div>
						<div class="mb-3">
							<form:input class="form-control form-control form-control-user"
								type="email" name="email" id="email" path="email"
								placeholder="Email Address" />
						</div>
						<div class="row mb-3">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<form:input class="form-control form-control form-control-user"
									type="password" name="password" id="password" path="password"
									placeholder="Password" />
							</div>
							<div class="col-sm-6">
								<input class="form-control form-control form-control-user"
									type="password" id="verifyPassword" name="re-password"
									placeholder="Repeat Password">
							</div>
						</div>
						<div class="row mb-3">
							<p class="text-danger">
								<form:errors path="email" />
							</p>
						</div>
						<button class="btn btn-primary d-block btn-user w-100"
							id="submitBtn" type="submit">Register Account</button>
						<hr>
					</form:form>
					<div class="text-center"></div>
					<div class="text-center">
						Already have an account? <a href="Login">Login</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"
		integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $("#register-form").validate({
		    rules:{
			    "firstName" : "required",
			    "lastName" : "required",
			    "email" : {
				    required : true,
				    email : true,
				    remote: {
				        url: "/check-email-customer-exists",
				        type: "post",
				        data: {
				          "email": function() {
				            return $("#email").val();
				          }
				        }
				    }
	    		},
				"password" : {
					required : true,
					rangelength: [8, 20]
				},
				"re-password" : {
					equalTo: "#password"
				}
			    },
			    messages: {
			        "password": {
			        	rangelength: "Your password should be at 8-20 characters."
			        },
		        	"re-password" : {
			        	equalTo: "Password does not match."
			        },
			        "email": {
			            remote: "Email already in use."
			          }
			      },
			    errorClass : "text-danger",
			    errorElement : "p",
			    
			    errorPlacement: function(error, element) {
			          error.insertAfter(element);
			   }
		    });
	});
	</script>
</body>

</html>