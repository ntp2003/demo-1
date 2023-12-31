<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html data-bs-theme="light" lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
		<title>Register</title>
	</head>

	<body>
		<div class="container-fluid"
			style="margin: 0px; margin-right: 0px; margin-left: 0px; padding-right: 3vw; padding-left: 2vw;">
			<h3 class="text-dark mb-4">Register</h3>
			<div class="row mb-3">
				<div class="col-lg-12">
					<div class="row mb-3 d-none">
						<div class="col">
							<div class="card text-white bg-primary shadow">
								<div class="card-body">
									<div class="row mb-2">
										<div class="col">
											<p class="m-0">Peformance</p>
											<p class="m-0">
												<strong>65.2%</strong>
											</p>
										</div>
										<div class="col-auto">
											<i class="fas fa-rocket fa-2x"></i>
										</div>
									</div>
									<p class="text-white-50 small m-0">
										<i class="fas fa-arrow-up"></i>&nbsp;5% since last month
									</p>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="card text-white bg-success shadow">
								<div class="card-body">
									<div class="row mb-2">
										<div class="col">
											<p class="m-0">Peformance</p>
											<p class="m-0">
												<strong>65.2%</strong>
											</p>
										</div>
										<div class="col-auto">
											<i class="fas fa-rocket fa-2x"></i>
										</div>
									</div>
									<p class="text-white-50 small m-0">
										<i class="fas fa-arrow-up"></i>&nbsp;5% since last month
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="card shadow mb-3">
								<div class="card-header py-3">
									<p class="text-primary m-0 fw-bold">Registration Information</p>
								</div>
								<div class="card-body">
									<form id="register-admin">
										<div class="row">
											<div class="col">
												<div class="mb-3">
													<label class="form-label"
														for="username"><strong>Username</strong></label><input
														class="form-control" type="text" id="username" name="username"
														placeholder="username">
												</div>
											</div>
											<div class="col">
												<div class="mb-3">
													<label class="form-label" for="email"><strong>Email
															Address</strong></label><input class="form-control"
														type="email" id="email" name="email"
														placeholder="user@example.com">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col">
												<div class="mb-3">
													<label class="form-label" for="firstName"><strong>First
															Name</strong></label><input class="form-control" type="text"
														id="firstName" name="firstName" placeholder="First Name">
												</div>
											</div>
											<div class="col">
												<div class="mb-3">
													<label class="form-label" for="lastName"><strong>Last
															Name</strong></label><input class="form-control" type="text"
														id="lastName" name="lastName" placeholder="Last Name">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col">
												<div class="mb-3">
													<label class="form-label" for="phoneNumber"><strong>Phone
															Number</strong></label><input class="form-control"
														type="text" id="phoneNumber" name="phoneNumber"
														placeholder="Phone Number">
												</div>
											</div>
											<div class="col">
												<div class="mb-3">
													<label class="form-label"
														for="cccd"><strong>CCCD</strong></label><input
														class="form-control" type="text" id="cccd" name="cccd"
														placeholder="CCCD">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col">
												<div class="mb-3">
													<label class="form-label"
														for="password"><strong>Password</strong></label><input
														class="form-control" type="password" id="password"
														name="password" placeholder="Password">
												</div>
											</div>
											<div class="col">
												<div class="mb-3">
													<label class="form-label" for="repeat_password"><strong>Repeat
															Password</strong></label><input class="form-control"
														type="password" id="repeat_password" name="repeat_password"
														placeholder="Repeat Password">
												</div>
											</div>
										</div>
										<div class="d-flex justify-content-end mb-3" style="margin-top: 16px;">
											<button class="btn btn-primary text-center d-lg-flex justify-content-lg-end"
												type="submit">Register</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
		<script src="/assets/js/validatormethod.js"></script>
		<script src="/assets/js/adminregister.js"></script>
	</body>

	</html>