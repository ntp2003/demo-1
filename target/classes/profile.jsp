<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<div class="container py-5">
		<div class="d-flex justify-content-center flex-wrap gap-5">
			<div>
				<div>
					<div class="card mt-3" style="width: 306.325px;">
						<ul
							class="list-group list-group-flush">
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
										<img id="profilePic"
											src="https://bootdey.com/img/Content/avatar/avatar7.png"
											alt="Admin"
											style="width: 80%; height: 100%; object-fit: cover; border-radius: 100%; overflow: hidden; padding: 0px; margin: 0px;"
											width="120" height="150">
									</div>
									<input type="file" id="fileInput" style="display: none;">
									<div class="mt-3">
										<h4>User</h4>
										<button class="btn btn-primary">Change Picture</button>
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
									<h2 class="text-center mb-4"
										style="text-align: center; font-weight: bold;">Account
										Information</h2>
									<form>
										<div class="row d-flex flex-wrap">
											<div class="col">
												<label class="form-label"
													for="firstName">First Name</label><input
													class="form-control"
													type="text" id="firstName" required="">
											</div>
											<div class="col">
												<label class="form-label"
													for="lastName">Last Name</label><input
													class="form-control"
													type="text" id="lastName" required="">
											</div>
										</div>
										<div class="mt-3">
											<label class="form-label"
												for="address">Address</label>
											<div class="d-flex flex-wrap"
												style="display: flex; align-items: center; gap: 10px;">
												<select class="form-select form-select-sm mb-3" id="city"
													aria-label=".form-select-sm" required=""
													style="max-width: 170px; min-width: 170px;">
													<option value="" selected="">Chọn tỉnh thành</option>
												</select><select class="form-select form-select-sm mb-3"
													id="district" aria-label=".form-select-sm" required=""
													style="max-width: 170px; min-width: 170px;">
													<option value="" selected="">Chọn quận huyện</option>
												</select><select class="form-select form-select-sm mb-3"
													id="ward" aria-label=".form-select-sm" required=""
													style="max-width: 170px; min-width: 170px;">
													<option value="" selected="">Chọn phường xã</option>
												</select>
											</div>
											<script
												src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
											<script>
		      var citis = document.getElementById("city");
		      var districts = document.getElementById("district");
		      var wards = document.getElementById("ward");
		      var Parameter = {
		        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
		        method: "GET",
		        responseType: "application/json",
		      };
		      var promise = axios(Parameter);
		      promise.then(function (result) {
		        renderCity(result.data);
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
										</div>
										<div class="mb-3">
											<label style="margin: 10px 0px" for="address">Details
												address</label> <input type="text" class="form-control" id="address"
												placeholder="1234 Main St" />
										</div>
										<div class="mb-3" style="margin: 10px 0px">
											<label class="form-label"
												for="phone">Phone</label><input
												class="form-control"
												type="tel" id="phone" pattern="[0-9]{10}">
										</div>
										<div class="mb-3">
											<label class="form-label"
												for="dob">Date of Birth</label><input
												class="form-control"
												id="dob" type="date">
										</div>
										<div class="mb-3 text-left"
											style="text-align: right; margin-top: 30px">
											<a class="btn btn-primary" role="button" href="#">Save</a>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center">
							<div class="card mb-3">
								<div class="card-body">
									<h2 class="text-center card-title font-weight-bold">Login
										Information</h2>
									<form>
										<div class="mb-3">
											<label class="form-label"
												for="email">Email : <span>phatnguyen@gmail.com</span></label>
										</div>
										<div class="mb-3">
											<label class="form-label"
												for="password">Password : <span>***************
											</span></label>
										</div>
										<div class="mb-3" style="margin-top: 10px">
											<button class="btn btn-primary" type="button"
												data-bs-toggle="modal" data-bs-target="#passwordModal">Change
												Password</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="d-flex">
							<div class="card mb-3">
								<div class="card-body">
									<h2 class="card-title"
										style="text-align: center; font-weight: bold;">Electronic
										Wallet</h2>
									<div id="walletStatus" style="text-align: left;"></div>
									<div id="walletBalance" style="text-align: left;"></div>
									<div style="text-align: right;">
										<button id="linkButton" type="button" data-bs-toggle="modal"
											data-bs-target="#linkWalletModal"
											style="background-color: #42dca3; color: white; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; border-radius: 4px; padding: 10px 24px; border: none;">Link
											Wallet</button>
										<button id="unlinkButton" type="button"
											style="background-color: #3B71CA; color: white; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; border-radius: 4px; padding: 10px 24px; border: none;">Unlink
											Wallet</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade show" role="dialog" tabindex="-1"
		style="padding: 120px 0;" id="linkWalletModal"
		aria-labelledby="linkWalletModalLabel" aria-hidden="true">
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
								<input class="form-control"
									type="text" id="walletID" required="">
							</div>
						</div>
						<div class="row mb-3">
							<label class="col-sm-4 col-form-label" style="margin-left: 30px;"
								for="verificationCodes">Verification Codes</label>
							<div class="col-sm-7">
								<input class="form-control" type="text"
									id="verificationCodes" required="">
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
	<div class="modal fade" role="dialog" tabindex="-1"
		style="padding: 100px 0;" id="passwordModal"
		aria-labelledby="passwordModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="border-radius: 15px;">
				<div class="modal-header">
					<h5 class="modal-title" id="passwordModalLabel"
						style="text-transform: uppercase;">Change Password</h5>
					<button class="btn-close" aria-label="Close"
						data-bs-dismiss="modal" type="button"></button>
				</div>
				<form id="changePasswordForm">
					<div class="modal-body">
						<div class="row form-group" style="padding: 10px;">
							<label class="col-sm-5" style="margin-left: 20px;"
								for="oldPassword">Old Password</label>
							<div class="col-sm-6">
								<input
									class="form-control"
									type="password" id="oldPassword" maxlength="15" minlength="5"
									required="">
							</div>
						</div>
						<div class="row form-group" style="padding: 10px;">
							<label class="col-sm-5" style="margin-left: 20px;"
								for="newPassword">New Password</label>
							<div class="col-sm-6">
								<input
									class="form-control"
									type="password" id="newPassword" maxlength="15" minlength="5"
									required="">
							</div>
						</div>
						<div class="row form-group" style="padding: 10px;">
							<label class="col-sm-5" style="margin-left: 20px;"
								for="confirmPassword">Confirm Password</label>
							<div class="col-sm-6">
								<input
									class="form-control"
									type="password" id="confirmPassword" maxlength="15" minlength="5"
									required="">
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

	<script type="text/javascript">
        function loadFile(event) {
            var reader = new FileReader();
            reader.onload = function(){
                var output = document.getElementById('profilePic');
                output.src = reader.result;
            };
            reader.readAsDataURL(event.target.files[0]);
        }
        document.querySelector('.btn-primary').addEventListener('click', function() {
            document.getElementById('fileInput').click();
        });
        document.getElementById('fileInput').addEventListener('change', loadFile);
    </script>
	<script type="text/javascript">
        function togglePasswordChange() {
            var passwordFields = document.getElementById('passwordFields');
            if (document.getElementById('changePassword').checked) {
                passwordFields.style.display = 'block';
            } else {
                passwordFields.style.display = 'none';
            }
        }
    </script>
	<script type="text/javascript">
        document.getElementById('changePassword').addEventListener('click', function() {
            var myModal = new bootstrap.Modal(document.getElementById('passwordModal'), {});
            myModal.show();
        });
        document.getElementById('passwordModal').addEventListener('shown.bs.modal', function () {
            document.getElementById('oldPassword').focus();
        });
    
        function validatePasswords() {
            var newPassword = document.getElementById('newPassword').value;
            var confirmPassword = document.getElementById('confirmPassword').value;
    
            if (newPassword !== confirmPassword) {
                alert('Passwords do not match.');
                return false;
            }
            return true;
        }
    </script>
	<script>
        var isLinked = false;
        var balance = 0;
        var walletStatus = document.getElementById('walletStatus');
        var walletBalance = document.getElementById('walletBalance');
        var linkButton = document.getElementById('linkButton');
        var unlinkButton = document.getElementById('unlinkButton');
    
        function updateDisplay() {
            if (isLinked) {
                walletStatus.textContent = 'Status: Linked';
                walletBalance.textContent = 'Balance: ' + balance;
                linkButton.style.display = 'none';
                unlinkButton.style.display = 'inline';
            } else {
                walletStatus.textContent = 'Status: Not Linked';
                walletBalance.textContent = '';
                linkButton.style.display = 'inline';
                unlinkButton.style.display = 'none';
            }
        }

        var database = {
            walletID: '123',
            verificationCodes: 'abc',
            balance: 100
        };
    
        var walletIDInput = document.getElementById('walletID');
        var verificationCodesInput = document.getElementById('verificationCodes');
        var balanceInput = document.getElementById('balance');

        var linkWalletForm = document.getElementById('linkWalletForm');
        linkWalletForm.addEventListener('submit', function(event) {
            event.preventDefault();
            if (walletIDInput.value === database.walletID && verificationCodesInput.value === database.verificationCodes && parseFloat(balanceInput.value) === database.balance) {
                isLinked = true;
                balance = parseFloat(balanceInput.value);
                updateDisplay();
 
                var linkWalletModal = bootstrap.Modal.getInstance(document.getElementById('linkWalletModal'));
                linkWalletModal.hide();
            } else {
   
                alert('The entered information does not match our records. Please try again.');
            }
        });
    
        unlinkButton.addEventListener('click', function() {

            var confirmUnlink = confirm("Are you sure you want to unlink your wallet?");
            if (confirmUnlink) {
               
                isLinked = false;
                balance = 0;
                updateDisplay();
            }
        });
    
        updateDisplay();
	    </script>
	<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
	    </script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js">
	    </script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>