<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
<title>Profile</title>
</head>

<body>
	<sec:authentication var="principal" property="principal" />
	<div class="container-fluid">
		<h3 class="text-dark mb-4">Admin</h3>
		<div class="row mb-3">
			<div class="col-lg-4">
				<div class="card mb-3">
					<div class="card-header py-3"
						style="background: var(--bs-card-cap-bg)">
						<h2 class="fw-bold text-primary m-0" style="font-size: 24px">
							Login Information</h2>
					</div>
					<div class="card-body">
						<div class="mb-3">
							<label class="form-label">Username : 
							<span>
								${principal.admin.username}
							</span>
							</label>
						</div>
						<div class="mb-3">
							<label class="form-label">Password : <span>***************
							</span>
							</label>
						</div>
						<div class="d-flex justify-content-xl-end mb-3">
							<button class="btn btn-primary" type="button"
								data-bs-toggle="modal" data-bs-target="#passwordModal">
								Change Password</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="row">
					<div class="col">
						<div class="card shadow mb-3">
							<div class="card-header py-3"
								style="background: var(--bs-card-cap-bg)">
								<h2 class="fw-bold text-primary m-0" style="font-size: 24px">
									Admin Information</h2>
							</div>
							<div class="card-body">
								<form id="update-info-form">
								<div class="row">
									<div class="col">
										<div class="mb-3">
											<label class="form-label" for="email"><strong>Email</strong></label><input
												type="email" id="email" class="form-control" name="email"
												value="${principal.admin.email}"
												placeholder="Enter your email" />
										</div>
									</div>
								</div>
									<div class="row">
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="firstName"><strong>First
														name</strong></label><input class="form-control" type="text" id="firstName"
													name="firstName" placeholder="Enter your first name" value="${principal.admin.firstName}"/>
											</div>
										</div>
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="lastName"><strong>Last
														name</strong></label><input class="form-control" type="text" id="lastName"
													name="lastName" placeholder="Enter your last name" value="${principal.admin.lastName}"/>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="cccd"><strong>CCCD</strong></label><input
													class="form-control" type="text" id="cccd" name="cccd"
													value="${principal.admin.cccd}"
													placeholder="Enter your cccd" disabled/>
											</div>
										</div>
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="phoneNumber"><strong>Phone
														number</strong></label><input class="form-control" type="tel"
													id="phoneNumber" pattern="[0-9]{10}"
													name="phoneNumber"
													placeholder="Enter your phone number" 
													value="${principal.admin.phoneNumber}"/>
											</div>
										</div>
									</div>
									<div class="d-flex justify-content-xl-end mb-3">
										<button class="btn btn-primary" type="submit">
											Save&nbsp;</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" role="dialog" tabindex="-1" id="passwordModal"
			aria-labelledby="passwordModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="passwordModalLabel">Change
							Password</h5>
						<button class="btn-close" aria-label="Close"
							data-bs-dismiss="modal" type="button"></button>
					</div>
					<form id="passwordForm" class="ms-1">
						<div class="modal-body" style="padding-bottom: 0">
							<div class="mb-3 row ms-2">
								<label class="form-label col-form-label col-sm-4"
									for="oldPassword">Old Password</label>
								<div class="col-lg-7 col-sm-7">
									<input class="form-control" type="password" id="oldPassword"
										placeholder="Enter old password" />
								</div>
							</div>
							<div class="mb-3 row ms-2">
								<label class="form-label col-form-label col-sm-4"
									for="newPassword">New Password</label>
								<div class="col col-sm-7">
									<input class="form-control" type="password" id="newPassword"
										placeholder="Enter new password" />
								</div>
							</div>
							<div class="mb-3 row ms-2">
								<label class="form-label col-form-label col-sm-4"
									for="confirmPassword">Confirm Password</label>
								<div class="col col-sm-7">
									<input class="form-control" type="password"
										id="confirmPassword"
										placeholder="Repeat new password" />
								</div>
							</div>
						</div>
						<div
							class="modal-footer d-flex justify-content-end pt-0 pe-4 pb-3"
							style="border-style: none">
							<button class="btn btn-primary" form="passwordForm"
								id="updateButton" type="submit">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<a class="border rounded d-inline scroll-to-top" href="#page-top"><i
		class="fas fa-angle-up"></i></a><script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script src="/assets/js/adminprofile.js"></script>
</body>
</html>

