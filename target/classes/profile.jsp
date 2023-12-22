<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Profile</title>
<link rel="stylesheet" href="/assets/css/filterTemplate.css">
<link />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/assets/css/user-profile.css">
</head>

<body style="background-color: rgb(231, 238, 243);">
	<sec:authentication var="info" property="principal.customerAccount" />
	<div class="container py-5">
		<div class="d-flex justify-content-center flex-wrap gap-5">
			<div>
				<div>
					<div class="card mt-3" style="width: 306.325px;">
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><a class="nav-link"
								href="Profile"><div
										style="display: flex; align-items: center;">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em"
											height="1em" viewbox="0 0 20 20" fill="none"
											style="font-size: 16px; margin-right: 10px;">
											<path fill-rule="evenodd"
												d="M10 9C11.6569 9 13 7.65685 13 6C13 4.34315 11.6569 3 10 3C8.34315 3 7 4.34315 7 6C7 7.65685 8.34315 9 10 9ZM3 18C3 14.134 6.13401 11 10 11C13.866 11 17 14.134 17 18H3Z"
												fill="currentColor"></path></svg>
										<span>Account Information</span>
									</div></a></li>
							<li class="list-group-item"><a class="nav-link"
								href="OrderHistory"><div
										style="display: flex; align-items: center;">
										<svg class="bi bi-cart-fill"
											xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
											fill="currentColor" viewbox="0 0 16 16"
											style="margin-right: 10px;">
											<path
												d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path></svg>
										<span>Purchase History</span>
									</div></a></li>
							<li class="list-group-item"><a class="nav-link"
								href="feedback.html"><div
										style="display: flex; align-items: center;">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em"
											height="1em" fill="currentColor" viewbox="0 0 16 16"
											style="margin-right: 10px;">
											<path d="M0 0h24v24H0z" fill="none"></path>
											<path
												d="M20 2H4c-1.1 0-1.99.9-1.99 2L2 22l4-4h14c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2zm-7 12h-2v-2h2v2zm0-4h-2V6h2v4z"></path></svg>
										<span>Feedback</span>
									</div></a></li>
							<li class="list-group-item"><a class="nav-link"
								href="/customer/logout"><div
										style="display: flex; align-items: center;">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em"
											height="1em" viewbox="0 0 24 24" fill="none"
											style="margin-right: 10px;">
											<path
												d="M8.51428 20H4.51428C3.40971 20 2.51428 19.1046 2.51428 18V6C2.51428 4.89543 3.40971 4 4.51428 4H8.51428V6H4.51428V18H8.51428V20Z"
												fill="currentColor"></path>
											<path
												d="M13.8418 17.385L15.262 15.9768L11.3428 12.0242L20.4857 12.0242C21.038 12.0242 21.4857 11.5765 21.4857 11.0242C21.4857 10.4719 21.038 10.0242 20.4857 10.0242L11.3236 10.0242L15.304 6.0774L13.8958 4.6572L7.5049 10.9941L13.8418 17.385Z"
												fill="currentColor"></path></svg>
										<span>Logout</span>
									</div></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="d-flex justify-content-center flex-wrap gap-5">
				<div class="d-flex">
					<div>
						<div class="card" style="width: 241.325px;">
							<div class="card-body"
								style="padding: 16px; margin: -7px; height: 266.4px; width: 259.325px;">
								<div class="text-center d-flex flex-column align-items-center"
									style="height: 230.4px; width: 224.325px;">
									<div
										style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden;">
										<img id="profilePic" src='${info.avatar}'
											onerror="this.onerror=null;this.src='https://bootdey.com/img/Content/avatar/avatar7.png';"
											style="width: 80%; height: 100%; object-fit: cover; border-radius: 100%; overflow: hidden; padding: 0px; margin: 0px;"
											width="120" height="150">
									</div>
									<input type="file" id="fileInput" accept="image/*" style="display: none;">
									<div class="mt-3">
										<h4>User</h4>
										<button id="update-avatar" class="btn btn-primary">Change
											Picture</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="d-flex">
					<div>
						<div>
							<div class="card mb-3">
								<div class="card-body">
									<h2 class="text-center mb-4" style="text-align: center;">Account
										Information</h2>
									<form id="account-info-form">
										<div class="row d-flex flex-wrap">
											<div class="col">
												<label class="form-label" for="firstName">First Name</label><input
													class="form-control" type="text" id="firstName"
													value="${info.firstName}" required="">
											</div>
											<div class="col">
												<label class="form-label" for="lastName">Last Name</label><input
													class="form-control" type="text" id="lastName"
													value="${info.lastName}" required="">
											</div>
										</div>
										<div class="mt-3">
											<label class="form-label" for="address">Address</label>
											<div class="d-flex flex-wrap"
												style="display: flex; align-items: center; gap: 10px;">
												<select class="form-select form-select-sm mb-3" id="city"
													aria-label=".form-select-sm"
													style="max-width: 170px; min-width: 170px;">
													<option value="" selected="">Chọn tỉnh thành</option>
												</select><select class="form-select form-select-sm mb-3"
													id="district" aria-label=".form-select-sm"
													style="max-width: 170px; min-width: 170px;">
													<option value="" selected="">Chọn quận huyện</option>
												</select><select class="form-select form-select-sm mb-3" id="ward"
													aria-label=".form-select-sm"
													style="max-width: 170px; min-width: 170px;">
													<option value="" selected="">Chọn phường xã</option>
												</select>
											</div>
											<script
												src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
										</div>
										<div class="mb-3">
											<label style="margin: 10px 0px" for="address-detail">Details
												address</label> <input type="text" class="form-control"
												id="address-detail" placeholder="1234 Main St" />
										</div>
										<script>
		      var citis = document.getElementById("city");
		      var districts = document.getElementById("district");
		      var wards = document.getElementById("ward");
		      let value = JSON.parse(`${info.address}`);
		      var Parameter = {
		        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
		        method: "GET",
		        responseType: "application/json",
		      };
		      var promise = axios(Parameter);
		      promise.then(function (result) {
		        	renderCity(result.data);
			      $("#city").val(value.city);
			      citis.onchange();
			      $("#district").val(value.district);
			      district.onchange();
			      $("#ward").val(value.ward);
			      $("#address-detail").val(value.detail); 
		      });
		
		      function renderCity(data) {
		        for (const x of data) {
		          citis.options[citis.options.length] = new Option(x.Name, x.Id);
		        }
		        citis.onchange = function () {
		          district.length = 1;
		          ward.length = 1;
		          if (this.value != "") {
		            const result = data.filter((n) => n.Id === this.value);
		
		            for (const k of result[0].Districts) {
		              district.options[district.options.length] = new Option(
		                k.Name,
		                k.Id
		              );
		            }
		          }
		        };
		        district.onchange = function () {
		          ward.length = 1;
		          const dataCity = data.filter((n) => n.Id === citis.value);
		          if (this.value != "") {
		            const dataWards = dataCity[0].Districts.filter(
		              (n) => n.Id === this.value
		            )[0].Wards;
		
		            for (const w of dataWards) {
		              wards.options[wards.options.length] = new Option(w.Name, w.Id);
		            }
		          }
		        };
		      }
		      
		  </script>
										<div class="mb-3" style="margin: 10px 0px">
											<label class="form-label" for="phoneNumber">Phone
												number</label><input class="form-control"
												value="${info.phoneNumber}" type="tel" id="phoneNumber"
												pattern="[0-9]{10}">
										</div>
										<div class="mb-3">
											<label class="form-label" for="dob">Date of Birth</label><input
												class="form-control" value="${info.birthDate}" id="dob"
												type="date">
										</div>
										<div class="mb-3 text-left"
											style="text-align: right; margin-top: 30px">
											<button class="btn btn-primary" type="submit">Save</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center">
							<div class="card mb-3">
								<div class="card-body">
									<h2 class="text-center card-title">Login Information</h2>
									<form>
										<div class="mb-3">
											<label class="form-label" for="email">Email : <span>${info.email}</span></label>
										</div>
										<div class="mb-3">
											<label class="form-label" for="password">Password : <span>***************
											</span></label>
										</div>
										<div class="mb-3" style="margin-top: 10px">
											<button class="btn btn-primary" type="button"
												data-bs-toggle="modal" data-bs-target="#changePasswordModal">Change
												Password</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="d-flex">
							<div class="card mb-3">
								<div class="card-body">
									<h2 class="card-title" style="text-align: center;">Electronic
										Wallet</h2>
									<c:choose>
										<c:when test="${empty info.electronicWallet}">
											<div id="walletStatus" style="text-align: left;">Status:
												Not Linked</div>
											<div style="text-align: right;">
												<button id="linkButton" class="btn btn-primary" data-bs-toggle="modal"
													data-bs-target="#linkWalletModal">Link
													Wallet</button>
											</div>
										</c:when>
										<c:otherwise>
											<div id="walletStatus" style="text-align: left;">Status:
												Linked</div>
											<div id="walletBalance" style="text-align: left;">${info.electronicWallet.balance}</div>
											<div style="text-align: right;">
												<button class="btn btn-primary" id="unlink-btn">Unlink
													Wallet</button>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" role="dialog" tabindex="-1"
		style="padding: 120px 0;" id="linkWalletModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="linkWalletModalLabel">Link Wallet</h5>
					<button class="btn-close" aria-label="Close"
						data-bs-dismiss="modal" type="button"></button>
				</div>

				<form id="linkWalletForm">
					<div class="modal-body">
						<div class="row mb-3">
							<label class="col-sm-4 col-form-label" style="margin-left: 30px;"
								for="walletID">Wallet ID</label>
							<div class="col-sm-7">
								<input class="form-control" type="text" id="walletID"
								onkeypress="return isNumber(event)"
										onpaste="return false;"	required="">
							</div>
						</div>
						<div class="row mb-3">
							<label class="col-sm-4 col-form-label" style="margin-left: 30px;"
								for="verificationCodes">Verification Codes</label>
							<div class="col-sm-7">
								<input class="form-control" type="text" id="verificationCodes"
									required="">
							</div>
						</div>
					</div>
					<div class="modal-footer d-flex justify-content-end">
						<button class="btn btn-primary me-2" type="submit">Link
							Wallet</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" role="dialog" tabindex="-1" id="changePasswordModal">
			<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content" style="border-radius: 15px;">
				<div class="modal-header">
					<h5 class="modal-title" id="passwordModalLabel"
						style="text-transform: uppercase;">Change Password</h5>
					<button class="btn-close" aria-label="Close"
						data-bs-dismiss="modal" type="button"></button>
				</div>
				<form id="change-password-form">
					<div class="modal-body">
						<div class="row form-group" style="padding: 10px;">
							<label class="col-sm-5" style="margin-left: 20px;"
								for="oldPassword">Old Password</label>
							<div class="col-sm-6">
								<input class="form-control" type="password" name="oldPassword"
									id="oldPassword">
							</div>
						</div>
						<div class="row form-group" style="padding: 10px;">
							<label class="col-sm-5" style="margin-left: 20px;"
								for="newPassword">New Password</label>
							<div class="col-sm-6">
								<input class="form-control" type="password" name="newPassword"
									id="newPassword">
							</div>
						</div>
						<div class="row form-group" style="padding: 10px;">
							<label class="col-sm-5" style="margin-left: 20px;"
								for="confirmPassword">Confirm Password</label>
							<div class="col-sm-6">
								<input class="form-control" type="password"
									name="confirmPassword" id="confirmPassword">
							</div>
						</div>
					</div>
					<div class="modal-footer d-flex justify-content-end">
						<button class="btn btn-primary me-2" type="submit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	 <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script src="/assets/js/notify.js"></script>
	<script src="/assets/js/customerprofile.js"></script>
</body>
</html>